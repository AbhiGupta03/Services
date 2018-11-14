package com.restApp.religiousIndia.utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class PoojaPackageIdGenrator implements IdentifierGenerator {
	private static Logger logger = Logger.getLogger(PoojaPackageIdGenrator.class);

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();

		String prefix = "PoojaPackage";

		try {

			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select count(POOJA_PACKAGE_CATEGORY_ID) as Id from religious_india.ri_pooja_package_types");

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
