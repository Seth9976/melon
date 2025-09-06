package com.iloen.melon.utils.datastore;

import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository", f = "SmartPlaylistServerSyncPreferencesRepository.kt", l = {0xAF}, m = "debugAfterUpdate")
final class SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1 extends c {
    public final SmartPlaylistServerSyncPreferencesRepository B;
    public int D;
    public LogU r;
    public Object w;

    public SmartPlaylistServerSyncPreferencesRepository.debugAfterUpdate.1(SmartPlaylistServerSyncPreferencesRepository smartPlaylistServerSyncPreferencesRepository0, Continuation continuation0) {
        this.B = smartPlaylistServerSyncPreferencesRepository0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return SmartPlaylistServerSyncPreferencesRepository.access$debugAfterUpdate(this.B, this);
    }
}

