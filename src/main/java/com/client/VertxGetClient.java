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

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpVersion;

/**
 * @author vagrant
 * @version $ 7/1/20
 */
public class VertxGetClient {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        HttpClientOptions options = new HttpClientOptions()
                .setProtocolVersion(HttpVersion.HTTP_2)
                .setSsl(true)
                .setTrustAll(true).setVerifyHost(false)
                .setUseAlpn(true)
                .setDefaultHost("localhost")
                .setDefaultPort(8443);
        HttpClient client = vertx.createHttpClient(options);

        // Going to send 2 GET requests
        client.request(HttpMethod.GET, "/demo/testGet", response -> {
            System.out.println("Received response with status code " + response.statusCode() + " " + response.version());
            response.bodyHandler(buffer -> System.out.println("Response : " + new String(buffer.getBytes())));
        }).end();

        client.request(HttpMethod.GET, "/demo/testGet", response -> {
            System.out.println("Received response with status code " + response.statusCode() + " " + response.version());
            response.bodyHandler(buffer -> System.out.println("Response : " + new String(buffer.getBytes())));
        }).end();
    }

}
