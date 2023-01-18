CREATE DATABASE `myproject` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
CREATE TABLE `iddb` (
  `worker_id` varchar(45) NOT NULL,
  `worker_pw` varchar(45) NOT NULL,
  PRIMARY KEY (`worker_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `iohistory` (
  `sku_code` varchar(45) NOT NULL,
  `sku_name` varchar(45) NOT NULL,
  `sku_kind` varchar(45) NOT NULL,
  `ordernum` varchar(45) NOT NULL,
  `oder_kind` varchar(45) DEFAULT NULL,
  `work_date` varchar(45) DEFAULT NULL,
  `ex_num` int DEFAULT NULL,
  `realnum` int DEFAULT NULL,
  `worker_id` varchar(45) DEFAULT NULL,
  `complete` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ordernum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `listdb` (
  `sku_code` varchar(30) NOT NULL,
  `sku_name` varchar(45) NOT NULL,
  `sku_kind` varchar(45) NOT NULL,
  `sku_location` varchar(45) DEFAULT NULL,
  `sku_finalnum` int NOT NULL,
  `memo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`sku_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `locationdb` (
  `sku_location` varchar(45) NOT NULL,
  PRIMARY KEY (`sku_location`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `masterid` (
  `id` varchar(45) NOT NULL,
  `pw` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `productlist` (
  `sku_code` varchar(45) NOT NULL,
  `sku_name` varchar(45) NOT NULL,
  `sku_kind` varchar(45) NOT NULL,
  PRIMARY KEY (`sku_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `workerid` (
  `id` varchar(45) NOT NULL,
  `pw` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
