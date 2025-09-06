package Ic;

import A7.d;
import U4.x;
import com.melon.ui.K4;
import java.util.ArrayList;

public final class n implements K4 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final ArrayList e;

    public n(String s, String s1, String s2, String s3, ArrayList arrayList0) {
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = arrayList0;
    }

    // 去混淆评级： 中等(60)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n && this.a.equals(((n)object0).a) && this.b.equals(((n)object0).b) && this.c.equals(((n)object0).c) && this.d.equals(((n)object0).d) && this.e.equals(((n)object0).e);
    }

    @Override
    public final int hashCode() {
        return this.e.hashCode() + x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("AlbumUiState(name=", this.a, ", image=", this.b, ", imageLarge=");
        d.u(stringBuilder0, this.c, ", issueDate=", this.d, ", artistList=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

