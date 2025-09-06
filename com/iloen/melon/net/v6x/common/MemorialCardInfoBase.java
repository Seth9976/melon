package com.iloen.melon.net.v6x.common;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class MemorialCardInfoBase implements Serializable {
    @b("ALBUMIMG")
    public String albumImg;
    @b("ARTISTIMG")
    public String artistImg;
    @b("ARTISTNAME")
    public String artistName;
    @b("BGIMG")
    public String bgImg;
    @b("DATE")
    public String date;
    @b("DAYS")
    public String days;
    @b("MYSTREAMINGCNT")
    public String myStreamingCnt;
    private static final long serialVersionUID = 0xAB0A7DDCC52C212DL;
    @b("SONGID")
    public String songId;
    @b("SONGNAME")
    public String songName;
    @b("STREAMCNT")
    public String streamCnt;
    @b("STREAMINGCNT")
    public String streamingCnt;
    @b("STREAMINGUSERCNT")
    public String streamingUserCnt;
    @b("USERMAXTEMPER")
    public String userMaxTemper;
    @b("YEARS")
    public String years;

    public MemorialCardInfoBase() {
        this.artistName = "";
        this.date = "";
        this.years = "";
        this.days = "";
        this.songId = "";
        this.songName = "";
        this.albumImg = "";
        this.artistImg = "";
        this.streamCnt = "";
        this.streamingCnt = "";
        this.streamingUserCnt = "";
        this.myStreamingCnt = "";
        this.userMaxTemper = "";
        this.bgImg = "";
    }

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

