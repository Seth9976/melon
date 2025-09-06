package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import k.y;

public class NavigationMenuView extends RecyclerView implements y {
    public NavigationMenuView(Context context0) {
        this(context0, null);
    }

    public NavigationMenuView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0);
    }

    public NavigationMenuView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.setLayoutManager(new LinearLayoutManager(1, false));
    }

    @Override  // k.y
    public final void a(MenuBuilder menuBuilder0) {
    }

    public int getWindowAnimations() {
        return 0;
    }
}

