package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class InformExcArtistRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class ARTISTLIST implements Serializable {
            @b("ACTGENRE")
            public String actGenre;
            @b("ARTISTID")
            public String artistId;
            @b("ARTISTIMG")
            public String artistImg;
            @b("ARTISTNAME")
            public String artistName;
            @b("DELYN")
            public String delYN;
            @b("EXCARTISTSEQ")
            public String excArtistSeq;
            @b("UPDTDATE")
            public String updtDate;

        }

        @b("ARTISTLIST")
        public ArrayList artistList;
        @b("MESSAGE")
        public String message;
        private static final long serialVersionUID = 0x169CBE69064590C1L;
        @b("SERVERDATETIME")
        public String serverDateTime;

        public Response() {
            this.message = "";
            this.serverDateTime = "";
            this.artistList = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x7C036B1EDCA7C4E0L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

