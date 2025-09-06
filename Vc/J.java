package Vc;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import java.util.List;
import pc.b;
import y0.s;

public final class j implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final b d;
    public final List e;
    public final long f;
    public final boolean g;
    public final B h;

    public j(String s, String s1, String s2, b b0, List list0, long v, boolean z, B b1) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = b0;
        this.e = list0;
        this.f = v;
        this.g = z;
        this.h = b1;
    }

    // 去混淆评级： 中等(70)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof j && this.a.equals(((j)object0).a) && this.b.equals(((j)object0).b) && this.c.equals(((j)object0).c) && this.d == ((j)object0).d && this.e.equals(((j)object0).e) && s.d(this.f, ((j)object0).f) && this.g == ((j)object0).g && this.h.equals(((j)object0).h);
    }

    @Override
    public final int hashCode() {
        int v = x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c);
        return this.d == null ? this.h.hashCode() + d.e(d.c(d.d(v * 0x1F, 0x1F, this.e), 0x1F, this.f), 0x1F, this.g) : this.h.hashCode() + d.e(d.c(d.d((v + this.d.hashCode()) * 0x1F, 0x1F, this.e), 0x1F, this.f), 0x1F, this.g);
    }

    @Override
    public final String toString() {
        String s = s.j(this.f);
        StringBuilder stringBuilder0 = d.o("DjMalrangSlotUiState(text1=", this.a, ", text2=", this.b, ", buttonText=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", djMalrangColorType=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", imageUrls=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", buttonColor=");
        stringBuilder0.append(s);
        stringBuilder0.append(", isHighContrastMode=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", userEvent=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

