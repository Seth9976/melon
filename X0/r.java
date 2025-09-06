package X0;

import ie.H;
import ie.f;
import java.util.ArrayList;
import java.util.List;
import je.p;
import s0.e;
import s0.o;
import we.n;

public final class r extends kotlin.jvm.internal.r implements n {
    public static final r B;
    public static final r D;
    public static final r E;
    public static final r G;
    public final int f;
    public static final r g;
    public static final r h;
    public static final r i;
    public static final r j;
    public static final r k;
    public static final r l;
    public static final r m;
    public static final r n;
    public static final r o;
    public static final r r;
    public static final r w;

    static {
        r.g = new r(2, 0);
        r.h = new r(2, 1);
        r.i = new r(2, 2);
        r.j = new r(2, 3);
        r.k = new r(2, 4);
        r.l = new r(2, 5);
        r.m = new r(2, 6);
        r.n = new r(2, 7);
        r.o = new r(2, 8);
        r.r = new r(2, 9);
        r.w = new r(2, 10);
        r.B = new r(2, 11);
        r.D = new r(2, 12);
        r.E = new r(2, 13);
        r.G = new r(2, 14);
    }

    public r(int v, int v1) {
        this.f = v1;
        super(v);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        String s3;
        switch(this.f) {
            case 0: {
                e e0 = (e)object1;
                return (e)object0;
            }
            case 1: {
                if(((List)object0) != null) {
                    ArrayList arrayList0 = p.Q0(((List)object0));
                    arrayList0.addAll(((List)object1));
                    return arrayList0;
                }
                return (List)object1;
            }
            case 2: {
                o o0 = (o)object1;
                return (o)object0;
            }
            case 3: {
                H h0 = (H)object1;
                return (H)object0;
            }
            case 4: {
                H h1 = (H)object1;
                return (H)object0;
            }
            case 5: {
                H h2 = (H)object0;
                H h3 = (H)object1;
                throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
            }
            case 6: {
                H h4 = (H)object1;
                return (H)object0;
            }
            case 7: {
                String s = (String)object0;
                String s1 = (String)object1;
                throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
            }
            case 8: {
                i i0 = (i)object1;
                return (i)object0;
            }
            case 9: {
                String s2 = (String)object1;
                return (String)object0;
            }
            case 10: {
                if(((List)object0) != null) {
                    ArrayList arrayList1 = p.Q0(((List)object0));
                    arrayList1.addAll(((List)object1));
                    return arrayList1;
                }
                return (List)object1;
            }
            case 11: {
                ((Number)object1).floatValue();
                return (Float)object0;
            }
            case 12: {
                ((Boolean)object1).booleanValue();
                return (Boolean)object0;
            }
            case 13: {
                if(((a)object0) == null) {
                    s3 = ((a)object1).a;
                }
                else {
                    s3 = ((a)object0).a;
                    if(s3 == null) {
                        s3 = ((a)object1).a;
                    }
                }
                if(((a)object0) != null) {
                    f f0 = ((a)object0).b;
                    return f0 == null ? new a(s3, ((a)object1).b) : new a(s3, f0);
                }
                return new a(s3, ((a)object1).b);
            }
            default: {
                return object0 == null ? object1 : object0;
            }
        }
    }
}

