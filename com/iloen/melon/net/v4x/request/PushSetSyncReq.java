package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;

public class PushSetSyncReq extends PushSetReq {
    public PushSetSyncReq(Context context0, ParamInfo pushSetReq$ParamInfo0, String s) {
        super(context0, pushSetReq$ParamInfo0);
        this.addParam("setPushType", s);
    }

    @Override  // com.iloen.melon.net.v4x.request.PushSetReq
    public String domain() {
        return M.a;
    }

    @Override  // com.iloen.melon.net.v4x.request.PushSetReq
    public String getApiPath() {
        return "/setting/pushSetSync.json";
    }
}

