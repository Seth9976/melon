package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class FeedUpdateFeedBlockContentsRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        @b("BLOCKYN")
        public String blockYn;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xB30E4E0BDD04A203L;

    public FeedUpdateFeedBlockContentsRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

