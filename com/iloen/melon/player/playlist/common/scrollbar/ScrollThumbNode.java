package com.iloen.melon.player.playlist.common.scrollbar;

import A0.b;
import A0.c;
import A0.d;
import P0.K;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import e.k;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import r0.p;
import r1.m;
import x0.e;
import y0.H;
import y0.M;
import y0.s;
import y0.u;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\t\u001A\u00020\b*\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0004\u001A\u00020\u00038\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/player/playlist/common/scrollbar/ScrollThumbNode;", "LP0/p;", "Lr0/p;", "Ly0/u;", "colorProducer", "<init>", "(Ly0/u;)V", "LA0/d;", "Lie/H;", "draw", "(LA0/d;)V", "a", "Ly0/u;", "getColorProducer", "()Ly0/u;", "setColorProducer", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
final class ScrollThumbNode extends p implements P0.p {
    public u a;
    public e b;
    public m c;
    public M d;

    public ScrollThumbNode(@NotNull u u0) {
        q.g(u0, "colorProducer");
        super();
        this.a = u0;
    }

    @Override  // P0.p
    public void draw(@NotNull d d0) {
        q.g(d0, "<this>");
        long v = this.a.invoke-0d7_KjU();
        float f = (float)ViewUtilsKt.dpToPx(4);
        b b0 = ((K)d0).a;
        long v1 = b0.c();
        M m0 = this.b == null || v1 != this.b.a || ((K)d0).getLayoutDirection() != this.c ? new H(k.d(0L, ((long)Float.floatToRawIntBits(f)) << 0x20 | 0xFFFFFFFFL & ((long)Float.floatToRawIntBits(Float.intBitsToFloat(((int)(b0.c() & 0xFFFFFFFFL))))))) : this.d;
        if(!s.d(v, s.g) && m0 != null) {
            float f1 = Float.intBitsToFloat(((int)(b0.c() >> 0x20))) - f;
            ((c)b0.b.a).M(f1, 0.0f);
            try {
                M.m(d0, m0, v);
            }
            finally {
                ((c)b0.b.a).M(-f1, -0.0f);
            }
        }
        this.d = m0;
        this.b = new e(b0.c());
        this.c = ((K)d0).getLayoutDirection();
    }

    @NotNull
    public final u getColorProducer() {
        return this.a;
    }

    @Override  // P0.m
    public void onDensityChange() {
    }

    @Override  // P0.m
    public void onLayoutDirectionChange() {
    }

    @Override  // P0.p
    public void onMeasureResultChanged() {
    }

    public final void setColorProducer(@NotNull u u0) {
        q.g(u0, "<set-?>");
        this.a = u0;
    }
}

