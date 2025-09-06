package com.gaa.sdk.iap;

import K5.a;
import android.os.Bundle;
import android.os.Parcel;
import java.util.concurrent.Callable;

public final class f implements Callable {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final Bundle e;
    public final j f;

    public f(j j0, int v, String s, String s1, String s2, Bundle bundle0) {
        this.f = j0;
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = bundle0;
    }

    @Override
    public final Object call() {
        a a0 = (a)this.f.f;
        a0.getClass();
        Parcel parcel0 = Parcel.obtain();
        Parcel parcel1 = Parcel.obtain();
        try {
            parcel0.writeInterfaceToken("com.gaa.extern.iap.IGlobalInAppService");
            parcel0.writeInt(this.a);
            parcel0.writeString("com.iloen.melon");
            parcel0.writeString(this.b);
            Bundle bundle0 = null;
            parcel0.writeString(null);
            parcel0.writeString(this.c);
            parcel0.writeString(this.d);
            parcel0.writeInt(1);
            this.e.writeToParcel(parcel0, 0);
            a0.a.transact(2, parcel0, parcel1, 0);
            parcel1.readException();
            if(parcel1.readInt() != 0) {
                bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel1);
            }
            return bundle0;
        }
        finally {
            parcel1.recycle();
            parcel0.recycle();
        }
    }
}

