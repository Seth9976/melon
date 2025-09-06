package wa;

import Ba.D;
import Ba.G;
import Ba.H;
import E9.w;
import Me.e;
import Se.n;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import android.widget.EditText;
import android.widget.TextView;
import com.iloen.melon.custom.J0;
import com.iloen.melon.custom.PlaylistCreatingInputBarView;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.data.database.MelonDatabase_Impl;
import d5.c;
import e1.m;
import ea.d;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;
import wd.j;
import x2.g;
import x5.h;
import x5.i;
import x5.k;
import z3.b;
import z3.p;

public final class a implements J0, i, p {
    public final Object a;

    public a(D d0) {
        q.g(d0, "api");
        super();
        this.a = d0;
    }

    public a(G g0) {
        q.g(g0, "api");
        super();
        this.a = g0;
    }

    public a(H h0) {
        q.g(h0, "api");
        super();
        this.a = h0;
    }

    public a(EditText editText0) {
        this.a = new c(editText0);
    }

    public a(TextView textView0) {
        this.a = new g(textView0);
    }

    public a(Object object0) {
        this.a = object0;
        super();
    }

    @Override  // z3.p
    public void a() {
        b b0 = (b)this.a;
        Surface surface0 = b0.l1;
        if(surface0 != null) {
            ea.b b1 = b0.a1;
            Handler handler0 = (Handler)b1.a;
            if(handler0 != null) {
                handler0.post(new com.facebook.appevents.internal.a(3, SystemClock.elapsedRealtime(), b1, surface0));
            }
            b0.o1 = true;
        }
    }

    @Override  // x5.i
    public boolean b() {
        h h0 = h.a;
        k k0 = (k)this.a;
        synchronized(h0) {
            int v1 = h.c;
            h.c = v1 + 1;
            if(v1 >= 30 || SystemClock.uptimeMillis() > h.d + 30000L) {
                boolean z = false;
                h.c = 0;
                h.d = SystemClock.uptimeMillis();
                String[] arr_s = h.b.list();
                if(arr_s == null) {
                    arr_s = new String[0];
                }
                if(arr_s.length < 800) {
                    z = true;
                }
                h.e = z;
                if(!z && k0 != null) {
                    k.a("FileDescriptorCounter", 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + arr_s.length, null);
                }
            }
            return h.e;
        }
    }

    @Override  // z3.p
    public void c() {
        b b0 = (b)this.a;
        if(b0.l1 != null) {
            b0.E0(0, 1);
        }
    }

    @Override  // x5.i
    public boolean d(u5.g g0) {
        int v = 0x7FFFFFFF;
        if((g0.a instanceof u5.a ? ((u5.a)g0.a).e : 0x7FFFFFFF) > 100) {
            m m0 = g0.b;
            if(m0 instanceof u5.a) {
                v = ((u5.a)m0).e;
            }
            return v > 100;
        }
        return false;
    }

    public Integer e(List list0) {
        StringBuilder stringBuilder0 = Y.p("delete from premium_off_play_log where _id in ( ");
        a.a.k(list0.size(), stringBuilder0);
        stringBuilder0.append(" )");
        H8.c c0 = new H8.c(stringBuilder0.toString(), 14, list0);
        return new Integer(((int)(((Integer)w.N(((MelonDatabase_Impl)((d)((a)this.a).a).a), false, true, c0)))));
    }

    public e f(n n0) {
        q.g(n0, "javaClass");
        qf.c c0 = n0.c();
        Class class0 = n0.a.getDeclaringClass();
        n n1 = class0 == null ? null : new n(class0);
        if(n1 != null) {
            e e0 = this.f(n1);
            Af.p p0 = e0 == null ? null : e0.Z();
            Me.h h0 = p0 == null ? null : p0.c(n0.e(), Ue.c.h);
            return h0 instanceof e ? ((e)h0) : null;
        }
        if(c0 != null) {
            qf.c c1 = c0.b();
            df.q q0 = (df.q)je.p.m0(e.k.z(((cf.d)this.a).c(c1)));
            if(q0 != null) {
                q0.j.d.getClass();
                qf.e e1 = n0.e();
                return q0.j.d.v(e1, n0);
            }
        }
        return null;
    }

    @Override  // com.iloen.melon.custom.J0
    public boolean onComplete(PlaylistCreatingInputBarView playlistCreatingInputBarView0, String s) {
        q.g(s, "text");
        if(TextUtils.isEmpty(s)) {
            ToastManager.show(0x7F13034F);  // string:djplaylist_alert_input_title "제목을 입력해주세요."
            return true;
        }
        j j0 = new j(s);
        ((wd.b)this.a).sendUserEvent(j0);
        return true;
    }

    @Override  // com.iloen.melon.custom.J0
    public void onEditStart(PlaylistCreatingInputBarView playlistCreatingInputBarView0) {
    }

    @Override  // com.iloen.melon.custom.J0
    public void onEditStop(PlaylistCreatingInputBarView playlistCreatingInputBarView0) {
    }
}

