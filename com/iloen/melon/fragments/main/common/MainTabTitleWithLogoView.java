package com.iloen.melon.fragments.main.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.LinearLayout;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\b\b\u0001\u0010\n\u001A\u00020\u0006¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u000F\u001A\u00020\u000E8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/main/common/MainTabTitleWithLogoView;", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "resId", "Lie/H;", "setLogoImageResource", "(I)V", "Ljava/util/concurrent/atomic/AtomicBoolean;", "logoAttached", "Ljava/util/concurrent/atomic/AtomicBoolean;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MainTabTitleWithLogoView extends MainTabTitleView {
    public static final int $stable = 8;
    @NotNull
    private AtomicBoolean logoAttached;

    public MainTabTitleWithLogoView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 0, 6, null);
    }

    public MainTabTitleWithLogoView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0, 4, null);
    }

    public MainTabTitleWithLogoView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.logoAttached = new AtomicBoolean(false);
        LinearLayout linearLayout0 = this.getBinding().g;
        q.f(linearLayout0, "titleLayout");
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = linearLayout0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        int v1 = ScreenUtils.dipToPixel(context0, 13.0f);
        int v2 = ScreenUtils.dipToPixel(context0, 8.0f);
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin, v1, ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin, v2);
        linearLayout0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
    }

    public MainTabTitleWithLogoView(Context context0, AttributeSet attributeSet0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            attributeSet0 = null;
        }
        if((v1 & 4) != 0) {
            v = 0;
        }
        this(context0, attributeSet0, v);
    }

    public final void setLogoImageResource(int v) {
        if(this.logoAttached.compareAndSet(false, true)) {
            ImageView imageView0 = new ImageView(this.getContext());
            imageView0.setMaxHeight(ScreenUtils.dipToPixel(imageView0.getContext(), 22.0f));
            imageView0.setImageResource(v);
            LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-2, -2);
            linearLayout$LayoutParams0.setMargins(0, 0, 0, ScreenUtils.dipToPixel(this.getContext(), 6.0f));
            imageView0.setLayoutParams(linearLayout$LayoutParams0);
            this.getBinding().g.addView(imageView0, 0);
        }
    }
}

