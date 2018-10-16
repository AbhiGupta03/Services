package com.restApp.religiousIndia.utilities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ImageIdGenrator implements IdentifierGenerator {

	private static Logger logger = Logger.getLogger(ImageIdGenrator.class);

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		Connection connection = session.connection();
		String prefix = "Rel";
		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select count(Image_Id) as Id from religious_india.ri_image");

			if (rs.next()) {
				int id = rs.getInt(1) + 101;
				String generatedId = prefix + new Integer(id).toString();

				return generatedId;
			}
		} catch (SQLException e) {
			logger.error("Error in Image Id genration:");
		}

		return null;
	}

}
