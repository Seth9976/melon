package com.kakao.sdk.share;

import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.net.Uri;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.IntentResolveClient;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import com.kakao.sdk.share.model.KakaoTalkSharingAttachment;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.share.model.ValidationResult;
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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B#\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ.\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\u0014\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H\u0002J&\u0010\u0017\u001A\u00020\u00182\u0006\u0010\u0019\u001A\u00020\u00182\u0014\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016H\u0002J\u000E\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u001C\u001A\u00020\u001DJB\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u001C\u001A\u00020\u001D2\u0006\u0010\u0013\u001A\u00020\u00142\u0014\u0010\u0015\u001A\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00162\b\b\u0002\u0010\u0011\u001A\u00020\u00122\b\b\u0002\u0010 \u001A\u00020\u0012H\u0007J\u0010\u0010!\u001A\n #*\u0004\u0018\u00010\"0\"H\u0002R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000E¨\u0006%"}, d2 = {"Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "intentResolveClient", "Lcom/kakao/sdk/common/util/IntentResolveClient;", "(Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/util/IntentResolveClient;)V", "getApplicationInfo", "()Lcom/kakao/sdk/common/model/ApplicationInfo;", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "getIntentResolveClient", "()Lcom/kakao/sdk/common/util/IntentResolveClient;", "attachmentSize", "", "appKey", "", "response", "Lcom/kakao/sdk/share/model/ValidationResult;", "serverCallbackArgs", "", "extrasWithServerCallbacks", "Lkotlinx/serialization/json/JsonObject;", "extras", "isKakaoTalkSharingAvailable", "", "context", "Landroid/content/Context;", "sharingResultFromResponse", "Lcom/kakao/sdk/share/model/SharingResult;", "appVer", "sharingUriBuilder", "Landroid/net/Uri$Builder;", "kotlin.jvm.PlatformType", "Companion", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class KakaoTalkShareIntentClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001B\u0010\t\u001A\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001A\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/kakao/sdk/share/KakaoTalkShareIntentClient$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "instance", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final KakaoTalkShareIntentClient getInstance() {
            return (KakaoTalkShareIntentClient)KakaoTalkShareIntentClient.instance$delegate.getValue();
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
    @NotNull
    private final IntentResolveClient intentResolveClient;

    static {
        KakaoTalkShareIntentClient.Companion = new Companion(null);
        KakaoTalkShareIntentClient.instance$delegate = g.Q(KakaoTalkShareIntentClient.Companion.instance.2.INSTANCE);
    }

    public KakaoTalkShareIntentClient() {
        this(null, null, null, 7, null);
    }

    public KakaoTalkShareIntentClient(@NotNull ContextInfo contextInfo0, @NotNull ApplicationInfo applicationInfo0, @NotNull IntentResolveClient intentResolveClient0) {
        q.g(contextInfo0, "contextInfo");
        q.g(applicationInfo0, "applicationInfo");
        q.g(intentResolveClient0, "intentResolveClient");
        super();
        this.contextInfo = contextInfo0;
        this.applicationInfo = applicationInfo0;
        this.intentResolveClient = intentResolveClient0;
    }

    public KakaoTalkShareIntentClient(ContextInfo contextInfo0, ApplicationInfo applicationInfo0, IntentResolveClient intentResolveClient0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            contextInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 2) != 0) {
            applicationInfo0 = KakaoSdk.INSTANCE.getApplicationContextInfo();
        }
        if((v & 4) != 0) {
            intentResolveClient0 = IntentResolveClient.Companion.getInstance();
        }
        this(contextInfo0, applicationInfo0, intentResolveClient0);
    }

    private final int attachmentSize(String s, ValidationResult validationResult0, Map map0) {
        JsonElement jsonElement0 = (JsonElement)validationResult0.getTemplateMsg().get("P");
        JsonObject jsonObject0 = null;
        JsonObject jsonObject1 = jsonElement0 == null ? null : JsonElementKt.getJsonObject(jsonElement0);
        JsonElement jsonElement1 = (JsonElement)validationResult0.getTemplateMsg().get("C");
        if(jsonElement1 != null) {
            jsonObject0 = JsonElementKt.getJsonObject(jsonElement1);
        }
        KakaoTalkSharingAttachment kakaoTalkSharingAttachment0 = new KakaoTalkSharingAttachment(null, null, s, jsonObject1, jsonObject0, validationResult0.getTemplateId(), validationResult0.getTemplateArgs(), this.extrasWithServerCallbacks(this.contextInfo.getExtras(), map0), 3, null);
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        return json0.encodeToString(KakaoTalkSharingAttachment.Companion.serializer(), kakaoTalkSharingAttachment0).length();
    }

    private final JsonObject extrasWithServerCallbacks(JsonObject jsonObject0, Map map0) {
        if(map0 == null) {
            return jsonObject0;
        }
        JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
        JsonObjectBuilder jsonObjectBuilder1 = new JsonObjectBuilder();
        for(Object object0: map0.entrySet()) {
            String s = (String)((Map.Entry)object0).getKey();
            Object object1 = ((Map.Entry)object0).getValue();
            Json json0 = KakaoJson.INSTANCE.getJson();
            json0.getSerializersModule();
            jsonObjectBuilder1.put(s, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
        }
        jsonObjectBuilder0.put("lcba", jsonObjectBuilder1.build());
        return jsonObjectBuilder0.build();
    }

    @NotNull
    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    @NotNull
    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    @NotNull
    public final IntentResolveClient getIntentResolveClient() {
        return this.intentResolveClient;
    }

    public final boolean isKakaoTalkSharingAvailable(@NotNull Context context0) {
        q.g(context0, "context");
        Intent intent0 = new Intent("android.intent.action.VIEW", this.sharingUriBuilder().build());
        return this.intentResolveClient.resolveTalkIntent(context0, intent0) != null;
    }

    @NotNull
    public final SharingResult sharingResultFromResponse(@NotNull Context context0, @NotNull ValidationResult validationResult0, @Nullable Map map0) {
        q.g(context0, "context");
        q.g(validationResult0, "response");
        return KakaoTalkShareIntentClient.sharingResultFromResponse$default(this, context0, validationResult0, map0, null, null, 24, null);
    }

    @NotNull
    public final SharingResult sharingResultFromResponse(@NotNull Context context0, @NotNull ValidationResult validationResult0, @Nullable Map map0, @NotNull String s) {
        q.g(context0, "context");
        q.g(validationResult0, "response");
        q.g(s, "appKey");
        return KakaoTalkShareIntentClient.sharingResultFromResponse$default(this, context0, validationResult0, map0, s, null, 16, null);
    }

    @NotNull
    public final SharingResult sharingResultFromResponse(@NotNull Context context0, @NotNull ValidationResult validationResult0, @Nullable Map map0, @NotNull String s, @NotNull String s1) {
        q.g(context0, "context");
        q.g(validationResult0, "response");
        q.g(s, "appKey");
        q.g(s1, "appVer");
        int v = this.attachmentSize(s, validationResult0, map0);
        if(v > 0x2800) {
            throw new ClientError(ClientErrorCause.BadParameter, "KakaoTalk Share intent size is " + v + " bytes. It should be less than 10240 bytes.");
        }
        Uri uri0 = this.sharingUriBuilder().appendQueryParameter("linkver", "4.0").appendQueryParameter("appkey", s).appendQueryParameter("appver", s1).appendQueryParameter("template_id", String.valueOf(validationResult0.getTemplateId())).appendQueryParameter("template_args", String.valueOf(validationResult0.getTemplateArgs())).appendQueryParameter("template_json", validationResult0.getTemplateMsg().toString()).appendQueryParameter("extras", this.extrasWithServerCallbacks(this.contextInfo.getExtras(), map0).toString()).build();
        SdkLog.Companion.i(uri0);
        Intent intent0 = new Intent("android.intent.action.SEND", uri0).addFlags(0x14000000);
        q.f(intent0, "Intent(Intent.ACTION_SEN….FLAG_ACTIVITY_CLEAR_TOP)");
        if(this.intentResolveClient.resolveTalkIntent(context0, intent0) == null) {
            throw new ClientError(ClientErrorCause.NotSupported, "Kakaotalk not installed");
        }
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        Map map1 = (Map)json0.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), String.valueOf(validationResult0.getWarningMsg()));
        Json json1 = KakaoJson.INSTANCE.getJson();
        json1.getSerializersModule();
        return new SharingResult(intent0, map1, ((Map)json1.decodeFromString(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), String.valueOf(validationResult0.getArgumentMsg()))));
    }

    public static SharingResult sharingResultFromResponse$default(KakaoTalkShareIntentClient kakaoTalkShareIntentClient0, Context context0, ValidationResult validationResult0, Map map0, String s, String s1, int v, Object object0) {
        if((v & 8) != 0) {
            s = kakaoTalkShareIntentClient0.applicationInfo.getAppKey();
        }
        if((v & 16) != 0) {
            s1 = kakaoTalkShareIntentClient0.contextInfo.getAppVer();
        }
        return kakaoTalkShareIntentClient0.sharingResultFromResponse(context0, validationResult0, map0, s, s1);
    }

    private final Uri.Builder sharingUriBuilder() {
        return new Uri.Builder().scheme("kakaolink").authority("send");
    }
}

