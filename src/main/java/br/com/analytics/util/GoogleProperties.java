package br.com.analytics.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class GoogleProperties {

	private static Properties prop;
	private static InputStreamReader input;

	static {

		try {
			prop = new Properties();
			input = new InputStreamReader(GoogleProperties.class.getResourceAsStream("/google.properties"));
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String getClientId() {
		return prop.getProperty("clientId");
	}

	public static final String getClientSecret() {
		return prop.getProperty("clientSecret");
	}
}
