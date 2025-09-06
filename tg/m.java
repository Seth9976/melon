package tg;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public final class M extends RequestBody {
    public final RequestBody a;
    public final MediaType b;

    public M(RequestBody requestBody0, MediaType mediaType0) {
        this.a = requestBody0;
        this.b = mediaType0;
    }

    @Override  // okhttp3.RequestBody
    public final long contentLength() {
        return this.a.contentLength();
    }

    @Override  // okhttp3.RequestBody
    public final MediaType contentType() {
        return this.b;
    }

    @Override  // okhttp3.RequestBody
    public final void writeTo(BufferedSink bufferedSink0) {
        this.a.writeTo(bufferedSink0);
    }
}

