package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.LinkInfoBase;

public class HeaderBase extends LinkInfoBase {
    @b("ARTISTIMG")
    public String artistImg;
    @b("COUNTDOWN")
    public Long countDown;
    @b("ISLOGOONLY")
    public boolean isLogoOnly;
    @b("LOGODARKIMG")
    public String logoDarkImg;
    @b("LOGOIMGFORMAT")
    public LogoImageType logoImageType;
    @b("LOGOIMG")
    public String logoImg;
    @b("LOGOIMGALTTEXT")
    public String logoImgAltText;
    @b("SUBTITLE")
    public String subTitle;
    @b("TITLE")
    public String title;

}

