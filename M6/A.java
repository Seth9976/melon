package m6;

import android.animation.TypeEvaluator;

public final class a implements TypeEvaluator {
    public final d a;
    public static final a b;

    static {
        a.b = new a();
    }

    public a() {
        this.a = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object object0, Object object1) {
        this.a.a = e2.a.K(((d)object0).a, ((d)object1).a, f);
        this.a.b = e2.a.K(((d)object0).b, ((d)object1).b, f);
        this.a.c = e2.a.K(((d)object0).c, ((d)object1).c, f);
        return this.a;
    }
}

