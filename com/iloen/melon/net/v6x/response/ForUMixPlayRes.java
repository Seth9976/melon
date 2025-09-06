package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ForUMixPlayRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            private static final long serialVersionUID = 0x26065CAAD3E90DD1L;

        }

        public static class STATSELEMENTS extends StatsElementsBase {
            private static final long serialVersionUID = 0xCE87B62744D8600BL;

        }

        @b("CONTSID")
        public String contsId;
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        private static final long serialVersionUID = 0x3281B4829174D800L;
        @b("SONGLIST")
        public ArrayList songList;
        @b("STATSELEMENTS")
        public STATSELEMENTS statsElements;

        public RESPONSE() {
            this.songList = null;
            this.contsTypeCode = "";
            this.contsId = "";
            this.statsElements = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 4873789040912710113L;

    public ForUMixPlayRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

