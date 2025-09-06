package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    public final b a;
    public final b b;
    public static final int c;

    public ContentLoadingProgressBar(Context context0) {
        this(context0, null);
    }

    public ContentLoadingProgressBar(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0, 0);
        this.a = new b(this, 0);
        this.b = new b(this, 1);
    }

    @Override  // android.widget.ProgressBar
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.removeCallbacks(this.a);
        this.removeCallbacks(this.b);
    }

    @Override  // android.widget.ProgressBar
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.a);
        this.removeCallbacks(this.b);
    }
}

