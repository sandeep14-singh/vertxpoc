/*
 * $
 *
 * Copyright (c) 2020  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
 */
package com.client;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.BytesContentProvider;
import org.eclipse.jetty.http2.client.HTTP2Client;
import org.eclipse.jetty.http2.client.http.HttpClientTransportOverHTTP2;
import org.eclipse.jetty.util.ssl.SslContextFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


/**
 * @author vagrant
 * @version $ 7/2/20
 */
public class JettyHighLevelPostClient {
    public static void main(String[] args) throws Exception {
        HTTP2Client http2Client = new HTTP2Client();
        SslContextFactory sslContextFactory = new SslContextFactory(true);
        HttpClient httpClient = new HttpClient(new HttpClientTransportOverHTTP2(http2Client), sslContextFactory);
        httpClient.start();

        // Going to send 2 POST requests. 2nd request will not be succeessful
        String input = "ron";
        ContentResponse response = httpClient.POST("https://localhost:8443/demo/testPost")
                .content(new BytesContentProvider(input.getBytes()), "text/plain")
                .send();
        System.out.println("Response : " + response.getContentAsString());

        String input2 = "alan";
        ContentResponse response2 = httpClient.POST("https://localhost:8443/demo/testPost")
                .content(new BytesContentProvider(input.getBytes()), "text/plain")
                .send();
        System.out.println("Response-2 : " + response2.getContentAsString());
    }
}
