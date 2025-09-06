package org.gagravarr.ogg.audio;

import org.gagravarr.flac.FlacFirstOggPacket;
import org.gagravarr.flac.FlacOggInfo;
import org.gagravarr.flac.FlacTags;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggStreamAudioData;
import org.gagravarr.ogg.OggStreamIdentifier.OggStreamType;
import org.gagravarr.ogg.OggStreamIdentifier;
import org.gagravarr.ogg.OggStreamPacket;
import org.gagravarr.opus.OpusInfo;
import org.gagravarr.opus.OpusPacketFactory;
import org.gagravarr.speex.SpeexInfo;
import org.gagravarr.speex.SpeexPacketFactory;
import org.gagravarr.vorbis.VorbisInfo;
import org.gagravarr.vorbis.VorbisPacketFactory;

public class OggAudioStreamHeaders implements OggAudioHeaders {
    private OggAudioInfoHeader info;
    private OggAudioSetupHeader setup;
    private int sid;
    private OggAudioTagsHeader tags;
    private OggStreamType type;

    private OggAudioStreamHeaders(int v, OggStreamType oggStreamIdentifier$OggStreamType0, OggAudioInfoHeader oggAudioInfoHeader0) {
        this.sid = v;
        this.type = oggStreamIdentifier$OggStreamType0;
        this.info = oggAudioInfoHeader0;
    }

    public static OggAudioStreamHeaders create(OggPacket oggPacket0) {
        if(!oggPacket0.isBeginningOfStream() || oggPacket0.getData() == null || oggPacket0.getData().length <= 10) {
            throw new IllegalArgumentException("May only be called for the first packet in a stream, with data");
        }
        int v = oggPacket0.getSid();
        if(VorbisPacketFactory.isVorbisStream(oggPacket0)) {
            VorbisInfo vorbisInfo0 = (VorbisInfo)VorbisPacketFactory.create(oggPacket0);
            return new OggAudioStreamHeaders(v, OggStreamIdentifier.OGG_VORBIS, vorbisInfo0);
        }
        if(SpeexPacketFactory.isSpeexStream(oggPacket0)) {
            SpeexInfo speexInfo0 = (SpeexInfo)SpeexPacketFactory.create(oggPacket0);
            return new OggAudioStreamHeaders(v, OggStreamIdentifier.SPEEX_AUDIO, speexInfo0);
        }
        if(OpusPacketFactory.isOpusStream(oggPacket0)) {
            OpusInfo opusInfo0 = (OpusInfo)OpusPacketFactory.create(oggPacket0);
            return new OggAudioStreamHeaders(v, OggStreamIdentifier.OPUS_AUDIO, opusInfo0);
        }
        if(!FlacFirstOggPacket.isFlacStream(oggPacket0)) {
            throw new IllegalArgumentException("Unsupported stream of type " + OggStreamIdentifier.identifyType(oggPacket0));
        }
        FlacOggInfo flacOggInfo0 = new FlacFirstOggPacket(oggPacket0).getInfo();
        return new OggAudioStreamHeaders(v, OggStreamIdentifier.OGG_FLAC, flacOggInfo0);
    }

    public OggStreamAudioData createAudio(OggPacket oggPacket0) {
        return (OggStreamAudioData)this.createNext(oggPacket0);
    }

    public OggStreamPacket createNext(OggPacket oggPacket0) {
        OggStreamType oggStreamIdentifier$OggStreamType0 = this.type;
        if(oggStreamIdentifier$OggStreamType0 == OggStreamIdentifier.OGG_VORBIS) {
            return VorbisPacketFactory.create(oggPacket0);
        }
        if(oggStreamIdentifier$OggStreamType0 == OggStreamIdentifier.SPEEX_AUDIO) {
            return SpeexPacketFactory.create(oggPacket0);
        }
        if(oggStreamIdentifier$OggStreamType0 == OggStreamIdentifier.OPUS_AUDIO) {
            return OpusPacketFactory.create(oggPacket0);
        }
        if(oggStreamIdentifier$OggStreamType0 != OggStreamIdentifier.OGG_FLAC) {
            throw new IllegalArgumentException("Unsupported stream of type " + this.type);
        }
        return null;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioInfoHeader getInfo() {
        return this.info;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioSetupHeader getSetup() {
        return this.setup;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public int getSid() {
        return this.sid;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggAudioTagsHeader getTags() {
        return this.tags;
    }

    @Override  // org.gagravarr.ogg.audio.OggAudioHeaders
    public OggStreamType getType() {
        return this.type;
    }

    public boolean populate(OggPacket oggPacket0) {
        if(this.type == OggStreamIdentifier.OGG_FLAC) {
            if(this.tags == null) {
                this.tags = new FlacTags(oggPacket0);
                return true;
            }
            return false;
        }
        OggStreamPacket oggStreamPacket0 = this.createNext(oggPacket0);
        if(oggStreamPacket0 instanceof OggAudioTagsHeader) {
            this.tags = (OggAudioTagsHeader)oggStreamPacket0;
            return this.type == OggStreamIdentifier.OGG_VORBIS;
        }
        if(!(oggStreamPacket0 instanceof OggAudioSetupHeader)) {
            throw new IllegalArgumentException("Expecting header packet but got " + oggStreamPacket0);
        }
        this.setup = (OggAudioSetupHeader)oggStreamPacket0;
        return false;
    }
}

