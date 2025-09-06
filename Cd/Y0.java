package cd;

import U4.F;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.b0;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.jvm.internal.q;
import m4.e;
import m4.g;
import m4.h;
import m4.i;

public final class y0 extends CustomTarget {
    public final Context a;
    public final b0 b;
    public final b0 c;

    public y0(Context context0, b0 b00, b0 b01) {
        this.a = context0;
        this.b = b00;
        this.c = b01;
        super();
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable0) {
    }

    @Override  // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object object0, Transition transition0) {
        q.g(((Bitmap)object0), "bitmap");
        e e0 = new e(((Bitmap)object0));
        e0.a = 24;
        h h0 = e0.a();
        Context context0 = this.a;
        int v = ColorUtils.getColor(context0, 0x7F06016A);  // color:gray900e
        g g0 = h0.a(i.f);
        if(g0 != null) {
            v = g0.d;
        }
        this.b.setValue(v);
        int v1 = h0.e == null ? ColorUtils.getColor(context0, 0x7F06016A) : F.C(h0.e);  // color:gray900e
        this.c.setValue(v1);
    }
}

