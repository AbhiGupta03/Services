package com.restApp.religiousIndia.utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TempleIdGenrator implements IdentifierGenerator {
	private static Logger logger = Logger.getLogger(TempleIdGenrator.class);

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();

		String prefix = "Temple";

		try {

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select count(Temple_Id) as Id from religious_india.ri_temple_temp");

			if (rs.next()) {
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();

				return generatedId;
			}
		} catch (Exception e) {
			logger.error("Error in temple Id generation");
		}

		return null;
	}
}
