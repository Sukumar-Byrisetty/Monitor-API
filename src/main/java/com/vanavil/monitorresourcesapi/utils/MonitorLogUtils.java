package com.vanavil.monitorresourcesapi.utils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;

import javax.net.ssl.HttpsURLConnection;

public class MonitorLogUtils {

	@SuppressWarnings("deprecation")
	private void checkWebsite(String websiteUrl) {

		// private URLdetails obj;
		double responseTime = 0.0;
		int time;
		int id;
		boolean stop = false;
		int index = 0;

		int responseCode = -1;
		URL url;
		try {

			url = new URL(websiteUrl); // create url object for the given string
			long millisStart = Calendar.getInstance().getTimeInMillis();
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			if (websiteUrl.startsWith("https")) {
				connection = (HttpsURLConnection) url.openConnection();
			}

			((HttpURLConnection) connection).setRequestMethod("HEAD");
			connection.setConnectTimeout(50000);
			connection.connect();
			String responseMessage = connection.getResponseMessage();
			responseCode = connection.getResponseCode();
			System.out.println(websiteUrl + " is up. Response Code : " + responseMessage);
			connection.disconnect();
			long millisEnd = Calendar.getInstance().getTimeInMillis();
			responseTime = millisEnd - millisStart;
			System.out.println("Response Time : " + (millisEnd - millisStart));
			// index = Controller.getList().indexOf(obj);
			if (index != -1) {
				// Controller.getList().get(index).setStatus(responseMessage);
				// Controller.getList().get(index).setTime(TimeAndDate.getTime());
				// Controller.getList().get(index).setAcessTime("" + (responseTime));
				// Controller.getList().remove(index);
				// Controller.getList().add(index, obj);
				// DataBase.addLog(id, responseMessage);
				if (responseCode == HttpsURLConnection.HTTP_UNAVAILABLE) {
					// Mail mail = new Mail("example@gmail.com","password",obj.getEmail());
					System.out.println(websiteUrl + " website is down.Mail sent.");
				}
			}

		} catch (MalformedURLException e) {
			System.out.println("Invalid URL.");
			// Controller.getList().get(index).setStatus("Invalid URL.");
		} catch (UnknownHostException e) {
			System.out.println("Unknown Host");
			// Controller.getList().get(index).setStatus("Unknown Host");
		} catch (ConnectException e) {
			System.out.println("Connection TimeOut");
			// Controller.getList().get(index).setStatus("Connection Timeout");
		} catch (IllegalStateException ex) {
			System.err.println("Illegal state occured.");
		} catch (IOException e) {
			System.out.println("Internet Unavilable");
			// Controller.getList().get(index).setStatus("Internet Unavilable");
		}
	}
}
