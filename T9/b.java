package t9;

import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsManager.PostParam;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class b extends i implements n {
    public final d B;
    public Object r;
    public final SnsManager.PostParam w;

    public b(SnsManager.PostParam snsManager$PostParam0, d d0, Continuation continuation0) {
        this.w = snsManager$PostParam0;
        this.B = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new b(this.w, this.B, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
        d5.n.D(object0);
        SnsManager.PostParam snsManager$PostParam0 = this.w;
        if(snsManager$PostParam0 != null) {
            Sharable sharable0 = snsManager$PostParam0.c;
            if(sharable0 != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, null, new a(sharable0.getShareGatePageUrl(F.a.B(SnsManager.SnsType.a), true), snsManager$PostParam0.b, this.B, null), 3, null);
            }
        }
        return H.a;
    }
}

