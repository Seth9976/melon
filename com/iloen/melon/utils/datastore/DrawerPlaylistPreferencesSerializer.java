package com.iloen.melon.utils.datastore;

import com.iloen.melon.MusicDrawerPreferences;
import com.iloen.melon.c;
import com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001J\u0013\u0010\u0004\u001A\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001C\u0010\b\u001A\u00060\u0002j\u0002`\u00032\u0006\u0010\u0007\u001A\u00020\u0006H\u0096@¢\u0006\u0004\b\b\u0010\tJ\u001C\u0010\u000B\u001A\u00020\u00062\n\u0010\n\u001A\u00060\u0002j\u0002`\u0003H\u0096@¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferencesSerializer;", "Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;", "Lcom/iloen/melon/MusicDrawerPreferences;", "Lcom/iloen/melon/utils/datastore/DrawerPlaylistPreferences;", "createDefaultValue", "()Lcom/iloen/melon/MusicDrawerPreferences;", "", "byteArray", "byteArrayToValue", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "valueToByteArray", "(Lcom/iloen/melon/MusicDrawerPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistPreferencesSerializer extends MelonEncryptedDatastoreSerializer {
    public static final int $stable;
    @NotNull
    public static final DrawerPlaylistPreferencesSerializer INSTANCE;

    static {
        DrawerPlaylistPreferencesSerializer.INSTANCE = new DrawerPlaylistPreferencesSerializer();  // 初始化器: Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;-><init>()V
        DrawerPlaylistPreferencesSerializer.$stable = 8;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    @Nullable
    public Object byteArrayToValue(@NotNull byte[] arr_b, @NotNull Continuation continuation0) {
        MusicDrawerPreferences musicDrawerPreferences0 = MusicDrawerPreferences.parseFrom(arr_b);
        q.f(musicDrawerPreferences0, "parseFrom(...)");
        return musicDrawerPreferences0;
    }

    @NotNull
    public MusicDrawerPreferences createDefaultValue() {
        c c0 = MusicDrawerPreferences.newBuilder();
        c0.d();
        ((MusicDrawerPreferences)c0.b).setViewModeStr("LIST");
        c0.d();
        ((MusicDrawerPreferences)c0.b).setLastTab("MADE_BY_ME");
        return (MusicDrawerPreferences)c0.a();
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    public Object createDefaultValue() {
        return this.createDefaultValue();
    }

    @Nullable
    public Object valueToByteArray(@NotNull MusicDrawerPreferences musicDrawerPreferences0, @NotNull Continuation continuation0) {
        byte[] arr_b = musicDrawerPreferences0.toByteArray();
        q.f(arr_b, "toByteArray(...)");
        return arr_b;
    }

    @Override  // com.iloen.melon.utils.datastore.common.MelonEncryptedDatastoreSerializer
    public Object valueToByteArray(Object object0, Continuation continuation0) {
        return this.valueToByteArray(((MusicDrawerPreferences)object0), continuation0);
    }
}

