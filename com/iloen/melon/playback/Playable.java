package com.iloen.melon.playback;

import A8.b;
import P4.a;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.appcompat.app.o;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.constants.LiveStatusCode;
import com.iloen.melon.drm.DcfError;
import com.iloen.melon.mcache.CacheUrlBuilder;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE.ContentsInfo.Artists;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE.ContentsInfo;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.common.LiveInfoBase.Artist;
import com.iloen.melon.net.v6x.common.LiveInfoBase;
import com.iloen.melon.sns.model.SharableBase;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.cipher.Base62UUID;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.SongInfoBase;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import r8.g;

public class Playable extends SharableBase {
    public static class Builder {
        private String album;
        private String albumImgThumb;
        private List albumImgs;
        private String albumid;
        private String albumimg;
        private Map artistMap;
        private List bgImgs;
        private SpecialBgVideo bgVideo;
        private CType ctype;
        private String data;
        private String dbContentId;
        private String displayName;
        private long duration;
        private String flacCode;
        private List genreList;
        private String impossCode;
        private String impossDesc;
        private boolean isAudioSt;
        private boolean isBookFile;
        private boolean isBrandDj;
        private boolean isFlac16Avail;
        private boolean isFlac24Avail;
        private boolean isFlacAvail;
        private boolean isFlacSt;
        private boolean isLandscapeMv;
        private boolean isMusicWaveSong;
        private String issueDate;
        private long lastGetPathTime;
        private String liveSeq;
        private String liveStatusCode;
        private String liveTitle;
        private String localAlbumKey;
        private String lyricFileUpdtDate;
        private String lyricType;
        private String lyricpath;
        private long mediaStoreAlbumId;
        private String menuid;
        private long metaFlag;
        private String mimeType;
        private int mvHeight;
        private int mvWidth;
        private String mvid;
        private String mvname;
        private int order;
        private int origin;
        private String originMenuId;
        private int pInterval;
        private int playCount;
        private String playToken;
        private String postEditImg;
        private String postImg;
        private String pstime;
        private String songName;
        private int songid;
        private String statsElements;
        private String trackId;
        private String uriString;
        private int viewCount;

        private Builder(int v) {
            this.origin = 0;
            this.data = null;
            this.songName = "";
            this.artistMap = new LinkedHashMap();
            this.album = "";
            this.albumid = "";
            this.albumimg = "";
            this.albumImgThumb = "";
            this.mvid = "";
            this.mvname = "";
            this.lyricType = "";
            this.lyricpath = "";
            this.lyricFileUpdtDate = "";
            this.duration = 0L;
            this.songid = -1;
            this.ctype = null;
            this.menuid = "";
            this.metaFlag = 1L;
            this.viewCount = -1;
            this.issueDate = "";
            this.dbContentId = "";
            this.mediaStoreAlbumId = -1L;
            this.localAlbumKey = "";
            this.playCount = 0;
            this.order = 0;
            this.isFlacSt = false;
            this.postImg = "";
            this.postEditImg = "";
            this.isLandscapeMv = true;
            this.mvWidth = 0;
            this.mvHeight = 0;
            this.isBookFile = false;
            this.isFlacAvail = false;
            this.isFlac16Avail = false;
            this.isFlac24Avail = false;
            this.flacCode = "";
            this.albumImgs = new ArrayList();
            this.pstime = "";
            this.mimeType = "";
            this.originMenuId = "";
            this.statsElements = "";
            this.isAudioSt = false;
            this.impossCode = "";
            this.impossDesc = "";
            this.isBrandDj = false;
            this.genreList = new ArrayList();
            this.uriString = "";
            this.displayName = "";
            this.liveSeq = "";
            this.liveTitle = "";
            this.liveStatusCode = "";
            this.trackId = "";
            this.bgVideo = null;
            this.bgImgs = new ArrayList();
            this.pInterval = -1;
            this.playToken = "";
            this.lastGetPathTime = -1L;
            this.isMusicWaveSong = false;
            this.origin = v;
        }

        public Builder(int v, int v1) {
            this(v);
        }

        public static String A(Builder playable$Builder0) {
            return playable$Builder0.liveStatusCode;
        }

        public static String B(Builder playable$Builder0) {
            return playable$Builder0.liveTitle;
        }

        public static String C(Builder playable$Builder0) {
            return playable$Builder0.localAlbumKey;
        }

        public static String D(Builder playable$Builder0) {
            return playable$Builder0.lyricFileUpdtDate;
        }

        public static String E(Builder playable$Builder0) {
            return playable$Builder0.lyricType;
        }

        public static String F(Builder playable$Builder0) {
            return playable$Builder0.lyricpath;
        }

        public static long G(Builder playable$Builder0) {
            return playable$Builder0.mediaStoreAlbumId;
        }

        public static String H(Builder playable$Builder0) {
            return playable$Builder0.menuid;
        }

        public static long I(Builder playable$Builder0) {
            return playable$Builder0.metaFlag;
        }

        public static String J(Builder playable$Builder0) {
            return playable$Builder0.mimeType;
        }

        public static int K(Builder playable$Builder0) {
            return playable$Builder0.mvHeight;
        }

        public static int L(Builder playable$Builder0) {
            return playable$Builder0.mvWidth;
        }

        public static String M(Builder playable$Builder0) {
            return playable$Builder0.mvid;
        }

        public static String N(Builder playable$Builder0) {
            return playable$Builder0.mvname;
        }

        public static int O(Builder playable$Builder0) {
            return playable$Builder0.order;
        }

        public static int P(Builder playable$Builder0) {
            return playable$Builder0.origin;
        }

        public static String Q(Builder playable$Builder0) {
            return playable$Builder0.originMenuId;
        }

        public static int R(Builder playable$Builder0) {
            return playable$Builder0.pInterval;
        }

        public static int S(Builder playable$Builder0) {
            return playable$Builder0.playCount;
        }

        public static String T(Builder playable$Builder0) {
            return playable$Builder0.playToken;
        }

        public static String U(Builder playable$Builder0) {
            return playable$Builder0.postEditImg;
        }

        public static String V(Builder playable$Builder0) {
            return playable$Builder0.postImg;
        }

        public static String W(Builder playable$Builder0) {
            return playable$Builder0.pstime;
        }

        public static String X(Builder playable$Builder0) {
            return playable$Builder0.songName;
        }

        public static int Y(Builder playable$Builder0) {
            return playable$Builder0.songid;
        }

        public static String Z(Builder playable$Builder0) {
            return playable$Builder0.statsElements;
        }

        public static String a(Builder playable$Builder0) {
            return playable$Builder0.album;
        }

        public static String a0(Builder playable$Builder0) {
            return playable$Builder0.trackId;
        }

        public Builder albumId(String s) {
            this.albumid = s;
            return this;
        }

        public Builder albumIdName(String s, String s1) {
            return this.albumId(s).albumName(s1);
        }

        public Builder albumImg(String s) {
            this.albumimg = s;
            return this;
        }

        public Builder albumImgThumb(String s) {
            this.albumImgThumb = s;
            return this;
        }

        public Builder albumImgs(List list0) {
            this.albumImgs.addAll(list0);
            return this;
        }

        public Builder albumName(String s) {
            this.album = s;
            return this;
        }

        public Builder artists(Map map0) {
            this.artistMap.putAll(map0);
            return this;
        }

        public static String b(Builder playable$Builder0) {
            return playable$Builder0.albumImgThumb;
        }

        public static String b0(Builder playable$Builder0) {
            return playable$Builder0.uriString;
        }

        public Builder bgImgs(List list0) {
            if(list0 != null && !list0.isEmpty()) {
                this.bgImgs.addAll(list0);
            }
            return this;
        }

        public Builder bgVideo(SpecialBgVideo specialBgVideo0) {
            this.bgVideo = specialBgVideo0;
            return this;
        }

        public Playable build() {
            return new Playable(this, 0);
        }

        public static List c(Builder playable$Builder0) {
            return playable$Builder0.albumImgs;
        }

        public static int c0(Builder playable$Builder0) {
            return playable$Builder0.viewCount;
        }

        public Builder cType(CType cType0) {
            this.ctype = cType0;
            return this;
        }

        public Builder cType(String s) {
            return this.cType(CType.get(s));
        }

        public static String d(Builder playable$Builder0) {
            return playable$Builder0.albumid;
        }

        public Builder data(String s) {
            this.data = s;
            return this;
        }

        public Builder dbContentId(String s) {
            this.dbContentId = s;
            return this;
        }

        public Builder displayName(String s) {
            this.displayName = s;
            return this;
        }

        public Builder duration(long v) {
            this.duration = v;
            return this;
        }

        public static String e(Builder playable$Builder0) {
            return playable$Builder0.albumimg;
        }

        public static Map f(Builder playable$Builder0) {
            return playable$Builder0.artistMap;
        }

        public Builder flacCode(String s) {
            this.flacCode = s;
            return this;
        }

        public static List g(Builder playable$Builder0) {
            return playable$Builder0.bgImgs;
        }

        public Builder genreList(List list0) {
            if(list0 != null && !list0.isEmpty()) {
                this.genreList.addAll(list0);
            }
            return this;
        }

        public static SpecialBgVideo h(Builder playable$Builder0) {
            return playable$Builder0.bgVideo;
        }

        public Builder hasMv(int v) {
            if(v == 1) {
                this.metaFlag |= 0x80L;
                return this;
            }
            this.metaFlag &= 0xFFFFFFFFFFFFFF7FL;
            return this;
        }

        public Builder hasMv(String s) {
            return this.hasMv(ProtocolUtils.parseBoolean(s));
        }

        public Builder hasMv(boolean z) {
            return this.hasMv(((int)z));
        }

        public static CType i(Builder playable$Builder0) {
            return playable$Builder0.ctype;
        }

        public Builder impossCode(String s) {
            this.impossCode = s;
            return this;
        }

        public Builder impossDesc(String s) {
            this.impossDesc = s;
            return this;
        }

        public Builder isAdult(int v) {
            if(v == 1) {
                this.metaFlag |= 8L;
                return this;
            }
            this.metaFlag &= -9L;
            return this;
        }

        public Builder isAdult(String s) {
            return this.isAdult(ProtocolUtils.parseBoolean(s));
        }

        public Builder isAdult(boolean z) {
            return this.isAdult(((int)z));
        }

        public Builder isAudioSt(boolean z) {
            this.isAudioSt = z;
            return this;
        }

        public Builder isBookFile(boolean z) {
            this.isBookFile = z;
            return this;
        }

        public Builder isBrandDj(boolean z) {
            this.isBrandDj = z;
            return this;
        }

        public Builder isDownload(int v) {
            if(v == 1) {
                this.metaFlag |= 0x100L;
                return this;
            }
            this.metaFlag &= 0xFFFFFFFFFFFFFEFFL;
            return this;
        }

        public Builder isDownload(String s) {
            return this.isDownload(ProtocolUtils.parseBoolean(s));
        }

        public Builder isDownload(boolean z) {
            return this.isDownload(((int)z));
        }

        public Builder isFlac16Avail(boolean z) {
            this.isFlac16Avail = z;
            return this;
        }

        public Builder isFlac24Avail(boolean z) {
            this.isFlac24Avail = z;
            return this;
        }

        public Builder isFlacAvail(boolean z) {
            this.isFlacAvail = z;
            return this;
        }

        public Builder isFlacSt(boolean z) {
            this.isFlacSt = z;
            return this;
        }

        public Builder isFree(int v) {
            if(v == 1) {
                this.metaFlag |= 0x40L;
                return this;
            }
            this.metaFlag &= -65L;
            return this;
        }

        public Builder isFree(String s) {
            return this.isFree(ProtocolUtils.parseBoolean(s));
        }

        public Builder isFree(boolean z) {
            return this.isFree(((int)z));
        }

        public Builder isHitsong(int v) {
            if(v == 1) {
                this.metaFlag |= 16L;
                return this;
            }
            this.metaFlag &= -17L;
            return this;
        }

        public Builder isHitsong(String s) {
            return this.isHitsong(ProtocolUtils.parseBoolean(s));
        }

        public Builder isHitsong(boolean z) {
            return this.isHitsong(((int)z));
        }

        public Builder isHoldback(int v) {
            if(v == 1) {
                this.metaFlag |= 0x20L;
                return this;
            }
            this.metaFlag &= -33L;
            return this;
        }

        public Builder isHoldback(String s) {
            return this.isHoldback(ProtocolUtils.parseBoolean(s));
        }

        public Builder isHoldback(boolean z) {
            return this.isHoldback(((int)z));
        }

        public Builder isLandscapeMv(boolean z) {
            this.isLandscapeMv = z;
            return this;
        }

        public Builder isMelonSong(int v) {
            if(v == 1) {
                this.metaFlag |= 1L;
                return this;
            }
            this.metaFlag &= -2L;
            return this;
        }

        public Builder isMelonSong(String s) {
            return this.isMelonSong(ProtocolUtils.parseBoolean(s));
        }

        public Builder isMelonSong(boolean z) {
            return this.isMelonSong(((int)z));
        }

        public Builder isMusicWaveSong(boolean z) {
            this.isMusicWaveSong = z;
            return this;
        }

        public Builder isPrivate(int v) {
            if(v == 1) {
                this.metaFlag |= 0x1000L;
                return this;
            }
            this.metaFlag &= 0xFFFFFFFFFFFFEFFFL;
            return this;
        }

        public Builder isPrivate(String s) {
            return this.isPrivate(((int)"Y".equals(s)));
        }

        public Builder isPrivate(boolean z) {
            return this.isPrivate(((int)z));
        }

        public Builder isService(int v) {
            if(v == 1) {
                this.metaFlag |= 2L;
                return this;
            }
            this.metaFlag &= -3L;
            return this;
        }

        public Builder isService(String s) {
            return this.isService(ProtocolUtils.parseBoolean(s));
        }

        public Builder isService(boolean z) {
            return this.isService(((int)z));
        }

        public Builder isSong(int v) {
            if(v == 1) {
                this.metaFlag |= 0x800L;
                return this;
            }
            this.metaFlag &= 0xFFFFFFFFFFFFF7FFL;
            return this;
        }

        public Builder isSong(String s) {
            return this.isSong(ProtocolUtils.parseBoolean(s));
        }

        public Builder isSong(boolean z) {
            return this.isSong(((int)z));
        }

        public Builder isTitle(int v) {
            if(v == 1) {
                this.metaFlag |= 4L;
                return this;
            }
            this.metaFlag &= -5L;
            return this;
        }

