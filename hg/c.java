package hg;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public final class c implements Closeable {
    public final int a;
    public final Object b;

    public c(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override
    public final void close() {
        if(this.a != 0) {
            ((l5.c)this.b).close();
            return;
        }
        InputStream[] arr_inputStream = (InputStream[])this.b;
        for(int v = 0; v < arr_inputStream.length; ++v) {
            InputStream inputStream0 = arr_inputStream[v];
            if(inputStream0 != null) {
                try {
                    inputStream0.close();
                    continue;
                }
                catch(RuntimeException runtimeException0) {
                }
                catch(Exception unused_ex) {
                    continue;
                }
                throw runtimeException0;
            }
        }
    }

    public String h() {
        try(InputStreamReader inputStreamReader0 = new InputStreamReader(((InputStream[])this.b)[0], d.o)) {
            StringWriter stringWriter0 = new StringWriter();
            char[] arr_c = new char[0x400];
            int v;
            while((v = inputStreamReader0.read(arr_c)) != -1) {
                stringWriter0.write(arr_c, 0, v);
            }
            return stringWriter0.toString();
        }
    }
}

