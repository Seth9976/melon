package ad;

import R6.c;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class r extends Enum {
    public static final enum r B;
    public static final r[] D;
    public static final b E;
    public static final c a;
    public static final enum r b;
    public static final enum r c;
    public static final enum r d;
    public static final enum r e;
    public static final enum r f;
    public static final enum r g;
    public static final enum r h;
    public static final enum r i;
    public static final enum r j;
    public static final enum r k;
    public static final enum r l;
    public static final enum r m;
    public static final enum r n;
    public static final enum r o;
    public static final enum r r;
    public static final enum r w;

    static {
        r r0 = new r("DJ", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r1 = new r("NEWALBUM", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.b = new r("THEME", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.c = new r("THEMESUB1", 3);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.d = new r("THEMESUB2", 4);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r2 = new r("FOOTER", 5);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r3 = new r("STRATEGY", 6);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r4 = new r("TOPBANNER", 7);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r5 = new r("MIDDLEBANNER", 8);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.e = new r("DAILY", 9);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r6 = new r("MELONCHART", 10);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.f = new r("VIDEO1", 11);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.g = new r("VIDEO2", 12);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.h = new r("VIDEO3", 13);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r7 = new r("TAG", 14);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r8 = new r("TABTITLE", 15);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r r9 = new r("POPULARSONG", 16);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.i = new r("FLEXIBLEA", 17);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.j = new r("FLEXIBLEB", 18);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.k = new r("FLEXIBLEC", 19);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.l = new r("FLEXIBLED", 20);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.m = new r("FLEXIBLEE", 21);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.n = new r("FLEXIBLEF", 22);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.o = new r("FLEXIBLEG", 23);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.r = new r("FLEXIBLEH", 24);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.w = new r("FLEXIBLEI", 25);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.B = new r("FLEXIBLEJ", 26);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r[] arr_r = {r0, r1, r.b, r.c, r.d, r2, r3, r4, r5, r.e, r6, r.f, r.g, r.h, r7, r8, r9, r.i, r.j, r.k, r.l, r.m, r.n, r.o, r.r, r.w, r.B, new r("WEEKLYDJ", 27), new r("TOPNOTIFICATION", 28), new r("MAGAZINE", 29)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V / 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        r.D = arr_r;
        q.g(arr_r, "entries");
        r.E = new b(arr_r);
        r.a = new c(14);
    }

    public static r valueOf(String s) {
        return (r)Enum.valueOf(r.class, s);
    }

    public static r[] values() {
        return (r[])r.D.clone();
    }
}

