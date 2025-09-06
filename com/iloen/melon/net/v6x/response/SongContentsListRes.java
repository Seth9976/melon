package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes;
import java.util.List;

public class SongContentsListRes extends DetailBaseRes {
    public static class RESPONSE extends DetailResponseBase {
        @b("DJPLAYLISTLIST")
        public List PLAYLISTList;
        @b("DJPLAYLISTALLBUTTONFLAG")
        public boolean djplaylistAllButtonFlag;
        @b("MAGAZINEALLBUTTONFLAG")
        public boolean magazineAllButtonFlag;
        @b("MAGAZINELIST")
        public List magazineList;
        @b("MVALLBUTTONFLAG")
        public boolean mvAllButtonFlag;
        @b("MVLIST")
        public List mvList;
        @b("OTHERVERSIONALLBUTTONFLAG")
        public boolean otherVersionAllButtonFlag;
        @b("OTHERVERSIONSONGLIST")
        public List otherVersionSongList;
        private static final long serialVersionUID = 0x1F1AA0CDC321FC41L;
        @b("SIMILARALLBUTTONFLAG")
        public boolean similarAllButtonFlag;
        @b("SIMILARSONGLIST")
        public List similarSongList;
        @b("STATIONALLBUTTONFLAG")
        public boolean stationAllButtonFlag;
        @b("STATIONLIST")
        public List stationList;
        @b("TICKETLIST")
        public List ticketList;

        public RESPONSE() {
            this.mvAllButtonFlag = false;
            this.magazineAllButtonFlag = false;
            this.djplaylistAllButtonFlag = false;
            this.otherVersionAllButtonFlag = false;
            this.similarAllButtonFlag = false;
            this.stationAllButtonFlag = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x10286BD346D1B52DL;

    public SongContentsListRes() {
        this.response = null;
    }

    @Override  // com.iloen.melon.net.v5x.response.DetailBaseRes
    public DetailResponseBase getResponseBase() {
        return this.response;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

