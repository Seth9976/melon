package androidx.appcompat.app;

import P1.c;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window.Callback;
import android.widget.FrameLayout.LayoutParams;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.o1;
import androidx.appcompat.widget.p1;
import c2.B0;
import c2.N;
import c2.W;
import c2.v;
import java.lang.reflect.Method;

public final class q implements c0, v, k.v {
    public final int a;
    public final D b;

    public q(D d0, int v) {
        this.a = v;
        this.b = d0;
        super();
    }

    @Override  // k.v
    public void b(MenuBuilder menuBuilder0, boolean z) {
        C c0;
        if(this.a != 2) {
            MenuBuilder menuBuilder1 = menuBuilder0.k();
            boolean z1 = menuBuilder1 != menuBuilder0;
            if(z1) {
                menuBuilder0 = menuBuilder1;
            }
            D d0 = this.b;
            C[] arr_c = d0.h0;
            int v1 = arr_c == null ? 0 : arr_c.length;
            for(int v = 0; true; ++v) {
                c0 = null;
                if(v >= v1) {
                    break;
                }
                C c1 = arr_c[v];
                if(c1 != null && c1.h == menuBuilder0) {
                    c0 = c1;
                    break;
                }
            }
            if(c0 != null) {
                if(z1) {
                    d0.r(c0.a, c0, menuBuilder1);
                    d0.t(c0, true);
                    return;
                }
                d0.t(c0, z);
            }
            return;
        }
        this.b.s(menuBuilder0);
    }

    @Override  // k.v
    public boolean m(MenuBuilder menuBuilder0) {
        if(this.a != 2) {
            if(menuBuilder0 == menuBuilder0.k()) {
                D d0 = this.b;
                if(d0.b0) {
                    Window.Callback window$Callback0 = d0.l.getCallback();
                    if(window$Callback0 != null && !d0.m0) {
                        window$Callback0.onMenuOpened(108, menuBuilder0);
                    }
                }
            }
            return true;
        }
        Window.Callback window$Callback1 = this.b.l.getCallback();
        if(window$Callback1 != null) {
            window$Callback1.onMenuOpened(108, menuBuilder0);
        }
        return true;
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        int v12;
        int v9;
        int v = b00.d();
        D d0 = this.b;
        Context context0 = d0.k;
        int v1 = b00.d();
        int v2 = 8;
        if(d0.I == null || !(d0.I.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            v12 = 0;
        }
        else {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = d0.I.getLayoutParams();
            int v3 = 1;
            if(d0.I.isShown()) {
                if(d0.y0 == null) {
                    d0.y0 = new Rect();
                    d0.z0 = new Rect();
                }
                Rect rect0 = d0.y0;
                Rect rect1 = d0.z0;
                rect0.set(b00.b(), b00.d(), b00.c(), b00.a());
                ViewGroup viewGroup0 = d0.V;
                Class class0 = Rect.class;
                if(Build.VERSION.SDK_INT >= 29) {
                    o1.a(viewGroup0, rect0, rect1);
                }
                else {
                    if(!p1.a) {
                        try {
                            p1.a = true;
                            Method method0 = View.class.getDeclaredMethod("computeFitSystemWindows", class0, class0);
                            p1.b = method0;
                            if(!method0.isAccessible()) {
                                p1.b.setAccessible(true);
                            }
                        }
                        catch(NoSuchMethodException unused_ex) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method1 = p1.b;
                    if(method1 != null) {
                        try {
                            method1.invoke(viewGroup0, rect0, rect1);
                        }
                        catch(Exception exception0) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", exception0);
                        }
                    }
                }
                int v4 = rect0.top;
                int v5 = rect0.left;
                int v6 = rect0.right;
                B0 b01 = N.a(d0.V);
                int v7 = b01 == null ? 0 : b01.b();
                int v8 = b01 == null ? 0 : b01.c();
                if(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin != v4 || ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin != v5 || ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin != v6) {
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = v4;
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin = v5;
                    ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = v6;
                    v9 = 1;
                }
                else {
                    v9 = 0;
                }
                if(v4 <= 0 || d0.X != null) {
                    View view2 = d0.X;
                    if(view2 != null) {
                        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view2.getLayoutParams();
                        int v10 = viewGroup$MarginLayoutParams0.height;
                        int v11 = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin;
                        if(v10 != v11 || viewGroup$MarginLayoutParams0.leftMargin != v7 || viewGroup$MarginLayoutParams0.rightMargin != v8) {
                            viewGroup$MarginLayoutParams0.height = v11;
                            viewGroup$MarginLayoutParams0.leftMargin = v7;
                            viewGroup$MarginLayoutParams0.rightMargin = v8;
                            d0.X.setLayoutParams(viewGroup$MarginLayoutParams0);
                        }
                    }
                }
                else {
                    View view1 = new View(context0);
                    d0.X = view1;
                    view1.setVisibility(8);
                    FrameLayout.LayoutParams frameLayout$LayoutParams0 = new FrameLayout.LayoutParams(-1, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin, 51);
                    frameLayout$LayoutParams0.leftMargin = v7;
                    frameLayout$LayoutParams0.rightMargin = v8;
                    d0.V.addView(d0.X, -1, frameLayout$LayoutParams0);
                }
                View view3 = d0.X;
                if(view3 == null) {
                    v3 = 0;
                }
                else if(view3.getVisibility() != 0) {
                    d0.X.setBackgroundColor(((d0.X.getWindowSystemUiVisibility() & 0x2000) == 0 ? c.getColor(context0, 0x7F060005) : c.getColor(context0, 0x7F060006)));  // color:abc_decor_view_status_guard
                }
                if(!d0.d0 && v3 != 0) {
                    v1 = 0;
                }
                v12 = v3;
                v3 = v9;
            }
            else if(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin == 0) {
                v12 = 0;
                v3 = 0;
            }
            else {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = 0;
                v12 = 0;
            }
            if(v3 != 0) {
                d0.I.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
            }
        }
        View view4 = d0.X;
        if(view4 != null) {
            if(v12 != 0) {
                v2 = 0;
            }
            view4.setVisibility(v2);
        }
        return v == v1 ? W.j(view0, b00) : W.j(view0, b00.f(b00.b(), v1, b00.c(), b00.a()));
    }
}

