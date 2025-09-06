package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v4x.common.ContentListInfo;
import com.iloen.melon.net.v4x.common.TargetMemberInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.ResponseBase;
import java.util.ArrayList;
import java.util.Collection;

public class MusicMessageListMusicMsgInboxContentsRes extends ResponseV4Res implements ResponseAdapter {
    public static class RESPONSE extends ResponseBase {
        public static class CONTENTSLIST extends ContentListInfo {
            public static class TARGETMEMBERINFOLIST extends TargetMemberInfoBase {
                private static final long serialVersionUID = 0x772990F845F85F19L;

                @Override
                public String toString() {
                    return ToStringUtil.toStringFields(this);
                }
            }

            @b("CONTENT")
            public String content;
            @b("GROUPYN")
            public String groupyn;
            @b("MEMBERKEY")
            public String memberkey;
            @b("MEMBERNICKNAME")
            public String membernickname;
            @b("MUSICMESGSEQ")
            public String musicmesgseq;
            @b("MYPAGEIMG")
            public String mypageimg;
            @b("OLDDATAYN")
            public String olddatayn;
            @b("PRIVATEYN")
            public String privateyn;
            @b("REGDATE")
            public String regdate;
            @b("REGDATEFORMAT")
            public String regdateformat;
            private static final long serialVersionUID = 0xE019DACF8FDE26BBL;
            @b("TARGETMEMBERINFOLIST")
            public ArrayList targetmemberinfolist;
            @b("TIMESTAMP")
            public String timestamp;
            @b("TRNSMTYE")
            public String trnsmtye;
            @b("UPDATETIME")
            public String updatetime;

            public CONTENTSLIST() {
                this.trnsmtye = "";
                this.memberkey = "";
                this.membernickname = "";
                this.mypageimg = "";
                this.groupyn = "";
                this.olddatayn = "";
                this.musicmesgseq = "";
                this.timestamp = "";
                this.updatetime = "";
                this.regdate = "";
                this.regdateformat = "";
                this.content = "";
                this.privateyn = "";
                this.targetmemberinfolist = null;
            }

            @Override  // com.melon.net.res.common.MvInfoBase
            public boolean equals(Object object0) {
                if(this == object0) {
                    return true;
                }
                if(!super.equals(object0)) {
                    return false;
                }
                if(this.getClass() != object0.getClass()) {
                    return false;
                }
                return this.timestamp == null ? ((CONTENTSLIST)object0).timestamp == null : this.timestamp.equals(((CONTENTSLIST)object0).timestamp);
            }

            @Override  // com.melon.net.res.common.MvInfoBase
            public int hashCode() {
                int v = super.hashCode();
                return this.timestamp == null ? v * 0x1F : v * 0x1F + this.timestamp.hashCode();
            }

            @Override  // com.iloen.melon.net.v4x.common.ContentListInfo
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        public static class com.iloen.melon.net.v4x.response.MusicMessageListMusicMsgInboxContentsRes.RESPONSE.TARGETMEMBERINFOLIST extends TargetMemberInfoBase {
            private static final long serialVersionUID = 0x6063349E41B338B3L;

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("CONTENTSLIST")
        public ArrayList contentslist;
        @b("HASMORE")
        public boolean hasMore;
        @b("NEXTTIMESTAMP")
        public String nexttimestamp;
        private static final long serialVersionUID = 881990218577181043L;
        @b("TARGETMEMBERINFOLIST")
        public ArrayList targetmemberinfolist;

        public RESPONSE() {
            this.nexttimestamp = "";
            this.contentslist = null;
            this.targetmemberinfolist = null;
        }

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x717C918A585241CDL;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        RESPONSE musicMessageListMusicMsgInboxContentsRes$RESPONSE0 = this.response;
        return musicMessageListMusicMsgInboxContentsRes$RESPONSE0 != null ? musicMessageListMusicMsgInboxContentsRes$RESPONSE0.contentslist : null;
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

