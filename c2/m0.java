package c2;

import S1.d;
import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public final class m0 extends r0 {
    public WindowInsets c;
    public d d;
    public static Field e = null;
    public static boolean f = false;
    public static Constructor g = null;
    public static boolean h = false;

    public m0() {
        this.c = m0.i();
    }

    public m0(B0 b00) {
        super(b00);
        this.c = b00.g();
    }

    @Override  // c2.r0
    public B0 b() {
        this.a();
        B0 b00 = B0.h(null, this.c);
        b00.a.r(this.b);
        b00.a.u(this.d);
        return b00;
    }

    @Override  // c2.r0
    public void e(d d0) {
        this.d = d0;
    }

    @Override  // c2.r0
    public void g(d d0) {
        WindowInsets windowInsets0 = this.c;
        if(windowInsets0 != null) {
            this.c = windowInsets0.replaceSystemWindowInsets(d0.a, d0.b, d0.c, d0.d);
        }
    }

    private static WindowInsets i() {
        Class class0 = WindowInsets.class;
        if(!m0.f) {
            try {
                m0.e = class0.getDeclaredField("CONSUMED");
            }
            catch(ReflectiveOperationException reflectiveOperationException0) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", reflectiveOperationException0);
            }
            m0.f = true;
        }
        Field field0 = m0.e;
        if(field0 != null) {
            try {
                WindowInsets windowInsets0 = (WindowInsets)field0.get(null);
                if(windowInsets0 != null) {
                    return new WindowInsets(windowInsets0);
                }
            }
            catch(ReflectiveOperationException reflectiveOperationException1) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", reflectiveOperationException1);
            }
        }
        if(!m0.h) {
            try {
                m0.g = class0.getConstructor(Rect.class);
            }
            catch(ReflectiveOperationException reflectiveOperationException2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", reflectiveOperationException2);
            }
            m0.h = true;
        }
        Constructor constructor0 = m0.g;
        if(constructor0 != null) {
            try {
                return (WindowInsets)constructor0.newInstance(new Rect());
            }
            catch(ReflectiveOperationException reflectiveOperationException3) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", reflectiveOperationException3);
            }
        }
        return null;
    }
}

