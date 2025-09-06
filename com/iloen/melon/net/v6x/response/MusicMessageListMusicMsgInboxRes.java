package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.TargetMemberInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class MusicMessageListMusicMsgInboxRes extends ResponseV6Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class INBOXLIST implements Serializable {
            public static class TARGETMEMBERINFOLIST extends TargetMemberInfoBase {
                private static final long serialVersionUID = 0x8E8E8D3217EEA951L;

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("GROUPYN")
            public String groupyn;
            @b("INBOXSEQ")
            public String inboxseq;
            @b("INOUTFLG")
            public String inoutflg;
            @b("MEMBERKEY")
            public String memberkey;
            @b("MEMBERNICKNAME")
            public String membernickname;
            @b("MSGENOCONFMCNT")
            public String msgenoconfmcnt;
            @b("MYPAGEIMG")
            public String mypageimg;
            private static final long serialVersionUID = 0xFEFE49B00FA8CDA4L;
            @b("SUMMARY")
            public String summary;
            @b("TARGETMEMBERINFOLIST")
            public ArrayList targetmemberinfolist;
            @b("UPDATEDATE")
            public String updatedate;

            public INBOXLIST() {
                this.groupyn = "";
                this.inboxseq = "";
                this.inoutflg = "";
                this.memberkey = "";
                this.membernickname = "";
                this.mypageimg = "";
                this.updatedate = "";
                this.msgenoconfmcnt = "";
                this.summary = "";
                this.targetmemberinfolist = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("HASMORE")
        public boolean hasMore;
        @b("INBOXLIST")
        public ArrayList inboxlist;
        private static final long serialVersionUID = 0xAA5CC6930D0EFE69L;

        public RESPONSE() {
            this.inboxlist = null;
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
        RESPONSE musicMessageListMusicMsgInboxRes$RESPONSE0 = this.response;
        return musicMessageListMusicMsgInboxRes$RESPONSE0 != null ? musicMessageListMusicMsgInboxRes$RESPONSE0.inboxlist : null;
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

