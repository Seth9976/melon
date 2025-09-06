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
import v9.e;

public final class f extends O0 {
    public final Context a;
    public final View b;
    public final ImageView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public f(Context context0, View view0) {
        super(view0);
        this.a = context0;
        this.b = view0.findViewById(0x7F0A042B);  // id:empty_layout
        View view1 = view0.findViewById(0x7F0A042A);  // id:empty_image
        TextView textView0 = null;
        this.c = view1 instanceof ImageView ? ((ImageView)view1) : null;
        View view2 = view0.findViewById(0x7F0A042F);  // id:empty_text
        this.d = view2 instanceof TextView ? ((TextView)view2) : null;
        View view3 = view0.findViewById(0x7F0A042E);  // id:empty_sub_text
        this.e = view3 instanceof TextView ? ((TextView)view3) : null;
        View view4 = view0.findViewById(0x7F0A0426);  // id:empty_button
        if(view4 instanceof TextView) {
            textView0 = (TextView)view4;
        }
        this.f = textView0;
    }

    public final void a(boolean z, e e0) {
        int v1;
        View view0 = this.b;
        int v = 0;
        if(e0 == null) {
            v1 = 0;
        }
        else {
            if(e0.a) {
                ViewUtils.hideWhen(view0, true);
                view0.getLayoutParams().height = 0;
                return;
            }
            v1 = e0.c;
            if(v1 <= 0) {
                v1 = 0;
            }
        }
        Context context0 = this.a;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            if(z) {
                v = v1 <= 0 ? context0.getResources().getDimensionPixelSize(0x7F070110) : v1;  // dimen:empty_or_network_error_layout_min_height
            }
            viewGroup$LayoutParams0.height = v;
        }
        ViewUtils.showWhen(view0, z);
        if(e0 != null) {
            ImageView imageView0 = this.c;
            TextView textView0 = this.d;
            TextView textView1 = this.e;
            TextView textView2 = this.f;
            if(e0.b) {
                ViewUtils.showWhen(imageView0, true);
                if(imageView0 != null) {
                    imageView0.setImageResource(0x7F080786);  // drawable:noimage_logo_large
                }
                if(textView0 != null) {
                    textView0.setText(0x7F130389);  // string:empty_content_list "목록이 없습니다."
                    textView0.setTextColor(ColorUtils.getColor(context0, 0x7F06010D));  // color:empty_or_network_error_layout_desc_text_color
                }
                if(textView1 != null) {
                    ViewUtils.hideWhen(textView1, true);
                    textView1.setText("");
                    textView1.setTextColor(ColorUtils.getColor(context0, 0x7F06010C));  // color:empty_or_network_error_layout_desc_sub_text_color
                }
                if(textView2 != null) {
                    ViewUtils.hideWhen(textView2, true);
                    textView2.setText("");
                    ViewUtils.setOnClickListener(textView2, null);
                    textView2.setTextColor(ColorUtils.getColor(context0, 0x7F06010B));  // color:empty_or_network_error_layout_button_text_color
                }
            }
            else {
                int v2 = e0.d;
                int v3 = e0.e;
                String s = e0.f;
                int v4 = e0.g;
                String s1 = e0.h;
                int v5 = e0.i;
                String s2 = e0.j;
                int v6 = e0.k;
                int v7 = e0.l;
                if(view0 != null && v2 != -1) {
                    view0.setBackgroundResource(v2);
                }
                if(imageView0 != null && v3 != -1) {
                    imageView0.setImageResource(e0.e);
                }
                if(textView0 != null && !TextUtils.isEmpty(s)) {
                    textView0.setText(s);
                    if(v4 != -1) {
                        textView0.setTextColor(ColorUtils.getColor(context0, v4));
                    }
                }
                if(textView1 != null && !TextUtils.isEmpty(s1)) {
                    ViewUtils.showWhen(textView1, true);
                    textView1.setText(s1);
                    if(v5 != -1) {
                        textView1.setTextColor(ColorUtils.getColor(context0, v5));
                    }
                }
                if(textView2 != null && !TextUtils.isEmpty(s2)) {
                    ViewUtils.showWhen(textView2, true);
                    textView2.setText(s2);
                    View.OnClickListener view$OnClickListener0 = e0.m;
                    if(view$OnClickListener0 != null) {
                        ViewUtils.setOnClickListener(textView2, view$OnClickListener0);
                        ViewUtils.setContentDescriptionWithButtonClassName(textView2, textView2.getText());
                    }
                    if(v3 == -1) {
                        ViewUtils.hideWhen(imageView0, true);
                    }
                    if(v6 != -1) {
                        textView2.setTextColor(ColorUtils.getColor(context0, v6));
                    }
                    if(v7 != -1) {
                        textView2.setBackgroundResource(v7);
                    }
                }
            }
        }
    }
}

