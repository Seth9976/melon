package com.google.android.material.bottomnavigation;

import android.content.Context;
import com.google.android.material.navigation.NavigationBarItemView;

public class BottomNavigationItemView extends NavigationBarItemView {
    public BottomNavigationItemView(Context context0) {
        super(context0);
    }

    @Override  // com.google.android.material.navigation.NavigationBarItemView
    public int getItemDefaultMarginResId() {
        return 0x7F0700BD;  // dimen:design_bottom_navigation_margin
    }

    @Override  // com.google.android.material.navigation.NavigationBarItemView
    public int getItemLayoutResId() {
        return 0x7F0D01E8;  // layout:design_bottom_navigation_item
    }
}

