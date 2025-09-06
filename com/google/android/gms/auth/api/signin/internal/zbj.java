package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;

final class zbj extends zba {
    final zbk zba;

    public zbj(zbk zbk0) {
        this.zba = zbk0;
        super();
    }

    @Override  // com.google.android.gms.auth.api.signin.internal.zba
    public final void zbb(Status status0) {
        this.zba.setResult(status0);
    }
}

