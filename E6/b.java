package e6;

import android.animation.TypeEvaluator;

public final class b implements TypeEvaluator {
    public static final b a;

    static {
        b.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static Integer a(Integer integer0, Integer integer1, float f) {
        int v = (int)integer0;
        float f1 = ((float)(v >> 24 & 0xFF)) / 255.0f;
        int v1 = (int)integer1;
        float f2 = (float)Math.pow(((float)(v >> 16 & 0xFF)) / 255.0f, 2.2);
        float f3 = (float)Math.pow(((float)(v >> 8 & 0xFF)) / 255.0f, 2.2);
        float f4 = (float)Math.pow(((float)(v & 0xFF)) / 255.0f, 2.2);
        return (int)(Math.round(((float)Math.pow((((float)Math.pow(((float)(v1 & 0xFF)) / 255.0f, 2.2)) - f4) * f + f4, 0.454545)) * 255.0f) | (Math.round(((float)Math.pow((((float)Math.pow(((float)(v1 >> 16 & 0xFF)) / 255.0f, 2.2)) - f2) * f + f2, 0.454545)) * 255.0f) << 16 | Math.round(((((float)(v1 >> 24 & 0xFF)) / 255.0f - f1) * f + f1) * 255.0f) << 24 | Math.round(((float)Math.pow((((float)Math.pow(((float)(v1 >> 8 & 0xFF)) / 255.0f, 2.2)) - f3) * f + f3, 0.454545)) * 255.0f) << 8));
    }

    @Override  // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object object0, Object object1) {
        return b.a(((Integer)object0), ((Integer)object1), f);
    }
}

