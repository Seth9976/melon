package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class EventMessageDecoder implements MetadataDecoder {
    @Override  // com.google.android.exoplayer2.metadata.MetadataDecoder
    public Metadata decode(MetadataInputBuffer metadataInputBuffer0) {
        ByteBuffer byteBuffer0 = (ByteBuffer)Assertions.checkNotNull(metadataInputBuffer0.data);
        return new Metadata(new Entry[]{this.decode(new ParsableByteArray(byteBuffer0.array(), byteBuffer0.limit()))});
    }

    public EventMessage decode(ParsableByteArray parsableByteArray0) {
        return new EventMessage(((String)Assertions.checkNotNull(parsableByteArray0.readNullTerminatedString())), ((String)Assertions.checkNotNull(parsableByteArray0.readNullTerminatedString())), parsableByteArray0.readUnsignedInt(), parsableByteArray0.readUnsignedInt(), Arrays.copyOfRange(parsableByteArray0.data, parsableByteArray0.getPosition(), parsableByteArray0.limit()));
    }
}

