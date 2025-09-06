package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class MyMusicFriendListInviteUserRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class USERLIST implements Serializable {
            @b("FRENDADDORIGIN")
            public String frendAddOrigin;
            @b("INVTFRENDNAME")
            public String invtFrendName;
            @b("MEMBERKEY")
            public String memberKey;
            @b("PHONENUMBER")
            public String phoneNumber;
            private static final long serialVersionUID = 0x948742F74ABDE1ABL;
            @b("UPDTDATE")
            public String updtDate;

        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xF44893BB04BB18CAL;
        @b("USERLIST")
        public ArrayList userList;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDA6900BD83D8314AL;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

