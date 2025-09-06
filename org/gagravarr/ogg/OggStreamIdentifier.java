package org.gagravarr.ogg;

import org.gagravarr.flac.FlacFirstOggPacket;
import org.gagravarr.opus.OpusPacketFactory;
import org.gagravarr.skeleton.SkeletonPacketFactory;
import org.gagravarr.speex.SpeexPacketFactory;
import org.gagravarr.theora.TheoraPacketFactory;
import org.gagravarr.vorbis.VorbisPacketFactory;

public class OggStreamIdentifier {
    public static class OggStreamType {
        public static enum Kind {
            GENERAL,
            AUDIO,
            VIDEO,
            METADATA;

        }

        public final String description;
        public final Kind kind;
        public final String mimetype;

        public OggStreamType(String s, String s1, Kind oggStreamIdentifier$OggStreamType$Kind0) {
            this.mimetype = s;
            this.description = s1;
            this.kind = oggStreamIdentifier$OggStreamType$Kind0;
        }

        @Override
        public String toString() {
            return this.kind + " - " + this.description + " as " + this.mimetype;
        }
    }

    public static final OggStreamType CMML;
    public static final OggStreamType DAALA_VIDEO;
    public static final OggStreamType DIRAC_VIDEO;
    public static final OggStreamType KATE;
    protected static final byte[] MAGIC_ANNODEX2;
    protected static final byte[] MAGIC_CMML;
    protected static final byte[] MAGIC_DAALA;
    protected static final byte[] MAGIC_DIRAC;
    protected static final byte[] MAGIC_KATE;
    protected static final byte[] MAGIC_OGG_OGM;
    protected static final byte[] MAGIC_OGG_PCM;
    protected static final byte[] MAGIC_OGG_RGB;
    protected static final byte[] MAGIC_OGG_UVS;
    protected static final byte[] MAGIC_OGG_YUV;
    public static final OggStreamType NATIVE_FLAC;
    public static final OggStreamType OGG_AUDIO;
    public static final OggStreamType OGG_FLAC;
    public static final OggStreamType OGG_GENERAL;
    public static final OggStreamType OGG_PCM;
    public static final OggStreamType OGG_RGB;
    public static final OggStreamType OGG_UVS;
    public static final OggStreamType OGG_VIDEO;
    public static final OggStreamType OGG_VORBIS;
    public static final OggStreamType OGG_YUV;
    public static final OggStreamType OGM_VIDEO;
    public static final OggStreamType OPUS_AUDIO;
    public static final OggStreamType OPUS_AUDIO_ALT;
    public static final OggStreamType SKELETON;
    public static final OggStreamType SPEEX_AUDIO;
    public static final OggStreamType SPEEX_AUDIO_ALT;
    public static final OggStreamType THEORA_VIDEO;
    public static final OggStreamType THEORA_VIDEO_ALT;
    public static final OggStreamType UNKNOWN;

    static {
        OggStreamIdentifier.OGG_GENERAL = new OggStreamType("application/ogg", "Ogg", Kind.GENERAL);
        OggStreamIdentifier.OGG_VIDEO = new OggStreamType("video/ogg", "Ogg Video", Kind.VIDEO);
        OggStreamIdentifier.OGG_AUDIO = new OggStreamType("audio/ogg", "Ogg Audio", Kind.AUDIO);
        OggStreamIdentifier.UNKNOWN = new OggStreamType("application/octet-stream", "Unknown", Kind.GENERAL);
        OggStreamIdentifier.OGG_VORBIS = new OggStreamType("audio/vorbis", "Vorbis", Kind.AUDIO);
        OggStreamIdentifier.OPUS_AUDIO = new OggStreamType("audio/opus", "Opus", Kind.AUDIO);
        OggStreamIdentifier.OPUS_AUDIO_ALT = new OggStreamType("audio/ogg; codecs=opus", "Opus", Kind.AUDIO);
        OggStreamIdentifier.SPEEX_AUDIO = new OggStreamType("audio/speex", "Speex", Kind.AUDIO);
        OggStreamIdentifier.SPEEX_AUDIO_ALT = new OggStreamType("audio/ogg; codecs=speex", "Speex", Kind.AUDIO);
        OggStreamIdentifier.OGG_PCM = new OggStreamType("audio/x-oggpcm", "Ogg PCM", Kind.AUDIO);
        OggStreamIdentifier.NATIVE_FLAC = new OggStreamType("audio/x-flac", "FLAC", Kind.AUDIO);
        OggStreamIdentifier.OGG_FLAC = new OggStreamType("audio/x-oggflac", "FLAC", Kind.AUDIO);
        OggStreamIdentifier.THEORA_VIDEO = new OggStreamType("video/theora", "Theora", Kind.VIDEO);
        OggStreamIdentifier.THEORA_VIDEO_ALT = new OggStreamType("video/x-theora", "Theora", Kind.VIDEO);
        OggStreamIdentifier.DAALA_VIDEO = new OggStreamType("video/daala", "Daala", Kind.VIDEO);
        OggStreamIdentifier.DIRAC_VIDEO = new OggStreamType("video/x-dirac", "Dirac", Kind.VIDEO);
        OggStreamIdentifier.OGM_VIDEO = new OggStreamType("video/x-ogm", "Ogg OGM", Kind.VIDEO);
        OggStreamIdentifier.OGG_UVS = new OggStreamType("video/x-ogguvs", "Ogg UVS", Kind.VIDEO);
        OggStreamIdentifier.OGG_YUV = new OggStreamType("video/x-oggyuv", "Ogg YUV", Kind.VIDEO);
        OggStreamIdentifier.OGG_RGB = new OggStreamType("video/x-oggrgb", "Ogg RGB", Kind.VIDEO);
        OggStreamIdentifier.SKELETON = new OggStreamType("application/annodex", "Skeleton Annodex", Kind.METADATA);
        OggStreamIdentifier.CMML = new OggStreamType("text/x-cmml", "CMML", Kind.METADATA);
        OggStreamIdentifier.KATE = new OggStreamType("application/kate", "Kate", Kind.METADATA);
        OggStreamIdentifier.MAGIC_OGG_PCM = new byte[]{80, 67, 77, 0x20, 0x20, 0x20, 0x20, 0x20};
        byte[] arr_b = new byte[8];
        OggStreamIdentifier.MAGIC_DAALA = arr_b;
        arr_b[0] = (byte)0x80;
        IOUtils.putUTF8(arr_b, 1, "daala");
        OggStreamIdentifier.MAGIC_DIRAC = new byte[]{66, 66, 67, 68};
        OggStreamIdentifier.MAGIC_OGG_OGM = new byte[]{0x76, 105, 100, 101, 0x6F};
        OggStreamIdentifier.MAGIC_OGG_UVS = new byte[]{85, 86, 83, 0x20};
        OggStreamIdentifier.MAGIC_OGG_YUV = new byte[]{1, 89, 85, 86};
        OggStreamIdentifier.MAGIC_OGG_RGB = new byte[]{1, 71, 66, 80};
        OggStreamIdentifier.MAGIC_CMML = new byte[]{67, 77, 77, 76, 0, 0, 0, 0};
        byte[] arr_b1 = new byte[8];
        OggStreamIdentifier.MAGIC_KATE = arr_b1;
        arr_b1[0] = (byte)0x80;
        IOUtils.putUTF8(arr_b1, 1, "kate");
        OggStreamIdentifier.MAGIC_ANNODEX2 = new byte[]{65, 110, 110, 0x6F, 100, 101, 120, 0};
    }

