package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class SettingItemView extends RelativeLayout {
    public final View a;
    public final View b;
    public final View c;
    public final View d;
    public final View e;
    public final ImageView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final ImageView k;
    public final View l;
    public boolean m;
    public boolean n;
    public boolean o;
    public a1 r;
    public b1 w;

    public SettingItemView(Context context0) {
        this(context0, null);
    }

    public SettingItemView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        int v1;
        this.m = false;
        this.n = false;
        this.o = false;
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.F, 0, 0);
        int v = typedArray0.getInt(5, this.getResources().getInteger(0x7F0B0055));  // integer:settingItemTypeCell
        if(v == this.getResources().getInteger(0x7F0B0055)) {  // integer:settingItemTypeCell
            v1 = 0x7F0D0830;  // layout:setting_item_cell
        }
        else {
            v1 = v == this.getResources().getInteger(0x7F0B0054) ? 0x7F0D082F : 0x7F0D0835;  // integer:settingItemTypeBox
        }
        LayoutInflater.from(this.getContext()).inflate(v1, this);
        this.a = this.findViewById(0x7F0A05A7);  // id:item_container
        this.b = this.findViewById(0x7F0A0AF9);  // id:sub_item_container
        this.c = this.findViewById(0x7F0A0AFB);  // id:sub_text_container
        this.f = (ImageView)this.findViewById(0x7F0A0558);  // id:image
        this.g = (TextView)this.findViewById(0x7F0A0B49);  // id:text
        this.h = (TextView)this.findViewById(0x7F0A0AFA);  // id:sub_text
        this.l = this.findViewById(0x7F0A011F);  // id:bottom_line
        this.j = (TextView)this.findViewById(0x7F0A0CCA);  // id:tv_new
        this.i = (TextView)this.findViewById(0x7F0A01E7);  // id:button_text
        View view0 = this.findViewById(0x7F0A01E3);  // id:button_container
        this.d = view0;
        ViewUtils.setOnClickListener(view0, new Z0(this, 0));
        this.k = (ImageView)this.findViewById(0x7F0A0996);  // id:radio_button
        this.e = this.findViewById(0x7F0A0997);  // id:radio_button_container
        this.setRadioButtonClickListener(true);
        this.setRadioTalkBack(this.m);
        int v2 = typedArray0.getResourceId(4, -1);
        if(v2 != -1) {
            ImageView imageView0 = this.f;
            if(imageView0 != null) {
                imageView0.setImageResource(v2);
                ViewUtils.showWhen(this.f, true);
            }
        }
        int v3 = typedArray0.getResourceId(6, -1);
        if(v3 != -1) {
            this.g.setText(v3);
        }
        int v4 = typedArray0.getResourceId(8, -1);
        if(v4 != -1) {
            this.setSubText(this.getResources().getString(v4));
        }
        int v5 = typedArray0.getResourceId(2, -1);
        if(v5 != -1) {
            this.i.setText(v5);
        }
        int v6 = typedArray0.getResourceId(3, -1);
        if(v6 != -1) {
            this.i.setTextColor(v6);
        }
        int v7 = typedArray0.getResourceId(1, -1);
        if(v7 != -1) {
            this.d.setBackgroundResource(v7);
        }
        boolean z = typedArray0.getBoolean(7, false);
        TextView textView0 = this.j;
        if(textView0 != null) {
            ViewUtils.showWhen(textView0, z);
        }
        boolean z1 = typedArray0.getBoolean(0, true);
        ViewUtils.showWhen(this.l, z1);
        typedArray0.recycle();
    }

    public final void a(boolean z) {
        this.setSubText((z ? "ON" : "OFF"));
        this.setSubTextColor(0x7F060163);  // color:gray700s
    }

    public final void b() {
        ViewUtils.showWhen(this.findViewById(0x7F0A0548), false);  // id:icon_arrow
        View view0 = this.findViewById(0x7F0A0AFC);  // id:sub_text_container_margin
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            viewGroup$LayoutParams0.width = ScreenUtils.dipToPixel(this.getContext(), 16.0f);
            view0.requestLayout();
        }
    }

    @Override  // android.view.View
    public void setBackgroundResource(int v) {
        View view0 = this.a;
        if(view0 != null) {
            view0.setBackgroundResource(v);
        }
    }

    public void setBottomLineColor(int v) {
        View view0 = this.l;
        if(view0 != null) {
            view0.setBackgroundColor(ColorUtils.getColor(this.getContext(), v));
        }
    }

    public void setButtonBackgroundResource(int v) {
        TextView textView0 = this.i;
        if(textView0 != null) {
            textView0.setBackgroundResource(v);
            int v1 = this.getResources().getDimensionPixelSize(0x7F070437);  // dimen:setting_view_button_padding
            this.i.setPadding(v1, 0, v1, 0);
        }
    }

    public void setButtonClickListener(a1 a10) {
        this.r = a10;
    }

    public void setButtonText(String s) {
        TextView textView0 = this.i;
        if(textView0 != null) {
            textView0.setText(s);
        }
    }

    public void setButtonTextColor(int v) {
        TextView textView0 = this.i;
        if(textView0 != null) {
            textView0.setTextColor(v);
        }
    }

    public void setButtonTextColor(ColorStateList colorStateList0) {
        TextView textView0 = this.i;
        if(textView0 != null) {
            textView0.setTextColor(colorStateList0);
        }
    }

    public void setImage(int v) {
        ImageView imageView0 = this.f;
        if(imageView0 != null) {
            imageView0.setImageResource(v);
            ViewUtils.showWhen(this.f, true);
        }
    }

    public void setImageRightMargin(int v) {
        ImageView imageView0 = this.f;
        if(imageView0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = imageView0.getLayoutParams();
            if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = v;
            }
        }
    }

    public void setLoginRequired(boolean z) {
        this.n = z;
    }

    public void setRadioBtnClickListener(b1 b10) {
        this.w = b10;
    }

    private void setRadioButtonClickListener(boolean z) {
        Z0 z00 = z ? new Z0(this, 1) : null;
        ViewUtils.setOnClickListener(this.e, z00);
    }

    public void setRadioButtonUpdateManually(boolean z) {
        this.o = z;
    }

    public void setRadioClickable(boolean z) {
        this.setTextColor((z ? 0x7F06016D : 0x7F060159));  // color:gray900s
        this.setRadioButtonClickListener(z);
    }

    public void setRadioOnOff(boolean z) {
        this.m = z;
        ImageView imageView0 = this.k;
        if(imageView0 != null) {
            imageView0.setImageResource((z ? 0x7F08016E : 0x7F08016D));  // drawable:btn_common_round_check_on
        }
        this.setRadioTalkBack(z);
    }

    private void setRadioTalkBack(boolean z) {
        if(this.k != null) {
            this.k.setContentDescription(this.getResources().getString((z ? 0x7F130BA9 : 0x7F130BAD)) + "버튼");  // string:talkback_off "꺼짐"
        }
    }

    public void setSubText(String s) {
        TextView textView0 = this.h;
        if(textView0 != null) {
            textView0.setText(s);
            boolean z = TextUtils.isEmpty(s);
            ViewUtils.showWhen(this.h, !z);
        }
    }

    public void setSubTextColor(int v) {
        TextView textView0 = this.h;
        if(textView0 != null) {
            textView0.setTextColor(ColorUtils.getColor(this.getContext(), v));
        }
    }

    public void setSubTextEllipsize(TextUtils.TruncateAt textUtils$TruncateAt0) {
        TextView textView0 = this.h;
        if(textView0 != null) {
            textView0.setEllipsize(textUtils$TruncateAt0);
        }
    }

    public void setSubTextFontType(int v) {
        TextView textView0 = this.h;
        if(textView0 instanceof MelonTextView) {
            ViewUtils.setTypeface(textView0, v);
        }
    }

    public void setSubTextMaxWidth(int v) {
        TextView textView0 = this.h;
        if(textView0 != null) {
            textView0.setMaxWidth(v);
        }
    }

    public void setSubTextOnOff(boolean z) {
        this.setSubText((z ? "ON" : "OFF"));
        this.setSubTextColor((z ? 0x7F06017A : 0x7F060163));  // color:green500e_support_high_contrast
    }

    public void setText(String s) {
        TextView textView0 = this.g;
        if(textView0 != null) {
            textView0.setText(s);
        }
    }

    public void setTextColor(int v) {
        TextView textView0 = this.g;
        if(textView0 != null) {
            textView0.setTextColor(ColorUtils.getColor(this.getContext(), v));
        }
    }

    public void setTextSingleLine(boolean z) {
        TextView textView0 = this.g;
        if(textView0 != null) {
            textView0.setSingleLine(z);
            this.g.setEllipsize((z ? TextUtils.TruncateAt.END : null));
            if(!z) {
                this.g.setMaxLines(1000);
                this.g.setBreakStrategy(0);
            }
        }
    }

    public void setTextSize(int v) {
        if(v > 0) {
            this.g.setTextSize(0, ((float)v));
        }
    }

    public void setViewHeight(int v) {
        View view0 = this.b;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
            viewGroup$LayoutParams0.height = v;
            this.b.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    public void setViewType(int v) {
        switch(v) {
            case 11: {
                ViewUtils.hideWhen(this.c, true);
                ViewUtils.showWhen(this.d, true);
                ViewUtils.hideWhen(this.e, true);
                return;
            }
            case 12: {
                ViewUtils.hideWhen(this.c, true);
                ViewUtils.hideWhen(this.d, true);
                ViewUtils.showWhen(this.e, true);
                return;
            }
            default: {
                ViewUtils.showWhen(this.c, true);
                ViewUtils.hideWhen(this.d, true);
                ViewUtils.hideWhen(this.e, true);
            }
        }
    }
}

