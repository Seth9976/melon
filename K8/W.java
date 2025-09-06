package k8;

import a7.c;
import b.l;
import com.iloen.melon.LoginUser;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import oe.i;
import we.n;

public final class w extends i implements n {
    public Object r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new w(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((w)this.create(((LoginUser)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        LoginUser loginUser0 = (LoginUser)this.r;
        d5.n.D(object0);
        c c0 = c.a();
        String s = u.w(loginUser0);
        if(s == null) {
            s = "";
        }
        l l0 = new l(27, c0.a, s);
        c0.a.o.a.a(l0);
        return H.a;
    }
}

