package co.ab180.airbridge.internal.d0.e.a;

import android.os.IBinder;
import android.os.Parcel;
import co.ab180.airbridge.internal.d0.b.a.c;

public class a extends co.ab180.airbridge.internal.d0.b.a.a {
    private static final String c = "com.uodis.opendevice.aidl.OpenDeviceIdentifierService";
    private static final int d = 1;
    private static final int e = 2;

    public a(IBinder iBinder0) {
        super(iBinder0, "com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
    }

    public String b() [...] // 潜在的解密器

    public boolean c() {
        boolean z;
        Parcel parcel0 = null;
        try {
            parcel0 = this.a(2, this.a());
            z = false;
            z = c.a(parcel0);
        }
        catch(Exception unused_ex) {
            if(parcel0 != null) {
                parcel0.recycle();
                return z;
            }
            return z;
        }
        catch(Throwable throwable0) {
            if(parcel0 != null) {
                parcel0.recycle();
            }
            throw throwable0;
        }
        if(parcel0 == null) {
            return z;
        }
        parcel0.recycle();
        return z;
    }
}

