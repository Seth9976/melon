package A8;

import kotlin.jvm.internal.q;
import pe.b;
import w7.d;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class t extends Enum {
    public final int a;
    public static final d b;
    public static final enum t c;
    public static final t[] d;

    static {
        t.c = new t("MELON", 0, 0);
        t[] arr_t = {t.c, new t("KAKAO", 1, 1), new t("KAKAO_MELON_OR_ID_PWD", 2, 2), new t("KAKAO_INTEG", 3, 3)};
        t.d = arr_t;
        q.g(arr_t, "entries");
        new b(arr_t);
        t.b = new d(4);
    }

    public t(String s, int v, int v1) {
        super(s, v);
        this.a = v1;
    }

    public static t valueOf(String s) {
        return (t)Enum.valueOf(t.class, s);
    }

    public static t[] values() {
        return (t[])t.d.clone();
    }
}

