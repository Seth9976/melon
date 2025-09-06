package com.paulburke.android.itemtouchhelperdemo;

public interface ItemTouchHelperAdapter {
    int currentDragPosition();

    boolean onItemCheckEnable();

    void onItemDismiss(int arg1);

    boolean onItemMove(int arg1, int arg2);

    void onItemMoveFinish();

    void onItemMoveStart();
}

