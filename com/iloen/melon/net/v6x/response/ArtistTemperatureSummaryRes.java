package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v6x.common.MemorialCardInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class ArtistTemperatureSummaryRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class INFO extends MemorialCardInfoBase {
            private static final long serialVersionUID = -5119631483056806970L;

        }

        public static class MEMORIALCARDRELAYLIST extends MemorialCardInfoBase {
            @b("INFO")
            public INFO info;
            @b("MEMBERIMG")
            public String memberImg;
            @b("MEMBERKEY")
            public String memberKey;
            @b("MEMBERNAME")
            public String memberName;
            private static final long serialVersionUID = 0x1D9A7FD59FA21C5EL;
            @b("TYPE")
            public String type;

            public MEMORIALCARDRELAYLIST() {
                this.type = "";
                this.memberKey = "";
                this.memberName = "";
                this.memberImg = "";
            }
        }

        @b("ACTIVEMEMORIALCARDCNT")
        public String activeMemorialCardCnt;
        @b("ARTISTMEMORIALCARDRELAYCNT")
        public String artistMemorialCardRelayCnt;
        @b("MEMORIALCARDRELAYLIST")
        public ArrayList memorialCardRelayListList;
        private static final long serialVersionUID = 0x32E13C56A3C240ACL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xD11F1A3D0027618L;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

