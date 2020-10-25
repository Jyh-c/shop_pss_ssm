package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_role
 * @author 
 */
@Data
public class SysRole implements Serializable {
    private Integer id;

    private String roleName;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}