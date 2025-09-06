package com.android.billingclient.api;

public final class ConsumeParams {
    public static final class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        public Builder(zzcf zzcf0) {
        }

        public ConsumeParams build() {
            String s = this.zza;
            if(s == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            ConsumeParams consumeParams0 = new ConsumeParams(null);
            consumeParams0.zza = s;
            return consumeParams0;
        }

        public Builder setPurchaseToken(String s) {
            this.zza = s;
            return this;
        }
    }

    private String zza;

    private ConsumeParams() {
        throw null;
    }

    public ConsumeParams(zzcg zzcg0) {
    }

    public String getPurchaseToken() {
        return this.zza;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }
}

