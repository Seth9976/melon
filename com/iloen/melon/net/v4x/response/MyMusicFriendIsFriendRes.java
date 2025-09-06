package com.iloen.melon.net.v4x.response;

import S7.b;
import com.melon.net.res.common.ResponseBase;

public class MyMusicFriendIsFriendRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("ISFRIEND")
        public boolean isFriend;
        private static final long serialVersionUID = 0xF8855368D4DE6C83L;

        public RESPONSE() {
            this.isFriend = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x3B87229618FDD0BCL;

}

