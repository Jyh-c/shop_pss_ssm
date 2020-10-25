package com.pss.demo.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sys_role_menu_map
 * @author 
 */
@Data
public class SysRoleMenuMap implements Serializable {
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    private Date createTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}