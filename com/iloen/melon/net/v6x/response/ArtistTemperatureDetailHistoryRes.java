package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArtistTemperatureDetailHistoryRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class HISTORYLIST implements Serializable {
            public static class HISTORYINFO implements Serializable {
                @b("HISTORYCODE")
                public String historyCode;
                @b("HISTORYTEXT")
                public String historyText;
                public boolean isLastDate;
                @b("SCOREGAP")
                public String scoreGap;
                private static final long serialVersionUID = 0x6A38683C83FC8A55L;

                public HISTORYINFO() {
                    this.scoreGap = "";
                    this.historyCode = "";
                    this.historyText = "";
                    this.isLastDate = false;
                }
            }

            @b("DISPLAYTEXT")
            public String disPlayText;
            @b("HISTORYINFO")
            public List historyInfo;
            public boolean isFirstDate;
            public boolean isLastDate;
            @b("RECORDDATE")
            public String recordDate;
            private static final long serialVersionUID = 0xD71DFF7A3C1AD0B9L;
            @b("TEMPERATURESCORE")
            public String temperatureScore;

            public HISTORYLIST() {
                this.recordDate = "";
                this.temperatureScore = "";
                this.disPlayText = "";
                this.isFirstDate = false;
                this.isLastDate = false;
            }
        }

        @b("HASMORE")
        @Nullable
        public String hasMore;
        @b("HISTORYLIST")
        @Nullable
        public List historyList;
        @b("NEXTIDX")
        @Nullable
        public String nextIdx;
        private static final long serialVersionUID = 0x9090C518A7FAF73CL;

        public RESPONSE() {
            this.hasMore = "N";
            this.nextIdx = "";
        }
    }

    public static final String T01 = "T01";
    public static final String T02 = "T02";
    public static final String T03 = "T03";
    public static final String T04 = "T04";
    @b("response")
    @Nullable
    public RESPONSE response;
    private static final long serialVersionUID = 0xA729BA524DA1BA1L;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

