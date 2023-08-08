/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80033 (8.0.33)
 Source Host           : localhost:3306
 Source Schema         : chouyv

 Target Server Type    : MySQL
 Target Server Version : 80033 (8.0.33)
 File Encoding         : 65001

 Date: 08/08/2023 15:35:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for money
-- ----------------------------
DROP TABLE IF EXISTS `money`;
CREATE TABLE `money`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT COMMENT '钱包主键',
    `uid`         bigint     NOT NULL COMMENT '用户(学生 跑腿 商家等)id',
    `cny`         bigint     NOT NULL DEFAULT 0 COMMENT '人民币余额',
    `deposit_cny` int        NOT NULL DEFAULT 0 COMMENT '人民币押金',
    `created_at`  datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户钱包表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for money_bill
-- ----------------------------
DROP TABLE IF EXISTS `money_bill`;
CREATE TABLE `money_bill`
(
    `id`         bigint     NOT NULL AUTO_INCREMENT COMMENT '账单主键',
    `from_id`    bigint     NOT NULL COMMENT '转出账户',
    `to_id`      bigint     NOT NULL COMMENT '转入账户',
    `money`      int        NOT NULL COMMENT '账单操作金额',
    `type`       tinyint    NOT NULL DEFAULT 0 COMMENT '转账类型 0-默认内部转账 1-充值(from_id = -1) 2-提现(to_id = -1)',
    `created_at` datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '账单表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`          bigint     NOT NULL AUTO_INCREMENT COMMENT '订单主键',
    `student_id`  bigint     NOT NULL COMMENT '学生外键',
    `run_id`      bigint     NULL     DEFAULT NULL COMMENT '学生外键',
    `shop_id`     bigint     NOT NULL COMMENT '商家外键',
    `total_price` int        NOT NULL COMMENT '商品总价',
    `status`      tinyint    NOT NULL DEFAULT 0 COMMENT '订单状态 0-备餐中 1-等待跑腿的取 2-配送中 3-商品已到达',
    `type`        tinyint    NOT NULL DEFAULT 0 COMMENT '订单的状态 0-堂食(用户取 食堂吃 不外带) 1-带走(打包, 需配送费) 2-找跑腿(run_id不可空)',
    `target_time` datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '预约时间',
    `created_at`  datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for order_shop_products_item
-- ----------------------------
DROP TABLE IF EXISTS `order_shop_products_item`;
CREATE TABLE `order_shop_products_item`
(
    `id`               bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '订单商品主键',
    `order_id`         bigint                                                        NOT NULL COMMENT '订单外键',
    `shop_products_id` bigint                                                        NOT NULL COMMENT '商品外键',
    `count`            tinyint                                                       NOT NULL DEFAULT 1 COMMENT '该商品的数量',
    `description`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '该商品的备注',
    `created_at`       datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`       datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`       tinyint(1)                                                    NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单商品表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`
(
    `id`         bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '商家主键',
    `username`   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商家登陆账号',
    `password`   varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商家登陆密码',
    `nickname`   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商家名称',
    `address`    varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商家地址',
    `phone`      varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商家联系电话',
    `created_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint(1)                                                    NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '商家表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shop_products
-- ----------------------------
DROP TABLE IF EXISTS `shop_products`;
CREATE TABLE `shop_products`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '商品主键',
    `shop_id`     bigint                                                        NOT NULL COMMENT '商品外键',
    `name`        varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名',
    `description` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '商品详细描述',
    `img_url`     varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL     DEFAULT NULL COMMENT '图片地址',
    `count`       int                                                           NOT NULL DEFAULT 0 COMMENT '剩余货量',
    `price`       int                                                           NOT NULL COMMENT '商品价格',
    `created_at`  datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at`  datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted`  tinyint(1)                                                    NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品信息表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for shopping_info
-- ----------------------------
DROP TABLE IF EXISTS `shopping_info`;
CREATE TABLE `shopping_info`
(
    `id`         bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '收货信息主键',
    `uid`        bigint                                                        NOT NULL COMMENT '用户主键',
    `name`       varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '收获姓名',
    `location`   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收货地址',
    `phone`      varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '联系电话',
    `created_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint(1)                                                    NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户的收货地址信息表'
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`
(
    `id`         bigint                                                        NOT NULL AUTO_INCREMENT COMMENT '学生主键',
    `username`   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生登陆账号',
    `password`   varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生登陆密码',
    `role`       tinyint                                                       NOT NULL DEFAULT 0 COMMENT '用户角色 0-学生(正常消费者) 1-消费者and跑腿',
    `created_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updated_at` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `is_deleted` tinyint(1)                                                    NOT NULL DEFAULT 0 COMMENT '逻辑删除 0-未删除 1-已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表'
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;
