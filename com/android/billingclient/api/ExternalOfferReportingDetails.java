package com.android.billingclient.api;

import org.json.JSONObject;

@zzh
public final class ExternalOfferReportingDetails {
    private final String externalTransactionToken;

    public ExternalOfferReportingDetails(String s) {
        this.externalTransactionToken = new JSONObject(s).optString("externalTransactionToken");
    }

    public String getExternalTransactionToken() {
        return this.externalTransactionToken;
    }
}

