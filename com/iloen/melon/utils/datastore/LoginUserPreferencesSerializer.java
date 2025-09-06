package com.iloen.melon.utils.datastore;

import com.iloen.melon.LoginUser;
import com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer;
import k8.s;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/datastore/LoginUserPreferencesSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;", "Lcom/iloen/melon/LoginUser;", "createDefaultValue", "()Lcom/iloen/melon/LoginUser;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Lcom/iloen/melon/LoginUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LoginUserPreferencesSerializer extends MelonEncryptedDatastoreSerializer {
    public static final int $stable;
    @NotNull
    public static final LoginUserPreferencesSerializer INSTANCE;

    static {
        LoginUserPreferencesSerializer.INSTANCE = new LoginUserPreferencesSerializer();  // 初始化器: Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;-><init>()V
        LoginUserPreferencesSerializer.$stable = 8;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        LoginUser loginUser0 = LoginUser.parseFrom(arr_b);
        q.f(loginUser0, "parseFrom(...)");
        return loginUser0;
    }

    @NotNull
    public LoginUser createDefaultValue() {
        s s0 = LoginUser.newBuilder();
        s0.d();
        ((LoginUser)s0.b).setUserId("");
        s0.d();
        ((LoginUser)s0.b).setToken("");
        s0.d();
        ((LoginUser)s0.b).setLoginType("0");
        s0.d();
        ((LoginUser)s0.b).setMemberKey("0");
        s0.d();
        ((LoginUser)s0.b).setMemberType(0);
        s0.d();
        ((LoginUser)s0.b).setAdultFlagType("0");
        s0.m(false);
        s0.d();
        ((LoginUser)s0.b).setArtistId("");
        s0.d();
        ((LoginUser)s0.b).setSessionId("");
        s0.l(false);
        s0.d();
        ((LoginUser)s0.b).setTmpCall("");
        s0.i("");
        s0.d();
        ((LoginUser)s0.b).setMin("");
        s0.k(false);
        s0.d();
        ((LoginUser)s0.b).setMemberImageUrl("");
        s0.n("");
        s0.d();
        ((LoginUser)s0.b).setBnrSgmt("");
        s0.j(false);
        s0.d();
        ((LoginUser)s0.b).setHifiProdType("4");
        s0.d();
        ((LoginUser)s0.b).setProductInfo("");
        s0.d();
        ((LoginUser)s0.b).setDisplayUserId("");
        s0.d();
        ((LoginUser)s0.b).setAutoLoginSuccessTime(-1L);
        s0.d();
        LoginUser.i(((LoginUser)s0.b));
        return (LoginUser)s0.a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull LoginUser loginUser0, @NotNull Continuation continuation0) {
        byte[] arr_b = loginUser0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((LoginUser)object0), continuation0);
    }
}

