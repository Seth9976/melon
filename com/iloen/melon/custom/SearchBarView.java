package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.t1;

public class SearchBarView extends InputBarView implements TextView.OnEditorActionListener {
    public V0 i;
    public final View j;
    public final ImageView k;
    public boolean l;

    public SearchBarView(Context context0) {
        this(context0, null);
    }

    public SearchBarView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = false;
        if(this.isInEditMode()) {
            return;
        }
        this.c.setImeOptions(3);
        this.c.setOnEditorActionListener(this);
        this.j = this.findViewById(0x7F0A0981);  // id:progress_bar
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0A39);  // id:search_btn
        this.k = imageView0;
        ViewUtils.setOnClickListener(imageView0, this);
        TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.m);
        try {
            float f = typedArray0.getDimension(38, 0.0f);
            float f1 = typedArray0.getDimension(35, 0.0f);
            if(f > 0.0f && f1 > 0.0f) {
                LinearLayout.LayoutParams linearLayout$LayoutParams0 = (LinearLayout.LayoutParams)this.j.getLayoutParams();
                if(linearLayout$LayoutParams0 != null) {
                    linearLayout$LayoutParams0.width = (int)f;
                    linearLayout$LayoutParams0.height = (int)f1;
                    linearLayout$LayoutParams0.leftMargin = (int)typedArray0.getDimension(36, 0.0f);
                    linearLayout$LayoutParams0.rightMargin = (int)typedArray0.getDimension(37, 0.0f);
                }
            }
            Drawable drawable0 = typedArray0.getDrawable(39);
            if(drawable0 == null) {
                ViewUtils.hideWhen(this.k, true);
            }
            else {
                this.k.setImageDrawable(drawable0);
            }
            LinearLayout.LayoutParams linearLayout$LayoutParams1 = (LinearLayout.LayoutParams)this.k.getLayoutParams();
            if(linearLayout$LayoutParams1 != null) {
                linearLayout$LayoutParams1.leftMargin = (int)typedArray0.getDimension(41, 0.0f);
                linearLayout$LayoutParams1.rightMargin = (int)typedArray0.getDimension(42, 0.0f);
            }
            String s = typedArray0.getString(40);
            if(TextUtils.isEmpty(s)) {
                this.k.setContentDescription("검색 버튼");
            }
            else {
                this.k.setContentDescription(s);
            }
            this.l = typedArray0.getBoolean(22, true);
        }
        finally {
            typedArray0.recycle();
        }
    }

    @Override  // com.iloen.melon.custom.InputBarView
    public final void b() {
        super.b();
    }

    @Override  // com.iloen.melon.custom.InputBarView
    public final void onClick(View view0) {
        super.onClick(view0);
        if(view0 == this.d) {
            V0 v00 = this.i;
            if(v00 != null) {
                v00.onClearClick(this);
            }
        }
        else if(view0 == this.k) {
            if(ViewUtils.hasStringEditText(this.c)) {
                V0 v01 = this.i;
                if(v01 != null) {
                    v01.onSearchClick(this, this.c.getText().toString());
                }
                InputMethodUtils.hideInputMethod(this.getContext(), this.c);
                return;
            }
            ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
        }
    }

    @Override  // android.widget.TextView$OnEditorActionListener
    public final boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
        if(v != 3 && v != 6) {
            return true;
        }
        if(this.l && !ViewUtils.hasStringEditText(this.c)) {
            ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
            return false;
        }
        V0 v00 = this.i;
        if(v00 != null) {
            v00.onSearchClick(this, this.c.getText().toString());
        }
        InputMethodUtils.hideInputMethod(this.getContext(), this.c);
        return true;
    }

    @Override  // com.iloen.melon.custom.InputBarView
    public final void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        MelonEditText melonEditText0 = this.c;
        if(melonEditText0 == null) {
            LogU.w("SearchBarView", "onTextChanged() - invalid EditText");
            return;
        }
        String s = melonEditText0.getText().toString();
        if(TextUtils.isEmpty(s)) {
            V0 v00 = this.i;
            if(v00 != null) {
                v00.onClearKeyword(this);
            }
        }
        else {
            V0 v01 = this.i;
            if(v01 != null) {
                v01.onSearchKeyword(this, s);
            }
        }
    }

    public void setEnableBlankAlert(boolean z) {
        this.l = z;
    }

    public void setOnSearchBarListener(V0 v00) {
        this.i = v00;
    }

    public void setProgressBarVisibility(boolean z) {
    }

    public void setSearchButtonVisibility(boolean z) {
        ViewUtils.showWhen(this.k, z);
    }
}

