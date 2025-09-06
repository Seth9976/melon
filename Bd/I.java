package bd;

import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.l;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v5x.response.FlexibleRes.RESPONSE.Flexible.Content;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.jvm.internal.q;
import m0.b;
import m0.c;
import we.a;
import y0.M;

public abstract class i {
    public static final void a(Content flexibleRes$RESPONSE$Flexible$Content0, boolean z, a a0, l l0, int v) {
        q.g(flexibleRes$RESPONSE$Flexible$Content0, "content");
        ((p)l0).c0(0x6C44E920);
        int v1 = (((p)l0).i(flexibleRes$RESPONSE$Flexible$Content0) ? 4 : 2) | v | (((p)l0).h(z) ? 0x20 : 16) | (((p)l0).i(a0) ? 0x100 : 0x80);
        if(((p)l0).Q(v1 & 1, (v1 & 0x93) != 0x92)) {
            String s = flexibleRes$RESPONSE$Flexible$Content0.getBgVideoUrl();
            if(s == null) {
                s = "";
            }
            boolean z1 = q.b(flexibleRes$RESPONSE$Flexible$Content0.getBgType(), "V");
            b b0 = c.e(0x4C5EF476, ((p)l0), new g(M.c(ColorUtils.getColorFromHexStr(flexibleRes$RESPONSE$Flexible$Content0.getBgColor())), a0, z1, s, z, flexibleRes$RESPONSE$Flexible$Content0));
            M.c.a(d.c, null, false, b0, ((p)l0), 0xC06, 6);
        }
        else {
            ((p)l0).T();
        }
        n0 n00 = ((p)l0).t();
        if(n00 != null) {
            n00.d = new h(flexibleRes$RESPONSE$Flexible$Content0, z, a0, v, 0);
        }
    }
}

