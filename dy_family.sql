-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2019-08-16 23:33:40
-- 服务器版本： 5.7.20-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dy_family`
--

-- --------------------------------------------------------

--
-- 表的结构 `advice`
--

CREATE TABLE `advice` (
  `a_id` int(11) NOT NULL,
  `u_id` varchar(11) DEFAULT NULL,
  `a_createtime` datetime DEFAULT NULL,
  `a_type` tinyint(4) DEFAULT NULL,
  `a_reid` int(11) DEFAULT NULL,
  `a_title` varchar(128) DEFAULT NULL,
  `a_detail` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `branch`
--

CREATE TABLE `branch` (
  `b_id` char(11) NOT NULL,
  `b_name` varchar(128) DEFAULT NULL,
  `b_detail` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE `manager` (
  `m_id` varchar(11) NOT NULL,
  `m_pass` varchar(32) DEFAULT NULL,
  `m_power` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`m_id`, `m_pass`, `m_power`) VALUES
('14011307', '8089bd9e7924542c9b4fdeef069a7798', 1);

-- --------------------------------------------------------

--
-- 表的结构 `notice`
--

CREATE TABLE `notice` (
  `n_id` int(11) NOT NULL,
  `n_type` int(11) DEFAULT NULL,
  `n_title` varchar(128) DEFAULT NULL,
  `n_subtitle` varchar(128) DEFAULT NULL,
  `n_read_time` int(11) DEFAULT NULL,
  `n_time` datetime DEFAULT NULL,
  `n_detail` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `payment`
--

CREATE TABLE `payment` (
  `pid` char(32) NOT NULL,
  `u_id` varchar(11) DEFAULT NULL,
  `p_time` datetime DEFAULT NULL,
  `p_count` float DEFAULT NULL,
  `p_comment` varchar(127) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `record`
--

CREATE TABLE `record` (
  `r_id` int(11) NOT NULL,
  `b_id` char(11) DEFAULT NULL,
  `r_date` datetime DEFAULT NULL,
  `r_unum` int(11) DEFAULT NULL,
  `r_arrnum` int(11) DEFAULT NULL,
  `r_theme` varchar(128) DEFAULT NULL,
  `r_place` varchar(64) DEFAULT NULL,
  `r_common` varchar(256) DEFAULT NULL,
  `r_detail` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `u_id` varchar(11) NOT NULL,
  `u_pass` varchar(32) DEFAULT NULL,
  `u_name` varchar(32) DEFAULT NULL,
  `u_sex` int(11) DEFAULT NULL,
  `u_birth` date DEFAULT NULL,
  `u_phone` char(11) DEFAULT NULL,
  `u_mail` varchar(32) DEFAULT NULL,
  `u_grade` int(11) DEFAULT NULL,
  `u_class` char(16) DEFAULT NULL,
  `b_id` char(11) DEFAULT NULL,
  `u_regist_time` datetime DEFAULT NULL,
  `u_cognition` varchar(512) DEFAULT NULL,
  `u_iscomp` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`u_id`, `u_pass`, `u_name`, `u_sex`, `u_birth`, `u_phone`, `u_mail`, `u_grade`, `u_class`, `b_id`, `u_regist_time`, `u_cognition`, `u_iscomp`) VALUES
('2017203133', 'e10adc3949ba59abbe56e057f20f883e', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- 表的结构 `user_notice`
--

CREATE TABLE `user_notice` (
  `u_id` char(11) NOT NULL,
  `n_id` int(11) NOT NULL,
  `un_isread` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advice`
--
ALTER TABLE `advice`
  ADD PRIMARY KEY (`a_id`) USING BTREE,
  ADD KEY `FK_ADVICE_REFERENCE_USER` (`u_id`) USING BTREE;

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`b_id`) USING BTREE;

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`m_id`) USING BTREE;

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`n_id`) USING BTREE;

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pid`) USING BTREE,
  ADD KEY `FK_PAYMENT_REFERENCE_USER` (`u_id`) USING BTREE;

--
-- Indexes for table `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`r_id`) USING BTREE,
  ADD KEY `FK_Reference_5` (`b_id`) USING BTREE;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`u_id`) USING BTREE,
  ADD KEY `FK_Reference_2` (`b_id`) USING BTREE;

--
-- Indexes for table `user_notice`
--
ALTER TABLE `user_notice`
  ADD PRIMARY KEY (`u_id`,`n_id`) USING BTREE,
  ADD KEY `FK_Reference_4` (`n_id`) USING BTREE;

--
-- 限制导出的表
--

--
-- 限制表 `advice`
--
ALTER TABLE `advice`
  ADD CONSTRAINT `FK_ADVICE_REFERENCE_USER` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`);

--
-- 限制表 `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK_PAYMENT_REFERENCE_USER` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`);

--
-- 限制表 `record`
--
ALTER TABLE `record`
  ADD CONSTRAINT `FK_Reference_5` FOREIGN KEY (`b_id`) REFERENCES `branch` (`b_id`);

--
-- 限制表 `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_Reference_2` FOREIGN KEY (`b_id`) REFERENCES `branch` (`b_id`);

--
-- 限制表 `user_notice`
--
ALTER TABLE `user_notice`
  ADD CONSTRAINT `FK_Reference_3` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`),
  ADD CONSTRAINT `FK_Reference_4` FOREIGN KEY (`n_id`) REFERENCES `notice` (`n_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
