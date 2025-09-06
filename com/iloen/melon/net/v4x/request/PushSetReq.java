package com.iloen.melon.net.v4x.request;

import A8.M;
import android.content.Context;
import com.iloen.melon.net.v4x.response.PushSetRes;
import java.io.Serializable;

public class PushSetReq extends RequestV4Req {
    public static class ParamInfo implements Serializable {
        public String appTypeCode;
        public String appVer;
        public String certificateType;
        public String deviceModelName;
        public String deviceOsVer;
        public String deviceToken;
        public String mannerModeEndTime;
        public String mannerModeStartTime;
        public String mannerModeYn;
        public String memberKey;
        public String mktRecvAgreeYn;
        public String pushNotifyYn;
        public String sendTypeCode;
        private static final long serialVersionUID = 1L;

    }

    public PushSetReq(Context context0, ParamInfo pushSetReq$ParamInfo0) {
        super(context0, 1, PushSetRes.class);
        this.addMemberKey(pushSetReq$ParamInfo0.memberKey);
        this.addParam("deviceToken", pushSetReq$ParamInfo0.deviceToken);
        this.addParam("sendTypeCode", pushSetReq$ParamInfo0.sendTypeCode);
        this.addParam("appTypeCode", pushSetReq$ParamInfo0.appTypeCode);
        this.addParam("appVer", pushSetReq$ParamInfo0.appVer);
        this.addParam("deviceOsVer", pushSetReq$ParamInfo0.deviceOsVer);
        this.addParam("deviceModelName", pushSetReq$ParamInfo0.deviceModelName);
        this.addParam("certificateType", pushSetReq$ParamInfo0.certificateType);
        this.addParam("pushNotifyYn", pushSetReq$ParamInfo0.pushNotifyYn);
        this.addParam("mannerModeYn", pushSetReq$ParamInfo0.mannerModeYn);
        this.addParam("mannerModeStartTime", pushSetReq$ParamInfo0.mannerModeStartTime);
        this.addParam("mannerModeEndTime", pushSetReq$ParamInfo0.mannerModeEndTime);
        this.addParam("mktRecvAgreeYn", pushSetReq$ParamInfo0.mktRecvAgreeYn);
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return M.a;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        return "/setting/pushSet.json";
    }
}

