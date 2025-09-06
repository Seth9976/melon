package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.internal.auth-api.zbb;

public abstract class zbo extends zbb implements zbp {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override  // com.google.android.gms.internal.auth-api.zbb
    public final boolean zba(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                this.zbc();
                return true;
            }
            case 2: {
                this.zbb();
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

