package lc;

import com.iloen.melon.playback.PlayableComparators.AlbumPlayableComparator;
import com.iloen.melon.playback.PlayableComparators.ArtistPlayableComparator;
import com.iloen.melon.playback.PlayableComparators.ArtistReversePlayableComparator;
import com.iloen.melon.playback.PlayableComparators.MostlyThenMyOrderPlayableComparator;
import com.iloen.melon.playback.PlayableComparators.MostlyThenSongNamePlayableComparator;
import com.iloen.melon.playback.PlayableComparators.MyOrderPlayableComparator;
import com.iloen.melon.playback.PlayableComparators.RecentlyPlayableComparator;
import com.iloen.melon.playback.PlayableComparators.SongPlayableComparator;

public abstract class i {
    public static final MyOrderPlayableComparator a;
    public static final RecentlyPlayableComparator b;
    public static final MostlyThenMyOrderPlayableComparator c;
    public static final MostlyThenSongNamePlayableComparator d;
    public static final ArtistPlayableComparator e;
    public static final ArtistReversePlayableComparator f;
    public static final SongPlayableComparator g;
    public static final AlbumPlayableComparator h;

    static {
        i.a = new MyOrderPlayableComparator();
        i.b = new RecentlyPlayableComparator();
        i.c = new MostlyThenMyOrderPlayableComparator();
        i.d = new MostlyThenSongNamePlayableComparator();
        i.e = new ArtistPlayableComparator();
        i.f = new ArtistReversePlayableComparator();
        i.g = new SongPlayableComparator();
        i.h = new AlbumPlayableComparator();
    }
}

