package com.iloen.melon.playback.playlist.add;

import A7.d;
import androidx.appcompat.app.o;
import com.iloen.melon.constants.AddPosition;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\u0003¢\u0006\u0004\b\n\u0010\u000BJ\f\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00150\u0014J\t\u0010\u0016\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001A\u00020\bHÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J;\u0010\u001B\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u001C\u001A\u00020\u00032\b\u0010\u001D\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001E\u001A\u00020\u001FHÖ\u0001J\t\u0010 \u001A\u00020!HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0005\u001A\u00020\u0006¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\r¨\u0006\""}, d2 = {"Lcom/iloen/melon/playback/playlist/add/PlaylistAddData;", "", "clearBefore", "", "removeDuplicated", "addPlayableListInfo", "Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "position", "Lcom/iloen/melon/constants/AddPosition;", "isAddAndPlay", "<init>", "(ZZLcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;Lcom/iloen/melon/constants/AddPosition;Z)V", "getClearBefore", "()Z", "getRemoveDuplicated", "getAddPlayableListInfo", "()Lcom/iloen/melon/playback/playlist/add/AddRequestPlayableListInfo;", "getPosition", "()Lcom/iloen/melon/constants/AddPosition;", "getAddPlayableList", "", "Lcom/iloen/melon/playback/Playable;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistAddData {
    public static final int $stable = 8;
    @NotNull
    private final AddRequestPlayableListInfo addPlayableListInfo;
    private final boolean clearBefore;
    private final boolean isAddAndPlay;
    @NotNull
    private final AddPosition position;
    private final boolean removeDuplicated;

    public PlaylistAddData(boolean z, boolean z1, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull AddPosition addPosition0, boolean z2) {
        q.g(addRequestPlayableListInfo0, "addPlayableListInfo");
        q.g(addPosition0, "position");
        super();
        this.clearBefore = z;
        this.removeDuplicated = z1;
        this.addPlayableListInfo = addRequestPlayableListInfo0;
        this.position = addPosition0;
        this.isAddAndPlay = z2;
    }

    public final boolean component1() {
        return this.clearBefore;
    }

    public final boolean component2() {
        return this.removeDuplicated;
    }

    @NotNull
    public final AddRequestPlayableListInfo component3() {
        return this.addPlayableListInfo;
    }

    @NotNull
    public final AddPosition component4() {
        return this.position;
    }

    public final boolean component5() {
        return this.isAddAndPlay;
    }

    @NotNull
    public final PlaylistAddData copy(boolean z, boolean z1, @NotNull AddRequestPlayableListInfo addRequestPlayableListInfo0, @NotNull AddPosition addPosition0, boolean z2) {
        q.g(addRequestPlayableListInfo0, "addPlayableListInfo");
        q.g(addPosition0, "position");
        return new PlaylistAddData(z, z1, addRequestPlayableListInfo0, addPosition0, z2);
    }

    public static PlaylistAddData copy$default(PlaylistAddData playlistAddData0, boolean z, boolean z1, AddRequestPlayableListInfo addRequestPlayableListInfo0, AddPosition addPosition0, boolean z2, int v, Object object0) {
        if((v & 1) != 0) {
            z = playlistAddData0.clearBefore;
        }
        if((v & 2) != 0) {
            z1 = playlistAddData0.removeDuplicated;
        }
        if((v & 4) != 0) {
            addRequestPlayableListInfo0 = playlistAddData0.addPlayableListInfo;
        }
        if((v & 8) != 0) {
            addPosition0 = playlistAddData0.position;
        }
        if((v & 16) != 0) {
            z2 = playlistAddData0.isAddAndPlay;
        }
        return playlistAddData0.copy(z, z1, addRequestPlayableListInfo0, addPosition0, z2);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlaylistAddData)) {
            return false;
        }
        if(this.clearBefore != ((PlaylistAddData)object0).clearBefore) {
            return false;
        }
        if(this.removeDuplicated != ((PlaylistAddData)object0).removeDuplicated) {
            return false;
        }
        if(!q.b(this.addPlayableListInfo, ((PlaylistAddData)object0).addPlayableListInfo)) {
            return false;
        }
        return this.position == ((PlaylistAddData)object0).position ? this.isAddAndPlay == ((PlaylistAddData)object0).isAddAndPlay : false;
    }

    @NotNull
    public final List getAddPlayableList() {
        return this.addPlayableListInfo.getUserRequestedPlaylist();
    }

    @NotNull
    public final AddRequestPlayableListInfo getAddPlayableListInfo() {
        return this.addPlayableListInfo;
    }

    public final boolean getClearBefore() {
        return this.clearBefore;
    }

    @NotNull
    public final AddPosition getPosition() {
        return this.position;
    }

    public final boolean getRemoveDuplicated() {
        return this.removeDuplicated;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(this.isAddAndPlay) + (this.position.hashCode() + (this.addPlayableListInfo.hashCode() + d.e(Boolean.hashCode(this.clearBefore) * 0x1F, 0x1F, this.removeDuplicated)) * 0x1F) * 0x1F;
    }

    public final boolean isAddAndPlay() {
        return this.isAddAndPlay;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = Y.q("PlaylistAddData(clearBefore=", ", removeDuplicated=", this.clearBefore, ", addPlayableListInfo=", this.removeDuplicated);
        stringBuilder0.append(this.addPlayableListInfo);
        stringBuilder0.append(", position=");
        stringBuilder0.append(this.position);
        stringBuilder0.append(", isAddAndPlay=");
        return o.s(stringBuilder0, this.isAddAndPlay, ")");
    }
}

