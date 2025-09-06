package com.iloen.melon.popup;

import H0.b;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/iloen/melon/popup/MelonTMPPopup$addTMPWebView$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "Lie/H;", "onGlobalLayout", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonTMPPopup.addTMPWebView.3 implements ViewTreeObserver.OnGlobalLayoutListener {
    public final View a;
    public final MelonTMPPopup b;

    public MelonTMPPopup.addTMPWebView.3(View view0, MelonTMPPopup melonTMPPopup0) {
        this.a = view0;
        this.b = melonTMPPopup0;
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            MelonTMPPopup melonTMPPopup0 = this.b;
            View view0 = this.a;
            if(view0 != null) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
                if(viewGroup$LayoutParams0 != null) {
                    TextView textView0 = melonTMPPopup0.getTvCheckMsg();
                    viewGroup$LayoutParams0.width = textView0 == null ? 0 : textView0.getWidth();
                }
            }
            if(view0 != null) {
                view0.requestLayout();
            }
            TextView textView1 = melonTMPPopup0.getTvCheckMsg();
            if(textView1 != null) {
                ViewTreeObserver viewTreeObserver0 = textView1.getViewTreeObserver();
                if(viewTreeObserver0 != null) {
                    viewTreeObserver0.removeOnGlobalLayoutListener(this);
                }
            }
            return;
        }
        catch(Exception exception0) {
        }
        b.w("onGlobalLayout error: ", exception0.getMessage(), LogU.Companion, "MelonTMPPopup");
    }
}

