package com.iloen.melon.fragments.mymusic.dna;

import android.os.Bundle;
import com.melon.net.res.common.SongInfoBase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/OnSongItemClickListener;", "", "Lcom/melon/net/res/common/SongInfoBase;", "songInfo", "Landroid/os/Bundle;", "extra", "Lie/H;", "onSongPlayClickListener", "(Lcom/melon/net/res/common/SongInfoBase;Landroid/os/Bundle;)V", "onSongItemClickListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface OnSongItemClickListener {
    void onSongItemClickListener(@NotNull SongInfoBase arg1, @Nullable Bundle arg2);

    void onSongPlayClickListener(@NotNull SongInfoBase arg1, @Nullable Bundle arg2);
}

