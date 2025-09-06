package hf;

import ie.H;
import kotlin.jvm.internal.q;
import we.k;

public final class j implements k {
    public final int a;
    public final String b;
    public final String c;

    public j(String s, String s1, int v) {
        this.a = v;
        this.b = s;
        this.c = s1;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        o o0 = (o)object0;
        switch(this.a) {
            case 0: {
                q.g(o0, "$this$function");
                o0.a(this.b, new d[]{l.b});
                o0.a(this.c, new d[]{l.b, l.b, l.a, l.a});
                o0.b(this.b, new d[]{l.a});
                return H.a;
            }
            case 1: {
                q.g(o0, "$this$function");
                o0.a(this.b, new d[]{l.b});
                o0.a(this.c, new d[]{l.b, l.b, l.b});
                o0.b(this.b, new d[]{l.b});
                return H.a;
            }
            case 2: {
                q.g(o0, "$this$function");
                o0.a(this.b, new d[]{l.b});
                o0.a(this.c, new d[]{l.b, l.b, l.c, l.a});
                o0.b(this.b, new d[]{l.a});
                return H.a;
            }
            case 3: {
                q.g(o0, "$this$function");
                o0.a(this.b, new d[]{l.b});
                o0.a(this.b, new d[]{l.c});
                o0.a(this.c, new d[]{l.b, l.c, l.c, l.a});
                o0.b(this.b, new d[]{l.a});
                return H.a;
            }
            case 4: {
                q.g(o0, "$this$function");
                o0.a(this.b, new d[]{l.c});
                o0.b(this.c, new d[]{l.b, l.c});
                return H.a;
            }
            default: {
                q.g(o0, "$this$function");
                o0.a(this.b, new d[]{l.a});
                o0.b(this.c, new d[]{l.b, l.c});
                return H.a;
            }
        }
    }
}

