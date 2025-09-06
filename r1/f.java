package r1;

public final class f implements Comparable {
    public final float a;

    public f(float f) {
        this.a = f;
    }

    public static final boolean a(float f, float f1) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static String b(float f) [...] // 潜在的解密器

    @Override
    public final int compareTo(Object object0) {
        return Float.compare(this.a, ((f)object0).a);
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof f && Float.compare(this.a, ((f)object0).a) == 0;
    }

    @Override
    public final int hashCode() {
        return Float.hashCode(this.a);
    }

    @Override
    public final String toString() {
        return f.b(this.a);
    }
}

