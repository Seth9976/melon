package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.List;

public class ForuPlayRes extends ResponseV6Res {
    public static class RESPONSE extends ResponseBase {
        public static class FORUSONG extends SongInfoBase {
            private static final long serialVersionUID = 0xA6BCA5C7C9857F07L;

        }

        private static final long serialVersionUID = 0xBFAD492BE9318EDCL;
        @b("LIST")
        public List songList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -7030019658111266305L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

