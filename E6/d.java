package e6;

import android.graphics.drawable.Drawable;
import android.util.Property;
import java.util.WeakHashMap;

public final class d extends Property {
    public static final d a;

    static {
        d d0 = new d(Integer.class, "drawableAlphaCompat");  // 初始化器: Landroid/util/Property;-><init>(Ljava/lang/Class;Ljava/lang/String;)V
        new WeakHashMap();
        d.a = d0;
    }

    @Override  // android.util.Property
    public final Object get(Object object0) {
        return ((Drawable)object0).getAlpha();
    }

    @Override  // android.util.Property
    public final void set(Object object0, Object object1) {
        ((Drawable)object0).setAlpha(((int)(((Integer)object1))));
    }
}

