package A8;

import kotlin.jvm.internal.q;
import pe.b;
import z6.f;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class n extends Enum {
    public final int a;
    public static final f b;
    public static final enum n c;
    public static final n[] d;
    public static final b e;

    static {
        n n0 = new n("ZERO", 0, 0x7F08078E);  // drawable:noimage_logo_small_dna
        n.c = new n("ONE", 1, 0x7F080792);  // drawable:noimage_logo_xlarge_dna
        n[] arr_n = {n0, n.c, new n("TWO", 2, 0x7F080789), new n("THREE", 3, 0x7F08078E)};  // drawable:noimage_logo_medium_dna
        n.d = arr_n;
        q.g(arr_n, "entries");
        n.e = new b(arr_n);
        n.b = new f(2);
    }

    public n(String s, int v, int v1) {
        super(s, v);
        this.a = v1;
    }

    public static n valueOf(String s) {
        return (n)Enum.valueOf(n.class, s);
    }

    public static n[] values() {
        return (n[])n.d.clone();
    }
}

