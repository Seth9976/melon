package com.iloen.melon.utils.datastore;

import com.iloen.melon.utils.log.LogU;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.utils.datastore.EachPlytSettingPreferencesRepository", f = "EachPlytSettingPreferencesRepository.kt", l = {0x87}, m = "debugAfterUpdate")
final class EachPlytSettingPreferencesRepository.debugAfterUpdate.1 extends c {
    public final EachPlytSettingPreferencesRepository B;
    public int D;
    public LogU r;
    public Object w;

    public EachPlytSettingPreferencesRepository.debugAfterUpdate.1(EachPlytSettingPreferencesRepository eachPlytSettingPreferencesRepository0, Continuation continuation0) {
        this.B = eachPlytSettingPreferencesRepository0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return EachPlytSettingPreferencesRepository.access$debugAfterUpdate(this.B, this);
    }
}

