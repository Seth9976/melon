package com.melon.net.res.v3;

import A7.d;
import Tf.v;
import U4.x;
import androidx.appcompat.app.o;
import ba.s;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001:\f\u001D\u001E\u001F !\"#$%&\'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tJ\u0010\u0010\n\u001A\u0004\u0018\u00010\u000B*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\f\u001A\u0004\u0018\u00010\r*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000F*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0017*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0018\u001A\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u001A\u001A\u0004\u0018\u00010\u00072\u0006\u0010\u001B\u001A\u00020\u001C¨\u0006)"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper;", "", "<init>", "()V", "getAttachPropertyData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "attachType", "", "attachProperty", "Lcom/melon/net/res/v3/CommentApiModel$AttachPropertyBase;", "toImageData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachImageData;", "toSongData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachSongData;", "toAlbumData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachAlbumData;", "toArtistData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachArtistData;", "toVideoData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachVideoData;", "toLinkVideoData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachLinkVideoData;", "toLinkGenrlData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachLinkGenrlData;", "toKakaoEmoticonData", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachKakaoEmoticonData;", "getMvAgeLevelIcon", "videoAgeLevel", "", "AttachType", "AttachPropertyData", "None", "AttachImageData", "AttachMusicData", "AttachSongData", "AttachAlbumData", "AttachArtistData", "AttachVideoData", "AttachLinkVideoData", "AttachLinkGenrlData", "AttachKakaoEmoticonData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MediaAttachHelper {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\b\b\u0002\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001A\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÆ\u0003J\t\u0010\u001B\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001C\u001A\u00020\u0005HÆ\u0003J\t\u0010\u001D\u001A\u00020\u000BHÆ\u0003JO\u0010\u001E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u000BHÆ\u0001J\u0013\u0010\u001F\u001A\u00020\u000B2\b\u0010 \u001A\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001A\u00020\u0003HÖ\u0001J\t\u0010#\u001A\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0011\u0010\b\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0011R\u0011\u0010\t\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001A\u00020\u000B¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u0016¨\u0006$"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachAlbumData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachMusicData;", "albumId", "", "albumName", "", "albumImagePath", "artistId", "artistName", "displayIssueDate", "isService", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Z)V", "getAlbumId", "()I", "getAlbumName", "()Ljava/lang/String;", "getAlbumImagePath", "getArtistId", "getArtistName", "getDisplayIssueDate", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachAlbumData implements AttachMusicData {
        public static final int $stable;
        private final int albumId;
        @NotNull
        private final String albumImagePath;
        @NotNull
        private final String albumName;
        private final int artistId;
        @NotNull
        private final String artistName;
        @NotNull
        private final String displayIssueDate;
        private final boolean isService;

        public AttachAlbumData(int v, @NotNull String s, @NotNull String s1, int v1, @NotNull String s2, @NotNull String s3, boolean z) {
            q.g(s, "albumName");
            q.g(s1, "albumImagePath");
            q.g(s2, "artistName");
            q.g(s3, "displayIssueDate");
            super();
            this.albumId = v;
            this.albumName = s;
            this.albumImagePath = s1;
            this.artistId = v1;
            this.artistName = s2;
            this.displayIssueDate = s3;
            this.isService = z;
        }

        public AttachAlbumData(int v, String s, String s1, int v1, String s2, String s3, boolean z, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 1) != 0) {
                v = -1;
            }
            if((v2 & 8) != 0) {
                v1 = -1;
            }
            if((v2 & 0x40) != 0) {
                z = false;
            }
            this(v, s, s1, v1, s2, s3, z);
        }

        public final int component1() {
            return this.albumId;
        }

        @NotNull
        public final String component2() {
            return this.albumName;
        }

        @NotNull
        public final String component3() {
            return this.albumImagePath;
        }

        public final int component4() {
            return this.artistId;
        }

        @NotNull
        public final String component5() {
            return this.artistName;
        }

        @NotNull
        public final String component6() {
            return this.displayIssueDate;
        }

        public final boolean component7() {
            return this.isService;
        }

        @NotNull
        public final AttachAlbumData copy(int v, @NotNull String s, @NotNull String s1, int v1, @NotNull String s2, @NotNull String s3, boolean z) {
            q.g(s, "albumName");
            q.g(s1, "albumImagePath");
            q.g(s2, "artistName");
            q.g(s3, "displayIssueDate");
            return new AttachAlbumData(v, s, s1, v1, s2, s3, z);
        }

        public static AttachAlbumData copy$default(AttachAlbumData mediaAttachHelper$AttachAlbumData0, int v, String s, String s1, int v1, String s2, String s3, boolean z, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = mediaAttachHelper$AttachAlbumData0.albumId;
            }
            if((v2 & 2) != 0) {
                s = mediaAttachHelper$AttachAlbumData0.albumName;
            }
            if((v2 & 4) != 0) {
                s1 = mediaAttachHelper$AttachAlbumData0.albumImagePath;
            }
            if((v2 & 8) != 0) {
                v1 = mediaAttachHelper$AttachAlbumData0.artistId;
            }
            if((v2 & 16) != 0) {
                s2 = mediaAttachHelper$AttachAlbumData0.artistName;
            }
            if((v2 & 0x20) != 0) {
                s3 = mediaAttachHelper$AttachAlbumData0.displayIssueDate;
            }
            if((v2 & 0x40) != 0) {
                z = mediaAttachHelper$AttachAlbumData0.isService;
            }
            return mediaAttachHelper$AttachAlbumData0.copy(v, s, s1, v1, s2, s3, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AttachAlbumData)) {
                return false;
            }
            if(this.albumId != ((AttachAlbumData)object0).albumId) {
                return false;
            }
            if(!q.b(this.albumName, ((AttachAlbumData)object0).albumName)) {
                return false;
            }
            if(!q.b(this.albumImagePath, ((AttachAlbumData)object0).albumImagePath)) {
                return false;
            }
            if(this.artistId != ((AttachAlbumData)object0).artistId) {
                return false;
            }
            if(!q.b(this.artistName, ((AttachAlbumData)object0).artistName)) {
                return false;
            }
            return q.b(this.displayIssueDate, ((AttachAlbumData)object0).displayIssueDate) ? this.isService == ((AttachAlbumData)object0).isService : false;
        }

        public final int getAlbumId() {
            return this.albumId;
        }

        @NotNull
        public final String getAlbumImagePath() {
            return this.albumImagePath;
        }

        @NotNull
        public final String getAlbumName() {
            return this.albumName;
        }

        public final int getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @NotNull
        public final String getDisplayIssueDate() {
            return this.displayIssueDate;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isService) + x.b(x.b(d.b(this.artistId, x.b(x.b(this.albumId * 0x1F, 0x1F, this.albumName), 0x1F, this.albumImagePath), 0x1F), 0x1F, this.artistName), 0x1F, this.displayIssueDate);
        }

        public final boolean isService() {
            return this.isService;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = x.o(this.albumId, "AttachAlbumData(albumId=", ", albumName=", this.albumName, ", albumImagePath=");
            d.t(stringBuilder0, this.albumImagePath, ", artistId=", this.artistId, ", artistName=");
            d.u(stringBuilder0, this.artistName, ", displayIssueDate=", this.displayIssueDate, ", isService=");
            return o.s(stringBuilder0, this.isService, ")");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001F\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\u0006\u0010\t\u001A\u00020\u0005\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\b\b\u0002\u0010\f\u001A\u00020\u0003\u00A2\u0006\u0004\b\r\u0010\u000EJ\t\u0010\u001A\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001B\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\u001C\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\u001D\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\u001E\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\u001F\u001A\u00020\u0005H\u00C6\u0003J\t\u0010 \u001A\u00020\u0005H\u00C6\u0003J\t\u0010!\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\"\u001A\u00020\u0003H\u00C6\u0003Jc\u0010#\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00052\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\f\u001A\u00020\u0003H\u00C6\u0001J\u0013\u0010$\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u00D6\u0003J\t\u0010(\u001A\u00020\u0003H\u00D6\u0001J\t\u0010)\u001A\u00020\u0005H\u00D6\u0001R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0012R\u0011\u0010\t\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0012R\u0011\u0010\u000B\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0012R\u0011\u0010\f\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0010\u00A8\u0006*"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachArtistData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachMusicData;", "artistId", "", "artistName", "", "artistImagePath", "artistType", "nationalityName", "actTypeName", "sex", "genre", "fanCount", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getArtistId", "()I", "getArtistName", "()Ljava/lang/String;", "getArtistImagePath", "getArtistType", "getNationalityName", "getActTypeName", "getSex", "getGenre", "getFanCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachArtistData implements AttachMusicData {
        public static final int $stable;
        @NotNull
        private final String actTypeName;
        private final int artistId;
        @NotNull
        private final String artistImagePath;
        @NotNull
        private final String artistName;
        @NotNull
        private final String artistType;
        private final int fanCount;
        @NotNull
        private final String genre;
        @NotNull
        private final String nationalityName;
        @NotNull
        private final String sex;

        public AttachArtistData(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, int v1) {
            q.g(s, "artistName");
            q.g(s1, "artistImagePath");
            q.g(s2, "artistType");
            q.g(s3, "nationalityName");
            q.g(s4, "actTypeName");
            q.g(s5, "sex");
            q.g(s6, "genre");
            super();
            this.artistId = v;
            this.artistName = s;
            this.artistImagePath = s1;
            this.artistType = s2;
            this.nationalityName = s3;
            this.actTypeName = s4;
            this.sex = s5;
            this.genre = s6;
            this.fanCount = v1;
        }

        public AttachArtistData(int v, String s, String s1, String s2, String s3, String s4, String s5, String s6, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 1) != 0) {
                v = -1;
            }
            this(v, s, s1, s2, s3, s4, s5, s6, ((v2 & 0x100) == 0 ? v1 : -1));
        }

        public final int component1() {
            return this.artistId;
        }

        @NotNull
        public final String component2() {
            return this.artistName;
        }

        @NotNull
        public final String component3() {
            return this.artistImagePath;
        }

        @NotNull
        public final String component4() {
            return this.artistType;
        }

        @NotNull
        public final String component5() {
            return this.nationalityName;
        }

        @NotNull
        public final String component6() {
            return this.actTypeName;
        }

        @NotNull
        public final String component7() {
            return this.sex;
        }

        @NotNull
        public final String component8() {
            return this.genre;
        }

        public final int component9() {
            return this.fanCount;
        }

        @NotNull
        public final AttachArtistData copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, int v1) {
            q.g(s, "artistName");
            q.g(s1, "artistImagePath");
            q.g(s2, "artistType");
            q.g(s3, "nationalityName");
            q.g(s4, "actTypeName");
            q.g(s5, "sex");
            q.g(s6, "genre");
            return new AttachArtistData(v, s, s1, s2, s3, s4, s5, s6, v1);
        }

        public static AttachArtistData copy$default(AttachArtistData mediaAttachHelper$AttachArtistData0, int v, String s, String s1, String s2, String s3, String s4, String s5, String s6, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = mediaAttachHelper$AttachArtistData0.artistId;
            }
            if((v2 & 2) != 0) {
                s = mediaAttachHelper$AttachArtistData0.artistName;
            }
            if((v2 & 4) != 0) {
                s1 = mediaAttachHelper$AttachArtistData0.artistImagePath;
            }
            if((v2 & 8) != 0) {
                s2 = mediaAttachHelper$AttachArtistData0.artistType;
            }
            if((v2 & 16) != 0) {
                s3 = mediaAttachHelper$AttachArtistData0.nationalityName;
            }
            if((v2 & 0x20) != 0) {
                s4 = mediaAttachHelper$AttachArtistData0.actTypeName;
            }
            if((v2 & 0x40) != 0) {
                s5 = mediaAttachHelper$AttachArtistData0.sex;
            }
            if((v2 & 0x80) != 0) {
                s6 = mediaAttachHelper$AttachArtistData0.genre;
            }
            if((v2 & 0x100) != 0) {
                v1 = mediaAttachHelper$AttachArtistData0.fanCount;
            }
            return mediaAttachHelper$AttachArtistData0.copy(v, s, s1, s2, s3, s4, s5, s6, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AttachArtistData)) {
                return false;
            }
            if(this.artistId != ((AttachArtistData)object0).artistId) {
                return false;
            }
            if(!q.b(this.artistName, ((AttachArtistData)object0).artistName)) {
                return false;
            }
            if(!q.b(this.artistImagePath, ((AttachArtistData)object0).artistImagePath)) {
                return false;
            }
            if(!q.b(this.artistType, ((AttachArtistData)object0).artistType)) {
                return false;
            }
            if(!q.b(this.nationalityName, ((AttachArtistData)object0).nationalityName)) {
                return false;
            }
            if(!q.b(this.actTypeName, ((AttachArtistData)object0).actTypeName)) {
                return false;
            }
            if(!q.b(this.sex, ((AttachArtistData)object0).sex)) {
                return false;
            }
            return q.b(this.genre, ((AttachArtistData)object0).genre) ? this.fanCount == ((AttachArtistData)object0).fanCount : false;
        }

        @NotNull
        public final String getActTypeName() {
            return this.actTypeName;
        }

        public final int getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistImagePath() {
            return this.artistImagePath;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @NotNull
        public final String getArtistType() {
            return this.artistType;
        }

        public final int getFanCount() {
            return this.fanCount;
        }

        @NotNull
        public final String getGenre() {
            return this.genre;
        }

        @NotNull
        public final String getNationalityName() {
            return this.nationalityName;
        }

        @NotNull
        public final String getSex() {
            return this.sex;
        }

        @Override
        public int hashCode() {
            return this.fanCount + x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.artistId * 0x1F, 0x1F, this.artistName), 0x1F, this.artistImagePath), 0x1F, this.artistType), 0x1F, this.nationalityName), 0x1F, this.actTypeName), 0x1F, this.sex), 0x1F, this.genre);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = x.o(this.artistId, "AttachArtistData(artistId=", ", artistName=", this.artistName, ", artistImagePath=");
            d.u(stringBuilder0, this.artistImagePath, ", artistType=", this.artistType, ", nationalityName=");
            d.u(stringBuilder0, this.nationalityName, ", actTypeName=", this.actTypeName, ", sex=");
            d.u(stringBuilder0, this.sex, ", genre=", this.genre, ", fanCount=");
            return x.g(this.fanCount, ")", stringBuilder0);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachImageData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "thumbUrl", "", "originalUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getThumbUrl", "()Ljava/lang/String;", "getOriginalUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachImageData implements AttachPropertyData {
        public static final int $stable;
        @NotNull
        private final String originalUrl;
        @NotNull
        private final String thumbUrl;

        public AttachImageData(@NotNull String s, @NotNull String s1) {
            q.g(s, "thumbUrl");
            q.g(s1, "originalUrl");
            super();
            this.thumbUrl = s;
            this.originalUrl = s1;
        }

        @NotNull
        public final String component1() {
            return this.thumbUrl;
        }

        @NotNull
        public final String component2() {
            return this.originalUrl;
        }

        @NotNull
        public final AttachImageData copy(@NotNull String s, @NotNull String s1) {
            q.g(s, "thumbUrl");
            q.g(s1, "originalUrl");
            return new AttachImageData(s, s1);
        }

        public static AttachImageData copy$default(AttachImageData mediaAttachHelper$AttachImageData0, String s, String s1, int v, Object object0) {
            if((v & 1) != 0) {
                s = mediaAttachHelper$AttachImageData0.thumbUrl;
            }
            if((v & 2) != 0) {
                s1 = mediaAttachHelper$AttachImageData0.originalUrl;
            }
            return mediaAttachHelper$AttachImageData0.copy(s, s1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AttachImageData)) {
                return false;
            }
            return q.b(this.thumbUrl, ((AttachImageData)object0).thumbUrl) ? q.b(this.originalUrl, ((AttachImageData)object0).originalUrl) : false;
        }

        @NotNull
        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        @NotNull
        public final String getThumbUrl() {
            return this.thumbUrl;
        }

        @Override
        public int hashCode() {
            return this.originalUrl.hashCode() + this.thumbUrl.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "AttachImageData(thumbUrl=" + this.thumbUrl + ", originalUrl=" + this.originalUrl + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachKakaoEmoticonData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "kakaoEmoticonParam", "", "<init>", "(Ljava/lang/String;)V", "getKakaoEmoticonParam", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachKakaoEmoticonData implements AttachPropertyData {
        public static final int $stable;
        @NotNull
        private final String kakaoEmoticonParam;

        public AttachKakaoEmoticonData(@NotNull String s) {
            q.g(s, "kakaoEmoticonParam");
            super();
            this.kakaoEmoticonParam = s;
        }

        @NotNull
        public final String component1() {
            return this.kakaoEmoticonParam;
        }

        @NotNull
        public final AttachKakaoEmoticonData copy(@NotNull String s) {
            q.g(s, "kakaoEmoticonParam");
            return new AttachKakaoEmoticonData(s);
        }

        public static AttachKakaoEmoticonData copy$default(AttachKakaoEmoticonData mediaAttachHelper$AttachKakaoEmoticonData0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = mediaAttachHelper$AttachKakaoEmoticonData0.kakaoEmoticonParam;
            }
            return mediaAttachHelper$AttachKakaoEmoticonData0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AttachKakaoEmoticonData ? q.b(this.kakaoEmoticonParam, ((AttachKakaoEmoticonData)object0).kakaoEmoticonParam) : false;
        }

        @NotNull
        public final String getKakaoEmoticonParam() {
            return this.kakaoEmoticonParam;
        }

        @Override
        public int hashCode() {
            return this.kakaoEmoticonParam.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "AttachKakaoEmoticonData(kakaoEmoticonParam=" + this.kakaoEmoticonParam + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachLinkGenrlData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "originalUrl", "", "<init>", "(Ljava/lang/String;)V", "getOriginalUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachLinkGenrlData implements AttachPropertyData {
        public static final int $stable;
        @NotNull
        private final String originalUrl;

        public AttachLinkGenrlData(@NotNull String s) {
            q.g(s, "originalUrl");
            super();
            this.originalUrl = s;
        }

        @NotNull
        public final String component1() {
            return this.originalUrl;
        }

        @NotNull
        public final AttachLinkGenrlData copy(@NotNull String s) {
            q.g(s, "originalUrl");
            return new AttachLinkGenrlData(s);
        }

        public static AttachLinkGenrlData copy$default(AttachLinkGenrlData mediaAttachHelper$AttachLinkGenrlData0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = mediaAttachHelper$AttachLinkGenrlData0.originalUrl;
            }
            return mediaAttachHelper$AttachLinkGenrlData0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof AttachLinkGenrlData ? q.b(this.originalUrl, ((AttachLinkGenrlData)object0).originalUrl) : false;
        }

        @NotNull
        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        @Override
        public int hashCode() {
            return this.originalUrl.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "AttachLinkGenrlData(originalUrl=" + this.originalUrl + ")";
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001A\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001A\u00020\u0007HÆ\u0003J;\u0010\u0017\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u001BHÖ\u0003J\t\u0010\u001C\u001A\u00020\u0007HÖ\u0001J\t\u0010\u001D\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\fR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\b\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u001E"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachLinkVideoData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "videoTitle", "", "videoImagePath", "originalUrl", "videoWidth", "", "videoHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getVideoTitle", "()Ljava/lang/String;", "getVideoImagePath", "getOriginalUrl", "getVideoWidth", "()I", "getVideoHeight", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachLinkVideoData implements AttachPropertyData {
        public static final int $stable;
        @NotNull
        private final String originalUrl;
        private final int videoHeight;
        @NotNull
        private final String videoImagePath;
        @NotNull
        private final String videoTitle;
        private final int videoWidth;

        public AttachLinkVideoData(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, int v1) {
            q.g(s, "videoTitle");
            q.g(s1, "videoImagePath");
            q.g(s2, "originalUrl");
            super();
            this.videoTitle = s;
            this.videoImagePath = s1;
            this.originalUrl = s2;
            this.videoWidth = v;
            this.videoHeight = v1;
        }

        public AttachLinkVideoData(String s, String s1, String s2, int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 8) != 0) {
                v = 0;
            }
            this(s, s1, s2, v, ((v2 & 16) == 0 ? v1 : 0));
        }

        @NotNull
        public final String component1() {
            return this.videoTitle;
        }

        @NotNull
        public final String component2() {
            return this.videoImagePath;
        }

        @NotNull
        public final String component3() {
            return this.originalUrl;
        }

        public final int component4() {
            return this.videoWidth;
        }

        public final int component5() {
            return this.videoHeight;
        }

        @NotNull
        public final AttachLinkVideoData copy(@NotNull String s, @NotNull String s1, @NotNull String s2, int v, int v1) {
            q.g(s, "videoTitle");
            q.g(s1, "videoImagePath");
            q.g(s2, "originalUrl");
            return new AttachLinkVideoData(s, s1, s2, v, v1);
        }

        public static AttachLinkVideoData copy$default(AttachLinkVideoData mediaAttachHelper$AttachLinkVideoData0, String s, String s1, String s2, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                s = mediaAttachHelper$AttachLinkVideoData0.videoTitle;
            }
            if((v2 & 2) != 0) {
                s1 = mediaAttachHelper$AttachLinkVideoData0.videoImagePath;
            }
            if((v2 & 4) != 0) {
                s2 = mediaAttachHelper$AttachLinkVideoData0.originalUrl;
            }
            if((v2 & 8) != 0) {
                v = mediaAttachHelper$AttachLinkVideoData0.videoWidth;
            }
            if((v2 & 16) != 0) {
                v1 = mediaAttachHelper$AttachLinkVideoData0.videoHeight;
            }
            return mediaAttachHelper$AttachLinkVideoData0.copy(s, s1, s2, v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AttachLinkVideoData)) {
                return false;
            }
            if(!q.b(this.videoTitle, ((AttachLinkVideoData)object0).videoTitle)) {
                return false;
            }
            if(!q.b(this.videoImagePath, ((AttachLinkVideoData)object0).videoImagePath)) {
                return false;
            }
            if(!q.b(this.originalUrl, ((AttachLinkVideoData)object0).originalUrl)) {
                return false;
            }
            return this.videoWidth == ((AttachLinkVideoData)object0).videoWidth ? this.videoHeight == ((AttachLinkVideoData)object0).videoHeight : false;
        }

        @NotNull
        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        public final int getVideoHeight() {
            return this.videoHeight;
        }

        @NotNull
        public final String getVideoImagePath() {
            return this.videoImagePath;
        }

        @NotNull
        public final String getVideoTitle() {
            return this.videoTitle;
        }

        public final int getVideoWidth() {
            return this.videoWidth;
        }

        @Override
        public int hashCode() {
            return this.videoHeight + d.b(this.videoWidth, x.b(x.b(this.videoTitle.hashCode() * 0x1F, 0x1F, this.videoImagePath), 0x1F, this.originalUrl), 0x1F);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("AttachLinkVideoData(videoTitle=", this.videoTitle, ", videoImagePath=", this.videoImagePath, ", originalUrl=");
            d.t(stringBuilder0, this.originalUrl, ", videoWidth=", this.videoWidth, ", videoHeight=");
            return x.g(this.videoHeight, ")", stringBuilder0);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachMusicData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface AttachMusicData extends AttachPropertyData {
    }

    @Metadata(d1 = {"\u0000\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003À\u0006\u0003"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "Lba/s;", "Ljava/io/Serializable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface AttachPropertyData extends s, Serializable {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u001F\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0005\u0012\u0006\u0010\u000B\u001A\u00020\u0005\u0012\b\b\u0002\u0010\f\u001A\u00020\r\u0012\b\b\u0002\u0010\u000E\u001A\u00020\r\u0012\b\b\u0002\u0010\u000F\u001A\u00020\r\u0012\b\b\u0002\u0010\u0010\u001A\u00020\r\u00A2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u001E\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001F\u001A\u00020\u0005H\u00C6\u0003J\t\u0010 \u001A\u00020\u0003H\u00C6\u0003J\t\u0010!\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\"\u001A\u00020\u0005H\u00C6\u0003J\t\u0010#\u001A\u00020\u0003H\u00C6\u0003J\t\u0010$\u001A\u00020\u0005H\u00C6\u0003J\t\u0010%\u001A\u00020\u0005H\u00C6\u0003J\t\u0010&\u001A\u00020\rH\u00C6\u0003J\t\u0010\'\u001A\u00020\rH\u00C6\u0003J\t\u0010(\u001A\u00020\rH\u00C6\u0003J\t\u0010)\u001A\u00020\rH\u00C6\u0003J\u0081\u0001\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00052\b\b\u0002\u0010\u000B\u001A\u00020\u00052\b\b\u0002\u0010\f\u001A\u00020\r2\b\b\u0002\u0010\u000E\u001A\u00020\r2\b\b\u0002\u0010\u000F\u001A\u00020\r2\b\b\u0002\u0010\u0010\u001A\u00020\rH\u00C6\u0001J\u0013\u0010+\u001A\u00020\r2\b\u0010,\u001A\u0004\u0018\u00010-H\u00D6\u0003J\t\u0010.\u001A\u00020\u0003H\u00D6\u0001J\t\u0010/\u001A\u00020\u0005H\u00D6\u0001R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0014R\u0011\u0010\u0007\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0018\u0010\u0016R\u0011\u0010\b\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0016R\u0011\u0010\t\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0014R\u0011\u0010\n\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0016R\u0011\u0010\u000B\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0016R\u0011\u0010\f\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u001DR\u0011\u0010\u000E\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u001DR\u0011\u0010\u000F\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u001DR\u0011\u0010\u0010\u001A\u00020\r\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u001D\u00A8\u00060"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachSongData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachMusicData;", "songId", "", "songName", "", "albumId", "albumName", "albumImagePath", "artistId", "artistName", "displayIssueDate", "isAdult", "", "isHoldBack", "isFree", "isService", "<init>", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZZZZ)V", "getSongId", "()I", "getSongName", "()Ljava/lang/String;", "getAlbumId", "getAlbumName", "getAlbumImagePath", "getArtistId", "getArtistName", "getDisplayIssueDate", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachSongData implements AttachMusicData {
        public static final int $stable;
        private final int albumId;
        @NotNull
        private final String albumImagePath;
        @NotNull
        private final String albumName;
        private final int artistId;
        @NotNull
        private final String artistName;
        @NotNull
        private final String displayIssueDate;
        private final boolean isAdult;
        private final boolean isFree;
        private final boolean isHoldBack;
        private final boolean isService;
        private final int songId;
        @NotNull
        private final String songName;

        public AttachSongData(int v, @NotNull String s, int v1, @NotNull String s1, @NotNull String s2, int v2, @NotNull String s3, @NotNull String s4, boolean z, boolean z1, boolean z2, boolean z3) {
            q.g(s, "songName");
            q.g(s1, "albumName");
            q.g(s2, "albumImagePath");
            q.g(s3, "artistName");
            q.g(s4, "displayIssueDate");
            super();
            this.songId = v;
            this.songName = s;
            this.albumId = v1;
            this.albumName = s1;
            this.albumImagePath = s2;
            this.artistId = v2;
            this.artistName = s3;
            this.displayIssueDate = s4;
            this.isAdult = z;
            this.isHoldBack = z1;
            this.isFree = z2;
            this.isService = z3;
        }

        public AttachSongData(int v, String s, int v1, String s1, String s2, int v2, String s3, String s4, boolean z, boolean z1, boolean z2, boolean z3, int v3, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v3 & 1) != 0) {
                v = -1;
            }
            if((v3 & 4) != 0) {
                v1 = -1;
            }
            if((v3 & 0x20) != 0) {
                v2 = -1;
            }
            if((v3 & 0x100) != 0) {
                z = false;
            }
            if((v3 & 0x200) != 0) {
                z1 = false;
            }
            if((v3 & 0x400) != 0) {
                z2 = false;
            }
            this(v, s, v1, s1, s2, v2, s3, s4, z, z1, z2, ((v3 & 0x800) == 0 ? z3 : false));
        }

        public final int component1() {
            return this.songId;
        }

        public final boolean component10() {
            return this.isHoldBack;
        }

        public final boolean component11() {
            return this.isFree;
        }

        public final boolean component12() {
            return this.isService;
        }

        @NotNull
        public final String component2() {
            return this.songName;
        }

        public final int component3() {
            return this.albumId;
        }

        @NotNull
        public final String component4() {
            return this.albumName;
        }

        @NotNull
        public final String component5() {
            return this.albumImagePath;
        }

        public final int component6() {
            return this.artistId;
        }

        @NotNull
        public final String component7() {
            return this.artistName;
        }

        @NotNull
        public final String component8() {
            return this.displayIssueDate;
        }

        public final boolean component9() {
            return this.isAdult;
        }

        @NotNull
        public final AttachSongData copy(int v, @NotNull String s, int v1, @NotNull String s1, @NotNull String s2, int v2, @NotNull String s3, @NotNull String s4, boolean z, boolean z1, boolean z2, boolean z3) {
            q.g(s, "songName");
            q.g(s1, "albumName");
            q.g(s2, "albumImagePath");
            q.g(s3, "artistName");
            q.g(s4, "displayIssueDate");
            return new AttachSongData(v, s, v1, s1, s2, v2, s3, s4, z, z1, z2, z3);
        }

        public static AttachSongData copy$default(AttachSongData mediaAttachHelper$AttachSongData0, int v, String s, int v1, String s1, String s2, int v2, String s3, String s4, boolean z, boolean z1, boolean z2, boolean z3, int v3, Object object0) {
            if((v3 & 1) != 0) {
                v = mediaAttachHelper$AttachSongData0.songId;
            }
            if((v3 & 2) != 0) {
                s = mediaAttachHelper$AttachSongData0.songName;
            }
            if((v3 & 4) != 0) {
                v1 = mediaAttachHelper$AttachSongData0.albumId;
            }
            if((v3 & 8) != 0) {
                s1 = mediaAttachHelper$AttachSongData0.albumName;
            }
            if((v3 & 16) != 0) {
                s2 = mediaAttachHelper$AttachSongData0.albumImagePath;
            }
            if((v3 & 0x20) != 0) {
                v2 = mediaAttachHelper$AttachSongData0.artistId;
            }
            if((v3 & 0x40) != 0) {
                s3 = mediaAttachHelper$AttachSongData0.artistName;
            }
            if((v3 & 0x80) != 0) {
                s4 = mediaAttachHelper$AttachSongData0.displayIssueDate;
            }
            if((v3 & 0x100) != 0) {
                z = mediaAttachHelper$AttachSongData0.isAdult;
            }
            if((v3 & 0x200) != 0) {
                z1 = mediaAttachHelper$AttachSongData0.isHoldBack;
            }
            if((v3 & 0x400) != 0) {
                z2 = mediaAttachHelper$AttachSongData0.isFree;
            }
            if((v3 & 0x800) != 0) {
                z3 = mediaAttachHelper$AttachSongData0.isService;
            }
            return mediaAttachHelper$AttachSongData0.copy(v, s, v1, s1, s2, v2, s3, s4, z, z1, z2, z3);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AttachSongData)) {
                return false;
            }
            if(this.songId != ((AttachSongData)object0).songId) {
                return false;
            }
            if(!q.b(this.songName, ((AttachSongData)object0).songName)) {
                return false;
            }
            if(this.albumId != ((AttachSongData)object0).albumId) {
                return false;
            }
            if(!q.b(this.albumName, ((AttachSongData)object0).albumName)) {
                return false;
            }
            if(!q.b(this.albumImagePath, ((AttachSongData)object0).albumImagePath)) {
                return false;
            }
            if(this.artistId != ((AttachSongData)object0).artistId) {
                return false;
            }
            if(!q.b(this.artistName, ((AttachSongData)object0).artistName)) {
                return false;
            }
            if(!q.b(this.displayIssueDate, ((AttachSongData)object0).displayIssueDate)) {
                return false;
            }
            if(this.isAdult != ((AttachSongData)object0).isAdult) {
                return false;
            }
            if(this.isHoldBack != ((AttachSongData)object0).isHoldBack) {
                return false;
            }
            return this.isFree == ((AttachSongData)object0).isFree ? this.isService == ((AttachSongData)object0).isService : false;
        }

        public final int getAlbumId() {
            return this.albumId;
        }

        @NotNull
        public final String getAlbumImagePath() {
            return this.albumImagePath;
        }

        @NotNull
        public final String getAlbumName() {
            return this.albumName;
        }

        public final int getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @NotNull
        public final String getDisplayIssueDate() {
            return this.displayIssueDate;
        }

        public final int getSongId() {
            return this.songId;
        }

        @NotNull
        public final String getSongName() {
            return this.songName;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isService) + d.e(d.e(d.e(x.b(x.b(d.b(this.artistId, x.b(x.b(d.b(this.albumId, x.b(this.songId * 0x1F, 0x1F, this.songName), 0x1F), 0x1F, this.albumName), 0x1F, this.albumImagePath), 0x1F), 0x1F, this.artistName), 0x1F, this.displayIssueDate), 0x1F, this.isAdult), 0x1F, this.isHoldBack), 0x1F, this.isFree);
        }

        public final boolean isAdult() {
            return this.isAdult;
        }

        public final boolean isFree() {
            return this.isFree;
        }

        public final boolean isHoldBack() {
            return this.isHoldBack;
        }

        public final boolean isService() {
            return this.isService;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = x.o(this.songId, "AttachSongData(songId=", ", songName=", this.songName, ", albumId=");
            stringBuilder0.append(this.albumId);
            stringBuilder0.append(", albumName=");
            stringBuilder0.append(this.albumName);
            stringBuilder0.append(", albumImagePath=");
            d.t(stringBuilder0, this.albumImagePath, ", artistId=", this.artistId, ", artistName=");
            d.u(stringBuilder0, this.artistName, ", displayIssueDate=", this.displayIssueDate, ", isAdult=");
            x.y(stringBuilder0, this.isAdult, ", isHoldBack=", this.isHoldBack, ", isFree=");
            stringBuilder0.append(this.isFree);
            stringBuilder0.append(", isService=");
            stringBuilder0.append(this.isService);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachType;", "", "<init>", "()V", "TEXT", "", "IMAGE", "MUSIC_SONG", "MUSIC_ALBUM", "MUSIC_ARTIST", "VIDEO", "LINK_VIDEO", "LINK_GENRL", "KAKAO_EMOTICON", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachType {
        public static final int $stable = 0;
        @NotNull
        public static final String IMAGE = "image";
        @NotNull
        public static final AttachType INSTANCE = null;
        @NotNull
        public static final String KAKAO_EMOTICON = "kakao_emoticon";
        @NotNull
        public static final String LINK_GENRL = "link_genrl";
        @NotNull
        public static final String LINK_VIDEO = "link_video";
        @NotNull
        public static final String MUSIC_ALBUM = "music_album";
        @NotNull
        public static final String MUSIC_ARTIST = "music_artist";
        @NotNull
        public static final String MUSIC_SONG = "music_song";
        @NotNull
        public static final String TEXT = "text";
        @NotNull
        public static final String VIDEO = "video";

        static {
            AttachType.INSTANCE = new AttachType();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\u0007\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0005\u0012\b\b\u0002\u0010\t\u001A\u00020\u0003\u0012\b\b\u0002\u0010\n\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0005\u0012\b\b\u0002\u0010\r\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u000E\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u000F\u0012\b\b\u0002\u0010\u0011\u001A\u00020\u000F\u0012\u0006\u0010\u0012\u001A\u00020\u0005\u00A2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010#\u001A\u00020\u0003H\u00C6\u0003J\t\u0010$\u001A\u00020\u0005H\u00C6\u0003J\t\u0010%\u001A\u00020\u0005H\u00C6\u0003J\t\u0010&\u001A\u00020\u0005H\u00C6\u0003J\t\u0010\'\u001A\u00020\u0005H\u00C6\u0003J\t\u0010(\u001A\u00020\u0003H\u00C6\u0003J\t\u0010)\u001A\u00020\u0003H\u00C6\u0003J\t\u0010*\u001A\u00020\u0003H\u00C6\u0003J\t\u0010+\u001A\u00020\u0005H\u00C6\u0003J\t\u0010,\u001A\u00020\u0003H\u00C6\u0003J\t\u0010-\u001A\u00020\u000FH\u00C6\u0003J\t\u0010.\u001A\u00020\u000FH\u00C6\u0003J\t\u0010/\u001A\u00020\u000FH\u00C6\u0003J\t\u00100\u001A\u00020\u0005H\u00C6\u0003J\u0095\u0001\u00101\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\b\b\u0002\u0010\b\u001A\u00020\u00052\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00052\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u000F2\b\b\u0002\u0010\u0011\u001A\u00020\u000F2\b\b\u0002\u0010\u0012\u001A\u00020\u0005H\u00C6\u0001J\u0013\u00102\u001A\u00020\u000F2\b\u00103\u001A\u0004\u0018\u000104H\u00D6\u0003J\t\u00105\u001A\u00020\u0003H\u00D6\u0001J\t\u00106\u001A\u00020\u0005H\u00D6\u0001R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001A\u0010\u0018R\u0011\u0010\b\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001B\u0010\u0018R\u0011\u0010\t\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u0016R\u0011\u0010\n\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001D\u0010\u0016R\u0011\u0010\u000B\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u0016R\u0011\u0010\f\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001F\u0010\u0018R\u0011\u0010\r\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b \u0010\u0016R\u0011\u0010\u000E\u001A\u00020\u000F\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010!R\u0011\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010!R\u0011\u0010\u0011\u001A\u00020\u000F\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010!R\u0011\u0010\u0012\u001A\u00020\u0005\u00A2\u0006\b\n\u0000\u001A\u0004\b\"\u0010\u0018\u00A8\u00067"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$AttachVideoData;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "videoId", "", "videoTitle", "", "videoImagePath", "displayIssueDate", "playTime", "songId", "albumId", "artistId", "artistName", "viewCount", "isAdult", "", "isHoldBack", "isFree", "age", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;IZZZLjava/lang/String;)V", "getVideoId", "()I", "getVideoTitle", "()Ljava/lang/String;", "getVideoImagePath", "getDisplayIssueDate", "getPlayTime", "getSongId", "getAlbumId", "getArtistId", "getArtistName", "getViewCount", "()Z", "getAge", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AttachVideoData implements AttachPropertyData {
        public static final int $stable;
        @NotNull
        private final String age;
        private final int albumId;
        private final int artistId;
        @NotNull
        private final String artistName;
        @NotNull
        private final String displayIssueDate;
        private final boolean isAdult;
        private final boolean isFree;
        private final boolean isHoldBack;
        @NotNull
        private final String playTime;
        private final int songId;
        private final int videoId;
        @NotNull
        private final String videoImagePath;
        @NotNull
        private final String videoTitle;
        private final int viewCount;

        public AttachVideoData(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, int v1, int v2, int v3, @NotNull String s4, int v4, boolean z, boolean z1, boolean z2, @NotNull String s5) {
            q.g(s, "videoTitle");
            q.g(s1, "videoImagePath");
            q.g(s2, "displayIssueDate");
            q.g(s3, "playTime");
            q.g(s4, "artistName");
            q.g(s5, "age");
            super();
            this.videoId = v;
            this.videoTitle = s;
            this.videoImagePath = s1;
            this.displayIssueDate = s2;
            this.playTime = s3;
            this.songId = v1;
            this.albumId = v2;
            this.artistId = v3;
            this.artistName = s4;
            this.viewCount = v4;
            this.isAdult = z;
            this.isHoldBack = z1;
            this.isFree = z2;
            this.age = s5;
        }

        public AttachVideoData(int v, String s, String s1, String s2, String s3, int v1, int v2, int v3, String s4, int v4, boolean z, boolean z1, boolean z2, String s5, int v5, DefaultConstructorMarker defaultConstructorMarker0) {
            this(((v5 & 1) == 0 ? v : -1), s, s1, s2, s3, ((v5 & 0x20) == 0 ? v1 : -1), ((v5 & 0x40) == 0 ? v2 : -1), ((v5 & 0x80) == 0 ? v3 : -1), s4, ((v5 & 0x200) == 0 ? v4 : -1), ((v5 & 0x400) == 0 ? z : false), ((v5 & 0x800) == 0 ? z1 : false), ((v5 & 0x1000) == 0 ? z2 : false), s5);
        }

        public final int component1() {
            return this.videoId;
        }

        public final int component10() {
            return this.viewCount;
        }

        public final boolean component11() {
            return this.isAdult;
        }

        public final boolean component12() {
            return this.isHoldBack;
        }

        public final boolean component13() {
            return this.isFree;
        }

        @NotNull
        public final String component14() {
            return this.age;
        }

        @NotNull
        public final String component2() {
            return this.videoTitle;
        }

        @NotNull
        public final String component3() {
            return this.videoImagePath;
        }

        @NotNull
        public final String component4() {
            return this.displayIssueDate;
        }

        @NotNull
        public final String component5() {
            return this.playTime;
        }

        public final int component6() {
            return this.songId;
        }

        public final int component7() {
            return this.albumId;
        }

        public final int component8() {
            return this.artistId;
        }

        @NotNull
        public final String component9() {
            return this.artistName;
        }

        @NotNull
        public final AttachVideoData copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, int v1, int v2, int v3, @NotNull String s4, int v4, boolean z, boolean z1, boolean z2, @NotNull String s5) {
            q.g(s, "videoTitle");
            q.g(s1, "videoImagePath");
            q.g(s2, "displayIssueDate");
            q.g(s3, "playTime");
            q.g(s4, "artistName");
            q.g(s5, "age");
            return new AttachVideoData(v, s, s1, s2, s3, v1, v2, v3, s4, v4, z, z1, z2, s5);
        }

        public static AttachVideoData copy$default(AttachVideoData mediaAttachHelper$AttachVideoData0, int v, String s, String s1, String s2, String s3, int v1, int v2, int v3, String s4, int v4, boolean z, boolean z1, boolean z2, String s5, int v5, Object object0) {
            int v6 = (v5 & 1) == 0 ? v : mediaAttachHelper$AttachVideoData0.videoId;
            String s6 = (v5 & 2) == 0 ? s : mediaAttachHelper$AttachVideoData0.videoTitle;
            String s7 = (v5 & 4) == 0 ? s1 : mediaAttachHelper$AttachVideoData0.videoImagePath;
            String s8 = (v5 & 8) == 0 ? s2 : mediaAttachHelper$AttachVideoData0.displayIssueDate;
            String s9 = (v5 & 16) == 0 ? s3 : mediaAttachHelper$AttachVideoData0.playTime;
            int v7 = (v5 & 0x20) == 0 ? v1 : mediaAttachHelper$AttachVideoData0.songId;
            int v8 = (v5 & 0x40) == 0 ? v2 : mediaAttachHelper$AttachVideoData0.albumId;
            int v9 = (v5 & 0x80) == 0 ? v3 : mediaAttachHelper$AttachVideoData0.artistId;
            String s10 = (v5 & 0x100) == 0 ? s4 : mediaAttachHelper$AttachVideoData0.artistName;
            int v10 = (v5 & 0x200) == 0 ? v4 : mediaAttachHelper$AttachVideoData0.viewCount;
            boolean z3 = (v5 & 0x400) == 0 ? z : mediaAttachHelper$AttachVideoData0.isAdult;
            boolean z4 = (v5 & 0x800) == 0 ? z1 : mediaAttachHelper$AttachVideoData0.isHoldBack;
            boolean z5 = (v5 & 0x1000) == 0 ? z2 : mediaAttachHelper$AttachVideoData0.isFree;
            return (v5 & 0x2000) == 0 ? mediaAttachHelper$AttachVideoData0.copy(v6, s6, s7, s8, s9, v7, v8, v9, s10, v10, z3, z4, z5, s5) : mediaAttachHelper$AttachVideoData0.copy(v6, s6, s7, s8, s9, v7, v8, v9, s10, v10, z3, z4, z5, mediaAttachHelper$AttachVideoData0.age);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AttachVideoData)) {
                return false;
            }
            if(this.videoId != ((AttachVideoData)object0).videoId) {
                return false;
            }
            if(!q.b(this.videoTitle, ((AttachVideoData)object0).videoTitle)) {
                return false;
            }
            if(!q.b(this.videoImagePath, ((AttachVideoData)object0).videoImagePath)) {
                return false;
            }
            if(!q.b(this.displayIssueDate, ((AttachVideoData)object0).displayIssueDate)) {
                return false;
            }
            if(!q.b(this.playTime, ((AttachVideoData)object0).playTime)) {
                return false;
            }
            if(this.songId != ((AttachVideoData)object0).songId) {
                return false;
            }
            if(this.albumId != ((AttachVideoData)object0).albumId) {
                return false;
            }
            if(this.artistId != ((AttachVideoData)object0).artistId) {
                return false;
            }
            if(!q.b(this.artistName, ((AttachVideoData)object0).artistName)) {
                return false;
            }
            if(this.viewCount != ((AttachVideoData)object0).viewCount) {
                return false;
            }
            if(this.isAdult != ((AttachVideoData)object0).isAdult) {
                return false;
            }
            if(this.isHoldBack != ((AttachVideoData)object0).isHoldBack) {
                return false;
            }
            return this.isFree == ((AttachVideoData)object0).isFree ? q.b(this.age, ((AttachVideoData)object0).age) : false;
        }

        @NotNull
        public final String getAge() {
            return this.age;
        }

        public final int getAlbumId() {
            return this.albumId;
        }

        public final int getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @NotNull
        public final String getDisplayIssueDate() {
            return this.displayIssueDate;
        }

        @NotNull
        public final String getPlayTime() {
            return this.playTime;
        }

        public final int getSongId() {
            return this.songId;
        }

        public final int getVideoId() {
            return this.videoId;
        }

        @NotNull
        public final String getVideoImagePath() {
            return this.videoImagePath;
        }

        @NotNull
        public final String getVideoTitle() {
            return this.videoTitle;
        }

        public final int getViewCount() {
            return this.viewCount;
        }

        @Override
        public int hashCode() {
            return this.age.hashCode() + d.e(d.e(d.e(d.b(this.viewCount, x.b(d.b(this.artistId, d.b(this.albumId, d.b(this.songId, x.b(x.b(x.b(x.b(this.videoId * 0x1F, 0x1F, this.videoTitle), 0x1F, this.videoImagePath), 0x1F, this.displayIssueDate), 0x1F, this.playTime), 0x1F), 0x1F), 0x1F), 0x1F, this.artistName), 0x1F), 0x1F, this.isAdult), 0x1F, this.isHoldBack), 0x1F, this.isFree);
        }

        public final boolean isAdult() {
            return this.isAdult;
        }

        public final boolean isFree() {
            return this.isFree;
        }

        public final boolean isHoldBack() {
            return this.isHoldBack;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = x.o(this.videoId, "AttachVideoData(videoId=", ", videoTitle=", this.videoTitle, ", videoImagePath=");
            d.u(stringBuilder0, this.videoImagePath, ", displayIssueDate=", this.displayIssueDate, ", playTime=");
            d.t(stringBuilder0, this.playTime, ", songId=", this.songId, ", albumId=");
            x.x(stringBuilder0, this.albumId, ", artistId=", this.artistId, ", artistName=");
            d.t(stringBuilder0, this.artistName, ", viewCount=", this.viewCount, ", isAdult=");
            x.y(stringBuilder0, this.isAdult, ", isHoldBack=", this.isHoldBack, ", isFree=");
            stringBuilder0.append(this.isFree);
            stringBuilder0.append(", age=");
            stringBuilder0.append(this.age);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001A\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000E\u001A\u00020\u000FHÖ\u0001J\t\u0010\u0010\u001A\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/melon/net/res/v3/MediaAttachHelper$None;", "Lcom/melon/net/res/v3/MediaAttachHelper$AttachPropertyData;", "dump", "", "<init>", "(Ljava/lang/String;)V", "getDump", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class None implements AttachPropertyData {
        public static final int $stable;
        @NotNull
        private final String dump;

        public None() {
            this(null, 1, null);
        }

        public None(@NotNull String s) {
            q.g(s, "dump");
            super();
            this.dump = s;
        }

        public None(String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            this(s);
        }

        @NotNull
        public final String component1() {
            return this.dump;
        }

        @NotNull
        public final None copy(@NotNull String s) {
            q.g(s, "dump");
            return new None(s);
        }

        public static None copy$default(None mediaAttachHelper$None0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = mediaAttachHelper$None0.dump;
            }
            return mediaAttachHelper$None0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof None ? q.b(this.dump, ((None)object0).dump) : false;
        }

        @NotNull
        public final String getDump() {
            return this.dump;
        }

        @Override
        public int hashCode() {
            return this.dump.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "None(dump=" + this.dump + ")";
        }
    }

    public static final int $stable;
    @NotNull
    public static final MediaAttachHelper INSTANCE;

    static {
        MediaAttachHelper.INSTANCE = new MediaAttachHelper();
    }

    @Nullable
    public final AttachPropertyData getAttachPropertyData(@NotNull String s, @Nullable AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        q.g(s, "attachType");
        switch(s) {
            case "image": {
                return this.toImageData(commentApiModel$AttachPropertyBase0);
            }
            case "kakao_emoticon": {
                return this.toKakaoEmoticonData(commentApiModel$AttachPropertyBase0);
            }
            case "link_genrl": {
                return this.toLinkGenrlData(commentApiModel$AttachPropertyBase0);
            }
            case "link_video": {
                return this.toLinkVideoData(commentApiModel$AttachPropertyBase0);
            }
            case "music_album": {
                return this.toAlbumData(commentApiModel$AttachPropertyBase0);
            }
            case "music_artist": {
                return this.toArtistData(commentApiModel$AttachPropertyBase0);
            }
            case "music_song": {
                return this.toSongData(commentApiModel$AttachPropertyBase0);
            }
            case "video": {
                return this.toVideoData(commentApiModel$AttachPropertyBase0);
            }
            default: {
                return null;
            }
        }
    }

    @Nullable
    public final String getMvAgeLevelIcon(int v) {
        switch(v) {
            case 0: {
                return "ALL";
            }
            case 1: {
                return "19";
            }
            case 2: {
                return "15";
            }
            case 3: {
                return "12";
            }
            default: {
                return null;
            }
        }
    }

    private final AttachAlbumData toAlbumData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = ProtocolUtils.getArtistNames(commentApiModel$AttachPropertyBase0.getArtistList());
        if(s == null) {
            s = "";
        }
        if(s.length() == 0) {
            s = commentApiModel$AttachPropertyBase0.getArtistName();
            if(s == null) {
                s = "";
            }
        }
        int v = commentApiModel$AttachPropertyBase0.getAlbumId();
        String s1 = commentApiModel$AttachPropertyBase0.getAlbumName();
        String s2 = s1 == null ? "" : s1;
        String s3 = commentApiModel$AttachPropertyBase0.getAlbumImagePath();
        String s4 = s3 == null ? "" : s3;
        int v1 = commentApiModel$AttachPropertyBase0.getArtistId();
        String s5 = commentApiModel$AttachPropertyBase0.getDsplyIssueDate();
        return s5 == null ? new AttachAlbumData(v, s2, s4, v1, s, "", commentApiModel$AttachPropertyBase0.getServiceFlag()) : new AttachAlbumData(v, s2, s4, v1, s, s5, commentApiModel$AttachPropertyBase0.getServiceFlag());
    }

    private final AttachArtistData toArtistData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = ProtocolUtils.getArtistNames(commentApiModel$AttachPropertyBase0.getArtistList());
        if(s == null) {
            s = "";
        }
        if(s.length() == 0) {
            s = commentApiModel$AttachPropertyBase0.getArtistName();
            if(s == null) {
                s = "";
            }
        }
        int v = commentApiModel$AttachPropertyBase0.getArtistId();
        String s1 = commentApiModel$AttachPropertyBase0.getArtistImagePath();
        String s2 = s1 == null ? "" : s1;
        String s3 = commentApiModel$AttachPropertyBase0.getArtistType();
        String s4 = s3 == null ? "" : s3;
        String s5 = commentApiModel$AttachPropertyBase0.getNationalityName();
        String s6 = s5 == null ? "" : s5;
        String s7 = commentApiModel$AttachPropertyBase0.getActTypeName();
        String s8 = s7 == null ? "" : s7;
        String s9 = commentApiModel$AttachPropertyBase0.getSex();
        String s10 = s9 == null ? "" : s9;
        String s11 = commentApiModel$AttachPropertyBase0.getGnr();
        return s11 == null ? new AttachArtistData(v, s, s2, s4, s6, s8, s10, "", commentApiModel$AttachPropertyBase0.getFanCnt()) : new AttachArtistData(v, s, s2, s4, s6, s8, s10, s11, commentApiModel$AttachPropertyBase0.getFanCnt());
    }

    private final AttachImageData toImageData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = commentApiModel$AttachPropertyBase0.getThumbUrl();
        String s1 = "";
        if(s == null) {
            s = "";
        }
        String s2 = commentApiModel$AttachPropertyBase0.getOriginalUrl();
        if(s2 != null) {
            s1 = s2;
        }
        return new AttachImageData(s, s1);
    }

    private final AttachKakaoEmoticonData toKakaoEmoticonData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        String s = null;
        if(commentApiModel$AttachPropertyBase0 != null) {
            String s1 = commentApiModel$AttachPropertyBase0.getKakaoEmoticon();
            if(s1 != null && s1.length() != 0) {
                String s2 = commentApiModel$AttachPropertyBase0.getKakaoEmoticon();
                if(s2 != null) {
                    s = v.p0(s2, "&quot;", "\"");
                }
                if(s == null) {
                    s = "";
                }
                return new AttachKakaoEmoticonData(s);
            }
        }
        return null;
    }

    private final AttachLinkGenrlData toLinkGenrlData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = commentApiModel$AttachPropertyBase0.getLinkUrl();
        if(s == null) {
            s = "";
        }
        return new AttachLinkGenrlData(s);
    }

    private final AttachLinkVideoData toLinkVideoData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = commentApiModel$AttachPropertyBase0.getVideoTitle();
        String s1 = "";
        if(s == null) {
            s = "";
        }
        String s2 = commentApiModel$AttachPropertyBase0.getThumbUrl() == null ? "" : commentApiModel$AttachPropertyBase0.getThumbUrl();
        String s3 = commentApiModel$AttachPropertyBase0.getVideoUrl();
        if(s3 != null) {
            s1 = s3;
        }
        return new AttachLinkVideoData(s, s2, s1, commentApiModel$AttachPropertyBase0.getVideoWidth(), commentApiModel$AttachPropertyBase0.getVideoHeight());
    }

    private final AttachSongData toSongData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = ProtocolUtils.getArtistNames(commentApiModel$AttachPropertyBase0.getArtistList());
        if(s == null || s.length() == 0) {
            s = commentApiModel$AttachPropertyBase0.getArtistName();
            if(s == null) {
                s = "";
            }
        }
        int v = commentApiModel$AttachPropertyBase0.getSongId();
        String s1 = commentApiModel$AttachPropertyBase0.getSongName();
        String s2 = s1 == null ? "" : s1;
        int v1 = commentApiModel$AttachPropertyBase0.getAlbumId();
        String s3 = commentApiModel$AttachPropertyBase0.getAlbumName();
        String s4 = s3 == null ? "" : s3;
        String s5 = commentApiModel$AttachPropertyBase0.getAlbumImagePath();
        String s6 = s5 == null ? "" : s5;
        int v2 = commentApiModel$AttachPropertyBase0.getArtistId();
        String s7 = commentApiModel$AttachPropertyBase0.getDsplyIssueDate();
        return s7 == null ? new AttachSongData(v, s2, v1, s4, s6, v2, s, "", commentApiModel$AttachPropertyBase0.getAdultFlag(), commentApiModel$AttachPropertyBase0.getHoldBackFlag(), commentApiModel$AttachPropertyBase0.getFreezoneFlag(), commentApiModel$AttachPropertyBase0.getServiceFlag()) : new AttachSongData(v, s2, v1, s4, s6, v2, s, s7, commentApiModel$AttachPropertyBase0.getAdultFlag(), commentApiModel$AttachPropertyBase0.getHoldBackFlag(), commentApiModel$AttachPropertyBase0.getFreezoneFlag(), commentApiModel$AttachPropertyBase0.getServiceFlag());
    }

    private final AttachVideoData toVideoData(AttachPropertyBase commentApiModel$AttachPropertyBase0) {
        if(commentApiModel$AttachPropertyBase0 == null) {
            return null;
        }
        q.d(commentApiModel$AttachPropertyBase0);
        String s = ProtocolUtils.getArtistNames(commentApiModel$AttachPropertyBase0.getArtistList());
        if(s == null) {
            s = "";
        }
        if(s.length() == 0) {
            s = commentApiModel$AttachPropertyBase0.getArtistName();
            if(s == null) {
                s = "";
            }
        }
        int v = commentApiModel$AttachPropertyBase0.getVideoId();
        String s1 = AttachPropertyBase.Companion.getMvTitle(commentApiModel$AttachPropertyBase0);
        String s2 = s1 == null ? "" : s1;
        String s3 = commentApiModel$AttachPropertyBase0.getVideoImagePath();
        String s4 = s3 == null ? "" : s3;
        String s5 = commentApiModel$AttachPropertyBase0.getDsplyVideoIssueDate();
        String s6 = s5 == null ? "" : s5;
        String s7 = commentApiModel$AttachPropertyBase0.getDsplyPlayTime();
        String s8 = s7 == null ? "" : s7;
        int v1 = commentApiModel$AttachPropertyBase0.getSongId();
        int v2 = commentApiModel$AttachPropertyBase0.getAlbumId();
        int v3 = commentApiModel$AttachPropertyBase0.getArtistId();
        int v4 = commentApiModel$AttachPropertyBase0.getVideoViewCnt();
        boolean z = commentApiModel$AttachPropertyBase0.getVideoAdultFlag();
        boolean z1 = commentApiModel$AttachPropertyBase0.getHoldBackFlag();
        boolean z2 = commentApiModel$AttachPropertyBase0.getFreezoneFlag();
        String s9 = this.getMvAgeLevelIcon(commentApiModel$AttachPropertyBase0.getVideoAgeLevel());
        return s9 == null ? new AttachVideoData(v, s2, s4, s6, s8, v1, v2, v3, s, v4, z, z1, z2, "") : new AttachVideoData(v, s2, s4, s6, s8, v1, v2, v3, s, v4, z, z1, z2, s9);
    }
}

