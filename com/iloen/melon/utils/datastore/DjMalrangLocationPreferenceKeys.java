package com.iloen.melon.utils.datastore;

import df.v;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import q2.f;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001R\u001D\u0010\b\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001A\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/datastore/DjMalrangLocationPreferenceKeys;", "", "Lq2/f;", "", "a", "Lq2/f;", "getLAST_SHOWN_TIMESTAMP", "()Lq2/f;", "LAST_SHOWN_TIMESTAMP", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjMalrangLocationPreferenceKeys {
    public static final int $stable;
    @NotNull
    public static final DjMalrangLocationPreferenceKeys INSTANCE;
    public static final f a;

    static {
        DjMalrangLocationPreferenceKeys.INSTANCE = new DjMalrangLocationPreferenceKeys();  // 初始化器: Ljava/lang/Object;-><init>()V
        DjMalrangLocationPreferenceKeys.a = v.B("last_shown_timestamp");
        DjMalrangLocationPreferenceKeys.$stable = 8;
    }

    @NotNull
    public final f getLAST_SHOWN_TIMESTAMP() {
        return DjMalrangLocationPreferenceKeys.a;
    }
}

