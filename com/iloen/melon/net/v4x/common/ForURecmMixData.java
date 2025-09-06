package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.ArrayList;

public class ForURecmMixData implements Serializable {
    public static class SONGLIST extends SongInfoBase {
        @b("CONTSTYPECODE")
        public String contsTypeCode;
        private static final long serialVersionUID = 0xE03EA1B81FB0B1FAL;

        @Override  // com.melon.net.res.common.SongInfoBase
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("IMPRESSIONID")
    public String impressionId;
    @b("ISNEW")
    public boolean isNew;
    @b("MEMBERNICKNAME")
    public String memberNickName;
    @b("ORDERNUM")
    public int orderNum;
    private static final long serialVersionUID = 0xF9706F2768D991DAL;
    @b("SONGLIST")
    public ArrayList songList;
    @b("SUBTITLE")
    public String subTitle;
    @b("TAGNAME")
    public String tagName;
    @b("TEXT")
    public String text;
    @b("TITLE")
    public String title;
    @b("WEEKLYORDER")
    public String weeklyOrder;

    public ForURecmMixData() {
        this.orderNum = -1;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

