package com.iloen.melon.utils.datastore;

import com.iloen.melon.MixUpPreference;
import com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001A\u00020\u0002H\u0016J\u0016\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ\u0016\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0002H\u0096@¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/utils/datastore/MixUpPlaylistPreferenceSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;", "Lcom/iloen/melon/MixUpPreference;", "<init>", "()V", "createDefaultValue", "byteArrayToValue", "byteArray", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "valueToByteArray", "t", "(Lcom/iloen/melon/MixUpPreference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixUpPlaylistPreferenceSerializer extends MelonDatastoreSerializer {
    public static final int $stable = 8;

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        MixUpPreference mixUpPreference0 = MixUpPreference.parseFrom(arr_b);
        q.f(mixUpPreference0, "parseFrom(...)");
        return mixUpPreference0;
    }

    @NotNull
    public MixUpPreference createDefaultValue() {
        return (MixUpPreference)MixUpPreference.newBuilder().a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull MixUpPreference mixUpPreference0, @NotNull Continuation continuation0) {
        byte[] arr_b = mixUpPreference0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((MixUpPreference)object0), continuation0);
    }
}

