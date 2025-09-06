package i.n.i.b.a.s.e;

import U4.x;
import android.text.TextUtils;

public final class H9 {
    public final String a;
    public final u b;
    public final u c;
    public final int d;
    public final int e;

    public H9(String s, u u0, u u1, int v, int v1) {
        M7.u(v == 0 || v1 == 0);
        if(TextUtils.isEmpty(s)) {
            throw new IllegalArgumentException();
        }
        this.a = s;
        u0.getClass();
        this.b = u0;
        u1.getClass();
        this.c = u1;
        this.d = v;
        this.e = v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return H9.class == class0 && this.d == ((H9)object0).d && this.e == ((H9)object0).e && this.a.equals(((H9)object0).a) && this.b.equals(((H9)object0).b) && this.c.equals(((H9)object0).c);
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.c.hashCode() + (this.b.hashCode() + x.b(((this.d + 0x20F) * 0x1F + this.e) * 0x1F, 0x1F, this.a)) * 0x1F;
    }
}

