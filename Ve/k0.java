package Ve;

import B3.d;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class k0 extends Enum {
    public final d a;
    public static final k0[] b;
    public static final b c;

    static {
        k0[] arr_k0 = {new k0("INTERNAL", 0, 0), new k0("PRIVATE", 1, 1), new k0("PROTECTED", 2, 2), new k0("PUBLIC", 3, 3), new k0("PRIVATE_TO_THIS", 4, 4), new k0("LOCAL", 5, 5)};
        k0.b = arr_k0;
        q.g(arr_k0, "entries");
        k0.c = new b(arr_k0);
    }

    public k0(String s, int v, int v1) {
        super(s, v);
        q.f(nf.d.d, "VISIBILITY");
        this.a = new d(nf.d.d, v1);
    }

    public static k0 valueOf(String s) {
        return (k0)Enum.valueOf(k0.class, s);
    }

    public static k0[] values() {
        return (k0[])k0.b.clone();
    }
}

