package com.iloen.melon.utils.datastore;

import df.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import q2.f;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/datastore/PlaylistPreferenceKeys;", "", "Lq2/f;", "", "a", "Lq2/f;", "getMIGRATE_RESULT_TYPE", "()Lq2/f;", "MIGRATE_RESULT_TYPE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistPreferenceKeys {
    public static final int $stable;
    @NotNull
    public static final PlaylistPreferenceKeys INSTANCE;
    public static final f a;

    static {
        PlaylistPreferenceKeys.INSTANCE = new PlaylistPreferenceKeys();  // 初始化器: Ljava/lang/Object;-><init>()V
        PlaylistPreferenceKeys.a = v.K("migrate_return_type");
        PlaylistPreferenceKeys.$stable = 8;
    }

    @NotNull
    public final f getMIGRATE_RESULT_TYPE() {
        return PlaylistPreferenceKeys.a;
    }
}

