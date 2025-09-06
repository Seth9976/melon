package c2;

import P4.a;
import S1.d;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class s0 extends y0 {
    public final WindowInsets c;
    public d[] d;
    public d e;
    public B0 f;
    public d g;
    public int h;
    public static boolean i = false;
    public static Method j;
    public static Class k;
    public static Field l;
    public static Field m;

    public s0(B0 b00, WindowInsets windowInsets0) {
        super(b00);
        this.e = null;
        this.c = windowInsets0;
    }

    public s0(B0 b00, s0 s00) {
        this(b00, new WindowInsets(s00.c));
    }

    public boolean A(int v) {
        switch(v) {
            case 4: {
                return false;
            }
            case 1: 
            case 2: 
            case 8: 
            case 0x80: {
                return !this.x(v, false).equals(d.e);
            }
            default: {
                return true;
            }
        }
    }

    @SuppressLint({"PrivateApi"})
    private static void B() {
        try {
            s0.j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class class0 = Class.forName("android.view.View$AttachInfo");
            s0.k = class0;
            s0.l = class0.getDeclaredField("mVisibleInsets");
            s0.m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            s0.l.setAccessible(true);
            s0.m.setAccessible(true);
        }
        catch(ReflectiveOperationException reflectiveOperationException0) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + reflectiveOperationException0.getMessage(), reflectiveOperationException0);
        }
        s0.i = true;
    }

    public static boolean C(int v, int v1) {
        return (v & 6) == (v1 & 6);
    }

    @Override  // c2.y0
    public void d(View view0) {
        d d0 = this.z(view0);
        if(d0 == null) {
            d0 = d.e;
        }
        this.s(d0);
    }

    @Override  // c2.y0
    public void e(B0 b00) {
        b00.a.t(this.f);
        b00.a.s(this.g);
        b00.a.v(this.h);
    }

    // 去混淆评级： 低(30)
    @Override  // c2.y0
    public boolean equals(Object object0) {
        return super.equals(object0) ? Objects.equals(this.g, ((s0)object0).g) && s0.C(this.h, ((s0)object0).h) : false;
    }

    @Override  // c2.y0
    public d g(int v) {
        return this.w(v, false);
    }

    @Override  // c2.y0
    public d h(int v) {
        return this.w(v, true);
    }

    @Override  // c2.y0
    public final d l() {
        if(this.e == null) {
            this.e = d.c(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override  // c2.y0
    public B0 n(int v, int v1, int v2, int v3) {
        o0 o00;
        B0 b00 = B0.h(null, this.c);
        int v4 = Build.VERSION.SDK_INT;
        if(v4 >= 34) {
            o00 = new q0(b00);
        }
        else if(v4 >= 30) {
            o00 = new p0(b00);
        }
        else if(v4 >= 29) {
            o00 = new o0(b00);
        }
        else {
            o00 = new m0(b00);
        }
        o00.g(B0.e(this.l(), v, v1, v2, v3));
        o00.e(B0.e(this.j(), v, v1, v2, v3));
        return o00.b();
    }

    @Override  // c2.y0
    public boolean p() {
        return this.c.isRound();
    }

    @Override  // c2.y0
    @SuppressLint({"WrongConstant"})
    public boolean q(int v) {
        for(int v1 = 1; v1 <= 0x200; v1 <<= 1) {
            if((v & v1) != 0 && !this.A(v1)) {
                return false;
            }
        }
        return true;
    }

    @Override  // c2.y0
    public void r(d[] arr_d) {
        this.d = arr_d;
    }

    @Override  // c2.y0
    public void s(d d0) {
        this.g = d0;
    }

    @Override  // c2.y0
    public void t(B0 b00) {
        this.f = b00;
    }

    @Override  // c2.y0
    public void v(int v) {
        this.h = v;
    }

    @SuppressLint({"WrongConstant"})
    private d w(int v, boolean z) {
        d d0 = d.e;
        for(int v1 = 1; v1 <= 0x200; v1 <<= 1) {
            if((v & v1) != 0) {
                d0 = d.a(d0, this.x(v1, z));
            }
        }
        return d0;
    }

    public d x(int v, boolean z) {
        d d0 = d.e;
        int v1 = 0;
        if(v != 1) {
            d d1 = null;
            switch(v) {
                case 2: {
                    if(z) {
                        d d4 = this.y();
                        d d5 = this.j();
                        return d.c(Math.max(d4.a, d5.a), 0, Math.max(d4.c, d5.c), Math.max(d4.d, d5.d));
                    }
                    if((this.h & 2) == 0) {
                        d d6 = this.l();
                        B0 b01 = this.f;
                        if(b01 != null) {
                            d1 = b01.a.j();
                        }
                        return d.c(d6.a, 0, d6.c, (d1 == null ? d6.d : Math.min(d6.d, d1.d)));
                    }
                    break;
                }
                case 8: {
                    d[] arr_d = this.d;
                    if(arr_d != null) {
                        d1 = arr_d[a.u(8)];
                    }
                    if(d1 != null) {
                        return d1;
                    }
                    d d2 = this.l();
                    d d3 = this.y();
                    int v6 = d2.d;
                    if(v6 > d3.d) {
                        return d.c(0, 0, 0, v6);
                    }
                    if(this.g != null && !this.g.equals(d0)) {
                        int v7 = this.g.d;
                        return v7 <= d3.d ? d0 : d.c(0, 0, 0, v7);
                    }
                    break;
                }
                case 16: {
                    return this.k();
                }
                case 0x20: {
                    return this.i();
                }
                case 0x40: {
                    return this.m();
                }
                case 0x80: {
                    B0 b00 = this.f;
                    j j0 = b00 == null ? this.f() : b00.a.f();
                    if(j0 != null) {
                        int v2 = Build.VERSION.SDK_INT;
                        int v3 = v2 < 28 ? 0 : P1.a.j(j0.a);
                        int v4 = v2 < 28 ? 0 : P1.a.l(j0.a);
                        int v5 = v2 < 28 ? 0 : P1.a.k(j0.a);
                        if(v2 >= 28) {
                            v1 = P1.a.i(j0.a);
                        }
                        return d.c(v3, v4, v5, v1);
                    }
                    break;
                }
                default: {
                    return d0;
                }
            }
            return d0;
        }
        if(z) {
            d d7 = this.y();
            d d8 = this.l();
            return d.c(0, Math.max(d7.b, d8.b), 0, 0);
        }
        return (this.h & 4) == 0 ? d.c(0, this.l().b, 0, 0) : d0;
    }

    private d y() {
        return this.f == null ? d.e : this.f.a.j();
    }

    private d z(View view0) {
        if(Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if(!s0.i) {
            s0.B();
        }
        Method method0 = s0.j;
        if(method0 != null && s0.k != null && s0.l != null) {
            try {
                Object object0 = method0.invoke(view0, null);
                if(object0 == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Object object1 = s0.m.get(object0);
                Rect rect0 = (Rect)s0.l.get(object1);
                return rect0 != null ? d.c(rect0.left, rect0.top, rect0.right, rect0.bottom) : null;
            }
            catch(ReflectiveOperationException reflectiveOperationException0) {
            }
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + reflectiveOperationException0.getMessage(), reflectiveOperationException0);
        }
        return null;
    }
}

