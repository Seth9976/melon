package okio;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001A\u00020\u00058&X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001A\u00020\t8&X¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000Bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lokio/Socket;", "", "Lie/H;", "cancel", "()V", "Lokio/Source;", "getSource", "()Lokio/Source;", "source", "Lokio/Sink;", "getSink", "()Lokio/Sink;", "sink", "okio"}, k = 1, mv = {2, 1, 0}, xi = 0x30)
public interface Socket {
    void cancel();

    @NotNull
    Sink getSink();

    @NotNull
    Source getSource();
}

