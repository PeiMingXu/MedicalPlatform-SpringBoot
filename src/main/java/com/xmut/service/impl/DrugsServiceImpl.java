package com.xmut.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.xmut.mapper.DrugsMapper;
import com.xmut.pojo.Durgs;
import com.xmut.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @date: 2023/12/20
 **/
@Service
public class DrugsServiceImpl implements DrugsService {
    @Autowired
    private DrugsMapper drugsMapper;

    //通过id查询
    @Override
    public Durgs findById(Integer id) {
        return drugsMapper.findById(id);
    }
    //多条件分页查询
    @Override
    public PageInfo findPages(Durgs drugs, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Durgs> page=drugsMapper.findPages(drugs);
        PageInfo pageInfo=new PageInfo(page);
        return pageInfo;
    }

    //普通分页
    @Override
    public PageInfo findPage(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<Durgs> page=drugsMapper.findPage();
        PageInfo pageInfo= new PageInfo(page);
        return pageInfo;
    }

    //查询全部药材
   @Override
    public List<Durgs> findByAll(Durgs drugs) {
        return drugsMapper.findByAll(drugs);
    }
   //根据名字，查找药材
    @Override
    public String findDrugs(String d_name) {
        return drugsMapper.findByD_name(d_name);
    }

    //添加药材
    @Override
    public boolean addDrugs(Durgs drugs) {
        //新增加的药材，默认状态设置为1
        drugs.setD_status(1);
        int result = drugsMapper.addDrugs(drugs);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
   //修改药材
    @Override
    public Integer editDrugs(Durgs drugs) {
        return drugsMapper.editDrugs(drugs);
    }

    //药材下架
    @Override
    public Integer borrowDrugs(Durgs drugs) {
        return drugsMapper.borrowDrugs(drugs);
    }

    @Override
    public List<Durgs> allfindDurgs() {
        return drugsMapper.allfindDurgs();
    }
}
