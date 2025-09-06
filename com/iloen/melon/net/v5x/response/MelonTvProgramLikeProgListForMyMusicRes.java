package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v4x.common.TvProgramBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;

public class MelonTvProgramLikeProgListForMyMusicRes extends ResponseV5Res {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends TvProgramBase {
            public static class MVLIST extends MvInfoBase {
                private static final long serialVersionUID = 0x6868AD39230FC771L;

            }

            @b("MVLIST")
            public ArrayList mvList;
            private static final long serialVersionUID = 7511153090005091345L;

        }

        @b("CONTENTSLIST")
        public ArrayList contentsList;
        private static final long serialVersionUID = 2003230097823004423L;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x196D5D67B2405AF5L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

