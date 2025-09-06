package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.ArtistsInfoBase;

public class PhotoInfoBase extends ArtistsInfoBase {
    @b("IMAGEPATH")
    public String imagePath;
    @b("IMGSIZEFLG")
    public String imgSizeFlg;
    @b("ISSUEDATE")
    public String issueDate;
    @b("PHOTODESC")
    public String photoDesc;
    @b("PHOTOID")
    public String photoId;
    @b("PHOTOIMG")
    public String photoImg;
    @b("PHOTONAME")
    public String photoName;
    @b("REPARTISTNAME")
    public String repArtistName;
    private static final long serialVersionUID = 0x6C86B99098644338L;
    @b("SUMMCNT")
    public String summCnt;

    public PhotoInfoBase() {
        this.photoId = "";
        this.photoName = "";
        this.photoDesc = "";
        this.photoImg = "";
        this.imagePath = "";
        this.issueDate = "";
        this.summCnt = "";
        this.imgSizeFlg = "";
        this.repArtistName = "";
    }

    @Override  // com.melon.net.res.common.ArtistsInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

