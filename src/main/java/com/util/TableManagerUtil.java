package com.util;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Arrays;

import org.apache.log4j.Logger;

public class TableManagerUtil {

	private static final Logger LOGGER = Logger.getLogger(TableManagerUtil.class);

	public static final String NODE_TABLE = "create table node(nodeId int primary key NOT NULL,parentId int,label varchar(225),isLeaf boolean)";

	public static final String INFO_TABLE = "create table info(infoId int primary key NOT NULL ,nodeId int references node(nodeId),c_date varchar(10),label varchar(200),description varchar(300))";

	public static void excuteTable(String sqlForCreateTable) {
		try (Connection con = DBUtil.getConnection(); Statement st = con.createStatement();) {
			st.execute(sqlForCreateTable);
		} catch (Exception e) {
			LOGGER.error("Error while executing query : " + sqlForCreateTable, e);
		}

	}

	public static void initTable() {

		Arrays.asList(NODE_TABLE, INFO_TABLE).forEach(sql -> excuteTable(sql));

		/*
		 * List<String> str=Arrays.asList(NODE_TABLE,INFO_TABLE);
		 * 
		 * for (String cteateTablequery : str) {
		 * 
		 * excuteTable(cteateTablequery);
		 * 
		 * }
		 */
	}

}
