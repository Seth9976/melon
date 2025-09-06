package com.iloen.melon.custom.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.color.DrawableColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;

public class GenreTabView extends TabView {
    public GenreTabView(Context context0) {
        super(context0);
    }

    @Override  // com.iloen.melon.custom.tablayout.TabView
    public final void b(Context context0) {
        View view0 = ((LayoutInflater)context0.getSystemService("layout_inflater")).inflate(0x7F0D086D, this, true);  // layout:tab_view_genre_item
        this.e = (LinearLayout)view0.findViewById(0x7F0A0B9E);  // id:title_layout
        this.f = (TextView)view0.findViewById(0x7F0A0BAA);  // id:title_tv
        this.c = view0.findViewById(0x7F0A075C);  // id:left_padding
        this.d = view0.findViewById(0x7F0A09FB);  // id:right_padding
    }

    @Override  // android.view.View
    public void setSelected(boolean z) {
        super.setSelected(z);
        int v = ColorUtils.getColor(this.getContext(), 0x7F06048A);  // color:transparent
        int v1 = ScreenUtils.dipToPixel(this.getContext(), 0.5f);
        if(z) {
            v = ColorUtils.getColor(this.getContext(), 0x7F06017F);  // color:green502s_support_high_contrast
            DrawableColorUtils.changeDrawableStrokeColor(this.e, v1, v);
        }
        else {
            DrawableColorUtils.changeDrawableStrokeColor(this.e, v1, ColorUtils.getColor(this.getContext(), 0x7F060152));  // color:gray200a
        }
        DrawableColorUtils.changeDrawableInnerColor(this.e, v);
        this.f.setTextColor(ColorUtils.getColor(this.getContext(), (z ? 0x7F0604A1 : 0x7F060163)));  // color:white000e
    }
}

