package com.vzw.prepaid.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

public class BaseDAO {
	
	static Logger log = Logger.getLogger(BaseDAO.class);
	
	public synchronized Connection getConnection(BasicDataSource dataSource) {
		Connection connection = null;
		
		try {
			connection = dataSource.getConnection();
		}
		catch (SQLException sqle) {
			log.error("Error while fetching connection from connection from connection pool. Error message is " + sqle.getMessage());
			
		}
		return connection;
	}
	
	public void closeConnection(Connection  conn) {
		try {
			if( conn != null && conn.getAutoCommit()) {
				conn.close();
				conn = null;
			}
		}
		catch ( SQLException err) {
			log.error("Error during closing DB connection!" + err);
		}
	}
	
	public void closeCallableStatement(CallableStatement cs ) {
		if( cs != null ) {
			try {
				cs.close();
				cs = null;
			}
			catch ( SQLException err) {
				log.error("Error during closing Callable Statement!" + err);
			}	
		}
	}
	
	public void close(CallableStatement cs, Connection conn) {
		closeCallableStatement(cs);
		closeConnection(conn);
	}
	
	public void close(PreparedStatement cs, Connection conn) {
		closePreparedStatement(cs);
		closeConnection(conn);
	}
	
	public void closePreparedStatement(PreparedStatement cs ) {
		if( cs != null ) {
			try {
				cs.close();
				cs = null;
			}
			catch ( SQLException err) {
				log.error("Error during closing Prepared Statement!" + err);
			}	
		}
	}
	public SessionFactory getSessionFactory()
	{
		return HibernateUtil.getSessionFactory();
	}
}
