/*说明：合并了所有的表格的创建，数据库命名为scu_java_21*/

drop database if exists scu_java_21;
create database scu_java_21;
use scu_java_21;

#user
/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : spring-boot-email

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/04/2020 13:37:53
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50)  NOT NULL,
  `nickname` varchar(50)  NOT NULL,
  `password` varchar(50)  NOT NULL,
  PRIMARY KEY (`id`)
) ;
SET FOREIGN_KEY_CHECKS = 1;
-- CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci

#verify

/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : spring-boot-email

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/04/2020 13:38:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for verify
-- ----------------------------
DROP TABLE IF EXISTS `verify`;
CREATE TABLE `verify`  (
  `email` varchar(50)  NOT NULL,
  `code` int(10) NOT NULL,
  PRIMARY KEY (`email`) USING BTREE
);

#City
drop table if exists City;
create table City
(
   name                 char(50),
   city_id             int not null AUTO_INCREMENT,
   province_id         int,
   primary key (city_id)
);
alter table City add constraint FK_Reference_8 foreign key (province_id)
     references Province (province_id) on delete restrict on update restrict;

#Country
drop table if exists Country;
create table Country
(
   country_id           int not null,
   name                 char(50),
   primary key (country_id)
);

#Distinction
drop table if exists Distinction;
create table Distinction
(
   distinct_id       int not null AUTO_INCREMENT,
   city_id              int,
   name                 char(50),
   primary key (distinct_id)
);

alter table Distinction add constraint FK_Reference_9 foreign key (city_id)
      references City (city_id) on delete restrict on update restrict;

#Hotel
drop table if exists Hotel;

create table Hotel
(
   hotel_id             int not null  AUTO_INCREMENT,
   distinct_id          int,
   name                 varchar(50),
   address              varchar(150),
   telephone            varchar(50),
   description          varchar(300),
   photo_address        varchar(300),
   grade                int,
   level                int,
   primary key (hotel_id)
);

alter table Hotel add constraint FK_Reference_10 foreign key (distinct_id)
      references Distinction (distinct_id) on delete restrict on update restrict;

#Province
drop table if exists Province;
create table Province
(
   province_id          int not null AUTO_INCREMENT,
   country_id           int,
   name                 char(50),
   primary key (province_id)
);

alter table Province add constraint FK_Reference_7 foreign key (country_id)
     references Country (country_id) on delete restrict on update restrict;

#Room
drop table if exists Room;
create table Room
(
   room_id              int not null AUTO_INCREMENT,
   wheather_avalible    bool,
   primary key (room_id)
);


#Standard
drop table if exists Standard;
create table Standard
(
   area                 float,
   standard_id          int not null,
   room_id              int,
   hotel_id             int,
   storey               int,
   weaher_hotwater      bool,
   weather_wifi         bool,
   roomphoto_url        char(100),
   bed                  char(50),
   room_number          int,
   weaher_cancel        bool,
   price                decimal,
   breakfast            int,
   equipment            char(50),
   primary key (standard_id)
);

alter table Standard add constraint FK_Reference_6 foreign key (hotel_id)
      references Hotel (hotel_id) on delete restrict on update restrict;

alter table Standard add constraint FK_Reference_6 foreign key (room_id)
      references Room (room_id) on delete restrict on update restrict;

#theOrder
drop table if exists theOrder;

create table theOrder
(
   order_id             int not null AUTO_INCREMENT,
   id                   int,
   standard_id          int,
   time                 date,
   total_price          decimal,
   dating_time          int,
   wheather_pay         bool,
   order_time           time,
   primary key (order_id)
);

alter table theOrder add constraint FK_Reference_4 foreign key (id)
      references User (id) on delete restrict on update restrict;
alter table theOrder add constraint FK_Reference_5 foreign key (standard_id)
      references Standard (standard_id) on delete restrict on update restrict;

#review
drop table if exists review;
create table review
(
   review_id            int not null AUTO_INCREMENT,
   order_id             int,
   content              char(255),
   primary key (review_id)
);
alter table review add constraint FK_Reference_11 foreign key (order_id)
      references theOrder (order_id) on delete restrict on update restrict;