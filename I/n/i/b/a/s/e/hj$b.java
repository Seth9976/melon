package i.n.i.b.a.s.e;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;

public final class hj.b {
    public final Context a;
    public final HashMap b;
    public final int c;
    public final E4 d;
    public final boolean e;

    public hj.b(Context context0) {
        String s1;
        this.a = context0 == null ? null : context0.getApplicationContext();
        if(context0 == null) {
            s1 = M7.C(Locale.getDefault().getCountry());
        }
        else {
            TelephonyManager telephonyManager0 = (TelephonyManager)context0.getSystemService("phone");
            if(telephonyManager0 == null) {
                s1 = M7.C(Locale.getDefault().getCountry());
            }
            else {
                String s = telephonyManager0.getNetworkCountryIso();
                s1 = TextUtils.isEmpty(s) ? M7.C(Locale.getDefault().getCountry()) : M7.C(s);
            }
        }
        h9 h90 = (h9)l4.n.d.get(s1);
        if(h90 == null) {
            h90 = c5.e;
        }
        if(h90.isEmpty()) {
            Object[] arr_object = {2, 2, 2, 2, 2, 2};
            Ja.C(arr_object);
            h90 = h9.r(6, arr_object);
        }
        HashMap hashMap0 = new HashMap(8);
        hashMap0.put(0, 2000000L);
        int v = (int)(((Integer)h90.get(0)));
        hashMap0.put(2, ((Long)l4.o.get(v)));
        int v1 = (int)(((Integer)h90.get(1)));
        hashMap0.put(3, ((Long)l4.r.get(v1)));
        int v2 = (int)(((Integer)h90.get(2)));
        hashMap0.put(4, ((Long)l4.w.get(v2)));
        int v3 = (int)(((Integer)h90.get(3)));
        hashMap0.put(5, ((Long)l4.B.get(v3)));
        int v4 = (int)(((Integer)h90.get(4)));
        hashMap0.put(10, ((Long)l4.D.get(v4)));
        int v5 = (int)(((Integer)h90.get(5)));
        hashMap0.put(9, ((Long)l4.E.get(v5)));
        int v6 = (int)(((Integer)h90.get(0)));
        hashMap0.put(7, ((Long)l4.o.get(v6)));
        this.b = hashMap0;
        this.c = 2000;
        this.d = E4.b;
        this.e = true;
    }
}

