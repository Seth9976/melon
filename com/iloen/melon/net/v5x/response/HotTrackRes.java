package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class HotTrackRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class HOTTRACKS implements Serializable {
            public static class CHARTLIST extends SongInfoBase {
                @b("CURRANK")
                public String currentRank;
                @b("PASTRANK")
                public String pastRank;
                @b("RANKGAP")
                public String rankGap;
                @b("RANKTYPE")
                public String rankType;
                private static final long serialVersionUID = 0x75BA92A28288D2FCL;

            }

            @b("CHARTLIST")
            public ArrayList chartList;
            @b("GNRCODE")
            public String gnrCode;
            @b("GNRNAME")
            public String gnrName;
            @b("HOTTRACKCODE")
            public String hotTrackCode;
            @b("HOTTRACKDESC")
            public String hotTrackDesc;
            @b("HOTTRACKTITLE")
            public String hotTrackTitle;
            @b("TAGNAME")
            public String tagName;
            @b("TAGSEQ")
            public String tagSeq;

        }

        @b("HOTTRACKS")
        public ArrayList hotTracks;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3072EC2AE8F2B835L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

