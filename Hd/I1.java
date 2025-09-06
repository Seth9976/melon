package hd;

import Na.f;
import Pc.e;
import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.sns.model.SharableMusicDna;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class i1 extends i implements n {
    public final Context B;
    public final e D;
    public int r;
    public final m1 w;

    public i1(m1 m10, Context context0, e e0, Continuation continuation0) {
        this.w = m10;
        this.B = context0;
        this.D = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new i1(this.w, this.B, this.D, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((i1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        e e0 = this.D;
        m1 m10 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Uri uri0 = m10.m;
                Object object1 = m10.i.getValue();
                T2.a a1 = f0.h(m10);
                this.r = 1;
                object0 = m10.b.a(this.B, uri0, ((String)object1), ((S)e0), a1, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((f)object0) instanceof Na.e) {
            m10.sendUiEvent(new K(((SharableMusicDna)((Na.e)(((f)object0))).a)));
            q.f("공유", "getString(...)");
            m1.d(m10, "공유", ActionKind.Share, ((S)e0).b.c, null, ((S)e0).b.f, ((S)e0).b.g, null, ((S)e0).b.i, 664);
            return H.a;
        }
        m10.sendUiEvent(new L(0x7F130752));  // string:musicdna_card_save_fail "DNA 카드 저장이 실패하였습니다."
        return H.a;
    }
}

