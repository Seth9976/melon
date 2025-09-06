package hd;

import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import q8.f;
import we.k;

public final class a1 implements k {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public a1(int v, String s, String s1, String s2, String s3) {
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = s3;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        String s = this.e;
        String s1 = this.d;
        String s2 = this.c;
        String s3 = this.b;
        switch(this.a) {
            case 0: {
                q.g(((a)object0), "$this$click");
                if(s3.length() > 0) {
                    ((a)object0).a = s3;
                }
                if(s2.length() > 0) {
                    ((a)object0).e = s2;
                }
                if(s1.length() > 0) {
                    ((a)object0).c = s1;
                }
                ((a)object0).g = s;
                return h0;
            }
            case 1: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = s2;
                ((f)object0).b = s1;
                ((f)object0).c = s;
                if(s3.length() > 0) {
                    ((f)object0).g = s3;
                }
                return h0;
            }
            case 2: {
                q.g(((a)object0), "$this$click");
                if(s3.length() > 0) {
                    ((a)object0).a = s3;
                }
                if(s2.length() > 0) {
                    ((a)object0).b = s2;
                }
                if(s1.length() > 0) {
                    ((a)object0).e = s1;
                }
                ((a)object0).g = s;
                return h0;
            }
            default: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = s3;
                ((f)object0).b = s2;
                ((f)object0).c = s1;
                ((f)object0).h = s;
                return h0;
            }
        }
    }
}

