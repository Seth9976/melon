package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.ResponseAdapter;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.ResponseBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProgramMoreMvRes extends ResponseV6Res implements ResponseAdapter {
    public static class Response extends ResponseBase {
        public static class EpsdList implements Serializable {
            @b("CNPCKSEQ")
            public String cnpckSeq;
            @b("EPSDNAME")
            public String epsdName;
            @b("YEAR")
            public String year;

        }

        public static class MvList extends MvInfoBase {
            @b("CONTSTYPECODE")
            public String contsTypeCode;
            @b("EPSDNO")
            public String epsdNo;
            @b("EPSDNONAME")
            public String epsdNoName;

        }

        public static class MyTypeCode implements Serializable {
            @b("MVTYPECODE")
            public String myTypeCode;
            @b("NAME")
            public String name;

        }

        public static class YearList implements Serializable {
            @b("EPSDLIST")
            public List epsdList;
            @b("YEAR")
            public String year;

        }

        @b("FILTERLIST")
        public List filterList;
        @b("HASMORE")
        public Boolean hasMore;
        @b("MVLIST")
        public List mvList;
        @b("YEARLIST")
        public List yearLists;

    }

    @b("response")
    public Response response;

    @Override  // com.iloen.melon.net.ResponseAdapter
    public Collection getItems() {
        Response programMoreMvRes$Response0 = this.response;
        return programMoreMvRes$Response0 == null ? new ArrayList() : programMoreMvRes$Response0.mvList;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public StatsElementsBase getStatsElements() {
        return null;
    }

    @Override  // com.iloen.melon.net.ResponseAdapter
    public boolean hasMore() {
        Response programMoreMvRes$Response0 = this.response;
        if(programMoreMvRes$Response0 != null) {
            return programMoreMvRes$Response0.hasMore == null ? false : programMoreMvRes$Response0.hasMore.booleanValue();
        }
        return false;
    }
}

