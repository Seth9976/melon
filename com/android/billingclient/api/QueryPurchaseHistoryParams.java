package com.android.billingclient.api;

public final class QueryPurchaseHistoryParams {
    public static class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        public Builder(zzdg zzdg0) {
        }

        public QueryPurchaseHistoryParams build() {
            if(this.zza == null) {
                throw new IllegalArgumentException("Product type must be set");
            }
            return new QueryPurchaseHistoryParams(this, null);
        }

        public Builder setProductType(String s) {
            this.zza = s;
            return this;
        }

        public static String zza(Builder queryPurchaseHistoryParams$Builder0) {
            return queryPurchaseHistoryParams$Builder0.zza;
        }
    }

    private final String zza;

    public QueryPurchaseHistoryParams(Builder queryPurchaseHistoryParams$Builder0, zzdh zzdh0) {
        this.zza = Builder.zza(queryPurchaseHistoryParams$Builder0);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final String zza() {
        return this.zza;
    }
}

