package jg;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public final class b extends Enum {
    public final int a;
    public final String b;
    public static final enum b c;
    public static final enum b d;
    public static final enum b e;
    public static final enum b f;
    public static final enum b g;
    public static final b[] h;

    static {
        b.c = new b("HTTP_INVALID", 0, 0, "Invalid");
        b b0 = new b("HTTP_CONTINUE", 1, 100, "Continue");
        b b1 = new b("HTTP_SWITCH_PROTOCOL", 2, 101, "Switching Protocols");
        b.d = new b("HTTP_OK", 3, 200, "OK");
        b b2 = new b("HTTP_CREATED", 4, 201, "Created");
        b b3 = new b("HTTP_ACCEPTED", 5, 202, "Accepted");
        b b4 = new b("HTTP_NOT_AUTHORITATIVE", 6, 203, "Non-Authoritative Information");
        b b5 = new b("HTTP_NO_CONTENT", 7, 204, "No Content");
        b b6 = new b("HTTP_RESET", 8, 205, "Reset Content");
        b b7 = new b("HTTP_PARTIAL", 9, 206, "Partial Content");
        b b8 = new b("HTTP_MULT_CHOICE", 10, 300, "Multiple Choices");
        b b9 = new b("HTTP_MOVED_PERM", 11, 301, "Moved Permanently");
        b b10 = new b("HTTP_FOUND", 12, 302, "Found");
        b b11 = new b("HTTP_SEE_OTHER", 13, 303, "See Other");
        b b12 = new b("HTTP_NOT_MODIFIED", 14, 304, "Not Modified");
        b b13 = new b("HTTP_USE_PROXY", 15, 305, "Use Proxy");
        b b14 = new b("HTTP_TEMP_REDIRECT", 16, 307, "Temporary Redirect");
        b.e = new b("HTTP_BAD_REQUEST", 17, 400, "Bad Request");
        b b15 = new b("HTTP_UNAUTHORIZED", 18, 401, "Unauthorized");
        b b16 = new b("HTTP_PAYMENT_REQUIRED", 19, 402, "Payment Required");
        b b17 = new b("HTTP_FORBIDDEN", 20, 403, "Forbidden");
        b b18 = new b("HTTP_NOT_FOUND", 21, 404, "Not Found");
        b b19 = new b("HTTP_BAD_METHOD", 22, 405, "Method Not Allowed");
        b b20 = new b("HTTP_NOT_ACCEPTABLE", 23, 406, "Not Acceptable");
        b b21 = new b("HTTP_PROXY_AUTH", 24, 407, "Proxy Authentication Required");
        b b22 = new b("HTTP_REQUEST_TIMEOUT", 25, 408, "Request Time-out");
        b b23 = new b("HTTP_CONFLICT", 26, 409, "Conflict");
        b b24 = new b("HTTP_GONE", 27, 410, "Gone");
        b b25 = new b("HTTP_LENGTH_REQUIRED", 28, 411, "Length Required");
        b.f = new b("HTTP_PRECON_FAILED", 29, 412, "Precondition Failed");
        b b26 = new b("HTTP_ENTITY_TOO_LARGE", 30, 413, "Request Entity Too Large");
        b b27 = new b("HTTP_URI_TOO_LONG", 0x1F, 414, "Request-URI Too Large");
        b b28 = new b("HTTP_UNSUPPORTED_TYPE", 0x20, 0x19F, "Unsupported Media Type");
        b b29 = new b("HTTP_RANGE_NOT_SATISFIABLE", 33, 0x1A0, "Requested range not satisfiable");
        b b30 = new b("HTTP_EXPECTATION_FAILED", 34, 417, "Expectation Failed");
        b.g = new b("HTTP_INTERNAL_ERROR", 35, 500, "Internal Server Error");
        b.h = new b[]{b.c, b0, b1, b.d, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b.e, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b.f, b26, b27, b28, b29, b30, b.g, new b("HTTP_NOT_IMPLEMENTED", 36, 501, "Not Implemented"), new b("HTTP_BAD_GATEWAY", 37, 502, "Bad Gateway"), new b("HTTP_UNAVAILABLE", 38, 503, "Service Unavailable"), new b("HTTP_GATEWAY_TIMEOUT", 39, 504, "Gateway Time-out"), new b("HTTP_VERSION", 40, 505, "HTTP Version not supported")};
    }

    public b(String s, int v, int v1, String s1) {
        super(s, v);
        this.a = v1;
        this.b = s1;
    }

    public static b valueOf(String s) {
        return (b)Enum.valueOf(b.class, s);
    }

    public static b[] values() {
        return (b[])b.h.clone();
    }
}

