package co.ab180.airbridge.internal.d0.d.c;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import co.ab180.airbridge.internal.d0.b.a.a;
import co.ab180.airbridge.internal.d0.b.a.c;

public class b extends a {
    private static final String c = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";
    private static final int d = 1;

    public b(IBinder iBinder0) {
        super(iBinder0, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public Bundle a(Bundle bundle0) {
        Parcel parcel0 = this.a();
        c.a(parcel0, bundle0);
        Parcel parcel1 = this.a(1, parcel0);
        Bundle bundle1 = (Bundle)c.a(parcel1, Bundle.CREATOR);
        parcel1.recycle();
        return bundle1;
    }
}

