package i.n.i.b.a.s.e;

import android.content.Context;
import java.util.Map;

public class wt {
    public final boolean a;
    public final Ga b;
    public final uc c;

    public wt(Context context0) {
        this.a = L7.E(context0);
        this.b = new Ga(context0);
        this.c = new uc(context0);
    }

    public static boolean a(h5 h50, byte[] arr_b) {
        long v;
        Map map0 = h50.h(arr_b);
        String s = (String)map0.get("PlayAllowed");
        if(s == null || s.equalsIgnoreCase("true")) {
            String s1 = (String)map0.get("PlaybackDurationRemaining");
            if(s1 == null) {
                v = 0L;
            }
            else {
                if(!s1.equalsIgnoreCase("00")) {
                    v = Long.parseLong(s1);
                    goto label_10;
                }
                return true;
            }
        label_10:
            String s2 = (String)map0.get("LicenseDurationRemaining");
            return (s1 == null || v > 0L) && (s2 == null || (s2 == null ? 0L : Long.parseLong(s2)) > 0L);
        }
        return false;
    }
}

