package com.xmut.pojo;

/**
 * @author
 * @date: 2023/5/19
 **/
public class Prescript {
    private Integer id;
    //一对一映射
    private User user;
    private String p_symptom;
    private String p_drugs;
    //一对一映射
    private User user1;
    //一对一映射
    private User user2;
    private Integer p_status;
}
