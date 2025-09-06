package com.iloen.melon.mcache.error;

public class NetworkError extends ErrorBase {
    public static class HostError extends NetworkError {
        public HostError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.NetworkError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("NetworkError", this.getClass().getSimpleName());
        }
    }

    public static class HttpError extends NetworkError {
        public HttpError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.NetworkError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("NetworkError", this.getClass().getSimpleName());
        }
    }

    public static class InterruptedError extends NetworkError {
        public InterruptedError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.NetworkError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("NetworkError", this.getClass().getSimpleName());
        }
    }

    public static class OperationStartError extends NetworkError {
        public OperationStartError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.NetworkError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("NetworkError", this.getClass().getSimpleName());
        }
    }

    public static class PortError extends NetworkError {
        public PortError(String s, String s1) {
            super(s, s1);
        }

        @Override  // com.iloen.melon.mcache.error.NetworkError
        public String getCallerTag() {
            return ErrorBase.getLogClassFormat("NetworkError", this.getClass().getSimpleName());
        }
    }

    private static final String TAG = "NetworkError";

    public NetworkError(String s, String s1) {
        super(s, s1);
    }

    @Override  // com.iloen.melon.mcache.error.ErrorBase
    public String getCallerTag() {
        return "NetworkError";
    }
}

