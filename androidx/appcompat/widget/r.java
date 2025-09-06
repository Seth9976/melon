package androidx.appcompat.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;
import androidx.core.view.ActionProvider;
import c2.c;

public final class r implements ViewTreeObserver.OnGlobalLayoutListener {
    public final int a;
    public final Object b;

    public r(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch(this.a) {
            case 0: {
                ActivityChooserView activityChooserView0 = (ActivityChooserView)this.b;
                if(activityChooserView0.b()) {
                    if(!activityChooserView0.isShown()) {
                        activityChooserView0.getListPopupWindow().dismiss();
                        return;
                    }
                    activityChooserView0.getListPopupWindow().show();
                    ActionProvider actionProvider0 = activityChooserView0.i;
                    if(actionProvider0 != null) {
                        c c0 = actionProvider0.b;
                        if(c0 != null) {
                            ((ActionMenuPresenter)c0).n(true);
                        }
                    }
                }
                return;
            }
            case 1: {
                AppCompatSpinner appCompatSpinner0 = (AppCompatSpinner)this.b;
                if(!appCompatSpinner0.getInternalPopup().a()) {
                    int v = appCompatSpinner0.getTextDirection();
                    int v1 = appCompatSpinner0.getTextAlignment();
                    appCompatSpinner0.f.j(v, v1);
                }
                ViewTreeObserver viewTreeObserver0 = appCompatSpinner0.getViewTreeObserver();
                if(viewTreeObserver0 != null) {
                    viewTreeObserver0.removeOnGlobalLayoutListener(this);
                }
                return;
            }
            default: {
                K k0 = (K)this.b;
                k0.getClass();
                if(k0.c0.isAttachedToWindow() && k0.c0.getGlobalVisibleRect(k0.Z)) {
                    k0.r();
                    k0.show();
                    return;
                }
                k0.dismiss();
            }
        }
    }
}

