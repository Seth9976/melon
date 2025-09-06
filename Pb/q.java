package pb;

import M6.B;
import com.iloen.melon.utils.log.LogU;
import e1.b;
import ie.H;
import java.util.ArrayList;
import kc.d3;
import kc.s2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.U;
import oc.w;
import oe.c;

public final class q {
    public final s2 a;

    public q(s2 s20) {
        kotlin.jvm.internal.q.g(s20, "playlistManager");
        super();
        this.a = s20;
    }

    public final Object a(String s, c c0) {
        ArrayList arrayList1;
        w w0;
        n n0;
        if(c0 instanceof n) {
            n0 = (n)c0;
            int v = n0.E;
            if((v & 0x80000000) == 0) {
                n0 = new n(this, c0);
            }
            else {
                n0.E = v ^ 0x80000000;
            }
        }
        else {
            n0 = new n(this, c0);
        }
        Object object0 = n0.B;
        a a0 = a.a;
        s2 s20 = this.a;
        H h0 = H.a;
        switch(n0.E) {
            case 0: {
                d5.n.D(object0);
                if(s == null) {
                    LogU.Companion.e("RemoveInCurrentPlaylistByPathUseCase", "path is null");
                    return h0;
                }
                w0 = ((d3)s20).k();
                if(w0 == null) {
                    return h0;
                }
                ArrayList arrayList0 = new ArrayList();
                o o0 = new o(b.B(w0.getState()), s, arrayList0, null);
                n0.r = w0;
                n0.w = arrayList0;
                n0.E = 1;
                if(BuildersKt.withContext(Dispatchers.getIO(), o0, n0) == a0) {
                    return a0;
                }
                arrayList1 = arrayList0;
                goto label_32;
            }
            case 1: {
                arrayList1 = n0.w;
                w0 = n0.r;
                d5.n.D(object0);
            label_32:
                if(arrayList1.isEmpty()) {
                    LogU.Companion.d("RemoveInCurrentPlaylistByPathUseCase", "removeIndices is empty.");
                    return h0;
                }
                B b0 = ((d3)s20).w(w0.getId(), arrayList1);
                n0.r = null;
                n0.w = null;
                n0.E = 2;
                object0 = ListenableFutureKt.await(b0, n0);
                if(object0 == a0) {
                    return a0;
                }
                LogU.Companion.d("RemoveInCurrentPlaylistByPathUseCase", "playlistRemoveResult: " + ((U)object0));
                return h0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
        LogU.Companion.d("RemoveInCurrentPlaylistByPathUseCase", "playlistRemoveResult: " + ((U)object0));
        return h0;
    }

    public final void b(String s) {
        ye.a.B(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, new p(this, s, null), 7);
    }
}

