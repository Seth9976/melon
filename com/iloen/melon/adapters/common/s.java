package com.iloen.melon.adapters.common;

import com.iloen.melon.playback.Playable;
import java.util.List;
import v9.m;

public interface s {
    List getAllIndexItems();

    m getAllWithoutRecommend();

    m getMarkedList(boolean arg1);

    List getMarkedPlayableItems();

    Playable getPlayable(int arg1);

    List getPlayableItems(List arg1);

    int getServiceAvailableCount();

    List getSongsFromPositionIndices(List arg1);
}

