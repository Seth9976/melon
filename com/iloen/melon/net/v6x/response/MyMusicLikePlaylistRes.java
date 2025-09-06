package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicLikePlaylistRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class LIKEPLYLSTLIST implements Serializable {
            @b("ALBUMIMGS")
            public ArrayList albumImgs;
            @b("CONTENTID")
            public String contentId;
            @b("CONTENTSTYPECODE")
            public String contentsTypeCode;
            @b("HASMELONLOGO")
            public Boolean hasMelonLogo;
            @b("ISOPEN")
            public Boolean isOpen;
            @b("ISSERVICE")
            public Boolean isService;
            @b("MAINREPLACE")
            public String mainReplace;
            @b("MAINTITLE")
            public String mainTitle;
            @b("OWNERNICKNAME")
            public String ownerNickName;
            @b("SEEDCONTENTID")
            public String seedContentId;
            @b("SEEDCONTENTSTYPECODE")
            public String seedContentsTypeCode;
            private static final long serialVersionUID = 0xF6C7F0E0FE76C4C1L;
            @b("TYPE")
            public String type;

            public LIKEPLYLSTLIST() {
                this.mainTitle = "";
                this.mainReplace = "";
                this.ownerNickName = "";
                this.type = "";
                this.isService = Boolean.FALSE;
                this.isOpen = Boolean.FALSE;
                this.hasMelonLogo = Boolean.FALSE;
                this.contentId = "";
                this.contentsTypeCode = "";
                this.seedContentId = "";
                this.seedContentsTypeCode = "";
            }
        }

        @b("LIKEPLYLSTLIST")
        public ArrayList likePlaylistList;
        private static final long serialVersionUID = 0xD0FAA9ECABD9AEB0L;

        public RESPONSE() {
            this.likePlaylistList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x2AD19603102F64B1L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

