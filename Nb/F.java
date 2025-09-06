package Nb;

import I6.V;
import android.net.Uri;
import androidx.media3.common.c;
import b3.B;
import b3.E;
import b3.G;
import b3.t;
import b3.v;
import b3.x;
import b3.y;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;

public final class f {
    public static final LogU a;

    static {
        f.a = Companion.create$default(LogU.Companion, "MediaIdManager", false, Category.Playback, 2, null);
    }

    public static E a(String s, String s1, boolean z, boolean z1, int v, String s2, Uri uri0, int v1) {
        ArrayList arrayList0 = new ArrayList();
        if((v1 & 0x40) != 0) {
            s2 = null;
        }
        if((v1 & 0x800) != 0) {
            uri0 = null;
        }
        c c0 = new c();
        c0.c = null;
        c0.d = null;
        c0.a = s;
        c0.e = s;
        c0.f = s2;
        c0.b = null;
        c0.D = null;
        c0.q = Boolean.valueOf(z1);
        c0.r = Boolean.valueOf(z);
        c0.m = uri0;
        c0.G = v;
        c0.H = null;
        G g0 = new G(c0);
        t t0 = new t();
        x x0 = new x();
        V.p(arrayList0);
        return new E(s1, new v(t0), null, new y(x0), g0, B.d);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
    }

    public static String b(String[] arr_s) [...] // 潜在的解密器
}

