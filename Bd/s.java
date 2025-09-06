package bd;

import A7.d;
import U4.x;
import com.iloen.melon.net.v4x.common.HeaderBase;
import java.text.SimpleDateFormat;
import java.util.Locale;
import k8.Y;
import kotlin.jvm.internal.q;
import we.a;

public final class s {
    public final HeaderBase a;
    public final SimpleDateFormat b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final String f;
    public final String g;
    public final boolean h;
    public final a i;
    public final a j;
    public final a k;

    public s(HeaderBase headerBase0, a a0, a a1, a a2, int v) {
        SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("M월 d일 H시", Locale.getDefault());
        if((v & 0x100) != 0) {
            a0 = null;
        }
        if((v & 0x400) != 0) {
            a2 = null;
        }
        q.g(headerBase0, "header");
        super();
        this.a = headerBase0;
        this.b = simpleDateFormat0;
        this.c = true;
        this.d = 0x7F06017C;  // color:green500s_support_high_contrast
        this.e = true;
        this.f = "";
        this.g = "";
        this.h = (v & 0x80) == 0;
        this.i = a0;
        this.j = a1;
        this.k = a2;
    }

    // 去混淆评级： 中等(80)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof s && q.b(this.a, ((s)object0).a) && q.b(this.b, ((s)object0).b) && this.c == ((s)object0).c && this.d == ((s)object0).d && this.e == ((s)object0).e && q.b(this.f, ((s)object0).f) && q.b(this.g, ((s)object0).g) && this.h == ((s)object0).h && q.b(this.i, ((s)object0).i) && q.b(this.j, ((s)object0).j) && q.b(this.k, ((s)object0).k);
    }

    @Override
    public final int hashCode() {
        int v = d.e(x.b(x.b(d.e(d.b(this.d, d.e((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F, 0x1F, this.c), 0x1F), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h);
        int v1 = 0;
        int v2 = this.i == null ? 0 : this.i.hashCode();
        int v3 = this.j == null ? 0 : this.j.hashCode();
        a a0 = this.k;
        if(a0 != null) {
            v1 = a0.hashCode();
        }
        return ((v + v2) * 0x1F + v3) * 0x1F + v1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MusicSlotHeaderUiState(header=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", endDateFormat=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", showEndDate=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", countDownTextColor=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", showViewAll=");
        Y.y(stringBuilder0, this.e, ", replaceText=", this.f, ", replaceTextKey=");
        Y.x(stringBuilder0, this.g, ", shouldUseWebpAnimation=", this.h, ", onTitleClick=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", onViewAllClick=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", onArtistPickClick=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

