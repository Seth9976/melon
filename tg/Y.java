package tg;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class y extends ResponseBody {
    public final MediaType a;
    public final long b;

    public y(MediaType mediaType0, long v) {
        this.a = mediaType0;
        this.b = v;
    }

    @Override  // okhttp3.ResponseBody
    public final long contentLength() {
        return this.b;
    }

    @Override  // okhttp3.ResponseBody
    public final MediaType contentType() {
        return this.a;
    }

    @Override  // okhttp3.ResponseBody
    public final BufferedSource source() {
        throw new IllegalStateException("Cannot read raw response body of a converted body.");
    }
}

