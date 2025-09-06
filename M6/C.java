package m6;

import android.util.Property;

public final class c extends Property {
    public static final c a;

    static {
        c.a = new c(Integer.class, "circularRevealScrimColor");  // 初始化器: Landroid/util/Property;-><init>(Ljava/lang/Class;Ljava/lang/String;)V
    }

    @Override  // android.util.Property
    public final Object get(Object object0) {
        return ((e)object0).getCircularRevealScrimColor();
    }

    @Override  // android.util.Property
    public final void set(Object object0, Object object1) {
        ((e)object0).setCircularRevealScrimColor(((int)(((Integer)object1))));
    }
}

