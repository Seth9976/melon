package kotlin.jvm.internal;

public final class v implements g {
    public final Class a;

    public v(Class class0) {
        q.g(class0, "jClass");
        super();
        this.a = class0;
    }

    @Override  // kotlin.jvm.internal.g
    public final Class c() {
        return this.a;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof v && q.b(this.a, ((v)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return this.a + " (Kotlin reflection is not available)";
    }
}

