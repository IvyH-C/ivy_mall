package com.mall.ivy.mapper;

import com.mall.ivy.model.Car;
import com.mall.ivy.model.CarExample;
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

public interface CarMapper {
    @SelectProvider(type=CarSqlProvider.class, method="countByExample")
    long countByExample(CarExample example);

    @DeleteProvider(type=CarSqlProvider.class, method="deleteByExample")
    int deleteByExample(CarExample example);

    @Delete({
        "delete from car",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into car (id, good_id, ",
        "user_id, amount, ",
        "del, gmt_createt, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{goodId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER}, #{amount,jdbcType=INTEGER}, ",
        "#{del,jdbcType=TINYINT}, #{gmtCreatet,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Car record);

    @InsertProvider(type=CarSqlProvider.class, method="insertSelective")
    int insertSelective(Car record);

    @SelectProvider(type=CarSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_createt", property="gmtCreatet", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Car> selectByExample(CarExample example);

    @Select({
        "select",
        "id, good_id, user_id, amount, del, gmt_createt, gmt_modify",
        "from car",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="good_id", property="goodId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.INTEGER),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_createt", property="gmtCreatet", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Car selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    @UpdateProvider(type=CarSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Car record);

    @Update({
        "update car",
        "set good_id = #{goodId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "amount = #{amount,jdbcType=INTEGER},",
          "del = #{del,jdbcType=TINYINT},",
          "gmt_createt = #{gmtCreatet,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Car record);
}