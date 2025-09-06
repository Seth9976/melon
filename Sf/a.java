package sf;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends Enum {
    public final boolean a;
    public final boolean b;
    public static final enum a c;
    public static final a[] d;

    static {
        a.c = new a("NO_ARGUMENTS", 0, 3);
        a[] arr_a = {a.c, new a("UNLESS_EMPTY", 1, 2), new a("ALWAYS_PARENTHESIZED", 2, true, true)};
        a.d = arr_a;
        q.g(arr_a, "entries");
        new b(arr_a);
    }

    public a(String s, int v, int v1) {
        this(s, v, (v1 & 1) == 0, false);
    }

    public a(String s, int v, boolean z, boolean z1) {
        super(s, v);
        this.a = z;
        this.b = z1;
    }

    public static a valueOf(String s) {
        return (a)Enum.valueOf(a.class, s);
    }

    public static a[] values() {
        return (a[])a.d.clone();
    }
}

