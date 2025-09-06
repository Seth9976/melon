package b5;

import U4.w;
import Z4.i;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import kotlin.jvm.internal.q;

public abstract class h {
    public static final String a;

    // 去混淆评级： 低(20)
    static {
        q.f("WM-NetworkStateTracker", "tagWithPrefix(\"NetworkStateTracker\")");
        h.a = "WM-NetworkStateTracker";
    }

    public static final i a(ConnectivityManager connectivityManager0) {
        boolean z2;
        q.g(connectivityManager0, "<this>");
        NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
        boolean z = true;
        boolean z1 = networkInfo0 != null && networkInfo0.isConnected();
        try {
            NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(connectivityManager0.getActiveNetwork());
            if(networkCapabilities0 == null) {
                goto label_12;
            }
            else {
                z2 = networkCapabilities0.hasCapability(16);
            }
        }
        catch(SecurityException securityException0) {
            w.e().d("WM-NetworkStateTracker", "Unable to validate active network", securityException0);
            z2 = false;
        }
        goto label_13;
    label_12:
        z2 = false;
    label_13:
        boolean z3 = connectivityManager0.isActiveNetworkMetered();
        if(networkInfo0 == null || networkInfo0.isRoaming()) {
            z = false;
        }
        return new i(z1, z2, z3, z);
    }
}

