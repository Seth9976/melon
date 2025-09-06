package org.gagravarr.speex;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.gagravarr.ogg.OggFile;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggPacketReader;
import org.gagravarr.ogg.OggPacketWriter;
import org.gagravarr.ogg.OggStreamAudioData;
import org.gagravarr.ogg.OggStreamIdentifier.OggStreamType;
import org.gagravarr.ogg.OggStreamIdentifier;
import org.gagravarr.ogg.audio.OggAudioHeaders;
import org.gagravarr.ogg.audio.OggAudioInfoHeader;
import org.gagravarr.ogg.audio.OggAudioSetupHeader;
import org.gagravarr.ogg.audio.OggAudioStream;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;

public class SpeexFile implements Closeable, OggAudioHeaders, OggAudioStream {
    private SpeexInfo info;
    private OggFile ogg;
    private OggPacketReader r;
    private int sid;
    private SpeexTags tags;
    private OggPacketWriter w;
    private List writtenPackets;

    public SpeexFile(File file0) {
        this(new OggFile(new FileInputStream(file0)));
    }

    public SpeexFile(OutputStream outputStream0) {
        this(outputStream0, new SpeexInfo(), new SpeexTags());
    }

    public SpeexFile(OutputStream outputStream0, int v, SpeexInfo speexInfo0, SpeexTags speexTags0) {
        this.sid = -1;
        OggFile oggFile0 = new OggFile(outputStream0);
        this.ogg = oggFile0;
        if(v > 0) {
            this.w = oggFile0.getPacketWriter(v);
            this.sid = v;
        }
        else {
            OggPacketWriter oggPacketWriter0 = oggFile0.getPacketWriter();
            this.w = oggPacketWriter0;
            this.sid = oggPacketWriter0.getSid();
        }
        this.writtenPackets = new ArrayList();
        this.info = speexInfo0;
        this.tags = speexTags0;
    }

    public SpeexFile(OutputStream outputStream0, SpeexInfo speexInfo0, SpeexTags speexTags0) {
        this(outputStream0, -1, speexInfo0, speexTags0);
    }

    public SpeexFile(OggFile oggFile0) {
        this(oggFile0.getPacketReader());
        this.ogg = oggFile0;
    }

    public SpeexFile(OggPacketReader oggPacketReader0) {
        OggPacket oggPacket0;
        this.sid = -1;
        this.r = oggPacketReader0;
        while(true) {
            oggPacket0 = oggPacketReader0.getNextPacket();
            if(oggPacket0 == null) {
                break;
            }
            if(oggPacket0.isBeginningOfStream() && oggPacket0.getData().length > 10 && SpeexPacketFactory.isSpeexStream(oggPacket0)) {
                this.sid = oggPacket0.getSid();
                break;
            }
        }
        if(this.sid == -1) {
            throw new IllegalArgumentException("Supplied File is not Speex");
        }
        this.info = (SpeexInfo)SpeexPacketFactory.create(oggPacket0);
        this.tags = (SpeexTags)SpeexPacketFactory.create(oggPacketReader0.getNextPacketWithSid(this.sid));
    }

    @Override
    public void close() {
        if(this.r != null) {
            this.r = null;
            this.ogg.close();
            this.ogg = null;
        }
        OggPacketWriter oggPacketWriter0 = this.w;
        if(oggPacketWriter0 != null) {
            oggPacketWriter0.bufferPacket(this.info.write(), true);
            this.w.bufferPacket(this.tags.write(), false);
            long v = 0L;
            for(Object object0: this.writtenPackets) {
                SpeexAudioData speexAudioData0 = (SpeexAudioData)object0;
                if(speexAudioData0.getGranulePosition() >= 0L && v != speexAudioData0.getGranulePosition()) {
                    this.w.flush();
                    v = speexAudioData0.getGranulePosition();
                    this.w.setGranulePosition(v);
                }
                this.w.bufferPacket(speexAudioData0.write());
                if(this.w.getSizePendingFlush() > 0x4000) {
                    this.w.flush();
                }
            }
            this.w.close();
            this.w = null;
            this.ogg.close();
            this.ogg = null;
        }
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioInfoHeader getInfo() {
        return this.getInfo();
    }

    public SpeexInfo getInfo() {
        return this.info;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioStream
    public OggStreamAudioData getNextAudioPacket() {
        return this.getNextAudioPacket();
    }

    public SpeexAudioData getNextAudioPacket() {
        OggPacket oggPacket0;
        while((oggPacket0 = this.r.getNextPacketWithSid(this.sid)) != null) {
            SpeexPacket speexPacket0 = SpeexPacketFactory.create(oggPacket0);
            if(speexPacket0 instanceof SpeexAudioData) {
                return (SpeexAudioData)speexPacket0;
            }
            System.err.println("Skipping non audio packet " + speexPacket0 + " mid audio stream");
        }
        return null;
    }

    public OggFile getOggFile() {
        return this.ogg;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioSetupHeader getSetup() {
        return null;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public int getSid() {
        return this.sid;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioTagsHeader getTags() {
        return this.getTags();
    }

    public SpeexTags getTags() {
        return this.tags;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggStreamType getType() {
        return OggStreamIdentifier.SPEEX_AUDIO;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioStream
    public void skipToGranule(long v) {
        this.r.skipToGranulePosition(this.sid, v);
    }

    public void writeAudioData(SpeexAudioData speexAudioData0) {
        this.writtenPackets.add(speexAudioData0);
    }
}

