package m8;

import Bf.a;
import android.app.Activity;
import d3.g;
import gd.r5;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import va.o;

public class c extends a {
    public final int b;
    public Object c;

    public c(int v) {
        this.b = v;
        switch(v) {
            case 1: {
                super();
                this.c = o.a();
                return;
            }
            case 2: {
                super();
                return;
            }
            default: {
                super();
                this.c = g.Q(new r5(27));
            }
        }
    }

    @Override  // Bf.a
    public final String W0() {
        switch(this.b) {
            case 0: {
                return "connected";
            }
            case 1: {
                return "login";
            }
            default: {
                return "play";
            }
        }
    }

    @Override  // Bf.a
    public String Z0() {
        switch(this.b) {
            case 0: {
                return "/smartplaylist/activate";
            }
            case 1: {
                return "";
            }
            default: {
                return "";
            }
        }
    }

    public static void r1(Activity activity0, boolean z, boolean z1, String s, boolean z2) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new d0(z, z1, activity0, z2, s, null), 3, null);
    }
}

