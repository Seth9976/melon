package A6;

import I6.V;
import I6.p0;
import M6.s;
import M6.x;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.media3.session.Q;
import androidx.media3.session.b0;
import androidx.media3.session.t;
import androidx.media3.session.w1;
import b3.P;
import b3.i0;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventResponseMessage.failMessage;
import com.iloen.melon.push.fcm.FcmHelper;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d2.n;
import e3.b;
import e3.j;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.q;

public final class e implements b0, OnCompleteListener, n, j {
    public final int a;
    public final int b;
    public final Object c;

    public e(int v, p0 p00, int v1) {
        this.a = v1;
        this.b = v;
        this.c = p00;
        super();
    }

    public e(Object object0, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.b = v;
        super();
    }

    @Override  // androidx.media3.session.b0
    public void b(Q q0) {
        if(this.a != 2) {
            List list0 = (List)this.c;
            if(q0.isConnected()) {
                p0 p00 = q0.q;
                q0.o = V.p(list0);
                p0 p01 = Q.u0(q0.p, list0, q0.r, q0.u);
                q0.q = p01;
                boolean z = Objects.equals(p01, p00);
                q0.a.getClass();
                b.j(Looper.myLooper() == q0.a.e.getLooper());
                t t0 = q0.a.d;
                t0.getClass();
                x x0 = com.google.firebase.b.I(new w1(-6));
                if(!z) {
                    t0.a();
                }
                x0.addListener(new androidx.media3.exoplayer.V(q0, x0, this.b, 1), s.a);
            }
            return;
        }
        V v0 = (V)this.c;
        if(q0.isConnected()) {
            p0 p02 = q0.q;
            q0.p = V.p(v0);
            p0 p03 = Q.u0(v0, q0.o, q0.r, q0.u);
            q0.q = p03;
            boolean z1 = Objects.equals(p03, p02);
            q0.a.getClass();
            b.j(Looper.myLooper() == q0.a.e.getLooper());
            t t1 = q0.a.d;
            t1.getClass();
            x x1 = com.google.firebase.b.I(new w1(-6));
            if(!z1) {
                t1.a();
            }
            x1.addListener(new androidx.media3.exoplayer.V(q0, x1, this.b, 1), s.a);
        }
    }

    @Override  // e3.j
    public void invoke(Object object0) {
        if(this.a != 1) {
            ((P)object0).s0(((i0)this.c).t, this.b);
            return;
        }
        ((P)object0).s0(((androidx.media3.exoplayer.b0)this.c).a, this.b);
    }

    @Override  // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task0) {
        Context context0 = (Context)this.c;
        q.g(task0, "task");
        String s = "";
        if(task0.isSuccessful()) {
            String s1 = (String)task0.getResult();
            if(s1 != null) {
                s = s1;
            }
        }
        LogU.Companion.w("FcmHelper", "refreshedToken: " + s);
        if(!TextUtils.isEmpty(s)) {
            FcmHelper.sendRegistrationToServer(context0, s);
            return;
        }
        if(this.b != 2 && this.b != 3) {
            return;
        }
        EventBusHelper.post(new failMessage());
        ToastManager.show(0x7F1303C1);  // string:error_delay_network "접속이 지연되고 있습니다.\n잠시 후 다시 이용해주세요."
    }

    @Override  // d2.n
    public boolean t(View view0) {
        ((SideSheetBehavior)this.c).w(this.b);
        return true;
    }
}

