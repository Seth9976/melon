package com.iloen.melon.utils.ui;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import oe.c;
import oe.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
@e(c = "com.iloen.melon.utils.ui.MusicBrowserPopupHelper", f = "MusicBrowserPopupHelper.kt", l = {716}, m = "showNoticePopup")
final class MusicBrowserPopupHelper.showNoticePopup.1 extends c {
    public int B;
    public Object r;
    public final MusicBrowserPopupHelper w;

    public MusicBrowserPopupHelper.showNoticePopup.1(MusicBrowserPopupHelper musicBrowserPopupHelper0, Continuation continuation0) {
        this.w = musicBrowserPopupHelper0;
        super(continuation0);
    }

    @Override  // oe.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object object0) {
        this.r = object0;
        this.B |= 0x80000000;
        return MusicBrowserPopupHelper.access$showNoticePopup(this.w, null, this);
    }
}

