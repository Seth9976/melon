package l5;

import hd.i;
import java.io.IOException;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

public final class g extends ForwardingSink {
    public final i a;
    public boolean b;

    public g(Sink sink0, i i0) {
        super(sink0);
        this.a = i0;
    }

    @Override  // okio.ForwardingSink
    public final void close() {
        try {
            super.close();
        }
        catch(IOException iOException0) {
            this.b = true;
            this.a.invoke(iOException0);
        }
    }

    @Override  // okio.ForwardingSink
    public final void flush() {
        try {
            super.flush();
        }
        catch(IOException iOException0) {
            this.b = true;
            this.a.invoke(iOException0);
        }
    }

    @Override  // okio.ForwardingSink
    public final void write(Buffer buffer0, long v) {
        if(this.b) {
            buffer0.skip(v);
            return;
        }
        try {
            super.write(buffer0, v);
        }
        catch(IOException iOException0) {
            this.b = true;
            this.a.invoke(iOException0);
        }
    }
}

