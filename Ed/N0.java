package ed;

import Tf.o;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import oe.i;
import q2.b;
import q2.f;
import we.n;

public final class n0 extends i implements n {
    public Object r;
    public final String w;

    public n0(String s, Continuation continuation0) {
        this.w = s;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new n0(this.w, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((n0)this.create(((b)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        List list0;
        b b0 = (b)this.r;
        d5.n.D(object0);
        f f0 = k.a;
        String s = (String)b0.b(f0);
        String s1 = this.w;
        if(s != null && !o.H0(s)) {
            Pattern pattern0 = Pattern.compile(",");
            q.f(pattern0, "compile(...)");
            o.P0(0);
            Matcher matcher0 = pattern0.matcher(s);
            if(matcher0.find()) {
                ArrayList arrayList0 = new ArrayList(10);
                int v = 0;
                do {
                    v = androidx.appcompat.app.o.c(matcher0, s, v, arrayList0);
                }
                while(matcher0.find());
                androidx.appcompat.app.o.w(v, s, arrayList0);
                list0 = arrayList0;
            }
            else {
                list0 = e.k.z(s.toString());
            }
            if(list0.size() < 3) {
                s = s + "," + s1;
            }
            else if(!list0.contains(s1)) {
                String s2 = s.substring(o.F0(s, ",", 0, false, 6) + 1);
                q.f(s2, "substring(...)");
                s = s2 + "," + s1;
            }
            b0.h(f0, s);
            return H.a;
        }
        b0.h(f0, s1);
        return H.a;
    }
}

