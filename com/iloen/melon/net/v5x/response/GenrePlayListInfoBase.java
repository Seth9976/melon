package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.melon.net.res.common.DjPlayListInfoBase;

public class GenrePlayListInfoBase extends DjPlayListInfoBase {
    public static class TAGLIST extends TagInfoBase {
        private static final long serialVersionUID = 0x708F232DC0ABF67DL;

    }

    @b("COMMENTCNT")
    public String commentCnt;
    @b("DSPLYORDER")
    public String dsPlyOrder;
    private static final long serialVersionUID = 0x3161244AACE1FBC0L;

}

