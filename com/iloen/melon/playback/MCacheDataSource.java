package com.iloen.melon.playback;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.BaseDataSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import f9.c;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\"B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\'\u0010\u0010\u001A\u00020\r2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001A\u00020\u00188\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\u0016\u0010 \u001A\u00020\u001F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/iloen/melon/playback/MCacheDataSource;", "Lcom/google/android/exoplayer2/upstream/BaseDataSource;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "dataSpec", "", "open", "(Lcom/google/android/exoplayer2/upstream/DataSpec;)J", "", "buffer", "", "offset", "readLength", "read", "([BII)I", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Lie/H;", "close", "()V", "Lf9/c;", "dataSource", "Lf9/c;", "getDataSource", "()Lf9/c;", "setDataSource", "(Lf9/c;)V", "", "playerUserAgent", "Ljava/lang/String;", "Factory", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MCacheDataSource extends BaseDataSource {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/MCacheDataSource$Factory;", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "createDataSource", "Lcom/google/android/exoplayer2/upstream/DataSource;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Factory implements com.google.android.exoplayer2.upstream.DataSource.Factory {
        public static final int $stable = 8;
        @NotNull
        private final Context context;

        public Factory(@NotNull Context context0) {
            q.g(context0, "context");
            super();
            this.context = context0;
        }

        @Override  // com.google.android.exoplayer2.upstream.DataSource$Factory
        @NotNull
        public DataSource createDataSource() {
            return new MCacheDataSource(this.context);
        }
    }

    public static final int $stable = 8;
    @NotNull
    private c dataSource;
    @NotNull
    private String playerUserAgent;

    public MCacheDataSource(@NotNull Context context0) {
        q.g(context0, "context");
        super(false);
        this.dataSource = new c();
        this.playerUserAgent = PlayerUtil.getExoPlayerUserAgent(context0);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public void close() {
        this.dataSource.a();
    }

    @NotNull
    public final c getDataSource() {
        return this.dataSource;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    @NotNull
    public Uri getUri() {
        Uri uri0 = this.dataSource.i;
        if(uri0 != null) {
            return uri0;
        }
        q.m("uri");
        throw null;
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public long open(@NotNull DataSpec dataSpec0) {
        q.g(dataSpec0, "dataSpec");
        return this.dataSource.d(dataSpec0.uri, dataSpec0.position, this.playerUserAgent);
    }

    @Override  // com.google.android.exoplayer2.upstream.DataSource
    public int read(@NotNull byte[] arr_b, int v, int v1) {
        q.g(arr_b, "buffer");
        return this.dataSource.e(arr_b, v, v1);
    }

    public final void setDataSource(@NotNull c c0) {
        q.g(c0, "<set-?>");
        this.dataSource = c0;
    }
}

