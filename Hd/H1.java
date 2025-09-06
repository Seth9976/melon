package hd;

import Pc.e;
import android.content.Context;
import android.net.Uri;
import com.iloen.melon.utils.FileUtils;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class h1 extends i implements n {
    public final e B;
    public final m1 r;
    public final Context w;

    public h1(m1 m10, Context context0, e e0, Continuation continuation0) {
        this.r = m10;
        this.w = context0;
        this.B = e0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new h1(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((h1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        N n0 = (N)this.B;
        Uri uri0 = FileUtils.INSTANCE.saveImageFile(this.w, n0.a, "melon_dna_", n0.b);
        m1 m10 = this.r;
        m10.m = uri0;
        H h0 = H.a;
        if(n0.b) {
            return h0;
        }
        m10.sendUiEvent(new L((uri0 == null ? 0x7F130752 : 0x7F130751)));  // string:musicdna_card_save_fail "DNA 카드 저장이 실패하였습니다."
        q.f("페이지이동", "getString(...)");
        m1.d(m10, "페이지이동", ActionKind.ClickContent, n0.c.c, null, n0.c.f, n0.c.g, null, n0.c.i, 664);
        return h0;
    }
}

