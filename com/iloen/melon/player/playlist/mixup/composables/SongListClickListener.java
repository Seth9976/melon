package com.iloen.melon.player.playlist.mixup.composables;

import com.iloen.melon.playback.Playable;
import com.melon.playlist.interfaces.PlayableData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u000E\u001A\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u0011\u0010\fJ\u001F\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u0012\u0010\fJ\u001F\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u0013\u0010\f¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/composables/SongListClickListener;", "", "", "itemId", "", "isSelected", "Lie/H;", "onSelect", "(Ljava/lang/String;Z)V", "Lcom/iloen/melon/playback/Playable;", "playable", "onClickSongLayer", "(Ljava/lang/String;Lcom/iloen/melon/playback/Playable;)V", "Lcom/melon/playlist/interfaces/PlayableData;", "playableData", "onMore", "(Ljava/lang/String;Lcom/melon/playlist/interfaces/PlayableData;)V", "onShowAlbumInfo", "onClickMoveUp", "onClickMoveDown", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SongListClickListener {
    void onClickMoveDown(@NotNull String arg1, @NotNull Playable arg2);

    void onClickMoveUp(@NotNull String arg1, @NotNull Playable arg2);

    void onClickSongLayer(@NotNull String arg1, @NotNull Playable arg2);

    void onMore(@NotNull String arg1, @Nullable PlayableData arg2);

    void onSelect(@NotNull String arg1, boolean arg2);

    void onShowAlbumInfo(@NotNull String arg1, @NotNull Playable arg2);
}

