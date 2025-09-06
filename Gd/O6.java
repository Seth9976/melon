package gd;

import A7.d;
import U4.x;
import androidx.appcompat.app.o;
import com.iloen.melon.types.MelonLinkInfo;
import kotlin.jvm.internal.q;

public final class o6 {
    public final String a;
    public final int b;
    public final String c;
    public final MelonLinkInfo d;
    public final String e;
    public final String f;
    public final String g;

    public o6(String s, int v, String s1, MelonLinkInfo melonLinkInfo0, String s2, String s3, String s4) {
        this.a = s;
        this.b = v;
        this.c = s1;
        this.d = melonLinkInfo0;
        this.e = s2;
        this.f = s3;
        this.g = s4;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof o6)) {
            return false;
        }
        if(!q.b(this.a, ((o6)object0).a)) {
            return false;
        }
        if(this.b != ((o6)object0).b) {
            return false;
        }
        if(!q.b(this.c, ((o6)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((o6)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((o6)object0).e)) {
            return false;
        }
        return q.b(this.f, ((o6)object0).f) ? q.b(this.g, ((o6)object0).g) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = d.b(this.b, (this.a == null ? 0 : this.a.hashCode()) * 0x1F, 0x1F);
        int v2 = this.c == null ? 0 : this.c.hashCode();
        int v3 = this.d.hashCode();
        int v4 = this.e == null ? 0 : this.e.hashCode();
        int v5 = this.f == null ? 0 : this.f.hashCode();
        String s = this.g;
        if(s != null) {
            v = s.hashCode();
        }
        return (((v3 + (v1 + v2) * 0x1F) * 0x1F + v4) * 0x1F + v5) * 0x1F + v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = o.u(this.b, "MelonDjTagHubTabBannerItemData(imgUrl=", this.a, ", bgColor=", ", menuId=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", linkInfo=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", bannerSeq=");
        d.u(stringBuilder0, this.e, ", contsTypeCode=", this.f, ", contsId=");
        return x.m(stringBuilder0, this.g, ")");
    }
}

