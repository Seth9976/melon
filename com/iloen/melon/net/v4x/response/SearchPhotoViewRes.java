package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class SearchPhotoViewRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTLIST extends ArtistInfoBase {
            private static final long serialVersionUID = 0xDA2368F98B82B0DBL;

            @Override  // com.melon.net.res.common.ArtistInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class NEXTPHOTOIDLIST implements Serializable {
            @b("ARTISTLIST")
            public ArrayList artistlist;
            @b("PHOTOID")
            public String photoid;
            private static final long serialVersionUID = 0x9FDAD586B7391C5DL;

            public NEXTPHOTOIDLIST() {
                this.artistlist = null;
                this.photoid = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class PREVPHOTOIDLIST implements Serializable {
            @b("ARTISTLIST")
            public ArrayList artistlist;
            @b("PHOTOID")
            public String photoid;
            private static final long serialVersionUID = 0x749C295F7177CE9BL;

            public PREVPHOTOIDLIST() {
                this.artistlist = null;
                this.photoid = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("ARTISTLIST")
        public ArrayList artistlist;
        @b("NEXTMOREYN")
        public String nextmoreyn;
        @b("NEXTPHOTOIDLIST")
        public ArrayList nextphotoidlist;
        @b("ORDERBY")
        public String orderby;
        @b("PHOTOID")
        public String photoid;
        @b("PHOTOINDEX")
        public String photoindex;
        @b("PREVMOREYN")
        public String prevmoreyn;
        @b("PREVPHOTOIDLIST")
        public ArrayList prevphotoidlist;
        @b("SEARCHKEYWORD")
        public String searchkeyword;
        private static final long serialVersionUID = 7740740052538863892L;

        public RESPONSE() {
            this.searchkeyword = "";
            this.orderby = "";
            this.artistlist = null;
            this.photoid = "";
            this.photoindex = "";
            this.prevphotoidlist = null;
            this.nextphotoidlist = null;
            this.prevmoreyn = "";
            this.nextmoreyn = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDB6E43C81F0B1179L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

