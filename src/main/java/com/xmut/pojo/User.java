package com.xmut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author User
 * @date: 2024/1/7 16:29
 * 用于登陆回响给浏览器的数据
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable { //实现Serializable,适用于一些第三方框架
    private Integer id;
    private String name;
    private String password;
    private String phone;
    private String role;
    private Integer status;
    private String dc_image;
    private String dc_isonline;
}
