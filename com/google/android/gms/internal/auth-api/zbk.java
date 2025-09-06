package com.google.android.gms.internal.auth-api;

import android.os.Parcel;
import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;

public abstract class zbk extends zbb implements zbl {
    public zbk() {
        super("com.google.android.gms.auth.api.identity.internal.IBeginSignInCallback");
    }

    @Override  // com.google.android.gms.internal.auth-api.zbb
    public final boolean zba(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Status status0 = (Status)zbc.zba(parcel0, Status.CREATOR);
            BeginSignInResult beginSignInResult0 = (BeginSignInResult)zbc.zba(parcel0, BeginSignInResult.CREATOR);
            zbc.zbb(parcel0);
            this.zbb(status0, beginSignInResult0);
            return true;
        }
        return false;
    }
}

