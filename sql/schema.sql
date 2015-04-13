
DROP TABLE UIP_CENTER;

CREATE TABLE UIP_CENTER (
		`id` bigint(20) NOT NULL AUTO_INCREMENT,
		`code` varchar(20) NOT NULL,
		`name` varchar(20),
		`chief` varchar(20),
		`address` varchar(80),
		`phone` varchar(20),
		PRIMARY KEY (`id`)
	);

--<ScriptOptions statementTerminator=";"/>

DROP TABLE UIP_REGION;

CREATE TABLE UIP_REGION (
		`id` bigint(20) NOT NULL AUTO_INCREMENT,
		`uip_center_id` bigint(20) NOT NULL,
		`code` varchar(20) NOT NULL,
		`region_code` varchar(20) NOT NULL,
		`name` varchar(20),
		`chief` varchar(20),
		`address` varchar(80),
		PRIMARY KEY (`id`)
	);

