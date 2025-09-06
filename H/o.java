package H;

import ie.H;
import java.io.File;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;
import te.j;
import we.a;

public final class o extends r implements a {
    public final int f;
    public final r g;

    public o(int v, a a0) {
        this.f = v;
        switch(v) {
            case 1: {
                this.g = (r)a0;
                super(0);
                return;
            }
            case 2: {
                this.g = (r)a0;
                super(0);
                return;
            }
            default: {
                this.g = (r)a0;
                super(0);
            }
        }
    }

    @Override  // we.a
    public final Object invoke() {
        switch(this.f) {
            case 0: {
                ((a)this.g).invoke();
                return H.a;
            }
            case 1: {
                ((a)this.g).invoke();
                return H.a;
            }
            default: {
                File file0 = (File)((a)this.g).invoke();
                if(!j.A(file0).equals("preferences_pb")) {
                    throw new IllegalStateException(("File extension for file: " + file0 + " does not match required extension for Preferences file: preferences_pb").toString());
                }
                File file1 = file0.getAbsoluteFile();
                q.f(file1, "file.absoluteFile");
                return file1;
            }
        }
    }
}

