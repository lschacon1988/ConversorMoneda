package com.LuisChacon.conversor.logic;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HttpRequest {
	private HttpClient httpClient ;
	private HttpGet request ;

	public HttpRequest(String url) {
		this.request = new HttpGet(url);
		this.httpClient = HttpClients.createDefault();
	}
	
	public String responseJsonString() {
		try {
			HttpResponse response = this.httpClient.execute(this.request);
			return EntityUtils.toString(response.getEntity());
			
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	public Double RateBaseEur(String responseBodyJsonString, String CodigoMoneda) {
		try {			

			JsonElement jsonResponse = JsonParser.parseString(responseBodyJsonString);
			JsonObject rates = jsonResponse.getAsJsonObject().getAsJsonObject("rates");

			Double eurToUsdRate = rates.get(CodigoMoneda).getAsDouble();
			return eurToUsdRate;

		} catch (Exception e) {
			e.getStackTrace();
			return null  ;

		}
	}

}
