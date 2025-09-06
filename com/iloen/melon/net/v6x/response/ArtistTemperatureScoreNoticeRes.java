package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArtistTemperatureScoreNoticeRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class SCORENOTICEINFO implements Serializable {
            @b("ISPLUS")
            @Nullable
            public String isPlus;
            @b("SCOREGAP")
            @Nullable
            public String scoreGap;
            private static final long serialVersionUID = 0x2036817BF2743E4L;

            public SCORENOTICEINFO() {
                this.scoreGap = "";
                this.isPlus = "N";
            }
        }

        @b("SCORENOTICEINFO")
        @Nullable
        public SCORENOTICEINFO scoreNoticeInfo;
        @b("SCORENOTICEYN")
        @Nullable
        public String scoreNoticeYN;
        private static final long serialVersionUID = 0x158BD85248E6E802L;

        public RESPONSE() {
            this.scoreNoticeYN = "N";
        }
    }

    @b("response")
    @Nullable
    public RESPONSE response;
    private static final long serialVersionUID = 4909959414506219260L;

    public ArtistTemperatureScoreNoticeRes() {
        this.response = null;
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

