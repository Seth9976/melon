package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class ArtistFanFollowYnListRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class FOLLOWYNLIST implements Serializable {
            @b("FOLLOWYN")
            public String followYN;
            @b("MEMBERKEY")
            public String memberKey;
            private static final long serialVersionUID = 5056816045346107003L;

            public FOLLOWYNLIST() {
                this.memberKey = "";
                this.followYN = "N";
            }
        }

        @b("FOLLOWYNLIST")
        public ArrayList followYNList;
        private static final long serialVersionUID = 0xE601A9A7CADAC830L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -8681037895372580290L;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

