package com.melon.net;

import Rd.b;
import Tf.v;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.OkHttpCache;
import com.iloen.melon.player.playlist.common.h;
import com.iloen.melon.utils.FlipperManager;
import com.iloen.melon.utils.log.MelonRetrofitLogger;
import com.iloen.melon.utils.log.TestLog;
import com.iloen.melon.utils.network.CookieHelper;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.m;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.CacheControl.Builder;
import okhttp3.CacheControl;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor.Chain;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import tg.u;
import we.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0005\'()*+B\'\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\u0014\b\u0002\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ1\u0010\u0012\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J3\u0010\u0018\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\u0006\u0010\u0011\u001A\u00020\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001C\u001A\u00020\u001B2\b\u0010\u0017\u001A\u0004\u0018\u00010\u001AH\u0002¢\u0006\u0004\b\u001C\u0010\u001DR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001ER \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001FR\"\u0010!\u001A\u00020 8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/melon/net/ApiClient;", "", "Lcom/melon/net/Timeout;", "timeout", "Lkotlin/Function1;", "Lokhttp3/OkHttpClient$Builder;", "Lie/H;", "buildBlock", "<init>", "(Lcom/melon/net/Timeout;Lwe/k;)V", "Lokhttp3/HttpUrl;", "url", "", "method", "Lcom/melon/net/Api;", "apiAnnotation", "", "useAppVersion", "handleUrlParam", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lcom/melon/net/Api;Z)Lokhttp3/HttpUrl;", "Lokhttp3/Request$Builder;", "builder", "Lokhttp3/RequestBody;", "requestBody", "handlePostParam", "(Lokhttp3/Request$Builder;Lokhttp3/RequestBody;Lcom/melon/net/Api;Z)Lokhttp3/Request$Builder;", "Lokhttp3/FormBody;", "Lokhttp3/FormBody$Builder;", "convertToFormBody", "(Lokhttp3/FormBody;)Lokhttp3/FormBody$Builder;", "Lcom/melon/net/Timeout;", "Lwe/k;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "setClient", "(Lokhttp3/OkHttpClient;)V", "Companion", "HeaderInterceptor", "ConnectivityInterceptor", "ParamInterceptor", "ResponseInterceptor", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ApiClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/melon/net/ApiClient$Companion;", "", "<init>", "()V", "TAG", "", "HEADER_CACHE_CONTROL", "HEADER_USER_AGENT", "HEADER_ACCEPT_CHARSET", "HEADER_ACCEPT_ENCODING", "ENCODING_GZIP", "PARAM_KEY_CPID", "PARAM_KEY_CPKEY", "PARAM_KEY_CPID_UNDER_BAR", "PARAM_KEY_CPKEY_UNDER_BAR", "PARAM_RESOLUTION", "PARAM_SERVER_VERSION", "SET_COOKIE", "HEADER_COOKIE", "METHOD_POST", "METHOD_GET", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/melon/net/ApiClient$ConnectivityInterceptor;", "Lokhttp3/Interceptor;", "<init>", "(Lcom/melon/net/ApiClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ConnectivityInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        @NotNull
        public Response intercept(@NotNull Chain interceptor$Chain0) {
            q.g(interceptor$Chain0, "chain");
            if(!NetUtils.isConnected()) {
                throw new IOException("No internet connection");
            }
            return interceptor$Chain0.proceed(interceptor$Chain0.request());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/melon/net/ApiClient$HeaderInterceptor;", "Lokhttp3/Interceptor;", "<init>", "(Lcom/melon/net/ApiClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class HeaderInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        @NotNull
        public Response intercept(@NotNull Chain interceptor$Chain0) {
            q.g(interceptor$Chain0, "chain");
            CacheControl cacheControl0 = new Builder().maxAge(0, TimeUnit.SECONDS).build();
            CacheControl cacheControl1 = new Builder().noCache().build();
            u u0 = (u)interceptor$Chain0.request().tag(u.class);
            Boolean boolean0 = null;
            Api api0 = u0 == null ? null : ((Api)u0.c.getAnnotation(Api.class));
            if(api0 != null) {
                boolean0 = Boolean.valueOf(api0.useCache());
            }
            if(q.b(boolean0, Boolean.FALSE)) {
                cacheControl0 = cacheControl1;
            }
            okhttp3.Request.Builder request$Builder0 = interceptor$Chain0.request().newBuilder();
            request$Builder0.removeHeader("Cache-Control");
            request$Builder0.cacheControl(cacheControl0);
            MelonAppBase.Companion.getClass();
            request$Builder0.header("User-Agent", t.a().getMelonProtocolUserAgent());
            q.f("UTF-8", "toString(...)");
            request$Builder0.header("Accept-Charset", "UTF-8");
            request$Builder0.header("Accept-Encoding", "gzip,deflate");
            String s = CookieHelper.getInstance().getCookie();
            q.f(s, "getCookie(...)");
            request$Builder0.addHeader("Cookie", s);
            TestLog testLog0 = TestLog.INSTANCE;
            if(testLog0.isTestOn()) {
                testLog0.logRetrofit("RequestUrl", request$Builder0.build().url().toString());
                for(Object object0: request$Builder0.build().headers()) {
                    TestLog.INSTANCE.logRetrofit(((String)((m)object0).a), ((String)((m)object0).b));
                }
            }
            return interceptor$Chain0.proceed(request$Builder0.build());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/melon/net/ApiClient$ParamInterceptor;", "Lokhttp3/Interceptor;", "<init>", "(Lcom/melon/net/ApiClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ParamInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        @NotNull
        public Response intercept(@NotNull Chain interceptor$Chain0) {
            Api api0;
            q.g(interceptor$Chain0, "chain");
            Request request0 = interceptor$Chain0.request();
            okhttp3.Request.Builder request$Builder0 = request0.newBuilder();
            u u0 = (u)request0.tag(u.class);
            if(u0 == null) {
                api0 = null;
            }
            else {
                Method method0 = u0.c;
                api0 = method0 == null ? null : ((Api)method0.getAnnotation(Api.class));
            }
            boolean z = api0 == null ? false : api0.useAppVersion();
            request$Builder0.url(ApiClient.this.handleUrlParam(request0.url(), request0.method(), api0, z));
            Request request1 = ApiClient.this.handlePostParam(request$Builder0, request0.body(), api0, z).build();
            TestLog testLog0 = TestLog.INSTANCE;
            if(testLog0.isTestOn()) {
                testLog0.logRetrofit("REQ_URL_PARAM", request1.url().query());
            }
            return interceptor$Chain0.proceed(request1);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/melon/net/ApiClient$ResponseInterceptor;", "Lokhttp3/Interceptor;", "<init>", "(Lcom/melon/net/ApiClient;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ResponseInterceptor implements Interceptor {
        @Override  // okhttp3.Interceptor
        @NotNull
        public Response intercept(@NotNull Chain interceptor$Chain0) {
            q.g(interceptor$Chain0, "chain");
            Response response0 = interceptor$Chain0.proceed(interceptor$Chain0.request());
            if(TestLog.INSTANCE.isTestOn()) {
                for(Object object0: response0.headers()) {
                    String s = (String)((m)object0).a;
                    String s1 = (String)((m)object0).b;
                    if(v.j0(s, "Cache-Control", true)) {
                        s = "Res-Cache-Control";
                    }
                    TestLog.INSTANCE.logRetrofit(s, s1);
                }
            }
            ArrayList arrayList0 = new ArrayList();
            for(Object object1: response0.headers()) {
                if(v.j0(((String)((m)object1).a), "set-cookie", true)) {
                    arrayList0.add(object1);
                }
            }
            ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
            for(Object object2: arrayList0) {
                arrayList1.add(((String)((m)object2).b));
            }
            CookieHelper.getInstance().setCookies(((String[])arrayList1.toArray(new String[0])));
            return response0;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[ApiType.values().length];
            try {
                arr_v[ApiType.EMPTY.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V4.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V4_1.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V4_2.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.MEMBER.ordinal()] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V5.ordinal()] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V5_1.ordinal()] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V5_2.ordinal()] = 8;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V5_5.ordinal()] = 9;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6.ordinal()] = 10;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_1.ordinal()] = 11;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_2.ordinal()] = 12;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_3.ordinal()] = 13;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_6.ordinal()] = 14;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_7.ordinal()] = 15;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_8.ordinal()] = 16;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_9.ordinal()] = 17;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[ApiType.V6_10.ordinal()] = 18;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String ENCODING_GZIP = "gzip,deflate";
    @NotNull
    private static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    @NotNull
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    @NotNull
    private static final String HEADER_CACHE_CONTROL = "Cache-Control";
    @NotNull
    private static final String HEADER_COOKIE = "Cookie";
    @NotNull
    private static final String HEADER_USER_AGENT = "User-Agent";
    @NotNull
    private static final String METHOD_GET = "GET";
    @NotNull
    private static final String METHOD_POST = "POST";
    @NotNull
    private static final String PARAM_KEY_CPID = "cpId";
    @NotNull
    private static final String PARAM_KEY_CPID_UNDER_BAR = "_cpId";
    @NotNull
    private static final String PARAM_KEY_CPKEY = "cpKey";
    @NotNull
    private static final String PARAM_KEY_CPKEY_UNDER_BAR = "_cpKey";
    @NotNull
    private static final String PARAM_RESOLUTION = "resolution";
    @NotNull
    private static final String PARAM_SERVER_VERSION = "v";
    @NotNull
    private static final String SET_COOKIE = "set-cookie";
    @NotNull
    private static final String TAG = "ApiClient";
    @NotNull
    private final k buildBlock;
    @NotNull
    private OkHttpClient client;
    @NotNull
    private final Timeout timeout;

    static {
        ApiClient.Companion = new Companion(null);
        ApiClient.$stable = 8;
    }

    public ApiClient() {
        this(null, null, 3, null);
    }

    public ApiClient(@NotNull Timeout timeout0, @NotNull k k0) {
        q.g(timeout0, "timeout");
        q.g(k0, "buildBlock");
        super();
        this.timeout = timeout0;
        this.buildBlock = k0;
        okhttp3.OkHttpClient.Builder okHttpClient$Builder0 = new OkHttpClient().newBuilder();
        k0.invoke(okHttpClient$Builder0);
        okHttpClient$Builder0.followRedirects(true);
        okHttpClient$Builder0.followSslRedirects(true);
        if(timeout0.getConnectMs() > 0L) {
            okHttpClient$Builder0.connectTimeout(timeout0.getConnectMs(), TimeUnit.MILLISECONDS);
        }
        if(timeout0.getWriteMs() > 0L) {
            okHttpClient$Builder0.writeTimeout(timeout0.getWriteMs(), TimeUnit.MILLISECONDS);
        }
        if(timeout0.getReadMs() > 0L) {
            okHttpClient$Builder0.readTimeout(timeout0.getReadMs(), TimeUnit.MILLISECONDS);
        }
        if(timeout0.getCallMs() > 0L) {
            okHttpClient$Builder0.callTimeout(timeout0.getCallMs(), TimeUnit.MILLISECONDS);
        }
        okHttpClient$Builder0.cache(OkHttpCache.INSTANCE.getCache());
        okHttpClient$Builder0.addInterceptor(new b());  // 初始化器: Ljava/lang/Object;-><init>()V
        okHttpClient$Builder0.addInterceptor(new ConnectivityInterceptor(this));
        okHttpClient$Builder0.addInterceptor(new ParamInterceptor(this));
        okHttpClient$Builder0.addInterceptor(new HttpLoggingInterceptor(MelonRetrofitLogger.INSTANCE));
        okHttpClient$Builder0.addNetworkInterceptor(new HeaderInterceptor(this));
        okHttpClient$Builder0.addInterceptor(new ResponseInterceptor(this));
        if(A8.b.f()) {
            FlipperManager.INSTANCE.addFlipperOkhttpInterceptor(okHttpClient$Builder0);
        }
        this.client = okHttpClient$Builder0.build();
    }

    public ApiClient(Timeout timeout0, k k0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            timeout0 = Timeout.Companion.getDefault();
        }
        if((v & 2) != 0) {
            k0 = new h(28);
        }
        this(timeout0, k0);
    }

    private static final H _init_$lambda$0(okhttp3.OkHttpClient.Builder okHttpClient$Builder0) {
        q.g(okHttpClient$Builder0, "<this>");
        return H.a;
    }

    public static H a(okhttp3.OkHttpClient.Builder okHttpClient$Builder0) {
        return ApiClient._init_$lambda$0(okHttpClient$Builder0);
    }

    private final okhttp3.FormBody.Builder convertToFormBody(FormBody formBody0) {
        okhttp3.FormBody.Builder formBody$Builder0 = new okhttp3.FormBody.Builder(null, 1, null);
        if(formBody0 != null) {
            int v = formBody0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                String s = formBody0.name(v1);
                String s1 = formBody0.value(v1);
                formBody$Builder0.add(s, s1);
                TestLog testLog0 = TestLog.INSTANCE;
                if(testLog0.isTestOn()) {
                    testLog0.logRetrofitBody(s, s1);
                }
            }
        }
        return formBody$Builder0;
    }

    @NotNull
    public final OkHttpClient getClient() {
        return this.client;
    }

    private final okhttp3.Request.Builder handlePostParam(okhttp3.Request.Builder request$Builder0, RequestBody requestBody0, Api api0, boolean z) {
        if(requestBody0 != null && requestBody0 instanceof FormBody) {
            okhttp3.FormBody.Builder formBody$Builder0 = this.convertToFormBody(((FormBody)requestBody0));
            if(api0 != null) {
                switch(WhenMappings.$EnumSwitchMapping$0[api0.type().ordinal()]) {
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 9: {
                        formBody$Builder0.add("v", api0.type().getApiVersion());
                        MelonAppBase.Companion.getClass();
                        formBody$Builder0.add("resolution", ScreenUtils.getResolution(t.a().getContext()));
                        TestLog testLog0 = TestLog.INSTANCE;
                        if(testLog0.isTestOn()) {
                            testLog0.logRetrofitBody("v", api0.type().getApiVersion());
                            testLog0.logRetrofitBody("resolution", ScreenUtils.getResolution(t.a().getContext()));
                        }
                        break;
                    }
                    case 1: 
                    case 10: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: 
                    case 16: 
                    case 17: 
                    case 18: {
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                if(z) {
                    MelonAppBase.Companion.getClass();
                    String s = AppUtils.getVersionName(t.a().getContext());
                    formBody$Builder0.add("appVer", s);
                    TestLog testLog1 = TestLog.INSTANCE;
                    if(testLog1.isTestOn()) {
                        testLog1.logRetrofitBody("appVer", s);
                    }
                }
            }
            MelonAppBase.Companion.getClass();
            formBody$Builder0.add("cpId", t.a().getMelonCpId());
            formBody$Builder0.add("cpKey", t.a().getMelonCpKey());
            TestLog testLog2 = TestLog.INSTANCE;
            if(testLog2.isTestOn()) {
                testLog2.logRetrofitBody("cpId", t.a().getMelonCpId());
                testLog2.logRetrofitBody("cpKey", t.a().getMelonCpKey());
            }
            request$Builder0.post(formBody$Builder0.build());
        }
        return request$Builder0;
    }

    private final HttpUrl handleUrlParam(HttpUrl httpUrl0, String s, Api api0, boolean z) {
        String s1 = httpUrl0.queryParameter("nonUseUrlCpIdKey");
        if(s1 == null) {
            s1 = "";
        }
        okhttp3.HttpUrl.Builder httpUrl$Builder0 = httpUrl0.newBuilder();
        if(s1.length() == 0) {
            String s2 = httpUrl0.queryParameter("urlCpId");
            if(s2 != null) {
                httpUrl$Builder0.removeAllQueryParameters("urlCpId");
            }
            if(s2 == null) {
                s2 = Z.l(MelonAppBase.Companion);
            }
            String s3 = httpUrl0.queryParameter("urlCpKey");
            if(s3 != null) {
                httpUrl$Builder0.removeAllQueryParameters("urlCpKey");
            }
            if(s3 == null) {
                MelonAppBase.Companion.getClass();
                s3 = t.a().getMelonCpKey();
            }
            if(q.b(s, "POST")) {
                httpUrl$Builder0.addQueryParameter("_cpId", s2);
                httpUrl$Builder0.addQueryParameter("_cpKey", s3);
            }
            else {
                httpUrl$Builder0.addQueryParameter("cpId", s2);
                httpUrl$Builder0.addQueryParameter("cpKey", s3);
            }
        }
        else {
            httpUrl$Builder0.removeAllQueryParameters("nonUseUrlCpIdKey");
        }
        if(api0 != null) {
            switch(WhenMappings.$EnumSwitchMapping$0[api0.type().ordinal()]) {
                case 1: {
                    break;
                }
                case 2: 
                case 3: 
                case 4: 
                case 5: {
                    if(q.b(s, "GET")) {
                        httpUrl$Builder0.addQueryParameter("v", api0.type().getApiVersion());
                        MelonAppBase.Companion.getClass();
                        httpUrl$Builder0.addQueryParameter("resolution", ScreenUtils.getResolution(t.a().getContext()));
                    }
                    break;
                }
                case 6: 
                case 7: 
                case 8: 
                case 9: {
                    if(q.b(s, "GET")) {
                        httpUrl$Builder0.addQueryParameter("v", api0.type().getApiVersion());
                        MelonAppBase.Companion.getClass();
                        httpUrl$Builder0.addQueryParameter("resolution", ScreenUtils.getResolution(t.a().getContext()));
                    }
                    httpUrl$Builder0.encodedPath(api0.type().getUrl() + httpUrl0.encodedPath());
                    break;
                }
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: {
                    httpUrl$Builder0.encodedPath(api0.type().getUrl() + httpUrl0.encodedPath());
                    break;
                }
                default: {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
            }
            if(q.b(s, "GET") && z) {
                MelonAppBase.Companion.getClass();
                httpUrl$Builder0.addQueryParameter("appVer", AppUtils.getVersionName(t.a().getContext()));
            }
        }
        return httpUrl$Builder0.build();
    }

    public final void setClient(@NotNull OkHttpClient okHttpClient0) {
        q.g(okHttpClient0, "<set-?>");
        this.client = okHttpClient0;
    }
}

