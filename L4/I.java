package l4;

import android.media.MediaRoute2Info;
import android.media.RoutingSessionInfo.Builder;
import java.util.ArrayList;

public abstract class i {
    public static void C(t t0, long v) {
        t0.notifyRequestFailed(v, 3);
    }

    public static MediaRoute2Info b(Object object0) [...] // Inlined contents

    public static RoutingSessionInfo.Builder f(String s, String s1) {
        return new RoutingSessionInfo.Builder(s, s1);
    }

    public static void u(t t0, long v) {
        t0.notifyRequestFailed(v, 4);
    }

    public static void v(t t0, ArrayList arrayList0) {
        t0.notifyRoutes(arrayList0);
    }
}

