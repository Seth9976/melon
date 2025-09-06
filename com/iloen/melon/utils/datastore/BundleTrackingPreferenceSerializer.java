package com.iloen.melon.utils.datastore;

import com.iloen.melon.BundleTrackingPreference;
import com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/utils/datastore/BundleTrackingPreferenceSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;", "Lcom/iloen/melon/BundleTrackingPreference;", "createDefaultValue", "()Lcom/iloen/melon/BundleTrackingPreference;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Lcom/iloen/melon/BundleTrackingPreference;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class BundleTrackingPreferenceSerializer extends MelonDatastoreSerializer {
    public static final int $stable;
    @NotNull
    public static final BundleTrackingPreferenceSerializer INSTANCE;

    static {
        BundleTrackingPreferenceSerializer.INSTANCE = new BundleTrackingPreferenceSerializer();  // 初始化器: Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;-><init>()V
        BundleTrackingPreferenceSerializer.$stable = 8;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        BundleTrackingPreference bundleTrackingPreference0 = BundleTrackingPreference.parseFrom(arr_b);
        q.f(bundleTrackingPreference0, "parseFrom(...)");
        return bundleTrackingPreference0;
    }

    @NotNull
    public BundleTrackingPreference createDefaultValue() {
        return (BundleTrackingPreference)BundleTrackingPreference.newBuilder().a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull BundleTrackingPreference bundleTrackingPreference0, @NotNull Continuation continuation0) {
        byte[] arr_b = bundleTrackingPreference0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((BundleTrackingPreference)object0), continuation0);
    }
}

