package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class UpdateNickNameRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("MEMBERNICKNAME")
        public String memberNickName;
        private static final long serialVersionUID = 0x73C8FEBB217A51E4L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xF424663266A6DA80L;

    public UpdateNickNameRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

