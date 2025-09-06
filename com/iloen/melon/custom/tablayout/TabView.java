package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;

public class TabView extends LinearLayout {
    public TabInfo a;
    public View b;
    public View c;
    public View d;
    public LinearLayout e;
    public TextView f;
    public TextView g;
    public ImageView h;
    public ImageView i;
    public ImageView j;
    public ImageView k;
    public View l;
    public View m;

    public TabView(Context context0) {
        super(context0);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.b(context0);
    }

    public TabView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.b(context0);
    }

    public TabView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.b(context0);
    }

    public final boolean a() {
        return this.a != null;
    }

    public void b(Context context0) {
        View view0 = ((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D086E, this, true);  // layout:tab_view_item
        this.b = view0.findViewById(0x7F0A031A);  // id:container
        this.e = (LinearLayout)view0.findViewById(0x7F0A0B9E);  // id:title_layout
        this.f = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
        this.g = (TextView)view0.findViewById(0x7F0A034C);  // id:count_tv
        this.h = (ImageView)view0.findViewById(0x7F0A08AF);  // id:new_iv
        this.i = (ImageView)view0.findViewById(0x7F0A08D3);  // id:on_iv
        this.j = (ImageView)view0.findViewById(0x7F0A03E6);  // id:dot_iv
        this.l = view0.findViewById(0x7F0A0125);  // id:bottom_select_line
        this.m = view0.findViewById(0x7F0A0124);  // id:bottom_select_full_line
        this.c = view0.findViewById(0x7F0A075C);  // id:left_padding
        this.d = view0.findViewById(0x7F0A09FB);  // id:right_padding
        this.k = (ImageView)view0.findViewById(0x7F0A0531);  // id:highlight_iv
    }

    public void c(boolean z) {
        ViewUtils.showWhen(this.k, z);
        this.requestLayout();
    }

    public int getIndex() {
        return this.a() ? this.a.e : -1;
    }

    public TabInfo getTabinfo() {
        return this.a;
    }

    public String getTitle() {
        return this.a() ? this.a.b : null;
    }

    public void setCount(String s) {
        if(!this.a()) {
            return;
        }
        this.a.d = s;
        boolean z = !TextUtils.isEmpty(s) && !"0".equals(s);
        ViewUtils.showWhen(this.g, z);
        if(z) {
            this.g.setText(s);
            this.g.requestLayout();
        }
        this.requestLayout();
    }

    private void setDefaultTabInfo(TabInfo tabInfo0) {
        int v2;
        this.a = tabInfo0;
        int v = !this.a() || this.a.k == -1.0f ? 0 : ScreenUtils.dipToPixel(this.getContext(), this.a.k);
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
        viewGroup$MarginLayoutParams0.width = v;
        this.c.setLayoutParams(viewGroup$MarginLayoutParams0);
        int v1 = !this.a() || this.a.l == -1.0f ? 0 : ScreenUtils.dipToPixel(this.getContext(), this.a.l);
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams1 = (ViewGroup.MarginLayoutParams)this.d.getLayoutParams();
        viewGroup$MarginLayoutParams1.width = v1;
        this.d.setLayoutParams(viewGroup$MarginLayoutParams1);
        this.f.setTextColor((!this.a() || this.a.f == 0 ? ColorUtils.getColorStateList(this.getContext(), 0x7F060473) : ColorUtils.getColorStateList(this.getContext(), this.a.f)));  // color:selector_gray900s_green500s
        TextView textView0 = this.g;
        if(textView0 != null) {
            textView0.setTextColor((!this.a() || this.a.g == 0 ? ColorUtils.getColorStateList(this.getContext(), 0x7F06046F) : ColorUtils.getColorStateList(this.getContext(), this.a.g)));  // color:selector_gray700s_green500s
            if(this.a()) {
                v2 = this.a.h;
                if(v2 <= 0) {
                    v2 = 0x7F080805;  // drawable:selector_btn_common_tab_count_bg
                }
            }
            else {
                v2 = 0x7F080805;  // drawable:selector_btn_common_tab_count_bg
            }
            this.g.setBackgroundResource(v2);
        }
        if(this.a()) {
            this.f.setText(this.a.b);
            int v3 = this.a.c;
            if(v3 != -1) {
                this.f.setCompoundDrawablesWithIntrinsicBounds(v3, 0, 0, 0);
                this.f.setCompoundDrawablePadding(ScreenUtils.dipToPixel(this.getContext(), 2.0f));
            }
            boolean z = StringUtils.isEmptyOrZero(this.a.d);
            ViewUtils.setText(this.g, (z ? "" : this.a.d));
            ViewUtils.showWhen(this.g, !z);
            int v4 = this.a.i;
            if(v4 != -1) {
                ImageView imageView0 = this.j;
                if(imageView0 != null) {
                    imageView0.setImageResource(v4);
                    return;
                }
            }
            ViewUtils.hideWhen(this.j, true);
        }
    }

    public void setDotImageRes(int v) {
        this.a.i = v;
        this.j.setImageResource(v);
    }

    private void setNewTabFullLineInfo(TabInfo tabInfo0) {
        this.setDefaultTabInfo(tabInfo0);
        ViewUtils.showWhen(this.m, true);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.b.getLayoutParams();
        viewGroup$LayoutParams0.height = this.getResources().getDimensionPixelSize(0x7F0703F4) - 1;  // dimen:new_tab_container_height
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
        relativeLayout$LayoutParams0.addRule(14);
        relativeLayout$LayoutParams0.removeRule(1);
        this.e.setPadding(0, ScreenUtils.dipToPixel(this.getContext(), 2.0f), 0, 0);
    }

    private void setNewTabInfo(TabInfo tabInfo0) {
        this.setDefaultTabInfo(tabInfo0);
        int v = tabInfo0.o;
        if(v > -1) {
            ViewUtils.setTypeface(this.f, v);
        }
        ViewUtils.showWhen(this.l, true);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.b.getLayoutParams();
        viewGroup$LayoutParams0.height = this.getResources().getDimensionPixelSize(0x7F0703F4) - 1;  // dimen:new_tab_container_height
        this.e.setPadding(0, 0, 0, 0);
    }

    public void setTabInfo(TabInfo tabInfo0) {
        if(tabInfo0 == null) {
            return;
        }
        int v = tabInfo0.a;
        if(v == 2) {
            this.setNewTabInfo(tabInfo0);
            return;
        }
        if(v == 3) {
            this.setNewTabFullLineInfo(tabInfo0);
            return;
        }
        this.setDefaultTabInfo(tabInfo0);
    }

    public void setTitle(String s) {
        if(this.a()) {
            TextView textView0 = this.f;
            if(textView0 != null) {
                this.a.b = s;
                textView0.setText(s);
                this.requestLayout();
            }
        }
    }
}

