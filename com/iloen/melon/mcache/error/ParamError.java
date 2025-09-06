package com.iloen.melon.mcache.error;

public class ParamError extends ErrorBase {
    public static class IllegalArgumentError extends ParamError {
        public IllegalArgumentError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.ParamError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("ParamError", this.getClass().getSimpleName());
        }
    }

    public static class IllegalStateError extends ParamError {
        public IllegalStateError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.ParamError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("ParamError", this.getClass().getSimpleName());
        }
    }

    public static class OutOfBoundsError extends ParamError {
        public OutOfBoundsError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.ParamError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("ParamError", this.getClass().getSimpleName());
        }
    }

    private static final String TAG = "ParamError";

    public ParamError(String s, String s1) {
        super(s, s1);
    }

    @Override  // com.iloen.melon.mcache.error.ErrorBase
    public String getCallerTag() {
        return "ParamError";
    }
}