    public static OggStreamType identifyType(OggPacket oggPacket0) {
        if(!oggPacket0.isBeginningOfStream()) {
            throw new IllegalArgumentException("Can only Identify from the first packet in a stream");
        }
        if(oggPacket0.getData() != null && oggPacket0.getData().length > 10) {
            if(SkeletonPacketFactory.isSkeletonStream(oggPacket0)) {
                return OggStreamIdentifier.SKELETON;
            }
            if(OggStreamIdentifier.isAnnodex2Stream(oggPacket0)) {
                return OggStreamIdentifier.SKELETON;
            }
            if(OggStreamIdentifier.isCMMLStream(oggPacket0)) {
                return OggStreamIdentifier.CMML;
            }
            if(OggStreamIdentifier.isKateStream(oggPacket0)) {
                return OggStreamIdentifier.KATE;
            }
            if(VorbisPacketFactory.isVorbisStream(oggPacket0)) {
                return OggStreamIdentifier.OGG_VORBIS;
            }
            if(SpeexPacketFactory.isSpeexStream(oggPacket0)) {
                return OggStreamIdentifier.SPEEX_AUDIO;
            }
            if(OpusPacketFactory.isOpusStream(oggPacket0)) {
                return OggStreamIdentifier.OPUS_AUDIO;
            }
            if(FlacFirstOggPacket.isFlacStream(oggPacket0)) {
                return OggStreamIdentifier.OGG_FLAC;
            }
            if(OggStreamIdentifier.isOggPCMStream(oggPacket0)) {
                return OggStreamIdentifier.OGG_PCM;
            }
            if(TheoraPacketFactory.isTheoraStream(oggPacket0)) {
                return OggStreamIdentifier.THEORA_VIDEO;
            }
            if(OggStreamIdentifier.isDaalaStream(oggPacket0)) {
                return OggStreamIdentifier.DAALA_VIDEO;
            }
            if(OggStreamIdentifier.isDiracStream(oggPacket0)) {
                return OggStreamIdentifier.DIRAC_VIDEO;
            }
            if(OggStreamIdentifier.isOggOGMStream(oggPacket0)) {
                return OggStreamIdentifier.OGM_VIDEO;
            }
            if(OggStreamIdentifier.isOggUVSStream(oggPacket0)) {
                return OggStreamIdentifier.OGG_UVS;
            }
            if(OggStreamIdentifier.isOggYUVStream(oggPacket0)) {
                return OggStreamIdentifier.OGG_YUV;
            }
            return OggStreamIdentifier.isOggRGBStream(oggPacket0) ? OggStreamIdentifier.OGG_RGB : OggStreamIdentifier.UNKNOWN;
        }
        return OggStreamIdentifier.UNKNOWN;
    }

    public static boolean isAnnodex2Stream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_ANNODEX2, oggPacket0.getData(), 0);
    }

    public static boolean isCMMLStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_CMML, oggPacket0.getData(), 0);
    }

    public static boolean isDaalaStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_DAALA, oggPacket0.getData(), 0);
    }

    public static boolean isDiracStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_DIRAC, oggPacket0.getData(), 0);
    }

    public static boolean isKateStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_KATE, oggPacket0.getData(), 0);
    }

    public static boolean isOggOGMStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_OGG_OGM, oggPacket0.getData(), 0);
    }

    public static boolean isOggPCMStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_OGG_PCM, oggPacket0.getData(), 0);
    }

    public static boolean isOggRGBStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_OGG_RGB, oggPacket0.getData(), 0);
    }

    public static boolean isOggUVSStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_OGG_UVS, oggPacket0.getData(), 0);
    }

    public static boolean isOggYUVStream(OggPacket oggPacket0) {
        return IOUtils.byteRangeMatches(OggStreamIdentifier.MAGIC_OGG_YUV, oggPacket0.getData(), 0);
    }
}

