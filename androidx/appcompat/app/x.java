package androidx.appcompat.app;

import android.view.ActionMode.Callback;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.V;
import j.i;
import j.j;
import j.k;
import java.util.ArrayList;
import java.util.List;
import o9.b;

public final class x implements Window.Callback {
    public final Window.Callback a;
    public J b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final D f;

    public x(D d0, Window.Callback window$Callback0) {
        this.f = d0;
        if(window$Callback0 == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.a = window$Callback0;
    }

    public final void a(Window.Callback window$Callback0) {
        try {
            this.c = true;
            window$Callback0.onContentChanged();
            this.c = false;
        }
        catch(Throwable throwable0) {
            this.c = false;
            throw throwable0;
        }
    }

    public final boolean b(int v, Menu menu0) {
        return this.a.onMenuOpened(v, menu0);
    }

    public final void c(int v, Menu menu0) {
        this.a.onPanelClosed(v, menu0);
    }

    public final void d(List list0, Menu menu0, int v) {
        j.a(this.a, list0, menu0, v);
    }

    @Override  // android.view.Window$Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent0) {
        return this.a.dispatchGenericMotionEvent(motionEvent0);
    }

    // 去混淆评级： 低(40)
    @Override  // android.view.Window$Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent0) {
        return this.d ? this.a.dispatchKeyEvent(keyEvent0) : this.f.v(keyEvent0) || this.a.dispatchKeyEvent(keyEvent0);
    }

    @Override  // android.view.Window$Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent0) {
        if(!this.a.dispatchKeyShortcutEvent(keyEvent0)) {
            int v = keyEvent0.getKeyCode();
            D d0 = this.f;
            d0.B();
            if(d0.o == null || !d0.o.j(v, keyEvent0)) {
                if(d0.i0 == null || !d0.G(d0.i0, keyEvent0.getKeyCode(), keyEvent0)) {
                    goto label_10;
                }
                C c0 = d0.i0;
                if(c0 != null) {
                    c0.l = true;
                    return true;
                label_10:
                    if(d0.i0 == null) {
                        C c1 = d0.A(0);
                        d0.H(c1, keyEvent0);
                        boolean z = d0.G(c1, keyEvent0.getKeyCode(), keyEvent0);
                        c1.k = false;
                        return z;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    @Override  // android.view.Window$Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent0);
    }

    @Override  // android.view.Window$Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent0) {
        return this.a.dispatchTouchEvent(motionEvent0);
    }

    @Override  // android.view.Window$Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent0) {
        return this.a.dispatchTrackballEvent(motionEvent0);
    }

    @Override  // android.view.Window$Callback
    public final void onActionModeFinished(ActionMode actionMode0) {
        this.a.onActionModeFinished(actionMode0);
    }

    @Override  // android.view.Window$Callback
    public final void onActionModeStarted(ActionMode actionMode0) {
        this.a.onActionModeStarted(actionMode0);
    }

    @Override  // android.view.Window$Callback
    public final void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override  // android.view.Window$Callback
    public final void onContentChanged() {
        if(this.c) {
            this.a.onContentChanged();
        }
    }

    @Override  // android.view.Window$Callback
    public final boolean onCreatePanelMenu(int v, Menu menu0) {
        return v != 0 || menu0 instanceof MenuBuilder ? this.a.onCreatePanelMenu(v, menu0) : false;
    }

    @Override  // android.view.Window$Callback
    public final View onCreatePanelView(int v) {
        J j0 = this.b;
        if(j0 != null) {
            View view0 = v == 0 ? new View(j0.a.a.a.getContext()) : null;
            return view0 == null ? this.a.onCreatePanelView(v) : view0;
        }
        return this.a.onCreatePanelView(v);
    }

    @Override  // android.view.Window$Callback
    public final void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override  // android.view.Window$Callback
    public final boolean onMenuItemSelected(int v, MenuItem menuItem0) {
        return this.a.onMenuItemSelected(v, menuItem0);
    }

    @Override  // android.view.Window$Callback
    public final boolean onMenuOpened(int v, Menu menu0) {
        this.b(v, menu0);
        D d0 = this.f;
        if(v == 108) {
            d0.B();
            a a0 = d0.o;
            if(a0 != null) {
                a0.c(true);
                return true;
            }
        }
        else {
            d0.getClass();
        }
        return true;
    }

    @Override  // android.view.Window$Callback
    public final void onPanelClosed(int v, Menu menu0) {
        if(this.e) {
            this.a.onPanelClosed(v, menu0);
            return;
        }
        this.c(v, menu0);
        D d0 = this.f;
        if(v == 108) {
            d0.B();
            a a0 = d0.o;
            if(a0 != null) {
                a0.c(false);
            }
        }
        else if(v == 0) {
            C c0 = d0.A(0);
            if(c0.m) {
                d0.t(c0, false);
            }
        }
    }

    @Override  // android.view.Window$Callback
    public final void onPointerCaptureChanged(boolean z) {
        k.a(this.a, z);
    }

    @Override  // android.view.Window$Callback
    public final boolean onPreparePanel(int v, View view0, Menu menu0) {
        MenuBuilder menuBuilder0 = menu0 instanceof MenuBuilder ? ((MenuBuilder)menu0) : null;
        if(v == 0 && menuBuilder0 == null) {
            return false;
        }
        if(menuBuilder0 != null) {
            menuBuilder0.x = true;
        }
        J j0 = this.b;
        if(j0 != null && v == 0) {
            K k0 = j0.a;
            if(!k0.d) {
                k0.a.l = true;
                k0.d = true;
            }
        }
        boolean z = this.a.onPreparePanel(v, view0, menu0);
        if(menuBuilder0 != null) {
            menuBuilder0.x = false;
        }
        return z;
    }

    @Override  // android.view.Window$Callback
    public final void onProvideKeyboardShortcuts(List list0, Menu menu0, int v) {
        MenuBuilder menuBuilder0 = this.f.A(0).h;
        if(menuBuilder0 != null) {
            this.d(list0, menuBuilder0, v);
            return;
        }
        this.d(list0, menu0, v);
    }

    @Override  // android.view.Window$Callback
    public final boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    @Override  // android.view.Window$Callback
    public final boolean onSearchRequested(SearchEvent searchEvent0) {
        return i.a(this.a, searchEvent0);
    }

    @Override  // android.view.Window$Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams windowManager$LayoutParams0) {
        this.a.onWindowAttributesChanged(windowManager$LayoutParams0);
    }

    @Override  // android.view.Window$Callback
    public final void onWindowFocusChanged(boolean z) {
        this.a.onWindowFocusChanged(z);
    }

    @Override  // android.view.Window$Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback0) {
        return null;
    }

    @Override  // android.view.Window$Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback actionMode$Callback0, int v) {
        if(v != 0) {
            return i.b(this.a, actionMode$Callback0, v);
        }
        b b0 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
        b0.b = this.f.k;
        b0.a = actionMode$Callback0;
        b0.c = new ArrayList();
        b0.d = new V(0);
        j.b b1 = this.f.n(b0);
        return b1 != null ? b0.p(b1) : null;
    }
}

