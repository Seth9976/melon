package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.View;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/custom/ViewPagerInScrollView;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ViewPagerInScrollView extends ViewPager {
    public ViewPagerInScrollView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    public ViewPagerInScrollView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
    }

    @Override  // androidx.viewpager.widget.ViewPager
    public final void onMeasure(int v, int v1) {
        switch(View.MeasureSpec.getMode(v1)) {
            case 0x80000000: 
            case 0: {
                super.onMeasure(v, v1);
                int v2 = this.getChildCount();
                int v4 = 0;
                for(int v3 = 0; v3 < v2; ++v3) {
                    View view0 = this.getChildAt(v3);
                    view0.measure(v, 0);
                    int v5 = view0.getMeasuredHeight();
                    if(v5 > v4) {
                        v4 = v5;
                    }
                }
                v1 = View.MeasureSpec.makeMeasureSpec(v4, 0x40000000);
            }
        }
        super.onMeasure(v, v1);
    }
}

