package com.google.android.exoplayer2.source;

public final class DefaultCompositeSequenceableLoaderFactory implements CompositeSequenceableLoaderFactory {
    @Override  // com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory
    public SequenceableLoader createCompositeSequenceableLoader(SequenceableLoader[] arr_sequenceableLoader) {
        return new CompositeSequenceableLoader(arr_sequenceableLoader);
    }
}

