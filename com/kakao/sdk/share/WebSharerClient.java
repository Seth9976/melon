package com.kakao.sdk.share;

import android.net.Uri.Builder;
import android.net.Uri;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.template.model.DefaultTemplate;
import d3.g;
import ie.j;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001E\u0010\u0007\u001A\u00020\b2\u0014\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\nH\u0002J>\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0016\b\u0002\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n2\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\nJ(\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00132\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\nH\u0007JQ\u0010\u0014\u001A\u00020\r2\u0006\u0010\u0015\u001A\u00020\u000B2\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0016\b\u0002\u0010\u0010\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\n2\u0016\b\u0002\u0010\t\u001A\u0010\u0012\u0004\u0012\u00020\u000B\u0012\u0004\u0012\u00020\u000B\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/kakao/sdk/share/WebSharerClient;", "", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "(Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApplicationInfo;)V", "baseUriBuilder", "Landroid/net/Uri$Builder;", "serverCallbackArgs", "", "", "makeCustomUrl", "Landroid/net/Uri;", "templateId", "", "templateArgs", "makeDefaultUrl", "template", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "makeScrapUrl", "requestUrl", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;)Landroid/net/Uri;", "Companion", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class WebSharerClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/share/WebSharerClient$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/share/WebSharerClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/share/WebSharerClient;", "getInstance$annotations", "instance", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final WebSharerClient getInstance() {
            return (WebSharerClient)WebSharerClient.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ApplicationInfo applicationInfo;
    @NotNull
    private final ContextInfo contextInfo;
    @NotNull
    private static final j instance$delegate;

    static {
        WebSharerClient.Companion = new Companion(null);
        WebSharerClient.instance$delegate = g.Q(WebSharerClient.Companion.instance.2.INSTANCE);
    }

    public WebSharerClient() {
        this(null, null, 3, null);
    }

    public WebSharerClient(@NotNull ContextInfo contextInfo0, @NotNull ApplicationInfo applicationInfo0) {
        q.g(contextInfo0, "contextInfo");
        q.g(applicationInfo0, "applicationInfo");
        super();
        this.contextInfo = contextInfo0;
        this.applicationInfo = applicationInfo0;
    }

    public WebSharerClient(ContextInfo contextInfo0, ApplicationInfo applicationInfo0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            contextInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 2) != 0) {
            applicationInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        this(contextInfo0, applicationInfo0);
    }

    private final Uri.Builder baseUriBuilder(Map map0) {
        Uri.Builder uri$Builder0 = new Uri.Builder().scheme("https").authority("sharer.kakao.com").path("talk/friends/picker/easylink").appendQueryParameter("app_key", this.applicationInfo.getAppKey()).appendQueryParameter("ka", this.contextInfo.getKaHeader());
        if(map0 != null) {
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            uri$Builder0.appendQueryParameter("lcba", json0.encodeToString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), map0));
        }
        q.f(uri$Builder0, "builder");
        return uri$Builder0;
    }

    @NotNull
    public static final WebSharerClient getInstance() {
        return WebSharerClient.Companion.getInstance();
    }

    @NotNull
    public final Uri makeCustomUrl(long v, @Nullable Map map0, @Nullable Map map1) {
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder0, "template_id", String.valueOf(v));
        if(map0 != null) {
            JsonObjectBuilder jsonObjectBuilder1 = new JsonObjectBuilder();
            for(Object object0: map0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                Object object1 = ((Map.Entry)object0).getValue();
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                jsonObjectBuilder1.put(s, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
            }
            jsonObjectBuilder0.put("template_args", jsonObjectBuilder1.build());
        }
        JsonElementBuildersKt.put(jsonObjectBuilder0, "link_ver", "4.0");
        JsonObject jsonObject0 = jsonObjectBuilder0.build();
        Uri uri0 = this.baseUriBuilder(map1).appendQueryParameter("validation_action", "custom").appendQueryParameter("validation_params", jsonObject0.toString()).build();
        q.f(uri0, "builder.build()");
        return uri0;
    }

    public static Uri makeCustomUrl$default(WebSharerClient webSharerClient0, long v, Map map0, Map map1, int v1, Object object0) {
        if((v1 & 2) != 0) {
            map0 = null;
        }
        if((v1 & 4) != 0) {
            map1 = null;
        }
        return webSharerClient0.makeCustomUrl(v, map0, map1);
    }

    @NotNull
    public final Uri makeDefaultUrl(@NotNull DefaultTemplate defaultTemplate0) {
        q.g(defaultTemplate0, "template");
        return WebSharerClient.makeDefaultUrl$default(this, defaultTemplate0, null, 2, null);
    }

    @NotNull
    public final Uri makeDefaultUrl(@NotNull DefaultTemplate defaultTemplate0, @Nullable Map map0) {
        q.g(defaultTemplate0, "template");
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        jsonObjectBuilder0.put("template_object", json0.encodeToJsonElement(DefaultTemplate.Companion.serializer(), defaultTemplate0));
        JsonElementBuildersKt.put(jsonObjectBuilder0, "link_ver", "4.0");
        JsonObject jsonObject0 = jsonObjectBuilder0.build();
        Uri uri0 = this.baseUriBuilder(map0).appendQueryParameter("validation_action", "default").appendQueryParameter("validation_params", jsonObject0.toString()).build();
        q.f(uri0, "builder.build()");
        return uri0;
    }

    public static Uri makeDefaultUrl$default(WebSharerClient webSharerClient0, DefaultTemplate defaultTemplate0, Map map0, int v, Object object0) {
        if((v & 2) != 0) {
            map0 = null;
        }
        return webSharerClient0.makeDefaultUrl(defaultTemplate0, map0);
    }

    @NotNull
    public final Uri makeScrapUrl(@NotNull String s) {
        q.g(s, "requestUrl");
        return WebSharerClient.makeScrapUrl$default(this, s, null, null, null, 14, null);
    }

    @NotNull
    public final Uri makeScrapUrl(@NotNull String s, @Nullable Long long0) {
        q.g(s, "requestUrl");
        return WebSharerClient.makeScrapUrl$default(this, s, long0, null, null, 12, null);
    }

    @NotNull
    public final Uri makeScrapUrl(@NotNull String s, @Nullable Long long0, @Nullable Map map0) {
        q.g(s, "requestUrl");
        return WebSharerClient.makeScrapUrl$default(this, s, long0, map0, null, 8, null);
    }

    @NotNull
    public final Uri makeScrapUrl(@NotNull String s, @Nullable Long long0, @Nullable Map map0, @Nullable Map map1) {
        q.g(s, "requestUrl");
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        JsonElementBuildersKt.put(jsonObjectBuilder0, "request_url", s);
        if(long0 != null) {
            JsonElementBuildersKt.put(jsonObjectBuilder0, "template_id", long0.longValue());
        }
        if(map0 != null) {
            JsonObjectBuilder jsonObjectBuilder1 = new JsonObjectBuilder();
            for(Object object0: map0.entrySet()) {
                String s1 = (String)((Map.Entry)object0).getKey();
                Object object1 = ((Map.Entry)object0).getValue();
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                jsonObjectBuilder1.put(s1, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
            }
            jsonObjectBuilder0.put("template_args", jsonObjectBuilder1.build());
        }
        JsonElementBuildersKt.put(jsonObjectBuilder0, "link_ver", "4.0");
        JsonObject jsonObject0 = jsonObjectBuilder0.build();
        Uri uri0 = this.baseUriBuilder(map1).appendQueryParameter("validation_action", "scrap").appendQueryParameter("validation_params", jsonObject0.toString()).build();
        q.f(uri0, "builder.build()");
        return uri0;
    }

    public static Uri makeScrapUrl$default(WebSharerClient webSharerClient0, String s, Long long0, Map map0, Map map1, int v, Object object0) {
        if((v & 2) != 0) {
            long0 = null;
        }
        if((v & 4) != 0) {
            map0 = null;
        }
        if((v & 8) != 0) {
            map1 = null;
        }
        return webSharerClient0.makeScrapUrl(s, long0, map0, map1);
    }
}

