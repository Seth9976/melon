package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;

public class PushSetMannerModeSyncReq extends PushSetReq {
    public PushSetMannerModeSyncReq(Context context0, ParamInfo pushSetReq$ParamInfo0) {
        super(context0, pushSetReq$ParamInfo0);
    }

    @Override  // com.iloen.melon.net.v4x.request.PushSetReq
    public String domain() {
        return M.a;
    }

    @Override  // com.iloen.melon.net.v4x.request.PushSetReq
    public String getApiPath() {
        return "/setting/mannerModeSetSync.json";
    }
}

