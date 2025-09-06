package Ua;

import Ac.S3;
import Ac.Y1;
import Pc.d;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.t4;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class s extends i implements n {
    public final CommentConfig B;
    public final CommentUiModel D;
    public final boolean E;
    public final Y1 G;
    public final kotlin.jvm.internal.n I;
    public final d M;
    public int r;
    public final N w;

    public s(N n0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, boolean z, Y1 y10, k k0, d d0, Continuation continuation0) {
        this.w = n0;
        this.B = commentConfig0;
        this.D = commentUiModel0;
        this.E = z;
        this.G = y10;
        this.I = (kotlin.jvm.internal.n)k0;
        this.M = d0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new s(this.w, this.B, this.D, this.E, this.G, ((k)this.I), this.M, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((s)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = this.w.q(this.B.getChannelSeq(), this.B.getContentRefValue(), this.D.getCommentSeq(), this.E, this);
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
            S3 s30 = new S3();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.G.invoke(s30);
            return H.a;
        }
        if(!(((Q)object0) instanceof O)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        String s = ((O)(((Q)object0))).b;
        if(s == null) {
            s = ((StringProviderImpl)this.M).a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        t4 t40 = new t4(s);
        ((k)this.I).invoke(t40);
        return H.a;
    }
}

