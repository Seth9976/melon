package com.iloen.melon.net.v4x.response;

import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import java.util.Collection;

public class GiftListFollowingAlphabetRes extends ListFollowingAlphabetBaseRes implements ResponseAdapter {
    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE listFollowingAlphabetBaseRes$RESPONSE0 = this.response;
        return listFollowingAlphabetBaseRes$RESPONSE0 != null ? listFollowingAlphabetBaseRes$RESPONSE0.userList : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }
}

