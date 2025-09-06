package com.iloen.melon.custom;

import A8.s;
import Fd.C;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter.LengthFilter;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ByteTextWatcher;
import com.iloen.melon.utils.ui.ViewUtils;
import java.lang.ref.WeakReference;
import k8.t1;

public class MelonEditText extends AppCompatEditText {
    public MelonLimits.TextLimit g;
    public WeakReference h;
    public TextWatcher i;
    public boolean j;

    public MelonEditText(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.j = true;
        this.getResources().getDrawable(0x7F0801E9);  // drawable:btn_input_x_n
        if(this.isInEditMode()) {
            return;
        }
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.u, 0, 0);
        int v = typedArray0.getInt(0, 0);
        typedArray0.recycle();
        if(this.getImeOptions() == 0) {
            this.setImeOptions(6);
        }
        ViewUtils.setTypeface(this, v);
        ViewUtils.setFallbackLineSpacing(this, false);
    }

    public final void b(MelonLimits.TextLimit melonLimits$TextLimit0, TextView textView0) {
        this.setInputGuideView(textView0);
        this.setTextLimit(melonLimits$TextLimit0);
    }

    public final void c() {
        if(this.g != null) {
            Editable editable0 = this.getText();
            String s = editable0 == null ? "" : editable0.toString();
            TextView textView0 = this.getInputCountGuideView();
            this.g.getClass();
            s s1 = s.a;
            if(s.b.equals(s1)) {
                String s2 = MelonAppBase.instance.getContext().getString(0x7F13018C, new Object[]{StringUtils.getByteSize(s), this.g.a});  // string:byte_count_label "%1$d/%2$dbyte"
                if(textView0 != null) {
                    textView0.setText(s2);
                }
            }
            else {
                this.g.getClass();
                if(s1.equals(s1)) {
                    int v = ColorUtils.getColor(this.getContext(), 0x7F06016D);  // color:gray900s
                    int v1 = ColorUtils.getColor(this.getContext(), 0x7F060160);  // color:gray600s_support_high_contrast
                    String s3 = this.getContext().getString(0x7F1304E2, new Object[]{v, s.length(), v1, v1, this.g.a});  // string:letter_count_label "<font color=\"%1$d\">%2$d</font><font color=\"%3$d\"> 
                                                                                                                         // / </font><font color=\"%4$d\">%5$d</font>"
                    if(textView0 != null) {
                        textView0.setText(Html.fromHtml(s3, 0));
                    }
                }
            }
        }
    }

    public TextView getInputCountGuideView() {
        return this.h == null ? null : ((TextView)this.h.get());
    }

    private void setInputGuideView(TextView textView0) {
        if(textView0 != null) {
            this.h = new WeakReference(textView0);
            return;
        }
        this.h = null;
    }

    public void setTextLimit(MelonLimits.TextLimit melonLimits$TextLimit0) {
        this.g = melonLimits$TextLimit0;
        this.setFilters(new InputFilter[0]);
        if(this.g != null) {
            s s0 = s.a;
            if(s0.equals(s0)) {
                this.setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.g.a)});
            }
            else {
                this.g.getClass();
                if(s.b.equals(s0)) {
                    this.addTextChangedListener(new ByteTextWatcher(this.g.a));
                }
            }
            this.addTextChangedListener(new C(this, 2));
            this.c();
        }
    }

    public void setTextLimitUpdate(boolean z) {
        this.j = z;
    }

    public void setTextWatcher(TextWatcher textWatcher0) {
        this.i = textWatcher0;
    }
}

