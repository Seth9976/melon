package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

@KeepForSdk
public abstract class TaskApiCall {
    @KeepForSdk
    public static class Builder {
        private RemoteCall zaa;
        private boolean zab;
        private Feature[] zac;
        private int zad;

        private Builder() {
            this.zab = true;
            this.zad = 0;
        }

        public Builder(zacw zacw0) {
            this.zab = true;
            this.zad = 0;
        }

        @KeepForSdk
        public TaskApiCall build() {
            Preconditions.checkArgument(this.zaa != null, "execute parameter required");
            return new zacv(this, this.zac, this.zab, this.zad);
        }

        @KeepForSdk
        @Deprecated
        public Builder execute(BiConsumer biConsumer0) {
            this.zaa = new zacu(biConsumer0);
            return this;
        }

        @KeepForSdk
        public Builder run(RemoteCall remoteCall0) {
            this.zaa = remoteCall0;
            return this;
        }

        @KeepForSdk
        public Builder setAutoResolveMissingFeatures(boolean z) {
            this.zab = z;
            return this;
        }

        @KeepForSdk
        public Builder setFeatures(Feature[] arr_feature) {
            this.zac = arr_feature;
            return this;
        }

        @KeepForSdk
        public Builder setMethodKey(int v) {
            this.zad = v;
            return this;
        }
    }

    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    @KeepForSdk
    @Deprecated
    public TaskApiCall() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    @KeepForSdk
    public TaskApiCall(Feature[] arr_feature, boolean z, int v) {
        this.zaa = arr_feature;
        this.zab = arr_feature != null && z;
        this.zac = v;
    }

    @KeepForSdk
    public static Builder builder() {
        return new Builder(null);
    }

    @KeepForSdk
    public abstract void doExecute(AnyClient arg1, TaskCompletionSource arg2);

    @KeepForSdk
    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    public final int zaa() {
        return this.zac;
    }

    public final Feature[] zab() {
        return this.zaa;
    }
}

