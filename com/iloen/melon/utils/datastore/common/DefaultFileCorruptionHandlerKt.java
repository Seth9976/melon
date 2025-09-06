package com.iloen.melon.utils.datastore.common;

import Vc.B;
import com.iloen.melon.player.playlist.common.h;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l2.c0;
import m2.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A#\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001A#\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0003\u0010\u0006\u001A#\u0010\u0003\u001A\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0003\u0010\b\u001A\u0013\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\u0002¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"T", "Ll2/c0;", "Lm2/a;", "getDefaultFileCorruptionHandler", "(Ll2/c0;)Lm2/a;", "Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;", "(Lcom/iloen/melon/utils/datastore/common/MelonDatastoreSerializer;)Lm2/a;", "Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;", "(Lcom/iloen/melon/utils/datastore/common/MelonEncryptedDatastoreSerializer;)Lm2/a;", "Lq2/h;", "getDefaultPreferenceFileCorruptionHandler", "()Lm2/a;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class DefaultFileCorruptionHandlerKt {
    @NotNull
    public static final a getDefaultFileCorruptionHandler(@NotNull MelonDatastoreSerializer melonDatastoreSerializer0) {
        q.g(melonDatastoreSerializer0, "<this>");
        return new a(new B(melonDatastoreSerializer0, 21));
    }

    @NotNull
    public static final a getDefaultFileCorruptionHandler(@NotNull MelonEncryptedDatastoreSerializer melonEncryptedDatastoreSerializer0) {
        q.g(melonEncryptedDatastoreSerializer0, "<this>");
        return new a(new B(melonEncryptedDatastoreSerializer0, 22));
    }

    @NotNull
    public static final a getDefaultFileCorruptionHandler(@NotNull c0 c00) {
        q.g(c00, "<this>");
        return new a(new B(c00, 23));
    }

    @NotNull
    public static final a getDefaultPreferenceFileCorruptionHandler() {
        return new a(new h(23));
    }
}

