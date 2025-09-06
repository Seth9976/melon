package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ContsInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v6x.response.ResponseV6Res;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class AlbumSuggestedContentsRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class RECMLIST extends ContsInfoBase {
            @b("CHNLLSEQ")
            public String chnllSeq;
            @b("PLAYTIME")
            public String playTime;
            @b("RECMTYPECODE")
            public String recmTypeCode;
            @b("RELATTITLE")
            public String relatTitle;
            private static final long serialVersionUID = 0xE7F7F8628550B8EFL;

            public RECMLIST() {
                this.playTime = "";
            }
        }

        @b("POPUPTITLE")
        public String popupTitle;
        @b("RECMLIST")
        public ArrayList recmList;
        private static final long serialVersionUID = -2540635154691003177L;

        public RESPONSE() {
            this.recmList = null;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 6107534053842539287L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

