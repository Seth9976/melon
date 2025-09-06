package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.media3.session.a0;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0011\u001A\u00020\f2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R0\u0010\u001B\u001A\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/custom/NewChartFilterLayout;", "Lcom/iloen/melon/custom/FilterLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "text", "Lie/H;", "setDropDownText", "(Ljava/lang/String;)V", "Lcom/iloen/melon/custom/J;", "checkedListener", "setOnCheckedListener", "(Lcom/iloen/melon/custom/J;)V", "Lkotlin/Function1;", "Landroid/view/View;", "k", "Lwe/k;", "getOnDropDownListener", "()Lwe/k;", "setOnDropDownListener", "(Lwe/k;)V", "onDropDownListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NewChartFilterLayout extends FilterLayout {
    public k k;
    public boolean l;

    public NewChartFilterLayout(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public NewChartFilterLayout(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public NewChartFilterLayout(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        int v1 = ScreenUtils.dipToPixel(context0, 20.0f);
        this.setPadding(v1, 0, v1, 0);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.b.getLayoutParams();
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = null;
        RelativeLayout.LayoutParams relativeLayout$LayoutParams1 = viewGroup$LayoutParams0 instanceof RelativeLayout.LayoutParams ? ((RelativeLayout.LayoutParams)viewGroup$LayoutParams0) : null;
        if(relativeLayout$LayoutParams1 != null) {
            relativeLayout$LayoutParams1.addRule(15);
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = this.c.getLayoutParams();
        if(viewGroup$LayoutParams1 instanceof RelativeLayout.LayoutParams) {
            relativeLayout$LayoutParams0 = (RelativeLayout.LayoutParams)viewGroup$LayoutParams1;
        }
        if(relativeLayout$LayoutParams0 != null) {
            relativeLayout$LayoutParams0.addRule(15);
        }
        LinearLayout linearLayout0 = this.a;
        if(linearLayout0 != null) {
            RelativeLayout.LayoutParams relativeLayout$LayoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            relativeLayout$LayoutParams2.addRule(0, 0x7F0A09F6);  // id:right_button_container
            linearLayout0.setLayoutParams(relativeLayout$LayoutParams2);
        }
    }

    public NewChartFilterLayout(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        LinearLayout linearLayout0 = this.a;
        if(linearLayout0 != null) {
            linearLayout0.addView(view0, v, viewGroup$LayoutParams0);
            return;
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    public final void e(boolean z) {
        if(this.l == z) {
            return;
        }
        this.l = z;
        if(z) {
            a0 a00 = new a0(this, 25);
            this.c(L.h, a00);
            return;
        }
        this.setRightLayout(L.a);
    }

    @Nullable
    public final k getOnDropDownListener() {
        return this.k;
    }

    public final void setDropDownText(@Nullable String s) {
        this.e(true);
        TextView textView0 = null;
        View view0 = this.c == null ? null : this.c.findViewById(0x7F0A04A3);  // id:filter_view_dropdown_button
        if(view0 instanceof TextView) {
            textView0 = (TextView)view0;
        }
        if(textView0 != null) {
            if(s == null) {
                s = "";
            }
            textView0.setText(s);
        }
    }

    @Override  // com.iloen.melon.custom.FilterLayout
    public void setOnCheckedListener(@Nullable J j0) {
        this.b(I.e, j0);
    }

    public final void setOnDropDownListener(@Nullable k k0) {
        this.k = k0;
    }
}

