package k;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController.AlertParams;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.view.menu.MenuBuilder;

public final class h implements AdapterView.OnItemClickListener, w {
    public Context a;
    public LayoutInflater b;
    public MenuBuilder c;
    public ExpandedMenuView d;
    public v e;
    public g f;

    public h(Context context0) {
        this.a = context0;
        this.b = LayoutInflater.from(context0);
    }

    @Override  // k.w
    public final void b(MenuBuilder menuBuilder0, boolean z) {
        v v0 = this.e;
        if(v0 != null) {
            v0.b(menuBuilder0, z);
        }
    }

    @Override  // k.w
    public final boolean c(m m0) {
        return false;
    }

    @Override  // k.w
    public final void d(Parcelable parcelable0) {
        SparseArray sparseArray0 = ((Bundle)parcelable0).getSparseParcelableArray("android:menu:list");
        if(sparseArray0 != null) {
            this.d.restoreHierarchyState(sparseArray0);
        }
    }

    @Override  // k.w
    public final Parcelable e() {
        if(this.d == null) {
            return null;
        }
        Parcelable parcelable0 = new Bundle();
        SparseArray sparseArray0 = new SparseArray();
        ExpandedMenuView expandedMenuView0 = this.d;
        if(expandedMenuView0 != null) {
            expandedMenuView0.saveHierarchyState(sparseArray0);
        }
        ((Bundle)parcelable0).putSparseParcelableArray("android:menu:list", sparseArray0);
        return parcelable0;
    }

    @Override  // k.w
    public final boolean f(m m0) {
        return false;
    }

    @Override  // k.w
    public final boolean g(C c0) {
        boolean z = c0.hasVisibleItems();
        Context context0 = c0.a;
        if(!z) {
            return false;
        }
        l l0 = new l();  // 初始化器: Ljava/lang/Object;-><init>()V
        l0.a = c0;
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(context0);
        AlertController.AlertParams alertController$AlertParams0 = alertDialog$Builder0.a;
        h h0 = new h(alertController$AlertParams0.a);
        l0.c = h0;
        h0.e = l0;
        c0.b(h0, context0);
        h h1 = l0.c;
        if(h1.f == null) {
            h1.f = new g(h1);
        }
        alertController$AlertParams0.q = h1.f;
        alertController$AlertParams0.r = l0;
        View view0 = c0.o;
        if(view0 == null) {
            alertController$AlertParams0.d = c0.n;
            alertController$AlertParams0.e = c0.m;
        }
        else {
            alertController$AlertParams0.f = view0;
        }
        alertController$AlertParams0.p = l0;
        androidx.appcompat.app.g g0 = alertDialog$Builder0.a();
        l0.b = g0;
        g0.setOnDismissListener(l0);
        WindowManager.LayoutParams windowManager$LayoutParams0 = l0.b.getWindow().getAttributes();
        windowManager$LayoutParams0.type = 1003;
        windowManager$LayoutParams0.flags |= 0x20000;
        l0.b.show();
        v v0 = this.e;
        if(v0 != null) {
            v0.m(c0);
        }
        return true;
    }

    @Override  // k.w
    public final int getId() {
        return 0;
    }

    @Override  // k.w
    public final void h(v v0) {
        throw null;
    }

    @Override  // k.w
    public final void i(boolean z) {
        g g0 = this.f;
        if(g0 != null) {
            g0.notifyDataSetChanged();
        }
    }

    @Override  // k.w
    public final boolean j() {
        return false;
    }

    @Override  // k.w
    public final void k(Context context0, MenuBuilder menuBuilder0) {
        if(this.a != null) {
            this.a = context0;
            if(this.b == null) {
                this.b = LayoutInflater.from(context0);
            }
        }
        this.c = menuBuilder0;
        g g0 = this.f;
        if(g0 != null) {
            g0.notifyDataSetChanged();
        }
    }

    @Override  // android.widget.AdapterView$OnItemClickListener
    public final void onItemClick(AdapterView adapterView0, View view0, int v, long v1) {
        this.c.q(this.f.b(v), this, 0);
    }
}

