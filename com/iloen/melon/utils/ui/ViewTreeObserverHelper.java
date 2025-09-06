package com.iloen.melon.utils.ui;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver;

public class ViewTreeObserverHelper {
    public interface OnGlobalLayoutListener {
        void onGlobalLayout();
    }

    public View a;
    public OnGlobalLayoutListener b;
    public final ViewTreeObserver.OnGlobalLayoutListener c;

    public ViewTreeObserverHelper() {
        this.c = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final ViewTreeObserverHelper a;

            {
                this.a = viewTreeObserverHelper0;
            }

            @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
            public void onGlobalLayout() {
                ViewTreeObserverHelper viewTreeObserverHelper0 = this.a;
                OnGlobalLayoutListener viewTreeObserverHelper$OnGlobalLayoutListener0 = viewTreeObserverHelper0.b;
                if(viewTreeObserverHelper$OnGlobalLayoutListener0 != null) {
                    viewTreeObserverHelper$OnGlobalLayoutListener0.onGlobalLayout();
                }
                viewTreeObserverHelper0.unregisterGlobalLayoutListener();
            }
        };
    }

    public void registerGlobalLayoutListener(View view0, OnGlobalLayoutListener viewTreeObserverHelper$OnGlobalLayoutListener0) {
        if(view0 != null && viewTreeObserverHelper$OnGlobalLayoutListener0 != null) {
            if(this.a != null) {
                this.unregisterGlobalLayoutListener();
            }
            this.a = view0;
            this.b = viewTreeObserverHelper$OnGlobalLayoutListener0;
            ViewTreeObserver viewTreeObserver0 = view0.getViewTreeObserver();
            if(viewTreeObserver0 != null) {
                viewTreeObserver0.addOnGlobalLayoutListener(this.c);
            }
        }
    }

    public void unregisterGlobalLayoutListener() {
        ViewTreeObserver viewTreeObserver0 = this.a == null ? null : this.a.getViewTreeObserver();
        if(viewTreeObserver0 != null) {
            viewTreeObserver0.removeOnGlobalLayoutListener(this.c);
        }
    }
}

