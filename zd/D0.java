package zd;

import A7.d;
import android.graphics.Bitmap;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class d0 extends m {
    public final String a;
    public final String b;
    public final String c;
    public final Bitmap d;

    public d0(String s, String s1, String s2, Bitmap bitmap0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = bitmap0;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(x.e);
        arrayList0.add(x.c);
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof d0)) {
            return false;
        }
        if(!q.b(this.a, ((d0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((d0)object0).b)) {
            return false;
        }
        return q.b(this.c, ((d0)object0).c) ? q.b(this.d, ((d0)object0).d) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 21;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = U4.x.b((this.a == null ? 0 : this.a.hashCode()) * 0x1F, 0x1F, this.b);
        int v2 = this.c == null ? 0 : this.c.hashCode();
        Bitmap bitmap0 = this.d;
        if(bitmap0 != null) {
            v = bitmap0.hashCode();
        }
        return (v1 + v2) * 0x1F + v;
    }

    @Override  // zd.m
    public final String p() {
        return this.c == null ? "" : this.c;
    }

    @Override  // zd.m
    public final String q() {
        return this.b;
    }

    @Override  // zd.Q
    public final String r() {
        return this.a == null ? "" : this.a;
    }

    @Override  // zd.m
    public final Object s() {
        return this.d;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MixMakerPlaylistDetailType(title=", this.a, ", subTitle=", this.b, ", menuId=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", coverBitmap=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

