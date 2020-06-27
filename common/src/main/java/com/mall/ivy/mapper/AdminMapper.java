package com.mall.ivy.mapper;

import com.mall.ivy.model.Admin;
import com.mall.ivy.model.AdminExample;
import java.util.List;

import com.mall.ivy.model.GoodsExample;
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

public interface AdminMapper {
    @SelectProvider(type=AdminSqlProvider.class, method="countByExample")
    long countByExample(AdminExample example);

    @DeleteProvider(type=AdminSqlProvider.class, method="deleteByExample")
    int deleteByExample(AdminExample example);

    @Delete({
        "delete from admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin (id, name, ",
        "account, tel, passwords, ",
        "role, sex, email, ",
        "del, gmt_create, ",
        "gmt_modify)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{account,jdbcType=VARCHAR}, #{tel,jdbcType=VARCHAR}, #{passwords,jdbcType=VARCHAR}, ",
        "#{role,jdbcType=TINYINT}, #{sex,jdbcType=TINYINT}, #{email,jdbcType=VARCHAR}, ",
        "#{del,jdbcType=TINYINT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP})"
    })
    int insert(Admin record);

    @InsertProvider(type=AdminSqlProvider.class, method="insertSelective")
    int insertSelective(Admin record);

    @SelectProvider(type=AdminSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwords", property="passwords", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Admin> selectByExample(AdminExample example);

    @Select({
        "select",
        "id, name, account, tel, passwords, role, sex, email, del, gmt_create, gmt_modify",
        "from admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel", property="tel", jdbcType=JdbcType.VARCHAR),
        @Result(column="passwords", property="passwords", jdbcType=JdbcType.VARCHAR),
        @Result(column="role", property="role", jdbcType=JdbcType.TINYINT),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="del", property="del", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Admin selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update admin",
        "set name = #{name,jdbcType=VARCHAR},",
          "account = #{account,jdbcType=VARCHAR},",
          "tel = #{tel,jdbcType=VARCHAR},",
          "passwords = #{passwords,jdbcType=VARCHAR},",
          "role = #{role,jdbcType=TINYINT},",
          "sex = #{sex,jdbcType=TINYINT},",
          "email = #{email,jdbcType=VARCHAR},",
          "del = #{del,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);

    @Select("select * from admin where account=#{account} or email = #{email}")
    Admin selectByAccountOrEmail(@Param("account") String account, @Param("email") String email);

    @Update("update admin set del = 1, gmt_modify = now where id = #{id}")
    int deleteById(@Param("id") Integer id);
}