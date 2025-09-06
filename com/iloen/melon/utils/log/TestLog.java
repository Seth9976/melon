package com.iloen.melon.utils.log;

import U4.x;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b%\n\u0002\u0010%\n\u0002\b\u0014\b\u00C7\u0002\u0018\u00002\u00020\u0001J\u001D\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\b\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0012\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0012\u0010\u0007J\u001F\u0010\u0013\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0007J\u001F\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0014\u0010\u0007J\u001F\u0010\u0015\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0007J\r\u0010\u0016\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001A\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0019R\u0014\u0010\u001B\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001B\u0010\u0019R\u0014\u0010\u001C\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u0019R\u0014\u0010\u001D\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u0019R\u0014\u0010\u001E\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001E\u0010\u0019R\u0014\u0010\u001F\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\u001F\u0010\u0019R\u0014\u0010 \u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b \u0010\u0019R\u0014\u0010!\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b!\u0010\u0019R\u0014\u0010\"\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\"\u0010\u0019R\u0014\u0010#\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b#\u0010\u0019R\u0014\u0010$\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b$\u0010\u0019R\u0014\u0010%\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b%\u0010\u0019R\u0014\u0010&\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b&\u0010\u0019R\u0014\u0010\'\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b\'\u0010\u0019R\u0014\u0010(\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b(\u0010\u0019R\u0014\u0010)\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b)\u0010\u0019R\u0014\u0010*\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b*\u0010\u0019R\u0014\u0010+\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b+\u0010\u0019R\u0014\u0010,\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b,\u0010\u0019R\u0014\u0010-\u001A\u00020\u00028\u0006X\u0086T\u00A2\u0006\u0006\n\u0004\b-\u0010\u0019R%\u00103\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020.8\u0006\u00A2\u0006\f\n\u0004\b/\u00100\u001A\u0004\b1\u00102R%\u00106\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020.8\u0006\u00A2\u0006\f\n\u0004\b4\u00100\u001A\u0004\b5\u00102R%\u00109\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020.8\u0006\u00A2\u0006\f\n\u0004\b7\u00100\u001A\u0004\b8\u00102R%\u0010<\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020.8\u0006\u00A2\u0006\f\n\u0004\b:\u00100\u001A\u0004\b;\u00102R$\u0010A\u001A\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b=\u0010\u0019\u001A\u0004\b>\u0010?\"\u0004\b@\u0010\u0010\u00A8\u0006B"}, d2 = {"Lcom/iloen/melon/utils/log/TestLog;", "", "", "tag", "message", "Lie/H;", "log", "(Ljava/lang/String;Ljava/lang/String;)V", "", "isTestOn", "()Z", "testOn", "setTestOn", "(Z)V", "reqUrl", "setTestVolleyReqUrl", "(Ljava/lang/String;)V", "key", "logRetrofit", "logVolley", "logRetrofitBody", "logVolleyBody", "clear", "()V", "TAG", "Ljava/lang/String;", "RETROFIT", "VOLLEY", "CACHE_CONTROL", "REQUEST_URL", "REQ_CACHE_CONTROL", "USER_AGENT", "ACCEPT_CHARSET", "ACCEPT_ENCODING", "COOKIE", "REQ_URL_PARAM", "CONTENT_ENCODING", "TRANSFER_ENCODING", "ACCEPT_RANGES", "CONTENT_TYPE", "CONNECTION", "DATE", "ETAG", "RES_CACHE_CONTROL", "M_LOG", "ACCESS_CONTROL_ALLOW_CREDENTIALS", "", "b", "Ljava/util/Map;", "getRetrofitLogMap", "()Ljava/util/Map;", "retrofitLogMap", "c", "getVolleyLogMap", "volleyLogMap", "d", "getRetrofitBodyLogMap", "retrofitBodyLogMap", "e", "getVolleyBodyLogMap", "volleyBodyLogMap", "f", "getTestReqUrl", "()Ljava/lang/String;", "setTestReqUrl", "testReqUrl", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TestLog {
    public static final int $stable = 0;
    @NotNull
    public static final String ACCEPT_CHARSET = "Accept-Charset";
    @NotNull
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    @NotNull
    public static final String ACCEPT_RANGES = "Accept-Ranges";
    @NotNull
    public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
    @NotNull
    public static final String CACHE_CONTROL = "Cache-Control";
    @NotNull
    public static final String CONNECTION = "Connection";
    @NotNull
    public static final String CONTENT_ENCODING = "Content-Encoding";
    @NotNull
    public static final String CONTENT_TYPE = "Content-Type";
    @NotNull
    public static final String COOKIE = "Cookie";
    @NotNull
    public static final String DATE = "Date";
    @NotNull
    public static final String ETAG = "ETag";
    @NotNull
    public static final TestLog INSTANCE = null;
    @NotNull
    public static final String M_LOG = "M-Log";
    @NotNull
    public static final String REQUEST_URL = "RequestUrl";
    @NotNull
    public static final String REQ_CACHE_CONTROL = "Req-Cache-Control";
    @NotNull
    public static final String REQ_URL_PARAM = "REQ_URL_PARAM";
    @NotNull
    public static final String RES_CACHE_CONTROL = "Res-Cache-Control";
    @NotNull
    public static final String RETROFIT = "TEST_LOG_RETROFIT";
    @NotNull
    public static final String TAG = "TEST_LOG";
    @NotNull
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    @NotNull
    public static final String USER_AGENT = "User-Agent";
    @NotNull
    public static final String VOLLEY = "TEST_LOG_VOLLEY";
    public static boolean a;
    public static final LinkedHashMap b;
    public static final LinkedHashMap c;
    public static final LinkedHashMap d;
    public static final LinkedHashMap e;
    public static String f;
    public static String g;

    static {
        TestLog.INSTANCE = new TestLog();  // 初始化器: Ljava/lang/Object;-><init>()V
        TestLog.b = new LinkedHashMap();
        TestLog.c = new LinkedHashMap();
        TestLog.d = new LinkedHashMap();
        TestLog.e = new LinkedHashMap();
        TestLog.$stable = 8;
    }

    public final void clear() {
        TestLog.b.clear();
        TestLog.c.clear();
        TestLog.d.clear();
        TestLog.e.clear();
        TestLog.f = null;
        TestLog.g = null;
    }

    @NotNull
    public final Map getRetrofitBodyLogMap() {
        return TestLog.d;
    }

    @NotNull
    public final Map getRetrofitLogMap() {
        return TestLog.b;
    }

    @Nullable
    public final String getTestReqUrl() {
        return TestLog.f;
    }

    @NotNull
    public final Map getVolleyBodyLogMap() {
        return TestLog.e;
    }

    @NotNull
    public final Map getVolleyLogMap() {
        return TestLog.c;
    }

    // 去混淆评级： 低(20)
    public final boolean isTestOn() {
        return TestLog.a && q.b(TestLog.g, TestLog.f);
    }

    public final void log(@NotNull String s, @NotNull String s1) {
        q.g(s, "tag");
        q.g(s1, "message");
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(s);
        String s2 = x.m(stringBuilder0, ": ", s1);
        System.out.println(s2);
    }

    public final void logRetrofit(@NotNull String s, @Nullable String s1) {
        q.g(s, "key");
        TestLog.b.put(s, s1);
    }

    public final void logRetrofitBody(@NotNull String s, @Nullable String s1) {
        q.g(s, "key");
        TestLog.d.put(s, s1);
    }

    public final void logVolley(@NotNull String s, @Nullable String s1) {
        q.g(s, "key");
        TestLog.c.put(s, s1);
    }

    public final void logVolleyBody(@NotNull String s, @Nullable String s1) {
        q.g(s, "key");
        TestLog.e.put(s, s1);
    }

    public final void setTestOn(boolean z) {
        TestLog.a = z;
    }

    public final void setTestReqUrl(@Nullable String s) {
        TestLog.f = s;
    }

    public final void setTestVolleyReqUrl(@NotNull String s) {
        q.g(s, "reqUrl");
        TestLog.g = s;
    }
}

