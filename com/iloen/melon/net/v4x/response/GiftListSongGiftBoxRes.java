package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.ArrayList;

public class GiftListSongGiftBoxRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class SONGLIST extends SongInfoBase {
            @b("FAILCODE")
            public String failCode;
            @b("FILETYPE")
            public String fileType;
            @b("ISGIFTALLOK")
            public boolean isGifTallOk;
            @b("PRODAMTS")
            public String prodAmts;
            @b("PRODID")
            public String prodId;
            @b("PRODSCLASCODE")
            public String prodSclasCode;
            private static final long serialVersionUID = 0x62F58266C18EF29EL;

            @Override  // com.melon.net.res.common.AlbumInfoBase
            public boolean equals(Object object0) {
                if(this == object0) {
                    return true;
                }
                if(!(object0 instanceof SONGLIST)) {
                    return false;
                }
                return super.equals(object0) ? this.songId != null && this.songId.equals(((SONGLIST)object0).songId) : false;
            }

            @Override  // com.melon.net.res.common.AlbumInfoBase
            public int hashCode() {
                int v = super.hashCode();
                return this.songId == null ? v * 0x1F : v * 0x1F + this.songId.hashCode();
            }

            @Override  // com.melon.net.res.common.SongInfoBase
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        private static final long serialVersionUID = 0x9265FFE1463C73D9L;
        @b("SONGLIST")
        public ArrayList songList;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x15DF6FDBF2E82920L;

    public GiftListSongGiftBoxRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

