package com.xmut.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xmut.mapper.PrescriptMapper;

import com.xmut.pojo.Durgs;
import com.xmut.pojo.Prescript;
import com.xmut.service.PrescriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date: 2023/5/19
 **/
@Service
public class PrescriptServiceImpl implements PrescriptService {
    @Autowired
    private PrescriptMapper prescriptMapper;


    //多条件分页查询 查询全部药方
    @Override
    public PageInfo findPages(Prescript prescript, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Prescript> page=prescriptMapper.findPages(prescript);
        PageInfo pageInfo=new PageInfo(page);
        return pageInfo;
    }


    //查询全部药方
    // @Override
    // public PageResult findByAll(Prescript prescript, Integer pageNum, Integer pageSize) {
    //     //开启分页查询
    //     PageHelper.startPage(pageNum, pageSize);
    //     //调用mapper
    //     Page<Prescript> page = prescriptMapper.findByAll(prescript);
    //     return new PageResult(page.getTotal(), page.getResult());
    // }
}
