package com.mall.ivy.mapper;

import com.mall.ivy.model.Banner;
import com.mall.ivy.model.BannerExample;
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

public interface BannerMapper {
    @SelectProvider(type=BannerSqlProvider.class, method="countByExample")
    long countByExample(BannerExample example);

    @DeleteProvider(type=BannerSqlProvider.class, method="deleteByExample")
    int deleteByExample(BannerExample example);

    @Delete({
        "delete from banner",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into banner (id, img, ",
        "url, del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{img,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Banner record);

    @InsertProvider(type=BannerSqlProvider.class, method="insertSelective")
    int insertSelective(Banner record);

    @SelectProvider(type=BannerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Banner> selectByExample(BannerExample example);

    @Select({
        "select",
        "id, img, url, del, gmt_create, gmt_modify",
        "from banner",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="img", property="img", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Banner selectByPrimaryKey(Integer id);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Banner record);

    @Update({
        "update banner",
        "set img = #{img,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Banner record);

    @Select("select * from Banner where del=0")
    List<Banner> selectAll();

    @Update("update banner set del = 1 where id =#{id]")
    int updateById(@Param("id") Integer id);

    @Select("select * from banner where img = #{img}")
    Banner selectByImg(@Param("img") String img);
}