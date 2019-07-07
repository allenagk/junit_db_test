CREATE TABLE `t_ksr_message_mng` (
  `msg_id` varchar(255) NOT NULL,
  `insurer_code` varchar(255) NOT NULL,
  `receive_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `data1` varchar(255) DEFAULT NULL,
  `data2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`msg_id`)
)