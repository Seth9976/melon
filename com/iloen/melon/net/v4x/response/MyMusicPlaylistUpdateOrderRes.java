package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicPlaylistUpdateOrderRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ENDDSPLYORDER")
        public String enddsplyorder;
        @b("MOVEDSPLYORDER")
        public String movedsplyorder;
        @b("MOVEPLYLSTSEQ")
        public String moveplylstseq;
        @b("MOVETYPE")
        public String movetype;
        @b("PLYLSTTYPECODE")
        public String plylsttypecode;
        private static final long serialVersionUID = 0x6ADAB0DE9DB21E11L;

        public RESPONSE() {
            this.movetype = "";
            this.movedsplyorder = "";
            this.enddsplyorder = "";
            this.moveplylstseq = "";
            this.plylsttypecode = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x929FFD9E0BD24048L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

