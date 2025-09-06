package com.google.android.exoplayer2.extractor.mp4;

import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

final class MetadataUtil {
    private static final String LANGUAGE_UNDEFINED = "und";
    private static final String MDTA_KEY_ANDROID_CAPTURE_FPS = "com.android.capture.fps";
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 0x616C62;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 0x636F6D;
    private static final int SHORT_TYPE_COMPOSER_2 = 7828084;
    private static final int SHORT_TYPE_ENCODER = 0x746F6F;
    private static final int SHORT_TYPE_GENRE = 0x67656E;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 0x74726B;
    private static final int SHORT_TYPE_YEAR = 0x646179;
    static final String[] STANDARD_GENRES = null;
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 0x6370696C;
    private static final int TYPE_COVER_ART = 0x636F7672;
    private static final int TYPE_DISK_NUMBER = 0x6469736B;
    private static final int TYPE_GAPLESS_ALBUM = 0x70676170;
    private static final int TYPE_GENRE = 0x676E7265;
    private static final int TYPE_GROUPING = 0x677270;
    private static final int TYPE_INTERNAL = 757935405;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 0x736F616C;
    private static final int TYPE_SORT_ALBUM_ARTIST = 0x736F6161;
    private static final int TYPE_SORT_ARTIST = 0x736F6172;
    private static final int TYPE_SORT_COMPOSER = 0x736F636F;
    private static final int TYPE_SORT_TRACK_NAME = 0x736F6E6D;
    private static final int TYPE_TEMPO = 0x746D706F;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 0xA9;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 0xFD;
    private static final int TYPE_TRACK_NUMBER = 0x74726B6E;
    private static final int TYPE_TV_SHOW = 0x74767368;
    private static final int TYPE_TV_SORT_SHOW = 0x736F736E;

    static {
        MetadataUtil.STANDARD_GENRES = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    }

    public static Format getFormatWithMetadata(int v, Format format0, Metadata metadata0, Metadata metadata1, GaplessInfoHolder gaplessInfoHolder0) {
        switch(v) {
            case 1: {
                if(gaplessInfoHolder0.hasGaplessInfo()) {
                    format0 = format0.copyWithGaplessInfo(gaplessInfoHolder0.encoderDelay, gaplessInfoHolder0.encoderPadding);
                }
                return metadata0 == null ? format0 : format0.copyWithMetadata(metadata0);
            }
            case 2: {
                if(metadata1 != null) {
                    for(int v1 = 0; v1 < metadata1.length(); ++v1) {
                        Entry metadata$Entry0 = metadata1.get(v1);
                        if(metadata$Entry0 instanceof MdtaMetadataEntry && "com.android.capture.fps".equals(((MdtaMetadataEntry)metadata$Entry0).key)) {
                            format0 = format0.copyWithMetadata(new Metadata(new Entry[]{((MdtaMetadataEntry)metadata$Entry0)}));
                        }
                    }
                }
                return format0;
            }
            default: {
                return format0;
            }
        }
    }

    private static CommentFrame parseCommentAttribute(int v, ParsableByteArray parsableByteArray0) {
        int v1 = parsableByteArray0.readInt();
        if(parsableByteArray0.readInt() == 1684108385) {
            parsableByteArray0.skipBytes(8);
            String s = parsableByteArray0.readNullTerminatedString(v1 - 16);
            return new CommentFrame("und", s, s);
        }
        String s1 = Atom.getAtomTypeString(v);
        Log.w("MetadataUtil", (s1.length() == 0 ? new String("Failed to parse comment attribute: ") : "Failed to parse comment attribute: " + s1));
        return null;
    }

    private static ApicFrame parseCoverArt(ParsableByteArray parsableByteArray0) {
        String s;
        int v = parsableByteArray0.readInt();
        if(parsableByteArray0.readInt() == 1684108385) {
            int v1 = Atom.parseFullAtomFlags(parsableByteArray0.readInt());
            if(v1 == 13) {
                s = "image/jpeg";
            }
            else {
                s = v1 == 14 ? "image/png" : null;
            }
            if(s == null) {
                Z.q(41, v1, "Unrecognized cover art flags: ", "MetadataUtil");
                return null;
            }
            parsableByteArray0.skipBytes(4);
            byte[] arr_b = new byte[v - 16];
            parsableByteArray0.readBytes(arr_b, 0, v - 16);
            return new ApicFrame(s, null, 3, arr_b);
        }
        Log.w("MetadataUtil", "Failed to parse cover art attribute");
        return null;
    }

