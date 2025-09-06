package com.iloen.melon.net.v4x.common;

import S7.b;

public class UserInfoBase {
    @b("ARTISTID")
    public String artistid;
    @b("DELETEYN")
    public String deleteyn;
    @b("FBIMAGEURL")
    public String fbimageurl;
    @b("FBNICKNAME")
    public String fbnickname;
    @b("FRENDADDORIGIN")
    public String frendaddorigin;
    @b("GNRNAME")
    public String gnrname;
    @b("ISESSENTIAL")
    public boolean isEssential;
    @b("ISLABEL")
    public boolean isLabel;
    @b("ISOFFICIAL")
    public boolean isOfficial;
    @b("ISARTIST")
    public boolean isartist;
    @b("ISDJ")
    public boolean isdj;
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
    @b("MENUID")
    public String menuid;
    @b("MYPAGEDESC")
    public String myPageDesc;
    @b("MYPAGEIMG")
    public String mypageimg;
    @b("NEWADDFRIENDYN")
    public String newaddfriendyn;
    @b("PHONEIMG")
    public String phoneimg;
    @b("PHONENAME")
    public String phonename;
    @b("PHONENUMBER")
    public String phonenumber;
    @b("PLAYLISTCNT")
    public String playlistcnt;
    @b("PROFILESONGARTISTNAME")
    public String profilesongartistname;
    @b("PROFILESONGID")
    public String profilesongid;
    @b("PROFILESONGNAME")
    public String profilesongname;
    @b("RECENTACTFLG")
    public String recentactflg;
    @b("TOTVISITCNT")
    public String totvisitcnt;
    @b("WITHDRAWYN")
    public String withdrawyn;

    public UserInfoBase() {
        this.memberkey = "";
        this.membernickname = "";
        this.memberstatus = "";
        this.fbnickname = "";
        this.mypageimg = "";
        this.fbimageurl = "";
        this.frendaddorigin = "";
        this.playlistcnt = "";
        this.gnrname = "";
        this.profilesongname = "";
        this.profilesongid = "";
        this.profilesongartistname = "";
        this.menuid = "";
        this.deleteyn = "";
        this.isdj = false;
        this.isartist = false;
        this.artistid = "";
        this.ismyfriend = false;
        this.phonenumber = "";
        this.recentactflg = "";
        this.withdrawyn = "";
        this.ispowerdj = false;
        this.isLabel = false;
        this.totvisitcnt = "";
        this.newaddfriendyn = "";
        this.phonename = "";
        this.phoneimg = "";
        this.memberDjType = "";
        this.memberDjIconType = "";
        this.myPageDesc = "";
        this.isOfficial = false;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

