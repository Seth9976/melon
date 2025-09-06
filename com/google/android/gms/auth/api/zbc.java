package com.google.android.gms.auth.api;

import com.google.android.gms.common.internal.ShowFirstParty;

@Deprecated
public final class zbc {
    protected Boolean zba;
    protected String zbb;

    public zbc() {
        this.zba = Boolean.FALSE;
    }

    @ShowFirstParty
    public zbc(zbd zbd0) {
        this.zba = Boolean.valueOf(zbd.zbd(zbd0));
        this.zbb = zbd.zbc(zbd0);
    }

    @ShowFirstParty
    public final zbc zba(String s) {
        this.zbb = s;
        return this;
    }
}

