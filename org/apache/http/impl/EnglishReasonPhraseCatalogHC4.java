package org.apache.http.impl;

import java.util.Locale;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.annotation.Immutable;
import org.apache.http.util.Args;

@Immutable
public class EnglishReasonPhraseCatalogHC4 implements ReasonPhraseCatalog {
    public static final EnglishReasonPhraseCatalogHC4 INSTANCE;
    private static final String[][] REASON_PHRASES;

    static {
        EnglishReasonPhraseCatalogHC4.INSTANCE = new EnglishReasonPhraseCatalogHC4();
        EnglishReasonPhraseCatalogHC4.REASON_PHRASES = new String[][]{0, new String[3], new String[8], new String[8], new String[25], new String[8]};
        EnglishReasonPhraseCatalogHC4.setReason(200, "OK");
        EnglishReasonPhraseCatalogHC4.setReason(201, "Created");
        EnglishReasonPhraseCatalogHC4.setReason(202, "Accepted");
        EnglishReasonPhraseCatalogHC4.setReason(204, "No Content");
        EnglishReasonPhraseCatalogHC4.setReason(301, "Moved Permanently");
        EnglishReasonPhraseCatalogHC4.setReason(302, "Moved Temporarily");
        EnglishReasonPhraseCatalogHC4.setReason(304, "Not Modified");
        EnglishReasonPhraseCatalogHC4.setReason(400, "Bad Request");
        EnglishReasonPhraseCatalogHC4.setReason(401, "Unauthorized");
        EnglishReasonPhraseCatalogHC4.setReason(403, "Forbidden");
        EnglishReasonPhraseCatalogHC4.setReason(404, "Not Found");
        EnglishReasonPhraseCatalogHC4.setReason(500, "Internal Server Error");
        EnglishReasonPhraseCatalogHC4.setReason(501, "Not Implemented");
        EnglishReasonPhraseCatalogHC4.setReason(502, "Bad Gateway");
        EnglishReasonPhraseCatalogHC4.setReason(503, "Service Unavailable");
        EnglishReasonPhraseCatalogHC4.setReason(100, "Continue");
        EnglishReasonPhraseCatalogHC4.setReason(307, "Temporary Redirect");
        EnglishReasonPhraseCatalogHC4.setReason(405, "Method Not Allowed");
        EnglishReasonPhraseCatalogHC4.setReason(409, "Conflict");
        EnglishReasonPhraseCatalogHC4.setReason(412, "Precondition Failed");
        EnglishReasonPhraseCatalogHC4.setReason(413, "Request Too Long");
        EnglishReasonPhraseCatalogHC4.setReason(414, "Request-URI Too Long");
        EnglishReasonPhraseCatalogHC4.setReason(0x19F, "Unsupported Media Type");
        EnglishReasonPhraseCatalogHC4.setReason(300, "Multiple Choices");
        EnglishReasonPhraseCatalogHC4.setReason(303, "See Other");
        EnglishReasonPhraseCatalogHC4.setReason(305, "Use Proxy");
        EnglishReasonPhraseCatalogHC4.setReason(402, "Payment Required");
        EnglishReasonPhraseCatalogHC4.setReason(406, "Not Acceptable");
        EnglishReasonPhraseCatalogHC4.setReason(407, "Proxy Authentication Required");
        EnglishReasonPhraseCatalogHC4.setReason(408, "Request Timeout");
        EnglishReasonPhraseCatalogHC4.setReason(101, "Switching Protocols");
        EnglishReasonPhraseCatalogHC4.setReason(203, "Non Authoritative Information");
        EnglishReasonPhraseCatalogHC4.setReason(205, "Reset Content");
        EnglishReasonPhraseCatalogHC4.setReason(206, "Partial Content");
        EnglishReasonPhraseCatalogHC4.setReason(504, "Gateway Timeout");
        EnglishReasonPhraseCatalogHC4.setReason(505, "Http Version Not Supported");
        EnglishReasonPhraseCatalogHC4.setReason(410, "Gone");
        EnglishReasonPhraseCatalogHC4.setReason(411, "Length Required");
        EnglishReasonPhraseCatalogHC4.setReason(0x1A0, "Requested Range Not Satisfiable");
        EnglishReasonPhraseCatalogHC4.setReason(417, "Expectation Failed");
        EnglishReasonPhraseCatalogHC4.setReason(102, "Processing");
        EnglishReasonPhraseCatalogHC4.setReason(0xCF, "Multi-Status");
        EnglishReasonPhraseCatalogHC4.setReason(422, "Unprocessable Entity");
        EnglishReasonPhraseCatalogHC4.setReason(419, "Insufficient Space On Resource");
        EnglishReasonPhraseCatalogHC4.setReason(420, "Method Failure");
        EnglishReasonPhraseCatalogHC4.setReason(423, "Locked");
        EnglishReasonPhraseCatalogHC4.setReason(507, "Insufficient Storage");
        EnglishReasonPhraseCatalogHC4.setReason(424, "Failed Dependency");
    }

    @Override  // org.apache.http.ReasonPhraseCatalog
    public String getReason(int v, Locale locale0) {
        Args.check(v >= 100 && v < 600, "Unknown category for status code " + v);
        int v1 = v - v / 100 * 100;
        String[] arr_s = EnglishReasonPhraseCatalogHC4.REASON_PHRASES[v / 100];
        return arr_s.length <= v1 ? null : arr_s[v1];
    }

    private static void setReason(int v, String s) {
        EnglishReasonPhraseCatalogHC4.REASON_PHRASES[v / 100][v - v / 100 * 100] = s;
    }
}

