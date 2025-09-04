package com.kdf.shardingjdbc.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mysql.cj.log.Log;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

//@Data注解是lombok的注解，简化实体类编写，自动生成get/set以及toString等方法
// @Data
@TableName("t_goods")
public class Goods implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // @TableId(value = "gid", type = IdType.AUTO)
    private Long gid;
    private String gname;
    private Integer userId;
    private Integer gstatus;

    public Long getGid() {
        return gid;
    }

    public void setGid(Long gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGstatus() {
        return gstatus;
    }

    public void setGstatus(Integer gstatus) {
        this.gstatus = gstatus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", userId=" + userId +
                ", gstatus=" + gstatus +
                '}';
    }
}