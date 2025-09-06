package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;

public class MyMusicFriendInsertPhoneFriendRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        @b("HASMORE")
        public boolean hasMore;
        @b("INVITEUSERID")
        public String inviteUserId;
        @b("INVTFRENDNAME")
        public String invtFrendName;
        @b("PHONENUMBER")
        public String phoneNumber;
        @b("REINVITEYN")
        public String reInviteYn;
        private static final long serialVersionUID = 0xF44893BB04BB18CAL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDA6900BD83D8314AL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

