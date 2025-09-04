## 数据库读写分离和分库分表

### 创建3个数据库实例
```shell
docker pull mysql:8.0
docker run -p 3306:3306 --name mysql8.0 \
-v /root/work/mysql/log:/var/log/mysql \
-v /root/work/mysql/data:/var/lib/mysql \
-v /root/work/mysql/conf:/etc/mysql/conf.d \
-e MYSQL_ROOT_PASSWORD=test1 \
-d mysql:8.0
```
my.cnf
```shell
# 主配置文件
[mysqld]
## 同一局域网内注意要唯一
server-id=100
# 开启二进制日志功能，可以随便取（关键）
log-bin=mysql-bin
# 关闭ssl认证
require_secure_transport=OFF

# 从节点配置文件

[mysqld]
## 设置server_id,注意要唯一
server-id=101

[mysqld]
## 设置server_id,注意要唯一
server-id=102
```

```shell
# 进入主库容器内
docker exec -it mysql8.0 /bin/bash
# 登录mysql
mysql -uroot -ptest1
# 创建用户
CREATE USER 'slave1'@'%' IDENTIFIED BY 'test1';
# 查看用户
SELECT Host, User FROM mysql.user;
# 授权
GRANT REPLICATION SLAVE ON *.* TO 'slave1'@'%';
# 修改用户身份验证插件为mysql_native_password
ALTER USER 'slave1'@'%' IDENTIFIED WITH mysql_native_password BY 'test1';

# 查看主库状态
SHOW MASTER STATUS;
+------------------+----------+--------------+------------------+-------------------+
| File             | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |
+------------------+----------+--------------+------------------+-------------------+
| mysql-bin.000001 |     1252 |              |                  |                   |
+------------------+----------+--------------+------------------+-------------------+
1 row in set (0.00 sec)
```

```shell
# 进入从库容器内，登录mysql
stop slave;
change master to master_host='192.168.50.41', master_user='slave1', master_password='test1', master_port=3306, master_log_file='mysql-bin.000001', master_log_pos=1252, master_connect_retry=30;
start slave;
# 查看同步状态
show slave status\G

# 主库中查看状态
show processlist;
```
- master_port：Master的端口号，指的是容器的端口号,如果mster 端口为3306 可以省略不写 
- master_user：用于数据同步的用户 
- master_password：用于同步的用户的密码 
- master_log_file：指定 Slave 从哪个日志文件开始复制数据，即上文中提到的 File 字段的值 
- master_log_pos：从哪个 Position 开始读，即上文中提到的 Position 字段的值 
- master_connect_retry：如果连接失败，重试的时间间隔，单位是秒，默认是60秒 
- 在Slave 中的mysql终端执行show slave status \G;用于查看主从同步状态