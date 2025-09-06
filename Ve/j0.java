package Ve;

import B3.d;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class j0 extends Enum {
    public final d a;
    public static final j0[] b;
    public static final b c;

    static {
        j0[] arr_j0 = {new j0("FINAL", 0, 0), new j0("OPEN", 1, 1), new j0("ABSTRACT", 2, 2), new j0("SEALED", 3, 3)};
        j0.b = arr_j0;
        q.g(arr_j0, "entries");
        j0.c = new b(arr_j0);
    }

    public j0(String s, int v, int v1) {
        super(s, v);
        q.f(nf.d.e, "MODALITY");
        this.a = new d(nf.d.e, v1);
    }

    public static j0 valueOf(String s) {
        return (j0)Enum.valueOf(j0.class, s);
    }

    public static j0[] values() {
        return (j0[])j0.b.clone();
    }
}

