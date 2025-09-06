package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v6x.common.LiveInfoBase;
import com.iloen.melon.sns.model.ShareLinkData;
import com.melon.net.res.common.ResponseBase;

public class LiveDetailRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class Live extends LiveInfoBase {
            private static final long serialVersionUID = 0x1C197C35B1FF340L;

        }

        @b("LIVE")
        public Live live;
        @b("SNSINFO")
        public ShareLinkData snsInfo;

        public Response() {
            this.live = null;
            this.snsInfo = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x69187AAD8BE7ABA3L;

    public LiveDetailRes() {
        this.response = null;
    }
}

