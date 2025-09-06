package org.gagravarr.flac;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggFile;

public abstract class FlacFile implements Closeable {
    protected FlacInfo info;
    protected List otherMetadata;
    protected FlacTags tags;

    @Override
    public abstract void close();

    public FlacInfo getInfo() {
        return this.info;
    }

    public abstract FlacAudioFrame getNextAudioPacket();

    public FlacTags getTags() {
        return this.tags;
    }

    public static FlacFile open(File file0) {
        BufferedInputStream bufferedInputStream0 = new BufferedInputStream(new FileInputStream(file0), 8);
        FlacFile flacFile0 = FlacFile.open(bufferedInputStream0);
        bufferedInputStream0.close();
        return flacFile0;
    }

    public static FlacFile open(InputStream inputStream0) {
        inputStream0.mark(4);
        byte[] arr_b = new byte[4];
        IOUtils.readFully(inputStream0, arr_b);
        inputStream0.reset();
        int v = arr_b[0];
        if(v == 0x4F && arr_b[1] == 103 && arr_b[2] == 103 && arr_b[3] == 83) {
            return new FlacOggFile(new OggFile(inputStream0));
        }
        if(v != 102 || arr_b[1] != 76 || arr_b[2] != 97 || arr_b[3] != 67) {
            throw new IllegalArgumentException("File type not recognised");
        }
        return new FlacNativeFile(inputStream0);
    }

    public static FlacFile open(OggFile oggFile0) {
        return new FlacOggFile(oggFile0);
    }

    public abstract void skipToGranule(long arg1);
}

