package rf;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public class J extends Enum {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class F extends J {
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class G extends J {
        @Override  // rf.J
        public final boolean a() {
            return false;
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class H extends J {
        @Override  // rf.J
        public final boolean a() {
            return false;
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    public final class I extends J {
        @Override  // rf.J
        public final boolean a() {
            return false;
        }
    }

    public final K a;
    public final int b;
    public static final enum J c;
    public static final enum J d;
    public static final enum G e;
    public static final enum H f;
    public static final enum J g;
    public static final J[] h;

    static {
        J j0 = new J("DOUBLE", 0, K.e, 1);
        J j1 = new J("FLOAT", 1, K.d, 5);
        J j2 = new J("INT64", 2, K.c, 0);
        J j3 = new J("UINT64", 3, K.c, 0);
        J.c = new J("INT32", 4, K.b, 0);
        J j4 = new J("FIXED64", 5, K.c, 1);
        J j5 = new J("FIXED32", 6, K.b, 5);
        J.d = new J("BOOL", 7, K.f, 0);
        F f0 = new F("STRING", 8, K.g, 2);  // 初始化器: Lrf/J;-><init>(Ljava/lang/String;ILrf/K;I)V
        J.e = new G("GROUP", 9, K.j, 3);  // 初始化器: Lrf/J;-><init>(Ljava/lang/String;ILrf/K;I)V
        J.f = new H("MESSAGE", 10, K.j, 2);  // 初始化器: Lrf/J;-><init>(Ljava/lang/String;ILrf/K;I)V
        I i0 = new I("BYTES", 11, K.h, 2);  // 初始化器: Lrf/J;-><init>(Ljava/lang/String;ILrf/K;I)V
        J j6 = new J("UINT32", 12, K.b, 0);
        J.g = new J("ENUM", 13, K.i, 0);
        J.h = new J[]{j0, j1, j2, j3, J.c, j4, j5, J.d, f0, J.e, J.f, i0, j6, J.g, new J("SFIXED32", 14, K.b, 5), new J("SFIXED64", 15, K.c, 1), new J("SINT32", 16, K.b, 0), new J("SINT64", 17, K.c, 0)};
    }

    public J(String s, int v, K k0, int v1) {
        super(s, v);
        this.a = k0;
        this.b = v1;
    }

    public boolean a() {
        return !(this instanceof F);
    }

    public static J valueOf(String s) {
        return (J)Enum.valueOf(J.class, s);
    }

    public static J[] values() {
        return (J[])J.h.clone();
    }
}

