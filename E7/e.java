package e7;

import java.util.HashMap;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class e extends Enum {
    public static final enum e a;
    public static final HashMap b;
    public static final e[] c;

    static {
        e e0 = new e("X86_32", 0);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e1 = new e("X86_64", 1);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e2 = new e("ARM_UNKNOWN", 2);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e3 = new e("PPC", 3);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e4 = new e("PPC64", 4);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e5 = new e("ARMV6", 5);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e6 = new e("ARMV7", 6);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e.a = new e("UNKNOWN", 7);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e7 = new e("ARMV7S", 8);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e e8 = new e("ARM64", 9);  // 初始化器: Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V
        e.c = new e[]{e0, e1, e2, e3, e4, e5, e6, e.a, e7, e8};
        HashMap hashMap0 = new HashMap(4);
        e.b = hashMap0;
        hashMap0.put("armeabi-v7a", e6);
        hashMap0.put("armeabi", e5);
        hashMap0.put("arm64-v8a", e8);
        hashMap0.put("x86", e0);
    }

    public static e valueOf(String s) {
        return (e)Enum.valueOf(e.class, s);
    }

    public static e[] values() {
        return (e[])e.c.clone();
    }
}

