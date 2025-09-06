package i.n.i.b.a.s.e;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;

public final class qc extends PhoneStateListener {
    public final rc a;

    public qc(rc rc0) {
        this.a = rc0;
        super();
    }

    @Override  // android.telephony.PhoneStateListener
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo0) {
        boolean z;
        switch(telephonyDisplayInfo0.getOverrideNetworkType()) {
            case 3: 
            case 4: {
                z = true;
                break;
            }
            default: {
                z = false;
            }
        }
        rc.b(this.a, (z ? 10 : 5));
    }

    @Override  // android.telephony.PhoneStateListener
    public final void onServiceStateChanged(ServiceState serviceState0) {
        String s = serviceState0 == null ? "" : serviceState0.toString();
        rc.b(this.a, (s.contains("nrState=CONNECTED") || s.contains("nrState=NOT_RESTRICTED") ? 10 : 5));
    }
}

