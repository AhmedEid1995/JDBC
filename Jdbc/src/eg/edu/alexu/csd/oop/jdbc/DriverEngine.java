package eg.edu.alexu.csd.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import java.util.Properties;

import java.util.logging.Logger;

public class DriverEngine implements java.sql.Driver {

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub

		return new ConnectionEngine(info);
	}

	@Override
	public int getMajorVersion() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public int getMinorVersion() {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		throw new java.lang.UnsupportedOperationException();
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub

		DriverPropertyInfo[] map = new DriverPropertyInfo[1];
		DriverPropertyInfo temp = new DriverPropertyInfo("path", info.getProperty("path"));
		map[0] = temp;
		return map;
	}

	@Override
	public boolean jdbcCompliant() {
		throw new java.lang.UnsupportedOperationException();
	}

}