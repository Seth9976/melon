package Ac;

import Ua.O;
import Ua.P;
import Ua.Q;
import com.melon.net.res.v3.InformOembedRes.Result;
import com.melon.ui.t4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class f0 extends i implements n {
    public final String B;
    public int r;
    public final g0 w;

    public f0(g0 g00, String s, Continuation continuation0) {
        this.w = g00;
        this.B = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new f0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((f0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        g0 g00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = g00.b.k(this.B, this);
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
        if(((Q)object0) instanceof P) {
            Result informOembedRes$Result0 = (Result)((P)(((Q)object0))).a;
            String s = informOembedRes$Result0.getVideoTitle();
            String s1 = "";
            if(s == null) {
                s = "";
            }
            String s2 = informOembedRes$Result0.getThumbUrl() == null ? "" : informOembedRes$Result0.getThumbUrl();
            String s3 = informOembedRes$Result0.getVideoUrl();
            if(s3 != null) {
                s1 = s3;
            }
            g00.sendUiEvent(new e0(s, s2, s1));
            return H.a;
        }
        if(!(((Q)object0) instanceof O)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        String s4 = ((O)(((Q)object0))).b;
        if(s4 == null) {
            s4 = g00.c.a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        g00.sendUiEvent(new t4(s4));
        return H.a;
    }
}

