package com.mall.ivy.mapper;

import com.mall.ivy.model.GoodsCategory;
import com.mall.ivy.model.GoodsCategoryExample;
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

public interface GoodsCategoryMapper {
    @SelectProvider(type=GoodsCategorySqlProvider.class, method="countByExample")
    long countByExample(GoodsCategoryExample example);

    @DeleteProvider(type=GoodsCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(GoodsCategoryExample example);

    @Delete({
        "delete from goods_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into goods_category (id, father_id, ",
        "category_name, del, ",
        "gmt_create, gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{fatherId,jdbcType=INTEGER}, ",
        "#{categoryName,jdbcType=VARCHAR}, #{del,jdbcType=TINYINT}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(GoodsCategory record);

    @InsertProvider(type=GoodsCategorySqlProvider.class, method="insertSelective")
    int insertSelective(GoodsCategory record);

    @SelectProvider(type=GoodsCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="father_id", property="fatherId", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<GoodsCategory> selectByExample(GoodsCategoryExample example);

    @Select({
        "select",
        "id, father_id, category_name, del, gmt_create, gmt_modify",
        "from goods_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="father_id", property="fatherId", jdbcType=JdbcType.INTEGER),
        @Result(column="category_name", property="categoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    GoodsCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=GoodsCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    @UpdateProvider(type=GoodsCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    @UpdateProvider(type=GoodsCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(GoodsCategory record);

    @Update({
        "update goods_category",
        "set father_id = #{fatherId,jdbcType=INTEGER},",
          "category_name = #{categoryName,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GoodsCategory record);

    @Select("select * from goods_category")
    List<GoodsCategory> selectAll();

    @Update("update goods_category set del = 1 where id = #{id}")
    int deleteById(@Param("id") Integer id);
}