package com.iloen.melon.utils.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper", f = "MusicBrowserPopupHelper.kt", l = {433}, m = "isSimpleLoginBannerAvailable")
final class MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1 extends c {
    public final MusicBrowserPopupHelper B;
    public int D;
    public int r;
    public Object w;

    public MusicBrowserPopupHelper.isSimpleLoginBannerAvailable.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, Continuation continuation0) {
        this.B = musicBrowserPopupHelper0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.w = object0;
        this.D |= 0x80000000;
        return MusicBrowserPopupHelper.access$isSimpleLoginBannerAvailable(this.B, this);
    }
}

