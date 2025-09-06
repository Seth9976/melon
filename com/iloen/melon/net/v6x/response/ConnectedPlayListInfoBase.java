package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.util.ArrayList;

public class ConnectedPlayListInfoBase extends ArtistPlayListInfoBase {
    @b("CONTSID")
    public String contsId;
    @b("ISMELONLOGO")
    public Boolean isMelonLogo;
    @b("MAINIMGURLS")
    public ArrayList mainImgUrls;
    @b("MAINREPLACE")
    public String mainReplace;
    @b("MAINSUBIMGURL")
    public String mainSubImgUrl;
    @b("MAINTEXT")
    public String mainText;
    @b("MAINTITLE")
    public String mainTitle;
    @b("MEMBERDJICONTYPE")
    public String memberDjIconType;
    @b("RANK")
    public String rank;
    @b("SEEDCONTSID")
    public String seedContsId;
    @b("SEEDCONTSTYPECODE")
    public String seedContsTypeCode;
    private static final long serialVersionUID = 0xE368DA2F564A6FC7L;
    @b("WRITER")
    public String writer;

    public ConnectedPlayListInfoBase() {
        this.memberDjIconType = "";
        this.contsId = "";
        this.seedContsTypeCode = "";
        this.seedContsId = "";
        this.mainTitle = "";
        this.mainReplace = "";
        this.mainText = "";
        this.mainImgUrls = null;
        this.mainSubImgUrl = "";
        this.rank = "";
        this.writer = "";
        this.isMelonLogo = Boolean.FALSE;
    }

    @Override  // com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

