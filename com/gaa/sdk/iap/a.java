package com.gaa.sdk.iap;

import De.I;
import Z8.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

public final class a extends BroadcastReceiver {
    public final g a;
    public boolean b;

    public a(g g0) {
        this.a = g0;
    }

    @Override  // android.content.BroadcastReceiver
    public final void onReceive(Context context0, Intent intent0) {
        ArrayList arrayList0 = B.a.h(intent0.getExtras());
        g g0 = this.a;
        try {
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    if(!TextUtils.isEmpty(null) && !I.c0(((k)object0).a, ((k)object0).c)) {
                        throw new b(1002);
                    }
                    if(false) {
                        break;
                    }
                }
            }
            g0.g(B.a.Z(intent0.getIntExtra("responseCode", -1)), arrayList0);
            return;
        }
        catch(b b0) {
        }
        g0.g(B.a.Z(b0.a), null);
    }
}

