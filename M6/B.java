package m6;

import android.util.Property;

public final class b extends Property {
    public static final b a;

    static {
        b.a = new b(d.class, "circularReveal");  // 初始化器: Landroid/util/Property;-><init>(Ljava/lang/Class;Ljava/lang/String;)V
    }

    @Override  // android.util.Property
    public final Object get(Object object0) {
        return ((e)object0).getRevealInfo();
    }

    @Override  // android.util.Property
    public final void set(Object object0, Object object1) {
        ((e)object0).setRevealInfo(((d)object1));
    }
}

