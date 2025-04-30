package com.stock.proxy;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import jakarta.servlet.http.HttpServletRequest;

@RestController()
public class ProxyController {
    public static final String BASE_REQUEST_PATH = "base";
    
    @Value("${api.key}")
    private String apiKey;

    @Value("${api.baseURL}")
    private String baseURL;

    private String getURI(HttpServletRequest request, @RequestParam Map<String, String> reqParam) {
        String requestURI = request.getRequestURI();
        requestURI = requestURI.replace("/" + BASE_REQUEST_PATH + "/", "");
        StringBuilder sb = new StringBuilder(requestURI);
        sb.append("?");
        for (Map.Entry<String, String> entry : reqParam.entrySet()) {
            if (entry.getKey().equals("token")) continue;
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        sb.append("token=" + apiKey);
        return sb.toString();
    }

    @GetMapping("/" + BASE_REQUEST_PATH + "/**")
    public String proxyRequest(HttpServletRequest request, @RequestParam Map<String, String> reqParam) {
        String requestUri = getURI(request, reqParam);
        
        RestClient restClient = RestClient.create();
        String result = restClient.get()
                .uri(baseURL + requestUri)
                .retrieve()
                .body(String.class);    
        return result; 
    }
}
