package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import com.exception.GenericException;

/**
 * 
 * @author KRISHNA
 *
 */
public class DBUtil {

	private static final Logger LOGGER = Logger.getLogger(DBUtil.class);

	private static final String DRIVER_CLASS_NAME = "org.apache.derby.jdbc.EmbeddedDriver";

	private static final String URL = "jdbc:derby:knowledge-store;create=true";

	private static final String USERNAME = "KRISHNA";

	private static final String PASSWORD = "RADHA";

	static {
		try {
			Class.forName(DRIVER_CLASS_NAME);
		} catch (ClassNotFoundException e) {
			LOGGER.error("Error while driver loading: ", e);
		}
	}

	/**
	 * method to get database Connection
	 * 
	 * @return new connection
	 */
	public static Connection getConnection() {

		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			LOGGER.error("Error while getting connection: ", e);
			throw new GenericException("DBUtill", "cant connect to sql derby", e);
		}
	}

	/**
	 * method to close database resources
	 *
	 */
	public static void close(ResultSet rs, Statement st, Connection con) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				LOGGER.error("Error while closing  resultset : ", e);
			}
		if (st != null)
			try {
				st.close();
			} catch (SQLException e) {
				LOGGER.error("Error while closing statement : ", e);
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error while closing Connection : ", e);
			}

	}

}
