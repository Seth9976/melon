package com.iloen.melon.net;

import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.util.Collection;

public interface ResponseAdapter {
    Collection getItems();

    String getMenuId();

    StatsElementsBase getStatsElements();

    boolean hasMore();
}

