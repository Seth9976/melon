package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.GenreInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.DjPlayListInfoBase;
import java.util.ArrayList;

public class MyMusicPlaylistInformRes extends PlaylistInformBaseRes {
    public static class RESPONSE extends DjPlayListInfoBase {
        public static class PLYLSTGENRELIST extends GenreInfoBase {
            private static final long serialVersionUID = 0x14D89251D42B6C44L;

        }

        @b("BBSCHANNELSEQ")
        public String bbsChannelSeq;
        @b("INTRODMOBILEUPDTPOSBLYN")
        public String introDMobileUpdtPosblYN;
        @b("ISLABEL")
        public boolean isLabel;
        @b("MUMSGIMG")
        public String muMsgImg;
        @b("OPENYN")
        public String openYN;
        @b("PLYLSTCNT")
        public String plylstCnt;
        @b("PLYLSTDESC")
        public String plylstDesc;
        @b("PLYLSTGENRELIST")
        public ArrayList plylstGenreList;
        @b("POSTEDITIMG")
        public String postEditImg;
        @b("POSTIMG")
        public String postImg;
        @b("REGDATE")
        public String regDate;
        private static final long serialVersionUID = 0x31D6D4DB6043974BL;
        @b("STATUS")
        public String status;
        @b("UPDTDATE")
        public String updtDate;
        @b("UPDTDATETIME")
        public String updtDateTime;

        public RESPONSE() {
            this.updtDateTime = "";
            this.plylstGenreList = null;
            this.postEditImg = "";
            this.isLabel = false;
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x79B255E5E90836ADL;

    @Override  // com.iloen.melon.net.HttpResponse
    public String getMenuId() {
        return this.response == null ? "" : this.response.menuId;
    }

    @Override  // com.iloen.melon.net.v4x.response.PlaylistInformBaseRes
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

