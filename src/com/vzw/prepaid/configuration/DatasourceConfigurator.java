package com.vzw.prepaid.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

public class DatasourceConfigurator implements GenericConfigurator
{
	public static BasicDataSource ds = null;
	static Logger log = Logger.getLogger(DatasourceConfigurator.class);
	
	@Override
	public void init() {
		getOracleDataSource();
		
	}

	@Override
	public void configure() {
		init();
	}

	@Override
	public void destroy() {
		try
		{
			ds.close();
		}
		catch(SQLException sqle)
		{
			log.error("SQL Exception while trying to close the datasource. Exception message is ",sqle);
		}
		catch(Exception e)
		{
			log.error("Exception while trying to close the datasource. Exception message is ",e);
		}
	}
	
	public static DataSource getOracleDataSource()
	{
		ds = new BasicDataSource();
		ds.setUrl(PropertyConfigurator.props.getProperty("ORACLE_DB_URL"));
		ds.setUsername(PropertyConfigurator.props.getProperty("ORACLE_DB_USERNAME"));
		ds.setPassword(PropertyConfigurator.props.getProperty("ORACLE_DB_PASSWORD"));
		ds.setInitialSize(Integer.parseInt(PropertyConfigurator.props.getProperty("ORACLE_CONNECTION_POOL_SIZE")));
		log.debug("Data source configured successfully. "+ds.getInitialSize());
		return ds;
	}
}
