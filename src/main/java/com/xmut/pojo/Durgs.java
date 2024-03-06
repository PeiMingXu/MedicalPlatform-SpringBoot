package com.xmut.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor  //有参
@NoArgsConstructor  //无参
public class Durgs {

    private Integer d_id;  //药品id
    private String d_name; //药品名称
    private String d_indication; //适应症
    private String d_use; //用法用量
    private String d_picture;//图片
    private Integer d_status;//状态

}