        public Builder isTitle(String s) {
            return this.isTitle(ProtocolUtils.parseBoolean(s));
        }

        public Builder isTitle(boolean z) {
            return this.isTitle(((int)z));
        }

        public Builder issueDate(String s) {
            this.issueDate = s;
            return this;
        }

        public static String j(Builder playable$Builder0) {
            return playable$Builder0.data;
        }

        public static String k(Builder playable$Builder0) {
            return playable$Builder0.dbContentId;
        }

        public static String l(Builder playable$Builder0) {
            return playable$Builder0.displayName;
        }

        public Builder lastGetPathTime(long v) {
            this.lastGetPathTime = v;
            return this;
        }

        public Builder liveSeq(String s) {
            this.liveSeq = s;
            return this;
        }

        public Builder liveSeqTitle(String s, String s1) {
            return this.liveSeq(s).liveTitle(s1);
        }

        public Builder liveStatusCode(String s) {
            this.liveStatusCode = s;
            return this;
        }

        public Builder liveTitle(String s) {
            this.liveTitle = s;
            return this;
        }

        public Builder localAlbumKey(String s) {
            this.localAlbumKey = s;
            return this;
        }

        public Builder lyricFileUpdtDate(String s) {
            this.lyricFileUpdtDate = s;
            return this;
        }

        public Builder lyricType(String s) {
            this.lyricType = s;
            return this;
        }

        public Builder lyricpath(String s) {
            this.lyricpath = s;
            return this;
        }

        public static long m(Builder playable$Builder0) {
            return playable$Builder0.duration;
        }

        public Builder mediaStoreAlbumId(long v) {
            this.mediaStoreAlbumId = v;
            return this;
        }

        public Builder menuId(String s) {
            this.menuid = s;
            return this;
        }

        public Builder mimeType(String s) {
            this.mimeType = s;
            return this;
        }

        public Builder mvHeight(int v) {
            this.mvHeight = v;
            return this;
        }

        public Builder mvId(String s) {
            this.mvid = s;
            return this;
        }

        public Builder mvIdTitle(String s, String s1) {
            return this.mvId(s).mvTitle(s1);
        }

        public Builder mvTitle(String s) {
            this.mvname = s;
            return this;
        }

        public Builder mvWidth(int v) {
            this.mvWidth = v;
            return this;
        }

        public static String n(Builder playable$Builder0) {
            return playable$Builder0.flacCode;
        }

        public static List o(Builder playable$Builder0) {
            return playable$Builder0.genreList;
        }

        public Builder order(int v) {
            this.order = v;
            return this;
        }

        public Builder origin(int v) {
            this.origin = v;
            return this;
        }

        public Builder originMenuId(String s) {
            this.originMenuId = s;
            return this;
        }

        public static boolean p(Builder playable$Builder0) {
            return playable$Builder0.isBookFile;
        }

        public Builder pInterval(int v) {
            this.pInterval = v;
            return this;
        }

        public Builder playCount(int v) {
            this.playCount = v;
            return this;
        }

        public Builder playTime(String s) {
            return this.duration(ProtocolUtils.parseLongFromPlayTime(s));
        }

        public Builder playToken(String s) {
            this.playToken = s;
            return this;
        }

        public Builder postEditImg(String s) {
            this.postEditImg = s;
            return this;
        }

        public Builder postImg(String s) {
            this.postImg = s;
            return this;
        }

        public Builder pstime(String s) {
            this.pstime = s;
            return this;
        }

        public static boolean q(Builder playable$Builder0) {
            return playable$Builder0.isBrandDj;
        }

        public static boolean r(Builder playable$Builder0) {
            return playable$Builder0.isFlac16Avail;
        }

        public static boolean s(Builder playable$Builder0) {
            return playable$Builder0.isFlac24Avail;
        }

        public Builder songId(int v) {
            this.songid = v;
            return this;
        }

        public Builder songId(String s) {
            this.songid = ProtocolUtils.parseInt(s, -1);
            return this;
        }

        public Builder songIdTitle(int v, String s) {
            return this.songId(v).songName(s);
        }

        public Builder songIdTitle(String s, String s1) {
            return this.songId(s).songName(s1);
        }

        public Builder songName(String s) {
            this.songName = s;
            return this;
        }

        public Builder statsElements(StatsElementsBase statsElementsBase0) {
            return statsElementsBase0 == null ? this : this.statsElements(StatsElementsBase.toJsonString(statsElementsBase0));
        }

        public Builder statsElements(String s) {
            this.statsElements = s;
            return this;
        }

        public static boolean t(Builder playable$Builder0) {
            return playable$Builder0.isFlacAvail;
        }

        public Builder trackId(String s) {
            this.trackId = s;
            return this;
        }

        public static boolean u(Builder playable$Builder0) {
            return playable$Builder0.isFlacSt;
        }

        public Builder uriString(String s) {
            this.uriString = s;
            return this;
        }

        public static boolean v(Builder playable$Builder0) {
            return playable$Builder0.isLandscapeMv;
        }

        public Builder viewCount(int v) {
            this.viewCount = v;
            return this;
        }

        public Builder viewCount(String s) {
            return this.viewCount(ProtocolUtils.parseInt(s, 0));
        }

        public static boolean w(Builder playable$Builder0) {
            return playable$Builder0.isMusicWaveSong;
        }

        public static String x(Builder playable$Builder0) {
            return playable$Builder0.issueDate;
        }

        public static long y(Builder playable$Builder0) {
            return playable$Builder0.lastGetPathTime;
        }

        public static String z(Builder playable$Builder0) {
            return playable$Builder0.liveSeq;
        }
    }

    static final class MetaFlag {
        public static final int HAS_MV = 0x80;
        public static final int IS_ADULT = 8;
        public static final int IS_DOWNLOAD = 0x100;
        public static final int IS_FREE = 0x40;
        public static final int IS_HIT_SONG = 16;
        public static final int IS_HOLDBACK = 0x20;
        public static final int IS_MELON_SONG = 1;
        public static final int IS_PRIVATE = 0x1000;
        public static final int IS_SERVICE = 2;
        public static final int IS_SONG = 0x800;
        public static final int IS_TITLE = 4;
        public static final int IS_TRACKZERO = 0x2000;

    }

    public static final class ProtocolType {
        public static final String HLS = "HLS";
        public static final String HTTP = "HTTP";
        public static final String MCACHE = "MCACHE";
        public static final String PREMIUM = "PREMIUM";

    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int DOWNLOAD_ORIGIN_MELON = 0;
    public static final int DOWNLOAD_ORIGIN_NOWPLAYING = 1;
    public static final Playable EMPTY = null;
    public static final String INVALID_ALBUM_ID = "";
    public static final String INVALID_ARTIST_ID = "";
    public static final int INVALID_SONG_ID = -1;
    private static final boolean LOGV = false;
    public static final int ORIGIN_LOCAL = 1;
    public static final int ORIGIN_MELON = 0;
    public static final int ORIGIN_PLAYLIST = 0;
    private static final boolean SHORT_TOSTRING = false;
    private static final String TAG = "Playable";
    private String albumId;
    private String albumImg;
    private String albumImgThumb;
    private List albumImgs;
    private String albumName;
    private String artistIds;
    private Map artistMap;
    private String artistNames;
    private ArrayList bgImgs;
    private SpecialBgVideo bgVideo;
    private String bitrate;
    private String c;
    private CType cType;
    private long createdAt;
    private int createdSeq;
    private String data;
    private String dbContentId;
    private String displayName;
    private int downloadOrigin;
    private long duration;
    private long durationLimit;
    private String flacCode;
    private List genreList;
    private String impossCode;
    private String impossDesc;
    private boolean isAudioSt;
    private boolean isBookFile;
    private boolean isBrandDj;
    private boolean isFlac16Avail;
    private boolean isFlac24Avail;
    private boolean isFlacAvail;
    private boolean isFlacSt;
    private boolean isHttps;
    private boolean isLandscapeMv;
    private boolean isMusicWaveSong;
    @Deprecated
    private boolean isShowKakaoLoginPopup;
    private String issueDate;
    private long lastGetPathTime;
    private transient String lastPlaybackPath;
    private int likeCount;
    private int liked;
    private String liveSeq;
    private String liveStatusCode;
    private String liveTitle;
    private String localAlbumKey;
    private String loggingToken;
    private String lyricFileUpdtDate;
    private String lyricType;
    private String lyricsPath;
    private long mediaStoreAlbumId;
    private String menuId;
    private long metaFlag;
    private String metaType;
    private String mimeType;
    private int mvHeight;
    private String mvId;
    private String mvName;
    private int mvWidth;
    private int order;
    public int origin;
    private String originMenuId;
    private int pInterval;
    private int playCount;
    private String playToken;
    private String postEditImg;
    private String postImg;
    private String protocolType;
    private String pstime;
    private static final long serialVersionUID = 0x42F3AE2294F3F900L;
    private int songId;
    private String songName;
    private String statsElements;
    private String streamPath;
    private String trackId;
    private String uriString;
    private int viewCount;

