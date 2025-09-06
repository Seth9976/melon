package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.response.ResponseV4Res;
import com.melon.net.res.common.ArtistInfoBase;
import com.melon.net.res.common.ResponseBase;

public class GenreMoreIntroRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class INTRO extends ArtistInfoBase {
            @b("DESC")
            public String desc;
            private static final long serialVersionUID = 0x9CE0B6FC36D9B057L;
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

        @b("HASMORE")
        public boolean hasMore;
        @b("INTRO")
        public INTRO intro;
        private static final long serialVersionUID = 0x290771AD87820426L;

        public RESPONSE() {
            this.intro = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x8944DE069F1BAE2AL;

    public GenreMoreIntroRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

