package com.kakao.sdk.share;

import android.content.Context;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.share.model.ImageUploadResult;
import com.kakao.sdk.share.model.SharingResult;
import com.kakao.sdk.share.model.ValidationResult;
import com.kakao.sdk.template.model.DefaultTemplate;
import d3.g;
import ie.j;
import java.io.File;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\u0018\u0000 .2\u00020\u0001:\u0001.B\u001B\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\b\u00A2\u0006\u0004\b\u000B\u0010\fJm\u0010\u0018\u001A\u00020\u00162\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\r2\u0016\b\u0002\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F2\u0016\b\u0002\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F2\u001C\u0010\u0017\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0013H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019JU\u0010\u001C\u001A\u00020\u00162\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\u001A2\u0016\b\u0002\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F2\u001C\u0010\u0017\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0013H\u0007\u00A2\u0006\u0004\b\u001C\u0010\u001DJy\u0010\u001F\u001A\u00020\u00162\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u001E\u001A\u00020\u00102\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0011\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F2\u0016\b\u0002\u0010\u0012\u001A\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000F2\u001C\u0010\u0017\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0013H\u0007\u00A2\u0006\u0004\b\u001F\u0010 J?\u0010%\u001A\u00020\u00162\u0006\u0010\"\u001A\u00020!2\b\b\u0002\u0010#\u001A\u00020\n2\u001C\u0010\u0017\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0013H\u0007\u00A2\u0006\u0004\b%\u0010&J?\u0010(\u001A\u00020\u00162\u0006\u0010\'\u001A\u00020\u00102\b\b\u0002\u0010#\u001A\u00020\n2\u001C\u0010\u0017\u001A\u0018\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u0013H\u0007\u00A2\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010*R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b\u0005\u0010+\u001A\u0004\b,\u0010-\u00A8\u0006/"}, d2 = {"Lcom/kakao/sdk/share/ShareClient;", "", "Lcom/kakao/sdk/share/ShareApi;", "shareApi", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "kakaotalkShareIntentClient", "<init>", "(Lcom/kakao/sdk/share/ShareApi;Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;)V", "Landroid/content/Context;", "context", "", "isKakaoTalkSharingAvailable", "(Landroid/content/Context;)Z", "", "templateId", "", "", "templateArgs", "serverCallbackArgs", "Lkotlin/Function2;", "Lcom/kakao/sdk/share/model/SharingResult;", "", "Lie/H;", "callback", "shareCustom", "(Landroid/content/Context;JLjava/util/Map;Ljava/util/Map;Lwe/n;)V", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "defaultTemplate", "shareDefault", "(Landroid/content/Context;Lcom/kakao/sdk/template/model/DefaultTemplate;Ljava/util/Map;Lwe/n;)V", "url", "shareScrap", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Lwe/n;)V", "Ljava/io/File;", "image", "secureResource", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "uploadImage", "(Ljava/io/File;ZLwe/n;)V", "imageUrl", "scrapImage", "(Ljava/lang/String;ZLwe/n;)V", "Lcom/kakao/sdk/share/ShareApi;", "Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "getKakaotalkShareIntentClient", "()Lcom/kakao/sdk/share/KakaoTalkShareIntentClient;", "Companion", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ShareClient {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R!\u0010\n\u001A\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001A\u0004\b\u0007\u0010\b¨\u0006\u000B"}, d2 = {"Lcom/kakao/sdk/share/ShareClient$Companion;", "", "<init>", "()V", "Lcom/kakao/sdk/share/ShareClient;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/share/ShareClient;", "getInstance$annotations", "instance", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ShareClient getInstance() {
            return (ShareClient)ShareClient.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private final KakaoTalkShareIntentClient kakaotalkShareIntentClient;
    @NotNull
    private final ShareApi shareApi;

    static {
        ShareClient.Companion = new Companion(null);
        ShareClient.instance$delegate = g.Q(ShareClient.Companion.instance.2.INSTANCE);
    }

    public ShareClient() {
        this(null, null, 3, null);
    }

    public ShareClient(@NotNull ShareApi shareApi0, @NotNull KakaoTalkShareIntentClient kakaoTalkShareIntentClient0) {
        q.g(shareApi0, "shareApi");
        q.g(kakaoTalkShareIntentClient0, "kakaotalkShareIntentClient");
        super();
        this.shareApi = shareApi0;
        this.kakaotalkShareIntentClient = kakaoTalkShareIntentClient0;
    }

    public ShareClient(ShareApi shareApi0, KakaoTalkShareIntentClient kakaoTalkShareIntentClient0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            Object object0 = ApiFactory.INSTANCE.getKapi().b(ShareApi.class);
            q.f(object0, "ApiFactory.kapi.create(ShareApi::class.java)");
            shareApi0 = (ShareApi)object0;
        }
        if((v & 2) != 0) {
            kakaoTalkShareIntentClient0 = KakaoTalkShareIntentClient.Companion.getInstance();
        }
        this(shareApi0, kakaoTalkShareIntentClient0);
    }

    @NotNull
    public static final ShareClient getInstance() {
        return ShareClient.Companion.getInstance();
    }

    @NotNull
    public final KakaoTalkShareIntentClient getKakaotalkShareIntentClient() {
        return this.kakaotalkShareIntentClient;
    }

    public final boolean isKakaoTalkSharingAvailable(@NotNull Context context0) {
        q.g(context0, "context");
        return this.kakaotalkShareIntentClient.isKakaoTalkSharingAvailable(context0);
    }

    public final void scrapImage(@NotNull String s, @NotNull n n0) {
        q.g(s, "imageUrl");
        q.g(n0, "callback");
        ShareClient.scrapImage$default(this, s, false, n0, 2, null);
    }

    public final void scrapImage(@NotNull String s, boolean z, @NotNull n n0) {
        q.g(s, "imageUrl");
        q.g(n0, "callback");
        this.shareApi.scrapImage(s, Boolean.valueOf(z)).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ImageUploadResult imageUploadResult0, @Nullable Throwable throwable0) {
                this.$callback.invoke(imageUploadResult0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ImageUploadResult)object0), throwable0);
            }
        });
    }

    public static void scrapImage$default(ShareClient shareClient0, String s, boolean z, n n0, int v, Object object0) {
        if((v & 2) != 0) {
            z = true;
        }
        shareClient0.scrapImage(s, z, n0);
    }

    public final void shareCustom(@NotNull Context context0, long v, @Nullable Map map0, @Nullable Map map1, @NotNull n n0) {
        JsonObject jsonObject0;
        q.g(context0, "context");
        q.g(n0, "callback");
        ShareApi shareApi0 = this.shareApi;
        if(map0 == null) {
            jsonObject0 = null;
        }
        else {
            JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
            for(Object object0: map0.entrySet()) {
                String s = (String)((Map.Entry)object0).getKey();
                Object object1 = ((Map.Entry)object0).getValue();
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                jsonObjectBuilder0.put(s, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
            }
            jsonObject0 = jsonObjectBuilder0.build();
        }
        shareApi0.validateCustom(v, jsonObject0).enqueue(new ApiCallback(this, context0, map1) {
            final n $callback;
            final Context $context;
            final Map $serverCallbackArgs;

            {
                this.$callback = n0;
                ShareClient.this = shareClient0;
                this.$context = context0;
                this.$serverCallbackArgs = map0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ValidationResult validationResult0, @Nullable Throwable throwable0) {
                if(validationResult0 != null) {
                    try {
                        SharingResult sharingResult0 = KakaoTalkShareIntentClient.sharingResultFromResponse$default(ShareClient.this.getKakaotalkShareIntentClient(), this.$context, validationResult0, this.$serverCallbackArgs, null, null, 24, null);
                        this.$callback.invoke(sharingResult0, null);
                    }
                    catch(Throwable throwable1) {
                        this.$callback.invoke(null, throwable1);
                    }
                    return;
                }
                this.$callback.invoke(null, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ValidationResult)object0), throwable0);
            }
        });
    }

    public final void shareCustom(@NotNull Context context0, long v, @Nullable Map map0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        ShareClient.shareCustom$default(this, context0, v, map0, null, n0, 8, null);
    }

    public final void shareCustom(@NotNull Context context0, long v, @NotNull n n0) {
        q.g(context0, "context");
        q.g(n0, "callback");
        ShareClient.shareCustom$default(this, context0, v, null, null, n0, 12, null);
    }

    public static void shareCustom$default(ShareClient shareClient0, Context context0, long v, Map map0, Map map1, n n0, int v1, Object object0) {
        if((v1 & 4) != 0) {
            map0 = null;
        }
        if((v1 & 8) != 0) {
            map1 = null;
        }
        shareClient0.shareCustom(context0, v, map0, map1, n0);
    }

    public final void shareDefault(@NotNull Context context0, @NotNull DefaultTemplate defaultTemplate0, @Nullable Map map0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(defaultTemplate0, "defaultTemplate");
        q.g(n0, "callback");
        Json json0 = KakaoJson.INSTANCE.getJson();
        json0.getSerializersModule();
        String s = json0.encodeToString(DefaultTemplate.Companion.serializer(), defaultTemplate0);
        this.shareApi.validateDefault(s).enqueue(new ApiCallback(this, context0, map0) {
            final n $callback;
            final Context $context;
            final Map $serverCallbackArgs;

            {
                this.$callback = n0;
                ShareClient.this = shareClient0;
                this.$context = context0;
                this.$serverCallbackArgs = map0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ValidationResult validationResult0, @Nullable Throwable throwable0) {
                if(validationResult0 != null) {
                    try {
                        SharingResult sharingResult0 = KakaoTalkShareIntentClient.sharingResultFromResponse$default(ShareClient.this.getKakaotalkShareIntentClient(), this.$context, validationResult0, this.$serverCallbackArgs, null, null, 24, null);
                        this.$callback.invoke(sharingResult0, null);
                    }
                    catch(Throwable throwable1) {
                        this.$callback.invoke(null, throwable1);
                    }
                    return;
                }
                this.$callback.invoke(null, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ValidationResult)object0), throwable0);
            }
        });
    }

    public final void shareDefault(@NotNull Context context0, @NotNull DefaultTemplate defaultTemplate0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(defaultTemplate0, "defaultTemplate");
        q.g(n0, "callback");
        ShareClient.shareDefault$default(this, context0, defaultTemplate0, null, n0, 4, null);
    }

    public static void shareDefault$default(ShareClient shareClient0, Context context0, DefaultTemplate defaultTemplate0, Map map0, n n0, int v, Object object0) {
        if((v & 4) != 0) {
            map0 = null;
        }
        shareClient0.shareDefault(context0, defaultTemplate0, map0, n0);
    }

    public final void shareScrap(@NotNull Context context0, @NotNull String s, @Nullable Long long0, @Nullable Map map0, @Nullable Map map1, @NotNull n n0) {
        JsonObject jsonObject0;
        q.g(context0, "context");
        q.g(s, "url");
        q.g(n0, "callback");
        ShareApi shareApi0 = this.shareApi;
        if(map0 == null) {
            jsonObject0 = null;
        }
        else {
            JsonObjectBuilder jsonObjectBuilder0 = new JsonObjectBuilder();
            for(Object object0: map0.entrySet()) {
                String s1 = (String)((Map.Entry)object0).getKey();
                Object object1 = ((Map.Entry)object0).getValue();
                Json json0 = KakaoJson.INSTANCE.getJson();
                json0.getSerializersModule();
                jsonObjectBuilder0.put(s1, json0.encodeToJsonElement(StringSerializer.INSTANCE, object1));
            }
            jsonObject0 = jsonObjectBuilder0.build();
        }
        shareApi0.validateScrap(s, long0, jsonObject0).enqueue(new ApiCallback(this, context0, map1) {
            final n $callback;
            final Context $context;
            final Map $serverCallbackArgs;

            {
                this.$callback = n0;
                ShareClient.this = shareClient0;
                this.$context = context0;
                this.$serverCallbackArgs = map0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ValidationResult validationResult0, @Nullable Throwable throwable0) {
                if(validationResult0 != null) {
                    try {
                        SharingResult sharingResult0 = KakaoTalkShareIntentClient.sharingResultFromResponse$default(ShareClient.this.getKakaotalkShareIntentClient(), this.$context, validationResult0, this.$serverCallbackArgs, null, null, 24, null);
                        this.$callback.invoke(sharingResult0, null);
                    }
                    catch(Throwable throwable1) {
                        this.$callback.invoke(null, throwable1);
                    }
                    return;
                }
                this.$callback.invoke(null, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ValidationResult)object0), throwable0);
            }
        });
    }

    public final void shareScrap(@NotNull Context context0, @NotNull String s, @Nullable Long long0, @Nullable Map map0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(s, "url");
        q.g(n0, "callback");
        ShareClient.shareScrap$default(this, context0, s, long0, map0, null, n0, 16, null);
    }

    public final void shareScrap(@NotNull Context context0, @NotNull String s, @Nullable Long long0, @NotNull n n0) {
        q.g(context0, "context");
        q.g(s, "url");
        q.g(n0, "callback");
        ShareClient.shareScrap$default(this, context0, s, long0, null, null, n0, 24, null);
    }

    public final void shareScrap(@NotNull Context context0, @NotNull String s, @NotNull n n0) {
        q.g(context0, "context");
        q.g(s, "url");
        q.g(n0, "callback");
        ShareClient.shareScrap$default(this, context0, s, null, null, null, n0, 28, null);
    }

    public static void shareScrap$default(ShareClient shareClient0, Context context0, String s, Long long0, Map map0, Map map1, n n0, int v, Object object0) {
        if((v & 4) != 0) {
            long0 = null;
        }
        if((v & 8) != 0) {
            map0 = null;
        }
        if((v & 16) != 0) {
            map1 = null;
        }
        shareClient0.shareScrap(context0, s, long0, map0, map1, n0);
    }

    public final void uploadImage(@NotNull File file0, @NotNull n n0) {
        q.g(file0, "image");
        q.g(n0, "callback");
        ShareClient.uploadImage$default(this, file0, false, n0, 2, null);
    }

    public final void uploadImage(@NotNull File file0, boolean z, @NotNull n n0) {
        q.g(file0, "image");
        q.g(n0, "callback");
        String s = file0.getName();
        MediaType mediaType0 = MediaType.Companion.get("image/*");
        RequestBody requestBody0 = RequestBody.Companion.create(file0, mediaType0);
        Part multipartBody$Part0 = Part.Companion.createFormData("file", s, requestBody0);
        this.shareApi.uploadImage(multipartBody$Part0, Boolean.valueOf(z)).enqueue(new ApiCallback() {
            final n $callback;

            {
                this.$callback = n0;
                super(false, 1, null);
            }

            public void onComplete(@Nullable ImageUploadResult imageUploadResult0, @Nullable Throwable throwable0) {
                this.$callback.invoke(imageUploadResult0, throwable0);
            }

            @Override  // com.kakao.sdk.network.ApiCallback
            public void onComplete(Object object0, Throwable throwable0) {
                this.onComplete(((ImageUploadResult)object0), throwable0);
            }
        });
    }

    public static void uploadImage$default(ShareClient shareClient0, File file0, boolean z, n n0, int v, Object object0) {
        if((v & 2) != 0) {
            z = true;
        }
        shareClient0.uploadImage(file0, z, n0);
    }
}

