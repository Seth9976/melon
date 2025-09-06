package com.android.billingclient.api;

import org.json.JSONObject;

@zzi
public final class BillingConfig {
    private final String countryCode;
    private final String jsonString;
    private final JSONObject parsedJson;

    public BillingConfig(String s) {
        this.jsonString = s;
        JSONObject jSONObject0 = new JSONObject(s);
        this.parsedJson = jSONObject0;
        this.countryCode = jSONObject0.optString("countryCode");
    }

    public String getCountryCode() {
        return this.countryCode;
    }
}

