package com.iloen.melon.adapters.common;

import java.util.List;

public interface ListMarker {
    int getMarkedCount();

    List getMarkedItems();

    int getWeakMarked();

    boolean isMarked(int arg1);

    boolean isMarkedMode();

    void setMarked(int arg1, boolean arg2);

    void setMarkedAll();

    void setMarkedMode(boolean arg1);

    void setUnmarkedAll();

    void setWeakMarked(int arg1);
}

