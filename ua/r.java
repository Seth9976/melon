package Ua;

import Ac.A1;
import Ac.U3;
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

public final class r extends i implements n {
    public final CommentConfig B;
    public final CommentUiModel D;
    public final kotlin.jvm.internal.n E;
    public final d G;
    public final Y1 I;
    public int r;
    public final N w;

    public r(N n0, CommentConfig commentConfig0, CommentUiModel commentUiModel0, k k0, d d0, Y1 y10, Continuation continuation0) {
        this.w = n0;
        this.B = commentConfig0;
        this.D = commentUiModel0;
        this.E = (kotlin.jvm.internal.n)k0;
        this.G = d0;
        this.I = y10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new r(this.w, this.B, this.D, ((k)this.E), this.G, this.I, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        CommentConfig commentConfig0 = this.B;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                this.r = 1;
                object0 = this.w.d(commentConfig0.getChannelSeq(), commentConfig0.getContentRefValue(), commentConfig0.getParentCommentSeq(), this.D.getCommentSeq(), this);
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
        d d0 = this.G;
        kotlin.jvm.internal.n n0 = this.E;
        if(((Q)object0) instanceof P) {
            ((k)n0).invoke(new t4(((StringProviderImpl)d0).a(0x7F1301DF)));  // string:cmt_delete_success "삭제되었습니다."
            U3 u30 = new U3(commentConfig0.getParentCommentSeq(), commentConfig0.getChannelSeq(), false, commentConfig0.getContentRefValue());
            this.I.invoke(u30);
            ((k)n0).invoke(new A1(u30));
            return H.a;
        }
        if(!(((Q)object0) instanceof O)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        String s = ((O)(((Q)object0))).b;
        if("405".equals(((O)(((Q)object0))).c)) {
            u.a(s, d0, ((k)n0));
            return H.a;
        }
        if(s == null) {
            s = ((StringProviderImpl)d0).a(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        }
        ((k)n0).invoke(new t4(s));
        return H.a;
    }
}

