package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class CastMemberDetailRes extends ResponseV5Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class PROGRAM extends ProgramBase {
            @b("MOREDATA")
            public boolean moreData;
            private static final long serialVersionUID = 0xD10AE4E5D05A57CDL;

            public PROGRAM() {
                this.moreData = false;
            }
        }

        @b("HASMORE")
        public Boolean hasMore;
        @b("PROGRAMLIST")
        public ArrayList programList;
        private static final long serialVersionUID = 0x9EF76FABE115EF2DL;

        public RESPONSE() {
            this.programList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA1DCB0DF514DFED2L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE castMemberDetailRes$RESPONSE0 = this.response;
        return castMemberDetailRes$RESPONSE0 != null ? castMemberDetailRes$RESPONSE0.programList : null;
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
        RESPONSE castMemberDetailRes$RESPONSE0 = this.response;
        if(castMemberDetailRes$RESPONSE0 != null) {
            return castMemberDetailRes$RESPONSE0.hasMore == null ? false : castMemberDetailRes$RESPONSE0.hasMore.booleanValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

