package n2;

import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import l2.i0;
import okio.FileSystem;
import okio.Path;
import we.n;

public final class d extends r implements n {
    public static final d f;

    static {
        d.f = new d(2);  // 初始化器: Lkotlin/jvm/internal/r;-><init>(I)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        q.g(((Path)object0), "path");
        q.g(((FileSystem)object1), "<anonymous parameter 1>");
        String s = ((Path)object0).normalized().toString();
        q.g(s, "filePath");
        return new i0(s);
    }
}

