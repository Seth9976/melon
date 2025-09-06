package com.iloen.melon.net.v4x.common;

import S7.b;
import java.io.Serializable;
import java.util.ArrayList;

public class GenreMenuListInfoBase implements Serializable {
    public static class GNRLIST implements Serializable {
        @b("GNRCODE")
        public String genreCode;
        @b("GNRNAME")
        public String genreName;
        @b("ISDTLGNR")
        public boolean isDetailGenreIncluded;
        @b("MENUCODE")
        public String menuCode;
        private static final long serialVersionUID = 0x4CEB532AF22DEA98L;

    }

    @b("GNRLIST")
    public ArrayList gnrlist;
    @b("MENUCODE")
    public String menuCode;
    @b("MENUNAME")
    public String menuName;
    private static final long serialVersionUID = 0x7B176EB4D761C031L;

    public GenreMenuListInfoBase() {
        this.gnrlist = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

