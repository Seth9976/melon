package com.iloen.melon.net.v4x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.BgVideoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class StreamGetSongInfoRes extends ResponseV4Res {
    public static class RESPONSE extends ResponseBase {
        public static class ContentsInfo {
            public static class AlbumImg implements Serializable {
                @b("ALBUMIMGPATH")
                public String albumImgPath;
                @b("DPORDER")
                public String dpOrder;
                private static final long serialVersionUID = 0x10C876E02C24A356L;

                public AlbumImg() {
                    this.albumImgPath = "";
                    this.dpOrder = "";
                }
            }

            public static class Artists extends ArtistsInfoBase {
                private static final long serialVersionUID = 0x15F340E6D4F4F988L;

            }

            @b("ALBUMIMGS")
            public ArrayList albumImgs;
            @b("ALBUMID")
            public String albumid;
            @b("ALBUMNAME")
            public String albumname;
            @b("ARTISTS")
            public ArrayList artists;
            @b("BGIMGS")
            public ArrayList bgImgs;
            @b("BGVIDEO")
            public BgVideoBase bgVideo;
            @b("CID")
            public String cid;
            @b("CNAME")
            public String cname;
            @b("CONTENTIMGPATH")
            public String contentimgpath;
            @b("CONTENTNOTIFICATIONIMGPATH")
            public String contentnotificationimgpath;
            @b("CONTENTSHARINGIMGPATH")
            public String contentsharingimgpath;
            @b("CONTENTTHUMBIMGPATH")
            public String contentthumbimgpath;
            @b("CTYPE")
            public String ctype;
            @b("IMPOSSCODE")
            public String impossCode;
            @b("IMPOSSDESC")
            public String impossDesc;
            @b("ISAUDIOST")
            public boolean isAudioSt;
            @b("ISFREE")
            public boolean isFree;
            @b("ISSPATIALST")
            public boolean isSpatialSt;
            @b("ISADULT")
            public boolean isadult;
            @b("ISBOOKFILE")
            public boolean isbookfile;
            @b("ISDOWNLOAD")
            public boolean isdownload;
            @b("ISMV")
            public boolean ismv;
            @b("ISSERVICE")
            public boolean isservice;
            @b("ISSUEDATE")
            public String issuedate;
            @b("LYRICFILEUPDTDATE")
            public String lyricfileupdtdate;
            @b("LYRICPATH")
            public String lyricpath;
            @b("LYRICTYPE")
            public String lyrictype;
            @b("MVTITLE")
            public String mvtitle;
            @b("PLAYTIME")
            public String playtime;
            @b("PRIVTYN")
            public String privtyn;
            @b("SONGID")
            public String songid;

            public ContentsInfo() {
                this.cid = "";
                this.ctype = "";
                this.cname = "";
                this.albumid = "";
                this.albumname = "";
                this.contentimgpath = "";
                this.contentthumbimgpath = "";
                this.contentnotificationimgpath = "";
                this.contentsharingimgpath = "";
                this.lyrictype = "";
                this.lyricpath = "";
                this.lyricfileupdtdate = "";
                this.songid = "";
                this.mvtitle = "";
                this.ismv = false;
                this.isadult = false;
                this.isservice = false;
                this.isdownload = false;
                this.issuedate = "";
                this.privtyn = "";
                this.playtime = "";
                this.isbookfile = false;
                this.isFree = false;
                this.isAudioSt = false;
                this.impossCode = "";
                this.impossDesc = "";
                this.isSpatialSt = false;
                this.bgVideo = null;
                this.bgImgs = null;
            }

            @Override
            public String toString() {
                return ToStringUtil.toStringFields(this);
            }
        }

        @b("CONTENTSINFO")
        public ArrayList contentsInfo;
        private static final long serialVersionUID = 0xC489DB18D18F3D51L;

        @Override  // com.melon.net.res.common.ResponseBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0x7C99B0D573363C66L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

