package com.example.springweb.mapper;

import com.example.springweb.dao.AppStruct;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AppMapper {
    @Select("select * from apps ")
    @Results({
            @Result(property = "id", column = "app_id"),
            @Result(property = "name", column = "app_name"),
            @Result(property = "company",column = "app_company"),
            @Result(property = "status",column = "app_status")
    })
    List<AppStruct> findAll();

    @Insert("insert into apps(app_id,app_name,app_company,app_status) values(#{id},#{name},#{company},#{status})")
    void insert(AppStruct helloUser);


    @Select("select * from apps where app_id = #{id}")
    @Results({
            @Result(property = "id",column = "app_id"),
            @Result(property = "name",column = "app_name"),
            @Result(property = "company",column = "app_company"),
            @Result(property = "status",column = "app_status")
    })
    AppStruct getOne(String id);

    @Update("update apps set app_name = #{name}, app_company = #{company}, app_status = #{status} where app_id = #{id}")
    void updateByID(AppStruct app);//UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值

    @Delete("delete from apps where app_id = #{id}")
    void deleteByID(String id);//DELETE FROM 表名称 WHERE 列名称 = 值

    //更新状态
    @Update("update apps set app_status = #{sta} where app_id = #{id}")
    void updateStatusByID(@Param("id")String id, @Param("sta") int status);
}
