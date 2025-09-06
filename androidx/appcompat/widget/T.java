package androidx.appcompat.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public final class t extends BaseAdapter {
    public p a;
    public int b;
    public boolean c;
    public boolean d;
    public boolean e;
    public final ActivityChooserView f;

    public t(ActivityChooserView activityChooserView0) {
        this.f = activityChooserView0;
        super();
        this.b = 4;
    }

    @Override  // android.widget.Adapter
    public final int getCount() {
        int v = this.a.d();
        if(!this.c) {
            this.a.e();
        }
        int v1 = Math.min(v, this.b);
        return this.e ? v1 + 1 : v1;
    }

    @Override  // android.widget.Adapter
    public final Object getItem(int v) {
        switch(this.getItemViewType(v)) {
            case 0: {
                if(!this.c) {
                    this.a.e();
                }
                this.a.c(v);
                throw null;
            }
            case 1: {
                return null;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override  // android.widget.Adapter
    public final long getItemId(int v) {
        return (long)v;
    }

    @Override  // android.widget.BaseAdapter
    public final int getItemViewType(int v) {
        return !this.e || v != this.getCount() - 1 ? 0 : 1;
    }

    @Override  // android.widget.Adapter
    public final View getView(int v, View view0, ViewGroup viewGroup0) {
        int v1 = this.getItemViewType(v);
        ActivityChooserView activityChooserView0 = this.f;
        switch(v1) {
            case 0: {
                if(view0 == null || view0.getId() != 0x7F0A077E) {  // id:list_item
                    view0 = LayoutInflater.from(activityChooserView0.getContext()).inflate(0x7F0D0007, viewGroup0, false);  // layout:abc_activity_chooser_view_list_item
                }
                activityChooserView0.getContext().getPackageManager();
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0546);  // id:icon
                this.getItem(v);
                throw null;
            }
            case 1: {
                if(view0 != null && view0.getId() == 1) {
                    return view0;
                }
                View view1 = LayoutInflater.from(activityChooserView0.getContext()).inflate(0x7F0D0007, viewGroup0, false);  // layout:abc_activity_chooser_view_list_item
                view1.setId(1);
                ((TextView)view1.findViewById(0x7F0A0B8D)).setText("See all");  // id:title
                return view1;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override  // android.widget.BaseAdapter
    public final int getViewTypeCount() {
        return 3;
    }
}

