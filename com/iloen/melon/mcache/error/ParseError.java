package com.iloen.melon.mcache.error;

public class ParseError extends ErrorBase {
    public static class AlreadyParse extends ParseError {
        public AlreadyParse(String s, String s1) {
            super(s, s1, false);
        }

        @Override  // com.iloen.melon.mcache.error.ParseError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("ParseError", this.getClass().getSimpleName());
        }
    }

    public static class NeedParse extends ParseError {
        public NeedParse(String s, String s1) {
            super(s, s1, true);
        }

        @Override  // com.iloen.melon.mcache.error.ParseError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("ParseError", this.getClass().getSimpleName());
        }
    }

    public static final String TAG = "ParseError";

    public ParseError(String s, String s1) {
        super(s, s1, true);
    }

    public ParseError(String s, String s1, boolean z) {
        super(s, s1, z);
    }

    @Override  // com.iloen.melon.mcache.error.ErrorBase
    public String getCallerTag() {
        return "ParseError";
    }
}

