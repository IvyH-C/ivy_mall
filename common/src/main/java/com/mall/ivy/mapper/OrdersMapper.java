package com.mall.ivy.mapper;

import com.mall.ivy.model.Orders;
import com.mall.ivy.model.OrdersExample;
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

public interface OrdersMapper {
    @SelectProvider(type=OrdersSqlProvider.class, method="countByExample")
    long countByExample(OrdersExample example);

    @DeleteProvider(type=OrdersSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrdersExample example);

    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into orders (id, num, ",
        "user_id, goods_id, ",
        "pay_status, del, ",
        "pay_time, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{num,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER}, #{goodsId,jdbcType=INTEGER}, ",
        "#{payStatus,jdbcType=TINYINT}, #{del,jdbcType=TINYINT}, ",
        "#{payTime,jdbcType=TIMESTAMP}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Orders record);

    @InsertProvider(type=OrdersSqlProvider.class, method="insertSelective")
    int insertSelective(Orders record);

    @SelectProvider(type=OrdersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="num", property="num", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Orders> selectByExample(OrdersExample example);

    @Select({
        "select",
        "id, num, user_id, goods_id, pay_status, del, pay_time, gmt_create, gmt_modify",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="num", property="num", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Orders selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Orders record);

    @Update({
        "update orders",
        "set num = #{num,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "goods_id = #{goodsId,jdbcType=INTEGER},",
          "pay_status = #{payStatus,jdbcType=TINYINT},",
          "del = #{del,jdbcType=TINYINT},",
          "pay_time = #{payTime,jdbcType=TIMESTAMP},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orders record);
}