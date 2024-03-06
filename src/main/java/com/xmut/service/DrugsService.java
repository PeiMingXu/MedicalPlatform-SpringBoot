package com.xmut.service;

import com.github.pagehelper.PageInfo;

import com.xmut.pojo.Durgs;

import java.util.List;

/**
 * @author
 * @date: 2023/12/20
 **/
public interface DrugsService {

    //通过id查询
    public Durgs findById(Integer id);

    //多条件分页查询
    public PageInfo findPages(Durgs drugs, int pageIndex, int pageSize);

    //普通分页查询
    public PageInfo findPage(int pageIndex,int pageSize);

    //查询全部药材
    public List<Durgs> findByAll(Durgs drugs);

    //查找药材名
    public String findDrugs(String d_name);

    //添加药材
    public boolean addDrugs(Durgs drugs);

    //药材编辑
    public Integer editDrugs(Durgs drugs);

    //药材下架
    public Integer borrowDrugs(Durgs drugs);

    List<Durgs> allfindDurgs();

}
