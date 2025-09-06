package com.iloen.melon.custom.tablayout;

import A6.d;
import E8.c;
import E8.f;
import E8.g;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnScrollChangeListener;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.List;
import v9.j;
import y8.s;

public class ScrollableAlyacFilter extends RelativeLayout {
    public Context a;
    public HorizontalScrollView b;
    public LinearLayout c;
    public List d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public static final int j;

    public ScrollableAlyacFilter(Context context0) {
        super(context0, null);
        this.e = 0;
        this.b(context0);
    }

    public ScrollableAlyacFilter(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.e = 0;
        this.b(context0);
    }

    public final void a(List list0) {
        List list1 = this.d;
        if(list1 != null) {
            try {
                list1.clear();
            }
            catch(UnsupportedOperationException unused_ex) {
            }
            this.d = null;
            this.c.removeAllViews();
        }
        this.d(list0);
    }

    public final void b(Context context0) {
        this.a = context0;
        View view0 = ((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D0278, this, true);  // layout:filter_scrollable_alyac_layout
        this.b = (HorizontalScrollView)view0.findViewById(0x7F0A0A2F);  // id:scroll_view
        this.c = (LinearLayout)view0.findViewById(0x7F0A0710);  // id:layout_container
        int v = ScreenUtils.dipToPixel(context0, 16.0f);
        this.g = v;
        this.h = v;
        this.i = ScreenUtils.dipToPixel(context0, 8.0f);
    }

    public final void c(int v) {
        if(v >= 0 && !AppUtils.isAccessibilityTalkbackOn()) {
            this.postDelayed(new d(this, v, 1), 100L);
        }
    }

    public final boolean d(List list0) {
        int v = 0;
        if(this.a == null) {
            return false;
        }
        if(this.d != null) {
            return false;
        }
        this.d = list0;
        if(list0 != null) {
            v = list0.size();
        }
        this.f = v;
        return true;
    }

    public final void e(g g0, c c0) {
        this.setOnCustomViewEventListener(new s(g0, this.a, c0));
    }

    public void setOnCustomViewEventListener(f f0) {
        if(f0 == null) {
            return;
        }
        LayoutInflater layoutInflater0 = LayoutInflater.from(this.a);
        int v = 0;
        for(Object object0: this.d) {
            View view0 = layoutInflater0.inflate(0x7F0D002E, null);  // layout:alyac_filter_default_item
            ((TextView)view0.findViewById(0x7F0A04A0)).setText(((j)object0).b);  // id:filter_name_tv
            this.c.addView(view0);
            ((s)f0).s(view0, v == this.e, v, this.f, this.g, this.h, this.i);
            view0.setTag(v);
            ViewUtils.setOnClickListener(view0, new Ad.s(2, this, f0));
            ++v;
        }
        this.c.invalidate();
        this.c(this.e);
    }

    @Override  // android.view.View
    public void setOnScrollChangeListener(View.OnScrollChangeListener view$OnScrollChangeListener0) {
        HorizontalScrollView horizontalScrollView0 = this.b;
        if(horizontalScrollView0 != null) {
            horizontalScrollView0.setOnScrollChangeListener(view$OnScrollChangeListener0);
        }
    }

    public void setPadding(int v) {
        this.g = v;
        this.h = v;
    }

    public void setSelectedIndex(int v) {
        this.e = v;
    }
}

