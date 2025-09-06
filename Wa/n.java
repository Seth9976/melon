package Wa;

import java.util.ArrayList;

public final class n extends p {
    public final ArrayList a;

    public n(ArrayList arrayList0) {
        this.a = arrayList0;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 || object0 instanceof n && this.a.equals(((n)object0).a);
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "ScrapPlaylistSong(playableList=" + this.a + ")";
    }
}

