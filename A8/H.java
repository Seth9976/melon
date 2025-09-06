package A8;

import kotlin.jvm.internal.q;
import pe.b;
import w7.d;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class h extends Enum {
    public final String a;
    public static final d b;
    public static final enum h c;
    public static final h[] d;

    static {
        h h0 = new h("HIFI", 0, "1");
        h h1 = new h("ST", 1, "2");
        h h2 = new h("COMPLEX", 2, "3");
        h.c = new h("NONE", 3, "4");
        h[] arr_h = {h0, h1, h2, h.c};
        h.d = arr_h;
        q.g(arr_h, "entries");
        new b(arr_h);
        h.b = new d(2);
    }

    public h(String s, int v, String s1) {
        super(s, v);
        this.a = s1;
    }

    public static h valueOf(String s) {
        return (h)Enum.valueOf(h.class, s);
    }

    public static h[] values() {
        return (h[])h.d.clone();
    }
}

