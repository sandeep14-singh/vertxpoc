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
package com.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

/**
 * @author vagrant
 * @version $ 7/1/20
 */
@Controller("/demo")
public class DemoController {
    @Get("/testGet")
    public HttpResponse<String> testGet() {
        return HttpResponse.ok("Test succeeded on GET");
    }

    @Post("/testPost")
    public HttpResponse<String> testPost(String body) {
        return HttpResponse.ok("Test succeeded on POST. Received : " + body);
    }
}
