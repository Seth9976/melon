package tg;

import java.io.IOException;
import k5.b;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;

public final class x extends ResponseBody {
    public final ResponseBody a;
    public final BufferedSource b;
    public IOException c;

    public x(ResponseBody responseBody0) {
        this.a = responseBody0;
        this.b = Okio.buffer(new b(this, responseBody0.source()));
    }

    @Override  // okhttp3.ResponseBody
    public final void close() {
        this.a.close();
    }

    @Override  // okhttp3.ResponseBody
    public final long contentLength() {
        return this.a.contentLength();
    }

    @Override  // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.a.contentType();
    }

    @Override  // okhttp3.ResponseBody
    public final BufferedSource source() {
        return this.b;
    }
}

