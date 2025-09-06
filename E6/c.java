package e6;

import android.util.Property;
import android.view.ViewGroup;

public final class c extends Property {
    public static final c a;

    static {
        c.a = new c(Float.class, "childrenAlpha");  // 初始化器: Landroid/util/Property;-><init>(Ljava/lang/Class;Ljava/lang/String;)V
    }

    @Override  // android.util.Property
    public final Object get(Object object0) {
        Float float0 = (Float)((ViewGroup)object0).getTag(0x7F0A0875);  // id:mtrl_internal_children_alpha_tag
        return float0 == null ? 1.0f : float0;
    }

    @Override  // android.util.Property
    public final void set(Object object0, Object object1) {
        float f = (float)(((Float)object1));
        ((ViewGroup)object0).setTag(0x7F0A0875, ((Float)object1));  // id:mtrl_internal_children_alpha_tag
        int v = ((ViewGroup)object0).getChildCount();
        for(int v1 = 0; v1 < v; ++v1) {
            ((ViewGroup)object0).getChildAt(v1).setAlpha(f);
        }
    }
}

