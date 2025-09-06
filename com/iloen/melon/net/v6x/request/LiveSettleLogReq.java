package com.iloen.melon.net.v6x.request;

import android.content.Context;
import com.iloen.melon.net.v6x.response.LiveSettleLogRes;

public class LiveSettleLogReq extends RequestV6Req {
    public static class ParamInfo {
        public String liveSeq;
        public String menuId;
        public String token;

    }

    public LiveSettleLogReq(Context context0, ParamInfo liveSettleLogReq$ParamInfo0) {
        super(context0, 0, LiveSettleLogRes.class);
        this.setup(liveSettleLogReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/live/settle/log.json";
    }

    private void setup(ParamInfo liveSettleLogReq$ParamInfo0) {
        this.addMemberKey();
        this.addParam("liveSeq", liveSettleLogReq$ParamInfo0.liveSeq);
        this.addParam("menuId", liveSettleLogReq$ParamInfo0.menuId);
        this.addParam("token", liveSettleLogReq$ParamInfo0.token);
    }
}

