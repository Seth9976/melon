package Ac;

import A7.d;
import U4.x;
import com.melon.net.res.v3.CommentConfig;
import java.util.List;
import k8.Y;
import kotlin.jvm.internal.q;

public final class l4 extends m4 {
    public final String a;
    public final String b;
    public final CommentConfig c;
    public final boolean d;
    public final List e;

    public l4(String s, String s1, CommentConfig commentConfig0, boolean z, List list0) {
        q.g(s, "text");
        q.g(s1, "placeholder");
        super();
        this.a = s;
        this.b = s1;
        this.c = commentConfig0;
        this.d = z;
        this.e = list0;
    }

    public static l4 a(l4 l40, String s, List list0, int v) {
        if((v & 1) != 0) {
            s = l40.a;
        }
        String s1 = l40.b;
        CommentConfig commentConfig0 = l40.c;
        boolean z = l40.d;
        if((v & 16) != 0) {
            list0 = l40.e;
        }
        l40.getClass();
        q.g(s, "text");
        q.g(s1, "placeholder");
        return new l4(s, s1, commentConfig0, z, list0);
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof l4 && q.b(this.a, ((l4)object0).a) && q.b(this.b, ((l4)object0).b) && this.c.equals(((l4)object0).c) && this.d == ((l4)object0).d && q.b(this.e, ((l4)object0).e);
    }

    @Override
    public final int hashCode() {
        int v = d.e((this.c.hashCode() + x.b(this.a.hashCode() * 0x1F, 0x1F, this.b)) * 0x1F, 0x1F, this.d);
        return this.e == null ? v : v + this.e.hashCode();
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = d.o("Success(text=", this.a, ", placeholder=", this.b, ", config=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", isEditMode=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", attachContents=");
        return Y.m(stringBuilder0, this.e, ")");
    }
}

