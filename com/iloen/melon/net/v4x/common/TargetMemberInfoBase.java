package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;

public class TargetMemberInfoBase implements Serializable {
    @b("ISDJ")
    public boolean isDj;
    @b("ISESSENTIAL")
    public boolean isEssential;
    @b("ISLABEL")
    public boolean isLabel;
    @b("ISOFFICIAL")
    public boolean isOfficial;
    @b("ISPOWERDJ")
    public boolean isPowerDj;
    @b("MEMBERDJICONTYPE")
    public String memberDjIconType;
    @b("MEMBERDJTYPE")
    public String memberDjType;
    private static final long serialVersionUID = 0x12D42A75BB42E4EFL;
    @b("TARGETBANYN")
    public String targetbanyn;
    @b("TARGETMEMBERKEY")
    public String targetmemberkey;
    @b("TARGETMEMBERSTATUS")
    public String targetmemberstatus;
    @b("TARGETNICKNAME")
    public String targetnickname;
    @b("TARGETPAGEIMG")
    public String targetpageimg;

    public TargetMemberInfoBase() {
        this.targetmemberkey = "";
        this.targetnickname = "";
        this.targetpageimg = "";
        this.targetmemberstatus = "";
        this.targetbanyn = "";
        this.memberDjIconType = "";
    }
}

