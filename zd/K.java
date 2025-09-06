package zd;

import java.util.ArrayList;

public final class k extends y0 {
    public final boolean a;
    public final boolean b;

    public k(boolean z, boolean z1) {
        this.a = z;
        this.b = z1;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        if(this.a) {
            if(!this.b) {
                arrayList0.add(x.k0);
            }
            arrayList0.add(x.l0);
            return arrayList0;
        }
        arrayList0.add(x.d0);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k && this.a == ((k)object0).a && this.b == ((k)object0).b;
    }

    @Override  // zd.Q
    public final int g() {
        return 26;
    }

    @Override
    public final int hashCode() {
        return Boolean.hashCode(this.b) + Boolean.hashCode(this.a) * 0x1F;
    }

    @Override
    public final String toString() {
        return "CommentBottomSheetType(isMyComment=" + this.a + ", isReply=" + this.b + ")";
    }
}

