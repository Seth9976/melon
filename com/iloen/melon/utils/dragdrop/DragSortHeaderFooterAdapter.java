package com.iloen.melon.utils.dragdrop;

import android.view.View;

public interface DragSortHeaderFooterAdapter {
    View getDragSortFooterView();

    int getDragSortFooterViewPosition();

    View getDragSortHeaderView();

    int getDragSortHeaderViewPosition();

    boolean hasDragSortFooterView();

    boolean hasDragSortHeaderView();
}

