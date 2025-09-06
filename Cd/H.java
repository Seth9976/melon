package cd;

import A0.f;
import Ac.K;
import J0.N;
import J0.y;
import K.l;
import P.i;
import P.v;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Paint;
import androidx.compose.foundation.S;
import androidx.compose.runtime.I0;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.Z;
import androidx.compose.runtime.b0;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.MELONCHART.Chart.ChartHeader;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarKt;
import com.iloen.melon.player.playlist.common.scrollbar.ScrollbarState;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import java.util.ArrayList;
import java.util.List;
import je.w;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import r1.c;
import we.k;
import y0.M;
import zc.I;

public final class h implements k {
    public final int a;
    public final float b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;
    public final Object h;

    public h(ScrollbarState scrollbarState0, y y0, float f, H h0, l l0, b0 b00, b0 b01) {
        this.a = 1;
        super();
        this.c = scrollbarState0;
        this.d = y0;
        this.b = f;
        this.e = h0;
        this.f = l0;
        this.g = b00;
        this.h = b01;
    }

    public h(ArrayList arrayList0, K0 k00, float f, ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0, List list0, CoroutineScope coroutineScope0, r r0) {
        this.a = 0;
        super();
        this.c = arrayList0;
        this.e = k00;
        this.b = f;
        this.f = mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0;
        this.d = list0;
        this.g = coroutineScope0;
        this.h = r0;
    }

    public h(c c0, Context context0, List list0, Z z0, I i0, float f, Z z1) {
        this.a = 2;
        super();
        this.d = c0;
        this.e = context0;
        this.c = list0;
        this.f = z0;
        this.g = i0;
        this.b = f;
        this.h = z1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        switch(this.a) {
            case 0: {
                List list1 = (List)this.c;
                K0 k00 = (K0)this.e;
                ChartHeader mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0 = (ChartHeader)this.f;
                List list2 = (List)this.d;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.g;
                r r0 = (r)this.h;
                q.g(((v)object0), "$this$LazyHorizontalGrid");
                if(list1 == null) {
                    list1 = w.a;
                }
                ((i)(((v)object0))).t(list1.size(), new S(8, new Zc.c(k00), list1), null, new K(list1, 27), new b(0x49456F69, new m(list1, this.b, mainMusicRes$RESPONSE$MELONCHART$Chart$ChartHeader0, list2, k00, coroutineScope0, r0), true));
                return ie.H.a;
            }
            case 1: {
                H h0 = (H)this.e;
                l l0 = (l)this.f;
                b0 b00 = (b0)this.h;
                float f11 = ScrollbarKt.access$getSize-GRq-Twk(ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$7(((b0)this.g)));
                float f12 = ((ScrollbarState)this.c).getThumbMovedPercent() * f11;
                float f13 = ((ScrollbarState)this.c).getThumbMovedPercent();
                float f14 = Math.max((((ScrollbarState)this.c).getThumbSizePercent() + f13) * f11, ((N)(((y)this.d))).b() * this.b);
                float f15 = f12 - ((float)ViewUtilsKt.dpToPx(50));
                float f16 = Float.intBitsToFloat(((int)(((x0.b)object0).a & 0xFFFFFFFFL)));
                if(f15 <= f16 && f16 <= f14 + f12) {
                    K.b b0 = new K.b();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h0.a = b0;
                    if(l0 != null) {
                        ((K.m)l0).b(b0);
                    }
                    ScrollbarKt.access$Scrollbar_jIwJxvA$lambda$2(b00, ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(((x0.b)object0).a >> 0x20))))) << 0x20 | ((long)Float.floatToRawIntBits(f12)) & 0xFFFFFFFFL);
                }
                return ie.H.a;
            }
            default: {
                List list0 = (List)this.c;
                I i0 = (I)this.g;
                Z z0 = (Z)this.h;
                q.g(((f)object0), "$this$Canvas");
                float f = Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL))) - ((float)ViewUtilsKt.dpToPx(30.0f));
                I0 i00 = (I0)(((Z)this.f));
                i00.n(f);
                float f1 = ((c)this.d).Y(12.0f);
                Paint paint0 = new Paint(1);
                paint0.setTextSize(f1);
                paint0.setTextAlign(Paint.Align.CENTER);
                paint0.setTypeface(d5.f.G(((Context)this.e)));
                float f2 = i00.m();
                float f3 = Float.intBitsToFloat(((int)(((f)object0).c() >> 0x20)));
                float f4 = i00.m();
                Context context0 = (Context)this.e;
                f.k0(((f)object0), M.c(ColorUtils.getColor(context0, 0x7F06014A)), ((long)Float.floatToRawIntBits(f2)) & 0xFFFFFFFFL, ((long)Float.floatToRawIntBits(f3)) << 0x20 | ((long)Float.floatToRawIntBits(f4)) & 0xFFFFFFFFL, ((float)ViewUtilsKt.dpToPx(1.0f)), 0, null, 0x1F0);  // color:gray100a
                int v = 0;
                for(Object object1: list0) {
                    if(v >= 0) {
                        paint0.setColor(ColorUtils.getColor(context0, (v == e.k.s(list0) ? i0.g : i0.f)));
                        Canvas canvas0 = y0.c.a(((f)object0).a0().h());
                        float f5 = ((float)v) * this.b;
                        canvas0.drawText(((String)object1), ((f)object0).Y(i0.d) + f5, Float.intBitsToFloat(((int)(((f)object0).c() & 0xFFFFFFFFL))) - ((float)ViewUtilsKt.dpToPx(10.0f)), paint0);
                        float f6 = ((f)object0).Y(i0.d);
                        float f7 = ((f)object0).Y(i0.d);
                        float f8 = i00.m();
                        long v1 = M.c(ColorUtils.getColor(context0, 0x7F06014A));  // color:gray100a
                        float f9 = (float)ViewUtilsKt.dpToPx(1.0f);
                        float f10 = i0.d;
                        f.k0(((f)object0), v1, ((long)Float.floatToRawIntBits(f6 + f5)) << 0x20, ((long)Float.floatToRawIntBits(f8)) & 0xFFFFFFFFL | ((long)Float.floatToRawIntBits(f7 + f5)) << 0x20, f9, 0, null, 0x1F0);
                        if(v == e.k.s(list0)) {
                            ((I0)z0).n(((f)object0).Y(f10) + f5);
                        }
                        ++v;
                        continue;
                    }
                    e.k.O();
                    throw null;
                }
                return ie.H.a;
            }
        }
    }
}