    static {
        Playable.LOGV = false;
        Playable.SHORT_TOSTRING = b.d();
        Playable.EMPTY = new Playable("-1", CType.SONG, "");
        Playable.CREATOR = new Parcelable.Creator() {
            public Playable createFromParcel(Parcel parcel0) {
                return new Playable(parcel0, 0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public Playable[] newArray(int v) {
                return new Playable[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    private Playable() {
        this.origin = 0;
        this.streamPath = "";
        this.data = "";
        this.songName = "";
        this.artistMap = new LinkedHashMap();
        this.artistNames = "";
        this.artistIds = "";
        this.albumName = "";
        this.albumId = "";
        this.albumImg = "";
        this.albumImgThumb = "";
        this.mvId = "";
        this.mvName = "";
        this.duration = a.b;
        this.songId = -1;
        this.cType = null;
        this.menuId = "";
        this.durationLimit = -1L;
        this.liked = 0;
        this.likeCount = -1;
        this.viewCount = -1;
        this.issueDate = "";
        this.bitrate = "";
        this.metaType = "";
        this.loggingToken = "";
        this.protocolType = "";
        this.c = "";
        this.isHttps = false;
        this.lyricType = "";
        this.lyricsPath = "";
        this.lyricFileUpdtDate = "";
        this.metaFlag = 1L;
        this.createdSeq = -1;
        this.createdAt = 0L;
        this.downloadOrigin = 0;
        this.dbContentId = "";
        this.mediaStoreAlbumId = -1L;
        this.localAlbumKey = "";
        this.playCount = 0;
        this.order = 0;
        this.isFlacSt = false;
        this.isLandscapeMv = true;
        this.mvWidth = 0;
        this.mvHeight = 0;
        this.isShowKakaoLoginPopup = false;
        this.isBookFile = false;
        this.isFlacAvail = false;
        this.isFlac16Avail = false;
        this.isFlac24Avail = false;
        this.flacCode = "";
        this.albumImgs = new ArrayList();
        this.pstime = "";
        this.mimeType = "";
        this.originMenuId = "";
        this.statsElements = "";
        this.isAudioSt = false;
        this.impossCode = "";
        this.impossDesc = "";
        this.isBrandDj = false;
        this.genreList = new ArrayList();
        this.uriString = "";
        this.displayName = "";
        this.liveSeq = "";
        this.liveStatusCode = "";
        this.liveTitle = "";
        this.trackId = "";
        this.bgVideo = null;
        this.bgImgs = new ArrayList();
        this.pInterval = -1;
        this.playToken = "";
        this.lastGetPathTime = -1L;
        this.isMusicWaveSong = false;
    }

    private Playable(Parcel parcel0) {
        boolean z = false;
        this.origin = 0;
        this.streamPath = "";
        this.data = "";
        this.songName = "";
        this.artistMap = new LinkedHashMap();
        this.artistNames = "";
        this.artistIds = "";
        this.albumName = "";
        this.albumId = "";
        this.albumImg = "";
        this.albumImgThumb = "";
        this.mvId = "";
        this.mvName = "";
        this.duration = a.b;
        this.songId = -1;
        this.cType = null;
        this.menuId = "";
        this.durationLimit = -1L;
        this.liked = 0;
        this.likeCount = -1;
        this.viewCount = -1;
        this.issueDate = "";
        this.bitrate = "";
        this.metaType = "";
        this.loggingToken = "";
        this.protocolType = "";
        this.c = "";
        this.isHttps = false;
        this.lyricType = "";
        this.lyricsPath = "";
        this.lyricFileUpdtDate = "";
        this.metaFlag = 1L;
        this.createdSeq = -1;
        this.createdAt = 0L;
        this.downloadOrigin = 0;
        this.dbContentId = "";
        this.mediaStoreAlbumId = -1L;
        this.localAlbumKey = "";
        this.playCount = 0;
        this.order = 0;
        this.isFlacSt = false;
        this.isLandscapeMv = true;
        this.mvWidth = 0;
        this.mvHeight = 0;
        this.isShowKakaoLoginPopup = false;
        this.isBookFile = false;
        this.isFlacAvail = false;
        this.isFlac16Avail = false;
        this.isFlac24Avail = false;
        this.flacCode = "";
        this.albumImgs = new ArrayList();
        this.pstime = "";
        this.mimeType = "";
        this.originMenuId = "";
        this.statsElements = "";
        this.isAudioSt = false;
        this.impossCode = "";
        this.impossDesc = "";
        this.isBrandDj = false;
        this.genreList = new ArrayList();
        this.uriString = "";
        this.displayName = "";
        this.liveSeq = "";
        this.liveStatusCode = "";
        this.liveTitle = "";
        this.trackId = "";
        this.bgVideo = null;
        this.bgImgs = new ArrayList();
        this.pInterval = -1;
        this.playToken = "";
        this.lastGetPathTime = -1L;
        this.isMusicWaveSong = false;
        this.origin = parcel0.readInt();
        this.data = parcel0.readString();
        this.songName = parcel0.readString();
        this.artistMap = (LinkedHashMap)parcel0.readSerializable();
        this.artistNames = parcel0.readString();
        this.artistIds = parcel0.readString();
        this.albumName = parcel0.readString();
        this.albumId = parcel0.readString();
        this.albumImg = parcel0.readString();
        this.albumImgThumb = parcel0.readString();
        this.mvId = parcel0.readString();
        this.mvName = parcel0.readString();
        this.duration = parcel0.readLong();
        this.songId = parcel0.readInt();
        this.cType = CType.get(parcel0.readString());
        this.menuId = parcel0.readString();
        this.streamPath = parcel0.readString();
        this.durationLimit = parcel0.readLong();
        this.liked = parcel0.readInt();
        this.likeCount = parcel0.readInt();
        this.viewCount = parcel0.readInt();
        this.issueDate = parcel0.readString();
        this.bitrate = parcel0.readString();
        this.metaType = parcel0.readString();
        this.loggingToken = parcel0.readString();
        this.protocolType = parcel0.readString();
        this.c = parcel0.readString();
        this.lyricType = parcel0.readString();
        this.lyricsPath = parcel0.readString();
        this.lyricFileUpdtDate = parcel0.readString();
        this.metaFlag = parcel0.readLong();
        this.createdSeq = parcel0.readInt();
        this.createdAt = parcel0.readLong();
        this.downloadOrigin = parcel0.readInt();
        this.dbContentId = parcel0.readString();
        this.mediaStoreAlbumId = parcel0.readLong();
        this.localAlbumKey = parcel0.readString();
        this.playCount = parcel0.readInt();
        this.order = parcel0.readInt();
        this.isFlacSt = parcel0.readInt() > 0;
        this.postImg = parcel0.readString();
        this.postEditImg = parcel0.readString();
        this.isLandscapeMv = parcel0.readInt() > 0;
        this.mvWidth = parcel0.readInt();
        this.mvHeight = parcel0.readInt();
        this.isBookFile = parcel0.readInt() > 0;
        this.isFlacAvail = parcel0.readInt() > 0;
        this.isFlac16Avail = parcel0.readInt() > 0;
        this.isFlac24Avail = parcel0.readInt() > 0;
        this.flacCode = parcel0.readString();
        this.albumImgs = (ArrayList)parcel0.readSerializable();
        this.pstime = parcel0.readString();
        this.mimeType = parcel0.readString();
        this.originMenuId = parcel0.readString();
        this.statsElements = parcel0.readString();
        this.isBrandDj = parcel0.readInt() > 0;
        this.genreList = (List)parcel0.readSerializable();
        this.uriString = parcel0.readString();
        this.displayName = parcel0.readString();
        this.liveSeq = parcel0.readString();
        this.liveTitle = parcel0.readString();
        this.liveStatusCode = parcel0.readString();
        this.trackId = parcel0.readString();
        this.bgVideo = (SpecialBgVideo)parcel0.readSerializable();
        this.bgImgs = (ArrayList)parcel0.readSerializable();
        this.pInterval = parcel0.readInt();
        this.playToken = parcel0.readString();
        this.lastGetPathTime = parcel0.readLong();
        if(parcel0.readInt() > 0) {
            z = true;
        }
        this.isMusicWaveSong = z;
        if(Playable.LOGV) {
            LogU.v("Playable", "created from Parcel:" + this);
        }
    }

    public Playable(Parcel parcel0, int v) {
        this(parcel0);
    }

    private Playable(Builder playable$Builder0) {
        this.origin = 0;
        this.streamPath = "";
        this.data = "";
        this.songName = "";
        this.artistMap = new LinkedHashMap();
        this.artistNames = "";
        this.artistIds = "";
        this.albumName = "";
        this.albumId = "";
        this.albumImg = "";
        this.albumImgThumb = "";
        this.mvId = "";
        this.mvName = "";
        this.duration = a.b;
        this.songId = -1;
        this.cType = null;
        this.menuId = "";
        this.durationLimit = -1L;
        this.liked = 0;
        this.likeCount = -1;
        this.viewCount = -1;
        this.issueDate = "";
        this.bitrate = "";
        this.metaType = "";
        this.loggingToken = "";
        this.protocolType = "";
        this.c = "";
        this.isHttps = false;
        this.lyricType = "";
        this.lyricsPath = "";
        this.lyricFileUpdtDate = "";
        this.metaFlag = 1L;
        this.createdSeq = -1;
        this.createdAt = 0L;
        this.downloadOrigin = 0;
        this.dbContentId = "";
        this.mediaStoreAlbumId = -1L;
        this.localAlbumKey = "";
        this.playCount = 0;
        this.order = 0;
        this.isFlacSt = false;
        this.isLandscapeMv = true;
        this.mvWidth = 0;
        this.mvHeight = 0;
        this.isShowKakaoLoginPopup = false;
        this.isBookFile = false;
        this.isFlacAvail = false;
        this.isFlac16Avail = false;
        this.isFlac24Avail = false;
        this.flacCode = "";
        this.albumImgs = new ArrayList();
        this.pstime = "";
        this.mimeType = "";
        this.originMenuId = "";
        this.statsElements = "";
        this.isAudioSt = false;
        this.impossCode = "";
        this.impossDesc = "";
        this.isBrandDj = false;
        this.genreList = new ArrayList();
        this.uriString = "";
        this.displayName = "";
        this.liveSeq = "";
        this.liveStatusCode = "";
        this.liveTitle = "";
        this.trackId = "";
        this.bgVideo = null;
        this.bgImgs = new ArrayList();
        this.pInterval = -1;
        this.playToken = "";
        this.lastGetPathTime = -1L;
        this.isMusicWaveSong = false;
        this.origin = Builder.P(playable$Builder0);
        this.data = Builder.j(playable$Builder0);
        this.setSongName(Builder.X(playable$Builder0));
        this.artistMap.putAll(Builder.f(playable$Builder0));
        this.artistIds = StringUtils.parseToCsv(Builder.f(playable$Builder0).keySet(), false, false);
        this.artistNames = StringUtils.parseToCsv(Builder.f(playable$Builder0).values(), false, true);
        this.albumName = Builder.a(playable$Builder0);
        this.albumId = Builder.d(playable$Builder0);
        this.albumImg = Builder.e(playable$Builder0);
        this.albumImgThumb = Builder.b(playable$Builder0);
        this.mvId = Builder.M(playable$Builder0);
        this.mvName = Builder.N(playable$Builder0);
        this.setLyricType(Builder.E(playable$Builder0));
        this.setLyricspath(Builder.F(playable$Builder0));
        this.setLyricLastUpdated(Builder.D(playable$Builder0));
        this.setDuration(Builder.m(playable$Builder0));
        this.setSongid(Builder.Y(playable$Builder0));
        this.cType = Builder.i(playable$Builder0);
        this.menuId = Builder.H(playable$Builder0);
        this.metaFlag = Builder.I(playable$Builder0);
        this.viewCount = Builder.c0(playable$Builder0);
        this.issueDate = Builder.x(playable$Builder0);
        this.dbContentId = Builder.k(playable$Builder0);
        this.mediaStoreAlbumId = Builder.G(playable$Builder0);
        this.localAlbumKey = Builder.C(playable$Builder0);
        this.playCount = Builder.S(playable$Builder0);
        this.order = Builder.O(playable$Builder0);
        this.isFlacSt = Builder.u(playable$Builder0);
        this.postImg = Builder.V(playable$Builder0);
        this.postEditImg = Builder.U(playable$Builder0);
        this.isLandscapeMv = Builder.v(playable$Builder0);
        this.mvWidth = Builder.L(playable$Builder0);
        this.mvHeight = Builder.K(playable$Builder0);
        this.isBookFile = Builder.p(playable$Builder0);
        this.isFlacAvail = Builder.t(playable$Builder0);
        this.isFlac16Avail = Builder.r(playable$Builder0);
        this.isFlac24Avail = Builder.s(playable$Builder0);
        this.flacCode = Builder.n(playable$Builder0);
        this.albumImgs.addAll(Builder.c(playable$Builder0));
        this.pstime = Builder.W(playable$Builder0);
        this.mimeType = Builder.J(playable$Builder0);
        this.originMenuId = Builder.Q(playable$Builder0);
        this.statsElements = Builder.Z(playable$Builder0);
        this.isBrandDj = Builder.q(playable$Builder0);
        this.genreList.addAll(Builder.o(playable$Builder0));
        this.uriString = Builder.b0(playable$Builder0);
        this.displayName = Builder.l(playable$Builder0);
        this.bgVideo = Builder.h(playable$Builder0);
        this.bgImgs.addAll(Builder.g(playable$Builder0));
        this.liveSeq = Builder.z(playable$Builder0);
        this.liveTitle = Builder.B(playable$Builder0);
        this.liveStatusCode = Builder.A(playable$Builder0);
        this.trackId = TextUtils.isEmpty(Builder.a0(playable$Builder0)) ? Base62UUID.randomUUID() : Builder.a0(playable$Builder0);
        this.pInterval = Builder.R(playable$Builder0);
        this.playToken = Builder.T(playable$Builder0);
        this.lastGetPathTime = Builder.y(playable$Builder0);
        this.isMusicWaveSong = Builder.w(playable$Builder0);
    }

    public Playable(Builder playable$Builder0, int v) {
        this(playable$Builder0);
    }

    private Playable(String s, CType cType0, String s1) {
        this.origin = 0;
        this.streamPath = "";
        this.data = "";
        this.songName = "";
        this.artistMap = new LinkedHashMap();
        this.artistNames = "";
        this.artistIds = "";
        this.albumName = "";
        this.albumId = "";
        this.albumImg = "";
        this.albumImgThumb = "";
        this.mvId = "";
        this.mvName = "";
        this.duration = a.b;
        this.songId = -1;
        this.cType = null;
        this.menuId = "";
        this.durationLimit = -1L;
        this.liked = 0;
        this.likeCount = -1;
        this.viewCount = -1;
        this.issueDate = "";
        this.bitrate = "";
        this.metaType = "";
        this.loggingToken = "";
        this.protocolType = "";
        this.c = "";
        this.isHttps = false;
        this.lyricType = "";
        this.lyricsPath = "";
        this.lyricFileUpdtDate = "";
        this.metaFlag = 1L;
        this.createdSeq = -1;
        this.createdAt = 0L;
        this.downloadOrigin = 0;
        this.dbContentId = "";
        this.mediaStoreAlbumId = -1L;
        this.localAlbumKey = "";
        this.playCount = 0;
        this.order = 0;
        this.isFlacSt = false;
        this.isLandscapeMv = true;
        this.mvWidth = 0;
        this.mvHeight = 0;
        this.isShowKakaoLoginPopup = false;
        this.isBookFile = false;
        this.isFlacAvail = false;
        this.isFlac16Avail = false;
        this.isFlac24Avail = false;
        this.flacCode = "";
        this.albumImgs = new ArrayList();
        this.pstime = "";
        this.mimeType = "";
        this.originMenuId = "";
        this.statsElements = "";
        this.isAudioSt = false;
        this.impossCode = "";
        this.impossDesc = "";
        this.isBrandDj = false;
        this.genreList = new ArrayList();
        this.uriString = "";
        this.displayName = "";
        this.liveSeq = "";
        this.liveStatusCode = "";
        this.liveTitle = "";
        this.trackId = "";
        this.bgVideo = null;
        this.bgImgs = new ArrayList();
        this.pInterval = -1;
        this.playToken = "";
        this.lastGetPathTime = -1L;
        this.isMusicWaveSong = false;
        this.setSongid(s);
        this.setCtype(cType0);
        this.setMenuid(s1);
    }

    public static Playable copyValueOf(Playable playable0) {
        boolean z = Playable.LOGV;
        if(z) {
            LogU.v("Playable", "copyValueOf() origin:" + playable0);
        }
        Playable playable1 = Playable.newBuilder(playable0.origin).data(playable0.data).songIdTitle(playable0.songId, playable0.songName).artists(playable0.getArtists()).albumIdName(playable0.albumId, playable0.albumName).albumImg(playable0.albumImg).albumImgThumb(playable0.albumImgThumb).mvIdTitle(playable0.mvId, playable0.mvName).duration(playable0.duration).cType(playable0.cType).menuId(playable0.menuId).viewCount(playable0.viewCount).liveSeq(playable0.liveSeq).liveTitle(playable0.liveTitle).liveStatusCode(playable0.liveStatusCode).issueDate(playable0.issueDate).trackId(playable0.trackId).build();
        playable1.setStreamPath(playable0.streamPath);
        playable1.setDurationLimit(playable0.durationLimit);
        playable1.setLiked(playable0.liked > 0);
        playable1.setLikeCount(playable0.likeCount);
        playable1.setBitrate(playable0.bitrate);
        playable1.setMetatype(playable0.metaType);
        playable1.setLoggingToken(playable0.loggingToken);
        playable1.setProtocolType(playable0.protocolType);
        playable1.setC(playable0.c);
        playable1.setIsHttps(playable0.isHttps);
        playable1.setLyricType(playable0.lyricType);
        playable1.setLyricspath(playable0.lyricsPath);
        playable1.setLyricLastUpdated(playable0.lyricFileUpdtDate);
        playable1.metaFlag |= playable0.metaFlag;
        playable1.createdSeq = playable0.createdSeq;
        playable1.createdAt = playable0.createdAt;
        playable1.downloadOrigin = playable0.downloadOrigin;
        playable1.dbContentId = playable0.dbContentId;
        playable1.mediaStoreAlbumId = playable0.mediaStoreAlbumId;
        playable1.localAlbumKey = playable0.localAlbumKey;
        playable1.playCount = playable0.playCount;
        playable1.order = playable0.order;
        playable1.isFlacSt = playable0.isFlacSt;
        playable1.postImg = playable0.postImg;
        playable1.postEditImg = playable0.postEditImg;
        playable1.isLandscapeMv = playable0.isLandscapeMv;
        playable1.mvWidth = playable0.mvWidth;
        playable1.mvHeight = playable0.mvHeight;
        playable1.isBookFile = playable0.isBookFile;
        playable1.isFlacAvail = playable0.isFlacAvail;
        playable1.isFlac16Avail = playable0.isFlac16Avail;
        playable1.isFlac24Avail = playable0.isFlac24Avail;
        playable1.flacCode = playable0.flacCode;
        playable1.albumImgs = playable0.albumImgs;
        playable1.pstime = playable0.pstime;
        playable1.mimeType = playable0.mimeType;
        playable1.originMenuId = playable0.originMenuId;
        playable1.statsElements = playable0.statsElements;
        playable1.isBrandDj = playable0.isBrandDj;
        playable1.setGenreList(playable0.genreList);
        playable1.uriString = playable0.uriString;
        playable1.displayName = playable0.displayName;
        playable1.bgVideo = playable0.bgVideo;
        playable1.bgImgs = playable0.bgImgs;
        playable1.pInterval = playable0.pInterval;
        playable1.playToken = playable0.playToken;
        playable1.lastGetPathTime = playable0.lastGetPathTime;
        playable1.isMusicWaveSong = playable0.isMusicWaveSong;
        if(z) {
            LogU.v("Playable", "copyValueOf() new: " + playable1);
        }
        return playable1;
    }

    public static Playable copyValueOfWithNewTrackId(Playable playable0) {
        boolean z = Playable.LOGV;
        if(z) {
            LogU.v("Playable", "copyValueOfWithNewTrackId() origin:" + playable0);
        }
        Playable playable1 = Playable.newBuilder(playable0.origin).data(playable0.data).songIdTitle(playable0.songId, playable0.songName).artists(playable0.getArtists()).albumIdName(playable0.albumId, playable0.albumName).albumImg(playable0.albumImg).albumImgThumb(playable0.albumImgThumb).mvIdTitle(playable0.mvId, playable0.mvName).duration(playable0.duration).cType(playable0.cType).menuId(playable0.menuId).viewCount(playable0.viewCount).liveSeq(playable0.liveSeq).liveTitle(playable0.liveTitle).liveStatusCode(playable0.liveStatusCode).issueDate(playable0.issueDate).trackId(Base62UUID.randomUUID()).build();
        playable1.setStreamPath(playable0.streamPath);
        playable1.setDurationLimit(playable0.durationLimit);
        playable1.setLiked(playable0.liked > 0);
        playable1.setLikeCount(playable0.likeCount);
        playable1.setBitrate(playable0.bitrate);
        playable1.setMetatype(playable0.metaType);
        playable1.setLoggingToken(playable0.loggingToken);
        playable1.setProtocolType(playable0.protocolType);
        playable1.setC(playable0.c);
        playable1.setIsHttps(playable0.isHttps);
        playable1.setLyricType(playable0.lyricType);
        playable1.setLyricspath(playable0.lyricsPath);
        playable1.setLyricLastUpdated(playable0.lyricFileUpdtDate);
        playable1.metaFlag |= playable0.metaFlag;
        playable1.createdSeq = playable0.createdSeq;
        playable1.createdAt = playable0.createdAt;
        playable1.downloadOrigin = playable0.downloadOrigin;
        playable1.dbContentId = playable0.dbContentId;
        playable1.mediaStoreAlbumId = playable0.mediaStoreAlbumId;
        playable1.localAlbumKey = playable0.localAlbumKey;
        playable1.playCount = playable0.playCount;
        playable1.order = playable0.order;
        playable1.isFlacSt = playable0.isFlacSt;
        playable1.postImg = playable0.postImg;
        playable1.postEditImg = playable0.postEditImg;
        playable1.isLandscapeMv = playable0.isLandscapeMv;
        playable1.mvWidth = playable0.mvWidth;
        playable1.mvHeight = playable0.mvHeight;
        playable1.isBookFile = playable0.isBookFile;
        playable1.isFlacAvail = playable0.isFlacAvail;
        playable1.isFlac16Avail = playable0.isFlac16Avail;
        playable1.isFlac24Avail = playable0.isFlac24Avail;
        playable1.flacCode = playable0.flacCode;
        playable1.albumImgs = playable0.albumImgs;
        playable1.pstime = playable0.pstime;
        playable1.mimeType = playable0.mimeType;
        playable1.originMenuId = playable0.originMenuId;
        playable1.statsElements = playable0.statsElements;
        playable1.isBrandDj = playable0.isBrandDj;
        playable1.setGenreList(playable0.genreList);
        playable1.uriString = playable0.uriString;
        playable1.displayName = playable0.displayName;
        if(z) {
            LogU.v("Playable", "copyValueOfWithNewTrackId() new: " + playable1);
        }
        return playable1;
    }

    public static Playable copyValueOfWithNewTrackIdAndOriginMelon(Playable playable0) {
        boolean z = Playable.LOGV;
        if(z) {
            LogU.v("Playable", "copyValueOfWithNewTrackId() origin:" + playable0);
        }
        boolean z1 = false;
        Playable playable1 = Playable.newBuilder(0).data(playable0.data).songIdTitle(playable0.songId, playable0.songName).artists(playable0.getArtists()).albumIdName(playable0.albumId, playable0.albumName).albumImg(playable0.albumImg).albumImgThumb(playable0.albumImgThumb).mvIdTitle(playable0.mvId, playable0.mvName).duration(playable0.duration).cType(playable0.cType).menuId(playable0.menuId).viewCount(playable0.viewCount).liveSeq(playable0.liveSeq).liveTitle(playable0.liveTitle).liveStatusCode(playable0.liveStatusCode).issueDate(playable0.issueDate).trackId(Base62UUID.randomUUID()).build();
        playable1.setStreamPath(playable0.streamPath);
        playable1.setDurationLimit(playable0.durationLimit);
        if(playable0.liked > 0) {
            z1 = true;
        }
        playable1.setLiked(z1);
        playable1.setLikeCount(playable0.likeCount);
        playable1.setBitrate(playable0.bitrate);
        playable1.setMetatype(playable0.metaType);
        playable1.setLoggingToken(playable0.loggingToken);
        playable1.setProtocolType(playable0.protocolType);
        playable1.setC(playable0.c);
        playable1.setIsHttps(playable0.isHttps);
        playable1.setLyricType(playable0.lyricType);
        playable1.setLyricspath(playable0.lyricsPath);
        playable1.setLyricLastUpdated(playable0.lyricFileUpdtDate);
        playable1.metaFlag |= playable0.metaFlag;
        playable1.createdSeq = playable0.createdSeq;
        playable1.createdAt = playable0.createdAt;
        playable1.downloadOrigin = playable0.downloadOrigin;
        playable1.dbContentId = playable0.dbContentId;
        playable1.mediaStoreAlbumId = playable0.mediaStoreAlbumId;
        playable1.localAlbumKey = playable0.localAlbumKey;
        playable1.playCount = playable0.playCount;
        playable1.order = playable0.order;
        playable1.isFlacSt = playable0.isFlacSt;
        playable1.postImg = playable0.postImg;
        playable1.postEditImg = playable0.postEditImg;
        playable1.isLandscapeMv = playable0.isLandscapeMv;
        playable1.mvWidth = playable0.mvWidth;
        playable1.mvHeight = playable0.mvHeight;
        playable1.isBookFile = playable0.isBookFile;
        playable1.isFlacAvail = playable0.isFlacAvail;
        playable1.isFlac16Avail = playable0.isFlac16Avail;
        playable1.isFlac24Avail = playable0.isFlac24Avail;
        playable1.flacCode = playable0.flacCode;
        playable1.albumImgs = playable0.albumImgs;
        playable1.pstime = playable0.pstime;
        playable1.mimeType = playable0.mimeType;
        playable1.originMenuId = playable0.originMenuId;
        playable1.statsElements = playable0.statsElements;
        playable1.isBrandDj = playable0.isBrandDj;
        playable1.setGenreList(playable0.genreList);
        playable1.uriString = playable0.uriString;
        playable1.displayName = playable0.displayName;
        if(z) {
            LogU.v("Playable", "copyValueOfWithNewTrackId() new: " + playable1);
        }
        return playable1;
    }

    // 去混淆评级： 低(20)
    private Uri createUriFromData() {
        return TextUtils.isEmpty(this.data) ? Uri.EMPTY : Uri.fromFile(new File(this.data));
    }

    // 去混淆评级： 中等(50)
    private Uri createUriFromUriString() {
        return Uri.EMPTY;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 instanceof Playable) {
            if(this == object0) {
                return true;
            }
            if(!ClassUtils.equals(this.trackId, ((Playable)object0).trackId)) {
                return false;
            }
            if(this.songId != -1) {
                if(CType.MV.equals(this.cType) && ClassUtils.equals(this.cType, ((Playable)object0).cType) && !TextUtils.isEmpty(this.mvId)) {
                    return this.mvId.equals(((Playable)object0).mvId);
                }
                if(this.songId == ((Playable)object0).songId && ClassUtils.equals(this.cType, ((Playable)object0).cType)) {
                    if(this.origin == 0 && ((Playable)object0).origin == 0) {
                        return true;
                    }
                    if(!this.isTypeOfSong() && !this.isTypeOfEdu()) {
                        return ClassUtils.equals(this.data, ((Playable)object0).data);
                    }
                    return StorageUtils.isScopedStorage() ? ClassUtils.equals(this.uriString, ((Playable)object0).uriString) : ClassUtils.equals(this.data, ((Playable)object0).data);
                }
                return false;
            }
            if(CType.MV.equals(this.cType) && ClassUtils.equals(this.cType, ((Playable)object0).cType) && !TextUtils.isEmpty(this.mvId)) {
                return this.mvId.equals(((Playable)object0).mvId);
            }
            if(CType.LIVE.equals(this.cType) && ClassUtils.equals(this.cType, ((Playable)object0).cType)) {
                return this.liveSeq.equals(((Playable)object0).liveSeq) && this.liveStatusCode.equals(((Playable)object0).liveStatusCode);
            }
            if(!this.isTypeOfSong() && !this.isTypeOfEdu()) {
                return this.cType.equals(((Playable)object0).cType) ? ClassUtils.equals(this.data, ((Playable)object0).data) : false;
            }
            return StorageUtils.isScopedStorage() ? ClassUtils.equals(this.uriString, ((Playable)object0).uriString) : ClassUtils.equals(this.data, ((Playable)object0).data);
        }
        return false;
    }

    public boolean existLocalFile() {
        return this.hasLocalFile() ? StorageUtils.existLocalContent(this.getLocalContentUri(), MelonAppBase.instance.getContext()) : false;
    }

    public static Playable from(LiveInfoBase liveInfoBase0, String s, StatsElementsBase statsElementsBase0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        ArrayList arrayList0 = liveInfoBase0.artistList;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                Artist liveInfoBase$Artist0 = (Artist)object0;
                if(!TextUtils.isEmpty(liveInfoBase$Artist0.getArtistId())) {
                    linkedHashMap0.put(liveInfoBase$Artist0.getArtistId(), liveInfoBase$Artist0.getArtistName());
                }
            }
        }
        return Playable.newBuilder().cType(CType.LIVE).menuId(s).statsElements(statsElementsBase0).albumImg(liveInfoBase0.liveImg).liveSeqTitle(liveInfoBase0.liveSeq, liveInfoBase0.liveTitle).liveStatusCode(liveInfoBase0.liveStatusCode.getCode()).artists(linkedHashMap0).build();
    }

    public static Playable from(AlbumInfoBase albumInfoBase0, String s, StatsElementsBase statsElementsBase0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        ArrayList arrayList0 = albumInfoBase0.artistList;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                linkedHashMap0.put(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName());
            }
        }
        return Playable.newBuilder().albumIdName(albumInfoBase0.albumId, albumInfoBase0.albumName).albumImg(albumInfoBase0.albumImgLarge).albumImgThumb(albumInfoBase0.albumImg).artists(linkedHashMap0).isService(albumInfoBase0.canService).cType(CType.ALBUM).menuId(s).originMenuId(s).statsElements(statsElementsBase0).build();
    }

    public static Playable from(MvInfoBase mvInfoBase0, String s, StatsElementsBase statsElementsBase0) {
        return Playable.from(mvInfoBase0, s, false, statsElementsBase0);
    }

    public static Playable from(MvInfoBase mvInfoBase0, String s, boolean z, StatsElementsBase statsElementsBase0) {
        String s2;
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        ArrayList arrayList0 = mvInfoBase0.artistList;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                linkedHashMap0.put(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName());
            }
        }
        String s1 = TextUtils.isEmpty(mvInfoBase0.mv169Img) ? mvInfoBase0.albumImgLarge : mvInfoBase0.mv169Img;
        if(!TextUtils.isEmpty(mvInfoBase0.mvImg)) {
            s2 = mvInfoBase0.mvImg;
            return Playable.newBuilder().mvIdTitle(mvInfoBase0.mvId, mvInfoBase0.mvName).songIdTitle(mvInfoBase0.songId, mvInfoBase0.songName).albumIdName(mvInfoBase0.albumId, mvInfoBase0.albumName).albumImg(s1).albumImgThumb(s2).artists(linkedHashMap0).isAdult(mvInfoBase0.isAdult).isService(mvInfoBase0.canService).isTitle(mvInfoBase0.isTitleSong).isHitsong(mvInfoBase0.isHitSong).isHoldback(mvInfoBase0.isHoldback).isFree(mvInfoBase0.isFree).isSong(mvInfoBase0.hasSong).hasMv(true).playTime(mvInfoBase0.playTime).cType(CType.MV).menuId(s).originMenuId(s).statsElements(statsElementsBase0).genreList(mvInfoBase0.genreList).build();
        }
        s2 = mvInfoBase0.albumImg;
        return Playable.newBuilder().mvIdTitle(mvInfoBase0.mvId, mvInfoBase0.mvName).songIdTitle(mvInfoBase0.songId, mvInfoBase0.songName).albumIdName(mvInfoBase0.albumId, mvInfoBase0.albumName).albumImg(s1).albumImgThumb(s2).artists(linkedHashMap0).isAdult(mvInfoBase0.isAdult).isService(mvInfoBase0.canService).isTitle(mvInfoBase0.isTitleSong).isHitsong(mvInfoBase0.isHitSong).isHoldback(mvInfoBase0.isHoldback).isFree(mvInfoBase0.isFree).isSong(mvInfoBase0.hasSong).hasMv(true).playTime(mvInfoBase0.playTime).cType(CType.MV).menuId(s).originMenuId(s).statsElements(statsElementsBase0).genreList(mvInfoBase0.genreList).build();
    }

