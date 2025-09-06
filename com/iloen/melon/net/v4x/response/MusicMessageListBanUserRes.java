package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MusicMessageListBanUserRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class USERLIST implements Serializable {
            @b("ARTISTID")
            public String artistid;
            @b("DELETEYN")
            public String deleteyn;
            @b("FBNICKNAME")
            public String fbnickname;
            @b("FRENDADDORIGIN")
            public String frendaddorigin;
            @b("ISESSENTIAL")
            public boolean isEssential;
            @b("ISOFFICIAL")
            public boolean isOfficial;
            @b("ISARTIST")
            public boolean isartist;
            @b("ISDJ")
            public boolean isdj;
            @b("ISLABEL")
            public boolean islabel;
            @b("ISMYFRIEND")
            public boolean ismyfriend;
            @b("ISPOWERDJ")
            public boolean ispowerdj;
            @b("MEMBERDJICONTYPE")
            public String memberDjIconType;
            @b("MEMBERDJTYPE")
            public String memberDjType;
            @b("MEMBERKEY")
            public String memberkey;
            @b("MEMBERNICKNAME")
            public String membernickname;
            @b("MEMBERSTATUS")
            public String memberstatus;
            @b("MYPAGEIMG")
            public String mypageimg;
            private static final long serialVersionUID = 0xE50C71508759610AL;
            @b("TOTVISITCNT")
            public String totvisitcnt;
            @b("UPDTDATE")
            public String updtdate;
            @b("UPDTDATE2")
            public String updtdate2;
            @b("WITHDRAWYN")
            public String withdrawyn;

            public USERLIST() {
                this.memberkey = "";
                this.membernickname = "";
                this.mypageimg = "";
                this.isdj = false;
                this.ispowerdj = false;
                this.islabel = false;
                this.isEssential = false;
                this.withdrawyn = "";
                this.memberstatus = "";
                this.updtdate = "";
                this.updtdate2 = "";
                this.ismyfriend = false;
                this.isartist = false;
                this.artistid = "";
                this.totvisitcnt = "";
                this.fbnickname = "";
                this.frendaddorigin = "";
                this.memberDjType = "";
                this.memberDjIconType = "";
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        private static final long serialVersionUID = 0xE92FFF4D0E5978B6L;
        @b("USERLIST")
        public ArrayList userlist;

        public RESPONSE() {
            this.userlist = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = -8500662371136050852L;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE musicMessageListBanUserRes$RESPONSE0 = this.response;
        return musicMessageListBanUserRes$RESPONSE0 != null ? musicMessageListBanUserRes$RESPONSE0.userlist : null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter, com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        return this.response == null ? false : this.response.hasMore;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

