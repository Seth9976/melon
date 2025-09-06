package k;

import Q0.x;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.A0;
import androidx.appcompat.widget.C0;
import androidx.appcompat.widget.o0;
import androidx.appcompat.widget.z0;
import com.google.android.material.navigation.m;
import com.iloen.melon.utils.a;
import i.n.i.b.a.s.e.Ga;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class f extends s implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public boolean B;
    public int D;
    public int E;
    public boolean G;
    public boolean I;
    public v M;
    public ViewTreeObserver N;
    public PopupWindow.OnDismissListener S;
    public boolean T;
    public final Context b;
    public final int c;
    public final int d;
    public final boolean e;
    public final Handler f;
    public final ArrayList g;
    public final ArrayList h;
    public final m i;
    public final x j;
    public final Ga k;
    public int l;
    public int m;
    public View n;
    public View o;
    public int r;
    public boolean w;

    public f(Context context0, View view0, int v, boolean z) {
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new m(this, 1);
        this.j = new x(this, 3);
        this.k = new Ga(this, 22);
        int v1 = 0;
        this.l = 0;
        this.m = 0;
        this.b = context0;
        this.n = view0;
        this.d = v;
        this.e = z;
        this.G = false;
        if(view0.getLayoutDirection() != 1) {
            v1 = 1;
        }
        this.r = v1;
        Resources resources0 = context0.getResources();
        this.c = Math.max(resources0.getDisplayMetrics().widthPixels / 2, resources0.getDimensionPixelSize(0x7F070017));  // dimen:abc_config_prefDialogWidth
        this.f = new Handler();
    }

    @Override  // k.A
    public final boolean a() {
        return this.h.size() > 0 && ((e)this.h.get(0)).a.T.isShowing();
    }

    @Override  // k.w
    public final void b(MenuBuilder menuBuilder0, boolean z) {
        ArrayList arrayList0 = this.h;
        int v = arrayList0.size();
        int v1;
        for(v1 = 0; true; ++v1) {
            if(v1 >= v) {
                v1 = -1;
                break;
            }
            if(menuBuilder0 == ((e)arrayList0.get(v1)).b) {
                break;
            }
        }
        if(v1 >= 0) {
            if(v1 + 1 < arrayList0.size()) {
                ((e)arrayList0.get(v1 + 1)).b.c(false);
            }
            e e0 = (e)arrayList0.remove(v1);
            C0 c00 = e0.a;
            e0.b.r(this);
            if(this.T) {
                z0.b(c00.T, null);
                c00.T.setAnimationStyle(0);
            }
            c00.dismiss();
            int v2 = arrayList0.size();
            if(v2 > 0) {
                this.r = ((e)arrayList0.get(v2 - 1)).c;
            }
            else {
                this.r = this.n.getLayoutDirection() == 1 ? 0 : 1;
            }
            if(v2 == 0) {
                this.dismiss();
                v v3 = this.M;
                if(v3 != null) {
                    v3.b(menuBuilder0, true);
                }
                ViewTreeObserver viewTreeObserver0 = this.N;
                if(viewTreeObserver0 != null) {
                    if(viewTreeObserver0.isAlive()) {
                        this.N.removeGlobalOnLayoutListener(this.i);
                    }
                    this.N = null;
                }
                this.o.removeOnAttachStateChangeListener(this.j);
                this.S.onDismiss();
                return;
            }
            if(z) {
                ((e)arrayList0.get(0)).b.c(false);
            }
        }
    }

    @Override  // k.w
    public final void d(Parcelable parcelable0) {
    }

    @Override  // k.A
    public final void dismiss() {
        ArrayList arrayList0 = this.h;
        int v = arrayList0.size();
        if(v > 0) {
            e[] arr_e = (e[])arrayList0.toArray(new e[v]);
            for(int v1 = v - 1; v1 >= 0; --v1) {
                e e0 = arr_e[v1];
                if(e0.a.T.isShowing()) {
                    e0.a.dismiss();
                }
            }
        }
    }

    @Override  // k.w
    public final Parcelable e() {
        return null;
    }

    @Override  // k.w
    public final boolean g(C c0) {
        for(Object object0: this.h) {
            e e0 = (e)object0;
            if(c0 == e0.b) {
                e0.a.c.requestFocus();
                return true;
            }
            if(false) {
                break;
            }
        }
        if(c0.hasVisibleItems()) {
            this.l(c0);
            v v0 = this.M;
            if(v0 != null) {
                v0.m(c0);
            }
            return true;
        }
        return false;
    }

    @Override  // k.w
    public final void h(v v0) {
        this.M = v0;
    }

    @Override  // k.w
    public final void i(boolean z) {
        for(Object object0: this.h) {
            ListAdapter listAdapter0 = ((e)object0).a.c.getAdapter();
            (listAdapter0 instanceof HeaderViewListAdapter ? ((i)((HeaderViewListAdapter)listAdapter0).getWrappedAdapter()) : ((i)listAdapter0)).notifyDataSetChanged();
        }
    }

    @Override  // k.w
    public final boolean j() {
        return false;
    }

    @Override  // k.s
    public final void l(MenuBuilder menuBuilder0) {
        menuBuilder0.b(this, this.b);
        if(this.a()) {
            this.v(menuBuilder0);
            return;
        }
        this.g.add(menuBuilder0);
    }

    // 去混淆评级： 低(20)
    @Override  // k.A
    public final o0 n() {
        return this.h.isEmpty() ? null : ((e)a.i(1, this.h)).a.c;
    }

    @Override  // k.s
    public final void o(View view0) {
        if(this.n != view0) {
            this.n = view0;
            this.m = Gravity.getAbsoluteGravity(this.l, view0.getLayoutDirection());
        }
    }

    @Override  // android.widget.PopupWindow$OnDismissListener
    public final void onDismiss() {
        e e0;
        ArrayList arrayList0 = this.h;
        int v = arrayList0.size();
        for(int v1 = 0; true; ++v1) {
            e0 = null;
            if(v1 >= v) {
                break;
            }
            e e1 = (e)arrayList0.get(v1);
            if(!e1.a.T.isShowing()) {
                e0 = e1;
                break;
            }
        }
        if(e0 != null) {
            e0.b.c(false);
        }
    }

    @Override  // android.view.View$OnKeyListener
    public final boolean onKey(View view0, int v, KeyEvent keyEvent0) {
        if(keyEvent0.getAction() == 1 && v == 82) {
            this.dismiss();
            return true;
        }
        return false;
    }

    @Override  // k.s
    public final void p(boolean z) {
        this.G = z;
    }

    @Override  // k.s
    public final void q(int v) {
        if(this.l != v) {
            this.l = v;
            this.m = Gravity.getAbsoluteGravity(v, this.n.getLayoutDirection());
        }
    }

    @Override  // k.s
    public final void r(int v) {
        this.w = true;
        this.D = v;
    }

    @Override  // k.s
    public final void s(PopupWindow.OnDismissListener popupWindow$OnDismissListener0) {
        this.S = popupWindow$OnDismissListener0;
    }

    @Override  // k.A
    public final void show() {
        if(!this.a()) {
            ArrayList arrayList0 = this.g;
            for(Object object0: arrayList0) {
                this.v(((MenuBuilder)object0));
            }
            arrayList0.clear();
            View view0 = this.n;
            this.o = view0;
            if(view0 != null) {
                boolean z = this.N == null;
                ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
                this.N = viewTreeObserver0;
                if(z) {
                    viewTreeObserver0.addOnGlobalLayoutListener(this.i);
                }
                this.o.addOnAttachStateChangeListener(this.j);
            }
        }
    }

    @Override  // k.s
    public final void t(boolean z) {
        this.I = z;
    }

    @Override  // k.s
    public final void u(int v) {
        this.B = true;
        this.E = v;
    }

    public final void v(MenuBuilder menuBuilder0) {
        int v10;
        i i1;
        int v5;
        View view0;
        e e0;
        boolean z;
        Context context0 = this.b;
        LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
        i i0 = new i(menuBuilder0, layoutInflater0, this.e, 0x7F0D000B);  // layout:abc_cascading_menu_item_layout
        if(!this.a() && this.G) {
            i0.c = true;
        }
        else if(this.a()) {
            int v = menuBuilder0.f.size();
            for(int v1 = 0; true; ++v1) {
                z = false;
                if(v1 >= v) {
                    break;
                }
                MenuItem menuItem0 = menuBuilder0.getItem(v1);
                if(menuItem0.isVisible() && menuItem0.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            i0.c = z;
        }
        int v2 = s.m(i0, context0, this.c);
        C0 c00 = new C0(context0, null, this.d, 0);  // 初始化器: Landroidx/appcompat/widget/ListPopupWindow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;II)V
        c00.X = this.k;
        c00.r = this;
        c00.T.setOnDismissListener(this);
        c00.o = this.n;
        c00.l = this.m;
        c00.S = true;
        c00.T.setFocusable(true);
        c00.T.setInputMethodMode(2);
        c00.l(i0);
        c00.q(v2);
        c00.l = this.m;
        ArrayList arrayList0 = this.h;
        if(arrayList0.size() > 0) {
            e0 = (e)a.i(1, arrayList0);
            MenuBuilder menuBuilder1 = e0.b;
            int v3 = menuBuilder1.f.size();
            for(int v4 = 0; true; ++v4) {
                MenuItem menuItem1 = null;
                if(v4 >= v3) {
                    break;
                }
                MenuItem menuItem2 = menuBuilder1.getItem(v4);
                if(menuItem2.hasSubMenu() && menuBuilder0 == menuItem2.getSubMenu()) {
                    menuItem1 = menuItem2;
                    break;
                }
            }
            if(menuItem1 == null) {
                view0 = null;
            }
            else {
                o0 o00 = e0.a.c;
                ListAdapter listAdapter0 = o00.getAdapter();
                if(listAdapter0 instanceof HeaderViewListAdapter) {
                    v5 = ((HeaderViewListAdapter)listAdapter0).getHeadersCount();
                    i1 = (i)((HeaderViewListAdapter)listAdapter0).getWrappedAdapter();
                }
                else {
                    i1 = (i)listAdapter0;
                    v5 = 0;
                }
                int v6 = i1.getCount();
                int v7;
                for(v7 = 0; true; ++v7) {
                    if(v7 >= v6) {
                        v7 = -1;
                        break;
                    }
                    if(menuItem1 == i1.b(v7)) {
                        break;
                    }
                }
                if(v7 == -1) {
                    view0 = null;
                }
                else {
                    int v8 = v7 + v5 - o00.getFirstVisiblePosition();
                    view0 = v8 < 0 || v8 >= o00.getChildCount() ? null : o00.getChildAt(v8);
                }
            }
        }
        else {
            e0 = null;
            view0 = null;
        }
        if(view0 == null) {
            if(this.w) {
                c00.f = this.D;
            }
            if(this.B) {
                c00.h(this.E);
            }
            c00.N = this.a == null ? null : new Rect(this.a);
        }
        else {
            PopupWindow popupWindow0 = c00.T;
            if(Build.VERSION.SDK_INT <= 28) {
                Method method0 = C0.Y;
                if(method0 != null) {
                    try {
                        method0.invoke(popupWindow0, Boolean.FALSE);
                    }
                    catch(Exception unused_ex) {
                        Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                    }
                }
            }
            else {
                A0.a(popupWindow0, false);
            }
            z0.a(c00.T, null);
            o0 o01 = ((e)arrayList0.get(arrayList0.size() - 1)).a.c;
            int[] arr_v = new int[2];
            o01.getLocationOnScreen(arr_v);
            Rect rect0 = new Rect();
            this.o.getWindowVisibleDisplayFrame(rect0);
            if(this.r == 1) {
                int v9 = arr_v[0];
                v10 = o01.getWidth() + v9 + v2 <= rect0.right ? 1 : 0;
            }
            else {
                v10 = arr_v[0] - v2 >= 0 ? 0 : 1;
            }
            this.r = v10;
            c00.o = view0;
            if((this.m & 5) != 5) {
                v2 = v10 == 1 ? -v2 : view0.getWidth();
            }
            else if(v10 != 1) {
                v2 = -view0.getWidth();
            }
            c00.f = v2;
            c00.k = true;
            c00.j = true;
            c00.h(0);
        }
        arrayList0.add(new e(c00, menuBuilder0, this.r));
        c00.show();
        o0 o02 = c00.c;
        o02.setOnKeyListener(this);
        if(e0 == null && this.I && menuBuilder0.m != null) {
            FrameLayout frameLayout0 = (FrameLayout)layoutInflater0.inflate(0x7F0D0012, o02, false);  // layout:abc_popup_menu_header_item_layout
            TextView textView0 = (TextView)frameLayout0.findViewById(0x1020016);
            frameLayout0.setEnabled(false);
            textView0.setText(menuBuilder0.m);
            o02.addHeaderView(frameLayout0, null, false);
            c00.show();
        }
    }
}

