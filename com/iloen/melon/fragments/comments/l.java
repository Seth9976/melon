package com.iloen.melon.fragments.comments;

import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;

public final class l implements View.OnApplyWindowInsetsListener {
    public final View a;

    public l(View view0) {
        this.a = view0;
    }

    @Override  // android.view.View$OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
        return CommentInputPopup.initView$lambda$1(this.a, view0, windowInsets0);
    }
}

