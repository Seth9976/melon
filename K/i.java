package k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.ArrayList;

public final class i extends BaseAdapter {
    public final MenuBuilder a;
    public int b;
    public boolean c;
    public final boolean d;
    public final LayoutInflater e;
    public final int f;

    public i(MenuBuilder menuBuilder0, LayoutInflater layoutInflater0, boolean z, int v) {
        this.b = -1;
        this.d = z;
        this.e = layoutInflater0;
        this.a = menuBuilder0;
        this.f = v;
        this.a();
    }

    public final void a() {
        MenuBuilder menuBuilder0 = this.a;
        m m0 = menuBuilder0.v;
        if(m0 != null) {
            menuBuilder0.i();
            ArrayList arrayList0 = menuBuilder0.j;
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((m)arrayList0.get(v1)) == m0) {
                    this.b = v1;
                    return;
                }
            }
        }
        this.b = -1;
    }

    public final m b(int v) {
        ArrayList arrayList0;
        MenuBuilder menuBuilder0 = this.a;
        if(this.d) {
            menuBuilder0.i();
            arrayList0 = menuBuilder0.j;
        }
        else {
            arrayList0 = menuBuilder0.l();
        }
        if(this.b >= 0 && v >= this.b) {
            ++v;
        }
        return (m)arrayList0.get(v);
    }

    @Override  // android.widget.Adapter
    public final int getCount() {
        MenuBuilder menuBuilder0 = this.a;
        if(this.d) {
            menuBuilder0.i();
            return this.b >= 0 ? menuBuilder0.j.size() - 1 : menuBuilder0.j.size();
        }
        ArrayList arrayList0 = menuBuilder0.l();
        return this.b >= 0 ? arrayList0.size() - 1 : arrayList0.size();
    }

    @Override  // android.widget.Adapter
    public final Object getItem(int v) {
        return this.b(v);
    }

    @Override  // android.widget.Adapter
    public final long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.Adapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        boolean z = false;
        if(view0 == null) {
            view0 = this.e.inflate(this.f, viewGroup0, false);
        }
        int v1 = this.b(v).b;
        int v2 = v - 1 < 0 ? v1 : this.b(v - 1).b;
        if(this.a.m() && v1 != v2) {
            z = true;
        }
        ((ListMenuItemView)view0).setGroupDividerEnabled(z);
        if(this.c) {
            ((ListMenuItemView)view0).setForceShowIcon(true);
        }
        ((x)view0).c(this.b(v));
        return view0;
    }

    @Override  // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        this.a();
        super.notifyDataSetChanged();
    }
}

