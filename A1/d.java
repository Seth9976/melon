package a1;

import g1.a;
import java.util.ArrayList;
import java.util.List;

public final class d implements Appendable {
    public final StringBuilder a;
    public final ArrayList b;
    public final ArrayList c;

    public d() {
        this(16);
    }

    public d(int v) {
        this.a = new StringBuilder(v);
        this.b = new ArrayList();
        this.c = new ArrayList();
        new ArrayList();
    }

    public d(g g0) {
        this.b(g0);
    }

    public final void a(M m0, int v, int v1) {
        c c0 = new c(m0, v, v1, 8);
        this.c.add(c0);
    }

    @Override
    public final Appendable append(char c) {
        this.a.append(c);
        return this;
    }

    @Override
    public final Appendable append(CharSequence charSequence0) {
        this.c(charSequence0);
        return this;
    }

    @Override
    public final Appendable append(CharSequence charSequence0, int v, int v1) {
        StringBuilder stringBuilder0 = this.a;
        if(charSequence0 instanceof g) {
            int v2 = stringBuilder0.length();
            stringBuilder0.append(((g)charSequence0).b, v, v1);
            List list0 = i.a(((g)charSequence0), v, v1, null);
            if(list0 != null) {
                int v3 = list0.size();
                for(int v4 = 0; v4 < v3; ++v4) {
                    e e0 = (e)list0.get(v4);
                    c c0 = new c(e0.d, e0.b + v2, e0.c + v2, e0.a);
                    this.c.add(c0);
                }
            }
            return this;
        }
        stringBuilder0.append(charSequence0, v, v1);
        return this;
    }

    public final void b(g g0) {
        int v = this.a.length();
        this.a.append(g0.b);
        List list0 = g0.a;
        if(list0 != null) {
            int v1 = list0.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                e e0 = (e)list0.get(v2);
                c c0 = new c(e0.d, e0.b + v, e0.c + v, e0.a);
                this.c.add(c0);
            }
        }
    }

    public final void c(CharSequence charSequence0) {
        if(charSequence0 instanceof g) {
            this.b(((g)charSequence0));
            return;
        }
        this.a.append(charSequence0);
    }

    public final void d(String s) {
        this.a.append(s);
    }

    public final void e() {
        ArrayList arrayList0 = this.b;
        if(arrayList0.isEmpty()) {
            a.c("Nothing to pop.");
        }
        c c0 = (c)arrayList0.remove(arrayList0.size() - 1);
        c0.c = this.a.length();
    }

    public final void f(int v) {
        ArrayList arrayList0 = this.b;
        if(v >= arrayList0.size()) {
            a.c((v + " should be less than " + arrayList0.size()));
        }
        while(arrayList0.size() - 1 >= v) {
            this.e();
        }
    }

    public final int g(M m0) {
        c c0 = new c(m0, this.a.length(), 0, 12);
        this.b.add(c0);
        this.c.add(c0);
        return this.b.size() - 1;
    }

    public final g h() {
        StringBuilder stringBuilder0 = this.a;
        String s = stringBuilder0.toString();
        ArrayList arrayList0 = this.c;
        ArrayList arrayList1 = new ArrayList(arrayList0.size());
        int v = arrayList0.size();
        for(int v1 = 0; v1 < v; ++v1) {
            arrayList1.add(((c)arrayList0.get(v1)).a(stringBuilder0.length()));
        }
        return new g(s, arrayList1);
    }
}

