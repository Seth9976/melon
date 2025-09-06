package com.android.billingclient.api;

import org.json.JSONObject;

public final class zzct {
    private final String zza;
    private final String zzb;

    public zzct(JSONObject jSONObject0) {
        this.zza = jSONObject0.getString("rentalPeriod");
        String s = jSONObject0.optString("rentalExpirationPeriod");
        if(s.isEmpty()) {
            s = null;
        }
        this.zzb = s;
    }
}

