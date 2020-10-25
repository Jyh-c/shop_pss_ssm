package com.pss.demo.controller;

import com.github.pagehelper.PageInfo;
import com.pss.demo.model.SysUser;
import com.pss.demo.response.ResponseEnum;
import com.pss.demo.response.ResponseResult;
import com.pss.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author JYH
 * @version 1.0
 * @date 2020/10/21 11:05
 */
@RestController
public class SysUserController {

    @PostMapping("/login.do")
    public ModelAndView login(String loginAccount, String password){
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = sysUserService.login(loginAccount, password);
        if(sysUser == null || sysUser.getLoginAccount() == null || "".equals(sysUser.getLoginAccount())){
            mv.addObject("failure","alert('登录失败，请检查账号，密码！！！');");
            mv.setViewName("/login.jsp");
        }else{
            SimpleDateFormat sdf = new SimpleDateFormat("HH时mm分");
            mv.addObject("time",sdf.format(new Date()));
            mv.addObject("userName",sysUser.getUserName());
            mv.addObject("role",sysUser.getRoleId());
            mv.setViewName("/index.jsp");
        }
        return mv;
    }

    @GetMapping("/exit.do")
    public ModelAndView exit(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/login.jsp");
        return mv;
    }

    @PostMapping("/user/all.do")
    public ResponseResult<PageInfo<SysUser>> findAll(String keyword, Integer pageNum, Integer pageSize){
        return new ResponseResult<>(ResponseEnum.SUCCESS,sysUserService.queryAll(keyword,pageNum,pageSize));
    }

    @GetMapping("/user/find-id.do")
    public ModelAndView findById(Integer id){
        ModelAndView mv = new ModelAndView();
        SysUser sysUser = sysUserService.queryById(id);
        mv.addObject("user",sysUser);
        mv.setViewName("/view/user/user_modify.jsp");
        return mv;
    }

    @PostMapping("/user/add.do")
    public ModelAndView insert(String user_name,Integer role_id,String login_account,String password, String tel,String wx_account,String id_no,String address){
        ModelAndView mv = new ModelAndView();
        SysUser u = new SysUser();
        u.setUserName(user_name);
        u.setRoleId(role_id);
        u.setLoginAccount(login_account);
        u.setPassword(password);
        u.setTel(tel);
        u.setWxAccount(wx_account);
        u.setIdNo(id_no);
        u.setAddress(address);
        sysUserService.addUser(u);
        mv.setViewName("/view/user/user_list.jsp");
        return mv;
    }

    @GetMapping("/user/delete.do")
    public ModelAndView delete(Integer id){
        ModelAndView mv = new ModelAndView();
        sysUserService.delete(id);
        mv.setViewName("/view/user/user_list.jsp");
        return mv;
    }

    @PostMapping("/user/update.do")
    public ModelAndView update(Integer id,String user_name,Integer role_id,String login_account,String password, String tel,String wx_account,String id_no,String address){
        ModelAndView mv = new ModelAndView();
        SysUser u = new SysUser();
        u.setId(id);
        u.setUserName(user_name);
        u.setRoleId(role_id);
        u.setLoginAccount(login_account);
        u.setPassword(password);
        u.setTel(tel);
        u.setWxAccount(wx_account);
        u.setIdNo(id_no);
        u.setAddress(address);
        sysUserService.update(u);
        mv.setViewName("/view/user/user_list.jsp");
        return mv;
    }

    @Autowired
    private SysUserService sysUserService;

}
