package com.iloen.melon.net.v3x.comments;

public class CmtTypes {
    public static class FilterType {
        public static final int DEFAULT = 0;
        public static final int LISTENER = 2;
        public static final int MY = 1;

    }

    public static class ReportType {
        public static final String ADVERTISEMENT = "advrt";
        public static final String OTHERS = "etc";
        public static final String PAPERING = "papering";
        public static final String PORNOGRAPHY = "badthing";
        public static final String PROFANITY = "abuse";
        public static final String VIOLATION_COPYRIGHT = "copyright";

    }

    public static class SortType {
        public static final int ADCMT = 2;
        public static final int NEW = 0;
        public static int[] Normal = null;
        public static final int RECM = 1;
        public static int[] WithoutRecom;

        static {
            SortType.Normal = new int[]{0, 1, 2};
            SortType.WithoutRecom = new int[]{0, 2};
        }
    }

}

