package com.iloen.melon.custom;

import Tf.o;
import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils.TruncateAt;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import com.iloen.melon.utils.color.ColorUtils;
import java.util.ArrayList;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tR*\u0010\u0012\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R*\u0010\u0016\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001A\u0004\b\u0014\u0010\u000F\"\u0004\b\u0015\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/custom/MoreExpandTextView;", "Lcom/iloen/melon/custom/MelonTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "value", "i", "Ljava/lang/String;", "getExpandTitle", "()Ljava/lang/String;", "setExpandTitle", "(Ljava/lang/String;)V", "expandTitle", "j", "getCollapseTitle", "setCollapseTitle", "collapseTitle", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MoreExpandTextView extends MelonTextView {
    public String i;
    public String j;
    public boolean k;
    public boolean l;
    public String m;
    public int n;
    public int o;

    public MoreExpandTextView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public MoreExpandTextView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public MoreExpandTextView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        q.f("더보기", "getString(...)");
        this.i = "더보기";
        q.f("접기", "getString(...)");
        this.j = "접기";
        this.m = "";
    }

    public MoreExpandTextView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @NotNull
    public final String getCollapseTitle() {
        return this.j;
    }

    @NotNull
    public final String getExpandTitle() {
        return this.i;
    }

    public final void h(int v, String s, String s1) {
        char[] arr_c = s.toCharArray();
        q.f(arr_c, "toCharArray(...)");
        ArrayList arrayList0 = new ArrayList();
        for(int v1 = 0; v1 < arr_c.length; ++v1) {
            char c = arr_c[v1];
            if(c <= 0xFFFF) {
                if(Character.isHighSurrogate(c)) {
                    ++v1;
                    arrayList0.add(new String(new char[]{c, arr_c[v1]}));
                }
                else {
                    arrayList0.add(new String(new char[]{c}));
                }
            }
        }
        String s2 = e.h(p.q0(p.g0(v + 1, arrayList0), "", null, null, null, 62), s1);
        if(this.i(s2, this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()).getLineCount() > this.o && v < 10) {
            this.h(v + 1, s, s1);
            return;
        }
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(s2);
        int v2 = o.F0(spannableStringBuilder0, s1, 0, false, 6);
        if(v2 > -1) {
            spannableStringBuilder0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06015D)), v2, s1.length() + v2, 34);  // color:gray500s_support_high_contrast
        }
        this.l = true;
        this.k = true;
        this.setText(spannableStringBuilder0);
        this.k = false;
    }

    public final StaticLayout i(CharSequence charSequence0, int v) {
        return new StaticLayout(charSequence0, this.getPaint(), v, Layout.Alignment.ALIGN_NORMAL, this.getLineSpacingMultiplier(), this.getLineSpacingExtra(), this.getIncludeFontPadding());
    }

    public final boolean j() {
        return this.m.length() > 0 && this.i(this.m, this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()).getLineCount() > this.o;
    }

    @Override  // android.widget.TextView
    public final void onDraw(Canvas canvas0) {
        q.g(canvas0, "canvas");
        if(this.l) {
            super.onDraw(canvas0);
            return;
        }
        if(this.getEllipsize() != TextUtils.TruncateAt.END) {
            this.k = true;
            String s = this.m;
            String s1 = this.j;
            SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(s);
            if(this.i(s, this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight()).getLineCount() > this.o && s1 != null && s1.length() != 0) {
                spannableStringBuilder0.append(" ");
                spannableStringBuilder0.append(s1);
                spannableStringBuilder0.setSpan(new ForegroundColorSpan(ColorUtils.getColor(this.getContext(), 0x7F06015D)), spannableStringBuilder0.length() - s1.length(), spannableStringBuilder0.length(), 34);  // color:gray500s_support_high_contrast
            }
            this.setText(spannableStringBuilder0);
            this.l = true;
            this.k = false;
            super.onDraw(canvas0);
            return;
        }
        int v = this.getMaxLines();
        this.o = v;
        String s2 = "..." + this.i;
        CharSequence charSequence0 = this.getText();
        if(v > 0) {
            try {
                q.d(charSequence0);
                StaticLayout staticLayout0 = this.i(charSequence0, this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight());
                if(staticLayout0.getLineCount() > v) {
                    int v1 = staticLayout0.getLineEnd(v - 1);
                    CharSequence charSequence1 = this.getText();
                    q.f(charSequence1, "getText(...)");
                    this.h(0, charSequence1.subSequence(0, v1).toString(), s2);
                }
            }
            catch(Exception unused_ex) {
            }
        }
        this.l = true;
        super.onDraw(canvas0);
    }

    @Override  // com.iloen.melon.custom.MelonTextView
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        if(this.n != this.getMeasuredWidth()) {
            this.n = this.getMeasuredWidth();
            this.l = false;
        }
    }

    @Override  // androidx.appcompat.widget.AppCompatTextView
    public final void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
        super.onTextChanged(charSequence0, v, v1, v2);
        if(!this.k) {
            this.m = String.valueOf(charSequence0);
            this.l = false;
        }
    }

    public final void setCollapseTitle(@NotNull String s) {
        q.g(s, "value");
        this.j = s;
    }

    public final void setExpandTitle(@NotNull String s) {
        q.g(s, "value");
        this.i = s;
    }
}

