package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class ContentsInfoListRes extends ResponseV4Res {
    public static class Response extends ResponseBase {
        public static class ContentsList extends SongInfoBase {
            private static final long serialVersionUID = 0x70B003C7EBC4D559L;

        }

        @b("CONTENTSLIST")
        public ArrayList contentsList;
        private static final long serialVersionUID = 0x18349B511754F306L;

        public Response() {
            this.contentsList = null;
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x6025F52FED689BAL;

    public ContentsInfoListRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

