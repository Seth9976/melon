package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class InputBarView extends LinearLayout implements TextWatcher, View.OnClickListener {
    public Y a;
    public final View b;
    public final MelonEditText c;
    public final ImageView d;
    public final TextView e;
    public final View f;
    public final int g;
    public final int h;

    public InputBarView(Context context0) {
        this(context0, null);
    }

    public InputBarView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        if(this.isInEditMode()) {
            return;
        }
        View.inflate(this.getContext(), 0x7F0D042B, this);  // layout:input_bar_view
        this.b = this.findViewById(0x7F0A0586);  // id:input_text_container
        MelonEditText melonEditText0 = (MelonEditText)this.findViewById(0x7F0A0585);  // id:input_text
        this.c = melonEditText0;
        melonEditText0.addTextChangedListener(this);
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A02C0);  // id:clear_btn
        this.d = imageView0;
        ViewUtils.setOnClickListener(imageView0, this);
        TextView textView0 = (TextView)this.findViewById(0x7F0A005A);  // id:action_btn
        this.e = textView0;
        ViewUtils.setOnClickListener(textView0, this);
        this.f = this.findViewById(0x7F0A0D6B);  // id:underline
        ViewUtils.hideWhen(this.findViewById(0x7F0A0981), true);  // id:progress_bar
        ViewUtils.hideWhen(this.findViewById(0x7F0A0A39), true);  // id:search_btn
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.m);
        try {
            int v1 = (int)typedArray0.getDimension(2, -1.0f);
            if(v1 >= 0) {
                this.setPadding(v1, v1, v1, v1);
            }
            else {
                this.setPadding(((int)typedArray0.getDimension(3, ((float)ScreenUtils.dipToPixel(context0, 16.0f)))), ((int)typedArray0.getDimension(4, ((float)ScreenUtils.dipToPixel(context0, 6.0f)))), ((int)typedArray0.getDimension(5, ((float)ScreenUtils.dipToPixel(context0, 16.0f)))), ((int)typedArray0.getDimension(6, ((float)ScreenUtils.dipToPixel(context0, 6.0f)))));
            }
            String s = typedArray0.getString(7);
            if(!TextUtils.isEmpty(s)) {
                this.c.setHint(s);
            }
            int v2 = typedArray0.getColor(0, ColorUtils.getColor(context0, 0x7F06016D));  // color:gray900s
            this.c.setTextColor(v2);
            int v3 = typedArray0.getColor(1, ColorUtils.getColor(context0, 0x7F060159));  // color:gray400s_support_high_contrast
            this.c.setHintTextColor(v3);
            int v4 = typedArray0.getResourceId(8, 0x7F080330);  // drawable:edittext_cursor_color_green500s
            this.c.setTextCursorDrawable(v4);
            this.g = (int)typedArray0.getDimension(34, ((float)ScreenUtils.dipToPixel(context0, 18.0f)));
            this.h = (int)typedArray0.getDimension(0x1F, ((float)ScreenUtils.dipToPixel(context0, 14.0f)));
            this.c(true);
            Drawable drawable0 = typedArray0.getDrawable(0x20);
            if(drawable0 != null) {
                drawable0.setBounds(0, 0, drawable0.getIntrinsicWidth(), drawable0.getIntrinsicHeight());
            }
            this.c.setCompoundDrawables(drawable0, null, null, null);
            int v5 = (int)typedArray0.getDimension(33, ((float)ScreenUtils.dipToPixel(context0, 6.0f)));
            this.c.setCompoundDrawablePadding(v5);
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.b.getLayoutParams();
            if(linearLayout$LayoutParams0 != null) {
                linearLayout$LayoutParams0.topMargin = (int)typedArray0.getDimension(28, 0.0f);
                linearLayout$LayoutParams0.bottomMargin = (int)typedArray0.getDimension(25, 0.0f);
                linearLayout$LayoutParams0.leftMargin = (int)typedArray0.getDimension(26, 0.0f);
                linearLayout$LayoutParams0.rightMargin = (int)typedArray0.getDimension(27, 0.0f);
            }
            int v6 = (int)typedArray0.getDimension(29, 0.0f);
            int v7 = (int)typedArray0.getDimension(30, 0.0f);
            this.c.setPadding(v6, 0, v7, 0);
            Drawable drawable1 = typedArray0.getDrawable(24);
            if(drawable1 != null) {
                ViewUtils.setBackground(this.b, drawable1);
            }
            LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)this.d.getLayoutParams();
            if(linearLayout$LayoutParams1 != null) {
                linearLayout$LayoutParams1.leftMargin = (int)typedArray0.getDimension(20, 0.0f);
                linearLayout$LayoutParams1.rightMargin = (int)typedArray0.getDimension(21, 0.0f);
            }
            Drawable drawable2 = typedArray0.getDrawable(18);
            if(drawable2 != null) {
                this.d.setImageDrawable(drawable2);
            }
            String s1 = typedArray0.getString(19);
            if(TextUtils.isEmpty(s1)) {
                this.d.setContentDescription("입력창 글자 전체삭제");
            }
            else {
                this.d.setContentDescription(s1);
            }
            String s2 = typedArray0.getString(14);
            if(!TextUtils.isEmpty(s2)) {
                this.e.setText(s2);
            }
            int v8 = (int)typedArray0.getDimension(16, ((float)ScreenUtils.dipToPixel(context0, 16.0f)));
            this.e.setTextSize(0, ((float)v8));
            int v9 = typedArray0.getColor(15, ColorUtils.getColor(context0, 0x7F0603F2));  // color:melon_green
            this.e.setTextColor(v9);
            Drawable drawable3 = typedArray0.getDrawable(9);
            TextView textView1 = this.e;
            if(textView1 != null) {
                ViewUtils.setBackground(textView1, drawable3);
            }
            float f = typedArray0.getDimension(17, 0.0f);
            float f1 = typedArray0.getDimension(11, 0.0f);
            if(f > 0.0f && f1 > 0.0f) {
                LinearLayout.LayoutParams linearLayout$LayoutParams2 = (LinearLayout.LayoutParams)this.e.getLayoutParams();
                if(linearLayout$LayoutParams2 != null) {
                    linearLayout$LayoutParams2.width = (int)f;
                    linearLayout$LayoutParams2.height = (int)f1;
                    linearLayout$LayoutParams2.leftMargin = (int)typedArray0.getDimension(12, 0.0f);
                    linearLayout$LayoutParams2.rightMargin = (int)typedArray0.getDimension(13, 0.0f);
                }
            }
            float f2 = typedArray0.getDimension(44, ((float)ScreenUtils.dipToPixel(context0, 2.0f)));
            LogU.v("InputBarView", "InputBarView_underlineHeight : " + f2);
            LinearLayout.LayoutParams linearLayout$LayoutParams3 = (LinearLayout.LayoutParams)this.f.getLayoutParams();
            if(linearLayout$LayoutParams3 != null) {
                linearLayout$LayoutParams3.height = (int)f2;
            }
            int v10 = typedArray0.getColor(43, ColorUtils.getColor(context0, 0x7F06016D));  // color:gray900s
            LogU.v("InputBarView", "InputBarView_underlineColor : " + v10);
            this.f.setBackgroundColor(v10);
        }
        finally {
            typedArray0.recycle();
        }
    }

    public final void a() {
        InputMethodUtils.hideInputMethod(this.getContext(), this.c);
    }

    @Override  // android.text.TextWatcher
    public final void afterTextChanged(Editable editable0) {
    }

    public void b() {
        this.c.setText("");
        this.setClearButtonVisibility(false);
        this.a();
    }

    @Override  // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
    }

    public final void c(boolean z) {
        this.c.setTextSize(0, ((float)(z ? this.h : this.g)));
    }

    public String getInputHintText() {
        String s = this.c.getHint().toString();
        return TextUtils.isEmpty(s) || s.trim().length() <= 0 ? "" : s;
    }

    public String getInputText() {
        if(ViewUtils.hasStringEditText(this.c)) {
            return this.c == null ? "" : this.c.getText().toString();
        }
        return "";
    }

    public EditText getInputTextView() {
        return this.c == null ? null : this.c;
    }

    @Override  // android.view.View$OnClickListener
    public void onClick(View view0) {
        if(view0 == this.d) {
            this.b();
            return;
        }
        if(view0 == this.e) {
            Y y0 = this.a;
            if(y0 != null) {
                y0.onActionClick(this);
            }
        }
    }

    @Override  // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        MelonEditText melonEditText0 = this.c;
        if(melonEditText0 == null) {
            LogU.w("InputBarView", "onTextChanged() - invalid EditText");
            return;
        }
        if(TextUtils.isEmpty(melonEditText0.getText().toString())) {
            this.setClearButtonVisibility(false);
            this.c(true);
            return;
        }
        this.setClearButtonVisibility(true);
        this.c(false);
    }

    private void setClearButtonVisibility(boolean z) {
        ViewUtils.showWhen(this.d, z);
    }

    public void setCursorPosition(int v) {
        MelonEditText melonEditText0 = this.c;
        if(melonEditText0 != null) {
            Editable editable0 = melonEditText0.getText();
            if(v >= 0 && v <= (editable0 == null ? 0 : editable0.length())) {
                this.c.setSelection(v);
            }
        }
    }

    public void setHint(int v) {
        MelonEditText melonEditText0 = this.c;
        if(melonEditText0 != null) {
            melonEditText0.setHint(v);
        }
    }

    public void setHint(String s) {
        MelonEditText melonEditText0 = this.c;
        if(melonEditText0 != null) {
            melonEditText0.setHint(s);
        }
    }

    public void setInputText(String s) {
        MelonEditText melonEditText0 = this.c;
        if(melonEditText0 != null) {
            melonEditText0.setText(s);
            this.setCursorPosition((s == null ? 0 : s.length()));
        }
    }

    public void setInputTextLimit(MelonLimits.TextLimit melonLimits$TextLimit0) {
        this.c.setTextLimit(melonLimits$TextLimit0);
    }

    public void setOnInputBarListener(Y y0) {
        this.a = y0;
    }
}

