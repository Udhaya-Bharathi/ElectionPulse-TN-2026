package com.project.electionpulse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistrictAliasService {

    private static final Map<String, String> DISTRICT_ALIASES = new HashMap<>();

    static {

        DISTRICT_ALIASES.put("trichy", "Tiruchirappalli");
        DISTRICT_ALIASES.put("tiruchi", "Tiruchirappalli");
        DISTRICT_ALIASES.put("tiruchi", "Tiruchirappalli");

        DISTRICT_ALIASES.put("madras", "Chennai");

        DISTRICT_ALIASES.put("kovai", "Coimbatore");

        DISTRICT_ALIASES.put("tanjore", "Thanjavur");

        DISTRICT_ALIASES.put("thoothukudi", "Thoothukudi");
        DISTRICT_ALIASES.put("tuticorin", "Thoothukudi");

        DISTRICT_ALIASES.put("kanyakumari", "Kanniyakumari");
    }

    public String normalize(String district) {

        if(district == null)
            return null;

        return DISTRICT_ALIASES.getOrDefault(
                district.trim().toLowerCase(),
                district
        );
    }

}
