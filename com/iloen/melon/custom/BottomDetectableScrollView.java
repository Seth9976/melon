package com.iloen.melon.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class BottomDetectableScrollView extends ScrollView {
    public j a;

    public BottomDetectableScrollView(Context context0) {
        super(context0);
        this.a = null;
    }

    public BottomDetectableScrollView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = null;
    }

    public BottomDetectableScrollView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.a = null;
    }

    @Override  // android.view.View
    public final void onScrollChanged(int v, int v1, int v2, int v3) {
        super.onScrollChanged(v, v1, v2, v3);
        if(this.a != null) {
            int v4 = this.getChildAt(this.getChildCount() - 1).getBottom();
            int v5 = this.getHeight();
            if(v4 - (this.getScrollY() + v5) == 0) {
                this.a.onScrollReachedBottom();
                return;
            }
            this.a.onScrollChanged();
        }
    }

    public void setOnScrollListener(j j0) {
        this.a = j0;
    }
}