    public static Entry parseIlstElement(ParsableByteArray parsableByteArray0) {
        Entry metadata$Entry26;
        Entry metadata$Entry25;
        Entry metadata$Entry24;
        Entry metadata$Entry23;
        Entry metadata$Entry22;
        Entry metadata$Entry21;
        Entry metadata$Entry20;
        Entry metadata$Entry19;
        Entry metadata$Entry18;
        Entry metadata$Entry17;
        Entry metadata$Entry16;
        Entry metadata$Entry15;
        Entry metadata$Entry14;
        Entry metadata$Entry13;
        Entry metadata$Entry12;
        Entry metadata$Entry11;
        Entry metadata$Entry10;
        Entry metadata$Entry9;
        Entry metadata$Entry8;
        Entry metadata$Entry7;
        Entry metadata$Entry6;
        Entry metadata$Entry5;
        Entry metadata$Entry4;
        Entry metadata$Entry3;
        Entry metadata$Entry2;
        Entry metadata$Entry1;
        Entry metadata$Entry0;
        int v = parsableByteArray0.readInt() + parsableByteArray0.getPosition();
        int v1 = parsableByteArray0.readInt();
        try {
            if((v1 >> 24 & 0xFF) == 0xA9 || (v1 >> 24 & 0xFF) == 0xFD) {
                goto label_56;
            }
            else {
                switch(v1) {
                    case 757935405: {
                        goto label_53;
                    }
                    case 1631670868: {
                        goto label_23;
                    }
                    case 0x636F7672: {
                        goto label_20;
                    }
                    case 0x6370696C: {
                        goto label_17;
                    }
                    case 0x6469736B: {
                        goto label_8;
                    }
                    case 0x676E7265: {
                        metadata$Entry0 = MetadataUtil.parseStandardGenreAttribute(parsableByteArray0);
                        goto label_6;
                    }
                    case 0x70676170: {
                        goto label_44;
                    }
                    case 1920233063: {
                        goto label_41;
                    }
                    case 0x736F6161: {
                        goto label_35;
                    }
                    case 0x736F616C: {
                        goto label_29;
                    }
                    case 0x736F6172: {
                        goto label_32;
                    }
                    case 0x736F636F: {
                        goto label_38;
                    }
                    case 0x736F6E6D: {
                        goto label_26;
                    }
                    case 0x736F736E: {
                        goto label_47;
                    }
                    case 0x746D706F: {
                        goto label_14;
                    }
                    case 0x74726B6E: {
                        goto label_11;
                    }
                    case 0x74767368: {
                        goto label_50;
                    }
                }
            }
            goto label_88;
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
    label_6:
        parsableByteArray0.setPosition(v);
        return metadata$Entry0;
        try {
        label_8:
            metadata$Entry1 = MetadataUtil.parseIndexAndCountAttribute(0x6469736B, "TPOS", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry1;
        try {
        label_11:
            metadata$Entry2 = MetadataUtil.parseIndexAndCountAttribute(0x74726B6E, "TRCK", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry2;
        try {
        label_14:
            metadata$Entry3 = MetadataUtil.parseUint8Attribute(0x746D706F, "TBPM", parsableByteArray0, true, false);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry3;
        try {
        label_17:
            metadata$Entry4 = MetadataUtil.parseUint8Attribute(0x6370696C, "TCMP", parsableByteArray0, true, true);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry4;
        try {
        label_20:
            metadata$Entry5 = MetadataUtil.parseCoverArt(parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry5;
        try {
        label_23:
            metadata$Entry6 = MetadataUtil.parseTextAttribute(1631670868, "TPE2", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry6;
        try {
        label_26:
            metadata$Entry7 = MetadataUtil.parseTextAttribute(0x736F6E6D, "TSOT", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry7;
        try {
        label_29:
            metadata$Entry8 = MetadataUtil.parseTextAttribute(0x736F616C, "TSO2", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry8;
        try {
        label_32:
            metadata$Entry9 = MetadataUtil.parseTextAttribute(0x736F6172, "TSOA", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry9;
        try {
        label_35:
            metadata$Entry10 = MetadataUtil.parseTextAttribute(0x736F6161, "TSOP", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry10;
        try {
        label_38:
            metadata$Entry11 = MetadataUtil.parseTextAttribute(0x736F636F, "TSOC", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry11;
        try {
        label_41:
            metadata$Entry12 = MetadataUtil.parseUint8Attribute(1920233063, "ITUNESADVISORY", parsableByteArray0, false, false);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry12;
        try {
        label_44:
            metadata$Entry13 = MetadataUtil.parseUint8Attribute(0x70676170, "ITUNESGAPLESS", parsableByteArray0, false, true);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry13;
        try {
        label_47:
            metadata$Entry14 = MetadataUtil.parseTextAttribute(0x736F736E, "TVSHOWSORT", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry14;
        try {
        label_50:
            metadata$Entry15 = MetadataUtil.parseTextAttribute(0x74767368, "TVSHOW", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry15;
        try {
        label_53:
            metadata$Entry16 = MetadataUtil.parseInternalAttribute(parsableByteArray0, v);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry16;
        try {
        label_56:
            switch(0xFFFFFF & v1) {
                case 4280916: {
                    metadata$Entry17 = MetadataUtil.parseTextAttribute(v1, "TPE1", parsableByteArray0);
                    break;
                }
                case 0x616C62: {
                    goto label_61;
                }
                case 6516084: {
                    goto label_64;
                }
                case 0x646179: {
                    goto label_70;
                }
                case 0x67656E: {
                    goto label_73;
                }
                case 0x677270: {
                    goto label_76;
                }
                case 7108978: {
                    goto label_79;
                }
                case 0x746F6F: {
                    goto label_85;
                }
                case 7233901: 
                case 0x74726B: {
                    goto label_82;
                }
                case 0x636F6D: 
                case 7828084: {
                    goto label_67;
                }
                default: {
                    goto label_88;
                }
            }
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry17;
        try {
        label_61:
            metadata$Entry18 = MetadataUtil.parseTextAttribute(v1, "TALB", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry18;
        try {
        label_64:
            metadata$Entry19 = MetadataUtil.parseCommentAttribute(v1, parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry19;
        try {
        label_67:
            metadata$Entry20 = MetadataUtil.parseTextAttribute(v1, "TCOM", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry20;
        try {
        label_70:
            metadata$Entry21 = MetadataUtil.parseTextAttribute(v1, "TDRC", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry21;
        try {
        label_73:
            metadata$Entry22 = MetadataUtil.parseTextAttribute(v1, "TCON", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry22;
        try {
        label_76:
            metadata$Entry23 = MetadataUtil.parseTextAttribute(v1, "TIT1", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry23;
        try {
        label_79:
            metadata$Entry24 = MetadataUtil.parseTextAttribute(v1, "USLT", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry24;
        try {
        label_82:
            metadata$Entry25 = MetadataUtil.parseTextAttribute(v1, "TIT2", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry25;
        try {
        label_85:
            metadata$Entry26 = MetadataUtil.parseTextAttribute(v1, "TSSE", parsableByteArray0);
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return metadata$Entry26;
        try {
        label_88:
            String s = Atom.getAtomTypeString(v1);
            Log.d("MetadataUtil", (s.length() == 0 ? new String("Skipped unknown metadata entry: ") : "Skipped unknown metadata entry: " + s));
        }
        catch(Throwable throwable0) {
            parsableByteArray0.setPosition(v);
            throw throwable0;
        }
        parsableByteArray0.setPosition(v);
        return null;
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int v, String s, ParsableByteArray parsableByteArray0) {
        int v1 = parsableByteArray0.readInt();
        if(parsableByteArray0.readInt() == 1684108385 && v1 >= 22) {
            parsableByteArray0.skipBytes(10);
            int v2 = parsableByteArray0.readUnsignedShort();
            if(v2 > 0) {
                String s1 = v2;
                int v3 = parsableByteArray0.readUnsignedShort();
                if(v3 > 0) {
                    s1 = s1 + "/" + v3;
                }
                return new TextInformationFrame(s, null, s1);
            }
        }
        String s2 = Atom.getAtomTypeString(v);
        Log.w("MetadataUtil", (s2.length() == 0 ? new String("Failed to parse index/count attribute: ") : "Failed to parse index/count attribute: " + s2));
        return null;
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray parsableByteArray0, int v) {
        String s = null;
        String s1 = null;
        int v1 = -1;
        int v2 = -1;
        while(parsableByteArray0.getPosition() < v) {
            int v3 = parsableByteArray0.getPosition();
            int v4 = parsableByteArray0.readInt();
            int v5 = parsableByteArray0.readInt();
            parsableByteArray0.skipBytes(4);
            if(v5 == 1835360622) {
                s = parsableByteArray0.readNullTerminatedString(v4 - 12);
            }
            else {
                switch(v5) {
                    case 1684108385: {
                        v1 = v3;
                        v2 = v4;
                        parsableByteArray0.skipBytes(v4 - 12);
                        continue;
                    }
                    case 0x6E616D65: {
                        break;
                    }
                    default: {
                        parsableByteArray0.skipBytes(v4 - 12);
                        continue;
                    }
                }
                s1 = parsableByteArray0.readNullTerminatedString(v4 - 12);
            }
        }
        if(s != null && s1 != null && v1 != -1) {
            parsableByteArray0.setPosition(v1);
            parsableByteArray0.skipBytes(16);
            return new InternalFrame(s, s1, parsableByteArray0.readNullTerminatedString(v2 - 16));
        }
        return null;
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray parsableByteArray0, int v, String s) {
        int v1;
        while((v1 = parsableByteArray0.getPosition()) < v) {
            int v2 = parsableByteArray0.readInt();
            if(parsableByteArray0.readInt() == 1684108385) {
                int v3 = parsableByteArray0.readInt();
                int v4 = parsableByteArray0.readInt();
                byte[] arr_b = new byte[v2 - 16];
                parsableByteArray0.readBytes(arr_b, 0, v2 - 16);
                return new MdtaMetadataEntry(s, arr_b, v4, v3);
            }
            parsableByteArray0.setPosition(v1 + v2);
        }
        return null;
    }

    private static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray parsableByteArray0) {
        String s;
        int v = MetadataUtil.parseUint8AttributeValue(parsableByteArray0);
        if(v > 0) {
            String[] arr_s = MetadataUtil.STANDARD_GENRES;
            s = v <= arr_s.length ? arr_s[v - 1] : null;
        }
        else {
            s = null;
        }
        if(s != null) {
            return new TextInformationFrame("TCON", null, s);
        }
        Log.w("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    private static TextInformationFrame parseTextAttribute(int v, String s, ParsableByteArray parsableByteArray0) {
        int v1 = parsableByteArray0.readInt();
        if(parsableByteArray0.readInt() == 1684108385) {
            parsableByteArray0.skipBytes(8);
            return new TextInformationFrame(s, null, parsableByteArray0.readNullTerminatedString(v1 - 16));
        }
        String s1 = Atom.getAtomTypeString(v);
        Log.w("MetadataUtil", (s1.length() == 0 ? new String("Failed to parse text attribute: ") : "Failed to parse text attribute: " + s1));
        return null;
    }

    private static Id3Frame parseUint8Attribute(int v, String s, ParsableByteArray parsableByteArray0, boolean z, boolean z1) {
        int v1 = MetadataUtil.parseUint8AttributeValue(parsableByteArray0);
        if(z1) {
            v1 = Math.min(1, v1);
        }
        if(v1 >= 0) {
            return z ? new TextInformationFrame(s, null, Integer.toString(v1)) : new CommentFrame("und", s, Integer.toString(v1));
        }
        String s1 = Atom.getAtomTypeString(v);
        Log.w("MetadataUtil", (s1.length() == 0 ? new String("Failed to parse uint8 attribute: ") : "Failed to parse uint8 attribute: " + s1));
        return null;
    }

    private static int parseUint8AttributeValue(ParsableByteArray parsableByteArray0) {
        parsableByteArray0.skipBytes(4);
        if(parsableByteArray0.readInt() == 1684108385) {
            parsableByteArray0.skipBytes(8);
            return parsableByteArray0.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}

