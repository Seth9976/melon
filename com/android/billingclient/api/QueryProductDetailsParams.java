package com.android.billingclient.api;

import com.google.android.gms.internal.play_billing.zzai;
import java.util.HashSet;
import java.util.List;

public final class QueryProductDetailsParams {
    public static class Builder {
        private zzai zza;

        private Builder() {
            throw null;
        }

        public Builder(zzdc zzdc0) {
        }

        public QueryProductDetailsParams build() {
            return new QueryProductDetailsParams(this, null);
        }

        public Builder setProductList(List list0) {
            if(list0 == null || list0.isEmpty()) {
                throw new IllegalArgumentException("Product list cannot be empty.");
            }
            HashSet hashSet0 = new HashSet();
            for(Object object0: list0) {
                Product queryProductDetailsParams$Product0 = (Product)object0;
                if(!"play_pass_subs".equals(queryProductDetailsParams$Product0.zzb())) {
                    hashSet0.add(queryProductDetailsParams$Product0.zzb());
                }
            }
            if(hashSet0.size() > 1) {
                throw new IllegalArgumentException("All products should be of the same product type.");
            }
            this.zza = zzai.zzj(list0);
            return this;
        }

        public static zzai zza(Builder queryProductDetailsParams$Builder0) {
            return queryProductDetailsParams$Builder0.zza;
        }
    }

    public static class Product {
        public static class com.android.billingclient.api.QueryProductDetailsParams.Product.Builder {
            private String zza;
            private String zzb;

            private com.android.billingclient.api.QueryProductDetailsParams.Product.Builder() {
                throw null;
            }

            public com.android.billingclient.api.QueryProductDetailsParams.Product.Builder(zzdd zzdd0) {
            }

            public Product build() {
                if("first_party".equals(this.zzb)) {
                    throw new IllegalArgumentException("Serialized doc id must be provided for first party products.");
                }
                if(this.zza == null) {
                    throw new IllegalArgumentException("Product id must be provided.");
                }
                if(this.zzb == null) {
                    throw new IllegalArgumentException("Product type must be provided.");
                }
                return new Product(this, null);
            }

            public com.android.billingclient.api.QueryProductDetailsParams.Product.Builder setProductId(String s) {
                this.zza = s;
                return this;
            }

            public com.android.billingclient.api.QueryProductDetailsParams.Product.Builder setProductType(String s) {
                this.zzb = s;
                return this;
            }

            public static String zzb(com.android.billingclient.api.QueryProductDetailsParams.Product.Builder queryProductDetailsParams$Product$Builder0) {
                return queryProductDetailsParams$Product$Builder0.zzb;
            }
        }

        private final String zza;
        private final String zzb;

        public Product(com.android.billingclient.api.QueryProductDetailsParams.Product.Builder queryProductDetailsParams$Product$Builder0, zzde zzde0) {
            this.zza = queryProductDetailsParams$Product$Builder0.zza;
            this.zzb = com.android.billingclient.api.QueryProductDetailsParams.Product.Builder.zzb(queryProductDetailsParams$Product$Builder0);
        }

        public static com.android.billingclient.api.QueryProductDetailsParams.Product.Builder newBuilder() {
            return new com.android.billingclient.api.QueryProductDetailsParams.Product.Builder(null);
        }

        public final String zza() {
            return this.zza;
        }

        public final String zzb() {
            return this.zzb;
        }
    }

    private final zzai zza;

    public QueryProductDetailsParams(Builder queryProductDetailsParams$Builder0, zzdf zzdf0) {
        this.zza = Builder.zza(queryProductDetailsParams$Builder0);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public final zzai zza() {
        return this.zza;
    }

    public final String zzb() {
        return ((Product)this.zza.get(0)).zzb();
    }
}

