package com.google.android.exoplayer2.metadata;

import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MAX_PENDING_METADATA_COUNT = 5;
    private static final int MSG_INVOKE_RENDERER;
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    private final Handler outputHandler;
    private final Metadata[] pendingMetadata;
    private int pendingMetadataCount;
    private int pendingMetadataIndex;
    private final long[] pendingMetadataTimestamps;
    private long subsampleOffsetUs;

    public MetadataRenderer(MetadataOutput metadataOutput0, Looper looper0) {
        this(metadataOutput0, looper0, MetadataDecoderFactory.DEFAULT);
    }

    public MetadataRenderer(MetadataOutput metadataOutput0, Looper looper0, MetadataDecoderFactory metadataDecoderFactory0) {
        super(4);
        this.output = (MetadataOutput)Assertions.checkNotNull(metadataOutput0);
        this.outputHandler = looper0 == null ? null : Util.createHandler(looper0, this);
        this.decoderFactory = (MetadataDecoderFactory)Assertions.checkNotNull(metadataDecoderFactory0);
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadata = new Metadata[5];
        this.pendingMetadataTimestamps = new long[5];
    }

    private void decodeWrappedMetadata(Metadata metadata0, List list0) {
        for(int v = 0; v < metadata0.length(); ++v) {
            Format format0 = metadata0.get(v).getWrappedMetadataFormat();
            if(format0 == null || !this.decoderFactory.supportsFormat(format0)) {
                list0.add(metadata0.get(v));
            }
            else {
                MetadataDecoder metadataDecoder0 = this.decoderFactory.createDecoder(format0);
                byte[] arr_b = (byte[])Assertions.checkNotNull(metadata0.get(v).getWrappedMetadataBytes());
                this.buffer.clear();
                this.buffer.ensureSpaceForWrite(arr_b.length);
                this.buffer.data.put(arr_b);
                this.buffer.flip();
                Metadata metadata1 = metadataDecoder0.decode(this.buffer);
                if(metadata1 != null) {
                    this.decodeWrappedMetadata(metadata1, list0);
                }
            }
        }
    }

    private void flushPendingMetadata() {
        Arrays.fill(this.pendingMetadata, null);
        this.pendingMetadataIndex = 0;
        this.pendingMetadataCount = 0;
    }

    @Override  // android.os.Handler$Callback
    public boolean handleMessage(Message message0) {
        if(message0.what != 0) {
            throw new IllegalStateException();
        }
        this.invokeRendererInternal(((Metadata)message0.obj));
        return true;
    }

    private void invokeRenderer(Metadata metadata0) {
        Handler handler0 = this.outputHandler;
        if(handler0 != null) {
            handler0.obtainMessage(0, metadata0).sendToTarget();
            return;
        }
        this.invokeRendererInternal(metadata0);
    }

    private void invokeRendererInternal(Metadata metadata0) {
        this.output.onMetadata(metadata0);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        return this.inputStreamEnded;
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        return true;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onDisabled() {
        this.flushPendingMetadata();
        this.decoder = null;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onPositionReset(long v, boolean z) {
        this.flushPendingMetadata();
        this.inputStreamEnded = false;
    }

    @Override  // com.google.android.exoplayer2.BaseRenderer
    public void onStreamChanged(Format[] arr_format, long v) {
        this.decoder = this.decoderFactory.createDecoder(arr_format[0]);
    }

    @Override  // com.google.android.exoplayer2.Renderer
    public void render(long v, long v1) {
        if(!this.inputStreamEnded && this.pendingMetadataCount < 5) {
            this.buffer.clear();
            FormatHolder formatHolder0 = this.getFormatHolder();
            int v2 = this.readSource(formatHolder0, this.buffer, false);
            if(v2 != -4) {
                if(v2 == -5) {
                    this.subsampleOffsetUs = ((Format)Assertions.checkNotNull(formatHolder0.format)).subsampleOffsetUs;
                }
            }
            else if(this.buffer.isEndOfStream()) {
                this.inputStreamEnded = true;
            }
            else if(!this.buffer.isDecodeOnly()) {
                this.buffer.subsampleOffsetUs = this.subsampleOffsetUs;
                this.buffer.flip();
                Metadata metadata0 = this.decoder.decode(this.buffer);
                if(metadata0 != null) {
                    ArrayList arrayList0 = new ArrayList(metadata0.length());
                    this.decodeWrappedMetadata(metadata0, arrayList0);
                    if(!arrayList0.isEmpty()) {
                        Metadata metadata1 = new Metadata(arrayList0);
                        int v3 = this.pendingMetadataCount;
                        int v4 = (this.pendingMetadataIndex + v3) % 5;
                        this.pendingMetadata[v4] = metadata1;
                        this.pendingMetadataTimestamps[v4] = this.buffer.timeUs;
                        this.pendingMetadataCount = v3 + 1;
                    }
                }
            }
        }
        if(this.pendingMetadataCount > 0) {
            int v5 = this.pendingMetadataIndex;
            if(this.pendingMetadataTimestamps[v5] <= v) {
                this.invokeRenderer(((Metadata)Util.castNonNull(this.pendingMetadata[v5])));
                int v6 = this.pendingMetadataIndex;
                this.pendingMetadata[v6] = null;
                this.pendingMetadataIndex = (v6 + 1) % 5;
                --this.pendingMetadataCount;
            }
        }
    }

    // 去混淆评级： 低(30)
    @Override  // com.google.android.exoplayer2.RendererCapabilities
    public int supportsFormat(Format format0) {
        if(this.decoderFactory.supportsFormat(format0)) {
            return BaseRenderer.supportsFormatDrm(null, format0.drmInitData) ? 4 : 2;
        }
        return 0;
    }
}

