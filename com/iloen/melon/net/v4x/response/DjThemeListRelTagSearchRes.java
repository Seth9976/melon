package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class DjThemeListRelTagSearchRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class TAGLIST extends TagInfoBase {
            @b("PLYLSTCNT")
            public String plylstcnt;
            private static final long serialVersionUID = 0x377C81B7FD3C5971L;

        }

        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0x6A33A205973F7972L;
        @b("TAGAREATYPE")
        public String tagAreaType;
        @b("TAGLIST")
        public ArrayList tagList;
        @b("TAGNAME")
        public String tagName;
        @b("TAGSEQ")
        public String tagSeq;

    }

    public static enum SEARCH_RESULT {
        EMPTY,
        SUCCESS;

        private static SEARCH_RESULT[] $values() [...] // Inlined contents
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA2B1165D58A82F11L;

    public DjThemeListRelTagSearchRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE djThemeListRelTagSearchRes$RESPONSE0 = this.response;
        return djThemeListRelTagSearchRes$RESPONSE0 != null ? djThemeListRelTagSearchRes$RESPONSE0.tagList : null;
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

    public SEARCH_RESULT resultType() {
        RESPONSE djThemeListRelTagSearchRes$RESPONSE0 = this.response;
        if(djThemeListRelTagSearchRes$RESPONSE0 != null) {
            if("OFFER".equals(djThemeListRelTagSearchRes$RESPONSE0.tagAreaType)) {
                return SEARCH_RESULT.EMPTY;
            }
            return "REL".equals(this.response.tagAreaType) ? SEARCH_RESULT.SUCCESS : SEARCH_RESULT.SUCCESS;
        }
        return SEARCH_RESULT.SUCCESS;
    }
}

