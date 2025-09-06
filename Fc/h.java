package Fc;

import android.text.Html;
import androidx.compose.foundation.lazy.a;
import androidx.compose.runtime.l;
import com.iloen.melon.lyric.LyricsInfo;
import ie.H;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import we.p;

public final class h extends r implements p {
    public final List f;
    public final long g;
    public final Integer h;
    public final List i;

    public h(List list0, long v, Integer integer0, List list1) {
        this.f = list0;
        this.g = v;
        this.h = integer0;
        this.i = list1;
        super(4);
    }

    @Override  // we.p
    public final Object invoke(Object object0, Object object1, Object object2, Object object3) {
        int v = ((Number)object1).intValue();
        int v1 = ((Number)object3).intValue();
        int v2 = (v1 & 6) == 0 ? (((androidx.compose.runtime.p)(((l)object2))).g(((a)object0)) ? 4 : 2) | v1 : v1;
        if((v1 & 0x30) == 0) {
            v2 |= (((androidx.compose.runtime.p)(((l)object2))).e(v) ? 0x20 : 16);
        }
        if(((androidx.compose.runtime.p)(((l)object2))).Q(v2 & 1, (v2 & 0x93) != 0x92)) {
            LyricsInfo lyricsInfo0 = (LyricsInfo)this.f.get(v);
            ((androidx.compose.runtime.p)(((l)object2))).a0(0x338A0BE5);
            Pattern pattern0 = Pattern.compile("\n");
            q.f(pattern0, "compile(...)");
            q.g(lyricsInfo0.b, "input");
            String s = pattern0.matcher(lyricsInfo0.b).replaceAll("<br>");
            q.f(s, "replaceAll(...)");
            E9.h.b(Html.fromHtml(s, 0).toString(), this.h != null && v == ((int)this.h), v == this.i.size() - 1, 1L <= this.g && this.g < lyricsInfo0.a, ((androidx.compose.runtime.p)(((l)object2))), 0, 0);
            ((androidx.compose.runtime.p)(((l)object2))).p(false);
            return H.a;
        }
        ((androidx.compose.runtime.p)(((l)object2))).T();
        return H.a;
    }
}

