package co.ab180.airbridge.internal.d0.g.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import co.ab180.airbridge.internal.d0.b.a.a;

public class b extends a {
    private static final String c = "com.sec.android.app.samsungapps.lib.IInstallReferrerAgentAPI";
    private static final int d = 1;

    public b(IBinder iBinder0) {
        super(iBinder0, "com.sec.android.app.samsungapps.lib.IInstallReferrerAgentAPI");
    }

    public void a(Bundle bundle0, c c0) {
        Parcel parcel0 = this.a();
        co.ab180.airbridge.internal.d0.b.a.c.a(parcel0, bundle0);
        IBinder iBinder0 = c0 == null ? null : c0;
        parcel0.writeStrongBinder(iBinder0);
        this.a(1, parcel0).recycle();
    }
}

