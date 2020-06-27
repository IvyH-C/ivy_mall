package com.mall.ivy.mapper;

import com.mall.ivy.model.Delivery;
import com.mall.ivy.model.DeliveryExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DeliveryMapper {
    @SelectProvider(type=DeliverySqlProvider.class, method="countByExample")
    long countByExample(DeliveryExample example);

    @DeleteProvider(type=DeliverySqlProvider.class, method="deleteByExample")
    int deleteByExample(DeliveryExample example);

    @Delete({
        "delete from delivery",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into delivery (id, user_id, ",
        "details, name, tel, ",
        "del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{details,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, ",
        "#{del,jdbcType=TINYINT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Delivery record);

    @InsertProvider(type=DeliverySqlProvider.class, method="insertSelective")
    int insertSelective(Delivery record);

    @SelectProvider(type=DeliverySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Delivery> selectByExample(DeliveryExample example);

    @Select({
        "select",
        "id, user_id, details, name, tel, del, gmt_create, gmt_modify",
        "from delivery",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Delivery selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DeliverySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Delivery record, @Param("example") DeliveryExample example);

    @UpdateProvider(type=DeliverySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Delivery record, @Param("example") DeliveryExample example);

    @UpdateProvider(type=DeliverySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Delivery record);

    @Update({
        "update delivery",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "details = #{details,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Delivery record);
}