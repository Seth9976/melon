package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ArtistPickRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTPICK implements Serializable {
            @b("ALBUMINFO")
            public AlbumInfoBase albumInfo;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTNAME")
            public String artistName;
            @b("ARTISTPICKSEQ")
            public String artistPickSeq;
            @b("ARTISTPICKTHUMBURL")
            public String artistPickThumbUrl;
            @b("ARTISTPICKTITLE")
            public String artistPickTitle;
            @b("ARTISTPICKVIDEOURL")
            public String artistPickVideoUrl;
            @b("PLAYTIMEMILLIS")
            public String playTimeMillis;
            private static final long serialVersionUID = 0xC29C2E3562E24A63L;

            public ARTISTPICK() {
                this.artistPickSeq = "";
                this.artistId = "";
                this.artistName = "";
                this.artistPickTitle = "";
                this.albumInfo = null;
                this.artistPickThumbUrl = "";
                this.artistPickVideoUrl = "";
                this.playTimeMillis = "";
            }
        }

        @b("ARTISTPICKLIST")
        public ArrayList artistPickList;
        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        private static final long serialVersionUID = 0x8C59BF6FC79ED297L;

        public RESPONSE() {
            this.artistPickList = null;
            this.bbsChannelSeq = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xE9028EF3014E3B0AL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

