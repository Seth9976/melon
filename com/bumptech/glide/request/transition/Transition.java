package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface Transition {
    public interface ViewAdapter {
        Drawable getCurrentDrawable();

        View getView();

        void setDrawable(Drawable arg1);
    }

    boolean transition(Object arg1, ViewAdapter arg2);
}

