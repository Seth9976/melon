package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.response.DetailBaseRes.DetailResponseBase;
import com.iloen.melon.net.v5x.response.DetailBaseRes;
import java.util.List;

public class AlbumContentsListRes extends DetailBaseRes {
    public static class RESPONSE extends DetailResponseBase {
        @b("CPLANCODE")
        public String cPlanCode;
        @b("MAGAZINEALLBUTTONFLAG")
        public boolean magazineAllButtonFlag;
        @b("MAGAZINELIST")
        public List magazineList;
        @b("MVALLBUTTONFLAG")
        public boolean mvAllButtonFlag;
        @b("MVLIST")
        public List mvList;
        @b("OTHERVERSIONALBUMLIST")
        public List otherVersionAlbumList;
        @b("OTHERVERSIONALLBUTTONFLAG")
        public boolean otherVersionAllButtonFlag;
        @b("PHOTOALLBUTTONFLAG")
        public boolean photoAllButtonFlag;
        @b("PHOTOLIST")
        public List photoList;
        private static final long serialVersionUID = 0x1F1AA8842A853C41L;
        @b("SERIESALBUMLIST")
        public List seriesAlbumList;
        @b("SERIESALLBUTTONFLAG")
        public boolean seriesAllButtonFlag;
        @b("STATIONALLBUTTONFLAG")
        public boolean stationAllButtonFlag;
        @b("STATIONLIST")
        public List stationList;
        @b("TICKETLIST")
        public List ticketList;

        public RESPONSE() {
            this.mvAllButtonFlag = false;
            this.magazineAllButtonFlag = false;
            this.photoAllButtonFlag = false;
            this.otherVersionAllButtonFlag = false;
            this.seriesAllButtonFlag = false;
            this.stationAllButtonFlag = false;
            this.cPlanCode = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5852884646D9B52DL;

    public AlbumContentsListRes() {
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

