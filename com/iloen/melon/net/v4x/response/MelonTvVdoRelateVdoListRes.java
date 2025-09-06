package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MelonTvVdoRelateVdoListRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class MVLIST extends MvInfoBase {
            @b("PROGRAMNAME")
            public String programname;
            private static final long serialVersionUID = 0xA3D4EF461ECAD819L;

            public MVLIST() {
                this.programname = "";
            }

            @Override  // com.melon.net.res.common.MvInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("MVLIST")
        public ArrayList mvlist;
        private static final long serialVersionUID = 0x9061479DCC58B431L;

        public RESPONSE() {
            this.mvlist = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x67368B88306E3BC4L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE melonTvVdoRelateVdoListRes$RESPONSE0 = this.response;
        return melonTvVdoRelateVdoListRes$RESPONSE0 != null ? melonTvVdoRelateVdoListRes$RESPONSE0.mvlist : null;
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

