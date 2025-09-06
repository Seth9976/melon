package com.iloen.melon.custom;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

public class MarqueeTextView extends MelonTextView {
    public MarqueeTextView(Context context0) {
        super(context0);
    }

    public MarqueeTextView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    public MarqueeTextView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
    }

    @Override  // android.view.View
    public final boolean isFocused() {
        return true;
    }

    @Override  // android.widget.TextView
    public final void onFocusChanged(boolean z, int v, Rect rect0) {
        super.onFocusChanged(true, v, rect0);
    }

    @Override  // android.widget.TextView
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(true);
    }
}

