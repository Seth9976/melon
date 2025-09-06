package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class SearchHotKeywordAndMenuListRes extends ResponseV6Res {
    public static class Contents implements Serializable {
        @b("CONTENTID")
        public String contentId;
        @b("KEYWORD")
        public String keyword;
        @b("RANKTYPE")
        public String rankType;
        @b("RANKINGGAP")
        public String rankingGap;
        @b("REPDATATYPE")
        public String repDataType;
        @b("REPDATAID")
        public String repdataId;

        public Contents() {
            this.contentId = "";
            this.keyword = "";
            this.rankingGap = "";
            this.rankType = "";
        }
    }

    public static class MenuList implements Serializable {
        @b("GENRECODE")
        public String genreCode;
        @b("LANDINGTYPE")
        public String landingType;
        @b("LANDINGURL")
        public String landingUrl;
        @b("MENUNAME")
        public String menuName;
        @b("PRIORITYYN")
        public String priorityYn;
        @b("RANGECODE")
        public String rangeCode;

        public MenuList() {
            this.menuName = "";
            this.genreCode = "";
            this.priorityYn = "";
            this.landingUrl = "";
            this.landingType = "";
            this.rangeCode = "";
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static class RESPONSE extends ResponseBase {
        public static class KeywordList implements Serializable {
            @b("CONTENTS")
            public List contents;
            @b("DATETIME")
            public String dateTime;
            @b("MENUID")
            public String menuId;

            public KeywordList() {
                this.dateTime = "";
                this.contents = null;
                this.menuId = "";
            }
        }

        @b("CURRENTHOTKEYWORDLIST")
        public KeywordList currentHotKeywordList;
        @b("MENULIST")
        public List menuList;
        private static final long serialVersionUID = 0xAA5CC6930D0EFE69L;
        @b("YESTERDAYHOTKEYWORDLIST")
        public KeywordList yesterdayHotKeywordList;

        @Override  // com.melon.net.res.common.ResponseBase
        @NotNull
        public String toString() {
            return ToStringUtil.toStringFields(this);
        }
    }

    @b("response")
    public RESPONSE response;
    private static final long serialVersionUID = 0xEC3707A07ECB695CL;

    @Override
    @NotNull
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

