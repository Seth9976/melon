package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/custom/FilterDropDownRenewalView;", "Lcom/iloen/melon/custom/FilterDropDownView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FilterDropDownRenewalView extends FilterDropDownView {
    public FilterDropDownRenewalView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public FilterDropDownRenewalView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public FilterDropDownRenewalView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
        RelativeLayout.LayoutParams relativeLayout$LayoutParams0 = viewGroup$LayoutParams0 instanceof RelativeLayout.LayoutParams ? ((RelativeLayout.LayoutParams)viewGroup$LayoutParams0) : null;
        if(relativeLayout$LayoutParams0 != null) {
            relativeLayout$LayoutParams0.addRule(11);
        }
    }

    public FilterDropDownRenewalView(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }
}

