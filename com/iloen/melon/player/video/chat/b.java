package com.iloen.melon.player.video.chat;

import B0.s;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View;
import android.view.WindowInsets;
import c2.h0;
import kotlin.jvm.internal.q;

public final class b implements View.OnApplyWindowInsetsListener {
    public final View a;

    public b(View view0) {
        this.a = view0;
    }

    @Override  // android.view.View$OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view0, WindowInsets windowInsets0) {
        q.g(view0, "<unused var>");
        q.g(windowInsets0, "windowInsets");
        int v = windowInsets0.getInsets(h0.b()).top;
        int v1 = windowInsets0.getInsets(s.B()).bottom;
        this.a.setPadding(0, v, 0, v1);
        return windowInsets0;
    }
}

