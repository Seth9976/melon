package ug;

import com.google.gson.E;
import com.google.gson.n;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.ByteString;
import tg.m;

public final class b implements m {
    public final n a;
    public final E b;
    public static final MediaType c;

    static {
        b.c = MediaType.get("application/json; charset=UTF-8");
    }

    public b(n n0, E e0) {
        this.a = n0;
        this.b = e0;
    }

    @Override  // tg.m
    public final Object l(Object object0) {
        Buffer buffer0 = new Buffer();
        OutputStreamWriter outputStreamWriter0 = new OutputStreamWriter(buffer0.outputStream(), StandardCharsets.UTF_8);
        W7.b b0 = this.a.i(outputStreamWriter0);
        this.b.c(b0, object0);
        b0.close();
        ByteString byteString0 = buffer0.readByteString();
        return RequestBody.create(b.c, byteString0);
    }
}

