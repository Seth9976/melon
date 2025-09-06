package ed;

import A0.f;
import android.content.Context;
import android.graphics.DashPathEffect;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.a0;
import com.iloen.melon.utils.color.ColorUtils;
import ie.H;
import kotlin.jvm.internal.q;
import r1.l;
import y0.M;
import y0.h;

public final class k implements we.k {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final Object e;

    public k(float f, float f1, float f2, Context context0) {
        this.a = 1;
        super();
        this.b = f;
        this.c = f1;
        this.d = f2;
        this.e = context0;
    }

    public k(a0 a00, float f, float f1, float f2) {
        this.a = 0;
        super();
        this.e = a00;
        this.b = f;
        this.c = f1;
        this.d = f2;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Object object1 = this.e;
        float f = this.d;
        float f1 = this.c;
        float f2 = this.b;
        if(this.a != 0) {
            q.g(((f)object0), "$this$Canvas");
            float f3 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL)));
            float f4 = f2 / f1 * f;
            float f5 = Float.intBitsToFloat(((int)(((f)object0).c() >> 0x20)));
            float f6 = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL)));
            f.k0(((f)object0), M.c(ColorUtils.getColor(((Context)object1), 0x7F060447)), ((long)Float.floatToRawIntBits(f3 - f4)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f5)) << 0x20 | ((long)Float.floatToRawIntBits(f6 - f4)) & 0xFFFFFFFFL, 2.0f, 0, new h(new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f)), 0x1D0);  // color:pink600s
            return h0;
        }
        float f7 = (float)(((int)(((l)object0).a >> 0x20)));
        ((K0)(((a0)object1))).n((f7 < f2 ? ((int)f1) : ((int)(f7 - f))));
        return h0;
    }
}

