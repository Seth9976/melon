package sf;

import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public abstract class r extends Enum {
    public static final enum q a;
    public static final enum p b;
    public static final r[] c;

    static {
        q q0 = new q();
        r.a = q0;
        p p0 = new p();
        r.b = p0;
        r[] arr_r = {q0, p0};
        r.c = arr_r;
        kotlin.jvm.internal.q.g(arr_r, "entries");
        new b(arr_r);
    }

    public abstract String a(String arg1);

    public static r valueOf(String s) {
        return (r)Enum.valueOf(r.class, s);
    }

    public static r[] values() {
        return (r[])r.c.clone();
    }
}

