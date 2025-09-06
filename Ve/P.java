package Ve;

import B3.d;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class p extends Enum {
    public final d a;
    public static final enum p b;
    public static final enum p c;
    public static final p[] d;
    public static final b e;

    static {
        p p0 = new p("CLASS", 0, 0);
        p p1 = new p("INTERFACE", 1, 1);
        p p2 = new p("ENUM_CLASS", 2, 2);
        p p3 = new p("ENUM_ENTRY", 3, 3);
        p p4 = new p("ANNOTATION_CLASS", 4, 4);
        p.b = new p("OBJECT", 5, 5);
        p.c = new p("COMPANION_OBJECT", 6, 6);
        p[] arr_p = {p0, p1, p2, p3, p4, p.b, p.c};
        p.d = arr_p;
        q.g(arr_p, "entries");
        p.e = new b(arr_p);
    }

    public p(String s, int v, int v1) {
        super(s, v);
        q.f(nf.d.f, "CLASS_KIND");
        this.a = new d(nf.d.f, v1);
    }

    public static p valueOf(String s) {
        return (p)Enum.valueOf(p.class, s);
    }

    public static p[] values() {
        return (p[])p.d.clone();
    }
}

