package jd;

import A8.M;
import Bb.b;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.melon.ui.s4;
import ie.H;
import java.io.Serializable;
import java.util.List;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import va.e0;
import va.o;
import we.n;

public final class s1 extends i implements n {
    public OpenType B;
    public b D;
    public String E;
    public int G;
    public final u1 I;
    public String r;
    public String w;

    public s1(u1 u10, Continuation continuation0) {
        this.I = u10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s1(this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s1)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        String s3;
        String s2;
        b b1;
        OpenType navigator$UrlOpenInto$OpenType1;
        String s;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.G) {
            case 0: {
                d5.n.D(object0);
                boolean z = ((e0)o.a()).m();
                u1 u10 = this.I;
                if(!z) {
                    u10.sendUiEvent(s4.a);
                    return h0;
                }
                s = M.v;
                OpenType navigator$UrlOpenInto$OpenType0 = OpenType.FullScreen;
                b b0 = b.a;
                String s1 = u10.getMenuId();
                this.r = "";
                this.w = s;
                this.B = navigator$UrlOpenInto$OpenType0;
                this.D = b0;
                this.E = s1;
                this.G = 1;
                Serializable serializable0 = u10.e(this);
                if(serializable0 == a0) {
                    return a0;
                }
                navigator$UrlOpenInto$OpenType1 = navigator$UrlOpenInto$OpenType0;
                object0 = serializable0;
                b1 = b0;
                s2 = s1;
                s3 = "";
                break;
            }
            case 1: {
                s2 = this.E;
                b1 = this.D;
                navigator$UrlOpenInto$OpenType1 = this.B;
                s = this.w;
                s3 = this.r;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Navigator.openUrl(s3, s, navigator$UrlOpenInto$OpenType1, b.b(b1, s2, ((List)object0)));
        return h0;
    }
}

