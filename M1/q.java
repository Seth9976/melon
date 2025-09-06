package m1;

import A7.d;
import H0.b;
import java.util.ArrayList;
import je.p;
import je.u;
import q1.j;
import r1.k;

public final class q {
    public final String a;
    public final int b;
    public final k c;
    public final j d;
    public final ArrayList e;
    public final Object f;

    public q(String s, int v, k k0, j j0, ArrayList arrayList0, Object object0) {
        this.a = s;
        this.b = v;
        this.c = k0;
        this.d = j0;
        this.e = arrayList0;
        this.f = object0;
    }

    public final ArrayList a() {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = this.e;
        for(Object object0: arrayList1) {
            u.U(arrayList0, ((q)object0).a());
        }
        return p.A0(arrayList1, arrayList0);
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q && this.a.equals(((q)object0).a) && this.b == ((q)object0).b && kotlin.jvm.internal.q.b(this.c, ((q)object0).c) && kotlin.jvm.internal.q.b(this.d, ((q)object0).d) && this.e.equals(((q)object0).e) && kotlin.jvm.internal.q.b(this.f, ((q)object0).f);
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = b.a(this.e, ((this.c.hashCode() + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F)) * 0x1F + (this.d == null ? 0 : this.d.hashCode())) * 0x1F, 0x1F);
        Object object0 = this.f;
        if(object0 != null) {
            v = object0.hashCode();
        }
        return v1 + v;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("(");
        stringBuilder0.append(this.a);
        stringBuilder0.append(':');
        stringBuilder0.append(this.b);
        stringBuilder0.append(",\n            |bounds=(top=");
        k k0 = this.c;
        stringBuilder0.append(k0.b);
        stringBuilder0.append(", left=");
        stringBuilder0.append(k0.a);
        stringBuilder0.append(",\n            |location=");
        j j0 = this.d;
        if(j0 == null) {
            s = "<none>";
        }
        else {
            s = "(" + j0.b + 'L' + j0.c;
            if(s == null) {
                s = "<none>";
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append("\n            |bottom=");
        stringBuilder0.append(k0.d);
        stringBuilder0.append(", right=");
        stringBuilder0.append(k0.c);
        stringBuilder0.append("),\n            |childrenCount=");
        stringBuilder0.append(this.e.size());
        stringBuilder0.append(')');
        return Tf.p.d0(stringBuilder0.toString());
    }
}

