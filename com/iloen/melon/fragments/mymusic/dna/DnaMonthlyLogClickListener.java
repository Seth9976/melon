package com.iloen.melon.fragments.mymusic.dna;

import android.os.Bundle;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004J!\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\b\u001A\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\n\u0010\u000BJ\u001D\u0010\u000E\u001A\u00020\t2\f\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\fH&¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0010\u001A\u00020\tH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/DnaMonthlyLogClickListener;", "Lcom/iloen/melon/fragments/mymusic/dna/OnSongItemClickListener;", "Lcom/iloen/melon/fragments/mymusic/dna/OnAlbumItemClickListener;", "Lcom/iloen/melon/fragments/mymusic/dna/OnArtistItemClickListener;", "Lcom/iloen/melon/fragments/mymusic/dna/OnTagItemClickListener;", "", "filterCode", "Landroid/os/Bundle;", "extra", "Lie/H;", "onMostGenreMoreClickListener", "(Ljava/lang/String;Landroid/os/Bundle;)V", "", "monthList", "onLastMonthClickListener", "(Ljava/util/List;)V", "onShortcutClickListener", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface DnaMonthlyLogClickListener extends OnAlbumItemClickListener, OnArtistItemClickListener, OnSongItemClickListener, OnTagItemClickListener {
    void onLastMonthClickListener(@NotNull List arg1);

    void onMostGenreMoreClickListener(@NotNull String arg1, @Nullable Bundle arg2);

    void onShortcutClickListener();
}

