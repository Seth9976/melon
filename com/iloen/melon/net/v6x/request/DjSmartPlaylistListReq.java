package com.iloen.melon.net.v6x.request;

import com.iloen.melon.net.v6x.response.DjSmartPlaylistListRes;
import e1.u;
import va.e0;
import va.o;

public class DjSmartPlaylistListReq extends RequestV6_1Req {
    public static class Params {
        public String mode;
        public String orderBy;
        public String targetMemberKey;

        public Params() {
            this.targetMemberKey = "";
            this.mode = "all";
            this.orderBy = "UDT";
        }
    }

    public static String ORDER_BY_DSP = "DSP";
    public static String ORDER_BY_LIK = "LIK";
    public static String ORDER_BY_UDT = "UDT";

    public DjSmartPlaylistListReq(Params djSmartPlaylistListReq$Params0) {
        super(0, DjSmartPlaylistListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(djSmartPlaylistListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/dj/connected/playlist/list.json";
    }
}

