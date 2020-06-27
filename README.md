# ivy_mall
ivy_mall商城系统

## 项目介绍

​	ivy_mall电商系统是一个作品展示项目。由于之前与公司签订了保密协议的关系，协议不允许把公司项目的源代码上传至个人Github或以其他形式对外展示。因此开发ivy_mall电商系统，用于向用人单位展示个人的编码风格、业务设计水平以及技术应用水平。



## 需求收集
![需求收集.png](https://i.loli.net/2020/06/27/JHjWlmpetva3LMV.png)


## 系统概述

![系统概述.png](https://i.loli.net/2020/06/27/e92YrLqRT71dNJW.png)

## 数据建模

![数据建模.png](https://i.loli.net/2020/06/27/AJPWajsRL6G2vzr.png)



## 系统设计

```
ivy_mall商城系统
├── 管理后台
|    ├── 注册登录
|    ├── 文件上传
|    ├── 分类管理
|    └── 系统设置
├── 商城
```



## 技术栈选取

| 技术                 | 名称                | 官网地址                                       |
| -------------------- | ------------------- | ---------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot         |
| MyBatis              | 持久层框架          | http://www.mybatis.org/mybatis-3/zh/index.html |
| PageHelper           | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper |
| Hibernator-Validator | 验证框架            | http://hibernate.org/validator                 |
| Redis                | 缓存框架            | https://redis.io/                              |
| Apache Shiro + JWT   | 安全框架            | http://shiro.apache.org/                       |
| Maven                | 项目构建管理        | http://maven.apache.org/                       |
| Log4J                | 日志组件            | http://logging.apache.org/log4j/1.2/           |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid               |
| Lombok               | 简化对象封装工具    | https://github.com/rzwitserloot/lombok         |
| MySQL                | 数据库              |                                                |



## 数据字典

[管理员](Banner - 轮播图表)



###  Admin - 管理员表

| Field      | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                                  |
| ---------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | ---------------------------------------- |
| id         | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 管理人员编号                             |
| name       | varchar(20)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 管理人员姓名                             |
| account    | varchar(20)         | utf8_general_ci | NO   | UNI  | (NULL)  |                | select,insert,update,references | 管理人员登录账号                         |
| tel        | varchar(20)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 管理人员手机号                           |
| passwords  | varchar(20)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 管理人员密码                             |
| role       | tinyint(4) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 管理人员角色：0-商品管理员，1-订单管理员 |
| sex        | tinyint(4) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 性别：0-女，1-男，2-跨性别者             |
| email      | varchar(50)         | utf8_general_ci | NO   | UNI  | (NULL)  |                | select,insert,update,references | 邮箱                                     |
| del        | tinyint(4) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 是否删除：0-未删除；1已删除              |
| gmt_create | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                          |
| gmt_modify | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                          |

**索引**

| Table | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ----- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| admin | 0          | PRIMARY  | 1            | id          | A         | 1           | (NULL)   | (NULL) |      | BTREE      |         |               |
| admin | 0          | u_accunt | 1            | account     | A         | 1           | (NULL)   | (NULL) |      | BTREE      |         |               |
| admin | 0          | u_email  | 1            | email       | A         | 1           | (NULL)   | (NULL) |      | BTREE      |         |               |





###  Banner - 轮播图表

| Field      | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                              |
| ---------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | ------------------------------------ |
| id         | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 轮播图编号                           |
| img        | varchar(250)        | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 轮播图图片                           |
| url        | varchar(250)        | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 跳转链接，自定义协议goods://goods_id |
| del        | tinyint(1) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references |                                      |
| gmt_create | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                      |
| gmt_modify | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                      |

**索引**

| Table  | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ------ | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| banner | 0          | PRIMARY  | 1            | id          | A         | 1           | (NULL)   | (NULL) |      | BTREE      |         |               |





### Car - 购物车表

| Field       | Type                      | Collation | Null | Key  | Default | Extra          | Privileges                      | Comment                     |
| ----------- | ------------------------- | --------- | ---- | ---- | ------- | -------------- | ------------------------------- | --------------------------- |
| id          | int(11) unsigned zerofill | (NULL)    | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 购物车编号                  |
| good_id     | int(11) unsigned          | (NULL)    | NO   |      | (NULL)  |                | select,insert,update,references | 商品编号                    |
| user_id     | int(11) unsigned          | (NULL)    | NO   |      | (NULL)  |                | select,insert,update,references | 用户编号                    |
| amount      | int(11) unsigned          | (NULL)    | NO   |      | (NULL)  |                | select,insert,update,references | 商品数量                    |
| del         | tinyint(4) unsigned       | (NULL)    | NO   |      | 0       |                | select,insert,update,references | 是否删除：0-未删除；1已删除 |
| gmt_createt | datetime                  | (NULL)    | NO   |      | (NULL)  |                | select,insert,update,references |                             |
| gmt_modify  | datetime                  | (NULL)    | NO   |      | (NULL)  |                | select,insert,update,references |                             |

**索引**

| Table | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ----- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| car   | 0          | PRIMARY  | 1            | id          | A         | 0           | (NULL)   | (NULL) |      | BTREE      |         |               |





### Delivery - 快递信息表

| Field      | Type                      | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                        |
| ---------- | ------------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | ------------------------------ |
| id         | int(11) unsigned zerofill | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 收件地址编号                   |
| user_id    | int(11) unsigned          | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 用户编号                       |
| details    | varchar(255)              | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 详细地址                       |
| name       | varchar(20)               | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 收件人姓名                     |
| tel        | varchar(20)               | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 收件人手机号                   |
| del        | tinyint(4) unsigned       | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 是否已删除：0-未删除；1-已删除 |
| gmt_create | datetime                  | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                |
| gmt_modify | datetime                  | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                |

**索引**

| Table    | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| -------- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| delivery | 0          | PRIMARY  | 1            | id          | A         | 0           | (NULL)   | (NULL) |      | BTREE      |         |               |





### Evaluation - 评价表

| Field      | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment  |
| ---------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | -------- |
| id         | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 评论编号 |
| user_id    | int(11) unsigned    | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 用户编号 |
| goods_id   | int(11) unsigned    | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 商品编号 |
| content    | varchar(200)        | utf8_general_ci | YES  |      | (NULL)  |                | select,insert,update,references | 评价内容 |
| star       | tinyint(2) unsigned | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 多少颗星 |
| del        | tinyint(1) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references |          |
| gmt_create | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |          |
| gmt_modify | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |          |

**索引**

| Table      | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ---------- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| evaluation | 0          | PRIMARY  | 1            | id          | A         | 1           | (NULL)   | (NULL) |      | BTREE      |         |               |





### Goods - 商品表

| Field      | Type                 | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                     |
| ---------- | -------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | --------------------------- |
| id         | int(11) unsigned     | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 商品编号                    |
| name       | varchar(30)          | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 商品名称                    |
| stock      | int(11) unsigned     | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 商品库存                    |
| price      | double(7,2) unsigned | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 商品价格                    |
| details    | varchar(255)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 商品详情                    |
| main_img   | varchar(255)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 商品主图                    |
| sub_img    | varchar(255)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 商品子图                    |
| del        | tinyint(4) unsigned  | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 是否删除：0-未删除；1已删除 |
| gmt_create | datetime             | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                             |
| gmt_modify | datetime             | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                             |

**索引**

| Table | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ----- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| goods | 0          | PRIMARY  | 1            | id          | A         | 0           | (NULL)   | (NULL) |      | BTREE      |         |               |





### goods_category - 商品分类表

| Field         | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                     |
| ------------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | --------------------------- |
| id            | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 商品分类编号                |
| father_id     | int(11) unsigned    | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 父级分类编号                |
| category_name | varchar(11)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 分类名称                    |
| del           | tinyint(4) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 是否删除：0-未删除；1已删除 |
| gmt_create    | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                             |
| gmt_modify    | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                             |

**索引**

| Table          | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| -------------- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| goods_category | 0          | PRIMARY  | 1            | id          | A         | 12          | (NULL)   | (NULL) |      | BTREE      |         |               |





### message - 系统消息表

| Field      | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment          |
| ---------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | ---------------- |
| id         | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 系统消息编号     |
| receiver   | int(11) unsigned    | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 接收者的用户编号 |
| content    | varchar(450)        | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 消息的内容       |
| type       | tinyint(2) unsigned | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 消息的类型       |
| del        | tinyint(1) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references |                  |
| gmt_create | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                  |
| gmt_modify | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                  |

**索引**

| Table   | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ------- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| message | 0          | PRIMARY  | 1            | id          | A         | 0           | (NULL)   | (NULL) |      | BTREE      |         |               |





### orders - 订单表

| Field      | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                                                      |
| ---------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | ------------------------------------------------------------ |
| id         | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 订单编号                                                     |
| num        | varchar(50)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 订单号                                                       |
| user_id    | int(11) unsigned    | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 用户编号                                                     |
| goods_id   | int(11) unsigned    | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 商品编号                                                     |
| pay_status | tinyint(5) unsigned | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 订单状态：0-支付成功；1-待支付；2-支付失败；3-待收货；4-待评价 |
| del        | tinyint(4) unsigned | (NULL)          | NO   |      | 0       |                | select,insert,update,references | 订单是否删除：0-未删除；1-删除                               |
| pay_time   | datetime            | (NULL)          | YES  |      | (NULL)  |                | select,insert,update,references |                                                              |
| gmt_create | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                                              |
| gmt_modify | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                                                              |

**索引**

| Table  | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ------ | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| orders | 0          | PRIMARY  | 1            | id          | A         | 0           | (NULL)   | (NULL) |      | BTREE      |         |               |





### user - 用户表

| Field      | Type                | Collation       | Null | Key  | Default | Extra          | Privileges                      | Comment                      |
| ---------- | ------------------- | --------------- | ---- | ---- | ------- | -------------- | ------------------------------- | ---------------------------- |
| id         | int(11) unsigned    | (NULL)          | NO   | PRI  | (NULL)  | auto_increment | select,insert,update,references | 用户编号                     |
| account    | varchar(20)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 用户登录账号                 |
| password   | varchar(20)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 用户密码                     |
| nickname   | varchar(20)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 用户昵称                     |
| mobile     | varchar(11)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 用户手机号码                 |
| sex        | tinyint(3) unsigned | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 性别：0-女，1-男，2-跨性别者 |
| head_img   | varchar(255)        | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 用户头像                     |
| birthday   | date                | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 用户生日                     |
| email      | varchar(50)         | utf8_general_ci | NO   |      | (NULL)  |                | select,insert,update,references | 用户邮箱                     |
| del        | tinyint(4) unsigned | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references | 是否删除：0-未删除；1已删除  |
| gmt_create | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                              |
| gmt_modify | datetime            | (NULL)          | NO   |      | (NULL)  |                | select,insert,update,references |                              |

**索引**

| Table | Non unique | Key name | Seq in index | Column name | Collation | Cardinality | Sub part | Packed | Null | Index type | Comment | Index comment |
| ----- | ---------- | -------- | ------------ | ----------- | --------- | ----------- | -------- | ------ | ---- | ---------- | ------- | ------------- |
| user  | 0          | PRIMARY  | 1            | id          | A         | 0           | (NULL)   | (NULL) |      | BTREE      |         |               |





## 接口文档地址

https://www.showdoc.cc/889964849168937?page_id=0
