package com.kakao.sdk.user;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tg.d;
import vg.c;
import vg.e;
import vg.f;
import vg.o;
import vg.t;

@Keep
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0003\u0010\u0003\u001A\u00020\u00022\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00062\n\b\u0003\u0010\u0005\u001A\u0004\u0018\u00010\nH\'\u00A2\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0006H\'\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u000B0\u00062\b\b\u0001\u0010\u0005\u001A\u00020\nH\'\u00A2\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0006H\'\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0006H\'\u00A2\u0006\u0004\b\u0013\u0010\u0010J9\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u00062\n\b\u0003\u0010\u0015\u001A\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0016\u001A\u0004\u0018\u00010\u00042\n\b\u0003\u0010\u0018\u001A\u0004\u0018\u00010\u0017H\'\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\u001D0\u00062\n\b\u0003\u0010\u001C\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b\u001C\u0010\u001EJ\u001F\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001D0\u00062\b\b\u0001\u0010\u001C\u001A\u00020\u0004H\'\u00A2\u0006\u0004\b\u001F\u0010\u001EJ-\u0010#\u001A\b\u0012\u0004\u0012\u00020\"0\u00062\n\b\u0003\u0010 \u001A\u0004\u0018\u00010\u00042\n\b\u0003\u0010!\u001A\u0004\u0018\u00010\u0004H\'\u00A2\u0006\u0004\b#\u0010$J\u001F\u0010&\u001A\b\u0012\u0004\u0012\u00020%0\u00062\b\b\u0001\u0010 \u001A\u00020\u0004H\'\u00A2\u0006\u0004\b&\u0010\u001EJ\u0015\u0010\'\u001A\b\u0012\u0004\u0012\u00020\u000E0\u0006H\'\u00A2\u0006\u0004\b\'\u0010\u0010\u00A8\u0006("}, d2 = {"Lcom/kakao/sdk/user/UserApi;", "", "", "secureResource", "", "properties", "Ltg/d;", "Lcom/kakao/sdk/user/model/UserResponse;", "me", "(ZLjava/lang/String;)Ltg/d;", "Lkotlinx/serialization/json/JsonObject;", "Lie/H;", "signup", "(Lkotlinx/serialization/json/JsonObject;)Ltg/d;", "Lcom/kakao/sdk/user/model/AccessTokenInfo;", "accessTokenInfo", "()Ltg/d;", "updateProfile", "logout", "unlink", "", "addressId", "fromUpdatedAt", "", "pageSize", "Lcom/kakao/sdk/user/model/UserShippingAddresses;", "shippingAddresses", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)Ltg/d;", "scopes", "Lcom/kakao/sdk/user/model/ScopeInfo;", "(Ljava/lang/String;)Ltg/d;", "revokeScopes", "tags", "result", "Lcom/kakao/sdk/user/model/UserServiceTerms;", "serviceTerms", "(Ljava/lang/String;Ljava/lang/String;)Ltg/d;", "Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "revokeServiceTerms", "checkAccessToken", "user_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface UserApi {
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 0x30)
    public static final class DefaultImpls {
        public static d me$default(UserApi userApi0, boolean z, String s, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: me");
            }
            if((v & 1) != 0) {
                z = true;
            }
            if((v & 2) != 0) {
                s = null;
            }
            return userApi0.me(z, s);
        }

        public static d scopes$default(UserApi userApi0, String s, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scopes");
            }
            if((v & 1) != 0) {
                s = null;
            }
            return userApi0.scopes(s);
        }

        public static d serviceTerms$default(UserApi userApi0, String s, String s1, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: serviceTerms");
            }
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            return userApi0.serviceTerms(s, s1);
        }

        public static d shippingAddresses$default(UserApi userApi0, Long long0, String s, Integer integer0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: shippingAddresses");
            }
            if((v & 1) != 0) {
                long0 = null;
            }
            if((v & 2) != 0) {
                s = null;
            }
            if((v & 4) != 0) {
                integer0 = null;
            }
            return userApi0.shippingAddresses(long0, s, integer0);
        }

        public static d signup$default(UserApi userApi0, JsonObject jsonObject0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: signup");
            }
            if((v & 1) != 0) {
                jsonObject0 = null;
            }
            return userApi0.signup(jsonObject0);
        }
    }

    @NotNull
    @f("/v1/user/access_token_info")
    d accessTokenInfo();

    @NotNull
    @f("/v1/user/check_access_token")
    d checkAccessToken();

    @NotNull
    @o("/v1/user/logout")
    d logout();

    @NotNull
    @f("/v2/user/me")
    d me(@t("secure_resource") boolean arg1, @Nullable @t("property_keys") String arg2);

    @NotNull
    @e
    @o("/v2/user/revoke/scopes")
    d revokeScopes(@NotNull @c("scopes") String arg1);

    @NotNull
    @e
    @o("/v2/user/revoke/service_terms")
    d revokeServiceTerms(@NotNull @c("tags") String arg1);

    @NotNull
    @f("/v2/user/scopes")
    d scopes(@Nullable @t("scopes") String arg1);

    @NotNull
    @f("/v2/user/service_terms")
    d serviceTerms(@Nullable @t("tags") String arg1, @Nullable @t("result") String arg2);

    @NotNull
    @f("/v1/user/shipping_address")
    d shippingAddresses(@Nullable @t("address_id") Long arg1, @Nullable @t("from_updated_at") String arg2, @Nullable @t("page_size") Integer arg3);

    @NotNull
    @e
    @o("/v1/user/signup")
    d signup(@Nullable @c("properties") JsonObject arg1);

    @NotNull
    @o("/v1/user/unlink")
    d unlink();

    @NotNull
    @e
    @o("/v1/user/update_profile")
    d updateProfile(@NotNull @c("properties") JsonObject arg1);
}

