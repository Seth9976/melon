package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

public abstract class j0 {
    public static final Method a;
    public static final Method b;
    public static final Method c;
    public static final boolean d;

    static {
        try {
            Class class0 = Integer.TYPE;
            Method method0 = AbsListView.class.getDeclaredMethod("positionSelector", class0, View.class, Boolean.TYPE, Float.TYPE, Float.TYPE);
            j0.a = method0;
            method0.setAccessible(true);
            Method method1 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", class0);
            j0.b = method1;
            method1.setAccessible(true);
            Method method2 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", class0);
            j0.c = method2;
            method2.setAccessible(true);
            j0.d = true;
        }
        catch(NoSuchMethodException noSuchMethodException0) {
            noSuchMethodException0.printStackTrace();
        }
    }
}

