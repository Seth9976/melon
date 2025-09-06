package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import okio.Pipe;
import okio.Sink;
import okio.Socket;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001A\u0004\b\u000B\u0010\fR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\n\u001A\u0004\b\r\u0010\fR\u0014\u0010\u0011\u001A\u00020\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0015\u001A\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lokio/internal/PipeSocket;", "Lokio/Socket;", "Lokio/Pipe;", "sinkPipe", "sourcePipe", "<init>", "(Lokio/Pipe;Lokio/Pipe;)V", "Lie/H;", "cancel", "()V", "Lokio/Pipe;", "getSinkPipe", "()Lokio/Pipe;", "getSourcePipe", "Lokio/Source;", "getSource", "()Lokio/Source;", "source", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "sink", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public final class PipeSocket implements Socket {
    @NotNull
    private final Pipe sinkPipe;
    @NotNull
    private final Pipe sourcePipe;

    public PipeSocket(@NotNull Pipe pipe0, @NotNull Pipe pipe1) {
        q.g(pipe0, "sinkPipe");
        q.g(pipe1, "sourcePipe");
        super();
        this.sinkPipe = pipe0;
        this.sourcePipe = pipe1;
    }

    @Override  // okio.Socket
    public void cancel() {
        this.sourcePipe.cancel();
        this.sinkPipe.cancel();
    }

    @Override  // okio.Socket
    @NotNull
    public Sink getSink() {
        return this.sinkPipe.sink();
    }

    @NotNull
    public final Pipe getSinkPipe() {
        return this.sinkPipe;
    }

    @Override  // okio.Socket
    @NotNull
    public Source getSource() {
        return this.sourcePipe.source();
    }

    @NotNull
    public final Pipe getSourcePipe() {
        return this.sourcePipe;
    }
}

