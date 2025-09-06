package co.ab180.airbridge.internal.thirdparty.huawei.installreferrer;

import android.os.IBinder;
import android.os.Parcel;
import co.ab180.airbridge.internal.d0.b.a.a;

public class b extends a {
    private static final String c = "com.huawei.android.hms.ppskit.IPPSChannelInfoService";
    private static final int d = 1;

    public b(IBinder iBinder0) {
        super(iBinder0, "com.huawei.android.hms.ppskit.IPPSChannelInfoService");
    }

    public String b() {
        Parcel parcel0 = this.a(1, this.a());
        String s = parcel0.readString();
        parcel0.recycle();
        return s;
    }
}

