package k5;

import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.util.Size;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import t5.o;
import u5.g;
import ye.a;

public final class v implements ImageDecoder.OnHeaderDecodedListener {
    public final H a;
    public final y b;
    public final C c;

    public v(H h0, y y0, C c0) {
        this.a = h0;
        this.b = y0;
        this.c = c0;
    }

    @Override  // android.graphics.ImageDecoder$OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder imageDecoder0, ImageDecoder.ImageInfo imageDecoder$ImageInfo0, ImageDecoder.Source imageDecoder$Source0) {
        this.a.a = imageDecoder0;
        Size size0 = imageDecoder$ImageInfo0.getSize();
        int v = size0.getWidth();
        int v1 = size0.getHeight();
        g g0 = this.b.b.d;
        int v2 = q.b(g0, g.c) ? v : d3.g.h0(g0.a, this.b.b.e);
        g g1 = this.b.b.d;
        int v3 = q.b(g1, g.c) ? v1 : d3.g.h0(g1.b, this.b.b.e);
        if(v > 0 && v1 > 0 && (v != v2 || v1 != v3)) {
            double f = df.v.r(v, v1, v2, v3, this.b.b.e);
            this.c.a = f < 1.0;
            if(f < 1.0 || !this.b.b.f) {
                imageDecoder0.setTargetSize(a.U(((double)v) * f), a.U(f * ((double)v1)));
            }
        }
        o o0 = this.b.b;
        com.iloen.melon.utils.system.a.o(imageDecoder0, (o0.b == Bitmap.Config.HARDWARE ? 3 : 1));
        com.iloen.melon.utils.system.a.B(imageDecoder0, !o0.g);
        ColorSpace colorSpace0 = o0.c;
        if(colorSpace0 != null) {
            com.iloen.melon.utils.system.a.p(imageDecoder0, colorSpace0);
        }
        com.iloen.melon.utils.system.a.q(imageDecoder0, !o0.h);
        if(o0.l.a("coil#animated_transformation") != null) {
            throw new ClassCastException();
        }
        com.iloen.melon.utils.system.a.n(imageDecoder0);
    }
}

