package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import org.jetbrains.annotations.NotNull;

public class ArtistTemperatureShareImgRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        @b("IMGURL")
        public String imgUrl;
        @b("KAGEACCESSKEY")
        public String kageAccessKey;
        private static final long serialVersionUID = 0x48AA4EB0756636FDL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x5DAB03CEAE355C38L;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

