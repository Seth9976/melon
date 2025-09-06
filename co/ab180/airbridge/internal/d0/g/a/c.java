package co.ab180.airbridge.internal.d0.g.a;

import android.os.Bundle;
import android.os.Parcel;
import co.ab180.airbridge.internal.d0.b.a.b;

public abstract class c extends b {
    private static final String a = "com.sec.android.app.samsungapps.lib.IInstallReferrerAgentResultCallback";
    private static final int b = 1;

    public c() {
        super("com.sec.android.app.samsungapps.lib.IInstallReferrerAgentResultCallback");
    }

    public abstract void a(Bundle arg1);

    @Override  // co.ab180.airbridge.internal.d0.b.a.b
    public boolean a(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            this.a(((Bundle)co.ab180.airbridge.internal.d0.b.a.c.a(parcel0, Bundle.CREATOR)));
            return true;
        }
        return false;
    }
}

