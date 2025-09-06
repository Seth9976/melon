package androidx.appcompat.widget;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public abstract class p1 {
    public static boolean a;
    public static Method b;
    public static final boolean c;

    static {
        p1.c = Build.VERSION.SDK_INT >= 27;
    }
}

