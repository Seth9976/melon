package com.android.billingclient.api;

public final class QueryPurchasesParams {
    public static class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        public Builder(zzdi zzdi0) {
        }

        public QueryPurchasesParams build() {
            if(this.zza == null) {
                throw new IllegalArgumentException("Product type must be set");
            }
            return new QueryPurchasesParams(this, null);
        }

        public Builder setProductType(String s) {
            this.zza = s;
            return this;
        }

        public static String zza(Builder queryPurchasesParams$Builder0) {
            return queryPurchasesParams$Builder0.zza;
        }
    }

    private final String zza;

    public QueryPurchasesParams(Builder queryPurchasesParams$Builder0, zzdj zzdj0) {
        this.zza = Builder.zza(queryPurchasesParams$Builder0);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final String zza() {
        return this.zza;
    }
}

