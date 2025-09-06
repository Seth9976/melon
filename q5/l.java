package Q5;

import R5.e;
import X5.d;
import java.io.Closeable;
import javax.inject.Provider;

public final class l implements Closeable {
    public Provider a;
    public e b;
    public Provider c;
    public X5.e d;
    public Provider e;
    public Provider f;
    public Provider g;

    @Override
    public final void close() {
        ((d)this.f.get()).close();
    }
}

