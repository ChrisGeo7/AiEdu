package com.shellhacks.genedubackend.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    public String sendRequest(String url, HttpMethod method, Map<String, String> queryParams,
                                     String requestBody, Map<String, String> headers) throws IOException {

        HttpClient httpClient = HttpClients.createDefault();

        HttpRequestBase request = null;
        switch (method) {
            case GET:
                request = new HttpGet(url);
                break;
            case POST:
                HttpPost postRequest = new HttpPost(url);
                if (requestBody != null) {
                    StringEntity requestEntity = new StringEntity(requestBody);
                    postRequest.setEntity(requestEntity);
                }
                request = postRequest;
                break;
            case PUT:
                HttpPut putRequest = new HttpPut(url);
                if (requestBody != null) {
                    StringEntity requestEntity = new StringEntity(requestBody);
                    putRequest.setEntity(requestEntity);
                }
                request = putRequest;
                break;
            case DELETE:
                request = new HttpDelete(url);
                break;
        }

        if (queryParams != null && !queryParams.isEmpty()) {
            StringBuilder queryString = new StringBuilder("?");
            for (Map.Entry<String, String> entry : queryParams.entrySet()) {
                queryString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            String finalQueryString = queryString.toString().replaceAll("&$", "");
            request.setURI(request.getURI().resolve(finalQueryString));
        }

        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        HttpResponse response = httpClient.execute(request);
        HttpEntity responseEntity = response.getEntity();
        String responseString = EntityUtils.toString(responseEntity);

        httpClient.getConnectionManager().shutdown();

        return responseString;

    }

    public enum HttpMethod {
        GET, POST, PUT, DELETE
    }

    public Map<String, String> getHeadersJson(String token) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + token);
        headers.put("Content-Type", "application/json");

        return headers;
    }

}

