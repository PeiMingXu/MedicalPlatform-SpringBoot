package com.xmut.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @date: 2023/5/19
 **/
@Data
@AllArgsConstructor  //有参
@NoArgsConstructor  //无参
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
