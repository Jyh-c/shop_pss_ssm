package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_user
 * @author 
 */
@Data
public class SysUser implements Serializable {
    private Integer id;

    private Integer roleId;

    private String userName;

    private String loginAccount;

    private String password;

    private String tel;

    private String wxAccount;

    private String idNo;

    private String address;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}