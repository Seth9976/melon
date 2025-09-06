package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.UnrecognizedInputFormatException;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.upstream.ParsingLoadable.Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

public final class HlsPlaylistParser implements Parser {
    static class LineIterator {
        private final Queue extraLines;
        private String next;
        private final BufferedReader reader;

        public LineIterator(Queue queue0, BufferedReader bufferedReader0) {
            this.extraLines = queue0;
            this.reader = bufferedReader0;
        }

        @EnsuresNonNullIf(expression = {"next"}, result = true)
        public boolean hasNext() {
            if(this.next != null) {
                return true;
            }
            if(!this.extraLines.isEmpty()) {
                this.next = (String)Assertions.checkNotNull(((String)this.extraLines.poll()));
                return true;
            }
            while(true) {
                String s = this.reader.readLine();
                this.next = s;
                if(s == null) {
                    break;
                }
                String s1 = s.trim();
                this.next = s1;
                if(!s1.isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        public String next() {
            if(!this.hasNext()) {
                throw new NoSuchElementException();
            }
            String s = this.next;
            this.next = null;
            return s;
        }
    }

    private static final String ATTR_CLOSED_CAPTIONS_NONE = "CLOSED-CAPTIONS=NONE";
    private static final String BOOLEAN_FALSE = "NO";
    private static final String BOOLEAN_TRUE = "YES";
    private static final String KEYFORMAT_IDENTITY = "identity";
    private static final String KEYFORMAT_PLAYREADY = "com.microsoft.playready";
    private static final String KEYFORMAT_WIDEVINE_PSSH_BINARY = "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed";
    private static final String KEYFORMAT_WIDEVINE_PSSH_JSON = "com.widevine";
    private static final String METHOD_AES_128 = "AES-128";
    private static final String METHOD_NONE = "NONE";
    private static final String METHOD_SAMPLE_AES = "SAMPLE-AES";
    private static final String METHOD_SAMPLE_AES_CENC = "SAMPLE-AES-CENC";
    private static final String METHOD_SAMPLE_AES_CTR = "SAMPLE-AES-CTR";
    private static final String PLAYLIST_HEADER = "#EXTM3U";
    private static final Pattern REGEX_ATTR_BYTERANGE = null;
    private static final Pattern REGEX_AUDIO = null;
    private static final Pattern REGEX_AUTOSELECT = null;
    private static final Pattern REGEX_AVERAGE_BANDWIDTH = null;
    private static final Pattern REGEX_BANDWIDTH = null;
    private static final Pattern REGEX_BYTERANGE = null;
    private static final Pattern REGEX_CHANNELS = null;
    private static final Pattern REGEX_CHARACTERISTICS = null;
    private static final Pattern REGEX_CLOSED_CAPTIONS = null;
    private static final Pattern REGEX_CODECS = null;
    private static final Pattern REGEX_DEFAULT = null;
    private static final Pattern REGEX_FORCED = null;
    private static final Pattern REGEX_FRAME_RATE = null;
    private static final Pattern REGEX_GROUP_ID = null;
    private static final Pattern REGEX_IMPORT = null;
    private static final Pattern REGEX_INSTREAM_ID = null;
    private static final Pattern REGEX_IV = null;
    private static final Pattern REGEX_KEYFORMAT = null;
    private static final Pattern REGEX_KEYFORMATVERSIONS = null;
    private static final Pattern REGEX_LANGUAGE = null;
    private static final Pattern REGEX_MEDIA_DURATION = null;
    private static final Pattern REGEX_MEDIA_SEQUENCE = null;
    private static final Pattern REGEX_MEDIA_TITLE = null;
    private static final Pattern REGEX_METHOD = null;
    private static final Pattern REGEX_NAME = null;
    private static final Pattern REGEX_PLAYLIST_TYPE = null;
    private static final Pattern REGEX_RESOLUTION = null;
    private static final Pattern REGEX_SUBTITLES = null;
    private static final Pattern REGEX_TARGET_DURATION = null;
    private static final Pattern REGEX_TIME_OFFSET = null;
    private static final Pattern REGEX_TYPE = null;
    private static final Pattern REGEX_URI = null;
    private static final Pattern REGEX_VALUE = null;
    private static final Pattern REGEX_VARIABLE_REFERENCE = null;
    private static final Pattern REGEX_VERSION = null;
    private static final Pattern REGEX_VIDEO = null;
    private static final String TAG_BYTERANGE = "#EXT-X-BYTERANGE";
    private static final String TAG_DEFINE = "#EXT-X-DEFINE";
    private static final String TAG_DISCONTINUITY = "#EXT-X-DISCONTINUITY";
    private static final String TAG_DISCONTINUITY_SEQUENCE = "#EXT-X-DISCONTINUITY-SEQUENCE";
    private static final String TAG_ENDLIST = "#EXT-X-ENDLIST";
    private static final String TAG_GAP = "#EXT-X-GAP";
    private static final String TAG_INDEPENDENT_SEGMENTS = "#EXT-X-INDEPENDENT-SEGMENTS";
    private static final String TAG_INIT_SEGMENT = "#EXT-X-MAP";
    private static final String TAG_KEY = "#EXT-X-KEY";
    private static final String TAG_MEDIA = "#EXT-X-MEDIA";
    private static final String TAG_MEDIA_DURATION = "#EXTINF";
    private static final String TAG_MEDIA_SEQUENCE = "#EXT-X-MEDIA-SEQUENCE";
    private static final String TAG_PLAYLIST_TYPE = "#EXT-X-PLAYLIST-TYPE";
    private static final String TAG_PREFIX = "#EXT";
    private static final String TAG_PROGRAM_DATE_TIME = "#EXT-X-PROGRAM-DATE-TIME";
    private static final String TAG_SESSION_KEY = "#EXT-X-SESSION-KEY";
    private static final String TAG_START = "#EXT-X-START";
    private static final String TAG_STREAM_INF = "#EXT-X-STREAM-INF";
    private static final String TAG_TARGET_DURATION = "#EXT-X-TARGETDURATION";
    private static final String TAG_VERSION = "#EXT-X-VERSION";
    private static final String TYPE_AUDIO = "AUDIO";
    private static final String TYPE_CLOSED_CAPTIONS = "CLOSED-CAPTIONS";
    private static final String TYPE_SUBTITLES = "SUBTITLES";
    private static final String TYPE_VIDEO = "VIDEO";
    private final HlsMasterPlaylist masterPlaylist;

    static {
        HlsPlaylistParser.REGEX_AVERAGE_BANDWIDTH = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        HlsPlaylistParser.REGEX_VIDEO = Pattern.compile("VIDEO=\"(.+?)\"");
        HlsPlaylistParser.REGEX_AUDIO = Pattern.compile("AUDIO=\"(.+?)\"");
        HlsPlaylistParser.REGEX_SUBTITLES = Pattern.compile("SUBTITLES=\"(.+?)\"");
        HlsPlaylistParser.REGEX_CLOSED_CAPTIONS = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
        HlsPlaylistParser.REGEX_BANDWIDTH = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        HlsPlaylistParser.REGEX_CHANNELS = Pattern.compile("CHANNELS=\"(.+?)\"");
        HlsPlaylistParser.REGEX_CODECS = Pattern.compile("CODECS=\"(.+?)\"");
        HlsPlaylistParser.REGEX_RESOLUTION = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        HlsPlaylistParser.REGEX_FRAME_RATE = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        HlsPlaylistParser.REGEX_TARGET_DURATION = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        HlsPlaylistParser.REGEX_VERSION = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        HlsPlaylistParser.REGEX_PLAYLIST_TYPE = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        HlsPlaylistParser.REGEX_MEDIA_SEQUENCE = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        HlsPlaylistParser.REGEX_MEDIA_DURATION = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        HlsPlaylistParser.REGEX_MEDIA_TITLE = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
        HlsPlaylistParser.REGEX_TIME_OFFSET = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        HlsPlaylistParser.REGEX_BYTERANGE = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        HlsPlaylistParser.REGEX_ATTR_BYTERANGE = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        HlsPlaylistParser.REGEX_METHOD = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
        HlsPlaylistParser.REGEX_KEYFORMAT = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        HlsPlaylistParser.REGEX_KEYFORMATVERSIONS = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
        HlsPlaylistParser.REGEX_URI = Pattern.compile("URI=\"(.+?)\"");
        HlsPlaylistParser.REGEX_IV = Pattern.compile("IV=([^,.*]+)");
        HlsPlaylistParser.REGEX_TYPE = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        HlsPlaylistParser.REGEX_LANGUAGE = Pattern.compile("LANGUAGE=\"(.+?)\"");
        HlsPlaylistParser.REGEX_NAME = Pattern.compile("NAME=\"(.+?)\"");
        HlsPlaylistParser.REGEX_GROUP_ID = Pattern.compile("GROUP-ID=\"(.+?)\"");
        HlsPlaylistParser.REGEX_CHARACTERISTICS = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
        HlsPlaylistParser.REGEX_INSTREAM_ID = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        HlsPlaylistParser.REGEX_AUTOSELECT = HlsPlaylistParser.compileBooleanAttrPattern("AUTOSELECT");
        HlsPlaylistParser.REGEX_DEFAULT = HlsPlaylistParser.compileBooleanAttrPattern("DEFAULT");
        HlsPlaylistParser.REGEX_FORCED = HlsPlaylistParser.compileBooleanAttrPattern("FORCED");
        HlsPlaylistParser.REGEX_VALUE = Pattern.compile("VALUE=\"(.+?)\"");
        HlsPlaylistParser.REGEX_IMPORT = Pattern.compile("IMPORT=\"(.+?)\"");
        HlsPlaylistParser.REGEX_VARIABLE_REFERENCE = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    }

    public HlsPlaylistParser() {
        this(HlsMasterPlaylist.EMPTY);
    }

    public HlsPlaylistParser(HlsMasterPlaylist hlsMasterPlaylist0) {
        this.masterPlaylist = hlsMasterPlaylist0;
    }

    private static boolean checkPlaylistHeader(BufferedReader bufferedReader0) {
        int v = bufferedReader0.read();
        if(v == 0xEF) {
            if(bufferedReader0.read() == 0xBB && bufferedReader0.read() == 0xBF) {
                v = bufferedReader0.read();
                goto label_6;
            }
            return false;
        }
    label_6:
        int v1 = HlsPlaylistParser.skipIgnorableWhitespace(bufferedReader0, true, v);
        for(int v2 = 0; v2 < 7; ++v2) {
            if(v1 != "#EXTM3U".charAt(v2)) {
                return false;
            }
            v1 = bufferedReader0.read();
        }
        return Util.isLinebreak(HlsPlaylistParser.skipIgnorableWhitespace(bufferedReader0, false, v1));
    }

    private static Pattern compileBooleanAttrPattern(String s) {
        return Pattern.compile((s + "=(NO|YES)"));
    }

    private static Variant getVariantWithAudioGroup(ArrayList arrayList0, String s) {
        for(int v = 0; v < arrayList0.size(); ++v) {
            Variant hlsMasterPlaylist$Variant0 = (Variant)arrayList0.get(v);
            if(s.equals(hlsMasterPlaylist$Variant0.audioGroupId)) {
                return hlsMasterPlaylist$Variant0;
            }
        }
        return null;
    }

    private static Variant getVariantWithSubtitleGroup(ArrayList arrayList0, String s) {
        for(int v = 0; v < arrayList0.size(); ++v) {
            Variant hlsMasterPlaylist$Variant0 = (Variant)arrayList0.get(v);
            if(s.equals(hlsMasterPlaylist$Variant0.subtitleGroupId)) {
                return hlsMasterPlaylist$Variant0;
            }
        }
        return null;
    }

    private static Variant getVariantWithVideoGroup(ArrayList arrayList0, String s) {
        for(int v = 0; v < arrayList0.size(); ++v) {
            Variant hlsMasterPlaylist$Variant0 = (Variant)arrayList0.get(v);
            if(s.equals(hlsMasterPlaylist$Variant0.videoGroupId)) {
                return hlsMasterPlaylist$Variant0;
            }
        }
        return null;
    }

    public HlsPlaylist parse(Uri uri0, InputStream inputStream0) {
        BufferedReader bufferedReader0 = new BufferedReader(new InputStreamReader(inputStream0));
        ArrayDeque arrayDeque0 = new ArrayDeque();
        try {
            if(HlsPlaylistParser.checkPlaylistHeader(bufferedReader0)) {
                String s;
                while((s = bufferedReader0.readLine()) != null) {
                    String s1 = s.trim();
                    if(s1.isEmpty()) {
                        continue;
                    }
                    if(s1.startsWith("#EXT-X-STREAM-INF")) {
                        arrayDeque0.add(s1);
                        return HlsPlaylistParser.parseMasterPlaylist(new LineIterator(arrayDeque0, bufferedReader0), uri0.toString());
                    }
                    if(!s1.startsWith("#EXT-X-TARGETDURATION") && !s1.startsWith("#EXT-X-MEDIA-SEQUENCE") && !s1.startsWith("#EXTINF") && !s1.startsWith("#EXT-X-KEY") && !s1.startsWith("#EXT-X-BYTERANGE") && !s1.equals("#EXT-X-DISCONTINUITY") && !s1.equals("#EXT-X-DISCONTINUITY-SEQUENCE") && !s1.equals("#EXT-X-ENDLIST")) {
                        arrayDeque0.add(s1);
                        continue;
                    }
                    arrayDeque0.add(s1);
                    LineIterator hlsPlaylistParser$LineIterator0 = new LineIterator(arrayDeque0, bufferedReader0);
                    return HlsPlaylistParser.parseMediaPlaylist(this.masterPlaylist, hlsPlaylistParser$LineIterator0, uri0.toString());
                }
                throw new ParserException("Failed to parse the playlist, could not identify any tags.");
            }
        }
        finally {
            Util.closeQuietly(bufferedReader0);
        }
        throw new UnrecognizedInputFormatException("Input does not start with the #EXTM3U header.", uri0);
    }

    @Override  // com.google.android.exoplayer2.upstream.ParsingLoadable$Parser
    public Object parse(Uri uri0, InputStream inputStream0) {
        return this.parse(uri0, inputStream0);
    }

    private static double parseDoubleAttr(String s, Pattern pattern0) {
        return Double.parseDouble(HlsPlaylistParser.parseStringAttr(s, pattern0, Collections.EMPTY_MAP));
    }

    private static SchemeData parseDrmSchemeData(String s, String s1, Map map0) {
        String s2 = HlsPlaylistParser.parseOptionalStringAttr(s, HlsPlaylistParser.REGEX_KEYFORMATVERSIONS, "1", map0);
        if("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(s1)) {
            String s3 = HlsPlaylistParser.parseStringAttr(s, HlsPlaylistParser.REGEX_URI, map0);
            byte[] arr_b = Base64.decode(s3.substring(s3.indexOf(44)), 0);
            return new SchemeData(C.WIDEVINE_UUID, "video/mp4", arr_b);
        }
        if("com.widevine".equals(s1)) {
            byte[] arr_b1 = Util.getUtf8Bytes(s);
            return new SchemeData(C.WIDEVINE_UUID, "hls", arr_b1);
        }
        if("com.microsoft.playready".equals(s1) && "1".equals(s2)) {
            String s4 = HlsPlaylistParser.parseStringAttr(s, HlsPlaylistParser.REGEX_URI, map0);
            byte[] arr_b2 = Base64.decode(s4.substring(s4.indexOf(44)), 0);
            byte[] arr_b3 = PsshAtomUtil.buildPsshAtom(C.PLAYREADY_UUID, arr_b2);
            return new SchemeData(C.PLAYREADY_UUID, "video/mp4", arr_b3);
        }
        return null;
    }

    // 去混淆评级： 低(20)
    private static String parseEncryptionScheme(String s) {
        return "SAMPLE-AES-CENC".equals(s) || "SAMPLE-AES-CTR".equals(s) ? "cenc" : "cbcs";
    }

    private static int parseIntAttr(String s, Pattern pattern0) {
        return Integer.parseInt(HlsPlaylistParser.parseStringAttr(s, pattern0, Collections.EMPTY_MAP));
    }

    private static long parseLongAttr(String s, Pattern pattern0) {
        return Long.parseLong(HlsPlaylistParser.parseStringAttr(s, pattern0, Collections.EMPTY_MAP));
    }

    // This method was un-flattened
    private static HlsMasterPlaylist parseMasterPlaylist(LineIterator hlsPlaylistParser$LineIterator0, String s) {
        int v13;
        String s27;
        float f1;
        int v12;
        String s18;
        String s17;
        String s20;
        int v10;
        String s25;
        String s24;
        int v11;
        boolean z2;
        HashSet hashSet1;
        int v5;
        int v4;
        int v3;
        HashMap hashMap0 = new HashMap();
        HashMap hashMap1 = new HashMap();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        boolean z = false;
        boolean z1 = false;
        while(hlsPlaylistParser$LineIterator0.hasNext()) {
            String s1 = hlsPlaylistParser$LineIterator0.next();
            if(s1.startsWith("#EXT")) {
                arrayList7.add(s1);
            }
            if(s1.startsWith("#EXT-X-DEFINE")) {
                hashMap1.put(HlsPlaylistParser.parseStringAttr(s1, HlsPlaylistParser.REGEX_NAME, hashMap1), HlsPlaylistParser.parseStringAttr(s1, HlsPlaylistParser.REGEX_VALUE, hashMap1));
            }
            else if(s1.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                z1 = true;
            }
            else if(s1.startsWith("#EXT-X-MEDIA")) {
                arrayList5.add(s1);
            }
            else if(s1.startsWith("#EXT-X-SESSION-KEY")) {
                SchemeData drmInitData$SchemeData0 = HlsPlaylistParser.parseDrmSchemeData(s1, HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_KEYFORMAT, "identity", hashMap1), hashMap1);
                if(drmInitData$SchemeData0 == null) {
                    continue;
                }
                arrayList6.add(new DrmInitData(HlsPlaylistParser.parseEncryptionScheme(HlsPlaylistParser.parseStringAttr(s1, HlsPlaylistParser.REGEX_METHOD, hashMap1)), new SchemeData[]{drmInitData$SchemeData0}));
            }
            else if(s1.startsWith("#EXT-X-STREAM-INF")) {
                z |= s1.contains("CLOSED-CAPTIONS=NONE");
                int v = HlsPlaylistParser.parseIntAttr(s1, HlsPlaylistParser.REGEX_BANDWIDTH);
                HlsPlaylistParser.parseOptionalIntAttr(s1, HlsPlaylistParser.REGEX_AVERAGE_BANDWIDTH, -1);
                String s2 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_CODECS, hashMap1);
                String s3 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_RESOLUTION, hashMap1);
                if(s3 == null) {
                    v4 = -1;
                    v5 = -1;
                }
                else {
                    String[] arr_s = s3.split("x");
                    int v1 = Integer.parseInt(arr_s[0]);
                    int v2 = Integer.parseInt(arr_s[1]);
                    if(v1 <= 0 || v2 <= 0) {
                        v1 = -1;
                        v3 = -1;
                    }
                    else {
                        v3 = v2;
                    }
                    v4 = v1;
                    v5 = v3;
                }
                String s4 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_FRAME_RATE, hashMap1);
                float f = s4 == null ? -1.0f : Float.parseFloat(s4);
                String s5 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_VIDEO, hashMap1);
                String s6 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_AUDIO, hashMap1);
                String s7 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_SUBTITLES, hashMap1);
                String s8 = HlsPlaylistParser.parseOptionalStringAttr(s1, HlsPlaylistParser.REGEX_CLOSED_CAPTIONS, hashMap1);
                if(!hlsPlaylistParser$LineIterator0.hasNext()) {
                    throw new ParserException("#EXT-X-STREAM-INF tag must be followed by another line");
                }
                Uri uri0 = UriUtil.resolveToUri(s, HlsPlaylistParser.replaceVariableReferences(hlsPlaylistParser$LineIterator0.next(), hashMap1));
                arrayList0.add(new Variant(uri0, Format.createVideoContainerFormat(Integer.toString(arrayList0.size()), null, "application/x-mpegURL", null, s2, null, v, v4, v5, f, null, 0, 0), s5, s6, s7, s8));
                ArrayList arrayList8 = (ArrayList)hashMap0.get(uri0);
                if(arrayList8 == null) {
                    arrayList8 = new ArrayList();
                    hashMap0.put(uri0, arrayList8);
                }
                arrayList8.add(new VariantInfo(((long)v), s5, s6, s7, s8));
            }
        }
        ArrayList arrayList9 = new ArrayList();
        HashSet hashSet0 = new HashSet();
        int v6 = 0;
        while(v6 < arrayList0.size()) {
            Variant hlsMasterPlaylist$Variant0 = (Variant)arrayList0.get(v6);
            if(hashSet0.add(hlsMasterPlaylist$Variant0.url)) {
                Assertions.checkState(hlsMasterPlaylist$Variant0.format.metadata == null);
                hashSet1 = hashSet0;
                z2 = z;
                Metadata metadata0 = new Metadata(new Entry[]{new HlsTrackMetadataEntry(null, null, ((List)Assertions.checkNotNull(((ArrayList)hashMap0.get(hlsMasterPlaylist$Variant0.url)))))});
                arrayList9.add(hlsMasterPlaylist$Variant0.copyWithFormat(hlsMasterPlaylist$Variant0.format.copyWithMetadata(metadata0)));
            }
            else {
                hashSet1 = hashSet0;
                z2 = z;
            }
            ++v6;
            hashSet0 = hashSet1;
            z = z2;
        }
        Format format0 = null;
        List list0 = null;
        for(int v7 = 0; v7 < arrayList5.size(); ++v7) {
            String s9 = (String)arrayList5.get(v7);
            String s10 = HlsPlaylistParser.parseStringAttr(s9, HlsPlaylistParser.REGEX_GROUP_ID, hashMap1);
            String s11 = HlsPlaylistParser.parseStringAttr(s9, HlsPlaylistParser.REGEX_NAME, hashMap1);
            String s12 = HlsPlaylistParser.parseOptionalStringAttr(s9, HlsPlaylistParser.REGEX_URI, hashMap1);
            Uri uri1 = s12 == null ? null : UriUtil.resolveToUri(s, s12);
            String s13 = HlsPlaylistParser.parseOptionalStringAttr(s9, HlsPlaylistParser.REGEX_LANGUAGE, hashMap1);
            int v8 = HlsPlaylistParser.parseSelectionFlags(s9);
            int v9 = HlsPlaylistParser.parseRoleFlags(s9, hashMap1);
            String s14 = s10 + ":" + s11;
            Metadata metadata1 = new Metadata(new Entry[]{new HlsTrackMetadataEntry(s10, s11, Collections.EMPTY_LIST)});
            String s15 = HlsPlaylistParser.parseStringAttr(s9, HlsPlaylistParser.REGEX_TYPE, hashMap1);
            s15.getClass();
            switch(s15) {
                case "AUDIO": {
                    Variant hlsMasterPlaylist$Variant2 = HlsPlaylistParser.getVariantWithAudioGroup(arrayList0, s10);
                    String s21 = hlsMasterPlaylist$Variant2 == null ? null : Util.getCodecsOfType(hlsMasterPlaylist$Variant2.format.codecs, 1);
                    String s22 = s21 == null ? null : MimeTypes.getMediaMimeType(s21);
                    String s23 = HlsPlaylistParser.parseOptionalStringAttr(s9, HlsPlaylistParser.REGEX_CHANNELS, hashMap1);
                    if(s23 == null) {
                        s24 = s22;
                        s25 = s13;
                        v11 = -1;
                    }
                    else {
                        v11 = Integer.parseInt(Util.splitAtFirst(s23, "/")[0]);
                        if("audio/eac3".equals(s22) && s23.endsWith("/JOC")) {
                            s22 = "audio/eac3-joc";
                        }
                        s24 = s22;
                        s25 = s13;
                    }
                    Format format1 = Format.createAudioContainerFormat(s14, s11, "application/x-mpegURL", s24, s21, null, -1, v11, -1, null, v8, v9, s25);
                    if(uri1 == null) {
                        format0 = format1;
                    }
                    else {
                        arrayList2.add(new Rendition(uri1, format1.copyWithMetadata(metadata1), s10, s11));
                    }
                    break;
                }
                case "CLOSED-CAPTIONS": {
                    String s19 = HlsPlaylistParser.parseStringAttr(s9, HlsPlaylistParser.REGEX_INSTREAM_ID, hashMap1);
                    if(s19.startsWith("CC")) {
                        v10 = Integer.parseInt(s19.substring(2));
                        s20 = "application/cea-608";
                    }
                    else {
                        v10 = Integer.parseInt(s19.substring(7));
                        s20 = "application/cea-708";
                    }
                    if(list0 == null) {
                        list0 = new ArrayList();
                    }
                    list0.add(Format.createTextContainerFormat(s14, s11, null, s20, null, -1, v8, v9, s13, v10));
                    break;
                }
                case "SUBTITLES": {
                    Variant hlsMasterPlaylist$Variant1 = HlsPlaylistParser.getVariantWithSubtitleGroup(arrayList0, s10);
                    if(hlsMasterPlaylist$Variant1 == null) {
                        s17 = null;
                        s18 = null;
                    }
                    else {
                        String s16 = Util.getCodecsOfType(hlsMasterPlaylist$Variant1.format.codecs, 3);
                        s17 = MimeTypes.getMediaMimeType(s16);
                        s18 = s16;
                    }
                    if(s17 == null) {
                        s17 = "text/vtt";
                    }
                    arrayList3.add(new Rendition(uri1, Format.createTextContainerFormat(s14, s11, "application/x-mpegURL", s17, s18, -1, v8, v9, s13).copyWithMetadata(metadata1), s10, s11));
                    break;
                }
                case "VIDEO": {
                    Variant hlsMasterPlaylist$Variant3 = HlsPlaylistParser.getVariantWithVideoGroup(arrayList0, s10);
                    if(hlsMasterPlaylist$Variant3 == null) {
                        v12 = -1;
                        s27 = null;
                        v13 = -1;
                        f1 = -1.0f;
                    }
                    else {
                        String s26 = Util.getCodecsOfType(hlsMasterPlaylist$Variant3.format.codecs, 2);
                        v12 = hlsMasterPlaylist$Variant3.format.width;
                        f1 = hlsMasterPlaylist$Variant3.format.frameRate;
                        s27 = s26;
                        v13 = hlsMasterPlaylist$Variant3.format.height;
                    }
                    Format format2 = Format.createVideoContainerFormat(s14, s11, "application/x-mpegURL", (s27 == null ? null : MimeTypes.getMediaMimeType(s27)), s27, null, -1, v12, v13, f1, null, v8, v9).copyWithMetadata(metadata1);
                    if(uri1 != null) {
                        arrayList1.add(new Rendition(uri1, format2, s10, s11));
                    }
                }
            }
        }
        if(z) {
            list0 = Collections.EMPTY_LIST;
        }
        return new HlsMasterPlaylist(s, arrayList7, arrayList9, arrayList1, arrayList2, arrayList3, arrayList4, format0, list0, z1, hashMap1, arrayList6);
    }

    private static HlsMediaPlaylist parseMediaPlaylist(HlsMasterPlaylist hlsMasterPlaylist0, LineIterator hlsPlaylistParser$LineIterator0, String s) {
        int v16;
        DrmInitData drmInitData3;
        TreeMap treeMap2;
        long v15;
        String s16;
        boolean z4;
        long v13;
        String s12;
        TreeMap treeMap1;
        String s9;
        boolean z3;
        HashMap hashMap0 = new HashMap();
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        TreeMap treeMap0 = new TreeMap();
        long v = 0x8000000000000001L;
        long v1 = 0L;
        boolean z = hlsMasterPlaylist0.hasIndependentSegments;
        long v2 = 0x8000000000000001L;
        long v3 = 0L;
        long v4 = 0L;
        long v5 = 0L;
        long v6 = 0L;
        long v7 = 0L;
        String s1 = "";
        long v8 = -1L;
        int v9 = 0;
        String s2 = null;
        boolean z1 = false;
        int v10 = 1;
        boolean z2 = false;
        int v11 = 0;
        DrmInitData drmInitData0 = null;
        Segment hlsMediaPlaylist$Segment0 = null;
        String s3 = null;
        String s4 = null;
        int v12 = 0;
        DrmInitData drmInitData1 = null;
        while(true) {
            z3 = false;
        label_28:
            if(!hlsPlaylistParser$LineIterator0.hasNext()) {
                return Long.compare(v1, 0L) == 0 ? new HlsMediaPlaylist(v9, s, arrayList1, v, v1, z2, v11, v3, v10, v2, z, z1, false, drmInitData0, arrayList0) : new HlsMediaPlaylist(v9, s, arrayList1, v, v1, z2, v11, v3, v10, v2, z, z1, true, drmInitData0, arrayList0);
            }
            String s5 = hlsPlaylistParser$LineIterator0.next();
            if(s5.startsWith("#EXT")) {
                arrayList1.add(s5);
            }
            if(s5.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String s6 = HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_PLAYLIST_TYPE, hashMap0);
                if("VOD".equals(s6)) {
                    v9 = 1;
                }
                else {
                    if(!"EVENT".equals(s6)) {
                        goto label_28;
                    }
                    v9 = 2;
                }
                goto label_28;
            }
            if(s5.startsWith("#EXT-X-START")) {
                v = (long)(HlsPlaylistParser.parseDoubleAttr(s5, HlsPlaylistParser.REGEX_TIME_OFFSET) * 1000000.0);
                goto label_28;
            }
            if(s5.startsWith("#EXT-X-MAP")) {
                String s7 = HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_URI, hashMap0);
                String s8 = HlsPlaylistParser.parseOptionalStringAttr(s5, HlsPlaylistParser.REGEX_ATTR_BYTERANGE, hashMap0);
                if(s8 != null) {
                    String[] arr_s = s8.split("@");
                    v8 = Long.parseLong(arr_s[0]);
                    if(arr_s.length > 1) {
                        v4 = Long.parseLong(arr_s[1]);
                    }
                }
                if(s3 != null && s4 == null) {
                    throw new ParserException("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.");
                }
                hlsMediaPlaylist$Segment0 = new Segment(s7, v4, v8, s3, s4);
                v4 = 0L;
                v8 = -1L;
                goto label_28;
            }
            if(s5.startsWith("#EXT-X-TARGETDURATION")) {
                s9 = s4;
                v2 = 1000000L * ((long)HlsPlaylistParser.parseIntAttr(s5, HlsPlaylistParser.REGEX_TARGET_DURATION));
            }
            else {
                s9 = s4;
                if(s5.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                    v6 = HlsPlaylistParser.parseLongAttr(s5, HlsPlaylistParser.REGEX_MEDIA_SEQUENCE);
                    s4 = s9;
                    v3 = v6;
                    goto label_28;
                }
                else if(s5.startsWith("#EXT-X-VERSION")) {
                    v10 = HlsPlaylistParser.parseIntAttr(s5, HlsPlaylistParser.REGEX_VERSION);
                }
                else if(s5.startsWith("#EXT-X-DEFINE")) {
                    String s10 = HlsPlaylistParser.parseOptionalStringAttr(s5, HlsPlaylistParser.REGEX_IMPORT, hashMap0);
                    if(s10 == null) {
                        hashMap0.put(HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_NAME, hashMap0), HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_VALUE, hashMap0));
                    }
                    else {
                        String s11 = (String)hlsMasterPlaylist0.variableDefinitions.get(s10);
                        if(s11 != null) {
                            hashMap0.put(s10, s11);
                        }
                    }
                    treeMap1 = treeMap0;
                    s12 = s1;
                    v13 = v7;
                    z4 = z3;
                    goto label_193;
                }
                else if(s5.startsWith("#EXTINF")) {
                    double f = HlsPlaylistParser.parseDoubleAttr(s5, HlsPlaylistParser.REGEX_MEDIA_DURATION);
                    s1 = HlsPlaylistParser.parseOptionalStringAttr(s5, HlsPlaylistParser.REGEX_MEDIA_TITLE, "", hashMap0);
                    v7 = (long)(f * 1000000.0);
                    s4 = s9;
                    goto label_28;
                }
                else if(s5.startsWith("#EXT-X-KEY")) {
                    String s13 = HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_METHOD, hashMap0);
                    String s14 = HlsPlaylistParser.parseOptionalStringAttr(s5, HlsPlaylistParser.REGEX_KEYFORMAT, "identity", hashMap0);
                    if("NONE".equals(s13)) {
                        treeMap0.clear();
                        s3 = null;
                        s4 = null;
                        drmInitData1 = null;
                    }
                    else {
                        String s15 = HlsPlaylistParser.parseOptionalStringAttr(s5, HlsPlaylistParser.REGEX_IV, hashMap0);
                        if(!"identity".equals(s14)) {
                            if(s2 == null) {
                                s2 = HlsPlaylistParser.parseEncryptionScheme(s13);
                            }
                            SchemeData drmInitData$SchemeData0 = HlsPlaylistParser.parseDrmSchemeData(s5, s14, hashMap0);
                            if(drmInitData$SchemeData0 != null) {
                                treeMap0.put(s14, drmInitData$SchemeData0);
                                s4 = s15;
                                s3 = null;
                                drmInitData1 = null;
                                goto label_28;
                            }
                        }
                        else if("AES-128".equals(s13)) {
                            s3 = HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_URI, hashMap0);
                            s4 = s15;
                            goto label_28;
                        }
                        s4 = s15;
                        s3 = null;
                    }
                    goto label_28;
                }
                else if(s5.startsWith("#EXT-X-BYTERANGE")) {
                    String[] arr_s1 = HlsPlaylistParser.parseStringAttr(s5, HlsPlaylistParser.REGEX_BYTERANGE, hashMap0).split("@");
                    v8 = Long.parseLong(arr_s1[0]);
                    if(arr_s1.length > 1) {
                        v4 = Long.parseLong(arr_s1[1]);
                    }
                }
                else if(s5.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                    v11 = Integer.parseInt(s5.substring(s5.indexOf(58) + 1));
                    s4 = s9;
                    z2 = true;
                    goto label_28;
                }
                else if(s5.equals("#EXT-X-DISCONTINUITY")) {
                    ++v12;
                }
                else if(!s5.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                    goto label_135;
                }
                else if(v1 == 0L) {
                    v1 = C.msToUs(Util.parseXsDateTime(s5.substring(s5.indexOf(58) + 1))) - v5;
                }
                else {
                    break;
                }
            }
            s4 = s9;
            goto label_28;
        label_135:
            if(s5.equals("#EXT-X-GAP")) {
                s4 = s9;
                z3 = true;
                goto label_28;
            }
            if(s5.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                s4 = s9;
                z = true;
                goto label_28;
            }
            if(s5.equals("#EXT-X-ENDLIST")) {
                s4 = s9;
                z1 = true;
                goto label_28;
            }
            if(s5.startsWith("#")) {
                break;
            }
            if(s3 == null) {
                s16 = null;
            }
            else {
                s16 = s9 == null ? Long.toHexString(v6) : s9;
            }
            int v14 = Long.compare(v8, -1L);
            if(v14 == 0) {
                v4 = 0L;
            }
            if(drmInitData1 != null || treeMap0.isEmpty()) {
                v15 = v6 + 1L;
                treeMap2 = treeMap0;
                v16 = v14;
            }
            else {
                v15 = v6 + 1L;
                treeMap2 = treeMap0;
                SchemeData[] arr_drmInitData$SchemeData = (SchemeData[])treeMap0.values().toArray(new SchemeData[0]);
                DrmInitData drmInitData2 = new DrmInitData(s2, arr_drmInitData$SchemeData);
                if(drmInitData0 == null) {
                    SchemeData[] arr_drmInitData$SchemeData1 = new SchemeData[arr_drmInitData$SchemeData.length];
                    drmInitData3 = drmInitData2;
                    v16 = v14;
                    for(int v17 = 0; v17 < arr_drmInitData$SchemeData.length; ++v17) {
                        arr_drmInitData$SchemeData1[v17] = arr_drmInitData$SchemeData[v17].copyWithData(null);
                    }
                    drmInitData0 = new DrmInitData(s2, arr_drmInitData$SchemeData1);
                }
                else {
                    drmInitData3 = drmInitData2;
                    v16 = v14;
                }
                drmInitData1 = drmInitData3;
            }
            arrayList0.add(new Segment(HlsPlaylistParser.replaceVariableReferences(s5, hashMap0), hlsMediaPlaylist$Segment0, s1, v7, v12, v5, drmInitData1, s3, s16, v4, v8, z3));
            v5 += v7;
            if(v16 != 0) {
                v4 += v8;
            }
            s4 = s9;
            s1 = "";
            v7 = 0L;
            v8 = -1L;
            treeMap0 = treeMap2;
            v6 = v15;
        }
        treeMap1 = treeMap0;
        s12 = s1;
        v13 = v7;
        z4 = z3;
    label_193:
        s4 = s9;
        v7 = v13;
        z3 = z4;
        treeMap0 = treeMap1;
        s1 = s12;
        goto label_28;
    }

    private static boolean parseOptionalBooleanAttribute(String s, Pattern pattern0, boolean z) {
        Matcher matcher0 = pattern0.matcher(s);
        return matcher0.find() ? matcher0.group(1).equals("YES") : z;
    }

    private static int parseOptionalIntAttr(String s, Pattern pattern0, int v) {
        Matcher matcher0 = pattern0.matcher(s);
        return matcher0.find() ? Integer.parseInt(matcher0.group(1)) : v;
    }

    private static String parseOptionalStringAttr(String s, Pattern pattern0, String s1, Map map0) {
        Matcher matcher0 = pattern0.matcher(s);
        if(matcher0.find()) {
            s1 = matcher0.group(1);
        }
        return map0.isEmpty() || s1 == null ? s1 : HlsPlaylistParser.replaceVariableReferences(s1, map0);
    }

    private static String parseOptionalStringAttr(String s, Pattern pattern0, Map map0) {
        return HlsPlaylistParser.parseOptionalStringAttr(s, pattern0, null, map0);
    }

    private static int parseRoleFlags(String s, Map map0) {
        String s1 = HlsPlaylistParser.parseOptionalStringAttr(s, HlsPlaylistParser.REGEX_CHARACTERISTICS, map0);
        int v = 0;
        if(TextUtils.isEmpty(s1)) {
            return 0;
        }
        String[] arr_s = Util.split(s1, ",");
        if(Util.contains(arr_s, "public.accessibility.describes-video")) {
            v = 0x200;
        }
        if(Util.contains(arr_s, "public.accessibility.transcribes-spoken-dialog")) {
            v |= 0x1000;
        }
        if(Util.contains(arr_s, "public.accessibility.describes-music-and-sound")) {
            v |= 0x400;
        }
        return Util.contains(arr_s, "public.easy-to-read") ? v | 0x2000 : v;
    }

    private static int parseSelectionFlags(String s) {
        int v = HlsPlaylistParser.parseOptionalBooleanAttribute(s, HlsPlaylistParser.REGEX_DEFAULT, false);
        if(HlsPlaylistParser.parseOptionalBooleanAttribute(s, HlsPlaylistParser.REGEX_FORCED, false)) {
            v |= 2;
        }
        return HlsPlaylistParser.parseOptionalBooleanAttribute(s, HlsPlaylistParser.REGEX_AUTOSELECT, false) ? v | 4 : v;
    }

    private static String parseStringAttr(String s, Pattern pattern0, Map map0) {
        String s1 = HlsPlaylistParser.parseOptionalStringAttr(s, pattern0, map0);
        if(s1 == null) {
            throw new ParserException("Couldn\'t match " + pattern0.pattern() + " in " + s);
        }
        return s1;
    }

    private static String replaceVariableReferences(String s, Map map0) {
        Matcher matcher0 = HlsPlaylistParser.REGEX_VARIABLE_REFERENCE.matcher(s);
        StringBuffer stringBuffer0 = new StringBuffer();
        while(matcher0.find()) {
            String s1 = matcher0.group(1);
            if(map0.containsKey(s1)) {
                matcher0.appendReplacement(stringBuffer0, Matcher.quoteReplacement(((String)map0.get(s1))));
            }
        }
        matcher0.appendTail(stringBuffer0);
        return stringBuffer0.toString();
    }

    private static int skipIgnorableWhitespace(BufferedReader bufferedReader0, boolean z, int v) {
        while(v != -1 && Character.isWhitespace(v) && (z || !Util.isLinebreak(v))) {
            v = bufferedReader0.read();
        }
        return v;
    }
}

