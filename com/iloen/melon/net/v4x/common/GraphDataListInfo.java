package com.iloen.melon.net.v4x.common;

import S7.b;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.List;

public class GraphDataListInfo implements Serializable {
    public static class CHARTSTATIC implements Serializable {
        @b("AGE10RT")
        public String age10Rt;
        @b("AGE20RT")
        public String age20Rt;
        @b("AGE30RT")
        public String age30Rt;
        @b("AGE40RT")
        public String age40Rt;
        @b("AGE50RT")
        public String age50Rt;
        @b("AGE60RT")
        public String age60Rt;
        @b("FEMALERT")
        public String femaleRt;
        @b("IDX")
        public int idx;
        @b("MALERT")
        public String maleRt;
        private static final long serialVersionUID = 0x75BA92A28288D2FCL;
        @b("SONGID")
        public int songId;
        @b("SUMMCNT")
        public int summCnt;

    }

    public static class ENTGRAPHDATA {
        @b("RANK")
        public String rank;
        @b("X")
        public int xIndex;

        public int getRank() {
            if(this.rank != null && !this.rank.isEmpty()) {
                try {
                    return Integer.parseInt(this.rank);
                }
                catch(Exception unused_ex) {
                }
            }
            return -1;
        }
    }

    public static class GRAPHCHARTINFO extends SongInfoBase {
        @b("CURRANK")
        public String currentRank;
        @b("PASTRANK")
        public String pastRank;
        public int rank;
        @b("RANKGAP")
        public String rankGap;
        @b("RANKTYPE")
        public String rankType;
        private static final long serialVersionUID = 0x75BA92A28288D2FCL;

        public GRAPHCHARTINFO() {
            this.rank = 1;
        }
    }

    public static class GRAPHDATA extends GraphInfoBase {
        private static final long serialVersionUID = 0x75BA92A28288D2FCL;

    }

    @b("CHARTSTATIC")
    public CHARTSTATIC chartStatic;
    @b("FIRSTRANKSERIALCOUNT")
    public int firstRankSerialCount;
    @b("GRAPHCHARTINFO")
    public GRAPHCHARTINFO graphChartInfo;
    @b("GRAPHDATA")
    public List graphDataList;
    @b("GRAPHTOP7")
    public int graphTop7;
    @b("PEEKTIME")
    public String peekTime;
    @b("ENTGRAPHDATA")
    public List rankDataList;
    private static final long serialVersionUID = 0x75BA92A28288D2FCL;
    @b("SHAREVALUE")
    public String shareValue;
    @b("SONGID")
    public long songId;

    public GraphDataListInfo() {
        this.graphDataList = null;
        this.rankDataList = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

