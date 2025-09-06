package k;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.ArrayList;

public final class g extends BaseAdapter {
    public int a;
    public final h b;

    public g(h h0) {
        this.b = h0;
        super();
        this.a = -1;
        this.a();
    }

    public final void a() {
        MenuBuilder menuBuilder0 = this.b.c;
        m m0 = menuBuilder0.v;
        if(m0 != null) {
            menuBuilder0.i();
            ArrayList arrayList0 = menuBuilder0.j;
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                if(((m)arrayList0.get(v1)) == m0) {
                    this.a = v1;
                    return;
                }
            }
        }
        this.a = -1;
    }

    public final m b(int v) {
        MenuBuilder menuBuilder0 = this.b.c;
        menuBuilder0.i();
        ArrayList arrayList0 = menuBuilder0.j;
        this.b.getClass();
        if(this.a >= 0 && v >= this.a) {
            ++v;
        }
        return (m)arrayList0.get(v);
    }

    @Override  // android.widget.Adapter
    public final int getCount() {
        MenuBuilder menuBuilder0 = this.b.c;
        menuBuilder0.i();
        int v = menuBuilder0.j.size();
        this.b.getClass();
        return this.a >= 0 ? v - 1 : v;
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
        if(view0 == null) {
            view0 = this.b.b.inflate(0x7F0D0010, viewGroup0, false);  // layout:abc_list_menu_item_layout
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

