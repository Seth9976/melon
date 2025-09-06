package com.iloen.melon.utils.datastore;

import com.iloen.melon.EachPlytSettingPreferences;
import com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer;
import je.w;
import k8.r;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/datastore/EachPlytSettingPreferencesSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;", "Lcom/iloen/melon/EachPlytSettingPreferences;", "createDefaultValue", "()Lcom/iloen/melon/EachPlytSettingPreferences;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Lcom/iloen/melon/EachPlytSettingPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EachPlytSettingPreferencesSerializer extends MelonDatastoreSerializer {
    public static final int $stable;
    @NotNull
    public static final EachPlytSettingPreferencesSerializer INSTANCE;

    static {
        EachPlytSettingPreferencesSerializer.INSTANCE = new EachPlytSettingPreferencesSerializer();  // 初始化器: Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;-><init>()V
        EachPlytSettingPreferencesSerializer.$stable = 8;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        EachPlytSettingPreferences eachPlytSettingPreferences0 = EachPlytSettingPreferences.parseFrom(arr_b);
        q.f(eachPlytSettingPreferences0, "parseFrom(...)");
        return eachPlytSettingPreferences0;
    }

    @NotNull
    public EachPlytSettingPreferences createDefaultValue() {
        r r0 = EachPlytSettingPreferences.newBuilder();
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setLastUniqueId("");
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setPlayedTime(0L);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setSortType(0);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setSectionRepeatStartPos(-1);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).setSectionRepeatEndPos(-1);
        r0.d();
        ((EachPlytSettingPreferences)r0.b).addAllSelectedRepeatUniqueId(w.a);
        return (EachPlytSettingPreferences)r0.a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull EachPlytSettingPreferences eachPlytSettingPreferences0, @NotNull Continuation continuation0) {
        byte[] arr_b = eachPlytSettingPreferences0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((EachPlytSettingPreferences)object0), continuation0);
    }
}

