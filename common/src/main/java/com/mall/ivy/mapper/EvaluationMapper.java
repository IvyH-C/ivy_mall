package com.mall.ivy.mapper;

import com.mall.ivy.dto.evaluation.EvaluationListDTO;
import com.mall.ivy.model.Evaluation;
import com.mall.ivy.model.EvaluationExample;
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

public interface EvaluationMapper {
    @SelectProvider(type=EvaluationSqlProvider.class, method="countByExample")
    long countByExample(EvaluationExample example);

    @DeleteProvider(type=EvaluationSqlProvider.class, method="deleteByExample")
    int deleteByExample(EvaluationExample example);

    @Delete({
        "delete from evaluation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into evaluation (id, user_id, ",
        "goods_id, content, ",
        "star, del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=INTEGER}, ",
        "#{goodsId,jdbcType=INTEGER}, #{content,jdbcType=VARCHAR}, ",
        "#{star,jdbcType=TINYINT}, #{del,jdbcType=BIT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Evaluation record);

    @InsertProvider(type=EvaluationSqlProvider.class, method="insertSelective")
    int insertSelective(Evaluation record);

    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="star", property="star", jdbcType=JdbcType.TINYINT),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Evaluation> selectByExample(EvaluationExample example);

    @Select({
        "select",
        "id, user_id, goods_id, content, star, del, gmt_create, gmt_modify",
        "from evaluation",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="star", property="star", jdbcType=JdbcType.TINYINT),
        @Result(column="del", property="del", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Evaluation selectByPrimaryKey(Integer id);

    @UpdateProvider(type=EvaluationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    @UpdateProvider(type=EvaluationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Evaluation record, @Param("example") EvaluationExample example);

    @UpdateProvider(type=EvaluationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Evaluation record);

    @Update({
        "update evaluation",
        "set user_id = #{userId,jdbcType=INTEGER},",
          "goods_id = #{goodsId,jdbcType=INTEGER},",
          "content = #{content,jdbcType=VARCHAR},",
          "star = #{star,jdbcType=TINYINT},",
          "del = #{del,jdbcType=BIT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Evaluation record);



    @SelectProvider(type = EvaluationSqlProvider.class, method = "selectEvaluation")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
            @Result(column="goods_id", property="goodsId", jdbcType=JdbcType.INTEGER),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="star", property="star", jdbcType=JdbcType.TINYINT),
            @Result(column="del", property="del", jdbcType=JdbcType.BIT),
            @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Evaluation> selectEvaluation(EvaluationListDTO dto);

    @Update("update evaluation set del =1 where id =#{id}")
    int deleteById(@Param("id") Integer id);
}