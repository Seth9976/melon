package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class CastProgramEpsdRes extends ResponseV5Res implements ResponseAdapter {
    public static class Response extends ResponseBase {
        public static class CastList extends CastInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x147A0954EAC1B68EL;

        }

        @b("CASTLIST")
        public ArrayList castList;
        @b("HASMORE")
        public Boolean hasMore;
        private static final long serialVersionUID = 0x147A095505942B0EL;

    }

    public Response response;
    private static final long serialVersionUID = 0x39C48B0FB448722BL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Response castProgramEpsdRes$Response0 = this.response;
        return castProgramEpsdRes$Response0 != null ? castProgramEpsdRes$Response0.castList : null;
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
        Response castProgramEpsdRes$Response0 = this.response;
        if(castProgramEpsdRes$Response0 != null) {
            return castProgramEpsdRes$Response0.hasMore == null ? false : castProgramEpsdRes$Response0.hasMore.booleanValue();
        }
        return false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

