package com.iloen.melon.utils.ui;

import Cc.e0;
import Ma.g;
import androidx.compose.runtime.V;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import com.iloen.melon.MelonAppBase;
import ie.H;
import k8.Y;
import k8.o;
import we.n;

public final class d implements n {
    public final MusicBrowserPopupHelper a;

    public d(MusicBrowserPopupHelper musicBrowserPopupHelper0) {
        this.a = musicBrowserPopupHelper0;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        int v = (int)(((Integer)object1));
        if(((p)(((l)object0))).Q(v & 1, (v & 3) != 2)) {
            String s = ((o)(((g)Y.f(MelonAppBase.Companion, g.class)))).m().b();
            if(s == null) {
                s = "";
            }
            long v1 = e0.T(((p)(((l)object0))), 0x7F06017A);  // color:green500e_support_high_contrast
            MusicBrowserPopupHelper musicBrowserPopupHelper0 = this.a;
            boolean z = ((p)(((l)object0))).i(musicBrowserPopupHelper0);
            f f0 = ((p)(((l)object0))).N();
            V v2 = k.a;
            if(z || f0 == v2) {
                f0 = new f(musicBrowserPopupHelper0, 3);
                ((p)(((l)object0))).l0(f0);
            }
            boolean z1 = ((p)(((l)object0))).i(musicBrowserPopupHelper0);
            f f1 = ((p)(((l)object0))).N();
            if(z1 || f1 == v2) {
                f1 = new f(musicBrowserPopupHelper0, 4);
                ((p)(((l)object0))).l0(f1);
            }
            boolean z2 = ((p)(((l)object0))).i(musicBrowserPopupHelper0);
            f f2 = ((p)(((l)object0))).N();
            if(z2 || f2 == v2) {
                f2 = new f(musicBrowserPopupHelper0, 0);
                ((p)(((l)object0))).l0(f2);
            }
            boolean z3 = ((p)(((l)object0))).i(musicBrowserPopupHelper0);
            f f3 = ((p)(((l)object0))).N();
            if(z3 || f3 == v2) {
                f3 = new f(musicBrowserPopupHelper0, 5);
                ((p)(((l)object0))).l0(f3);
            }
            MusicBrowserPopupHelperKt.FloatingBanner-Lb_0hxI(null, null, v1, false, false, true, s, f0, f1, f2, f3, ((p)(((l)object0))), 0x30000, 0, 27);
            return H.a;
        }
        ((p)(((l)object0))).T();
        return H.a;
    }
}

