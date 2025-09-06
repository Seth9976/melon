package com.android.billingclient.api;

@zzk
public final class PendingPurchasesParams {
    @zzk
    public static final class Builder {
        private boolean enableOneTimeProducts;
        private boolean enablePrepaidPlans;

        private Builder() {
        }

        public Builder(zzco zzco0) {
        }

        public PendingPurchasesParams build() {
            if(!this.enableOneTimeProducts) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new PendingPurchasesParams(true, this.enablePrepaidPlans, null);
        }

        public Builder enableOneTimeProducts() {
            this.enableOneTimeProducts = true;
            return this;
        }

        public Builder enablePrepaidPlans() {
            this.enablePrepaidPlans = true;
            return this;
        }
    }

    private final boolean enableOneTimeProducts;
    private final boolean enablePrepaidPlans;

    private PendingPurchasesParams(boolean z, boolean z1) {
        this.enableOneTimeProducts = z;
        this.enablePrepaidPlans = z1;
    }

    public PendingPurchasesParams(boolean z, boolean z1, zzcp zzcp0) {
        this(z, z1);
    }

    public boolean isEnabledForOneTimeProducts() {
        return this.enableOneTimeProducts;
    }

    public boolean isEnabledForPrepaidPlans() {
        return this.enablePrepaidPlans;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }
}

