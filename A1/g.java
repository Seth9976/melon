package a1;

import androidx.collection.y;
import g1.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import je.p;
import je.w;
import kotlin.jvm.internal.q;

public final class g implements CharSequence {
    public final List a;
    public final String b;
    public final ArrayList c;
    public final ArrayList d;
    public static final int e;

    static {
    }

    public g(String s) {
        this(s, w.a);
    }

    public g(String s, List list0) {
        Collection collection0 = list0;
        if(collection0.isEmpty()) {
            collection0 = null;
        }
        this(((List)collection0), s);
    }

    public g(List list0, String s) {
        ArrayList arrayList1;
        ArrayList arrayList0;
        this.a = list0;
        this.b = s;
        List list1 = null;
        if(list0 == null) {
            arrayList0 = null;
            arrayList1 = null;
        }
        else {
            int v = list0.size();
            arrayList0 = null;
            arrayList1 = null;
            for(int v1 = 0; v1 < v; ++v1) {
                e e0 = (e)list0.get(v1);
                Object object0 = e0.a;
                if(object0 instanceof M) {
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    arrayList0.add(e0);
                }
                else if(object0 instanceof D) {
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    arrayList1.add(e0);
                }
            }
        }
        this.c = arrayList0;
        this.d = arrayList1;
        if(arrayList1 != null) {
            list1 = p.J0(arrayList1, new f(0));
        }
        if(list1 != null && !list1.isEmpty()) {
            int v2 = ((e)p.k0(list1)).c;
            y y0 = new y(1);
            y0.a(v2);
            int v3 = list1.size();
            for(int v4 = 1; v4 < v3; ++v4) {
                e e1 = (e)list1.get(v4);
                while(y0.b != 0) {
                    int v5 = y0.d();
                    int v6 = e1.c;
                    if(e1.b >= v5) {
                        y0.e(y0.b - 1);
                    }
                    else {
                        if(v6 <= v5) {
                            break;
                        }
                        a.a(("Paragraph overlap not allowed, end " + v6 + " should be less than or equal to " + v5));
                        if(true) {
                            break;
                        }
                    }
                }
                y0.a(e1.c);
            }
        }
    }

    public final List a(int v) {
        List list0 = this.a;
        if(list0 != null) {
            List list1 = new ArrayList(list0.size());
            int v1 = list0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                Object object0 = list0.get(v2);
                e e0 = (e)object0;
                if(e0.a instanceof a1.w && i.b(0, v, e0.b, e0.c)) {
                    ((ArrayList)list1).add(object0);
                }
            }
            return list1;
        }
        return w.a;
    }

    public final g b(int v, int v1) {
        if(v > v1) {
            a.a(("start (" + v + ") should be less or equal to end (" + v1 + ')'));
        }
        String s = this.b;
        if(v == 0 && v1 == s.length()) {
            return this;
        }
        String s1 = s.substring(v, v1);
        q.f(s1, "substring(...)");
        if(v > v1) {
            a.a(("start (" + v + ") should be less than or equal to end (" + v1 + ')'));
        }
        List list0 = this.a;
        if(list0 != null) {
            ArrayList arrayList0 = new ArrayList(list0.size());
            int v3 = list0.size();
            for(int v2 = 0; v2 < v3; ++v2) {
                e e0 = (e)list0.get(v2);
                int v4 = e0.c;
                if(i.b(v, v1, e0.b, v4)) {
                    arrayList0.add(new e(e0.d, Math.max(v, e0.b) - v, Math.min(v1, v4) - v, e0.a));
                }
            }
            return arrayList0.isEmpty() ? new g(null, s1) : new g(arrayList0, s1);
        }
        return new g(null, s1);
    }

    @Override
    public final char charAt(int v) {
        return this.b.charAt(v);
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof g)) {
            return false;
        }
        return q.b(this.b, ((g)object0).b) ? q.b(this.a, ((g)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        int v = this.b.hashCode();
        return this.a == null ? v * 0x1F : v * 0x1F + this.a.hashCode();
    }

    @Override
    public final int length() {
        return this.b.length();
    }

    @Override
    public final CharSequence subSequence(int v, int v1) {
        return this.b(v, v1);
    }

    @Override
    public final String toString() {
        return this.b;
    }
}

