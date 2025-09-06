package Ic;

import Ad.w;
import Kc.f;
import P0.A0;
import P0.I;
import P0.d0;
import P1.b;
import Q0.u;
import Tf.o;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.L;
import androidx.compose.ui.tooling.ComposeViewAdapter;
import androidx.fragment.app.l0;
import b.t;
import com.iloen.melon.MusicBrowserActivity;
import com.kakao.tiara.data.Meta.Builder;
import ed.F0;
import f7.c;
import hd.i;
import ie.H;
import jd.A;
import jd.M0;
import jd.f0;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import r0.p;
import rd.K1;
import td.t1;
import w0.e;
import w0.g;
import we.a;

public final class h extends n implements a {
    public final int b;

    public h(int v, Object object0, Class class0, String s, String s1, int v1, int v2) {
        this.b = v2;
        super(v, v1, class0, object0, s, s1);
    }

    @Override  // we.a
    public final Object invoke() {
        H h0 = H.a;
        switch(this.b) {
            case 0: {
                ((k)this.receiver).u();
                return h0;
            }
            case 1: {
                ((k)this.receiver).u();
                return h0;
            }
            case 2: {
                ((f)this.receiver).u();
                return h0;
            }
            case 3: {
                View view0 = (View)this.receiver;
                int v = Build.VERSION.SDK_INT;
                if(v >= 30) {
                    b.k(view0);
                }
                if(v >= 29) {
                    ContentCaptureSession contentCaptureSession0 = S1.b.a(view0);
                    if(contentCaptureSession0 != null) {
                        return new T0.a(contentCaptureSession0, view0);
                    }
                }
                return null;
            }
            case 4: {
                u u0 = (u)this.receiver;
                if(u0.isFocused() || u0.hasFocus()) {
                    u0.clearFocus();
                }
                else if(u0.hasFocus()) {
                    View view1 = u0.findFocus();
                    if(view1 != null) {
                        view1.clearFocus();
                    }
                    u0.clearFocus();
                    return h0;
                }
                return h0;
            }
            case 5: {
                return ((u)this.receiver).y();
            }
            case 6: {
                androidx.room.H.access$onClosed(((androidx.room.H)this.receiver));
                return h0;
            }
            case 7: {
                ((t)this.receiver).e();
                return h0;
            }
            case 8: {
                ((t)this.receiver).e();
                return h0;
            }
            case 9: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 10: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 11: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 12: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 13: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 14: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 15: {
                F0.j(((F0)this.receiver));
                return h0;
            }
            case 16: {
                ((c)this.receiver).getClass();
                q.f("jeb-dexdec-sb-st-2254", "threadName");
                return Boolean.valueOf(o.v0("jeb-dexdec-sb-st-2254", "Firebase Background Thread #", false));
            }
            case 17: {
                ((c)this.receiver).getClass();
                q.f("jeb-dexdec-sb-st-2254", "threadName");
                return Boolean.valueOf(o.v0("jeb-dexdec-sb-st-2254", "Firebase Blocking Thread #", false));
            }
            case 18: {
                ((c)this.receiver).getClass();
                return Boolean.valueOf(!Looper.getMainLooper().isCurrentThread());
            }
            case 19: {
                A a0 = (A)this.receiver;
                String s = a0.getString(0x7F1300DA);  // string:alert_dlg_title_select_photo "사진 선택"
                q.f(s, "getString(...)");
                a0.sendUserEvent(new f0(null, null, (a0.getContext() == null ? null : "페이지이동"), (a0.getContext() == null ? null : "채팅"), (a0.getContext() == null ? null : "사진보내기"), new Builder().id(((M0)a0.getViewModel()).g().e).type((a0.getContext() == null ? null : "뮤직웨이브")).name(((M0)a0.getViewModel()).g().b).build(), 3));
                l0 l00 = a0.getChildFragmentManager();
                String s1 = a0.getString(0x7F1300DA);  // string:alert_dlg_title_select_photo "사진 선택"
                q.f(s1, "getString(...)");
                com.melon.ui.popup.b.h(l00, s1, new w(s, false), new i(a0, 9));
                return h0;
            }
            case 20: {
                ((MusicBrowserActivity)this.receiver).handleScreenCapture();
                return h0;
            }
            case 21: {
                ((ComposeViewAdapter)this.receiver).requestLayout();
                return h0;
            }
            case 22: {
                return ((K1)this.receiver).getCurrentPlayable();
            }
            case 23: {
                return ((od.b)this.receiver).c();
            }
            case 24: {
                return ((K1)this.receiver).getCurrentPlayable();
            }
            case 25: {
                return ((od.b)this.receiver).c();
            }
            case 26: {
                return ((t1)this.receiver).getCurrentPlayable();
            }
            case 27: {
                return ((t1)this.receiver).getCurrentPlayable();
            }
            case 28: {
                g g0 = (g)this.receiver;
                L l0 = g0.d;
                L l1 = g0.e;
                w0.u u1 = (w0.u)g0.c.get();
                if(u1 == null) {
                    Object[] arr_object = l1.b;
                    long[] arr_v = l1.a;
                    int v1 = arr_v.length - 2;
                    if(v1 >= 0) {
                        int v2 = 0;
                        while(true) {
                            long v3 = arr_v[v2];
                            if((~v3 << 7 & v3 & 0x8080808080808080L) == 0x8080808080808080L) {
                                goto label_100;
                            }
                            int v4 = 8 - (~(v2 - v1) >>> 0x1F);
                            for(int v5 = 0; v5 < v4; ++v5) {
                                if((v3 & 0xFFL) < 0x80L) {
                                    ((e)arr_object[(v2 << 3) + v5]).r(w0.t.d);
                                }
                                v3 >>= 8;
                            }
                            if(v4 == 8) {
                            label_100:
                                if(v2 != v1) {
                                    ++v2;
                                    continue;
                                }
                            }
                            break;
                        }
                    }
                }
                else if(u1.isAttached()) {
                    if(l0.c(u1)) {
                        u1.p0();
                    }
                    w0.t t0 = u1.o0();
                    if(!u1.getNode().isAttached()) {
                        M0.a.b("visitAncestors called on an unattached node");
                    }
                    p p0 = u1.getNode();
                    I i0 = P0.f.v(u1);
                    int v6 = 0;
                    while(i0 != null) {
                        if((((p)i0.b0.f).getAggregateChildKindSet$ui_release() & 0x1400) != 0) {
                            while(p0 != null) {
                                if((p0.getKindSet$ui_release() & 0x1400) != 0) {
                                    if((p0.getKindSet$ui_release() & 0x400) != 0) {
                                        ++v6;
                                    }
                                    if(p0 instanceof e && l1.c(p0)) {
                                        if(v6 <= 1) {
                                            ((e)p0).r(t0);
                                        }
                                        else {
                                            ((e)p0).r(w0.t.b);
                                        }
                                        l1.l(p0);
                                    }
                                }
                                p0 = p0.getParent$ui_release();
                            }
                        }
                        i0 = i0.u();
                        if(i0 != null) {
                            d0 d00 = i0.b0;
                            if(d00 != null) {
                                p0 = (A0)d00.e;
                                continue;
                            }
                        }
                        p0 = null;
                    }
                    Object[] arr_object1 = l1.b;
                    long[] arr_v1 = l1.a;
                    int v7 = arr_v1.length - 2;
                    if(v7 >= 0) {
                        int v8 = 0;
                        while(true) {
                            long v9 = arr_v1[v8];
                            if((~v9 << 7 & v9 & 0x8080808080808080L) != 0x8080808080808080L) {
                                int v10 = 8 - (~(v8 - v7) >>> 0x1F);
                                for(int v11 = 0; v11 < v10; ++v11) {
                                    if((v9 & 0xFFL) < 0x80L) {
                                        ((e)arr_object1[(v8 << 3) + v11]).r(w0.t.d);
                                    }
                                    v9 >>= 8;
                                }
                                if(v10 == 8) {
                                    goto label_150;
                                }
                                break;
                            }
                        label_150:
                            if(v8 == v7) {
                                break;
                            }
                            ++v8;
                        }
                    }
                }
                g0.b.invoke();
                l0.b();
                l1.b();
                g0.f = false;
                return h0;
            }
            default: {
                w0.k k0 = (w0.k)this.receiver;
                if(k0.l == null || k0.f.o0() == w0.t.d) {
                    k0.c.invoke();
                }
                return h0;
            }
        }
    }
}

