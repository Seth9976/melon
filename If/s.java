package If;

import Hf.K;
import Hf.a0;
import Hf.c;
import Hf.l;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public abstract class s extends Enum {
    public static final enum q a;
    public static final enum o b;
    public static final enum r c;
    public static final enum p d;
    public static final s[] e;

    static {
        q q0 = new q();
        s.a = q0;
        o o0 = new o();
        s.b = o0;
        r r0 = new r();
        s.c = r0;
        p p0 = new p();
        s.d = p0;
        s[] arr_s = {q0, o0, r0, p0};
        s.e = arr_s;
        kotlin.jvm.internal.q.g(arr_s, "entries");
        new b(arr_s);
    }

    public abstract s a(a0 arg1);

    public static s b(a0 a00) {
        kotlin.jvm.internal.q.g(a00, "<this>");
        if(a00.D()) {
            return s.b;
        }
        if(a00 instanceof l) {
            l l0 = (l)a00;
        }
        return c.h(m.a.q0(), c.m(a00), K.b) ? s.d : s.c;
    }

    public static s valueOf(String s) {
        return (s)Enum.valueOf(s.class, s);
    }

    public static s[] values() {
        return (s[])s.e.clone();
    }
}

