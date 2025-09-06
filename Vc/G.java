package Vc;

import androidx.compose.runtime.b0;
import com.iloen.melon.utils.StringUtils;
import com.melon.playlist.mixup.DjMalrangInfo;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import oe.i;
import p0.p;
import we.a;
import we.n;

public final class g extends i implements n {
    public final b0 B;
    public final p D;
    public final boolean E;
    public final DjMalrangInfo G;
    public final b0 I;
    public final b0 M;
    public final b0 N;
    public final a S;
    public int r;
    public final b0 w;

    public g(b0 b00, b0 b01, p p0, boolean z, DjMalrangInfo djMalrangInfo0, b0 b02, b0 b03, b0 b04, a a0, Continuation continuation0) {
        this.w = b00;
        this.B = b01;
        this.D = p0;
        this.E = z;
        this.G = djMalrangInfo0;
        this.I = b02;
        this.M = b03;
        this.N = b04;
        this.S = a0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new g(this.w, this.B, this.D, this.E, this.G, this.I, this.M, this.N, this.S, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((g)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        ne.a a0 = ne.a.a;
        boolean z = this.E;
        p p0 = this.D;
        b0 b00 = this.B;
        b0 b01 = this.w;
        String s = "";
        String s1 = null;
        DjMalrangInfo djMalrangInfo0 = this.G;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                b01.setValue(Boolean.FALSE);
                b00.setValue(Boolean.FALSE);
                p0.clear();
                if(!z) {
                    this.r = 1;
                    if(DelayKt.delay(300L, this) == a0) {
                        return a0;
                    }
                }
                goto label_19;
            }
            case 1: {
                d5.n.D(object0);
            label_19:
                String s2 = djMalrangInfo0 == null ? null : djMalrangInfo0.a;
                p0.addAll(StringUtils.splitTextByMaxLengthAndLines$default(StringUtils.INSTANCE, (s2 == null ? "" : s2), 16, 3, false, 8, null));
                b00.setValue(Boolean.TRUE);
                if(!z) {
                    this.r = 2;
                    if(DelayKt.delay(300L, this) == a0) {
                        return a0;
                    }
                }
                goto label_27;
            }
            case 2: {
                d5.n.D(object0);
            label_27:
                String s3 = djMalrangInfo0 == null ? null : djMalrangInfo0.d;
                if(s3 == null) {
                    s3 = "";
                }
                this.I.setValue(s3);
                String s4 = djMalrangInfo0 == null ? null : djMalrangInfo0.b;
                if(s4 == null) {
                    s4 = "";
                }
                this.M.setValue(s4);
                if(djMalrangInfo0 != null) {
                    s1 = djMalrangInfo0.c;
                }
                if(s1 != null) {
                    s = s1;
                }
                this.N.setValue(s);
                b01.setValue(Boolean.TRUE);
                this.r = 3;
                if(DelayKt.delay(300L, this) == a0) {
                    return a0;
                }
                goto label_45;
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
    label_45:
        a a1 = this.S;
        if(a1 != null) {
            a1.invoke();
        }
        return H.a;
    }
}

