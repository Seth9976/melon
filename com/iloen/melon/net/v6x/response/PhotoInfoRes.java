package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class PhotoInfoRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class NEXTPHOTOIDLIST implements Serializable {
            @b("PHOTOID")
            public String photoid;
            private static final long serialVersionUID = 0x36BC79A0D2800970L;

            public NEXTPHOTOIDLIST() {
                this.photoid = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class PREVPHOTOIDLIST implements Serializable {
            @b("PHOTOID")
            public String photoid;
            private static final long serialVersionUID = 3648500728172983174L;

            public PREVPHOTOIDLIST() {
                this.photoid = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("ARTISTLIST")
        public ArrayList artistlist;
        @b("BBSCHANNELSEQ")
        public int bbschannelseq;
        @b("CMTCNT")
        public String cmtcnt;
        @b("DESC")
        public String desc;
        @b("NEXTMOREYN")
        public String nextmoreyn;
        @b("NEXTPHOTOIDLIST")
        public ArrayList nextphotoidlist;
        @b("PHOTOCNT")
        public String photocnt;
        @b("PHOTOID")
        public String photoid;
        @b("PHOTOIMG")
        public String photoimg;
        @b("PHOTOINDEX")
        public String photoindex;
        @b("POSTEDITIMG")
        public String posteditimg;
        @b("POSTIMG")
        public String postimg;
        @b("PREVMOREYN")
        public String prevmoreyn;
        @b("PREVPHOTOIDLIST")
        public ArrayList prevphotoidlist;
        private static final long serialVersionUID = 0x91587439B25A86FBL;
        @b("TITLE")
        public String title;

        public RESPONSE() {
            this.photoid = "";
            this.photoimg = "";
            this.postimg = "";
            this.posteditimg = "";
            this.title = "";
            this.desc = "";
            this.artistlist = null;
            this.cmtcnt = "";
            this.bbschannelseq = 0;
            this.photocnt = "";
            this.photoindex = "";
            this.prevphotoidlist = null;
            this.nextphotoidlist = null;
            this.prevmoreyn = "";
            this.nextmoreyn = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x49A2D58D218328F9L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

