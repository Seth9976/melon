package com.iloen.melon.net.mcp;

import S7.b;
import java.io.Serializable;

public class PlaylistSmartError implements Serializable {
    public static class Reason implements Serializable {
        @b("path")
        public String path;
        private static final long serialVersionUID = 0xB60DCC081FABE67FL;
        @b("type")
        public String type;

    }

    public static final int ERROR_4091 = 0xFFB;
    public static final int ERROR_4092 = 0xFFC;
    public static final int ERROR_4093 = 0xFFD;
    public static final int ERROR_5003 = 5003;
    public static final int ERROR_5031 = 5031;
    @b("code")
    public int code;
    @b("message")
    public String message;
    @b("reason")
    public Reason reason;
    private static final long serialVersionUID = 0xE80DD55DDEBB8C95L;

}

