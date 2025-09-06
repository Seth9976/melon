package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjTagSearchAutoCompleteRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class TAGLIST extends TagInfoBase {
            @b("PLYLSTCNT")
            public String plylstcnt;
            private static final long serialVersionUID = 7701124390408208849L;

        }

        private static final long serialVersionUID = -5582492000141529667L;
        @b("TAGLIST")
        public ArrayList tagList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -1795572066197054009L;

    public DjTagSearchAutoCompleteRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djTagSearchAutoCompleteRes$RESPONSE0 = this.response;
        return djTagSearchAutoCompleteRes$RESPONSE0 != null ? djTagSearchAutoCompleteRes$RESPONSE0.tagList : null;
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
        return false;
    }
}

