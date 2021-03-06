package com.redhat.oskutka.rhlp.servlet;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.text.ParseException;

import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class CookPoint
 */
@WebServlet("/Cookpoint")
public class CookPoint extends RestaurantGetter {
	private static final long serialVersionUID = 5185240436706683195L;

	protected String getUrl() {
		return "http://cookpoint.cz";
	}

	protected String getPreUrl() {
		return "http://cookpoint.cz/lang/1";
	}

	@Override
	protected String getFreshMenuHTML() throws IOException, ParseException {
		// the site's default language is English, so we first need to switch the page to Czech and only then get the menu
		CookieManager cm = new CookieManager();
		CookieHandler.setDefault(cm);
		getConnection(getPreUrl()).getContent();
		return super.getFreshMenuHTML();
	}

}
