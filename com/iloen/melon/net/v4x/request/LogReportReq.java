package com.iloen.melon.net.v4x.request;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.HttpResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LogReportReq extends HttpRequest {
    public static enum LogLevel {
        VERBOSE("V"),
        INFO("I"),
        WARN("W"),
        ERROR("E");

        private String level;

        private static LogLevel[] $values() [...] // Inlined contents

        private LogLevel(String s1) {
            this.level = s1;
        }

        public String level() {
            return this.level;
        }
    }

    public static final class LogParam {
        public LogLevel logLevel;
        public String message;
        public Type type;

    }

    public static enum Type {
        PLAYER("PLY"),
        MCACHE("MCH"),
        DRM("DRM"),
        DOWNLOAD("DWN"),
        CRASH("CRS"),
        INFLOW("INFLOW"),
        SERVICE("SVC"),
        PREMIUM_DOWNLOAD("PDWN"),
        APP("APP"),
        REMOTE("RMT"),
        PLYMIG("PLYMIG"),
        LOGIN("LOGIN"),
        PLAYLIST("PLST"),
        HTTP("HTTP"),
        PTRACE("PTRACE");

        private String typeName;

        private static Type[] $values() [...] // Inlined contents

        private Type(String s1) {
            this.typeName = s1;
        }

        public String typeName() {
            return this.typeName;
        }
    }

    private static final String LOG_DOMAIN = null;
    private static final int MAX_MESSAGE_LENGTH = 4000;
    private LogParam param;

    static {
        LogReportReq.LOG_DOMAIN = "null/app?";
    }

    public LogReportReq(Context context0, LogParam logReportReq$LogParam0) {
        super(context0, 0, HttpResponse.class, false);
        this.param = logReportReq$LogParam0;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String domain() {
        return LogReportReq.LOG_DOMAIN;
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public String getApiPath() {
        StringBuilder stringBuilder0 = new StringBuilder("t=");
        stringBuilder0.append(this.param.type.typeName());
        stringBuilder0.append("&l=");
        stringBuilder0.append(this.param.logLevel.level());
        String s = this.param.message;
        s = TextUtils.isEmpty(s) || s.length() < 4000 ? this.param.message : s.substring(0, 4000);
        try {
            stringBuilder0.append("&m=");
            stringBuilder0.append(URLEncoder.encode(s, "utf-8"));
        }
        catch(UnsupportedEncodingException unused_ex) {
        }
        return stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.net.HttpRequest
    public boolean shouldCache() {
        return false;
    }
}

