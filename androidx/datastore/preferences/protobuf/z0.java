package androidx.datastore.preferences.protobuf;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public class z0 extends Enum {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class v0 extends z0 {
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class w0 extends z0 {
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class x0 extends z0 {
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class y0 extends z0 {
    }

    public final A0 a;
    public final int b;
    public static final enum v0 c;
    public static final enum w0 d;
    public static final enum x0 e;
    public static final z0[] f;

    static {
        z0 z00 = new z0("DOUBLE", 0, A0.e, 1);
        z0 z01 = new z0("FLOAT", 1, A0.d, 5);
        z0 z02 = new z0("INT64", 2, A0.c, 0);
        z0 z03 = new z0("UINT64", 3, A0.c, 0);
        z0 z04 = new z0("INT32", 4, A0.b, 0);
        z0 z05 = new z0("FIXED64", 5, A0.c, 1);
        z0 z06 = new z0("FIXED32", 6, A0.b, 5);
        z0 z07 = new z0("BOOL", 7, A0.f, 0);
        z0.c = new v0("STRING", 8, A0.g, 2);  // 初始化器: Landroidx/datastore/preferences/protobuf/z0;-><init>(Ljava/lang/String;ILandroidx/datastore/preferences/protobuf/A0;I)V
        z0.d = new w0("GROUP", 9, A0.j, 3);  // 初始化器: Landroidx/datastore/preferences/protobuf/z0;-><init>(Ljava/lang/String;ILandroidx/datastore/preferences/protobuf/A0;I)V
        z0.e = new x0("MESSAGE", 10, A0.j, 2);  // 初始化器: Landroidx/datastore/preferences/protobuf/z0;-><init>(Ljava/lang/String;ILandroidx/datastore/preferences/protobuf/A0;I)V
        z0.f = new z0[]{z00, z01, z02, z03, z04, z05, z06, z07, z0.c, z0.d, z0.e, new y0("BYTES", 11, A0.h, 2), new z0("UINT32", 12, A0.b, 0), new z0("ENUM", 13, A0.i, 0), new z0("SFIXED32", 14, A0.b, 5), new z0("SFIXED64", 15, A0.c, 1), new z0("SINT32", 16, A0.b, 0), new z0("SINT64", 17, A0.c, 0)};  // 初始化器: Landroidx/datastore/preferences/protobuf/z0;-><init>(Ljava/lang/String;ILandroidx/datastore/preferences/protobuf/A0;I)V
    }

    public z0(String s, int v, A0 a00, int v1) {
        super(s, v);
        this.a = a00;
        this.b = v1;
    }

    public static z0 valueOf(String s) {
        return (z0)Enum.valueOf(z0.class, s);
    }

    public static z0[] values() {
        return (z0[])z0.f.clone();
    }
}

