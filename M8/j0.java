package m8;

import E9.h;
import Na.f;
import Td.b;
import android.app.Activity;
import com.iloen.melon.net.v4x.response.AuthLocationRes.Response;
import com.iloen.melon.net.v4x.response.AuthLocationRes;
import com.iloen.melon.utils.datastore.DjMalrangAgreementPopupDataStoreKt;
import com.iloen.melon.utils.datastore.DjMalrangLocationPreferenceKeys;
import db.d;
import db.g;
import ie.H;
import java.time.Duration;
import java.time.Instant;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import we.n;

public final class j0 extends i implements n {
    public int B;
    public final Activity D;
    public final c E;
    public final String G;
    public final boolean I;
    public int r;
    public long w;

    public j0(Activity activity0, c c0, String s, boolean z, Continuation continuation0) {
        this.D = activity0;
        this.E = c0;
        this.G = s;
        this.I = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j0(this.D, this.E, this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((j0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        long v3;
        int v2;
        boolean z1;
        a a0 = a.a;
        int v = this.B;
        boolean z = this.I;
        String s = this.G;
        Activity activity0 = this.D;
        switch(v) {
            case 0: {
                d5.n.D(object0);
                db.c c0 = (db.c)d.a.getValue();
                this.B = 1;
                object0 = ((g)c0).c(this);
                if(object0 == a0) {
                    return a0;
                }
                goto label_17;
            }
            case 1: {
                d5.n.D(object0);
            label_17:
                AuthLocationRes authLocationRes0 = (AuthLocationRes)h.H(((f)object0));
                if(authLocationRes0 == null) {
                    z1 = false;
                }
                else {
                    Response authLocationRes$Response0 = authLocationRes0.response;
                    z1 = authLocationRes$Response0 == null ? false : authLocationRes$Response0.isAgree;
                }
                long v1 = System.currentTimeMillis();
                Flow flow0 = DjMalrangAgreementPopupDataStoreKt.getDjMalrangAgreementPopupDataStore(activity0).getData();
                this.r = z1;
                this.w = v1;
                this.B = 2;
                Object object1 = FlowKt.first(flow0, this);
                if(object1 == a0) {
                    return a0;
                }
                v2 = z1;
                object0 = object1;
                v3 = v1;
                break;
            }
            case 2: {
                v3 = this.w;
                v2 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                if(v != 3) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                c.r1(activity0, false, false, s, z);
                return H.a;
            }
        }
        Long long0 = (Long)((q2.h)object0).b(DjMalrangLocationPreferenceKeys.INSTANCE.getLAST_SHOWN_TIMESTAMP());
        Instant instant0 = Instant.ofEpochMilli(v3);
        long v4 = Math.abs(Duration.between(Instant.ofEpochMilli((long0 == null ? 0L : ((long)long0))), instant0).toDays());
        if(v2 != 0) {
            if(!b.e(activity0, "android.permission.ACCESS_COARSE_LOCATION")) {
                b.b(activity0, 0x20, new J0.h(this.E, activity0, s, z));
                return H.a;
            }
            c.r1(activity0, true, true, s, z);
            return H.a;
        }
        if(v4 <= 180L) {
            c.r1(activity0, false, false, s, z);
            return H.a;
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new i0(activity0, null), 3, null);
        return H.a;
    }
}

