package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ArtistListArtistInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTLIST extends ArtistsInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            private static final long serialVersionUID = 0x6F7294EE1B279835L;

        }

        @b("ARTISTLIST")
        public ArrayList artistList;
        private static final long serialVersionUID = 0x19356C4D0C425B6EL;

        public RESPONSE() {
            this.artistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x8330379E0D8842E5L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

