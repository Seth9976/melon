package Ve;

import B3.d;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class i0 extends Enum {
    public final d a;
    public static final i0[] b;
    public static final b c;

    static {
        i0[] arr_i0 = {new i0("DECLARATION", 0, 0), new i0("FAKE_OVERRIDE", 1, 1), new i0("DELEGATION", 2, 2), new i0("SYNTHESIZED", 3, 3)};
        i0.b = arr_i0;
        q.g(arr_i0, "entries");
        i0.c = new b(arr_i0);
    }

    public i0(String s, int v, int v1) {
        super(s, v);
        q.f(nf.d.p, "MEMBER_KIND");
        this.a = new d(nf.d.p, v1);
    }

    public static i0 valueOf(String s) {
        return (i0)Enum.valueOf(i0.class, s);
    }

    public static i0[] values() {
        return (i0[])i0.b.clone();
    }
}

