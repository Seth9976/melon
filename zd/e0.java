package zd;

import A7.d;
import android.graphics.Bitmap;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class e0 extends m {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Bitmap e;
    public final Bitmap f;
    public final String g;

    public e0(String s, String s1, String s2, String s3, Bitmap bitmap0, Bitmap bitmap1, String s4) {
        q.g(s2, "subTitle");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = bitmap0;
        this.f = bitmap1;
        this.g = s4;
    }

    @Override  // zd.m
    public final String a() {
        return this.a == null ? "" : this.a;
    }

    // 去混淆评级： 低(30)
    @Override  // zd.m
    public final String b() {
        q.f("N10078", "code(...)");
        return "N10078";
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
        if(!(object0 instanceof e0)) {
            return false;
        }
        if(!q.b(this.a, ((e0)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((e0)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((e0)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((e0)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((e0)object0).e)) {
            return false;
        }
        return q.b(this.f, ((e0)object0).f) ? q.b(this.g, ((e0)object0).g) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 19;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = U4.x.b(((this.a == null ? 0 : this.a.hashCode()) * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c);
        int v2 = this.d == null ? 0 : this.d.hashCode();
        int v3 = this.e == null ? 0 : this.e.hashCode();
        int v4 = this.f == null ? 0 : this.f.hashCode();
        String s = this.g;
        if(s != null) {
            v = s.hashCode();
        }
        return (((v1 + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v;
    }

    @Override  // zd.m
    public final String p() {
        return this.d == null ? "" : this.d;
    }

    @Override  // zd.m
    public final String q() {
        return this.c;
    }

    @Override  // zd.Q
    public final String r() {
        return this.b == null ? "" : this.b;
    }

    @Override  // zd.m
    public final Object s() {
        String s = this.g;
        return s != null && s.length() != 0 ? s : this.e;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("MixPlaylistDetailType(contsId=", this.a, ", title=", this.b, ", subTitle=");
        d.u(stringBuilder0, this.c, ", menuId=", this.d, ", thumbnail=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", bgImg=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", coverImgUrl=");
        return U4.x.m(stringBuilder0, this.g, ")");
    }
}

