package com.iloen.melon.net.mcp.response;

import com.iloen.melon.net.v6x.response.ResponseV6Res;

public class MixupPlayResponseBase extends ResponseV6Res {
    public static class Error {
        public static class Reason {
            public String path;
            public String type;

        }

        public int code;
        public String message;
        public Reason reason;

    }

    public Error error;
    public MixUpPlayBase result;
    public boolean success;

}

