package org.gagravarr.flac;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.gagravarr.ogg.OggFile;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggPacketReader;
import org.gagravarr.ogg.OggPacketWriter;
import org.gagravarr.ogg.OggStreamIdentifier.OggStreamType;
import org.gagravarr.ogg.OggStreamIdentifier;
import org.gagravarr.ogg.audio.OggAudioHeaders;
import org.gagravarr.ogg.audio.OggAudioInfoHeader;
import org.gagravarr.ogg.audio.OggAudioSetupHeader;
import org.gagravarr.ogg.audio.OggAudioTagsHeader;

public class FlacOggFile extends FlacFile implements OggAudioHeaders {
    private FlacFirstOggPacket firstPacket;
    private OggFile ogg;
    private OggPacketReader r;
    private int sid;
    private OggPacketWriter w;
    private List writtenAudio;

    public FlacOggFile(File file0) {
        this(new OggFile(new FileInputStream(file0)));
    }

    public FlacOggFile(OutputStream outputStream0) {
        this(outputStream0, new FlacOggInfo(), new FlacTags());
    }

    public FlacOggFile(OutputStream outputStream0, int v, FlacOggInfo flacOggInfo0, FlacTags flacTags0) {
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
        this.writtenAudio = new ArrayList();
        this.firstPacket = new FlacFirstOggPacket(flacOggInfo0);
        this.info = flacOggInfo0;
        this.tags = flacTags0;
    }

    public FlacOggFile(OutputStream outputStream0, FlacOggInfo flacOggInfo0, FlacTags flacTags0) {
        this(outputStream0, -1, flacOggInfo0, flacTags0);
    }

    public FlacOggFile(OggFile oggFile0) {
        this(oggFile0.getPacketReader());
        this.ogg = oggFile0;
    }

    public FlacOggFile(OggPacketReader oggPacketReader0) {
        OggPacket oggPacket0;
        this.sid = -1;
        this.r = oggPacketReader0;
        while(true) {
            oggPacket0 = oggPacketReader0.getNextPacket();
            if(oggPacket0 == null) {
                break;
            }
            if(oggPacket0.isBeginningOfStream() && oggPacket0.getData().length > 10 && FlacFirstOggPacket.isFlacStream(oggPacket0)) {
                this.sid = oggPacket0.getSid();
                break;
            }
        }
        FlacFirstOggPacket flacFirstOggPacket0 = new FlacFirstOggPacket(oggPacket0);
        this.firstPacket = flacFirstOggPacket0;
        this.info = flacFirstOggPacket0.getInfo();
        this.tags = new FlacTags(oggPacketReader0.getNextPacketWithSid(this.sid));
        this.otherMetadata = new ArrayList();
        do {
            OggPacket oggPacket1 = oggPacketReader0.getNextPacketWithSid(this.sid);
            if(oggPacket1 == null) {
                break;
            }
            FlacMetadataBlock flacMetadataBlock0 = FlacMetadataBlock.create(new ByteArrayInputStream(oggPacket1.getData()));
            this.otherMetadata.add(flacMetadataBlock0);
        }
        while(!flacMetadataBlock0.isLastMetadataBlock());
    }

    @Override  // org.gagravarr.flac.FlacFile
    public void close() {
        if(this.r != null) {
            this.r = null;
            this.ogg.close();
            this.ogg = null;
        }
        OggPacketWriter oggPacketWriter0 = this.w;
        if(oggPacketWriter0 != null) {
            oggPacketWriter0.bufferPacket(this.firstPacket.write(), true);
            this.w.bufferPacket(this.tags.write(), false);
            for(Object object0: this.writtenAudio) {
                this.w.bufferPacket(new OggPacket(((FlacAudioFrame)object0).getData()));
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

    public FlacFirstOggPacket getFirstPacket() {
        return this.firstPacket;
    }

    @Override  // org.gagravarr.flac.FlacFile
    public FlacInfo getInfo() {
        return this.getInfo();
    }

    public FlacOggInfo getInfo() {
        return (FlacOggInfo)this.info;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioInfoHeader getInfo() {
        return this.getInfo();
    }

    @Override  // org.gagravarr.flac.FlacFile
    public FlacAudioFrame getNextAudioPacket() {
        OggPacket oggPacket0 = this.r.getNextPacketWithSid(this.sid);
        return oggPacket0 == null ? null : new FlacAudioFrame(oggPacket0.getData());
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
        return super.getTags();
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggStreamType getType() {
        return OggStreamIdentifier.OGG_FLAC;
    }

    @Override  // org.gagravarr.flac.FlacFile
    public void skipToGranule(long v) {
        this.r.skipToGranulePosition(this.sid, v);
    }

    public void writeAudioData(FlacAudioFrame flacAudioFrame0) {
        this.writtenAudio.add(flacAudioFrame0);
    }
}

