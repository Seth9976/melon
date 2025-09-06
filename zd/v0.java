package zd;

import A7.d;
import androidx.appcompat.app.o;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class v0 extends m {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public v0(String s, String s1, boolean z, boolean z1, boolean z2) {
        q.g(s, "title");
        super();
        this.a = s;
        this.b = s1;
        this.c = z;
        this.d = z1;
        this.e = z2;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        if(this.c) {
            arrayList0.add(x.V);
            if(this.d && !this.e) {
                arrayList0.add(x.W);
            }
            return arrayList0;
        }
        arrayList0.add(x.U);
        arrayList0.add(x.d0);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof v0)) {
            return false;
        }
        if(!q.b(this.a, ((v0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((v0)object0).b)) {
            return false;
        }
        if(this.c != ((v0)object0).c) {
            return false;
        }
        return this.d == ((v0)object0).d ? this.e == ((v0)object0).e : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 0x1F;
    }

    @Override
    public final int hashCode() {
        int v = this.a.hashCode();
        return this.b == null ? Boolean.hashCode(this.e) + d.e(d.e(v * 961, 0x1F, this.c), 0x1F, this.d) : Boolean.hashCode(this.e) + d.e(d.e((v * 0x1F + this.b.hashCode()) * 0x1F, 0x1F, this.c), 0x1F, this.d);
    }

    @Override  // zd.Q
    public final String r() {
        return this.a;
    }

    @Override  // zd.m
    public final Object s() {
        return this.b;
    }

    @Override  // zd.m
    public final l t() {
        return l.d;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("ProfileBottomSheetType(title=", this.a, ", imgUrl=", this.b, ", isMyself=");
        U4.x.y(stringBuilder0, this.c, ", isDj=", this.d, ", isPowerDj=");
        return o.s(stringBuilder0, this.e, ")");
    }
}

