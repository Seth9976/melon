package ed;

import Tf.o;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.b0;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.net.res.SearchMainContentRes.ThemeOffering;
import ie.H;
import we.k;
import y0.M;
import y0.s;

public final class q implements k {
    public final int a;
    public final b0 b;
    public final Context c;
    public final p0 d;

    public q(b0 b00, Context context0, p0 p00, int v) {
        this.a = v;
        this.b = b00;
        this.c = context0;
        this.d = p00;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            kotlin.jvm.internal.q.g(((Drawable)object0), "drawable");
            ThemeOffering searchMainContentRes$ThemeOffering0 = this.d.c;
            kotlin.jvm.internal.q.g(this.c, "context");
            s s0 = new s((searchMainContentRes$ThemeOffering0 == null || o.H0("") ? M.c(ColorUtils.getColor(this.c, 0x7F060145)) : M.c(ColorUtils.getColorFromHexStr(""))));  // color:gray050s
            this.b.setValue(s0);
            return H.a;
        }
        kotlin.jvm.internal.q.g(((Drawable)object0), "drawable");
        ThemeOffering searchMainContentRes$ThemeOffering1 = this.d.c;
        kotlin.jvm.internal.q.g(this.c, "context");
        s s1 = new s((searchMainContentRes$ThemeOffering1 == null || o.H0("") ? M.c(ColorUtils.getColor(this.c, 0x7F060145)) : M.c(ColorUtils.getColorFromHexStr(""))));  // color:gray050s
        this.b.setValue(s1);
        return H.a;
    }
}

