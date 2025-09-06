package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;

public class GenreLabelIntroRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class INTRO implements Serializable {
            @b("DESC")
            public String desc;
            private static final long serialVersionUID = 0x9CE0B6FC49EC8057L;
            @b("SUBTITLE")
            public String subTitle;
            @b("TITLE")
            public String title;

            public INTRO() {
                this.title = "";
                this.subTitle = null;
                this.desc = null;
            }
        }

        @b("INTRO")
        public INTRO intro;
        private static final long serialVersionUID = 0x290771AD8781D3B6L;

        public RESPONSE() {
            this.intro = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x895060C9E82E2E2AL;

    public GenreLabelIntroRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

