package com.iloen.melon.net.v6x.response;

import S7.b;
import com.iloen.melon.net.v4x.common.ToStringUtil;
import com.melon.net.res.common.ResponseBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.Serializable;
import java.util.List;

public class ChartReportRes extends ResponseV6Res {
    public static class Response extends ResponseBase {
        public static class CHARTBASE implements Serializable {
            public static class DATA implements Serializable {
                @b("HIGHLIGHTING")
                public boolean highlighting;
                @b("LABEL")
                public String label;
                private static final long serialVersionUID = 0x705A022D533ADE27L;
                @b("VALUE")
                public int value;
                @b("XINDEX")
                public int xIndex;

                public DATA() {
                    this.value = 0;
                    this.label = "";
                    this.xIndex = 0;
                    this.highlighting = false;
                }
            }

            public static class INFO implements Serializable {
                public static class INFODATA implements Serializable {
                    private static final long serialVersionUID = 0x8B5B0A8F98E5B8D9L;
                    @b("TEXT")
                    public String text;
                    @b("TITLE")
                    public String title;

                    public INFODATA() {
                        this.title = "";
                        this.text = "";
                    }
                }

                @b("DESC")
                public String desc;
                @b("FOOT")
                public String foot;
                @b("INFOLIST")
                public List infoList;
                private static final long serialVersionUID = 3124959083009407508L;
                @b("TITLE")
                public String title;

                public INFO() {
                    this.title = "";
                    this.desc = "";
                    this.foot = "";
                }
            }

            public static class TITLE implements Serializable {
                private static final long serialVersionUID = 0xB177A3B85A1DB07L;
                @b("TEXT")
                public String text;
                @b("VALUE")
                public String value;
                @b("VALUEPLACEHOLDER")
                public String valuePlaceholder;

                public TITLE() {
                    this.valuePlaceholder = "";
                    this.text = "";
                    this.value = "";
                }
            }

            public static class XLABEL implements Serializable {
                @b("HIGHLIGHTING")
                public boolean highlighting;
                private static final long serialVersionUID = 8276676768666778070L;
                @b("XLABEL")
                public String xLabel;

                public XLABEL() {
                    this.xLabel = "";
                }
            }

            @b("DATA")
            public List data;
            @b("INFO")
            public INFO info;
            private static final long serialVersionUID = 0x4AC3399057F171A3L;
            @b("TITLE")
            public TITLE title;
            @b("XLABELS")
            public List xLabels;
            @b("YMAXIMUM")
            public int yMaximum;
            @b("YMINIMUM")
            public int yMinimum;

            public CHARTBASE() {
                this.yMinimum = 0;
                this.yMaximum = 0;
            }
        }

        public static class FOOTBUTTON implements Serializable {
            public static class BUTTONINFO implements Serializable {
                @b("LABEL")
                public String label;
                private static final long serialVersionUID = 0xCD9F1D7FD05E23C2L;
                @b("SONGID")
                public String songId;

                public BUTTONINFO() {
                    this.songId = "";
                    this.label = "";
                }
            }

            @b("NEXTBUTTON")
            public BUTTONINFO nextButton;
            @b("PREVBUTTON")
            public BUTTONINFO prevButton;
            private static final long serialVersionUID = 0xDC2EB96184EF0205L;

        }

        public static class LISTENERCHART extends CHARTBASE {
            private static final long serialVersionUID = 0x24479A365414D6A0L;

        }

        public static class LISTENERDATA implements Serializable {
            @b("ONEDAY")
            public String oneDay;
            @b("ONEHOUR")
            public String oneHour;
            private static final long serialVersionUID = 0x2C75080F6C92B397L;

            public LISTENERDATA() {
                this.oneHour = "";
                this.oneDay = "";
            }
        }

        public static class RANKCHART extends CHARTBASE {
            @b("PREDICTEDDATA")
            public List predictedData;
            private static final long serialVersionUID = -2606332622408987830L;

        }

        public static class SONGINFO extends SongInfoBase {
            @b("CURRANK")
            public String currentRank;
            @b("PASTRANK")
            public String pastRank;
            @b("RANKGAP")
            public String rankGap;
            @b("RANKTYPE")
            public String rankType;
            private static final long serialVersionUID = 0x7F80C094F01865E7L;

            public SONGINFO() {
                this.currentRank = "";
                this.pastRank = "";
                this.rankGap = "";
                this.rankType = "";
            }
        }

        public static class YESTERCHARTINFO extends CHARTBASE {
            public static class RECORD implements Serializable {
                @b("RECORD")
                public String record;
                @b("RECORDCODE")
                public String recordCode;
                private static final long serialVersionUID = 0x5F5E08181FFA2830L;

                public RECORD() {
                    this.record = "";
                    this.recordCode = "";
                }
            }

            @b("FIRSTINFOLABEL")
            public String firstInfoLabel;
            @b("FIRSTINFOVALUE")
            public String firstInfoValue;
            @b("RECORDLIST")
            public List recordList;
            @b("SECONDINFOLABEL")
            public String secondInfoLabel;
            @b("SECONDINFOVALUE")
            public String secondInfoValue;
            private static final long serialVersionUID = 0x1B3C8B9CC9FAD7C5L;

            public YESTERCHARTINFO() {
                this.firstInfoLabel = "";
                this.firstInfoValue = "";
                this.secondInfoLabel = "";
                this.secondInfoValue = "";
            }
        }

        @b("CPLANCODE")
        public String cPlanCode;
        @b("FOOTBUTTON")
        public FOOTBUTTON footButton;
        @b("LISTENERCHART")
        public LISTENERCHART listenerChart;
        @b("LISTENERDATA")
        public LISTENERDATA listenerData;
        @b("RANKCHART")
        public RANKCHART rankChart;
        @b("RECENTTIME")
        public String recentTime;
        private static final long serialVersionUID = 1381836146090615158L;
        @b("SONGINFO")
        public SONGINFO songInfo;
        @b("YESTERCHARTINFO")
        public YESTERCHARTINFO yesterChartInfo;

        public Response() {
            this.cPlanCode = "";
            this.recentTime = "";
        }
    }

    @b("response")
    public Response response;
    private static final long serialVersionUID = 0x2DFACE324A0BE3A8L;

    public ChartReportRes() {
        this.response = null;
    }

    @Override
    public String toString() {
        return ToStringUtil.toStringFields(this);
    }
}

