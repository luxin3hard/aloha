package com.mclx;

import com.mclx.annotation.*;

import java.util.Map;

@RestUrl(url = "172.17.32.114:8080")
@RestContentType(contentType = "application/json")
public interface RestService {
    @RestPost(path = "/myTest")
    Object invoke(@RestHeader Map<String, Object> header, @RestBody Object body);
}
