package com.ittopdogs.certicoach;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> info = new HashMap<>();
        info.put("version", "1.0.0");
        info.put("timestamp", System.currentTimeMillis());
        info.put("developer", "Ikke!");
        info.put("feature-flags", List.of("123", "1", "100", "ABC"));
        builder.withDetail("customInfo", info);
    }
}
