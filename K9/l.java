package k9;

import android.text.TextUtils;
import java.io.File;
import kotlin.jvm.internal.q;

public final class l {
    public final String a;
    public final String b;
    public final File c;

    public l(String s, String s1) {
        q.g(s1, "imgUrl");
        super();
        this.a = s;
        this.b = s1;
        String s2 = i.d(new String[]{s1});
        File file0 = TextUtils.isEmpty(s2) ? null : new File(i.c(2), s2);
        q.f(file0, "getPlaylistImageFile(...)");
        this.c = file0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof l)) {
            return false;
        }
        return q.b(this.a, ((l)object0).a) ? q.b(this.b, ((l)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    public final String toString() {
        return "PlaylistImage(title=" + this.a + ", imgUrl=" + this.b + ")";
    }
}

