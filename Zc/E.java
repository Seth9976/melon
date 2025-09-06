package zc;

import A0.f;
import android.content.Context;
import android.graphics.Paint.Align;
import android.graphics.Paint;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.Z;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import r1.c;
import we.k;
import y0.M;

public final class e implements k {
    public final c a;
    public final zc.k b;
    public final Context c;
    public final List d;
    public final Z e;
    public final float f;

    public e(c c0, zc.k k0, Context context0, List list0, Z z0, float f) {
        this.a = c0;
        this.b = k0;
        this.c = context0;
        this.d = list0;
        this.e = z0;
        this.f = f;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        float f11;
        q.g(((f)object0), "$this$Canvas");
        float f = this.a.Y(12.0f);
        float f1 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL)));
        zc.k k0 = this.b;
        float f2 = k0.e;
        float f3 = ((f)object0).Y(k0.g);
        ((I0)this.e).n(f1 - f3);
        Paint paint0 = new Paint(1);
        paint0.setTextSize(f);
        paint0.setTextAlign(Paint.Align.CENTER);
        paint0.setTypeface(d5.f.G(this.c));
        float f4 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL))) - ((float)ViewUtilsKt.dpToPx(3.0f));
        float f5 = ((I0)this.e).m();
        float f6 = Float.intBitsToFloat(((int)(((f)object0).c() >> 0x20)));
        float f7 = ((I0)this.e).m();
        long v = M.c(ColorUtils.getColor(this.c, 0x7F06014A));  // color:gray100a
        float f8 = (float)ViewUtilsKt.dpToPx(1.0f);
        float f9 = f4;
        I0 i00 = (I0)this.e;
        Context context0 = this.c;
        f.k0(((f)object0), v, ((long)Float.floatToRawIntBits(f5)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f7)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f6)) << 0x20, f8, 0, null, 0x1F0);
        List list0 = this.d;
        int v1 = 0;
        for(Object object1: list0) {
            if(v1 >= 0) {
                paint0.setColor(ColorUtils.getColor(context0, (v1 == e.k.s(list0) ? k0.i : k0.h)));
                float f10 = this.f;
                if(list0.isEmpty()) {
                    f11 = f9;
                }
                else {
                    f11 = f9;
                    y0.c.a(((f)object0).a0().h()).drawText(((String)object1), ((f)object0).Y(f2) + ((float)v1) * f10, f11, paint0);
                }
                float f12 = ((float)v1) * f10;
                float f13 = ((f)object0).Y(f2);
                float f14 = ((f)object0).Y(f2);
                float f15 = i00.m();
                f9 = f11;
                f.k0(((f)object0), M.c(ColorUtils.getColor(context0, 0x7F06014A)), ((long)Float.floatToRawIntBits(f13 + f12)) << 0x20, ((long)Float.floatToRawIntBits(f14 + f12)) << 0x20 | ((long)Float.floatToRawIntBits(f15)) & 0xFFFFFFFFL, ((float)ViewUtilsKt.dpToPx(1.0f)), 0, null, 0x1F0);  // color:gray100a
                ++v1;
                continue;
            }
            e.k.O();
            throw null;
        }
        return H.a;
    }
}

