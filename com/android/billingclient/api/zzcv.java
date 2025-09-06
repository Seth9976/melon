package com.android.billingclient.api;

import org.json.JSONObject;

public final class zzcv {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final PricingPhase zzf;

    public zzcv(JSONObject jSONObject0) {
        this.zza = jSONObject0.getString("productId");
        this.zzb = jSONObject0.optString("title");
        this.zzc = jSONObject0.optString("name");
        this.zzd = jSONObject0.optString("description");
        this.zze = jSONObject0.optString("basePlanId");
        JSONObject jSONObject1 = jSONObject0.optJSONObject("pricingPhase");
        this.zzf = jSONObject1 == null ? null : new PricingPhase(jSONObject1);
    }
}

