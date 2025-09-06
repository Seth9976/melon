package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class HashAccumulator {
    private int zaa;

    public HashAccumulator() {
        this.zaa = 1;
    }

    @KeepForSdk
    public HashAccumulator addObject(Object object0) {
        this.zaa = this.zaa * 0x1F + (object0 == null ? 0 : object0.hashCode());
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zaa;
    }

    public final HashAccumulator zaa(boolean z) {
        this.zaa = this.zaa * 0x1F + ((int)z);
        return this;
    }
}

