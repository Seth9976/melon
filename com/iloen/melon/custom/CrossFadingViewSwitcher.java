package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.ViewSwitcher;
import com.iloen.melon.MelonAppBase;
import d3.g;
import ie.r;
import k8.t1;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u001D\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R#\u0010\u000E\u001A\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\rR#\u0010\u0011\u001A\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000F\u0010\u000B\u001A\u0004\b\u0010\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/custom/CrossFadingViewSwitcher;", "Landroid/widget/ViewSwitcher;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/animation/Animation;", "kotlin.jvm.PlatformType", "c", "Lie/j;", "getFadeInAnim", "()Landroid/view/animation/Animation;", "fadeInAnim", "d", "getFadeOutAnim", "fadeOutAnim", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CrossFadingViewSwitcher extends ViewSwitcher {
    public final int a;
    public final float b;
    public final r c;
    public final r d;
    public static final int e;

    public CrossFadingViewSwitcher(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        this.c = g.Q(new u(this, 0));
        this.d = g.Q(new u(this, 1));
        if(attributeSet0 == null) {
            this.a = 0;
            MelonAppBase.Companion.getClass();
            this.b = t.a().getMelonImageviewDefaultRadius();
        }
        else {
            TypedArray typedArray0 = this.getContext().obtainStyledAttributes(attributeSet0, t1.j);
            q.f(typedArray0, "obtainStyledAttributes(...)");
            try {
                this.a = typedArray0.getInt(2, 0);
                MelonAppBase.Companion.getClass();
                this.b = typedArray0.getDimension(1, t.a().getMelonImageviewDefaultRadius());
                typedArray0.getBoolean(0, false);
            }
            finally {
                typedArray0.recycle();
            }
        }
        MelonImageView melonImageView0 = new MelonImageView(this.getContext(), null, 6, 0);
        ImageView.ScaleType imageView$ScaleType0 = ImageView.ScaleType.CENTER_CROP;
        melonImageView0.setScaleType(imageView$ScaleType0);
        melonImageView0.setCornerType(this.a);
        melonImageView0.setCornerRadius(this.b);
        this.addView(melonImageView0);
        MelonImageView melonImageView1 = new MelonImageView(this.getContext(), null, 6, 0);
        melonImageView1.setScaleType(imageView$ScaleType0);
        melonImageView1.setCornerType(this.a);
        melonImageView1.setCornerRadius(this.b);
        this.addView(melonImageView1);
    }

    @Override  // android.widget.ViewSwitcher
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        super.addView(view0, v, viewGroup$LayoutParams0);
        if(view0 != null) {
            view0.setVisibility((this.getChildCount() == 1 ? 0 : 4));
        }
    }

    private final Animation getFadeInAnim() {
        return (Animation)this.c.getValue();
    }

    private final Animation getFadeOutAnim() {
        return (Animation)this.d.getValue();
    }
}

