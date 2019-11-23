package com.example.springweb.mapper;

import com.example.springweb.dao.AppStruct;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppMapper {
    @Select("select * from appinfo ")
    @Results({
            @Result(property = "id", column = "app_id"),
            @Result(property = "name", column = "app_name"),
            @Result(property = "company",column = "app_company"),
            @Result(property = "status",column = "app_status"),
            @Result(property = "level",column = "app_level"),
            @Result(property = "kinds",column = "app_kinds"),
            @Result(property = "items",column = "app_items"),
            @Result(property = "items1",column = "app_items1"),
            @Result(property = "comment",column = "app_comment"),
            @Result(property = "namelegel",column = "app_namelegel"),
            @Result(property = "kindcorrect",column = "app_kindcorrect")
    })
    List<AppStruct> findAll();

    @Insert("insert into appinfo(app_id,app_name,app_company,app_status,app_kinds,app_level,app_items,app_comment) values(#{id},#{name},#{company},#{status},#{kinds},#{level},#{items},#{comment})")
    void insert(AppStruct helloapp);


    @Select("select * from appinfo where app_id = #{id}")
    @Results({
            @Result(property = "id",column = "app_id"),
            @Result(property = "name",column = "app_name"),
            @Result(property = "company",column = "app_company"),
            @Result(property = "status",column = "app_status"),
            @Result(property = "level",column = "app_level"),
            @Result(property = "kinds",column = "app_kinds"),
            @Result(property = "items",column = "app_items"),
            @Result(property = "items1",column = "app_items1"),
            @Result(property = "comment",column = "app_comment"),
            @Result(property = "namelegel",column = "app_namelegel"),
            @Result(property = "kindcorrect",column = "app_kindcorrect")
    })
    AppStruct getOne(String id);

    @Update("update appinfo set app_name = #{name}, app_company = #{company}, app_status = #{status},app_level=#{level},app_items=#{items},app_kinds=#{kinds},app_comment=#{comment} where app_id = #{id}")
    void updateByID(AppStruct app);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from appinfo where app_id = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值

    //更新状态
    @Update("update appinfo set app_status = #{sta} where app_id = #{id}")
    void updateStatusByID(@Param("id")String id, @Param("sta") String status);

    @Update("update appinfo set app_comment = #{sta} where app_id = #{id}")
    void updateCommentByID(@Param("id")String id, @Param("sta") String comments);

    @Update("update appinfo set app_level = #{sta} where app_id = #{id}")
    void updateLevelByID(@Param("id")String id, @Param("sta") String comments);

    @Update("update appinfo set app_namelegel = #{sta} where app_id = #{id}")
    void updateNamelegelByID(@Param("id")String id, @Param("sta") String namelegel);

    @Update("update appinfo set app_kindcorrect = #{sta} where app_id = #{id}")
    void updateKindcorrectByID(@Param("id")String id, @Param("sta") String kindcorrect);

}

