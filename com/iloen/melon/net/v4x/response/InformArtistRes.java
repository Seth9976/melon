package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class InformArtistRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ARTISTID")
        public String artistId;
        @b("ARTISTIMG")
        public String artistImg;
        @b("ARTISTNAME")
        public String artistName;
        @b("NEWICONYN")
        public String newIconYn;
        private static final long serialVersionUID = 0xDCB642A616F30B9DL;

        public RESPONSE() {
            this.artistId = "";
            this.artistName = "";
            this.artistImg = "";
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB8E2EA848DF30AF9L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

