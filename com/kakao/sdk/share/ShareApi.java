package com.kakao.sdk.share;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;
import okhttp3.MultipartBody.Part;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.d;
import vg.c;
import vg.e;
import vg.f;
import vg.l;
import vg.o;
import vg.q;
import vg.t;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\'¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000B\u001A\u00020\nH\'¢\u0006\u0004\b\f\u0010\rJ7\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\u000E\u001A\u00020\n2\n\b\u0003\u0010\u0003\u001A\u0004\u0018\u00010\u00022\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\'¢\u0006\u0004\b\u000F\u0010\u0010J+\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00150\u00062\b\b\u0001\u0010\u0012\u001A\u00020\u00112\n\b\u0003\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\'¢\u0006\u0004\b\u0016\u0010\u0017J+\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u00150\u00062\b\b\u0001\u0010\u0018\u001A\u00020\n2\n\b\u0003\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\'¢\u0006\u0004\b\u0019\u0010\u001A¨\u0006\u001B"}, d2 = {"Lcom/kakao/sdk/share/ShareApi;", "", "", "templateId", "Lkotlinx/serialization/json/JsonObject;", "templateArgs", "Ltg/d;", "Lcom/kakao/sdk/share/model/ValidationResult;", "validateCustom", "(JLkotlinx/serialization/json/JsonObject;)Ltg/d;", "", "templateObject", "validateDefault", "(Ljava/lang/String;)Ltg/d;", "url", "validateScrap", "(Ljava/lang/String;Ljava/lang/Long;Lkotlinx/serialization/json/JsonObject;)Ltg/d;", "Lokhttp3/MultipartBody$Part;", "image", "", "secureResource", "Lcom/kakao/sdk/share/model/ImageUploadResult;", "uploadImage", "(Lokhttp3/MultipartBody$Part;Ljava/lang/Boolean;)Ltg/d;", "imageUrl", "scrapImage", "(Ljava/lang/String;Ljava/lang/Boolean;)Ltg/d;", "share_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface ShareApi {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static d scrapImage$default(ShareApi shareApi0, String s, Boolean boolean0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrapImage");
            }
            if((v & 2) != 0) {
                boolean0 = Boolean.TRUE;
            }
            return shareApi0.scrapImage(s, boolean0);
        }

        public static d uploadImage$default(ShareApi shareApi0, Part multipartBody$Part0, Boolean boolean0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadImage");
            }
            if((v & 2) != 0) {
                boolean0 = Boolean.TRUE;
            }
            return shareApi0.uploadImage(multipartBody$Part0, boolean0);
        }

        public static d validateCustom$default(ShareApi shareApi0, long v, JsonObject jsonObject0, int v1, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateCustom");
            }
            if((v1 & 2) != 0) {
                jsonObject0 = null;
            }
            return shareApi0.validateCustom(v, jsonObject0);
        }

        public static d validateScrap$default(ShareApi shareApi0, String s, Long long0, JsonObject jsonObject0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: validateScrap");
            }
            if((v & 2) != 0) {
                long0 = null;
            }
            if((v & 4) != 0) {
                jsonObject0 = null;
            }
            return shareApi0.validateScrap(s, long0, jsonObject0);
        }
    }

    @NotNull
    @e
    @o("/v2/api/talk/message/image/scrap")
    d scrapImage(@NotNull @c("image_url") String arg1, @Nullable @c("secure_resource") Boolean arg2);

    @NotNull
    @l
    @o("/v2/api/talk/message/image/upload")
    d uploadImage(@NotNull @q Part arg1, @Nullable @q("secure_resource") Boolean arg2);

    @NotNull
    @f("/v2/api/kakaolink/talk/template/validate?link_ver=4.0")
    d validateCustom(@t("template_id") long arg1, @Nullable @t("template_args") JsonObject arg2);

    @NotNull
    @f("/v2/api/kakaolink/talk/template/default?link_ver=4.0")
    d validateDefault(@NotNull @t("template_object") String arg1);

    @NotNull
    @f("/v2/api/kakaolink/talk/template/scrap?link_ver=4.0")
    d validateScrap(@NotNull @t("request_url") String arg1, @Nullable @t("template_id") Long arg2, @Nullable @t("template_args") JsonObject arg3);
}

