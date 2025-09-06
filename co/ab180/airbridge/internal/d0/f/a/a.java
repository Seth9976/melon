package co.ab180.airbridge.internal.d0.f.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import co.ab180.airbridge.internal.d0.b.a.c;

@Deprecated
public class a extends co.ab180.airbridge.internal.d0.b.a.a {
    private static final String c = "com.onestore.android.external.installreferrer.IGetInstallReferrerService";
    private static final int d = 1;

    public a(IBinder iBinder0) {
        super(iBinder0, "com.onestore.android.external.installreferrer.IGetInstallReferrerService");
    }

    public Bundle a(String s) {
        Parcel parcel0 = this.a();
        parcel0.writeString(s);
        Parcel parcel1 = this.a(1, parcel0);
        Bundle bundle0 = (Bundle)c.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle0;
    }
}

