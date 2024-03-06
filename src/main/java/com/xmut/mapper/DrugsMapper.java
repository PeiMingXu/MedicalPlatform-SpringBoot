package com.xmut.mapper;

import com.xmut.pojo.Durgs;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author
 * @date: 2023/12/20
 **/

public interface DrugsMapper {

    //通过id查询
    @Select("select * from durgs where d_id=#{d_id}")
    public Durgs findById(Integer id);


    //带条件分页
    public List<Durgs> findPages(Durgs drugs);

    //分页查询
    public List<Durgs> findPage();

    //查询全部药材
    @Select("<script>\n" +
            "        select * from durgs\n" +
            "        <where>\n" +
            "            <if test=\"d_name!=null and d_name.trim()!=''\">\n" +
            "                and d_name like concat('%',#{d_name},'%')\n" +
            "            </if>\n" +
            "            <if test=\"d_indication!=null and d_indication.trim()!=''\">\n" +
            "                and d_indication like concat('%',#{d_indication},'%')\n" +
            "            </if>\n" +
            "            <if test=\"d_use!=null and d_use.trim()!=''\">\n" +
            "                and d_use like concat('%',#{d_use},'%')\n" +
            "            </if>\n" +
            "        </where>\n" +
            "        order by d_id\n" +
            "    </script>")
    public List<Durgs> findByAll(Durgs drugs);


    //查找药材名
    @Select("select * from durgs where d_name=#{d_name}")
    @Results(id = "phoneResult",value = {
            @Result(property ="d_name",column ="d_name"),
    })
    public String findByD_name(@Param("d_name") String d_name);


    //添加药材
    public Integer addDrugs(Durgs drugs);


    //药材信息修改
    public Integer editDrugs(Durgs drugs);

    //药材下架
    public Integer borrowDrugs(Durgs drugs);

    public List<Durgs> allfindDurgs();






}
