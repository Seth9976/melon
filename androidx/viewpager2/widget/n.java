package androidx.viewpager2.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;

public final class n extends RecyclerView {
    public final ViewPager2 h1;

    public n(ViewPager2 viewPager20, Context context0) {
        this.h1 = viewPager20;
        super(context0);
    }

    @Override  // androidx.recyclerview.widget.RecyclerView
    public final CharSequence getAccessibilityClassName() {
        this.h1.E.getClass();
        return super.getAccessibilityClassName();
    }

    @Override  // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent0) {
        super.onInitializeAccessibilityEvent(accessibilityEvent0);
        accessibilityEvent0.setFromIndex(this.h1.d);
        accessibilityEvent0.setToIndex(this.h1.d);
        accessibilityEvent0.setSource(((ViewPager2)this.h1.E.d));
        accessibilityEvent0.setClassName("androidx.viewpager.widget.ViewPager");
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.recyclerview.widget.RecyclerView
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        return this.h1.B && super.onInterceptTouchEvent(motionEvent0);
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.recyclerview.widget.RecyclerView
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.h1.B && super.onTouchEvent(motionEvent0);
    }
}

