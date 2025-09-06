package org.gagravarr.flac;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.gagravarr.ogg.IOUtils;

public class FlacNativeFile extends FlacFile {
    private InputStream input;

    public FlacNativeFile(File file0) {
        this(new FileInputStream(file0));
    }

    public FlacNativeFile(InputStream inputStream0) {
        byte[] arr_b = new byte[4];
        IOUtils.readFully(inputStream0, arr_b);
        if(arr_b[0] != 102 || arr_b[1] != 76 || arr_b[2] != 97 || arr_b[3] != 67) {
            throw new IllegalArgumentException("Not a FLAC file");
        }
        this.info = (FlacInfo)FlacMetadataBlock.create(inputStream0);
        this.otherMetadata = new ArrayList();
        do {
            FlacMetadataBlock flacMetadataBlock0 = FlacMetadataBlock.create(inputStream0);
            if(flacMetadataBlock0 instanceof FlacTagsAsMetadata) {
                this.tags = ((FlacTagsAsMetadata)flacMetadataBlock0).getTags();
            }
            else {
                this.otherMetadata.add(flacMetadataBlock0);
            }
        }
        while(!flacMetadataBlock0.isLastMetadataBlock());
        this.input = inputStream0;
    }

    @Override  // org.gagravarr.flac.FlacFile
    public void close() {
        InputStream inputStream0 = this.input;
        if(inputStream0 == null) {
            throw new RuntimeException("Not supported");
        }
        inputStream0.close();
        this.input = null;
    }

    @Override  // org.gagravarr.flac.FlacFile
    public FlacAudioFrame getNextAudioPacket() {
        return new FlacAudioFrame(null);
    }

    @Override  // org.gagravarr.flac.FlacFile
    public void skipToGranule(long v) {
        throw new RuntimeException("Not supported");
    }
}

