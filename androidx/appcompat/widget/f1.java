package androidx.appcompat.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.MenuBuilder;
import j.c;
import java.util.ArrayList;
import k.C;
import k.m;
import k.w;

public final class f1 implements w {
    public MenuBuilder a;
    public m b;
    public final Toolbar c;

    public f1(Toolbar toolbar0) {
        this.c = toolbar0;
    }

    @Override  // k.w
    public final void b(MenuBuilder menuBuilder0, boolean z) {
    }

    @Override  // k.w
    public final boolean c(m m0) {
        Toolbar toolbar0 = this.c;
        View view0 = toolbar0.i;
        if(view0 instanceof c) {
            ((c)view0).onActionViewCollapsed();
        }
        toolbar0.removeView(toolbar0.i);
        toolbar0.removeView(toolbar0.h);
        toolbar0.i = null;
        ArrayList arrayList0 = toolbar0.d0;
        for(int v = arrayList0.size() - 1; v >= 0; --v) {
            toolbar0.addView(((View)arrayList0.get(v)));
        }
        arrayList0.clear();
        this.b = null;
        toolbar0.requestLayout();
        m0.C = false;
        m0.n.p(false);
        toolbar0.w();
        return true;
    }

    @Override  // k.w
    public final void d(Parcelable parcelable0) {
    }

    @Override  // k.w
    public final Parcelable e() {
        return null;
    }

    @Override  // k.w
    public final boolean f(m m0) {
        Toolbar toolbar0 = this.c;
        toolbar0.c();
        ViewParent viewParent0 = toolbar0.h.getParent();
        if(viewParent0 != toolbar0) {
            if(viewParent0 instanceof ViewGroup) {
                ((ViewGroup)viewParent0).removeView(toolbar0.h);
            }
            toolbar0.addView(toolbar0.h);
        }
        View view0 = m0.getActionView();
        toolbar0.i = view0;
        this.b = m0;
        ViewParent viewParent1 = view0.getParent();
        if(viewParent1 != toolbar0) {
            if(viewParent1 instanceof ViewGroup) {
                ((ViewGroup)viewParent1).removeView(toolbar0.i);
            }
            LayoutParams toolbar$LayoutParams0 = Toolbar.h();
            toolbar$LayoutParams0.a = toolbar0.n & 0x70 | 0x800003;
            toolbar$LayoutParams0.b = 2;
            toolbar0.i.setLayoutParams(toolbar$LayoutParams0);
            toolbar0.addView(toolbar0.i);
        }
        for(int v = toolbar0.getChildCount() - 1; v >= 0; --v) {
            View view1 = toolbar0.getChildAt(v);
            if(((LayoutParams)view1.getLayoutParams()).b != 2 && view1 != toolbar0.a) {
                toolbar0.removeViewAt(v);
                toolbar0.d0.add(view1);
            }
        }
        toolbar0.requestLayout();
        m0.C = true;
        m0.n.p(false);
        View view2 = toolbar0.i;
        if(view2 instanceof c) {
            ((c)view2).onActionViewExpanded();
        }
        toolbar0.w();
        return true;
    }

    @Override  // k.w
    public final boolean g(C c0) {
        return false;
    }

    @Override  // k.w
    public final int getId() {
        return 0;
    }

    @Override  // k.w
    public final void i(boolean z) {
        if(this.b != null) {
            MenuBuilder menuBuilder0 = this.a;
            if(menuBuilder0 != null) {
                int v = menuBuilder0.f.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    if(this.a.getItem(v1) == this.b) {
                        return;
                    }
                }
            }
            this.c(this.b);
        }
    }

    @Override  // k.w
    public final boolean j() {
        return false;
    }

    @Override  // k.w
    public final void k(Context context0, MenuBuilder menuBuilder0) {
        MenuBuilder menuBuilder1 = this.a;
        if(menuBuilder1 != null) {
            m m0 = this.b;
            if(m0 != null) {
                menuBuilder1.d(m0);
            }
        }
        this.a = menuBuilder0;
    }
}

