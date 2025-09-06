package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjThemeListPlylstRes extends ResponseV4Res implements ResponseAdapter {
    public static class response extends ResponseBase {
        public static class PLYLSTLIST extends DjPlayListInfoBase {
            private static final long serialVersionUID = 5000557254273537803L;

        }

        @b("HASMORE")
        public boolean hasMore;
        @b("PLYLSTLIST")
        public ArrayList plylstList;
        private static final long serialVersionUID = 0x3866B052130D4DE0L;

    }

    @b("response")
    public response response;
    private static final long serialVersionUID = 0x3C88EAF65A243C71L;

    public DjThemeListPlylstRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        response djThemeListPlylstRes$response0 = this.response;
        return djThemeListPlylstRes$response0 != null ? djThemeListPlylstRes$response0.plylstList : null;
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

