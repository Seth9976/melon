package cd;

import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.NEWALBUM.NEWALBUMS.ALBUM;
import com.melon.ui.K4;
import dd.I;
import kotlin.jvm.internal.q;

public final class q1 implements K4 {
    public final ALBUM a;
    public final I b;

    public q1(ALBUM mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0, I i0) {
        q.g(mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0, "item");
        super();
        this.a = mainMusicRes$RESPONSE$NEWALBUM$NEWALBUMS$ALBUM0;
        this.b = i0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof q1 && q.b(this.a, ((q1)object0).a) && this.b.equals(((q1)object0).b);
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "NewAlbumSlotItemUiState(item=" + this.a + ", userEvent=" + this.b + ")";
    }
}

