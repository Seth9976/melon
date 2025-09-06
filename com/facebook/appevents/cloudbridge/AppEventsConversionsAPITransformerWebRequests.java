package com.facebook.appevents.cloudbridge;

import Ce.g;
import U4.x;
import androidx.appcompat.app.o;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.c;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import d8.d;
import ie.G;
import ie.H;
import ie.m;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import je.C;
import je.D;
import je.I;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.N;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import we.n;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\r\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0001HB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000F\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\rH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J+\u0010\u0013\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u000E\u001A\u00020\rH\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J=\u0010\u001B\u001A\u00020\b2\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0018\u0010\u0017\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00120\u00112\b\b\u0002\u0010\u0018\u001A\u00020\u0015H\u0000\u00A2\u0006\u0004\b\u0019\u0010\u001AJ+\u0010\u001F\u001A\u00020\b2\u001A\u0010\u001C\u001A\u0016\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012\u0018\u00010\u0011H\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJi\u0010)\u001A\u00020\b2\u0006\u0010 \u001A\u00020\u00042\u0006\u0010!\u001A\u00020\u00042\b\u0010\"\u001A\u0004\u0018\u00010\u00042\u0014\u0010#\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00122\b\b\u0002\u0010$\u001A\u00020\u00152\u001E\u0010&\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\b\u0018\u00010%H\u0000\u00A2\u0006\u0004\b\'\u0010(R\u0014\u0010*\u001A\u00020\u00048\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020\u00158\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001A\u00020\u00158\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001A\u00020\u00158\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b/\u0010-R$\u00102\u001A\u0012\u0012\u0004\u0012\u00020\u001500j\b\u0012\u0004\u0012\u00020\u0015`18\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00103R$\u00104\u001A\u0012\u0012\u0004\u0012\u00020\u001500j\b\u0012\u0004\u0012\u00020\u0015`18\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u00103R\"\u00106\u001A\u0002058\u0000@\u0000X\u0080.\u00A2\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R4\u0010=\u001A\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00120<8\u0000@\u0000X\u0080.\u00A2\u0006\u0012\n\u0004\b=\u0010>\u001A\u0004\b?\u0010@\"\u0004\bA\u0010\u001ER\u0014\u0010B\u001A\u00020\u00158\u0000X\u0080T\u00A2\u0006\u0006\n\u0004\bB\u0010-R\"\u0010C\u001A\u00020\u00158\u0000@\u0000X\u0080\u000E\u00A2\u0006\u0012\n\u0004\bC\u0010-\u001A\u0004\bD\u0010E\"\u0004\bF\u0010G\u00A8\u0006I"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests;", "", "<init>", "()V", "", "datasetID", "url", "accessKey", "Lie/H;", "configure", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCredentials", "()Ljava/lang/String;", "Lcom/facebook/GraphRequest;", "request", "transformGraphRequestAndSendToCAPIGEndPoint", "(Lcom/facebook/GraphRequest;)V", "", "", "transformAppEventRequestForCAPIG", "(Lcom/facebook/GraphRequest;)Ljava/util/List;", "", "responseCode", "processedEvents", "maxRetryCount", "handleError$facebook_core_release", "(Ljava/lang/Integer;Ljava/util/List;I)V", "handleError", "events", "appendEvents$facebook_core_release", "(Ljava/util/List;)V", "appendEvents", "urlStr", "requestMethod", "jsonBodyStr", "requestProperties", "timeOutInterval", "Lkotlin/Function2;", "requestCallback", "makeHttpRequest$facebook_core_release", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;ILwe/n;)V", "makeHttpRequest", "TAG", "Ljava/lang/String;", "MAX_CACHED_TRANSFORMED_EVENTS", "I", "MAX_PROCESSED_TRANSFORMED_EVENTS", "TIMEOUT_INTERVAL", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "ACCEPTABLE_HTTP_RESPONSE", "Ljava/util/HashSet;", "RETRY_EVENTS_HTTP_RESPONSE", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "credentials", "Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "getCredentials$facebook_core_release", "()Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "setCredentials$facebook_core_release", "(Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;)V", "", "transformedEvents", "Ljava/util/List;", "getTransformedEvents$facebook_core_release", "()Ljava/util/List;", "setTransformedEvents$facebook_core_release", "MAX_RETRY_COUNT", "currentRetryCount", "getCurrentRetryCount$facebook_core_release", "()I", "setCurrentRetryCount$facebook_core_release", "(I)V", "CloudBridgeCredentials", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class AppEventsConversionsAPITransformerWebRequests {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\f\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\'\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials;", "", "datasetID", "", "cloudBridgeURL", "accessKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKey", "()Ljava/lang/String;", "getCloudBridgeURL", "getDatasetID", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class CloudBridgeCredentials {
        @NotNull
        private final String accessKey;
        @NotNull
        private final String cloudBridgeURL;
        @NotNull
        private final String datasetID;

        public CloudBridgeCredentials(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "datasetID");
            q.g(s1, "cloudBridgeURL");
            q.g(s2, "accessKey");
            super();
            this.datasetID = s;
            this.cloudBridgeURL = s1;
            this.accessKey = s2;
        }

        @NotNull
        public final String component1() {
            return this.datasetID;
        }

        @NotNull
        public final String component2() {
            return this.cloudBridgeURL;
        }

        @NotNull
        public final String component3() {
            return this.accessKey;
        }

        @NotNull
        public final CloudBridgeCredentials copy(@NotNull String s, @NotNull String s1, @NotNull String s2) {
            q.g(s, "datasetID");
            q.g(s1, "cloudBridgeURL");
            q.g(s2, "accessKey");
            return new CloudBridgeCredentials(s, s1, s2);
        }

        public static CloudBridgeCredentials copy$default(CloudBridgeCredentials appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0, String s, String s1, String s2, int v, Object object0) {
            if((v & 1) != 0) {
                s = appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0.datasetID;
            }
            if((v & 2) != 0) {
                s1 = appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0.cloudBridgeURL;
            }
            if((v & 4) != 0) {
                s2 = appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0.accessKey;
            }
            return appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0.copy(s, s1, s2);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof CloudBridgeCredentials)) {
                return false;
            }
            if(!q.b(this.datasetID, ((CloudBridgeCredentials)object0).datasetID)) {
                return false;
            }
            return q.b(this.cloudBridgeURL, ((CloudBridgeCredentials)object0).cloudBridgeURL) ? q.b(this.accessKey, ((CloudBridgeCredentials)object0).accessKey) : false;
        }

        @NotNull
        public final String getAccessKey() {
            return this.accessKey;
        }

        @NotNull
        public final String getCloudBridgeURL() {
            return this.cloudBridgeURL;
        }

        @NotNull
        public final String getDatasetID() {
            return this.datasetID;
        }

        @Override
        public int hashCode() {
            return this.accessKey.hashCode() + x.b(this.datasetID.hashCode() * 0x1F, 0x1F, this.cloudBridgeURL);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("CloudBridgeCredentials(datasetID=");
            stringBuilder0.append(this.datasetID);
            stringBuilder0.append(", cloudBridgeURL=");
            stringBuilder0.append(this.cloudBridgeURL);
            stringBuilder0.append(", accessKey=");
            return o.r(stringBuilder0, this.accessKey, ')');
        }
    }

    @NotNull
    private static final HashSet ACCEPTABLE_HTTP_RESPONSE = null;
    @NotNull
    public static final AppEventsConversionsAPITransformerWebRequests INSTANCE = null;
    public static final int MAX_CACHED_TRANSFORMED_EVENTS = 1000;
    private static final int MAX_PROCESSED_TRANSFORMED_EVENTS = 10;
    public static final int MAX_RETRY_COUNT = 5;
    @NotNull
    private static final HashSet RETRY_EVENTS_HTTP_RESPONSE = null;
    @NotNull
    private static final String TAG = "CAPITransformerWebRequests";
    private static final int TIMEOUT_INTERVAL = 60000;
    public static CloudBridgeCredentials credentials;
    private static int currentRetryCount;
    public static List transformedEvents;

    static {
        AppEventsConversionsAPITransformerWebRequests.INSTANCE = new AppEventsConversionsAPITransformerWebRequests();
        AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE = I.H(new Integer[]{200, 202});
        AppEventsConversionsAPITransformerWebRequests.RETRY_EVENTS_HTTP_RESPONSE = I.H(new Integer[]{503, 504, 429});
    }

    public static void a(GraphRequest graphRequest0) {
        AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint$lambda$0(graphRequest0);
    }

    public final void appendEvents$facebook_core_release(@Nullable List list0) {
        if(list0 != null) {
            this.getTransformedEvents$facebook_core_release().addAll(list0);
        }
        int v = Math.max(0, this.getTransformedEvents$facebook_core_release().size() - 1000);
        if(v > 0) {
            this.setTransformedEvents$facebook_core_release(N.b(p.f0(v, this.getTransformedEvents$facebook_core_release())));
        }
    }

    public static final void configure(@NotNull String s, @NotNull String s1, @NotNull String s2) {
        q.g(s, "datasetID");
        q.g(s1, "url");
        q.g(s2, "accessKey");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "CAPITransformerWebRequests", " \n\nCloudbridge Configured: \n================\ndatasetID: %s\nurl: %s\naccessKey: %s\n\n", new Object[]{s, s1, s2});
        CloudBridgeCredentials appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0 = new CloudBridgeCredentials(s, s1, s2);
        AppEventsConversionsAPITransformerWebRequests.INSTANCE.setCredentials$facebook_core_release(appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0);
        ArrayList arrayList0 = new ArrayList();
        AppEventsConversionsAPITransformerWebRequests.INSTANCE.setTransformedEvents$facebook_core_release(arrayList0);
    }

    @Nullable
    public static final String getCredentials() {
        try {
            CloudBridgeCredentials appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0 = AppEventsConversionsAPITransformerWebRequests.INSTANCE.getCredentials$facebook_core_release();
            return appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0 == null ? null : appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0.toString();
        }
        catch(G unused_ex) {
        }
        return null;
    }

    @NotNull
    public final CloudBridgeCredentials getCredentials$facebook_core_release() {
        CloudBridgeCredentials appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0 = AppEventsConversionsAPITransformerWebRequests.credentials;
        if(appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0 != null) {
            return appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0;
        }
        q.m("credentials");
        throw null;
    }

    public final int getCurrentRetryCount$facebook_core_release() {
        return AppEventsConversionsAPITransformerWebRequests.currentRetryCount;
    }

    @NotNull
    public final List getTransformedEvents$facebook_core_release() {
        List list0 = AppEventsConversionsAPITransformerWebRequests.transformedEvents;
        if(list0 != null) {
            return list0;
        }
        q.m("transformedEvents");
        throw null;
    }

    public final void handleError$facebook_core_release(@Nullable Integer integer0, @NotNull List list0, int v) {
        q.g(list0, "processedEvents");
        if(p.d0(AppEventsConversionsAPITransformerWebRequests.RETRY_EVENTS_HTTP_RESPONSE, integer0)) {
            if(AppEventsConversionsAPITransformerWebRequests.currentRetryCount >= v) {
                this.getTransformedEvents$facebook_core_release().clear();
                AppEventsConversionsAPITransformerWebRequests.currentRetryCount = 0;
                return;
            }
            this.getTransformedEvents$facebook_core_release().addAll(0, list0);
            ++AppEventsConversionsAPITransformerWebRequests.currentRetryCount;
        }
    }

    public static void handleError$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests0, Integer integer0, List list0, int v, int v1, Object object0) {
        if((v1 & 4) != 0) {
            v = 5;
        }
        appEventsConversionsAPITransformerWebRequests0.handleError$facebook_core_release(integer0, list0, v);
    }

    public final void makeHttpRequest$facebook_core_release(@NotNull String s, @NotNull String s1, @Nullable String s2, @Nullable Map map0, int v, @Nullable n n0) {
        BufferedReader bufferedReader0;
        StringBuilder stringBuilder0;
        URLConnection uRLConnection0;
        q.g(s, "urlStr");
        q.g(s1, "requestMethod");
        try {
            uRLConnection0 = new URL(s).openConnection();
            q.e(uRLConnection0, "null cannot be cast to non-null type java.net.HttpURLConnection");
            ((HttpURLConnection)uRLConnection0).setRequestMethod(s1);
            if(map0 != null) {
                Set set0 = map0.keySet();
                if(set0 != null) {
                    for(Object object0: set0) {
                        ((HttpURLConnection)uRLConnection0).setRequestProperty(((String)object0), ((String)map0.get(((String)object0))));
                    }
                }
            }
            ((HttpURLConnection)uRLConnection0).setDoOutput(((HttpURLConnection)uRLConnection0).getRequestMethod().equals("POST") || ((HttpURLConnection)uRLConnection0).getRequestMethod().equals("PUT"));
            ((HttpURLConnection)uRLConnection0).setConnectTimeout(v);
            BufferedOutputStream bufferedOutputStream0 = new BufferedOutputStream(((HttpURLConnection)uRLConnection0).getOutputStream());
            BufferedWriter bufferedWriter0 = new BufferedWriter(new OutputStreamWriter(bufferedOutputStream0, "UTF-8"));
            bufferedWriter0.write(s2);
            bufferedWriter0.flush();
            bufferedWriter0.close();
            bufferedOutputStream0.close();
            stringBuilder0 = new StringBuilder();
            Integer integer0 = ((HttpURLConnection)uRLConnection0).getResponseCode();
            if(AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE.contains(integer0)) {
                bufferedReader0 = new BufferedReader(new InputStreamReader(((HttpURLConnection)uRLConnection0).getInputStream(), "UTF-8"));
                goto label_25;
            }
            goto label_33;
        }
        catch(UnknownHostException unknownHostException0) {
            goto label_43;
        }
        catch(IOException iOException0) {
            Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "Send to server failed: \n%s", new Object[]{iOException0.toString()});
            return;
        }
        try {
            while(true) {
            label_25:
                String s3 = bufferedReader0.readLine();
                if(s3 == null) {
                    goto label_32;
                }
                stringBuilder0.append(s3);
            }
        }
        catch(Throwable throwable0) {
            try {
                d.l(bufferedReader0, throwable0);
                throw throwable0;
            label_32:
                bufferedReader0.close();
            label_33:
                String s4 = stringBuilder0.toString();
                q.f(s4, "connResponseSB.toString()");
                Object[] arr_object = {s4, ((HttpURLConnection)uRLConnection0).getResponseCode()};
                Logger.Companion.log(LoggingBehavior.APP_EVENTS, "CAPITransformerWebRequests", "\nResponse Received: \n%s\n%s", arr_object);
                if(n0 != null) {
                    n0.invoke(s4, ((HttpURLConnection)uRLConnection0).getResponseCode());
                    return;
                }
                return;
            }
            catch(UnknownHostException unknownHostException0) {
            }
            catch(IOException iOException0) {
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "Send to server failed: \n%s", new Object[]{iOException0.toString()});
                return;
            }
        }
    label_43:
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, "CAPITransformerWebRequests", "Connection failed, retrying: \n%s", new Object[]{unknownHostException0.toString()});
        if(n0 != null) {
            n0.invoke(null, 503);
        }
    }

    public static void makeHttpRequest$facebook_core_release$default(AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests0, String s, String s1, String s2, Map map0, int v, n n0, int v1, Object object0) {
        if((v1 & 16) != 0) {
            v = 60000;
        }
        appEventsConversionsAPITransformerWebRequests0.makeHttpRequest$facebook_core_release(s, s1, s2, map0, v, n0);
    }

    public final void setCredentials$facebook_core_release(@NotNull CloudBridgeCredentials appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0) {
        q.g(appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0, "<set-?>");
        AppEventsConversionsAPITransformerWebRequests.credentials = appEventsConversionsAPITransformerWebRequests$CloudBridgeCredentials0;
    }

    public final void setCurrentRetryCount$facebook_core_release(int v) {
        AppEventsConversionsAPITransformerWebRequests.currentRetryCount = v;
    }

    public final void setTransformedEvents$facebook_core_release(@NotNull List list0) {
        q.g(list0, "<set-?>");
        AppEventsConversionsAPITransformerWebRequests.transformedEvents = list0;
    }

    private final List transformAppEventRequestForCAPIG(GraphRequest graphRequest0) {
        JSONObject jSONObject0 = graphRequest0.getGraphObject();
        if(jSONObject0 != null) {
            LinkedHashMap linkedHashMap0 = C.a0(Utility.convertJSONObjectToHashMap(jSONObject0));
            Object object0 = graphRequest0.getTag();
            q.e(object0, "null cannot be cast to non-null type kotlin.Any");
            linkedHashMap0.put("custom_events", object0);
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object1: linkedHashMap0.keySet()) {
                stringBuilder0.append(((String)object1));
                stringBuilder0.append(" : ");
                stringBuilder0.append(linkedHashMap0.get(((String)object1)));
                stringBuilder0.append("\n");
            }
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "CAPITransformerWebRequests", "\nGraph Request data: \n\n%s \n\n", new Object[]{stringBuilder0});
            return AppEventsConversionsAPITransformer.INSTANCE.conversionsAPICompatibleEvent$facebook_core_release(linkedHashMap0);
        }
        return null;
    }

    public static final void transformGraphRequestAndSendToCAPIGEndPoint(@NotNull GraphRequest graphRequest0) {
        q.g(graphRequest0, "request");
        Utility.runOnNonUiThread(new c(graphRequest0, 1));

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001A\u00020\u00042\b\u0010\u0001\u001A\u0004\u0018\u00010\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "<anonymous parameter 0>", "", "responseCode", "Lie/H;", "invoke", "(Ljava/lang/String;Ljava/lang/Integer;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        final class com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint.1.1 extends r implements n {
            final List $processedEvents;

            public com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint.1.1(List list0) {
                this.$processedEvents = list0;
                super(2);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                this.invoke(((String)object0), ((Integer)object1));
                return H.a;
            }

            public final void invoke(@Nullable String s, @Nullable Integer integer0) {
                Utility.runOnNonUiThread(() -> {
                    q.g(this.$processedEvents, "$processedEvents");
                    if(!p.d0(AppEventsConversionsAPITransformerWebRequests.ACCEPTABLE_HTTP_RESPONSE, integer0)) {
                        AppEventsConversionsAPITransformerWebRequests.INSTANCE.handleError$facebook_core_release(integer0, this.$processedEvents, 5);
                    }
                });
            }

            // 检测为 Lambda 实现
            private static final void invoke$lambda$0(Integer integer0, List list0) [...]
        }

    }

    private static final void transformGraphRequestAndSendToCAPIGEndPoint$lambda$0(GraphRequest graphRequest0) {
        String s1;
        AppEventsConversionsAPITransformerWebRequests appEventsConversionsAPITransformerWebRequests0;
        q.g(graphRequest0, "$request");
        String s = graphRequest0.getGraphPath();
        List list0 = s == null ? null : Tf.o.R0(s, new String[]{"/"}, 0, 6);
        if(list0 != null && list0.size() == 2) {
            try {
                appEventsConversionsAPITransformerWebRequests0 = AppEventsConversionsAPITransformerWebRequests.INSTANCE;
                s1 = appEventsConversionsAPITransformerWebRequests0.getCredentials$facebook_core_release().getCloudBridgeURL() + "/capi/" + appEventsConversionsAPITransformerWebRequests0.getCredentials$facebook_core_release().getDatasetID() + "/events";
            }
            catch(G g0) {
                Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "\n Credentials not initialized Error when logging: \n%s", new Object[]{g0});
                return;
            }
            List list1 = appEventsConversionsAPITransformerWebRequests0.transformAppEventRequestForCAPIG(graphRequest0);
            if(list1 == null) {
                return;
            }
            appEventsConversionsAPITransformerWebRequests0.appendEvents$facebook_core_release(list1);
            int v = Math.min(appEventsConversionsAPITransformerWebRequests0.getTransformedEvents$facebook_core_release().size(), 10);
            List list2 = p.H0(appEventsConversionsAPITransformerWebRequests0.getTransformedEvents$facebook_core_release(), new g(0, v - 1, 1));  // 初始化器: LCe/e;-><init>(III)V
            appEventsConversionsAPITransformerWebRequests0.getTransformedEvents$facebook_core_release().subList(0, v).clear();
            JSONArray jSONArray0 = new JSONArray(list2);
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            linkedHashMap0.put("data", jSONArray0);
            linkedHashMap0.put("accessKey", appEventsConversionsAPITransformerWebRequests0.getCredentials$facebook_core_release().getAccessKey());
            JSONObject jSONObject0 = new JSONObject(linkedHashMap0);
            String s2 = jSONObject0.toString(2);
            q.f(s2, "jsonBodyStr.toString(2)");
            Logger.Companion.log(LoggingBehavior.APP_EVENTS, "CAPITransformerWebRequests", "\nTransformed_CAPI_JSON:\nURL: %s\nFROM=========\n%s\n>>>>>>TO>>>>>>\n%s\n=============\n", new Object[]{s1, graphRequest0, s2});
            appEventsConversionsAPITransformerWebRequests0.makeHttpRequest$facebook_core_release(s1, "POST", jSONObject0.toString(), D.O(new m("Content-Type", "application/json")), 60000, new com.facebook.appevents.cloudbridge.AppEventsConversionsAPITransformerWebRequests.transformGraphRequestAndSendToCAPIGEndPoint.1.1(list2));
            return;
        }
        Logger.Companion.log(LoggingBehavior.DEVELOPER_ERRORS, "CAPITransformerWebRequests", "\n GraphPathComponents Error when logging: \n%s", new Object[]{graphRequest0});
    }
}

