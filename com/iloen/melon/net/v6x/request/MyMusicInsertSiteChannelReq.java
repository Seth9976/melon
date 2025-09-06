package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.MyMusicInsertSiteChannelRes;

public class MyMusicInsertSiteChannelReq extends RequestV6Req {
    public static class Params {
        public String infoCode;
        public String infoDesc;
        public String infoVal;
        public String repntYn;

        public Params() {
            this.infoCode = "";
            this.infoDesc = "";
            this.infoVal = "";
            this.repntYn = "N";
        }
    }

    public MyMusicInsertSiteChannelReq(Context context0, Params myMusicInsertSiteChannelReq$Params0) {
        super(context0, 0, MyMusicInsertSiteChannelRes.class);
        this.addMemberKey();
        this.addParams(myMusicInsertSiteChannelReq$Params0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/mymusic/insertSiteChannel.json";
    }
}

