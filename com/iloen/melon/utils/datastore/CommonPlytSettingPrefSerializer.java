package com.iloen.melon.utils.datastore;

import com.iloen.melon.CommonPlytSettingPreferences;
import com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer;
import k8.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/datastore/CommonPlytSettingPrefSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;", "Lcom/iloen/melon/CommonPlytSettingPreferences;", "createDefaultValue", "()Lcom/iloen/melon/CommonPlytSettingPreferences;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Lcom/iloen/melon/CommonPlytSettingPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CommonPlytSettingPrefSerializer extends MelonDatastoreSerializer {
    public static final int $stable;
    @NotNull
    public static final CommonPlytSettingPrefSerializer INSTANCE;

    static {
        CommonPlytSettingPrefSerializer.INSTANCE = new CommonPlytSettingPrefSerializer();  // 初始化器: Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;-><init>()V
        CommonPlytSettingPrefSerializer.$stable = 8;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        CommonPlytSettingPreferences commonPlytSettingPreferences0 = CommonPlytSettingPreferences.parseFrom(arr_b);
        q.f(commonPlytSettingPreferences0, "parseFrom(...)");
        return commonPlytSettingPreferences0;
    }

    @NotNull
    public CommonPlytSettingPreferences createDefaultValue() {
        d d0 = CommonPlytSettingPreferences.newBuilder();
        d0.d();
        ((CommonPlytSettingPreferences)d0.b).setRepeatMode(0);
        d0.d();
        ((CommonPlytSettingPreferences)d0.b).setIsShuffle(false);
        return (CommonPlytSettingPreferences)d0.a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull CommonPlytSettingPreferences commonPlytSettingPreferences0, @NotNull Continuation continuation0) {
        byte[] arr_b = commonPlytSettingPreferences0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((CommonPlytSettingPreferences)object0), continuation0);
    }
}

