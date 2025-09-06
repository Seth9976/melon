package com.iloen.melon.utils.ui;

import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.net.v6x.response.FloatingBannerRes.RESPONSE.BANNER;
import ie.H;
import we.n;

public final class g implements n {
    public final a1.g a;
    public final a1.g b;
    public final long c;
    public final boolean d;
    public final boolean e;
    public final MusicBrowserPopupHelper f;
    public final BANNER g;

    public g(a1.g g0, a1.g g1, long v, boolean z, boolean z1, MusicBrowserPopupHelper musicBrowserPopupHelper0, BANNER floatingBannerRes$RESPONSE$BANNER0) {
        this.a = g0;
        this.b = g1;
        this.c = v;
        this.d = z;
        this.e = z1;
        this.f = musicBrowserPopupHelper0;
        this.g = floatingBannerRes$RESPONSE$BANNER0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        p p0 = (p)(((l)object0));
        if(p0.Q(v & 1, (v & 3) != 2)) {
            boolean z = this.e;
            boolean z1 = p0.h(z);
            MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.f;
            boolean z2 = p0.i(musicBrowserPopupHelper0);
            BANNER floatingBannerRes$RESPONSE$BANNER0 = this.g;
            boolean z3 = p0.i(floatingBannerRes$RESPONSE$BANNER0);
            h h0 = p0.N();
            V v1 = k.a;
            if((z1 | z2 | z3) != 0 || h0 == v1) {
                h0 = new h(z, musicBrowserPopupHelper0, floatingBannerRes$RESPONSE$BANNER0, 0);
                p0.l0(h0);
            }
            boolean z4 = p0.h(z);
            boolean z5 = p0.i(musicBrowserPopupHelper0);
            boolean z6 = p0.i(floatingBannerRes$RESPONSE$BANNER0);
            h h1 = p0.N();
            if((z4 | z5 | z6) != 0 || h1 == v1) {
                h1 = new h(z, musicBrowserPopupHelper0, floatingBannerRes$RESPONSE$BANNER0, 1);
                p0.l0(h1);
            }
            boolean z7 = p0.h(z);
            boolean z8 = p0.i(musicBrowserPopupHelper0);
            boolean z9 = p0.i(floatingBannerRes$RESPONSE$BANNER0);
            h h2 = p0.N();
            if((z7 | z8 | z9) != 0 || h2 == v1) {
                h2 = new h(z, musicBrowserPopupHelper0, floatingBannerRes$RESPONSE$BANNER0, 2);
                p0.l0(h2);
            }
            boolean z10 = p0.i(musicBrowserPopupHelper0);
            boolean z11 = p0.i(floatingBannerRes$RESPONSE$BANNER0);
            c c0 = p0.N();
            if(z10 || z11 || c0 == v1) {
                c0 = new c(musicBrowserPopupHelper0, floatingBannerRes$RESPONSE$BANNER0);
                p0.l0(c0);
            }
            MusicBrowserPopupHelperKt.FloatingBanner-Lb_0hxI(this.a, this.b, this.c, this.d, z, false, null, h0, h1, h2, c0, p0, 0, 0, 0x60);
            return H.a;
        }
        p0.T();
        return H.a;
    }
}

