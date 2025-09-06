package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicSeriesInformCntCheckRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("CNTOVERYN")
        public String cntoverYn;
        private static final long serialVersionUID = 3998810657955487058L;

        public RESPONSE() {
            this.cntoverYn = "";
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x21D01485CD178B05L;

    public MyMusicSeriesInformCntCheckRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

