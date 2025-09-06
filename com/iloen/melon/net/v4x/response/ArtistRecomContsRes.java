package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ContsInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class ArtistRecomContsRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class CONTSLIST extends ContsInfoBase {
            @b("CHNLLSEQ")
            public String chnllSeq;
            @b("PLAYTIME")
            public String playTime;
            private static final long serialVersionUID = 0x3D65EA4C0AB1A643L;
            @b("TITLE")
            public String title;
            @b("TYPE")
            public String type;

            public CONTSLIST() {
                this.playTime = "";
            }
        }

        @b("CONTSLIST")
        public ArrayList contsList;
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 3613643360706868131L;

        public RESPONSE() {
            this.contsList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xAE218473CD8261AFL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

