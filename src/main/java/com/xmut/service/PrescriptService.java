package com.xmut.service;


import com.github.pagehelper.PageInfo;

import com.xmut.pojo.Prescript;


/**
 * @author
 * @date: 2023/5/19
 **/
public interface PrescriptService {


    //多条件分页查询 查询全部药方
    public PageInfo findPages(Prescript prescript, int pageIndex, int pageSize);


}
