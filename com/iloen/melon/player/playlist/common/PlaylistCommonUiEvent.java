package com.iloen.melon.player.playlist.common;

import com.melon.ui.I4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.a;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistCommonUiEvent;", "Lcom/melon/ui/I4;", "ShowSelectionRepeatInterruptPopup", "Lcom/iloen/melon/player/playlist/common/PlaylistCommonUiEvent$ShowSelectionRepeatInterruptPopup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistCommonUiEvent implements I4 {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000E\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001A\u00020\u00002\u0010\b\u0002\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001F\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistCommonUiEvent$ShowSelectionRepeatInterruptPopup;", "Lcom/iloen/melon/player/playlist/common/PlaylistCommonUiEvent;", "Lkotlin/Function0;", "Lie/H;", "okAction", "<init>", "(Lwe/a;)V", "component1", "()Lwe/a;", "copy", "(Lwe/a;)Lcom/iloen/melon/player/playlist/common/PlaylistCommonUiEvent$ShowSelectionRepeatInterruptPopup;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lwe/a;", "getOkAction", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ShowSelectionRepeatInterruptPopup extends PlaylistCommonUiEvent {
        public static final int $stable;
        public final a a;

        public ShowSelectionRepeatInterruptPopup(@Nullable a a0) {
            super(null);
            this.a = a0;
        }

        @Nullable
        public final a component1() {
            return this.a;
        }

        @NotNull
        public final ShowSelectionRepeatInterruptPopup copy(@Nullable a a0) {
            return new ShowSelectionRepeatInterruptPopup(a0);
        }

        public static ShowSelectionRepeatInterruptPopup copy$default(ShowSelectionRepeatInterruptPopup playlistCommonUiEvent$ShowSelectionRepeatInterruptPopup0, a a0, int v, Object object0) {
            if((v & 1) != 0) {
                a0 = playlistCommonUiEvent$ShowSelectionRepeatInterruptPopup0.a;
            }
            return playlistCommonUiEvent$ShowSelectionRepeatInterruptPopup0.copy(a0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ShowSelectionRepeatInterruptPopup ? q.b(this.a, ((ShowSelectionRepeatInterruptPopup)object0).a) : false;
        }

        @Nullable
        public final a getOkAction() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "ShowSelectionRepeatInterruptPopup(okAction=" + this.a + ")";
        }
    }

    public static final int $stable;

    public PlaylistCommonUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

