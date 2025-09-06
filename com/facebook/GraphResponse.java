package com.facebook;

import android.util.Log;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.iloen.melon.utils.a;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \'2\u00020\u0001:\u0002\'(B+\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rB!\b\u0016\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000E\u001A\u00020\u000F¢\u0006\u0002\u0010\u0010BA\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001A\u0004\u0018\u00010\t\u0012\b\u0010\u0011\u001A\u0004\u0018\u00010\f\u0012\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\u0002\u0010\u0012J\b\u0010!\u001A\u0004\u0018\u00010\fJ\b\u0010\"\u001A\u0004\u0018\u00010\tJ\u0010\u0010#\u001A\u0004\u0018\u00010\u00032\u0006\u0010$\u001A\u00020%J\b\u0010&\u001A\u00020\u0007H\u0016R\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000E\u001A\u0004\u0018\u00010\u000F¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001A\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001A\u001A\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u001CR\u0013\u0010\u0006\u001A\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u001ER\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010 ¨\u0006)"}, d2 = {"Lcom/facebook/GraphResponse;", "", "request", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "rawResponse", "", "graphObject", "Lorg/json/JSONObject;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;)V", "graphObjects", "Lorg/json/JSONArray;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONArray;)V", "error", "Lcom/facebook/FacebookRequestError;", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Lcom/facebook/FacebookRequestError;)V", "graphObjectArray", "(Lcom/facebook/GraphRequest;Ljava/net/HttpURLConnection;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONArray;Lcom/facebook/FacebookRequestError;)V", "getConnection", "()Ljava/net/HttpURLConnection;", "getError", "()Lcom/facebook/FacebookRequestError;", "jsonArray", "getJsonArray", "()Lorg/json/JSONArray;", "jsonObject", "getJsonObject", "()Lorg/json/JSONObject;", "getRawResponse", "()Ljava/lang/String;", "getRequest", "()Lcom/facebook/GraphRequest;", "getJSONArray", "getJSONObject", "getRequestForPagedResults", "direction", "Lcom/facebook/GraphResponse$PagingDirection;", "toString", "Companion", "PagingDirection", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class GraphResponse {
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\n\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012H\u0007J*\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0014\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001A\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u0001H\u0002J.\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u000E0\u000B2\u0006\u0010\u0015\u001A\u00020\u0001H\u0002J/\u0010\u0018\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\b\u0010\u0019\u001A\u0004\u0018\u00010\u001A2\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\r\u001A\u00020\u001BH\u0001¢\u0006\u0002\b\u001CJ-\u0010\u001D\u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\u001E\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u00102\u0006\u0010\r\u001A\u00020\u001BH\u0001¢\u0006\u0002\b\u001FJ#\u0010 \u001A\b\u0012\u0004\u0012\u00020\f0\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u001BH\u0001¢\u0006\u0002\b!R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001A\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/GraphResponse$Companion;", "", "()V", "BODY_KEY", "", "CODE_KEY", "NON_JSON_RESPONSE_PROPERTY", "RESPONSE_LOG_TAG", "SUCCESS_KEY", "TAG", "constructErrorResponses", "", "Lcom/facebook/GraphResponse;", "requests", "Lcom/facebook/GraphRequest;", "connection", "Ljava/net/HttpURLConnection;", "error", "Lcom/facebook/FacebookException;", "createResponseFromObject", "request", "sourceObject", "originalResult", "createResponsesFromObject", "createResponsesFromStream", "stream", "Ljava/io/InputStream;", "Lcom/facebook/GraphRequestBatch;", "createResponsesFromStream$facebook_core_release", "createResponsesFromString", "responseString", "createResponsesFromString$facebook_core_release", "fromHttpConnection", "fromHttpConnection$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final List constructErrorResponses(@NotNull List list0, @Nullable HttpURLConnection httpURLConnection0, @Nullable FacebookException facebookException0) {
            q.g(list0, "requests");
            List list1 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                list1.add(new GraphResponse(((GraphRequest)object0), httpURLConnection0, new FacebookRequestError(httpURLConnection0, facebookException0)));
            }
            return list1;
        }

        private final GraphResponse createResponseFromObject(GraphRequest graphRequest0, HttpURLConnection httpURLConnection0, Object object0, Object object1) {
            if(object0 instanceof JSONObject) {
                FacebookRequestError facebookRequestError0 = FacebookRequestError.Companion.checkResponseAndCreateError(((JSONObject)object0), object1, httpURLConnection0);
                if(facebookRequestError0 != null) {
                    Log.e(GraphResponse.TAG, facebookRequestError0.toString());
                    if(facebookRequestError0.getErrorCode() == 190 && Utility.isCurrentAccessToken(graphRequest0.getAccessToken())) {
                        if(facebookRequestError0.getSubErrorCode() != 493) {
                            AccessToken.Companion.setCurrentAccessToken(null);
                            return new GraphResponse(graphRequest0, httpURLConnection0, facebookRequestError0);
                        }
                        com.facebook.AccessToken.Companion accessToken$Companion0 = AccessToken.Companion;
                        AccessToken accessToken0 = accessToken$Companion0.getCurrentAccessToken();
                        if(accessToken0 != null && !accessToken0.isExpired()) {
                            accessToken$Companion0.expireCurrentAccessToken();
                        }
                    }
                    return new GraphResponse(graphRequest0, httpURLConnection0, facebookRequestError0);
                }
                Object object2 = Utility.getStringPropertyAsJSON(((JSONObject)object0), "body", "FACEBOOK_NON_JSON_RESULT");
                if(object2 instanceof JSONObject) {
                    return new GraphResponse(graphRequest0, httpURLConnection0, ((JSONObject)object2).toString(), ((JSONObject)object2));
                }
                if(object2 instanceof JSONArray) {
                    return new GraphResponse(graphRequest0, httpURLConnection0, ((JSONArray)object2).toString(), ((JSONArray)object2));
                }
                object0 = JSONObject.NULL;
                q.f(object0, "NULL");
            }
            if(object0 != JSONObject.NULL) {
                throw new FacebookException("Got unexpected object type in response, class: " + object0.getClass().getSimpleName());
            }
            return new GraphResponse(graphRequest0, httpURLConnection0, object0.toString(), null);
        }

        private final List createResponsesFromObject(HttpURLConnection httpURLConnection0, List list0, Object object0) {
            JSONArray jSONArray0;
            int v = list0.size();
            List list1 = new ArrayList(v);
            if(v == 1) {
                GraphRequest graphRequest0 = (GraphRequest)list0.get(0);
                try {
                    JSONObject jSONObject0 = new JSONObject();
                    jSONObject0.put("body", object0);
                    jSONObject0.put("code", (httpURLConnection0 == null ? 200 : httpURLConnection0.getResponseCode()));
                    jSONArray0 = new JSONArray();
                    jSONArray0.put(jSONObject0);
                    goto label_18;
                }
                catch(JSONException jSONException0) {
                }
                catch(IOException iOException0) {
                    list1.add(new GraphResponse(graphRequest0, httpURLConnection0, new FacebookRequestError(httpURLConnection0, iOException0)));
                    goto label_17;
                }
                list1.add(new GraphResponse(graphRequest0, httpURLConnection0, new FacebookRequestError(httpURLConnection0, jSONException0)));
                goto label_17;
            }
            else {
            label_17:
                jSONArray0 = object0;
            }
        label_18:
            if(!(jSONArray0 instanceof JSONArray) || jSONArray0.length() != v) {
                throw new FacebookException("Unexpected number of results");
            }
            int v2 = jSONArray0.length();
            for(int v1 = 0; v1 < v2; ++v1) {
                GraphRequest graphRequest1 = (GraphRequest)list0.get(v1);
                try {
                    Object object1 = jSONArray0.get(v1);
                    q.f(object1, "obj");
                    list1.add(this.createResponseFromObject(graphRequest1, httpURLConnection0, object1, object0));
                }
                catch(JSONException jSONException1) {
                    list1.add(new GraphResponse(graphRequest1, httpURLConnection0, new FacebookRequestError(httpURLConnection0, jSONException1)));
                }
                catch(FacebookException facebookException0) {
                    list1.add(new GraphResponse(graphRequest1, httpURLConnection0, new FacebookRequestError(httpURLConnection0, facebookException0)));
                }
            }
            return list1;
        }

        @NotNull
        public final List createResponsesFromStream$facebook_core_release(@Nullable InputStream inputStream0, @Nullable HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(graphRequestBatch0, "requests");
            String s = Utility.readStreamToString(inputStream0);
            Logger.Companion.log(LoggingBehavior.INCLUDE_RAW_RESPONSES, "Response", "Response (raw)\n  Size: %d\n  Response:\n%s\n", new Object[]{s.length(), s});
            return this.createResponsesFromString$facebook_core_release(s, httpURLConnection0, graphRequestBatch0);
        }

        @NotNull
        public final List createResponsesFromString$facebook_core_release(@NotNull String s, @Nullable HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
            q.g(s, "responseString");
            q.g(graphRequestBatch0, "requests");
            Object object0 = new JSONTokener(s).nextValue();
            q.f(object0, "resultObject");
            List list0 = this.createResponsesFromObject(httpURLConnection0, graphRequestBatch0, object0);
            Logger.Companion.log(LoggingBehavior.REQUESTS, "Response", "Response\n  Id: %s\n  Size: %d\n  Responses:\n%s\n", new Object[]{"1", s.length(), list0});
            return list0;
        }

        @NotNull
        public final List fromHttpConnection$facebook_core_release(@NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
            List list1;
            List list0;
            q.g(httpURLConnection0, "connection");
            q.g(graphRequestBatch0, "requests");
            InputStream inputStream0 = null;
            try {
                try {
                    if(!FacebookSdk.isFullyInitialized()) {
                        Log.e(GraphResponse.TAG, "GraphRequest can\'t be used when Facebook SDK isn\'t fully initialized");
                        throw new FacebookException("GraphRequest can\'t be used when Facebook SDK isn\'t fully initialized");
                    }
                    inputStream0 = httpURLConnection0.getResponseCode() < 400 ? httpURLConnection0.getInputStream() : httpURLConnection0.getErrorStream();
                    list0 = this.createResponsesFromStream$facebook_core_release(inputStream0, httpURLConnection0, graphRequestBatch0);
                    goto label_23;
                }
                catch(FacebookException facebookException0) {
                }
                catch(Exception exception0) {
                    Logger.Companion.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[]{exception0});
                    list1 = this.constructErrorResponses(graphRequestBatch0, httpURLConnection0, new FacebookException(exception0));
                    Utility.closeQuietly(inputStream0);
                    return list1;
                }
                Logger.Companion.log(LoggingBehavior.REQUESTS, "Response", "Response <Error>: %s", new Object[]{facebookException0});
                list1 = this.constructErrorResponses(graphRequestBatch0, httpURLConnection0, facebookException0);
            }
            catch(Throwable throwable0) {
                Utility.closeQuietly(inputStream0);
                throw throwable0;
            }
            Utility.closeQuietly(inputStream0);
            return list1;
        label_23:
            Utility.closeQuietly(inputStream0);
            return list0;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/GraphResponse$PagingDirection;", "", "(Ljava/lang/String;I)V", "NEXT", "PREVIOUS", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum PagingDirection {
        NEXT,
        PREVIOUS;

        private static final PagingDirection[] $values() [...] // Inlined contents
    }

    @NotNull
    private static final String BODY_KEY = "body";
    @NotNull
    private static final String CODE_KEY = "code";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String NON_JSON_RESPONSE_PROPERTY = "FACEBOOK_NON_JSON_RESULT";
    @NotNull
    private static final String RESPONSE_LOG_TAG = "Response";
    @NotNull
    public static final String SUCCESS_KEY = "success";
    @Nullable
    private static final String TAG;
    @Nullable
    private final HttpURLConnection connection;
    @Nullable
    private final FacebookRequestError error;
    @Nullable
    private final JSONObject graphObject;
    @Nullable
    private final JSONArray graphObjectArray;
    @Nullable
    private final JSONArray jsonArray;
    @Nullable
    private final JSONObject jsonObject;
    @Nullable
    private final String rawResponse;
    @NotNull
    private final GraphRequest request;

    static {
        GraphResponse.Companion = new Companion(null);
        GraphResponse.TAG = GraphResponse.class.getCanonicalName();
    }

    public GraphResponse(@NotNull GraphRequest graphRequest0, @Nullable HttpURLConnection httpURLConnection0, @NotNull FacebookRequestError facebookRequestError0) {
        q.g(graphRequest0, "request");
        q.g(facebookRequestError0, "error");
        this(graphRequest0, httpURLConnection0, null, null, null, facebookRequestError0);
    }

    public GraphResponse(@NotNull GraphRequest graphRequest0, @Nullable HttpURLConnection httpURLConnection0, @NotNull String s, @NotNull JSONArray jSONArray0) {
        q.g(graphRequest0, "request");
        q.g(s, "rawResponse");
        q.g(jSONArray0, "graphObjects");
        this(graphRequest0, httpURLConnection0, s, null, jSONArray0, null);
    }

    public GraphResponse(@NotNull GraphRequest graphRequest0, @Nullable HttpURLConnection httpURLConnection0, @NotNull String s, @Nullable JSONObject jSONObject0) {
        q.g(graphRequest0, "request");
        q.g(s, "rawResponse");
        this(graphRequest0, httpURLConnection0, s, jSONObject0, null, null);
    }

    public GraphResponse(@NotNull GraphRequest graphRequest0, @Nullable HttpURLConnection httpURLConnection0, @Nullable String s, @Nullable JSONObject jSONObject0, @Nullable JSONArray jSONArray0, @Nullable FacebookRequestError facebookRequestError0) {
        q.g(graphRequest0, "request");
        super();
        this.request = graphRequest0;
        this.connection = httpURLConnection0;
        this.rawResponse = s;
        this.graphObject = jSONObject0;
        this.graphObjectArray = jSONArray0;
        this.error = facebookRequestError0;
        this.jsonObject = jSONObject0;
        this.jsonArray = jSONArray0;
    }

    @NotNull
    public static final List constructErrorResponses(@NotNull List list0, @Nullable HttpURLConnection httpURLConnection0, @Nullable FacebookException facebookException0) {
        return GraphResponse.Companion.constructErrorResponses(list0, httpURLConnection0, facebookException0);
    }

    @NotNull
    public static final List createResponsesFromStream$facebook_core_release(@Nullable InputStream inputStream0, @Nullable HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphResponse.Companion.createResponsesFromStream$facebook_core_release(inputStream0, httpURLConnection0, graphRequestBatch0);
    }

    @NotNull
    public static final List createResponsesFromString$facebook_core_release(@NotNull String s, @Nullable HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphResponse.Companion.createResponsesFromString$facebook_core_release(s, httpURLConnection0, graphRequestBatch0);
    }

    @NotNull
    public static final List fromHttpConnection$facebook_core_release(@NotNull HttpURLConnection httpURLConnection0, @NotNull GraphRequestBatch graphRequestBatch0) {
        return GraphResponse.Companion.fromHttpConnection$facebook_core_release(httpURLConnection0, graphRequestBatch0);
    }

    @Nullable
    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final FacebookRequestError getError() {
        return this.error;
    }

    @Nullable
    public final JSONArray getJSONArray() {
        return this.graphObjectArray;
    }

    @Nullable
    public final JSONObject getJSONObject() {
        return this.graphObject;
    }

    @Nullable
    public final JSONArray getJsonArray() {
        return this.jsonArray;
    }

    @Nullable
    public final JSONObject getJsonObject() {
        return this.jsonObject;
    }

    @Nullable
    public final String getRawResponse() {
        return this.rawResponse;
    }

    @NotNull
    public final GraphRequest getRequest() {
        return this.request;
    }

    @Nullable
    public final GraphRequest getRequestForPagedResults(@NotNull PagingDirection graphResponse$PagingDirection0) {
        String s;
        q.g(graphResponse$PagingDirection0, "direction");
        JSONObject jSONObject0 = this.graphObject;
        if(jSONObject0 == null) {
            s = null;
        }
        else {
            JSONObject jSONObject1 = jSONObject0.optJSONObject("paging");
            if(jSONObject1 == null) {
                s = null;
            }
            else if(graphResponse$PagingDirection0 == PagingDirection.NEXT) {
                s = jSONObject1.optString("next");
            }
            else {
                s = jSONObject1.optString("previous");
            }
        }
        if(Utility.isNullOrEmpty(s)) {
            return null;
        }
        if(s != null && s.equals(this.request.getUrlForSingleRequest())) {
            return null;
        }
        try {
            URL uRL0 = new URL(s);
            return new GraphRequest(this.request.getAccessToken(), uRL0);
        }
        catch(MalformedURLException unused_ex) {
            return null;
        }
    }

    @Override
    @NotNull
    public String toString() {
        String s = "unknown";
        try {
            s = String.format(Locale.US, "%d", Arrays.copyOf(new Object[]{((int)(this.connection == null ? 200 : this.connection.getResponseCode()))}, 1));
        }
        catch(IOException unused_ex) {
        }
        StringBuilder stringBuilder0 = a.n("{Response:  responseCode: ", s, ", graphObject: ");
        stringBuilder0.append(this.graphObject);
        stringBuilder0.append(", error: ");
        stringBuilder0.append(this.error);
        stringBuilder0.append("}");
        String s1 = stringBuilder0.toString();
        q.f(s1, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return s1;
    }
}

