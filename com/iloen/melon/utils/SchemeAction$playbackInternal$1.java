package com.iloen.melon.utils;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.utils.SchemeAction", f = "SchemeAction.kt", l = {73, 84, 109, 0x92, 0x93}, m = "playbackInternal")
final class SchemeAction.playbackInternal.1 extends c {
    public String B;
    public int D;
    public Object E;
    public final SchemeAction G;
    public int I;
    public Uri r;
    public String w;

    public SchemeAction.playbackInternal.1(SchemeAction schemeAction0, Continuation continuation0) {
        this.G = schemeAction0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.E = object0;
        this.I |= 0x80000000;
        return SchemeAction.access$playbackInternal(this.G, null, this);
    }
}

