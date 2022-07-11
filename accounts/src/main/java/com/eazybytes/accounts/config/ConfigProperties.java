package com.eazybytes.accounts.config;

import lombok.Data;
 import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Component
@Data
public class ConfigProperties implements Serializable {

    @Value("${management.endpoints.web.exposure.include}")
    private String endpoint;

    @Value("${accounts.msg}")
    private String msg;

    @Value("${accounts.build-version}")
    private String buildVersion;

//    private Map<String, String> mailDetails;
//
//    private List<String> activeBranches;
}
