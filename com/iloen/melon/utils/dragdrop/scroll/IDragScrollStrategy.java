package com.iloen.melon.utils.dragdrop.scroll;

import androidx.recyclerview.widget.O0;
import com.paulburke.android.itemtouchhelperdemo.ItemTouchHelperAdapter;

public interface IDragScrollStrategy {
    void autoScroll(O0 arg1, ItemTouchHelperAdapter arg2, DragPos arg3);

    int getFirstVisiblePosition();

    int getLastVisiblePosition();

    int getMovementFlags();
}

