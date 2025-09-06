package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    public final D a;

    public AppCompatSeekBar(Context context0) {
        this(context0, null);
    }

    public AppCompatSeekBar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040535);  // attr:seekBarStyle
    }

    public AppCompatSeekBar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        a1.a(this.getContext(), this);
        D d0 = new D(this);
        this.a = d0;
        d0.b(attributeSet0, v);
    }

    @Override  // android.widget.AbsSeekBar
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatSeekBar appCompatSeekBar0 = this.a.e;
        Drawable drawable0 = this.a.f;
        if(drawable0 != null && drawable0.isStateful() && drawable0.setState(appCompatSeekBar0.getDrawableState())) {
            appCompatSeekBar0.invalidateDrawable(drawable0);
        }
    }

    @Override  // android.widget.AbsSeekBar
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable0 = this.a.f;
        if(drawable0 != null) {
            drawable0.jumpToCurrentState();
        }
    }

    @Override  // android.widget.AbsSeekBar
    public void onDraw(Canvas canvas0) {
        synchronized(this) {
            super.onDraw(canvas0);
            this.a.g(canvas0);
        }
    }
}

