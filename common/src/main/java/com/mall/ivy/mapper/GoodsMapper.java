package com.mall.ivy.mapper;

import com.mall.ivy.model.Goods;
import com.mall.ivy.model.GoodsExample;
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

public interface GoodsMapper {
    @SelectProvider(type=GoodsSqlProvider.class, method="countByExample")
    long countByExample(GoodsExample example);

    @DeleteProvider(type=GoodsSqlProvider.class, method="deleteByExample")
    int deleteByExample(GoodsExample example);

    @Delete({
        "delete from goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into goods (id, name, ",
        "stock, price, details, ",
        "main_img, sub_img, ",
        "del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{stock,jdbcType=INTEGER}, #{price,jdbcType=DOUBLE}, #{details,jdbcType=VARCHAR}, ",
        "#{mainImg,jdbcType=VARCHAR}, #{subImg,jdbcType=VARCHAR}, ",
        "#{del,jdbcType=TINYINT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Goods record);

    @InsertProvider(type=GoodsSqlProvider.class, method="insertSelective")
    int insertSelective(Goods record);

    @SelectProvider(type=GoodsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_img", property="mainImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_img", property="subImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Goods> selectByExample(GoodsExample example);

    @Select({
        "select",
        "id, name, stock, price, details, main_img, sub_img, del, gmt_create, gmt_modify",
        "from goods",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_img", property="mainImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_img", property="subImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Goods selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Goods record);

    @Update({
        "update goods",
        "set name = #{name,jdbcType=VARCHAR},",
          "stock = #{stock,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DOUBLE},",
          "details = #{details,jdbcType=VARCHAR},",
          "main_img = #{mainImg,jdbcType=VARCHAR},",
          "sub_img = #{subImg,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Goods record);

    @Select("select * from goods")
    List<Goods> selectAllGoods();

    @Update("update goods set del = 1 where id = #{id}")
    int deleteById(@Param("id") Integer id);
}