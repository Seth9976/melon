package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;

@Deprecated
public class BrowserActionsFallbackMenuView extends LinearLayout {
    public final int a;
    public final int b;

    public BrowserActionsFallbackMenuView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = this.getResources().getDimensionPixelOffset(0x7F07005A);  // dimen:browser_actions_context_menu_min_padding
        this.b = this.getResources().getDimensionPixelOffset(0x7F070059);  // dimen:browser_actions_context_menu_max_width
    }

    @Override  // android.widget.LinearLayout
    public final void onMeasure(int v, int v1) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(this.getResources().getDisplayMetrics().widthPixels - this.a * 2, this.b), 0x40000000), v1);
    }
}

