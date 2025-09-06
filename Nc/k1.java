package Nc;

import A7.d;
import H0.b;
import Oc.l;
import com.melon.ui.K4;
import java.util.ArrayList;

public final class k1 implements K4 {
    public final F0 a;
    public final boolean b;
    public final ArrayList c;
    public final l d;

    public k1(F0 f00, boolean z, ArrayList arrayList0, l l0) {
        this.a = f00;
        this.b = z;
        this.c = arrayList0;
        this.d = l0;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof k1 && this.a.equals(((k1)object0).a) && this.b == ((k1)object0).b && this.c.equals(((k1)object0).c) && this.d.equals(((k1)object0).d);
    }

    @Override
    public final int hashCode() {
        return this.d.hashCode() + b.a(this.c, d.e(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F);
    }

    @Override
    public final String toString() {
        return "GenrePlaylistItemUiState(genreListItemTitleUiState=" + this.a + ", isOnlyPlaylist=" + this.b + ", playlistList=" + this.c + ", onGenrePlaylistItemUserEvent=" + this.d + ")";
    }
}

