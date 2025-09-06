package hg;

import J0.h;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

public final class a extends FilterOutputStream {
    public final h a;

    public a(h h0, FileOutputStream fileOutputStream0) {
        this.a = h0;
        super(fileOutputStream0);
    }

    @Override
    public final void close() {
        try {
            this.out.close();
        }
        catch(IOException unused_ex) {
            this.a.b = true;
        }
    }

    @Override
    public final void flush() {
        try {
            this.out.flush();
        }
        catch(IOException unused_ex) {
            this.a.b = true;
        }
    }

    @Override
    public final void write(int v) {
        try {
            this.out.write(v);
        }
        catch(IOException unused_ex) {
            this.a.b = true;
        }
    }

    @Override
    public final void write(byte[] arr_b, int v, int v1) {
        try {
            this.out.write(arr_b, v, v1);
        }
        catch(IOException unused_ex) {
            this.a.b = true;
        }
    }
}

