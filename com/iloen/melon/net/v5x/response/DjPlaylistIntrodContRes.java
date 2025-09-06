package com.iloen.melon.net.v5x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;

public class DjPlaylistIntrodContRes extends ResponseV5Res {
    public static class HISTLIST implements Serializable {
        @b("HISTCONT")
        public String histCont;
        @b("HISTTYPECODE")
        public String histTypeCode;
        @b("OWNERTYPECODE")
        public String ownerTypeCode;
        @b("REGDATE")
        public String regDate;
        private static final long serialVersionUID = 0x667F272434C7B6C1L;

    }

    public static class INTRODLIST implements Serializable {
        @b("DSPLYORDER")
        public String dsplyOrder;
        @b("INTRODCONT")
        public String introdCont;
        @b("INTRODTYPECODE")
        public String introdTypeCode;
        private static final long serialVersionUID = -1272209309000253033L;

    }

    public static class PLYLSTINFO implements Serializable {
        @b("DAYOFWEEKNAME")
        public String dayOfWeekName;
        @b("ISREGULARPLYLST")
        public boolean isRegularPlayList;
        @b("PLAYTIME")
        public String playTime;
        private static final long serialVersionUID = 0xAF1F42E3E70FC03CL;
        @b("SONGCNT")
        public String songCount;
        @b("UPDTDATE")
        public String updateDate;

    }

    public static class RESPONSE extends ResponseBase {
        @b("HISTLIST")
        public ArrayList histList;
        @b("INTRODLIST")
        public ArrayList introdList;
        @b("PLYLSTINFO")
        public PLYLSTINFO playlistInfo;
        @b("PLYLSTTITLE")
        public String plylstTitle;
        private static final long serialVersionUID = -6080944805533543461L;
        @b("TAGLIST")
        public ArrayList tagList;

    }

    public static class TAGLIST extends TagInfoBase {
        private static final long serialVersionUID = 0xAF1F42E3E70FC03CL;

    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xDE20D69478D65986L;

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

