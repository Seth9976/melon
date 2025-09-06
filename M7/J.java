package M7;

import t7.f;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class j extends Enum implements f {
    public final int a;
    public static final enum j b;
    public static final enum j c;
    public static final enum j d;
    public static final j[] e;

    static {
        j j0 = new j("COLLECTION_UNKNOWN", 0, 0);
        j.b = new j("COLLECTION_SDK_NOT_INSTALLED", 1, 1);
        j.c = new j("COLLECTION_ENABLED", 2, 2);
        j.d = new j("COLLECTION_DISABLED", 3, 3);
        j.e = new j[]{j0, j.b, j.c, j.d, new j("COLLECTION_DISABLED_REMOTE", 4, 4), new j("COLLECTION_SAMPLED", 5, 5)};
    }

    public j(String s, int v, int v1) {
        super(s, v);
        this.a = v1;
    }

    @Override  // t7.f
    public final int a() {
        return this.a;
    }

    public static j valueOf(String s) {
        return (j)Enum.valueOf(j.class, s);
    }

    public static j[] values() {
        return (j[])j.e.clone();
    }
}

