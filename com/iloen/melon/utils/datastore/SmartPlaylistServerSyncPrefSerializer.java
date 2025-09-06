package com.iloen.melon.utils.datastore;

import com.iloen.melon.SpServerSyncPreferences;
import com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer;
import k8.w1;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u0005H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\n\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u0002H\u0096@¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\r\u001A\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/utils/datastore/SmartPlaylistServerSyncPrefSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;", "Lcom/iloen/melon/SpServerSyncPreferences;", "createDefaultValue", "()Lcom/iloen/melon/SpServerSyncPreferences;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Lcom/iloen/melon/SpServerSyncPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "THRESHOLD_DEFAULT", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlaylistServerSyncPrefSerializer extends MelonEncryptedDatastoreSerializer {
    public static final int $stable = 0;
    @NotNull
    public static final SmartPlaylistServerSyncPrefSerializer INSTANCE = null;
    public static final int THRESHOLD_DEFAULT = 5;

    static {
        SmartPlaylistServerSyncPrefSerializer.INSTANCE = new SmartPlaylistServerSyncPrefSerializer();  // 初始化器: Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;-><init>()V
        SmartPlaylistServerSyncPrefSerializer.$stable = 8;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        SpServerSyncPreferences spServerSyncPreferences0 = SpServerSyncPreferences.parseFrom(arr_b);
        q.f(spServerSyncPreferences0, "parseFrom(...)");
        return spServerSyncPreferences0;
    }

    @NotNull
    public SpServerSyncPreferences createDefaultValue() {
        w1 w10 = SpServerSyncPreferences.newBuilder();
        w10.d();
        ((SpServerSyncPreferences)w10.b).setVersionDate(0L);
        w10.d();
        ((SpServerSyncPreferences)w10.b).setVersionThreshold(5);
        w10.d();
        ((SpServerSyncPreferences)w10.b).setMemberKey("0");
        w10.i(0);
        w10.d();
        ((SpServerSyncPreferences)w10.b).setLastHistoryReqDate("");
        return (SpServerSyncPreferences)w10.a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull SpServerSyncPreferences spServerSyncPreferences0, @NotNull Continuation continuation0) {
        byte[] arr_b = spServerSyncPreferences0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((SpServerSyncPreferences)object0), continuation0);
    }
}