    public static Playable from(SongInfoBase songInfoBase0, String s, StatsElementsBase statsElementsBase0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        ArrayList arrayList0 = songInfoBase0.artistList;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                linkedHashMap0.put(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName());
            }
        }
        CType cType0 = CType.get(songInfoBase0.cType);
        if(CType.UNKNOWN.equals(cType0)) {
            cType0 = CType.SONG;
        }
        return Playable.newBuilder().songIdTitle(songInfoBase0.songId, songInfoBase0.songName).albumIdName(songInfoBase0.albumId, songInfoBase0.albumName).albumImg(songInfoBase0.albumImgLarge).albumImgThumb(songInfoBase0.albumImg).artists(linkedHashMap0).isAdult(songInfoBase0.isAdult).isService(songInfoBase0.canService).isTitle(songInfoBase0.isTitleSong).isHitsong(songInfoBase0.isHitSong).isHoldback(songInfoBase0.isHoldback).isFree(songInfoBase0.isFree).hasMv(songInfoBase0.hasMv).playTime(songInfoBase0.playTime).cType(cType0).isSong(CType.SONG.equals(cType0)).isFlacAvail(songInfoBase0.isFlacAvail).isFlac16Avail(songInfoBase0.isFlac16Avail).isFlac24Avail(songInfoBase0.isFlac24Avail).menuId(s).originMenuId(s).statsElements(statsElementsBase0).genreList(songInfoBase0.genreList).trackId(Base62UUID.randomUUID()).build();
    }

    public static Playable from(String s, String s1, StatsElementsBase statsElementsBase0, String s2) {
        return Playable.newBuilder().cType(CType.UNKNOWN).songId(s).menuId(s1).originMenuId(s1).statsElements(statsElementsBase0).trackId(s2).build();
    }

    private static Playable fromAlbumCursor(Cursor cursor0) {
        int v = cursor0.getColumnIndex("album_name");
        int v1 = cursor0.getColumnIndex("album_id");
        int v2 = cursor0.getColumnIndex("album_img_path");
        int v3 = cursor0.getColumnIndex("artist_name");
        int v4 = cursor0.getColumnIndex("artist_id");
        int v5 = cursor0.getColumnIndex("ctype");
        int v6 = cursor0.getColumnIndex("menu_id");
        int v7 = cursor0.getColumnIndex("is_service");
        CType cType0 = CType.UNKNOWN;
        String s = v1 == -1 ? "" : cursor0.getString(v1);
        String s1 = v == -1 ? "" : cursor0.getString(v);
        String s2 = v2 == -1 ? "" : cursor0.getString(v2);
        String s3 = v3 == -1 ? "" : cursor0.getString(v3);
        String s4 = v4 == -1 ? "" : cursor0.getString(v4);
        if(v5 != -1) {
            cType0 = CType.get(cursor0.getString(v5));
        }
        String s5 = v6 == -1 ? "" : cursor0.getString(v6);
        if(v7 != -1) {
            int v8 = cursor0.getInt(v7);
            return Playable.newBuilder().artists(StringUtils.makeArtistMap(s4, s3)).albumIdName(s, s1).albumImg(s2).mvId("").cType(cType0).menuId(s5).isService(v8).originMenuId(s5).statsElements("").build();
        }
        return Playable.newBuilder().artists(StringUtils.makeArtistMap(s4, s3)).albumIdName(s, s1).albumImg(s2).mvId("").cType(cType0).menuId(s5).isService(0).originMenuId(s5).statsElements("").build();
    }

    public static Playable fromCursor(Cursor cursor0, Class class0) {
        if(r8.a.class.equals(class0)) {
            return Playable.fromAlbumCursor(cursor0);
        }
        if(!g.class.equals(class0)) {
            throw new IllegalArgumentException("not suppprted columns");
        }
        return Playable.fromSongCursor(cursor0);
    }

    public static Playable fromLocalFilePath(String s) {
        Builder playable$Builder0 = Playable.newBuilder(1).data(s).songName(FilenameUtils.getName(s));
        return FilenameUtils.isVideo(s) ? playable$Builder0.cType(CType.MV).build() : playable$Builder0.cType(CType.SONG).build();
    }

    public static Playable fromLocalVideoCursor(Cursor cursor0) {
        String s2;
        int v = cursor0.getColumnIndex("_id");
        int v1 = cursor0.getColumnIndex("_data");
        int v2 = cursor0.getColumnIndex("title");
        int v3 = cursor0.getColumnIndex("duration");
        int v4 = cursor0.getColumnIndex("mini_thumb_magic");
        String s = "";
        String s1 = v1 == -1 ? "" : cursor0.getString(v1);
        if(v2 == -1) {
            s2 = "";
        }
        else if(FilenameUtils.getFileType(cursor0.getString(v2)) != 0) {
            s2 = FilenameUtils.getBasename(cursor0.getString(v2));
        }
        else {
            s2 = cursor0.getString(v2);
        }
        long v5 = v3 == -1 ? 0L : cursor0.getLong(v3);
        String s3 = v4 == -1 ? "" : cursor0.getString(v4);
        if(v != -1) {
            long v6 = cursor0.getLong(v);
            s = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, v6).toString();
        }
        return Playable.newBuilder(1).data(s1).songName(s2).mvTitle(s2).cType(CType.MV).duration(v5).albumImg(s3).albumImgThumb(s3).uriString(s).build();
    }

    private static Playable fromSongCursor(Cursor cursor0) {
        int v24;
        String s9;
        int v = cursor0.getColumnIndex("song_title");
        int v1 = cursor0.getColumnIndex("album_name");
        int v2 = cursor0.getColumnIndex("album_id");
        int v3 = cursor0.getColumnIndex("album_img_path");
        int v4 = cursor0.getColumnIndex("artist_name");
        int v5 = cursor0.getColumnIndex("artist_id");
        int v6 = cursor0.getColumnIndex("ctype");
        int v7 = cursor0.getColumnIndex("play_time");
        int v8 = cursor0.getColumnIndex("song_id");
        int v9 = cursor0.getColumnIndex("menu_id");
        int v10 = cursor0.getColumnIndex("is_mv");
        int v11 = cursor0.getColumnIndex("is_adult");
        int v12 = cursor0.getColumnIndex("is_service");
        int v13 = cursor0.getColumnIndex("is_melon_song");
        int v14 = cursor0.getColumnIndex("local_path");
        int v15 = cursor0.getColumnIndex("is_title_song");
        int v16 = cursor0.getColumnIndex("is_hit_song");
        int v17 = cursor0.getColumnIndex("is_holdback");
        int v18 = cursor0.getColumnIndex("is_free");
        CType cType0 = CType.UNKNOWN;
        String s = v == -1 ? "" : cursor0.getString(v);
        String s1 = v2 == -1 ? "" : cursor0.getString(v2);
        String s2 = v1 == -1 ? "" : cursor0.getString(v1);
        String s3 = v3 == -1 ? "" : cursor0.getString(v3);
        String s4 = v4 == -1 ? "" : cursor0.getString(v4);
        String s5 = v5 == -1 ? "" : cursor0.getString(v5);
        if(v6 != -1) {
            cType0 = CType.get(cursor0.getString(v6));
        }
        String s6 = v7 == -1 ? "" : cursor0.getString(v7);
        String s7 = v8 == -1 ? "" : cursor0.getString(v8);
        String s8 = v9 == -1 ? "" : cursor0.getString(v9);
        int v19 = 0;
        int v20 = v10 == -1 ? 0 : cursor0.getInt(v10);
        int v21 = v11 == -1 ? 0 : cursor0.getInt(v11);
        int v22 = v12 == -1 ? 0 : cursor0.getInt(v12);
        int v23 = v13 == -1 ? 1 : cursor0.getInt(v13);
        if(v14 == -1) {
            v24 = v21;
            s9 = "";
        }
        else {
            s9 = cursor0.getString(v14);
            v24 = v21;
        }
        int v25 = v15 == -1 ? 0 : cursor0.getInt(v15);
        int v26 = v16 == -1 ? 0 : cursor0.getInt(v16);
        int v27 = v17 == -1 ? 0 : cursor0.getInt(v17);
        if(v18 != -1) {
            v19 = cursor0.getInt(v18);
        }
        return v23 == 1 ? Playable.newBuilder().songId(s7).data(s9).songName(s).artists(StringUtils.makeArtistMap(s5, s4)).albumIdName(s1, s2).albumImg(s3).mvId("").playTime(s6).cType(cType0).menuId(s8).hasMv(v20).isAdult(v24).isService(v22).isMelonSong(1).isTitle(v25).isHitsong(v26).isHoldback(v27).isFree(v19).originMenuId(s8).statsElements("").build() : Playable.newBuilder().songId(-1).data(s9).songName(s).artists(StringUtils.makeArtistMap(s5, s4)).albumIdName(s1, s2).albumImg(s3).mvId("").playTime(s6).cType(cType0).menuId(s8).hasMv(v20).isAdult(v24).isService(v22).isMelonSong(v23).isTitle(v25).isHitsong(v26).isHoldback(v27).isFree(v19).originMenuId(s8).statsElements("").build();
    }

    public static Playable fromStreamGetSongInfoResult(ContentsInfo streamGetSongInfoRes$RESPONSE$ContentsInfo0, String s, StatsElementsBase statsElementsBase0) {
        return Playable.fromStreamGetSongInfoResultWithTrackId(streamGetSongInfoRes$RESPONSE$ContentsInfo0, s, statsElementsBase0, Base62UUID.randomUUID());
    }

    public static Playable fromStreamGetSongInfoResultWithTrackId(ContentsInfo streamGetSongInfoRes$RESPONSE$ContentsInfo0, String s, StatsElementsBase statsElementsBase0, String s1) {
        boolean z = "21".equals(streamGetSongInfoRes$RESPONSE$ContentsInfo0.ctype);
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        ArrayList arrayList0 = streamGetSongInfoRes$RESPONSE$ContentsInfo0.artists;
        if(arrayList0 != null) {
            for(Object object0: arrayList0) {
                linkedHashMap0.put(((Artists)object0).getArtistId(), ((Artists)object0).getArtistName());
            }
        }
        String s2 = "";
        Builder playable$Builder0 = Playable.newBuilder().songId((z ? streamGetSongInfoRes$RESPONSE$ContentsInfo0.songid : streamGetSongInfoRes$RESPONSE$ContentsInfo0.cid)).songName((z ? "" : streamGetSongInfoRes$RESPONSE$ContentsInfo0.cname)).mvId((z ? streamGetSongInfoRes$RESPONSE$ContentsInfo0.cid : "")).mvTitle((!z || TextUtils.isEmpty(streamGetSongInfoRes$RESPONSE$ContentsInfo0.mvtitle) ? streamGetSongInfoRes$RESPONSE$ContentsInfo0.cname : streamGetSongInfoRes$RESPONSE$ContentsInfo0.mvtitle)).artists(linkedHashMap0).albumId(streamGetSongInfoRes$RESPONSE$ContentsInfo0.albumid).albumName(streamGetSongInfoRes$RESPONSE$ContentsInfo0.albumname).lyricType((z ? "" : streamGetSongInfoRes$RESPONSE$ContentsInfo0.lyrictype)).lyricpath((z ? "" : streamGetSongInfoRes$RESPONSE$ContentsInfo0.lyricpath)).lyricFileUpdtDate((z ? "" : streamGetSongInfoRes$RESPONSE$ContentsInfo0.lyricfileupdtdate)).cType(CType.get(streamGetSongInfoRes$RESPONSE$ContentsInfo0.ctype)).playTime(streamGetSongInfoRes$RESPONSE$ContentsInfo0.playtime).menuId(s).hasMv((z ? true : streamGetSongInfoRes$RESPONSE$ContentsInfo0.ismv)).isAdult(streamGetSongInfoRes$RESPONSE$ContentsInfo0.isadult).isFree(streamGetSongInfoRes$RESPONSE$ContentsInfo0.isFree);
        if(z) {
            s2 = streamGetSongInfoRes$RESPONSE$ContentsInfo0.issuedate;
        }
        return playable$Builder0.issueDate(s2).isSong("1".equals(streamGetSongInfoRes$RESPONSE$ContentsInfo0.ctype)).isService(streamGetSongInfoRes$RESPONSE$ContentsInfo0.isservice).isPrivate(streamGetSongInfoRes$RESPONSE$ContentsInfo0.privtyn).albumImg(streamGetSongInfoRes$RESPONSE$ContentsInfo0.contentimgpath).albumImgThumb(streamGetSongInfoRes$RESPONSE$ContentsInfo0.contentthumbimgpath).originMenuId(s).statsElements(statsElementsBase0).isAudioSt(streamGetSongInfoRes$RESPONSE$ContentsInfo0.isAudioSt).impossCode(streamGetSongInfoRes$RESPONSE$ContentsInfo0.impossCode).impossDesc(streamGetSongInfoRes$RESPONSE$ContentsInfo0.impossDesc).trackId(s1).bgVideo(SpecialContentsKt.getSpecialBgVideoFromBgVideoBase(streamGetSongInfoRes$RESPONSE$ContentsInfo0.bgVideo)).bgImgs(SpecialContentsKt.getSpecialBgImageListFromBgImgsBaseList(streamGetSongInfoRes$RESPONSE$ContentsInfo0.bgImgs)).build();
    }

    public String getAlbum() [...] // 潜在的解密器

    public String getAlbumImg() [...] // 潜在的解密器

    public String getAlbumImgThumb() [...] // 潜在的解密器

    public List getAlbumImgs() {
        return this.albumImgs;
    }

    public String getAlbumid() [...] // 潜在的解密器

    public String getArtist() [...] // 潜在的解密器

    public String getArtistIds() [...] // 潜在的解密器

    public String getArtistNames() [...] // 潜在的解密器

    public String getArtistid() {
        return this.getFirstArtistId();
    }

    public Map getArtists() {
        return this.artistMap.isEmpty() ? StringUtils.makeArtistMap(this.artistIds, this.artistNames) : this.artistMap;
    }

    public String getBestPlaybackPath(Context context0, PlayerKind playerKind0) {
        String s1;
        if(PlayerKind.GoogleCastPlayer.equals(playerKind0)) {
            return this.streamPath;
        }
        if(PlayerKind.DlnaPlayer.equals(playerKind0) && this.isOriginLocal() && this.hasLocalFile()) {
            return !this.isTypeOfSong() && !this.isTypeOfEdu() || !StorageUtils.isScopedStorage() ? this.data : "";
        }
        Playable.copyValueOf(this);
        String s = null;
        if(!this.isOriginLocal() || !this.hasLocalFile()) {
            s1 = null;
        }
        else if((this.isTypeOfSong() || this.isTypeOfEdu()) && StorageUtils.isScopedStorage()) {
            s1 = "";
        }
        else if(!this.isTypeOfMv() || !StorageUtils.isScopedStorage() || TextUtils.isEmpty(this.uriString)) {
            s1 = this.data;
        }
        else {
            s1 = this.uriString;
        }
        LogU.i("Playable", "getBestPlaybackPath() localPath:" + s1);
        if(this.existLocalFile()) {
            s = s1;
        }
        LogU.i("Playable", "getBestPlaybackPath() bestPath:" + s);
        if(TextUtils.isEmpty(s) && this.hasStreamPath()) {
            if(!TextUtils.isEmpty(this.protocolType) && "PINO20".equals(this.protocolType)) {
                s = "";
            }
            else if(TextUtils.isEmpty(this.protocolType) || !"MCACHE".equals(this.protocolType) && !"PREMIUM".equals(this.protocolType)) {
                s = this.streamPath;
            }
            else {
                try {
                    CacheUrlBuilder cacheUrlBuilder0 = new CacheUrlBuilder(this.streamPath, "").cacheEnable(Ob.b.b()).bitrate(this.bitrate).metaType(this.metaType);
                    if("PREMIUM".equals(this.protocolType)) {
                        cacheUrlBuilder0.isLocal(true).contentType(this.mimeType);
                    }
                    s = Ob.b.c(cacheUrlBuilder0.build(), "");
                    if(!URLUtil.isNetworkUrl(s)) {
                        throw new MCacheError("Wrong mcache path: " + s + ", src:" + this.streamPath);
                    }
                    goto label_35;
                }
                catch(Exception exception0) {
                }
                LogU.e("Playable", "mcache path error: " + exception0);
                throw new MCacheError("mcache path exception:" + exception0 + ", src:" + this.streamPath);
            }
        }
    label_35:
        this.lastPlaybackPath = s;
        LogU.i("Playable", "getBestPlaybackPath() lastPlaybackPath: " + s);
        return s;
    }

    public List getBgImgs() {
        return this.bgImgs;
    }

    public SpecialBgVideo getBgVideo() {
        return this.bgVideo;
    }

    public String getBitrate() [...] // 潜在的解密器

    public boolean getBrandDj() {
        return this.isBrandDj;
    }

    public String getC() [...] // 潜在的解密器

    // 去混淆评级： 中等(90)
    @Override  // com.iloen.melon.sns.model.Sharable
    public String getContentId() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public ContsTypeCode getContsTypeCode() {
        return this.isTypeOfMv() ? ContsTypeCode.VIDEO : ContsTypeCode.SONG;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public int getCreatedSeq() {
        return this.createdSeq;
    }

    public CType getCtype() {
        return this.cType;
    }

    public String getData() [...] // 潜在的解密器

    @Override  // com.iloen.melon.sns.model.SharableBase
    public String getDisplayImageUrl(SnsTarget snsTarget0) {
        if(!TextUtils.isEmpty(this.postEditImg)) {
            return this.postEditImg;
        }
        return !this.isOriginMelon() || TextUtils.isEmpty(this.albumImgThumb) ? this.getDefaultPostEditImageUrl() : this.albumImgThumb;
    }

    // 去混淆评级： 中等(75)
    @Override  // com.iloen.melon.sns.model.Sharable
    public String getDisplayMessage(SnsTarget snsTarget0) {
        if(MelonAppBase.instance.getContext() == null) {
            LogU.e("Playable", "getDisplayMessage() context is NULL!");
            return null;
        }
        return this.isTypeOfMv() ? this.makeMessage(snsTarget0, "의  - 감상해보세요. ") : this.makeMessage(snsTarget0, " -  - 들어보세요. ");
    }

    // 去混淆评级： 中等(100)
    @Override  // com.iloen.melon.sns.model.Sharable
    public String[] getDisplayMultiLineTitle(SnsTarget snsTarget0) {
        return this.isTypeOfMv() ? new String[]{"", ""} : new String[]{"", ""};
    }

    public String getDisplayName() [...] // 潜在的解密器

    @Override  // com.iloen.melon.sns.model.SharableBase
    public String getDisplayTitle(SnsTarget snsTarget0) {
        return this.getShareTitle(snsTarget0);
    }

    public static long getDuration(Playable playable0) {
        if(playable0 != null) {
            long v = playable0.getDuration();
            if(v <= 2L * a.b) {
                long v1 = playable0.getDurationLimit();
                return v1 <= 0L || v <= v1 ? v : v1;
            }
            LogU.w("Playable", "player duration validation error - " + v / 3600000L + " hours");
            return v;
        }
        return 0L;
    }

    private long getDuration(boolean z) {
        long v = this.duration;
        if(z) {
            return this.durationLimit <= 0L || v <= this.durationLimit ? v : this.durationLimit;
        }
        return v;
    }

    public long getDuration() {
        return this.getDuration(true);
    }

    public long getDurationLimit() {
        return this.durationLimit;
    }

    public String getFirstArtistId() {
        if(!this.artistMap.isEmpty()) {
            Iterator iterator0 = this.artistMap.entrySet().iterator();
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                return (String)((Map.Entry)object0).getKey();
            }
        }
        String s = this.artistIds;
        if(s != null) {
            List list0 = StringUtils.tokenizeCsv(s);
            return list0.isEmpty() ? "" : ((String)list0.get(0));
        }
        return "";
    }

    public String getFirstArtistName() [...] // 潜在的解密器

    public String getFlacCode() [...] // 潜在的解密器

    public List getGenreList() {
        return this.genreList;
    }

    public String getImpossCode() {
        return this.impossCode;
    }

    public String getImpossDesc() {
        return this.impossDesc;
    }

    public int getIsDownload() {
        return this.isDownload();
    }

    public boolean getIsHttps() {
        return this.isHttps;
    }

    public boolean getIsMusicWaveSong() {
        return this.isMusicWaveSong;
    }

    public int getIsPrivate() {
        return this.isPrivate();
    }

    public int getIsSong() {
        return this.isSong();
    }

    public int getIsadult() {
        return this.isAdult();
    }

    public int getIsfree() {
        return this.isFree();
    }

    public int getIshasmv() {
        return this.hasMv();
    }

    public int getIshitsong() {
        return this.isHitSong();
    }

    public int getIsholdback() {
        return this.isHoldback();
    }

    public int getIsmelonsong() {
        return this.isMelonSong();
    }

    public int getIsservice() {
        return this.isService();
    }

    public String getIssueDate() [...] // 潜在的解密器

    public int getIstitle() {
        return this.isTitle();
    }

    public long getLastGetPathTime() {
        return this.lastGetPathTime;
    }

    public String getLastPlaybackPath(Context context0, PlayerKind playerKind0) {
        if(this.lastPlaybackPath != null) {
            LogU.i("Playable", "getLastPlaybackPath() lastPlaybackPath:" + this.lastPlaybackPath);
            return this.lastPlaybackPath;
        }
        try {
            return this.getBestPlaybackPath(context0, playerKind0);
        }
        catch(DcfError dcfError0) {
            return String.valueOf(dcfError0.b);
        }
        catch(MCacheError unused_ex) {
            return null;
        }
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public static ArrayList getListFromSongBaseArrayOnlyCanService(Collection collection0, String s, StatsElementsBase statsElementsBase0) {
        ArrayList arrayList0 = new ArrayList();
        if(collection0 != null) {
            for(Object object0: collection0) {
                SongInfoBase songInfoBase0 = (SongInfoBase)object0;
                if(songInfoBase0.canService) {
                    arrayList0.add(Playable.from(songInfoBase0, s, statsElementsBase0));
                }
            }
        }
        return arrayList0;
    }

    public String getLiveSeq() [...] // 潜在的解密器

    public String getLiveStatusCode() [...] // 潜在的解密器

    public String getLiveTitle() [...] // 潜在的解密器

    public String getLocalAlbumKey() [...] // 潜在的解密器

    public Uri getLocalContentUri() {
        try {
            if((this.isTypeOfSong() || this.isTypeOfEdu()) && StorageUtils.isScopedStorage()) {
                Uri uri0 = this.createUriFromUriString();
                return uri0 == Uri.EMPTY ? this.createUriFromData() : uri0;
            }
            return this.createUriFromData();
        }
        catch(Exception unused_ex) {
            return Uri.EMPTY;
        }
    }

    public String getLocalDbContentId() [...] // 潜在的解密器

    public String getLoggingToken() {
        return this.loggingToken;
    }

    public String getLyricLastUpdated() [...] // 潜在的解密器

    public String getLyricType() [...] // 潜在的解密器

    public String getLyricspath() [...] // 潜在的解密器

    public long getMediaStoreAlbumId() {
        return this.mediaStoreAlbumId;
    }

    public String getMenuid() [...] // 潜在的解密器

    public String getMetatype() [...] // 潜在的解密器

    public String getMimeType() [...] // 潜在的解密器

    public int getMvHeight() {
        return this.mvHeight;
    }

    public int getMvWidth() {
        return this.mvWidth;
    }

    public String getMvid() [...] // 潜在的解密器

    public String getMvname() [...] // 潜在的解密器

    public int getOrder() {
        return this.order;
    }

    public String getOriginMenuId() [...] // 潜在的解密器

    public long getOriginalDuration() {
        return this.getDuration(false);
    }

    // 去混淆评级： 中等(110)
    @Override  // com.iloen.melon.sns.model.SharableBase
    public String getOutPostingLogParam(SnsTarget snsTarget0) {
        return this.hasCid() ? this.getBaseOutPostingLogParam(snsTarget0) + "&sId=" + "" : this.getBaseOutPostingLogParam(snsTarget0) + "&sId=" + "";
    }

    public int getPInterval() {
        return this.pInterval;
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.sns.model.Sharable
    public String getPageTypeCode() {
        return this.hasCid() ? "sst" : "sch";
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public String getPlayToken() {
        return this.playToken;
    }

    public String getPostEditImg() {
        return this.postEditImg;
    }

    public String getPostImg() {
        return this.postImg;
    }

    public String getProtocolType() {
        return this.protocolType;
    }

    public String getPstime() [...] // 潜在的解密器

    @Override  // com.iloen.melon.sns.model.SharableBase
    public String getShareGatePageUrl(SnsTarget snsTarget0, boolean z) {
        StringBuilder stringBuilder0 = new StringBuilder("https://m2.melon.com/pda/msvc/snsGatePage.jsp?");
        if(this.hasCid()) {
            stringBuilder0.append("type=");
            if(this.isTypeOfSong()) {
                stringBuilder0.append("son");
            }
            else {
                stringBuilder0.append("mvd");
            }
            if(this.isTypeOfMv() && this.isLiveContent()) {
                stringBuilder0.append("&subType=live");
            }
            stringBuilder0.append("&sId=");
            stringBuilder0.append("");
        }
        else {
            stringBuilder0.append("type=sch&sId=");
            try {
                stringBuilder0.append("");
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                LogU.e("Playable", "getSharePageUrl() UnsupportedEncodingException : " + unsupportedEncodingException0.toString());
            }
        }
        stringBuilder0.append("&ref=");
        stringBuilder0.append(snsTarget0.getId());
        return z ? this.getShortenUrl(stringBuilder0.toString()) : stringBuilder0.toString();
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getShareImageUrl(SnsTarget snsTarget0) {
        if(!TextUtils.isEmpty(this.postImg)) {
            return this.postImg;
        }
        return !this.isOriginMelon() || TextUtils.isEmpty(this.albumImg) ? this.getDefaultPostImageUrl() : this.albumImg;
    }

    @Override  // com.iloen.melon.sns.model.Sharable
    public String getShareTitle(SnsTarget snsTarget0) [...] // 潜在的解密器

    public String getSongName() [...] // 潜在的解密器

    public int getSongid() {
        return this.songId;
    }

    public String getSongidString() [...] // 潜在的解密器

    public String getStatsElements() [...] // 潜在的解密器

    public String getStreamPath() {
        return this.streamPath;
    }

    public String getTrackId() [...] // 潜在的解密器

    public String getUriString() [...] // 潜在的解密器

    public int getViewCount() {
        return this.viewCount;
    }

    public boolean hasCid() {
        return !TextUtils.isEmpty(this.getContentId());
    }

    public boolean hasLocalFile() {
        return !Uri.EMPTY.equals(this.getLocalContentUri());
    }

    public boolean hasMv() {
        return TextUtils.isEmpty(this.mvId) ? (this.metaFlag & 0x80L) > 0L : true;
    }

    public boolean hasSongId() {
        return this.songId != -1;
    }

    public boolean hasStreamPath() {
        return !TextUtils.isEmpty(this.streamPath);
    }

    @Override
    public int hashCode() {
        int v = this.trackId.hashCode();
        int v1 = this.songId;
        int v2 = 0;
        if(v1 == -1) {
            int v3 = this.data == null ? 0 : this.data.hashCode();
            String s = this.uriString;
            if(s != null) {
                v2 = s.hashCode();
            }
            return ((v + 0x103) * 37 + v3) * 37 + v2;
        }
        int v4 = (((((v + 0x103) * 37 + v1) * 37 + (this.cType == null ? 0 : this.cType.hashCode())) * 37 + (this.mvId == null ? 0 : this.mvId.hashCode())) * 37 + this.origin) * 37;
        int v5 = this.data == null ? 0 : this.data.hashCode();
        String s1 = this.uriString;
        if(s1 != null) {
            v2 = s1.hashCode();
        }
        return (v4 + v5) * 37 + v2;
    }

    public boolean isAdult() {
        return (this.metaFlag & 8L) > 0L;
    }

    public boolean isAudioSt() {
        return this.isAudioSt;
    }

    public boolean isBookFile() {
        return this.isBookFile;
    }

    // 去混淆评级： 中等(60)
    public boolean isDcfFile() {
        return this.hasLocalFile() && false;
    }

    public boolean isDownload() {
        return (this.metaFlag & 0x100L) > 0L;
    }

    public boolean isDownloadOriginMelon() {
        return this.downloadOrigin == 0;
    }

    public boolean isDownloadOriginNowplaying() {
        return this.downloadOrigin == 1;
    }

    public boolean isFlac16Avail() {
        return this.isFlac16Avail;
    }

    public boolean isFlac24Avail() {
        return this.isFlac24Avail;
    }

    public boolean isFlacAvail() {
        return this.isFlacAvail;
    }

    // 去混淆评级： 低(40)
    public boolean isFlacFile() {
        return this.hasLocalFile() && FilenameUtils.isFlac("");
    }

    public boolean isFlacSt() {
        return this.isFlacSt;
    }

    public boolean isFree() {
        return (this.metaFlag & 0x40L) > 0L;
    }

    public boolean isHitSong() {
        return (this.metaFlag & 16L) > 0L;
    }

    public boolean isHoldback() {
        return (this.metaFlag & 0x20L) > 0L;
    }

    public boolean isLandscapeMv() {
        return this.isLandscapeMv;
    }

    public boolean isLiked() {
        return this.liked == 1;
    }

    public boolean isLiveContent() {
        return this.isTypeOfLive();
    }

    public boolean isLivePreView() {
        if(this.isTypeOfLive()) {
            LiveStatusCode liveStatusCode0 = LiveStatusCode.of(this.liveStatusCode);
            return LiveStatusCode.Preview == liveStatusCode0;
        }
        return false;
    }

    public boolean isMelonSong() {
        return (this.metaFlag & 1L) > 0L;
    }

    public boolean isOnAir() {
        if(this.isTypeOfLive()) {
            LiveStatusCode liveStatusCode0 = LiveStatusCode.of(this.liveStatusCode);
            return LiveStatusCode.LiveStreaming == liveStatusCode0;
        }
        return false;
    }

    public boolean isOriginLocal() {
        return this.origin == 1;
    }

    public boolean isOriginMelon() {
        return this.origin == 0;
    }

    public boolean isPremiumProtocol() {
        return TextUtils.equals("PREMIUM", this.protocolType);
    }

    public boolean isPrivate() {
        return (this.metaFlag & 0x1000L) > 0L;
    }

    public boolean isService() {
        return (this.metaFlag & 2L) > 0L;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public boolean isShowInstagram() {
        return CType.isMusic(this.cType);
    }

    public boolean isShowKakaoLoginPopup() {
        return this.isShowKakaoLoginPopup;
    }

    public boolean isSong() {
        return (this.metaFlag & 0x800L) > 0L;
    }

    public boolean isTitle() {
        return (this.metaFlag & 4L) > 0L;
    }

    public boolean isTypeOfEdu() {
        return CType.EDU.equals(this.cType);
    }

    public boolean isTypeOfLive() {
        return CType.LIVE.equals(this.cType);
    }

    public boolean isTypeOfMv() {
        return CType.MV.equals(this.cType);
    }

    public boolean isTypeOfSong() {
        return CType.SONG.equals(this.cType);
    }

    public boolean isTypeOfThanksMsg() {
        return CType.THANKSMSG.equals(this.cType);
    }

    public boolean isTypeOfVoice() {
        return CType.VOICE.equals(this.cType);
    }

    public static ArrayList makeList(List list0, String s, String s1, StatsElementsBase statsElementsBase0) {
        ArrayList arrayList0 = new ArrayList();
        if(list0 != null) {
            List list1 = StringUtils.tokenizeCsv(s1);
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = 0;
            for(Object object0: list0) {
                Playable playable0 = Playable.fromStreamGetSongInfoResult(((ContentsInfo)object0), s, statsElementsBase0);
                if(playable0 != null) {
                    if(Playable.LOGV) {
                        stringBuilder0.append("[name] ");
                        stringBuilder0.append("");
                        stringBuilder0.append(" [songId] ");
                        stringBuilder0.append("");
                        stringBuilder0.append(", ");
                    }
                    if(!TextUtils.isEmpty(s1)) {
                        try {
                            playable0.setMvid(((String)list1.get(v)));
                        }
                        catch(IndexOutOfBoundsException unused_ex) {
                        }
                    }
                    arrayList0.add(playable0);
                }
                ++v;
            }
            if(Playable.LOGV) {
                LogU.v("Playable", "makeList() " + stringBuilder0);
            }
        }
        return arrayList0;
    }

    public static Builder newBuilder() {
        return Playable.newBuilder(0);
    }

    public static Builder newBuilder(int v) {
        return new Builder(v, 0);
    }

    public void setAdult(int v) {
        this.setAdult(v == 1);
    }

    public void setAdult(boolean z) {
        if(z) {
            this.metaFlag |= 8L;
            return;
        }
        this.metaFlag &= -9L;
    }

    public void setAlbum(String s, String s1) {
        if(TextUtils.isEmpty(s)) {
            s = "";
        }
        this.albumId = s;
        if(TextUtils.isEmpty(s1)) {
            s1 = "";
        }
        this.albumName = s1;
        if(Playable.LOGV) {
            StringBuilder stringBuilder0 = new StringBuilder("setAlbum() id:");
            stringBuilder0.append(this.albumId);
            stringBuilder0.append(", name:");
            Z.x(stringBuilder0, this.albumName, "Playable");
        }
    }

    public void setAlbumId(String s) {
        if(TextUtils.isEmpty(s)) {
            s = "";
        }
        this.albumId = s;
        if(Playable.LOGV) {
            Z.x(new StringBuilder("setAlbumId() albumId:"), this.albumId, "Playable");
        }
    }

    public void setAlbumImg(String s) {
        this.albumImg = s;
    }

    public void setAlbumImgThumb(String s) {
        this.albumImgThumb = s;
    }

    public void setAlbumImgs(List list0) {
        this.albumImgs = list0;
    }

    public void setArtist(String s, String s1) {
        this.setArtists(StringUtils.makeArtistMap(s, s1));
        if(Playable.LOGV) {
            StringBuilder stringBuilder0 = new StringBuilder("setArtists - ids:");
            stringBuilder0.append(this.artistIds);
            stringBuilder0.append(", names:");
            Z.x(stringBuilder0, this.artistNames, "Playable");
        }
    }

    public void setArtistIds(StringIds stringIds0) {
        if(stringIds0 != null) {
            this.setArtistIds("");
            return;
        }
        this.setArtistIds(null);
    }

    public void setArtistIds(String s) {
        if(TextUtils.isEmpty(s)) {
            s = "";
        }
        this.artistIds = s;
        if(Playable.LOGV) {
            Z.x(new StringBuilder("setArtistIds() artistIds:"), this.artistIds, "Playable");
        }
    }

    public void setArtists(Map map0) {
        this.artistMap = map0;
        this.artistIds = StringUtils.parseToCsv(map0.keySet(), false, false);
        this.artistNames = StringUtils.parseToCsv(map0.values(), false, true);
        if(Playable.LOGV) {
            StringBuilder stringBuilder0 = new StringBuilder("setArtists - ids:");
            stringBuilder0.append(this.artistIds);
            stringBuilder0.append(", names:");
            Z.x(stringBuilder0, this.artistNames, "Playable");
        }
    }

    public void setAudioSt(boolean z) {
        this.isAudioSt = z;
    }

    public void setBgImgs(Collection collection0) {
        this.bgImgs.clear();
        if(collection0 != null && !collection0.isEmpty()) {
            this.bgImgs.addAll(collection0);
        }
    }

    public void setBgVideo(SpecialBgVideo specialBgVideo0) {
        this.bgVideo = specialBgVideo0;
    }

    public void setBitrate(String s) {
        this.bitrate = s;
    }

    public void setBookFile(boolean z) {
        if(!this.isTypeOfEdu()) {
            return;
        }
        this.isBookFile = z;
    }

    public void setBrandDj(boolean z) {
        this.isBrandDj = z;
    }

    public void setC(String s) {
        this.c = s;
    }

    public void setCreatedAt(long v) {
        this.createdAt = v;
    }

    public void setCreatedSeq(int v) {
        this.createdSeq = v;
    }

    public void setCtype(CType cType0) {
        if(Playable.LOGV) {
            LogU.v("Playable", "setCtype: " + cType0);
        }
        this.cType = cType0;
    }

    public void setData(String s) {
        if(Playable.LOGV) {
            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("setData: ", s, ", songId: ");
            stringBuilder0.append(this.songId);
            LogU.v("Playable", stringBuilder0.toString());
        }
        this.data = s;
    }

    public void setDisplayName(String s) {
        synchronized(this) {
            this.displayName = s;
        }
    }

    public void setDownloadOrigin(int v) {
        this.downloadOrigin = v;
        this.lastPlaybackPath = null;
    }

    public void setDuration(long v) {
        if(Playable.LOGV) {
            LogU.v("Playable", "setDuration: " + v);
        }
        this.duration = v;
    }

    public void setDurationLimit(long v) {
        LogU.d("Playable", "setDurationLimit: " + v + ", this:" + this);
        this.durationLimit = v;
    }

    public void setFlac16Avail(boolean z) {
        this.isFlac16Avail = z;
    }

    public void setFlac24Avail(boolean z) {
        this.isFlac24Avail = z;
    }

    public void setFlacAvail(boolean z) {
        this.isFlacAvail = z;
    }

    public void setFlacCode(String s) {
        this.flacCode = s;
    }

    public void setFree(int v) {
        this.setFree(v == 1);
    }

    public void setFree(boolean z) {
        if(z) {
            this.metaFlag |= 0x40L;
            return;
        }
        this.metaFlag &= -65L;
    }

    public void setGenreList(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            this.genreList.clear();
            this.genreList.addAll(list0);
        }
    }

    public void setHasMv(int v) {
        this.setHasMv(v == 1);
    }

    public void setHasMv(boolean z) {
        if(z) {
            this.metaFlag |= 0x80L;
            return;
        }
        this.metaFlag &= 0xFFFFFFFFFFFFFF7FL;
    }

    public void setHitSong(int v) {
        this.setHitSong(v == 1);
    }

    public void setHitSong(boolean z) {
        if(z) {
            this.metaFlag |= 16L;
            return;
        }
        this.metaFlag &= -17L;
    }

    public void setHoldback(int v) {
        this.setHoldback(v == 1);
    }

    public void setHoldback(boolean z) {
        if(z) {
            this.metaFlag |= 0x20L;
            return;
        }
        this.metaFlag &= -33L;
    }

    public void setImpossCode(String s) {
        this.impossCode = s;
    }

    public void setImpossDesc(String s) {
        this.impossDesc = s;
    }

    public void setIsDownload(int v) {
        this.setIsDownload(v == 1);
    }

    public void setIsDownload(String s) {
        this.setIsDownload("true".equalsIgnoreCase(s));
    }

    public void setIsDownload(boolean z) {
        if(z) {
            this.metaFlag |= 0x100L;
            return;
        }
        this.metaFlag &= 0xFFFFFFFFFFFFFEFFL;
    }

    public void setIsFlacSt(boolean z) {
        this.isFlacSt = z;
    }

    public void setIsHttps(boolean z) {
        this.isHttps = z;
    }

    public void setIsLandscapeMv(boolean z) {
        this.isLandscapeMv = z;
    }

    public void setIsPrivate(String s) {
        this.setIsPrivate("true".equalsIgnoreCase(s));
    }

    public void setIsPrivate(boolean z) {
        if(z) {
            this.metaFlag |= 0x1000L;
            return;
        }
        this.metaFlag &= 0xFFFFFFFFFFFFEFFFL;
    }

    public void setIsSong(int v) {
        this.setIsSong(v == 1);
    }

    public void setIsSong(String s) {
        this.setIsSong("true".equalsIgnoreCase(s));
    }

    public void setIsSong(boolean z) {
        if(z) {
            this.metaFlag |= 0x800L;
            return;
        }
        this.metaFlag &= 0xFFFFFFFFFFFFF7FFL;
    }

    public void setIsadult(String s) {
        this.setAdult("true".equalsIgnoreCase(s));
    }

    public void setIsfree(String s) {
        this.setFree("true".equalsIgnoreCase(s));
    }

    public void setIshitsong(String s) {
        this.setHitSong("true".equalsIgnoreCase(s));
    }

    public void setIsholdback(String s) {
        this.setHoldback("true".equalsIgnoreCase(s));
    }

    public void setIsmelonsong(String s) {
        this.setMelonSong("true".equalsIgnoreCase(s));
    }

    public void setIsmv(String s) {
        this.setHasMv("true".equalsIgnoreCase(s));
    }

    public void setIsservice(String s) {
        this.setService("true".equalsIgnoreCase(s));
    }

    public void setIssueDate(String s) {
        this.issueDate = s;
    }

    public void setIstitle(String s) {
        this.setTitle("true".equalsIgnoreCase(s));
    }

    public void setLastGetPathTime(long v) {
        this.lastGetPathTime = v;
    }

    public void setLikeCount(int v) {
        this.likeCount = v;
    }

    public void setLiked(boolean z) {
        this.liked = z;
    }

    public void setLiveStatusCode(String s) {
        this.liveStatusCode = s;
    }

    public void setLocalAlbumKey(String s) {
        this.localAlbumKey = s;
    }

    public void setLoggingToken(String s) {
        this.loggingToken = s;
    }

    public void setLyricLastUpdated(String s) {
        this.lyricFileUpdtDate = s;
    }

    public void setLyricType(String s) {
        this.lyricType = s;
    }

    public void setLyricspath(String s) {
        this.lyricsPath = s;
    }

    public long setMediaStoreAlbumId(long v) {
        this.mediaStoreAlbumId = v;
        return v;
    }

    public void setMelonSong(int v) {
        this.setMelonSong(v == 1);
    }

    public void setMelonSong(boolean z) {
        if(z) {
            this.metaFlag |= 1L;
            return;
        }
        this.metaFlag &= -2L;
    }

    public void setMenuid(String s) {
        this.menuId = s;
    }

    public void setMetatype(String s) {
        this.metaType = s;
    }

    public void setMimeType(String s) {
        this.mimeType = s;
    }

    public void setMvHeight(int v) {
        this.mvHeight = v;
    }

    public void setMvWidth(int v) {
        this.mvWidth = v;
    }

    public void setMvid(String s) {
        this.mvId = s;
    }

    public void setMvname(String s) {
        this.mvName = s;
    }

    public void setOrder(int v) {
        this.order = v;
    }

    public void setOrigin(int v) {
        this.origin = v;
    }

    public void setOriginMenuId(String s) {
        this.originMenuId = s;
    }

    public void setPInterval(int v) {
        this.pInterval = v;
    }

    public void setPlayCount(int v) {
        this.playCount = v;
    }

    public void setPlayToken(String s) {
        this.playToken = s;
    }

    public void setPostEditImg(String s) {
        this.postEditImg = s;
    }

    public void setPostImg(String s) {
        this.postImg = s;
    }

    public void setProtocolType(String s) {
        this.protocolType = s;
    }

    public void setPstime(String s) {
        this.pstime = s;
    }

    public void setService(int v) {
        this.setService(v == 1);
    }

    public void setService(boolean z) {
        if(z) {
            this.metaFlag |= 2L;
            return;
        }
        this.metaFlag &= -3L;
    }

    public void setSongName(String s) {
        if(TextUtils.isEmpty(s)) {
            s = "";
        }
        this.songName = s;
        if(Playable.LOGV) {
            LogU.v("Playable", "songName() " + this.songName);
        }
    }

    public void setSongid(int v) {
        LogU.v("Playable", "setSongId: " + v);
        this.songId = v;
    }

    public void setSongid(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("Playable", "setSongid() invalid songId");
            return;
        }
        try {
            this.setSongid(((int)Integer.valueOf(s)));
        }
        catch(Exception exception0) {
            LogU.w("Playable", "setSongid() " + exception0.toString());
            this.setSongid(-1);
        }
    }

    public void setStatsElements(StatsElementsBase statsElementsBase0) {
        if(statsElementsBase0 != null) {
            this.statsElements = StatsElementsBase.toJsonString(statsElementsBase0);
        }
    }

    public void setStatsElements(String s) {
        this.statsElements = s;
    }

    public void setStreamPath(String s) {
        Z.w("setStreamPath:", s, "Playable");
        this.streamPath = s;
    }

    public void setTitle(int v) {
        this.setTitle(v == 1);
    }

    public void setTitle(boolean z) {
        if(z) {
            this.metaFlag |= 4L;
            return;
        }
        this.metaFlag &= -5L;
    }

    public void setUriString(String s) {
        if(Playable.LOGV) {
            StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("setUriString: ", s, ", songId: ");
            stringBuilder0.append(this.songId);
            LogU.v("Playable", stringBuilder0.toString());
        }
        this.uriString = s;
    }

    public void setViewCount(int v) {
        this.viewCount = v;
    }

    private String toLiveString() [...] // 潜在的解密器

    public String toShortString() [...] // 潜在的解密器

    // 去混淆评级： 低(36)
    public Song toSong() {
        if(this.hasSongId()) {
            return StorageUtils.isScopedStorage() ? new Song(null, Uri.parse(""), "", 2) : new Song(this.data, null, "", 2);
        }
        return CType.SONG.equals(this.getCtype()) ? Song.e(this, false) : null;
    }

    @Override  // com.iloen.melon.sns.model.SharableBase
    public String toString() {
        if(Playable.SHORT_TOSTRING) {
            return "Playable {orig=0,ctype=null,menuId=,cid=,duration=3600000,durLimit=-1,data=,uriString=,streamPath=, trackId= }";
        }
        if(this.isTypeOfLive()) {
            return "Playable {cType=null,menuId=,liveSeq=,liveTitle=,liveStatusCode=}";
        }
        StringBuilder stringBuilder0 = new StringBuilder("Playable {orig=");
        stringBuilder0.append(this.origin);
        stringBuilder0.append(",ctype=");
        stringBuilder0.append(this.cType);
        stringBuilder0.append(",duration=");
        stringBuilder0.append(this.duration);
        stringBuilder0.append(",menuId=");
        stringBuilder0.append(this.menuId);
        stringBuilder0.append(",data=");
        stringBuilder0.append(this.data);
        stringBuilder0.append(",streamPath=");
        stringBuilder0.append(this.streamPath);
        stringBuilder0.append(",lastPlaybackPath=");
        stringBuilder0.append(this.lastPlaybackPath);
        stringBuilder0.append(",cid=");
        stringBuilder0.append("");
        stringBuilder0.append(",songId=");
        stringBuilder0.append(this.songId);
        stringBuilder0.append(",songName=");
        stringBuilder0.append(this.songName);
        stringBuilder0.append(",artIds=");
        stringBuilder0.append(this.artistIds);
        stringBuilder0.append(",artNames=");
        stringBuilder0.append(this.artistNames);
        stringBuilder0.append(",album=");
        stringBuilder0.append(this.albumName);
        stringBuilder0.append(",albumId=");
        stringBuilder0.append(this.albumId);
        stringBuilder0.append(",albumImg=");
        stringBuilder0.append(this.albumImg);
        stringBuilder0.append(",albumImgThumb=");
        stringBuilder0.append(this.albumImgThumb);
        if(this.isTypeOfMv()) {
            stringBuilder0.append(",mvId=");
            stringBuilder0.append(this.mvId);
            stringBuilder0.append(",mvName=");
            stringBuilder0.append(this.mvName);
        }
        stringBuilder0.append(",durLimit=");
        stringBuilder0.append(this.durationLimit);
        stringBuilder0.append(",bitrate=");
        stringBuilder0.append(this.bitrate);
        stringBuilder0.append(",metatype=");
        stringBuilder0.append(this.metaType);
        stringBuilder0.append(",loggingToken=");
        stringBuilder0.append(this.loggingToken);
        stringBuilder0.append(",protocolType=");
        stringBuilder0.append(this.protocolType);
        stringBuilder0.append(",lyricType=");
        stringBuilder0.append(this.lyricType);
        stringBuilder0.append(",lyricsPath=");
        stringBuilder0.append(this.lyricsPath);
        stringBuilder0.append(",lyricFileUpdtDate=");
        stringBuilder0.append(this.lyricFileUpdtDate);
        stringBuilder0.append(",ismelonsong=");
        String s = "false";
        stringBuilder0.append((this.isMelonSong() ? "true" : "false"));
        stringBuilder0.append(",isservice=");
        stringBuilder0.append((this.isService() ? "true" : "false"));
        stringBuilder0.append(",istitle=");
        stringBuilder0.append((this.isTitle() ? "true" : "false"));
        stringBuilder0.append(",isadult=");
        stringBuilder0.append((this.isAdult() ? "true" : "false"));
        stringBuilder0.append(",ishitsong=");
        stringBuilder0.append((this.isHitSong() ? "true" : "false"));
        stringBuilder0.append(",isholdback=");
        stringBuilder0.append((this.isHoldback() ? "true" : "false"));
        stringBuilder0.append(",isfree=");
        stringBuilder0.append((this.isFree() ? "true" : "false"));
        stringBuilder0.append(",havMv=");
        stringBuilder0.append((this.hasMv() ? "true" : "false"));
        if(this.isTypeOfMv()) {
            stringBuilder0.append(",isDownload=");
            stringBuilder0.append((this.isDownload() ? "true" : "false"));
            stringBuilder0.append(",isSong=");
            stringBuilder0.append((this.isSong() ? "true" : "false"));
        }
        if(this.isTypeOfLive()) {
            stringBuilder0.append(",isOnAir=");
            stringBuilder0.append((this.isOnAir() ? "true" : "false"));
            stringBuilder0.append(",isLivePreView=");
            stringBuilder0.append((this.isLivePreView() ? "true" : "false"));
        }
        stringBuilder0.append(",liked=");
        stringBuilder0.append((this.isLiked() ? "true" : "false"));
        stringBuilder0.append(",likeCount=");
        stringBuilder0.append(this.likeCount);
        if(this.isTypeOfMv()) {
            stringBuilder0.append(",viewCount=");
            stringBuilder0.append(this.viewCount);
            stringBuilder0.append(",issueDate=");
            stringBuilder0.append(this.issueDate);
        }
        stringBuilder0.append(",createdAt=");
        stringBuilder0.append(this.createdAt);
        stringBuilder0.append(",createdSeq=");
        stringBuilder0.append(this.createdSeq);
        stringBuilder0.append(",playCount=");
        stringBuilder0.append(this.playCount);
        stringBuilder0.append(",order=");
        stringBuilder0.append(this.order);
        stringBuilder0.append(",isFlacSt=");
        stringBuilder0.append((this.isFlacSt ? "true" : "false"));
        stringBuilder0.append(",postImg=");
        stringBuilder0.append(this.postImg);
        stringBuilder0.append(",postEditImg=");
        stringBuilder0.append(this.postEditImg);
        stringBuilder0.append(",isLandscapeMv=");
        stringBuilder0.append((this.isLandscapeMv ? "true" : "false"));
        stringBuilder0.append(",mvWidth=");
        stringBuilder0.append(this.mvWidth);
        stringBuilder0.append(",mvHeight=");
        stringBuilder0.append(this.mvHeight);
        stringBuilder0.append(",isShowKakaoLoginPopup=");
        stringBuilder0.append((this.isShowKakaoLoginPopup ? "true" : "false"));
        stringBuilder0.append(",isBookFile=");
        stringBuilder0.append((this.isBookFile ? "true" : "false"));
        stringBuilder0.append(",isFlacAvail=");
        stringBuilder0.append((this.isFlacAvail ? "true" : "false"));
        stringBuilder0.append(",isFlac16Avail=");
        stringBuilder0.append((this.isFlac16Avail ? "true" : "false"));
        stringBuilder0.append(",isFlac24Avail=");
        stringBuilder0.append((this.isFlac24Avail ? "true" : "false"));
        stringBuilder0.append(",flacCode=");
        stringBuilder0.append(this.flacCode);
        stringBuilder0.append(",isPrivate=");
        stringBuilder0.append((this.isPrivate() ? "true" : "false"));
        stringBuilder0.append(",pstime=");
        stringBuilder0.append(this.pstime);
        stringBuilder0.append(",mimeType=");
        stringBuilder0.append(this.mimeType);
        stringBuilder0.append(",originMenuId=");
        stringBuilder0.append(this.originMenuId);
        stringBuilder0.append(",statsElements=");
        stringBuilder0.append(this.statsElements);
        stringBuilder0.append(",isBrandDj=");
        if(this.isBrandDj) {
            s = "true";
        }
        stringBuilder0.append(s);
        stringBuilder0.append(",uriString=");
        stringBuilder0.append(this.uriString);
        stringBuilder0.append(",displayName=");
        stringBuilder0.append(this.displayName);
        stringBuilder0.append(",liveStatusCode=");
        stringBuilder0.append(this.liveStatusCode);
        stringBuilder0.append(", trackId=");
        stringBuilder0.append(this.trackId);
        if(this.bgVideo == null) {
            stringBuilder0.append(",bgVideo=null");
        }
        else {
            stringBuilder0.append(",bgVideoPath=");
            stringBuilder0.append("");
            stringBuilder0.append(",bgVideoImgPath=");
            stringBuilder0.append("");
        }
        if(this.bgImgs == null) {
            stringBuilder0.append(",bgImgs=null");
        }
        else {
            for(int v = 0; v < this.bgImgs.size(); ++v) {
                stringBuilder0.append(",bgImgPath[");
                stringBuilder0.append(v);
                stringBuilder0.append("]=");
                stringBuilder0.append("");
            }
        }
        stringBuilder0.append(",pInteval=");
        stringBuilder0.append(this.pInterval);
        stringBuilder0.append(",playToken=");
        stringBuilder0.append(this.playToken);
        stringBuilder0.append(",lastGetPathTime=");
        stringBuilder0.append(this.lastGetPathTime);
        stringBuilder0.append(",isMusicWaveSong= ");
        return o.s(stringBuilder0, this.isMusicWaveSong, "}");
    }

    public void updateFrom(Song song0) {
        if(song0 != null && song0.c()) {
            this.setSongid(song0.b);
            if(!TextUtils.isEmpty(song0.c)) {
                this.setSongName(song0.c);
            }
            this.setAlbumId(song0.g);
            this.setArtists(StringUtils.makeArtistMap(song0.h, song0.i));
            LogU.d("Playable", "updateFrom - p:" + this + ", from:" + song0);
            return;
        }
        this.albumId = "";
        this.artistIds = "";
    }

    public void updateFrom(SongInfoBase songInfoBase0) {
        if(songInfoBase0 != null) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            ArrayList arrayList0 = songInfoBase0.artistList;
            if(arrayList0 != null) {
                for(Object object0: arrayList0) {
                    linkedHashMap0.put(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName());
                }
            }
            this.setSongid(songInfoBase0.songId);
            this.setSongName(songInfoBase0.songName);
            this.setAlbum(songInfoBase0.albumId, songInfoBase0.albumName);
            this.setAlbumImg(songInfoBase0.albumImgLarge);
            this.setAlbumImgThumb(songInfoBase0.albumImg);
            this.setArtists(linkedHashMap0);
            LogU.d("Playable", "updateFrom - p:" + this + ", from:" + songInfoBase0);
        }
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.origin);
        parcel0.writeString(this.data);
        parcel0.writeString(this.songName);
        parcel0.writeSerializable(((Serializable)this.artistMap));
        parcel0.writeString(this.artistNames);
        parcel0.writeString(this.artistIds);
        parcel0.writeString(this.albumName);
        parcel0.writeString(this.albumId);
        parcel0.writeString(this.albumImg);
        parcel0.writeString(this.albumImgThumb);
        parcel0.writeString(this.mvId);
        parcel0.writeString(this.mvName);
        parcel0.writeLong(this.duration);
        parcel0.writeInt(this.songId);
        parcel0.writeString(String.valueOf(this.cType));
        parcel0.writeString(this.menuId);
        parcel0.writeString(this.streamPath);
        parcel0.writeLong(this.durationLimit);
        parcel0.writeInt(this.liked);
        parcel0.writeInt(this.likeCount);
        parcel0.writeInt(this.viewCount);
        parcel0.writeString(this.issueDate);
        parcel0.writeString(this.bitrate);
        parcel0.writeString(this.metaType);
        parcel0.writeString(this.loggingToken);
        parcel0.writeString(this.protocolType);
        parcel0.writeString(this.c);
        parcel0.writeString(this.lyricType);
        parcel0.writeString(this.lyricsPath);
        parcel0.writeString(this.lyricFileUpdtDate);
        parcel0.writeLong(this.metaFlag);
        parcel0.writeInt(this.createdSeq);
        parcel0.writeLong(this.createdAt);
        parcel0.writeInt(this.downloadOrigin);
        parcel0.writeString(this.dbContentId);
        parcel0.writeLong(this.mediaStoreAlbumId);
        parcel0.writeString(this.localAlbumKey);
        parcel0.writeInt(this.playCount);
        parcel0.writeInt(this.order);
        parcel0.writeInt(((int)this.isFlacSt));
        parcel0.writeString(this.postImg);
        parcel0.writeString(this.postEditImg);
        parcel0.writeInt(((int)this.isLandscapeMv));
        parcel0.writeInt(this.mvWidth);
        parcel0.writeInt(this.mvHeight);
        parcel0.writeInt(((int)this.isBookFile));
        parcel0.writeInt(((int)this.isFlacAvail));
        parcel0.writeInt(((int)this.isFlac16Avail));
        parcel0.writeInt(((int)this.isFlac24Avail));
        parcel0.writeString(this.flacCode);
        parcel0.writeSerializable(((Serializable)this.albumImgs));
        parcel0.writeString(this.pstime);
        parcel0.writeString(this.mimeType);
        parcel0.writeString(this.originMenuId);
        parcel0.writeString(this.statsElements);
        parcel0.writeInt(((int)this.isBrandDj));
        parcel0.writeSerializable(((Serializable)this.genreList));
        parcel0.writeString(this.uriString);
        parcel0.writeString(this.displayName);
        parcel0.writeString(this.liveSeq);
        parcel0.writeString(this.liveTitle);
        parcel0.writeString(this.liveStatusCode);
        parcel0.writeString(this.trackId);
        parcel0.writeSerializable(this.bgVideo);
        parcel0.writeSerializable(this.bgImgs);
        parcel0.writeInt(this.pInterval);
        parcel0.writeString(this.playToken);
        parcel0.writeLong(this.lastGetPathTime);
        parcel0.writeInt(((int)this.isMusicWaveSong));
    }
}

