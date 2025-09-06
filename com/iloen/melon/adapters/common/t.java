package com.iloen.melon.adapters.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import v9.o;

public final class t extends O0 {
    public final Context a;
    public final View b;
    public final ImageView c;
    public final TextView d;
    public final View e;
    public final View f;

    public t(Context context0, View view0) {
        super(view0);
        this.a = context0;
        this.b = view0.findViewById(0x7F0A08A5);  // id:network_error_layout
        View view1 = view0.findViewById(0x7F0A08A4);  // id:network_error_info_icon
        TextView textView0 = null;
        this.c = view1 instanceof ImageView ? ((ImageView)view1) : null;
        View view2 = view0.findViewById(0x7F0A08A3);  // id:network_error_desc_text
        if(view2 instanceof TextView) {
            textView0 = (TextView)view2;
        }
        this.d = textView0;
        this.e = view0.findViewById(0x7F0A08A2);  // id:network_error_confirm_button
        this.f = view0.findViewById(0x7F0A08A6);  // id:network_error_retry_button
    }

    public final void a(boolean z, o o0) {
        boolean z1 = false;
        Context context0 = this.a;
        View view0 = this.b;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            viewGroup$LayoutParams0.height = z ? context0.getResources().getDimensionPixelSize(0x7F070110) : 0;  // dimen:empty_or_network_error_layout_min_height
        }
        ViewUtils.showWhen(view0, z);
        if(o0 != null) {
            int v = o0.b;
            if(view0 != null && v != -1) {
                view0.setBackgroundResource(v);
            }
            int v1 = o0.c;
            ImageView imageView0 = this.c;
            if(imageView0 != null && v1 != -1) {
                imageView0.setImageResource(v1);
            }
            String s = o0.d;
            int v2 = o0.e;
            TextView textView0 = this.d;
            if(textView0 != null && !TextUtils.isEmpty(s)) {
                textView0.setText(s);
                if(v2 != -1) {
                    textView0.setTextColor(ColorUtils.getColor(context0, v2));
                }
            }
            int v3 = o0.h;
            int v4 = o0.i;
            View view1 = this.e;
            ViewUtils.showWhen(view1, o0.f != null);
            if(view1 != null) {
                View.OnClickListener view$OnClickListener0 = o0.f;
                if(view$OnClickListener0 != null) {
                    ViewUtils.setOnClickListener(view1, view$OnClickListener0);
                    if(view1 instanceof TextView) {
                        if(v3 != -1) {
                            ((TextView)view1).setTextColor(ColorUtils.getColor(context0, v3));
                        }
                        if(v4 != -1) {
                            ((TextView)view1).setBackgroundResource(v4);
                        }
                    }
                }
            }
            if(o0.g != null) {
                z1 = true;
            }
            View view2 = this.f;
            ViewUtils.showWhen(view2, z1);
            if(view2 != null) {
                View.OnClickListener view$OnClickListener1 = o0.g;
                if(view$OnClickListener1 != null) {
                    ViewUtils.setOnClickListener(view2, view$OnClickListener1);
                    if(view2 instanceof TextView) {
                        if(v3 != -1) {
                            ((TextView)view2).setTextColor(ColorUtils.getColor(context0, v3));
                        }
                        if(v4 != -1) {
                            ((TextView)view2).setBackgroundResource(v4);
                        }
                    }
                }
            }
        }
    }
}

