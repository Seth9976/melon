package C1;

import java.util.HashMap;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class j extends Enum {
    public static final HashMap a;
    public static final j[] b;

    static {
        j j0 = new j("NONE", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        j j1 = new j("CHAIN", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        j j2 = new j("ALIGNED", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        j.b = new j[]{j0, j1, j2};
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        j.a = hashMap1;
        hashMap0.put("none", j0);
        hashMap0.put("chain", j1);
        hashMap0.put("aligned", j2);
        hashMap1.put("none", 0);
        hashMap1.put("chain", 3);
        hashMap1.put("aligned", 2);
    }

    public static j valueOf(String s) {
        return (j)Enum.valueOf(j.class, s);
    }

    public static j[] values() {
        return (j[])j.b.clone();
    }
}

