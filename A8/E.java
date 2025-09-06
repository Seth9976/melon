package A8;

import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class e extends Enum {
    public final String a;
    public static final enum e b;
    public static final enum e c;
    public static final e[] d;

    static {
        e.b = new e("NOT_PHONE", 0, "0");
        e.c = new e("PHONE", 1, "1");
        e[] arr_e = {e.b, e.c, new e("ETC", 2, "2"), new e("TABLET", 3, "3")};
        e.d = arr_e;
        q.g(arr_e, "entries");
        new b(arr_e);
    }

    public e(String s, int v, String s1) {
        super(s, v);
        this.a = s1;
    }

    public static e valueOf(String s) {
        return (e)Enum.valueOf(e.class, s);
    }

    public static e[] values() {
        return (e[])e.d.clone();
    }
}

