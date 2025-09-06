package wd;

import Cb.j;
import Md.l;
import Pa.d;
import Pa.e;
import Pa.f;
import Pa.g;
import Pa.h;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.utils.TimeExpiredCache;
import com.melon.ui.t4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

public final class s implements FlowCollector {
    public final t a;

    public s(t t0) {
        this.a = t0;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        if(!(((h)object0) instanceof e)) {
            t t0 = this.a;
            if(((h)object0) instanceof f) {
                if(j.c(((f)(((h)object0))).a)) {
                    TimeExpiredCache.getInstance().removeLike(("M20001".equals(t0.c) ? MelonContentUris.J0 : MelonContentUris.O0).toString());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.X.toString());
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Y.toString());
                    l.a(("M20001".equals(t0.c) ? Md.f.b : Md.f.c));
                }
                j.b(((f)(((h)object0))).a, false, 3);
                return H.a;
            }
            if(((h)object0) instanceof g) {
                t0.sendUiEvent(new t4(t0.b.a(((g)(((h)object0))).a)));
                return H.a;
            }
            if(!(((h)object0) instanceof d)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        return H.a;
    }
}

