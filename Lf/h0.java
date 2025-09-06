package lf;

import rf.n;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class h0 extends Enum implements n {
    public final int a;
    public static final h0[] b;

    static {
        h0.b = new h0[]{new h0("INTERNAL", 0, 0), new h0("PRIVATE", 1, 1), new h0("PROTECTED", 2, 2), new h0("PUBLIC", 3, 3), new h0("PRIVATE_TO_THIS", 4, 4), new h0("LOCAL", 5, 5)};
    }

    public h0(String s, int v, int v1) {
        super(s, v);
        this.a = v1;
    }

    @Override  // rf.n
    public final int a() {
        return this.a;
    }

    public static h0 valueOf(String s) {
        return (h0)Enum.valueOf(h0.class, s);
    }

    public static h0[] values() {
        return (h0[])h0.b.clone();
    }
}

