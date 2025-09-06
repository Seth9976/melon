package l4;

import android.os.Bundle;
import android.util.Log;

public final class f0 extends J {
    public final g0 a;

    public f0(g0 g00) {
        this.a = g00;
    }

    @Override  // l4.J
    public final void a(String s, Bundle bundle0) {
        Log.d("MediaRouteProviderProxy", "Error: " + s + ", data: " + bundle0);
    }

    @Override  // l4.J
    public final void b(Bundle bundle0) {
        this.a.h = bundle0.getString("groupableTitle");
        this.a.i = bundle0.getString("transferableTitle");
    }
}

