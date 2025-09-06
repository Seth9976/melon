package androidx.appcompat.widget;

import android.widget.AbsListView;

public abstract class k0 {
    public static boolean a(AbsListView absListView0) {
        return absListView0.isSelectedChildViewEnabled();
    }

    public static void b(AbsListView absListView0, boolean z) {
        absListView0.setSelectedChildViewEnabled(z);
    }
}

