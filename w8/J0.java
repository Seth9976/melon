package w8;

import D2.f;
import U4.y;
import android.content.Context;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.appwidget.CoverWidgetProgressBarWorker;
import ie.H;
import java.util.Set;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;
import y8.s;

public final class j0 extends i implements n {
    public final boolean r;
    public final f w;

    public j0(boolean z, f f0, Continuation continuation0) {
        this.r = z;
        this.w = f0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j0(this.r, this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        if(this.r) {
            q.g(this.w, "glanceId");
            s s0 = new s(CoverWidgetProgressBarWorker.class);
            String s1 = this.w.toString();
            q.g(s1, "tag");
            ((Set)s0.c).add(s1);
            y y0 = s0.b();
            MelonAppBase.Companion.getClass();
            Context context0 = t.a().getContext();
            q.g(context0, "context");
            V4.s.c0(context0).r("CoverWidgetProgressBarWorker", 1, y0);
        }
        return H.a;
    }
}

