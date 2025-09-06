package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0004\u001A\u00020\u0005H\u0016J\n\u0010\t\u001A\u0004\u0018\u00010\nH\u0016J\b\u0010\u0006\u001A\u00020\u0007H\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lokhttp3/internal/http/RealResponseBody;", "Lokhttp3/ResponseBody;", "contentTypeString", "", "contentLength", "", "source", "Lokio/BufferedSource;", "(Ljava/lang/String;JLokio/BufferedSource;)V", "contentType", "Lokhttp3/MediaType;", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    @Nullable
    private final String contentTypeString;
    @NotNull
    private final BufferedSource source;

    public RealResponseBody(@Nullable String s, long v, @NotNull BufferedSource bufferedSource0) {
        q.g(bufferedSource0, "source");
        super();
        this.contentTypeString = s;
        this.contentLength = v;
        this.source = bufferedSource0;
    }

    @Override  // okhttp3.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override  // okhttp3.ResponseBody
    @Nullable
    public MediaType contentType() {
        return this.contentTypeString == null ? null : MediaType.Companion.parse(this.contentTypeString);
    }

    @Override  // okhttp3.ResponseBody
    @NotNull
    public BufferedSource source() {
        return this.source;
    }
}

