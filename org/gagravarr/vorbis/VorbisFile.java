package org.gagravarr.vorbis;

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

public class VorbisFile implements Closeable, OggAudioHeaders, OggAudioStream {
    private VorbisComments comment;
    private VorbisInfo info;
    private OggFile ogg;
    private OggPacketReader r;
    private VorbisSetup setup;
    private int sid;
    private OggPacketWriter w;
    private List writtenPackets;

    public VorbisFile(File file0) {
        this(new OggFile(new FileInputStream(file0)));
    }

    public VorbisFile(OutputStream outputStream0) {
        this(outputStream0, new VorbisInfo(), new VorbisComments(), new VorbisSetup());
    }

    public VorbisFile(OutputStream outputStream0, int v, VorbisInfo vorbisInfo0, VorbisComments vorbisComments0, VorbisSetup vorbisSetup0) {
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
        this.info = vorbisInfo0;
        this.comment = vorbisComments0;
        this.setup = vorbisSetup0;
    }

    public VorbisFile(OutputStream outputStream0, VorbisInfo vorbisInfo0, VorbisComments vorbisComments0, VorbisSetup vorbisSetup0) {
        this(outputStream0, -1, vorbisInfo0, vorbisComments0, vorbisSetup0);
    }

    public VorbisFile(OggFile oggFile0) {
        this(oggFile0.getPacketReader());
        this.ogg = oggFile0;
    }

    public VorbisFile(OggPacketReader oggPacketReader0) {
        OggPacket oggPacket0;
        this.sid = -1;
        this.r = oggPacketReader0;
        while(true) {
            oggPacket0 = oggPacketReader0.getNextPacket();
            if(oggPacket0 == null) {
                break;
            }
            if(oggPacket0.isBeginningOfStream() && oggPacket0.getData().length > 10 && VorbisPacketFactory.isVorbisStream(oggPacket0)) {
                this.sid = oggPacket0.getSid();
                break;
            }
        }
        if(oggPacket0 == null) {
            throw new IllegalArgumentException("Supplied File is not Vorbis");
        }
        this.info = (VorbisInfo)VorbisPacketFactory.create(oggPacket0);
        this.comment = (VorbisComments)VorbisPacketFactory.create(oggPacketReader0.getNextPacketWithSid(this.sid));
        this.setup = (VorbisSetup)VorbisPacketFactory.create(oggPacketReader0.getNextPacketWithSid(this.sid));
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
            this.w.bufferPacket(this.comment.write(), false);
            this.w.bufferPacket(this.setup.write(), true);
            long v = 0L;
            for(Object object0: this.writtenPackets) {
                VorbisAudioData vorbisAudioData0 = (VorbisAudioData)object0;
                if(vorbisAudioData0.getGranulePosition() >= 0L && v != vorbisAudioData0.getGranulePosition()) {
                    this.w.flush();
                    v = vorbisAudioData0.getGranulePosition();
                    this.w.setGranulePosition(v);
                }
                this.w.bufferPacket(vorbisAudioData0.write());
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

    public VorbisComments getComment() {
        return this.comment;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioInfoHeader getInfo() {
        return this.getInfo();
    }

    public VorbisInfo getInfo() {
        return this.info;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioStream
    public OggStreamAudioData getNextAudioPacket() {
        return this.getNextAudioPacket();
    }

    public VorbisAudioData getNextAudioPacket() {
        OggPacket oggPacket0;
        while((oggPacket0 = this.r.getNextPacketWithSid(this.sid)) != null) {
            VorbisPacket vorbisPacket0 = VorbisPacketFactory.create(oggPacket0);
            if(vorbisPacket0 instanceof VorbisAudioData) {
                return (VorbisAudioData)vorbisPacket0;
            }
            System.err.println("Skipping non audio packet " + vorbisPacket0 + " mid audio stream");
        }
        return null;
    }

    public OggFile getOggFile() {
        return this.ogg;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioSetupHeader getSetup() {
        return this.getSetup();
    }

    public VorbisSetup getSetup() {
        return this.setup;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public int getSid() {
        return this.sid;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioTagsHeader getTags() {
        return this.getTags();
    }

    public VorbisComments getTags() {
        return this.comment;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggStreamType getType() {
        return OggStreamIdentifier.OGG_VORBIS;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioStream
    public void skipToGranule(long v) {
        this.r.skipToGranulePosition(this.sid, v);
    }

    public void writeAudioData(VorbisAudioData vorbisAudioData0) {
        this.writtenPackets.add(vorbisAudioData0);
    }
}

