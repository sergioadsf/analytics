package br.com.analytics.google.v3;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.analytics.Analytics;

import br.com.analytics.util.GoogleProperties;

public class Connection {

	private static String clientId = "";
	private static String clientSecret = "";

	private static HttpTransport httpTransport;

	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	private static final String APPLICATION_NAME = "analytics-teste";

	static {
		clientId = GoogleProperties.getClientId();
		clientSecret = GoogleProperties.getClientSecret();
	}

	private Connection() {
	}

	public static Analytics getAnalytics(String code) throws Exception {
		GoogleCredential credential = getConnection().initTransport().getCredential(code);
		Analytics analytics = new Analytics.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();

		return analytics;
	}

	public static GoogleTokenResponse getTokenResponse(String code) throws IOException, GeneralSecurityException {
		return getConnection().initTransport().configTokenResponse(code);
	}

	private GoogleTokenResponse configTokenResponse(String code) throws IOException {
		return new GoogleAuthorizationCodeTokenRequest(httpTransport, JSON_FACTORY, clientId, clientSecret, code,
				"postmessage").execute();
	}

	private GoogleCredential getCredential(String token) throws Exception {

		return new GoogleCredential.Builder().setJsonFactory(JSON_FACTORY).setTransport(httpTransport)
				.setClientSecrets(clientId, clientSecret).build()
				.setFromTokenResponse(JSON_FACTORY.fromString(token, GoogleTokenResponse.class));
	}

	private Connection initTransport() throws GeneralSecurityException, IOException {
		if (httpTransport == null) {
			httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		}

		return this;
	}

	private static Connection getConnection() {
		return new Connection();
	}

}
