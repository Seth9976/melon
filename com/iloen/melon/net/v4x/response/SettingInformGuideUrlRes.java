package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class SettingInformGuideUrlRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        @b("GUIDEURL")
        public String guideUrl;
        private static final long serialVersionUID = 0x99930BDED9A45EE9L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = -6620107074870729509L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

