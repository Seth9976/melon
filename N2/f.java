package n2;

import d3.g;
import e1.F;
import i.n.i.b.a.s.e.Ga;
import ie.r;
import java.util.LinkedHashSet;
import k2.b;
import kotlin.jvm.internal.q;
import l2.i0;
import l2.k0;
import l2.l0;
import okio.FileSystem;
import okio.Path;
import we.n;

public final class f implements k0 {
    public final FileSystem a;
    public final Ga b;
    public final n c;
    public final b d;
    public final r e;
    public static final LinkedHashSet f;
    public static final F g;

    static {
        f.f = new LinkedHashSet();
        f.g = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public f(FileSystem fileSystem0, Ga ga0, b b0) {
        q.g(fileSystem0, "fileSystem");
        super();
        this.a = fileSystem0;
        this.b = ga0;
        this.c = d.f;
        this.d = b0;
        this.e = g.Q(new e(this, 0));
    }

    @Override  // l2.k0
    public final l0 createConnection() {
        String s = ((Path)this.e.getValue()).toString();
        synchronized(f.g) {
            LinkedHashSet linkedHashSet0 = f.f;
            if(!linkedHashSet0.contains(s)) {
                linkedHashSet0.add(s);
                Object object0 = this.e.getValue();
                Path path0 = (Path)this.e.getValue();
                Object object1 = this.c.invoke(path0, this.a);
                e e0 = new e(this, 1);
                return new i(this.a, ((Path)object0), this.b, ((i0)object1), e0);
            }
        }
        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + s + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore\'s active on the same file (by confirming that the scope is cancelled).").toString());
    }
}

