package com.iloen.melon.mcache.error;

public class StreamIOError extends ErrorBase {
    public static class CloseError extends StreamIOError {
        public CloseError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.StreamIOError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StreamIOError", this.getClass().getSimpleName());
        }
    }

    public static class NoStreamError extends StreamIOError {
        public NoStreamError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.StreamIOError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StreamIOError", this.getClass().getSimpleName());
        }
    }

    public static class OpenError extends StreamIOError {
        public OpenError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.StreamIOError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StreamIOError", this.getClass().getSimpleName());
        }
    }

    public static class ReadError extends StreamIOError {
        public ReadError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.StreamIOError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StreamIOError", this.getClass().getSimpleName());
        }
    }

    public static class WriteError extends StreamIOError {
        public WriteError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.StreamIOError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("StreamIOError", this.getClass().getSimpleName());
        }
    }

    public static final String TAG = "StreamIOError";

    public StreamIOError(String s, String s1) {
        super(s, s1);
    }

    @Override  // com.iloen.melon.mcache.error.ErrorBase
    public String getCallerTag() {
        return "StreamIOError";
    }
}

