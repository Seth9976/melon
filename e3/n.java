package e3;

import android.telephony.TelephonyCallback.DisplayInfoListener;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import com.google.android.material.internal.F;

public final class n extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    public final o a;

    public n(o o0) {
        this.a = o0;
    }

    @Override  // android.telephony.TelephonyCallback$DisplayInfoListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo0) {
        int v = F.d(telephonyDisplayInfo0);
        o.a((v != 3 && (v != 4 && v != 5) ? 5 : 10), this.a);
    }
}

