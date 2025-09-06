package com.google.protobuf;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public class j3 extends Enum {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class f3 extends j3 {
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class g3 extends j3 {
        @Override  // com.google.protobuf.j3
        public final boolean a() {
            return false;
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class h3 extends j3 {
        @Override  // com.google.protobuf.j3
        public final boolean a() {
            return false;
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class i3 extends j3 {
        @Override  // com.google.protobuf.j3
        public final boolean a() {
            return false;
        }
    }

    public final k3 a;
    public final int b;
    public static final enum j3 c;
    public static final enum f3 d;
    public static final enum g3 e;
    public static final enum h3 f;
    public static final enum j3 g;
    public static final j3[] h;

    static {
        j3 j30 = new j3("DOUBLE", 0, k3.e, 1);
        j3 j31 = new j3("FLOAT", 1, k3.d, 5);
        j3 j32 = new j3("INT64", 2, k3.c, 0);
        j3 j33 = new j3("UINT64", 3, k3.c, 0);
        j3 j34 = new j3("INT32", 4, k3.b, 0);
        j3 j35 = new j3("FIXED64", 5, k3.c, 1);
        j3 j36 = new j3("FIXED32", 6, k3.b, 5);
        j3.c = new j3("BOOL", 7, k3.f, 0);
        j3.d = new f3("STRING", 8, k3.g, 2);  // 初始化器: Lcom/google/protobuf/j3;-><init>(Ljava/lang/String;ILcom/google/protobuf/k3;I)V
        j3.e = new g3("GROUP", 9, k3.j, 3);  // 初始化器: Lcom/google/protobuf/j3;-><init>(Ljava/lang/String;ILcom/google/protobuf/k3;I)V
        j3.f = new h3("MESSAGE", 10, k3.j, 2);  // 初始化器: Lcom/google/protobuf/j3;-><init>(Ljava/lang/String;ILcom/google/protobuf/k3;I)V
        i3 i30 = new i3("BYTES", 11, k3.h, 2);  // 初始化器: Lcom/google/protobuf/j3;-><init>(Ljava/lang/String;ILcom/google/protobuf/k3;I)V
        j3 j37 = new j3("UINT32", 12, k3.b, 0);
        j3.g = new j3("ENUM", 13, k3.i, 0);
        j3.h = new j3[]{j30, j31, j32, j33, j34, j35, j36, j3.c, j3.d, j3.e, j3.f, i30, j37, j3.g, new j3("SFIXED32", 14, k3.b, 5), new j3("SFIXED64", 15, k3.c, 1), new j3("SINT32", 16, k3.b, 0), new j3("SINT64", 17, k3.c, 0)};
    }

    public j3(String s, int v, k3 k30, int v1) {
        super(s, v);
        this.a = k30;
        this.b = v1;
    }

    public boolean a() {
        return !(this instanceof f3);
    }

    public static j3 valueOf(String s) {
        return (j3)Enum.valueOf(j3.class, s);
    }

    public static j3[] values() {
        return (j3[])j3.h.clone();
    }
}

