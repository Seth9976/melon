package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ForuMixMakerMainRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class ARTISTTAGLIST implements Serializable {
            @b("IMGURL")
            public String imgUrl;
            public boolean isSaved;
            private static final long serialVersionUID = 0x90CEC6BEA04ABECL;
            @b("TAGNAME")
            public String tagName;

            public ARTISTTAGLIST() {
                this.tagName = "";
                this.imgUrl = "";
            }
        }

        public static class TAGLIST implements Serializable {
            @b("EMOJI")
            public String emoji;
            public boolean isSaved;
            private static final long serialVersionUID = 0xCC754C99D08694C6L;
            @b("TAGNAME")
            public String tagName;

            public TAGLIST() {
                this.tagName = "";
                this.emoji = "";
            }
        }

        @b("ARTISTTAGLIST")
        public ArrayList artistTagList;
        @b("PLACEHOLDERTEXT")
        public String placeHolderText;
        private static final long serialVersionUID = 0x1948267F649A41CL;
        @b("TAGLIST")
        public ArrayList tagList;

        public RESPONSE() {
            this.placeHolderText = "";
            this.tagList = null;
            this.artistTagList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xA41BAB3BEA4B1386L;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() [...] // 潜在的解密器

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

