package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import androidx.recyclerview.widget.Q0;
import d2.d;

public final class o extends Q0 {
    public final r a;

    public o(r r0, NavigationMenuView navigationMenuView0) {
        this.a = r0;
        super(navigationMenuView0);
    }

    @Override  // androidx.recyclerview.widget.Q0
    public final void onInitializeAccessibilityNodeInfo(View view0, d d0) {
        super.onInitializeAccessibilityNodeInfo(view0, d0);
        r r0 = this.a.e.d;
        int v1 = 0;
        for(int v = 0; v < r0.e.a.size(); ++v) {
            switch(r0.e.getItemViewType(v)) {
                case 0: 
                case 1: {
                    ++v1;
                }
            }
        }
        AccessibilityNodeInfo.CollectionInfo accessibilityNodeInfo$CollectionInfo0 = AccessibilityNodeInfo.CollectionInfo.obtain(v1, 1, false);
        d0.a.setCollectionInfo(accessibilityNodeInfo$CollectionInfo0);
    }
}

