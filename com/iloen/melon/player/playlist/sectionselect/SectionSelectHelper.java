package com.iloen.melon.player.playlist.sectionselect;

import android.content.Context;
import i.n.i.b.a.s.e.M3;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\b\'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001A\u00020\u00072\n\u0010\u0006\u001A\u00020\u0004\"\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\n\u001A\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u0003J\u001B\u0010\u000B\u001A\u00020\u00072\n\u0010\u0006\u001A\u00020\u0004\"\u00020\u0005H&¢\u0006\u0004\b\u000B\u0010\tJ\u000F\u0010\f\u001A\u00020\u0007H&¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\u000F\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\rH&¢\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001A\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001A\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0003J\u000F\u0010\u0019\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u0003J\u001B\u0010\u001A\u001A\u00020\u00072\n\u0010\u0006\u001A\u00020\u0004\"\u00020\u0005H\u0016¢\u0006\u0004\b\u001A\u0010\tJ\u0017\u0010\u001B\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\"\u0010$\u001A\u00020\u001D8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010\u001CR\"\u0010.\u001A\u00020\u00058\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b+\u0010&\u001A\u0004\b,\u0010(\"\u0004\b-\u0010\u001C¨\u0006/"}, d2 = {"Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectHelper;", "Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectable;", "<init>", "()V", "", "", "position", "Lie/H;", "selectItem", "([I)V", "showSectionSelectStart", "markedFirstView", "showSectionSelectEnd", "", "isCancel", "hideSectionSelectMode", "(Z)V", "Landroid/content/Context;", "context", "", "getDescritionTextForSectionSelect", "(Landroid/content/Context;)Ljava/lang/String;", "isSectionSelectMode", "()Z", "convertNormalMode", "convertSectionSelectMode", "selectStart", "selectEnd", "(I)V", "Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;", "a", "Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;", "getState", "()Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;", "setState", "(Lcom/iloen/melon/player/playlist/sectionselect/SectionSelectState;)V", "state", "b", "I", "getStartPos", "()I", "setStartPos", "startPos", "c", "getEndPos", "setEndPos", "endPos", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SectionSelectHelper implements SectionSelectable {
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[SectionSelectState.values().length];
            try {
                arr_v[SectionSelectState.STATE_IDLE.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[SectionSelectState.STATE_START_POSITION.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[SectionSelectState.STATE_END_POSITION.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 8;
    public SectionSelectState a;
    public int b;
    public int c;

    public SectionSelectHelper() {
        this.a = SectionSelectState.STATE_IDLE;
        this.b = -1;
        this.c = -1;
    }

    public final void a() {
        SectionSelectState sectionSelectState0;
        switch(WhenMappings.$EnumSwitchMapping$0[this.a.ordinal()]) {
            case 1: {
                sectionSelectState0 = SectionSelectState.STATE_START_POSITION;
                break;
            }
            case 2: {
                sectionSelectState0 = SectionSelectState.STATE_END_POSITION;
                break;
            }
            case 3: {
                sectionSelectState0 = SectionSelectState.STATE_IDLE;
                break;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
        this.a = sectionSelectState0;
    }

    public final void convertNormalMode() {
        this.a = SectionSelectState.STATE_IDLE;
        this.hideSectionSelectMode(true);
    }

    @Override  // com.iloen.melon.player.playlist.sectionselect.SectionSelectable
    public void convertSectionSelectMode() {
        this.a = SectionSelectState.STATE_START_POSITION;
        this.showSectionSelectStart();
    }

    @Nullable
    public final String getDescritionTextForSectionSelect(@Nullable Context context0) {
        SectionSelectState sectionSelectState0 = this.a;
        if(sectionSelectState0 == SectionSelectState.STATE_START_POSITION) {
            return context0 == null ? null : "구간선택 첫 번째 곡을 선택하세요.";
        }
        return sectionSelectState0 != SectionSelectState.STATE_END_POSITION || context0 == null ? null : "구간선택 마지막 곡을 선택하세요.";
    }

    public final int getEndPos() {
        return this.c;
    }

    public final int getStartPos() {
        return this.b;
    }

    @NotNull
    public final SectionSelectState getState() {
        return this.a;
    }

    public abstract void hideSectionSelectMode(boolean arg1);

    public final boolean isSectionSelectMode() {
        return SectionSelectState.Companion.isSectionSelectMode(this.a);
    }

    public abstract void markedFirstView(@NotNull int[] arg1);

    @Override  // com.iloen.melon.player.playlist.sectionselect.SectionSelectable
    public void selectEnd(int v) {
        this.c = v;
        int v1 = this.b;
        if(v1 > v) {
            this.performAfterProcess(v, v1);
        }
        else {
            this.performAfterProcess(v1, v);
        }
        this.hideSectionSelectMode(false);
    }

    public final void selectItem(@NotNull int[] arr_v) {
        q.g(arr_v, "position");
        switch(WhenMappings.$EnumSwitchMapping$0[this.a.ordinal()]) {
            case 1: {
                break;
            }
            case 2: {
                this.a();
                this.selectStart(Arrays.copyOf(arr_v, arr_v.length));
                break;
            }
            case 3: {
                this.a();
                if(arr_v.length == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                this.selectEnd(arr_v[arr_v.length - 1]);
                return;
            }
            default: {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
        }
    }

    @Override  // com.iloen.melon.player.playlist.sectionselect.SectionSelectable
    public void selectStart(@NotNull int[] arr_v) {
        q.g(arr_v, "position");
        if(arr_v.length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        this.b = arr_v[0];
        this.showSectionSelectEnd();
        this.markedFirstView(Arrays.copyOf(arr_v, arr_v.length));
    }

    public final void setEndPos(int v) {
        this.c = v;
    }

    public final void setStartPos(int v) {
        this.b = v;
    }

    public final void setState(@NotNull SectionSelectState sectionSelectState0) {
        q.g(sectionSelectState0, "<set-?>");
        this.a = sectionSelectState0;
    }

    public abstract void showSectionSelectEnd();

    public abstract void showSectionSelectStart();
}

