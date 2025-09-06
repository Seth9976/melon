package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuBuilder;
import i.n.i.b.a.s.e.Ga;
import java.lang.reflect.Method;
import k.m;

public final class C0 extends ListPopupWindow implements y0 {
    public Ga X;
    public static final Method Y;

    static {
        try {
            if(Build.VERSION.SDK_INT <= 28) {
                C0.Y = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        }
        catch(NoSuchMethodException unused_ex) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override  // androidx.appcompat.widget.y0
    public final void f(MenuBuilder menuBuilder0, m m0) {
        Ga ga0 = this.X;
        if(ga0 != null) {
            ga0.f(menuBuilder0, m0);
        }
    }

    @Override  // androidx.appcompat.widget.y0
    public final void m(MenuBuilder menuBuilder0, MenuItem menuItem0) {
        Ga ga0 = this.X;
        if(ga0 != null) {
            ga0.m(menuBuilder0, menuItem0);
        }
    }

    @Override  // androidx.appcompat.widget.ListPopupWindow
    public final o0 p(Context context0, boolean z) {
        o0 o00 = new B0(context0, z);
        ((B0)o00).setHoverListener(this);
        return o00;
    }
}

