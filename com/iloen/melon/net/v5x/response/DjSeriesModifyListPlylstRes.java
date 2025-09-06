package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class DjSeriesModifyListPlylstRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class PLYLSTLIST extends DjPlayListInfoBase {
            private static final long serialVersionUID = 0x5C729C78D4F9B6DAL;

            @Override  // com.melon.net.res.common.DjPlayListInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("PLYLSTLIST")
        public ArrayList playlistList;
        private static final long serialVersionUID = 0xD0F0209F6400240AL;
        @b("SERIESPLYLSTMAXCNT")
        public String seriesPlaylistMaxCount;

        public RESPONSE() {
            this.seriesPlaylistMaxCount = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x310529280E459303L;

    public DjSeriesModifyListPlylstRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

