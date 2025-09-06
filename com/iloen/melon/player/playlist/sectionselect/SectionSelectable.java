package com.iloen.melon.player.playlist.sectionselect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\b\u001A\u00020\u00022\n\u0010\u0007\u001A\u00020\u0005\"\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001A\u00020\u00022\u0006\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\u00022\u0006\u0010\f\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u0006H&¢\u0006\u0004\b\u000E\u0010\u000F¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectable;", "", "Lie/H;", "convertSectionSelectMode", "()V", "", "", "position", "selectStart", "([I)V", "selectEnd", "(I)V", "startPosition", "endPosition", "performAfterProcess", "(II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SectionSelectable {
    void convertSectionSelectMode();

    void performAfterProcess(int arg1, int arg2);

    void selectEnd(int arg1);

    void selectStart(@NotNull int[] arg1);
}

