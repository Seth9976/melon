package com.iloen.melon.task;

import com.android.volley.Request.Priority;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.HttpRequest;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.LogReportReq.LogLevel;
import com.iloen.melon.net.v4x.request.LogReportReq.LogParam;
import com.iloen.melon.net.v4x.request.LogReportReq.Type;
import com.iloen.melon.net.v4x.request.LogReportReq;
import com.iloen.melon.net.v4x.request.LoggingReq;
import com.iloen.melon.utils.log.LogU;

public final class ReportService {
    public static final class Reporter {
        public Type a;
        public LogLevel b;
        public String c;

        public static Reporter createReporter(Type logReportReq$Type0, LogLevel logReportReq$LogLevel0) {
            Reporter reportService$Reporter0 = new Reporter();  // 初始化器: Ljava/lang/Object;-><init>()V
            reportService$Reporter0.a = logReportReq$Type0;
            reportService$Reporter0.b = logReportReq$LogLevel0;
            return reportService$Reporter0;
        }

        public void report() {
            LogParam logReportReq$LogParam0 = new LogParam();
            logReportReq$LogParam0.type = this.a;
            logReportReq$LogParam0.logLevel = this.b;
            logReportReq$LogParam0.message = this.c;
            ReportService.sendLogging(new LogReportReq(MelonAppBase.instance.getContext(), logReportReq$LogParam0));
        }

        public Reporter setMessage(String s) {
            this.c = s;
            return this;
        }
    }

    public static final String PV_LOG_TAG = "PvLog";

    public static void sendLogging(HttpRequest httpRequest0) {
        LogU.v("ReportService", "report() " + httpRequest0);
        RequestBuilder.newInstance(httpRequest0).priority(Priority.LOW).errorListener(new ReportService.1()).request();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static void sendLogging(String s) {
        ReportService.sendLogging(new LoggingReq(MelonAppBase.instance.getContext(), s));
    }
}

