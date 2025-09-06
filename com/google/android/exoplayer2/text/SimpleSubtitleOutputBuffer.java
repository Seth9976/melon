package com.google.android.exoplayer2.text;

final class SimpleSubtitleOutputBuffer extends SubtitleOutputBuffer {
    private final SimpleSubtitleDecoder owner;

    public SimpleSubtitleOutputBuffer(SimpleSubtitleDecoder simpleSubtitleDecoder0) {
        this.owner = simpleSubtitleDecoder0;
    }

    @Override  // com.google.android.exoplayer2.text.SubtitleOutputBuffer
    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

