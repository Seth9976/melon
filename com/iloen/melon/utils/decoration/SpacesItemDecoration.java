package com.iloen.melon.utils.decoration;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.K0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r0;
import com.iloen.melon.utils.system.ScreenUtils;

public class SpacesItemDecoration extends r0 {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public SpacesItemDecoration(Context context0) {
        this(context0, 8, 8);
    }

    public SpacesItemDecoration(Context context0, int v, int v1) {
        this.a = ScreenUtils.dipToPixel(context0, ((float)v));
        this.b = ScreenUtils.dipToPixel(context0, ((float)v));
        this.c = ScreenUtils.dipToPixel(context0, ((float)v));
        this.d = ScreenUtils.dipToPixel(context0, ((float)v));
        this.e = ScreenUtils.dipToPixel(context0, ((float)v1));
        this.f = ScreenUtils.dipToPixel(context0, ((float)v1));
        this.g = ScreenUtils.dipToPixel(context0, ((float)v1));
        this.h = ScreenUtils.dipToPixel(context0, ((float)v1));
    }

    public SpacesItemDecoration(Context context0, int v, int v1, int v2, int v3, int v4) {
        this.a = ScreenUtils.dipToPixel(context0, ((float)v));
        this.b = ScreenUtils.dipToPixel(context0, ((float)v1));
        this.c = ScreenUtils.dipToPixel(context0, ((float)v2));
        this.d = ScreenUtils.dipToPixel(context0, ((float)v3));
        this.e = ScreenUtils.dipToPixel(context0, ((float)v4));
        this.f = ScreenUtils.dipToPixel(context0, ((float)v4));
        this.g = ScreenUtils.dipToPixel(context0, ((float)v4));
        this.h = ScreenUtils.dipToPixel(context0, ((float)v4));
    }

    public SpacesItemDecoration(Context context0, int v, int v1, int v2, int v3, int v4, int v5, int v6, int v7) {
        this.a = ScreenUtils.dipToPixel(context0, ((float)v));
        this.b = ScreenUtils.dipToPixel(context0, ((float)v1));
        this.c = ScreenUtils.dipToPixel(context0, ((float)v2));
        this.d = ScreenUtils.dipToPixel(context0, ((float)v3));
        this.e = ScreenUtils.dipToPixel(context0, ((float)v4));
        this.f = ScreenUtils.dipToPixel(context0, ((float)v5));
        this.g = ScreenUtils.dipToPixel(context0, ((float)v6));
        this.h = ScreenUtils.dipToPixel(context0, ((float)v7));
    }

    @Override  // androidx.recyclerview.widget.r0
    public void getItemOffsets(Rect rect0, View view0, RecyclerView recyclerView0, K0 k00) {
        recyclerView0.setPadding(this.e, this.f, this.g, this.h);
        recyclerView0.setClipToPadding(false);
        rect0.left = this.a;
        rect0.top = this.b;
        rect0.right = this.c;
        rect0.bottom = this.d;
    }
}

