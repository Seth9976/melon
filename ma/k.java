package Ma;

import Cc.U3;
import G.N;
import Pb.a;
import Qc.u;
import U4.F;
import U8.r;
import Vc.z;
import X0.x;
import android.content.Context;
import android.widget.ImageView;
import androidx.media3.session.v;
import com.melon.ui.K4;
import dc.g;
import ie.H;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.q;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient.Builder;
import q8.c;
import y8.l;

public final class k implements we.k {
    public final int a;

    public k(int v) {
        this.a = v;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        boolean z = false;
        r r0 = null;
        H h0 = H.a;
        switch(this.a) {
            case 0: {
                q.g(((Builder)object0), "$this$ApiClient");
                ((Builder)object0).connectionPool(new ConnectionPool(5, 5L, TimeUnit.SECONDS));
                g.a.getClass();
                ((Builder)object0).eventListener(g.a);
                return h0;
            }
            case 1: {
                q.g(((Throwable)object0), "it");
                return h0;
            }
            case 2: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a.put("menuid", "1000003153");
                return h0;
            }
            case 3: {
                q.g(((c)object0), "$this$customProps");
                ((c)object0).a.put("menuid", "1000003139");
                return h0;
            }
            case 4: {
                q.g(((x)object0), "$this$semantics");
                return h0;
            }
            case 5: {
                q.g(((x)object0), "$this$semantics");
                return h0;
            }
            case 6: {
                q.g(((v)object0), "$this$executeAwaitPrepareWithResult");
                return F.V(((v)object0), a.b);
            }
            case 7: {
                q.g(((K4)object0), "it");
                return Boolean.valueOf(((K4)object0) instanceof u);
            }
            case 8: {
                q.g(((K4)object0), "it");
                return Boolean.valueOf(((K4)object0) instanceof u);
            }
            case 9: {
                q.g(((Context)object0), "context");
                return new ImageView(((Context)object0));
            }
            case 10: {
                q.g(((Sf.k)object0), "it");
                return ((Sf.k)object0).iterator();
            }
            case 11: {
                return object0;
            }
            case 12: {
                if(object0 == null) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            case 13: {
                q.g(((K4)object0), "it");
                r r1 = ((K4)object0) instanceof r ? ((r)(((K4)object0))) : null;
                if(r1 != null) {
                    r0 = r.a(r1, false, 0, false, 0, l.c(), null, 0x37F);
                }
                q.e(r0, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r0;
            }
            case 14: {
                q.g(((K4)object0), "it");
                r r2 = ((K4)object0) instanceof r ? ((r)(((K4)object0))) : null;
                if(r2 != null) {
                    r0 = r.a(r2, false, 0, l.e(), 0, null, null, 0x3FB);
                }
                q.e(r0, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r0;
            }
            case 15: {
                q.g(((K4)object0), "it");
                r r3 = ((K4)object0) instanceof r ? ((r)(((K4)object0))) : null;
                if(r3 != null) {
                    r0 = r.a(r3, false, 0, false, 0, null, null, 0x3F3);
                }
                q.e(r0, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r0;
            }
            case 16: {
                q.g(((K4)object0), "it");
                r r4 = ((K4)object0) instanceof r ? ((r)(((K4)object0))) : null;
                if(r4 != null) {
                    r0 = r.a(r4, false, 0, false, 0, l.c(), null, 0x37F);
                }
                q.e(r0, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r0;
            }
            case 17: {
                q.g(((K4)object0), "it");
                r r5 = ((K4)object0) instanceof r ? ((r)(((K4)object0))) : null;
                if(r5 != null) {
                    r0 = r.a(r5, false, 0, false, 0, null, U3.a(((r)(((K4)object0))).j, 0, false, 0, 29), 0x1FF);
                }
                q.e(r0, "null cannot be cast to non-null type com.melon.ui.UiState");
                return r0;
            }
            case 18: {
                q.g(((x)object0), "$this$semantics");
                X0.v.a(((x)object0));
                return h0;
            }
            case 19: {
                q.g(((StringBuilder)object0), "$this$buildDebug");
                ((StringBuilder)object0).append("clearRangeRepeat()");
                return h0;
            }
            case 20: {
                q.g(((N)object0), "$this$keyframes");
                ((N)object0).a = 100;
                return h0;
            }
            case 21: {
                q.g(((N)object0), "$this$keyframes");
                ((N)object0).a = 300;
                return h0;
            }
            case 22: {
                q.g(((N)object0), "$this$keyframes");
                ((N)object0).a = 300;
                return h0;
            }
            case 23: {
                q.g(((N)object0), "$this$keyframes");
                ((N)object0).a = 300;
                return h0;
            }
            case 24: {
                q.g(((x)object0), "$this$semantics");
                X0.u.e(((x)object0));
                return h0;
            }
            case 25: {
                q.g(((z)object0), "it");
                return ((z)object0).c;
            }
            case 26: {
                q.g(((x)object0), "$this$semantics");
                X0.u.k(((x)object0), 0);
                return h0;
            }
            case 27: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
            case 28: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
            default: {
                q.g(((x)object0), "$this$clearAndSetSemantics");
                return h0;
            }
        }
    }
}

