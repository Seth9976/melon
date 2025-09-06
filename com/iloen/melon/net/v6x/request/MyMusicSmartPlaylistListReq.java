package com.iloen.melon.net.v6x.request;

import com.iloen.melon.net.v6x.response.MyMusicSmartPlaylistListRes;
import e1.u;
import va.e0;
import va.o;

public class MyMusicSmartPlaylistListReq extends RequestV6_1Req {
    public static class Params {
        public String mode;
        public String orderBy;
        public String targetMemberKey;

        public Params() {
            this.targetMemberKey = "";
            this.mode = "all";
            this.orderBy = "REG_DATE";
        }
    }

    public static String ORDER_BY_DSPLY_ORDER = "DSPLY_ORDER";
    public static String ORDER_BY_REG_DATE = "REG_DATE";
    public static String ORDER_BY_SUMM_CNT = "SUMM_CNT";

    public MyMusicSmartPlaylistListReq(Params myMusicSmartPlaylistListReq$Params0) {
        super(0, MyMusicSmartPlaylistListRes.class);
        this.addMemberKey(u.v(((e0)o.a()).j()), Boolean.FALSE);
        this.addParams(myMusicSmartPlaylistListReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/connected/playlist/list.json";
    }
}

