package r8;

import k8.Y;
import kotlin.jvm.internal.q;
import pe.b;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class d extends Enum {
    public static final enum d a;
    public static final enum d b;
    public static final enum d c;
    public static final enum d d;
    public static final enum d e;
    public static final d[] f;

    static {
        d.a = new d("Today", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d d0 = new d("Pop", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.b = new d("Mv", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.c = new d("Original", 3);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.d = new d("Broad", 4);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.e = new d("Live", 5);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d[] arr_d = {d.a, d0, d.b, d.c, d.d, d.e, new d("Liked", 6)};  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        d.f = arr_d;
        q.g(arr_d, "entries");
        new b(arr_d);
    }

    public final String a() {
        return Y.j("getDefault(...)", this.name(), "toLowerCase(...)");
    }

    public static d valueOf(String s) {
        return (d)Enum.valueOf(d.class, s);
    }

    public static d[] values() {
        return (d[])d.f.clone();
    }
}

