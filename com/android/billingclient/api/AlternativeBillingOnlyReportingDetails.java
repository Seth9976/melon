package com.android.billingclient.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import org.json.JSONObject;

@zzg
@KeepForSdk
public final class AlternativeBillingOnlyReportingDetails {
    private final String externalTransactionToken;

    public AlternativeBillingOnlyReportingDetails(String s) {
        this.externalTransactionToken = new JSONObject(s).optString("externalTransactionToken");
    }

    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}

