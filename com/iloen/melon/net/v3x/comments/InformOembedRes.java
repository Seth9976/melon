package com.iloen.melon.net.v3x.comments;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;

public class InformOembedRes extends CmtBaseRes {
    public static class result implements Serializable {
        @b("cmtSeq")
        public int cmtseq;
        private static final long serialVersionUID = 0xC4183DEC155EA8E9L;
        @b("thumbUrl")
        public String thumburl;
        @b("videoHeight")
        public int videoheight;
        @b("videoHtml")
        public String videohtml;
        @b("videoTitle")
        public String videotitle;
        @b("videoUrl")
        public String videourl;
        @b("videoWidth")
        public int videowidth;

        public result() {
            this.cmtseq = -1;
            this.videourl = "";
            this.thumburl = "";
            this.videotitle = "";
            this.videowidth = -1;
            this.videoheight = -1;
            this.videohtml = "";
        }

        @Override
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("result")
    public result result;
    private static final long serialVersionUID = 0x44C52A8C59D419FCL;

    public InformOembedRes() {
        this.result = null;
    }

    @Override  // com.iloen.melon.net.v3x.comments.CmtBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

