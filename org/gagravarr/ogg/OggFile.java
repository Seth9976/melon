package org.gagravarr.ogg;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class OggFile implements Closeable {
    private InputStream inp;
    private OutputStream out;
    private Set seenSIDs;
    private boolean writing;

    public OggFile(InputStream inputStream0) {
        this.writing = true;
        this.seenSIDs = new HashSet();
        this.inp = inputStream0;
        this.writing = false;
    }

    public OggFile(InputStream inputStream0, OggStreamListener oggStreamListener0) {
        this(inputStream0);
        HashMap hashMap0 = new HashMap();
        OggPacketReader oggPacketReader0 = this.getPacketReader();
        OggPacket oggPacket0;
        while((oggPacket0 = oggPacketReader0.getNextPacket()) != null) {
            if(oggPacket0.isBeginningOfStream()) {
                OggStreamReader[] arr_oggStreamReader = oggStreamListener0.processNewStream(oggPacket0.getSid(), oggPacket0.getData());
                if(arr_oggStreamReader != null && arr_oggStreamReader.length > 0) {
                    hashMap0.put(oggPacket0.getSid(), arr_oggStreamReader);
                }
            }
            else {
                OggStreamReader[] arr_oggStreamReader1 = (OggStreamReader[])hashMap0.get(oggPacket0.getSid());
                if(arr_oggStreamReader1 != null) {
                    int v = arr_oggStreamReader1.length;
                    for(int v1 = 0; v1 < v; ++v1) {
                        arr_oggStreamReader1[v1].processPacket(oggPacket0);
                    }
                }
            }
            if(oggPacket0.isEndOfStream()) {
                oggStreamListener0.processStreamEnd(oggPacket0.getSid());
            }
        }
    }

    public OggFile(OutputStream outputStream0) {
        this.writing = true;
        this.seenSIDs = new HashSet();
        this.out = outputStream0;
        this.writing = true;
    }

    @Override
    public void close() {
        InputStream inputStream0 = this.inp;
        if(inputStream0 != null) {
            inputStream0.close();
        }
        OutputStream outputStream0 = this.out;
        if(outputStream0 != null) {
            outputStream0.close();
        }
    }

    public OggPacketReader getPacketReader() {
        if(!this.writing) {
            InputStream inputStream0 = this.inp;
            if(inputStream0 != null) {
                return new OggPacketReader(inputStream0);
            }
        }
        throw new IllegalStateException("Can only read from a file opened with an InputStream");
    }

    public OggPacketWriter getPacketWriter() {
        return this.getPacketWriter(this.getUnusedSerialNumber());
    }

    public OggPacketWriter getPacketWriter(int v) {
        if(!this.writing) {
            throw new IllegalStateException("Can only write to a file opened with an OutputStream");
        }
        this.seenSIDs.add(v);
        return new OggPacketWriter(this, v);
    }

    public int getUnusedSerialNumber() {
        int v;
        do {
            v = (int)(Math.random() * 32767.0);
        }
        while(this.seenSIDs.contains(v));
        return v;
    }

    public void writePages(OggPage[] arr_oggPage) {
        synchronized(this) {
            for(int v1 = 0; v1 < arr_oggPage.length; ++v1) {
                OggPage oggPage0 = arr_oggPage[v1];
                oggPage0.writeHeader(this.out);
                this.out.write(oggPage0.getData());
            }
            this.out.flush();
        }
    }
}

