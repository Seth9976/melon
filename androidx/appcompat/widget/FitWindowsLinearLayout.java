package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout {
    public FitWindowsLinearLayout(Context context0) {
        super(context0);
    }

    public FitWindowsLinearLayout(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
    }

    @Override  // android.view.View
    public final boolean fitSystemWindows(Rect rect0) {
        return super.fitSystemWindows(rect0);
    }

    public void setOnFitSystemWindowsListener(p0 p00) {
    }
}

