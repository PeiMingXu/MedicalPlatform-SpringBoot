package com.xmut.mapper;

import com.github.pagehelper.Page;
import com.xmut.pojo.Durgs;
import com.xmut.pojo.Prescript;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @date: 2023/5/19
 **/
public interface PrescriptMapper {


    //带条件分页 查询全部药单
    public List<Prescript> findPages(Prescript prescript);

    //查询全部药方
    @Select("select * from prescript")
    @Results({
            @Result(id = true,property = "id",column = "p_id"),
            @Result(property ="user",column="p_user",
            one = @One(select = "com.xmut.mapper.UserMapper.findById")
            ),
            @Result(property ="user1",column ="dc_id",
            one = @One(select = "com.xmut.mapper.UserMapper.findById")
            ),
            @Result(property ="user2",column ="dr_id",
                    one = @One(select = "com.xmut.mapper.UserMapper.findById")
            ),
    })
    public Page<Prescript> findByAll(Prescript prescript);

    //查询全部药方
    @Select("select * from prescript where p_status=2")
    @Results({
            @Result(id = true,property = "id",column = "p_id"),
            @Result(property ="user",column="p_user",
                    one = @One(select = "com.xmut.mapper.UserMapper.findById")
            )
    })
    public List<Prescript> findByAll1(Prescript prescript);
}
