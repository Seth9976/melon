package cd;

import com.iloen.melon.MelonAppBase;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class a extends Enum {
    public final String a;
    public final String b;
    public static final enum a c;
    public static final enum a d;
    public static final enum a e;
    public static final a[] f;

    static {
        q.g(new Object[0], "args");
        String s2;
        String s1;
        String s;
        try {
            MelonAppBase.Companion.getClass();
            s = "";
            q.d("전체전체보기");
            s = "전체전체보기";
        }
        catch(Exception unused_ex) {
        }
        a.c = new a("ALL", 0, s, "");
        q.g(new Object[0], "args");
        try {
            MelonAppBase.Companion.getClass();
            s1 = "";
            q.d("국내전체보기");
            s1 = "국내전체보기";
        }
        catch(Exception unused_ex) {
        }
        a.d = new a("DOMESTIC", 1, s1, "");
        q.g(new Object[0], "args");
        try {
            MelonAppBase.Companion.getClass();
            s2 = "";
            q.d("해외전체보기");
            s2 = "해외전체보기";
        }
        catch(Exception unused_ex) {
        }
        a.e = new a("OVERSEAS", 2, s2, "");
        a[] arr_a = {a.c, a.d, a.e};
        a.f = arr_a;
        q.g(arr_a, "entries");
        new b(arr_a);
    }

    public a(String s, int v, String s1, String s2) {
        super(s, v);
        this.a = s1;
        this.b = s2;
    }

    public static a valueOf(String s) {
        return (a)Enum.valueOf(a.class, s);
    }

    public static a[] values() {
        return (a[])a.f.clone();
    }
}

