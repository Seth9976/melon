package com.melon.net.res;

import A7.d;
import S7.b;
import U4.x;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/melon/net/res/VoiceAlarm;", "", "<init>", "()V", "TrackDto", "AlbumDto", "Track", "Album", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VoiceAlarm {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u001F\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u0019\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001A\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001B\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001C\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001D\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001E\u001A\u00020\u0003H\u00C6\u0003J\t\u0010\u001F\u001A\u00020\u0003H\u00C6\u0003J\t\u0010 \u001A\u00020\u0003H\u00C6\u0003Jc\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u0003H\u00C6\u0001J\u0013\u0010\"\u001A\u00020#2\b\u0010$\u001A\u0004\u0018\u00010%H\u00D6\u0003J\t\u0010&\u001A\u00020\'H\u00D6\u0001J\t\u0010(\u001A\u00020\u0003H\u00D6\u0001R\u0011\u0010\u0002\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0011\u0010\u0005\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0011\u0010\u0006\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0011\u0010\u0007\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0011\u0010\b\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000FR\u0011\u0010\t\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000FR\u0011\u0010\n\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000FR\u0011\u0010\u000B\u001A\u00020\u0003\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000F\u00A8\u0006)"}, d2 = {"Lcom/melon/net/res/VoiceAlarm$Album;", "Lcom/melon/net/res/Domain;", "albumId", "", "albumName", "artistId", "artistName", "albumImage", "startDate", "endDate", "statusCode", "statusMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "getAlbumName", "getArtistId", "getArtistName", "getAlbumImage", "getStartDate", "getEndDate", "getStatusCode", "getStatusMessage", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Album implements Domain {
        public static final int $stable;
        @NotNull
        private final String albumId;
        @NotNull
        private final String albumImage;
        @NotNull
        private final String albumName;
        @NotNull
        private final String artistId;
        @NotNull
        private final String artistName;
        @NotNull
        private final String endDate;
        @NotNull
        private final String startDate;
        @NotNull
        private final String statusCode;
        @NotNull
        private final String statusMessage;

        public Album(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8) {
            q.g(s, "albumId");
            q.g(s1, "albumName");
            q.g(s2, "artistId");
            q.g(s3, "artistName");
            q.g(s4, "albumImage");
            q.g(s5, "startDate");
            q.g(s6, "endDate");
            q.g(s7, "statusCode");
            q.g(s8, "statusMessage");
            super();
            this.albumId = s;
            this.albumName = s1;
            this.artistId = s2;
            this.artistName = s3;
            this.albumImage = s4;
            this.startDate = s5;
            this.endDate = s6;
            this.statusCode = s7;
            this.statusMessage = s8;
        }

        @NotNull
        public final String component1() {
            return this.albumId;
        }

        @NotNull
        public final String component2() {
            return this.albumName;
        }

        @NotNull
        public final String component3() {
            return this.artistId;
        }

        @NotNull
        public final String component4() {
            return this.artistName;
        }

        @NotNull
        public final String component5() {
            return this.albumImage;
        }

        @NotNull
        public final String component6() {
            return this.startDate;
        }

        @NotNull
        public final String component7() {
            return this.endDate;
        }

        @NotNull
        public final String component8() {
            return this.statusCode;
        }

        @NotNull
        public final String component9() {
            return this.statusMessage;
        }

        @NotNull
        public final Album copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8) {
            q.g(s, "albumId");
            q.g(s1, "albumName");
            q.g(s2, "artistId");
            q.g(s3, "artistName");
            q.g(s4, "albumImage");
            q.g(s5, "startDate");
            q.g(s6, "endDate");
            q.g(s7, "statusCode");
            q.g(s8, "statusMessage");
            return new Album(s, s1, s2, s3, s4, s5, s6, s7, s8);
        }

        public static Album copy$default(Album voiceAlarm$Album0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, int v, Object object0) {
            if((v & 1) != 0) {
                s = voiceAlarm$Album0.albumId;
            }
            if((v & 2) != 0) {
                s1 = voiceAlarm$Album0.albumName;
            }
            if((v & 4) != 0) {
                s2 = voiceAlarm$Album0.artistId;
            }
            if((v & 8) != 0) {
                s3 = voiceAlarm$Album0.artistName;
            }
            if((v & 16) != 0) {
                s4 = voiceAlarm$Album0.albumImage;
            }
            if((v & 0x20) != 0) {
                s5 = voiceAlarm$Album0.startDate;
            }
            if((v & 0x40) != 0) {
                s6 = voiceAlarm$Album0.endDate;
            }
            if((v & 0x80) != 0) {
                s7 = voiceAlarm$Album0.statusCode;
            }
            if((v & 0x100) != 0) {
                s8 = voiceAlarm$Album0.statusMessage;
            }
            return voiceAlarm$Album0.copy(s, s1, s2, s3, s4, s5, s6, s7, s8);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Album)) {
                return false;
            }
            if(!q.b(this.albumId, ((Album)object0).albumId)) {
                return false;
            }
            if(!q.b(this.albumName, ((Album)object0).albumName)) {
                return false;
            }
            if(!q.b(this.artistId, ((Album)object0).artistId)) {
                return false;
            }
            if(!q.b(this.artistName, ((Album)object0).artistName)) {
                return false;
            }
            if(!q.b(this.albumImage, ((Album)object0).albumImage)) {
                return false;
            }
            if(!q.b(this.startDate, ((Album)object0).startDate)) {
                return false;
            }
            if(!q.b(this.endDate, ((Album)object0).endDate)) {
                return false;
            }
            return q.b(this.statusCode, ((Album)object0).statusCode) ? q.b(this.statusMessage, ((Album)object0).statusMessage) : false;
        }

        @NotNull
        public final String getAlbumId() {
            return this.albumId;
        }

        @NotNull
        public final String getAlbumImage() {
            return this.albumImage;
        }

        @NotNull
        public final String getAlbumName() {
            return this.albumName;
        }

        @NotNull
        public final String getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @NotNull
        public final String getEndDate() {
            return this.endDate;
        }

        @NotNull
        public final String getStartDate() {
            return this.startDate;
        }

        @NotNull
        public final String getStatusCode() {
            return this.statusCode;
        }

        @NotNull
        public final String getStatusMessage() {
            return this.statusMessage;
        }

        @Override
        public int hashCode() {
            return this.statusMessage.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.albumId.hashCode() * 0x1F, 0x1F, this.albumName), 0x1F, this.artistId), 0x1F, this.artistName), 0x1F, this.albumImage), 0x1F, this.startDate), 0x1F, this.endDate), 0x1F, this.statusCode);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Album(albumId=", this.albumId, ", albumName=", this.albumName, ", artistId=");
            d.u(stringBuilder0, this.artistId, ", artistName=", this.artistName, ", albumImage=");
            d.u(stringBuilder0, this.albumImage, ", startDate=", this.startDate, ", endDate=");
            d.u(stringBuilder0, this.endDate, ", statusCode=", this.statusCode, ", statusMessage=");
            return x.m(stringBuilder0, this.statusMessage, ")");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0018\u001A\u00020\u0019H\u0016J\u000B\u0010\u001A\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001B\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001C\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001D\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001E\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\u001F\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010 \u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010!\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010\"\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003Ju\u0010#\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010$\u001A\u00020%2\b\u0010&\u001A\u0004\u0018\u00010\'H\u00D6\u0003J\t\u0010(\u001A\u00020)H\u00D6\u0001J\t\u0010*\u001A\u00020\u0003H\u00D6\u0001R\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000FR\u0018\u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u000FR\u0018\u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u000FR\u0018\u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u000FR\u0018\u0010\b\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0014\u0010\u000FR\u0018\u0010\t\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0015\u0010\u000FR\u0018\u0010\n\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0016\u0010\u000FR\u0018\u0010\u000B\u001A\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u0017\u0010\u000F\u00A8\u0006+"}, d2 = {"Lcom/melon/net/res/VoiceAlarm$AlbumDto;", "Lcom/melon/net/res/Dto;", "albumId", "", "albumName", "artistId", "artistName", "albumImage", "startDate", "endDate", "statusCode", "statusMessage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "getAlbumName", "getArtistId", "getArtistName", "getAlbumImage", "getStartDate", "getEndDate", "getStatusCode", "getStatusMessage", "asDomain", "Lcom/melon/net/res/VoiceAlarm$Album;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AlbumDto implements Dto {
        public static final int $stable;
        @b("ALBUMID")
        @Nullable
        private final String albumId;
        @b("ALBUMIMAGE")
        @Nullable
        private final String albumImage;
        @b("ALBUMNAME")
        @Nullable
        private final String albumName;
        @b("ARTISTID")
        @Nullable
        private final String artistId;
        @b("ARTISTNAME")
        @Nullable
        private final String artistName;
        @b("ENDDATE")
        @Nullable
        private final String endDate;
        @b("STARTDATE")
        @Nullable
        private final String startDate;
        @b("STATUSCODE")
        @Nullable
        private final String statusCode;
        @b("STATUSMESSAGE")
        @Nullable
        private final String statusMessage;

        public AlbumDto() {
            this(null, null, null, null, null, null, null, null, null, 0x1FF, null);
        }

        public AlbumDto(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
            this.albumId = s;
            this.albumName = s1;
            this.artistId = s2;
            this.artistName = s3;
            this.albumImage = s4;
            this.startDate = s5;
            this.endDate = s6;
            this.statusCode = s7;
            this.statusMessage = s8;
        }

        public AlbumDto(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            if((v & 16) != 0) {
                s4 = null;
            }
            if((v & 0x20) != 0) {
                s5 = null;
            }
            if((v & 0x40) != 0) {
                s6 = null;
            }
            if((v & 0x80) != 0) {
                s7 = null;
            }
            this(s, s1, s2, s3, s4, s5, s6, s7, ((v & 0x100) == 0 ? s8 : null));
        }

        @Override  // com.melon.net.res.Dto
        public Domain asDomain() {
            return this.asDomain();
        }

        @NotNull
        public Album asDomain() {
            String s = this.albumId == null ? "" : this.albumId;
            String s1 = this.albumName == null ? "" : this.albumName;
            String s2 = this.artistId == null ? "" : this.artistId;
            String s3 = this.artistName == null ? "" : this.artistName;
            String s4 = this.albumImage == null ? "" : this.albumImage;
            String s5 = this.startDate == null ? "" : this.startDate;
            String s6 = this.endDate == null ? "" : this.endDate;
            String s7 = this.statusCode == null ? "0" : this.statusCode;
            return this.statusMessage == null ? new Album(s, s1, s2, s3, s4, s5, s6, s7, "") : new Album(s, s1, s2, s3, s4, s5, s6, s7, this.statusMessage);
        }

        @Nullable
        public final String component1() {
            return this.albumId;
        }

        @Nullable
        public final String component2() {
            return this.albumName;
        }

        @Nullable
        public final String component3() {
            return this.artistId;
        }

        @Nullable
        public final String component4() {
            return this.artistName;
        }

        @Nullable
        public final String component5() {
            return this.albumImage;
        }

        @Nullable
        public final String component6() {
            return this.startDate;
        }

        @Nullable
        public final String component7() {
            return this.endDate;
        }

        @Nullable
        public final String component8() {
            return this.statusCode;
        }

        @Nullable
        public final String component9() {
            return this.statusMessage;
        }

        @NotNull
        public final AlbumDto copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8) {
            return new AlbumDto(s, s1, s2, s3, s4, s5, s6, s7, s8);
        }

        public static AlbumDto copy$default(AlbumDto voiceAlarm$AlbumDto0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, int v, Object object0) {
            if((v & 1) != 0) {
                s = voiceAlarm$AlbumDto0.albumId;
            }
            if((v & 2) != 0) {
                s1 = voiceAlarm$AlbumDto0.albumName;
            }
            if((v & 4) != 0) {
                s2 = voiceAlarm$AlbumDto0.artistId;
            }
            if((v & 8) != 0) {
                s3 = voiceAlarm$AlbumDto0.artistName;
            }
            if((v & 16) != 0) {
                s4 = voiceAlarm$AlbumDto0.albumImage;
            }
            if((v & 0x20) != 0) {
                s5 = voiceAlarm$AlbumDto0.startDate;
            }
            if((v & 0x40) != 0) {
                s6 = voiceAlarm$AlbumDto0.endDate;
            }
            if((v & 0x80) != 0) {
                s7 = voiceAlarm$AlbumDto0.statusCode;
            }
            if((v & 0x100) != 0) {
                s8 = voiceAlarm$AlbumDto0.statusMessage;
            }
            return voiceAlarm$AlbumDto0.copy(s, s1, s2, s3, s4, s5, s6, s7, s8);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AlbumDto)) {
                return false;
            }
            if(!q.b(this.albumId, ((AlbumDto)object0).albumId)) {
                return false;
            }
            if(!q.b(this.albumName, ((AlbumDto)object0).albumName)) {
                return false;
            }
            if(!q.b(this.artistId, ((AlbumDto)object0).artistId)) {
                return false;
            }
            if(!q.b(this.artistName, ((AlbumDto)object0).artistName)) {
                return false;
            }
            if(!q.b(this.albumImage, ((AlbumDto)object0).albumImage)) {
                return false;
            }
            if(!q.b(this.startDate, ((AlbumDto)object0).startDate)) {
                return false;
            }
            if(!q.b(this.endDate, ((AlbumDto)object0).endDate)) {
                return false;
            }
            return q.b(this.statusCode, ((AlbumDto)object0).statusCode) ? q.b(this.statusMessage, ((AlbumDto)object0).statusMessage) : false;
        }

        @Nullable
        public final String getAlbumId() {
            return this.albumId;
        }

        @Nullable
        public final String getAlbumImage() {
            return this.albumImage;
        }

        @Nullable
        public final String getAlbumName() {
            return this.albumName;
        }

        @Nullable
        public final String getArtistId() {
            return this.artistId;
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        @Nullable
        public final String getEndDate() {
            return this.endDate;
        }

        @Nullable
        public final String getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final String getStatusCode() {
            return this.statusCode;
        }

        @Nullable
        public final String getStatusMessage() {
            return this.statusMessage;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.albumId == null ? 0 : this.albumId.hashCode();
            int v2 = this.albumName == null ? 0 : this.albumName.hashCode();
            int v3 = this.artistId == null ? 0 : this.artistId.hashCode();
            int v4 = this.artistName == null ? 0 : this.artistName.hashCode();
            int v5 = this.albumImage == null ? 0 : this.albumImage.hashCode();
            int v6 = this.startDate == null ? 0 : this.startDate.hashCode();
            int v7 = this.endDate == null ? 0 : this.endDate.hashCode();
            int v8 = this.statusCode == null ? 0 : this.statusCode.hashCode();
            String s = this.statusMessage;
            if(s != null) {
                v = s.hashCode();
            }
            return (((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("AlbumDto(albumId=", this.albumId, ", albumName=", this.albumName, ", artistId=");
            d.u(stringBuilder0, this.artistId, ", artistName=", this.artistName, ", albumImage=");
            d.u(stringBuilder0, this.albumImage, ", startDate=", this.startDate, ", endDate=");
            d.u(stringBuilder0, this.endDate, ", statusCode=", this.statusCode, ", statusMessage=");
            return x.m(stringBuilder0, this.statusMessage, ")");
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0010\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bg\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0003\u0012\u0006\u0010\u0007\u001A\u00020\u0003\u0012\u0006\u0010\b\u001A\u00020\u0003\u0012\u0006\u0010\t\u001A\u00020\u0003\u0012\u0006\u0010\n\u001A\u00020\u0003\u0012\u0006\u0010\u000B\u001A\u00020\u0003\u0012\u0006\u0010\f\u001A\u00020\u0003\u0012\u0006\u0010\r\u001A\u00020\u0003\u0012\u0006\u0010\u000E\u001A\u00020\u0003\u0012\u0006\u0010\u000F\u001A\u00020\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001A\u00020\u0012\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u001D\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0012\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001CJ\u0010\u0010\u001E\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001CJ\u0010\u0010\u001F\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001CJ\u0010\u0010 \u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001CJ\u0010\u0010!\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001CJ\u0010\u0010\"\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010\u001CJ\u0010\u0010#\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010\u001CJ\u0010\u0010$\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b$\u0010\u001CJ\u0010\u0010%\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b%\u0010\u001CJ\u0010\u0010&\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b&\u0010\u001CJ\u0010\u0010\'\u001A\u00020\u0003H\u00C6\u0003\u00A2\u0006\u0004\b\'\u0010\u001CJ\u0088\u0001\u0010(\u001A\u00020\u00002\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00032\b\b\u0002\u0010\u0006\u001A\u00020\u00032\b\b\u0002\u0010\u0007\u001A\u00020\u00032\b\b\u0002\u0010\b\u001A\u00020\u00032\b\b\u0002\u0010\t\u001A\u00020\u00032\b\b\u0002\u0010\n\u001A\u00020\u00032\b\b\u0002\u0010\u000B\u001A\u00020\u00032\b\b\u0002\u0010\f\u001A\u00020\u00032\b\b\u0002\u0010\r\u001A\u00020\u00032\b\b\u0002\u0010\u000E\u001A\u00020\u00032\b\b\u0002\u0010\u000F\u001A\u00020\u0003H\u00C6\u0001\u00A2\u0006\u0004\b(\u0010)J\u0010\u0010*\u001A\u00020\u0003H\u00D6\u0001\u00A2\u0006\u0004\b*\u0010\u001CJ\u0010\u0010+\u001A\u00020\u0012H\u00D6\u0001\u00A2\u0006\u0004\b+\u0010\u0014J\u001A\u0010/\u001A\u00020.2\b\u0010-\u001A\u0004\u0018\u00010,H\u00D6\u0003\u00A2\u0006\u0004\b/\u00100R\u0017\u0010\u0004\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0004\u00101\u001A\u0004\b2\u0010\u001CR\u0017\u0010\u0005\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0005\u00101\u001A\u0004\b3\u0010\u001CR\u0017\u0010\u0006\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0006\u00101\u001A\u0004\b4\u0010\u001CR\u0017\u0010\u0007\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u0007\u00101\u001A\u0004\b5\u0010\u001CR\u0017\u0010\b\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\b\u00101\u001A\u0004\b6\u0010\u001CR\u0017\u0010\t\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\t\u00101\u001A\u0004\b7\u0010\u001CR\u0017\u0010\n\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\n\u00101\u001A\u0004\b8\u0010\u001CR\u0017\u0010\u000B\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u000B\u00101\u001A\u0004\b9\u0010\u001CR\u0017\u0010\f\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\f\u00101\u001A\u0004\b:\u0010\u001CR\u0017\u0010\r\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\r\u00101\u001A\u0004\b;\u0010\u001CR\u0017\u0010\u000E\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u000E\u00101\u001A\u0004\b<\u0010\u001CR\u0017\u0010\u000F\u001A\u00020\u00038\u0006\u00A2\u0006\f\n\u0004\b\u000F\u00101\u001A\u0004\b=\u0010\u001C\u00A8\u0006>"}, d2 = {"Lcom/melon/net/res/VoiceAlarm$Track;", "Landroid/os/Parcelable;", "Lcom/melon/net/res/Domain;", "", "trackId", "trackName", "artistId", "artistName", "albumId", "albumName", "albumImage", "startDate", "endDate", "playTime", "status", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "Lie/H;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/melon/net/res/VoiceAlarm$Track;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTrackId", "getTrackName", "getArtistId", "getArtistName", "getAlbumId", "getAlbumName", "getAlbumImage", "getStartDate", "getEndDate", "getPlayTime", "getStatus", "getMessage", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Track implements Parcelable, Domain {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class Creator implements Parcelable.Creator {
            public final Track createFromParcel(Parcel parcel0) {
                q.g(parcel0, "parcel");
                return new Track(parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString(), parcel0.readString());
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public final Track[] newArray(int v) {
                return new Track[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        }

        public static final int $stable;
        @NotNull
        public static final Parcelable.Creator CREATOR;
        @NotNull
        private final String albumId;
        @NotNull
        private final String albumImage;
        @NotNull
        private final String albumName;
        @NotNull
        private final String artistId;
        @NotNull
        private final String artistName;
        @NotNull
        private final String endDate;
        @NotNull
        private final String message;
        @NotNull
        private final String playTime;
        @NotNull
        private final String startDate;
        @NotNull
        private final String status;
        @NotNull
        private final String trackId;
        @NotNull
        private final String trackName;

        static {
            Track.CREATOR = new Creator();
        }

        public Track(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11) {
            q.g(s, "trackId");
            q.g(s1, "trackName");
            q.g(s2, "artistId");
            q.g(s3, "artistName");
            q.g(s4, "albumId");
            q.g(s5, "albumName");
            q.g(s6, "albumImage");
            q.g(s7, "startDate");
            q.g(s8, "endDate");
            q.g(s9, "playTime");
            q.g(s10, "status");
            q.g(s11, "message");
            super();
            this.trackId = s;
            this.trackName = s1;
            this.artistId = s2;
            this.artistName = s3;
            this.albumId = s4;
            this.albumName = s5;
            this.albumImage = s6;
            this.startDate = s7;
            this.endDate = s8;
            this.playTime = s9;
            this.status = s10;
            this.message = s11;
        }

        @NotNull
        public final String component1() {
            return this.trackId;
        }

        @NotNull
        public final String component10() {
            return this.playTime;
        }

        @NotNull
        public final String component11() {
            return this.status;
        }

        @NotNull
        public final String component12() {
            return this.message;
        }

        @NotNull
        public final String component2() {
            return this.trackName;
        }

        @NotNull
        public final String component3() {
            return this.artistId;
        }

        @NotNull
        public final String component4() {
            return this.artistName;
        }

        @NotNull
        public final String component5() {
            return this.albumId;
        }

        @NotNull
        public final String component6() {
            return this.albumName;
        }

        @NotNull
        public final String component7() {
            return this.albumImage;
        }

        @NotNull
        public final String component8() {
            return this.startDate;
        }

        @NotNull
        public final String component9() {
            return this.endDate;
        }

        @NotNull
        public final Track copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @NotNull String s4, @NotNull String s5, @NotNull String s6, @NotNull String s7, @NotNull String s8, @NotNull String s9, @NotNull String s10, @NotNull String s11) {
            q.g(s, "trackId");
            q.g(s1, "trackName");
            q.g(s2, "artistId");
            q.g(s3, "artistName");
            q.g(s4, "albumId");
            q.g(s5, "albumName");
            q.g(s6, "albumImage");
            q.g(s7, "startDate");
            q.g(s8, "endDate");
            q.g(s9, "playTime");
            q.g(s10, "status");
            q.g(s11, "message");
            return new Track(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
        }

        public static Track copy$default(Track voiceAlarm$Track0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, int v, Object object0) {
            if((v & 1) != 0) {
                s = voiceAlarm$Track0.trackId;
            }
            if((v & 2) != 0) {
                s1 = voiceAlarm$Track0.trackName;
            }
            if((v & 4) != 0) {
                s2 = voiceAlarm$Track0.artistId;
            }
            if((v & 8) != 0) {
                s3 = voiceAlarm$Track0.artistName;
            }
            if((v & 16) != 0) {
                s4 = voiceAlarm$Track0.albumId;
            }
            if((v & 0x20) != 0) {
                s5 = voiceAlarm$Track0.albumName;
            }
            if((v & 0x40) != 0) {
                s6 = voiceAlarm$Track0.albumImage;
            }
            if((v & 0x80) != 0) {
                s7 = voiceAlarm$Track0.startDate;
            }
            if((v & 0x100) != 0) {
                s8 = voiceAlarm$Track0.endDate;
            }
            if((v & 0x200) != 0) {
                s9 = voiceAlarm$Track0.playTime;
            }
            if((v & 0x400) != 0) {
                s10 = voiceAlarm$Track0.status;
            }
            if((v & 0x800) != 0) {
                s11 = voiceAlarm$Track0.message;
            }
            return voiceAlarm$Track0.copy(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Track)) {
                return false;
            }
            if(!q.b(this.trackId, ((Track)object0).trackId)) {
                return false;
            }
            if(!q.b(this.trackName, ((Track)object0).trackName)) {
                return false;
            }
            if(!q.b(this.artistId, ((Track)object0).artistId)) {
                return false;
            }
            if(!q.b(this.artistName, ((Track)object0).artistName)) {
                return false;
            }
            if(!q.b(this.albumId, ((Track)object0).albumId)) {
                return false;
            }
            if(!q.b(this.albumName, ((Track)object0).albumName)) {
                return false;
            }
            if(!q.b(this.albumImage, ((Track)object0).albumImage)) {
                return false;
            }
            if(!q.b(this.startDate, ((Track)object0).startDate)) {
                return false;
            }
            if(!q.b(this.endDate, ((Track)object0).endDate)) {
                return false;
            }
            if(!q.b(this.playTime, ((Track)object0).playTime)) {
                return false;
            }
            return q.b(this.status, ((Track)object0).status) ? q.b(this.message, ((Track)object0).message) : false;
        }

        @NotNull
        public final String getAlbumId() {
            return this.albumId;
        }

        @NotNull
        public final String getAlbumImage() {
            return this.albumImage;
        }

        @NotNull
        public final String getAlbumName() {
            return this.albumName;
        }

        @NotNull
        public final String getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final String getArtistName() {
            return this.artistName;
        }

        @NotNull
        public final String getEndDate() {
            return this.endDate;
        }

        @NotNull
        public final String getMessage() {
            return this.message;
        }

        @NotNull
        public final String getPlayTime() {
            return this.playTime;
        }

        @NotNull
        public final String getStartDate() {
            return this.startDate;
        }

        @NotNull
        public final String getStatus() {
            return this.status;
        }

        @NotNull
        public final String getTrackId() {
            return this.trackId;
        }

        @NotNull
        public final String getTrackName() {
            return this.trackName;
        }

        @Override
        public int hashCode() {
            return this.message.hashCode() + x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(x.b(this.trackId.hashCode() * 0x1F, 0x1F, this.trackName), 0x1F, this.artistId), 0x1F, this.artistName), 0x1F, this.albumId), 0x1F, this.albumName), 0x1F, this.albumImage), 0x1F, this.startDate), 0x1F, this.endDate), 0x1F, this.playTime), 0x1F, this.status);
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = d.o("Track(trackId=", this.trackId, ", trackName=", this.trackName, ", artistId=");
            d.u(stringBuilder0, this.artistId, ", artistName=", this.artistName, ", albumId=");
            d.u(stringBuilder0, this.albumId, ", albumName=", this.albumName, ", albumImage=");
            d.u(stringBuilder0, this.albumImage, ", startDate=", this.startDate, ", endDate=");
            d.u(stringBuilder0, this.endDate, ", playTime=", this.playTime, ", status=");
            return d.n(stringBuilder0, this.status, ", message=", this.message, ")");
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeString(this.trackId);
            parcel0.writeString(this.trackName);
            parcel0.writeString(this.artistId);
            parcel0.writeString(this.artistName);
            parcel0.writeString(this.albumId);
            parcel0.writeString(this.albumName);
            parcel0.writeString(this.albumImage);
            parcel0.writeString(this.startDate);
            parcel0.writeString(this.endDate);
            parcel0.writeString(this.playTime);
            parcel0.writeString(this.status);
            parcel0.writeString(this.message);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003\u00A2\u0006\u0004\b\u000F\u0010\u0010J\b\u0010+\u001A\u00020,H\u0016J\u000B\u0010-\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010.\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u0010/\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00100\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00101\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00102\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00103\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00104\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00105\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00106\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00107\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u000B\u00108\u001A\u0004\u0018\u00010\u0003H\u00C6\u0003J\u0099\u0001\u00109\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000E\u001A\u0004\u0018\u00010\u0003H\u00C6\u0001J\u0013\u0010:\u001A\u00020;2\b\u0010<\u001A\u0004\u0018\u00010=H\u00D6\u0003J\t\u0010>\u001A\u00020?H\u00D6\u0001J\t\u0010@\u001A\u00020\u0003H\u00D6\u0001R \u0010\u0002\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0004\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R \u0010\u0005\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\u0006\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0012\"\u0004\b\u001A\u0010\u0014R \u0010\u0007\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001B\u0010\u0012\"\u0004\b\u001C\u0010\u0014R \u0010\b\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001D\u0010\u0012\"\u0004\b\u001E\u0010\u0014R \u0010\t\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0012\"\u0004\b \u0010\u0014R \u0010\n\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R \u0010\u000B\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R \u0010\f\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R \u0010\r\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b\'\u0010\u0012\"\u0004\b(\u0010\u0014R \u0010\u000E\u001A\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014\u00A8\u0006A"}, d2 = {"Lcom/melon/net/res/VoiceAlarm$TrackDto;", "Lcom/melon/net/res/Dto;", "trackId", "", "trackName", "artistId", "artistName", "albumId", "albumName", "albumImage", "startDate", "endDate", "playTime", "status", "message", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTrackId", "()Ljava/lang/String;", "setTrackId", "(Ljava/lang/String;)V", "getTrackName", "setTrackName", "getArtistId", "setArtistId", "getArtistName", "setArtistName", "getAlbumId", "setAlbumId", "getAlbumName", "setAlbumName", "getAlbumImage", "setAlbumImage", "getStartDate", "setStartDate", "getEndDate", "setEndDate", "getPlayTime", "setPlayTime", "getStatus", "setStatus", "getMessage", "setMessage", "asDomain", "Lcom/melon/net/res/VoiceAlarm$Track;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TrackDto implements Dto {
        public static final int $stable = 8;
        @b("ALBUMID")
        @Nullable
        private String albumId;
        @b("ALBUMIMAGE")
        @Nullable
        private String albumImage;
        @b("ALBUMNAME")
        @Nullable
        private String albumName;
        @b("ARTISTID")
        @Nullable
        private String artistId;
        @b("ARTISTNAME")
        @Nullable
        private String artistName;
        @b("ENDDATE")
        @Nullable
        private String endDate;
        @b("MESSAGE")
        @Nullable
        private String message;
        @b("PLAYTIME")
        @Nullable
        private String playTime;
        @b("STARTDATE")
        @Nullable
        private String startDate;
        @b("STATUS")
        @Nullable
        private String status;
        @b("TRACKID")
        @Nullable
        private String trackId;
        @b("TRACKNAME")
        @Nullable
        private String trackName;

        public TrackDto() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, 0xFFF, null);
        }

        public TrackDto(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable String s11) {
            this.trackId = s;
            this.trackName = s1;
            this.artistId = s2;
            this.artistName = s3;
            this.albumId = s4;
            this.albumName = s5;
            this.albumImage = s6;
            this.startDate = s7;
            this.endDate = s8;
            this.playTime = s9;
            this.status = s10;
            this.message = s11;
        }

        public TrackDto(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = null;
            }
            if((v & 2) != 0) {
                s1 = null;
            }
            if((v & 4) != 0) {
                s2 = null;
            }
            if((v & 8) != 0) {
                s3 = null;
            }
            if((v & 16) != 0) {
                s4 = null;
            }
            if((v & 0x20) != 0) {
                s5 = null;
            }
            if((v & 0x40) != 0) {
                s6 = null;
            }
            if((v & 0x80) != 0) {
                s7 = null;
            }
            if((v & 0x100) != 0) {
                s8 = null;
            }
            if((v & 0x200) != 0) {
                s9 = null;
            }
            if((v & 0x400) != 0) {
                s10 = null;
            }
            this(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, ((v & 0x800) == 0 ? s11 : null));
        }

        @Override  // com.melon.net.res.Dto
        public Domain asDomain() {
            return this.asDomain();
        }

        @NotNull
        public Track asDomain() {
            String s = this.trackId == null ? "" : this.trackId;
            String s1 = this.trackName == null ? "" : this.trackName;
            String s2 = this.artistId == null ? "" : this.artistId;
            String s3 = this.artistName == null ? "" : this.artistName;
            String s4 = this.albumId == null ? "" : this.albumId;
            String s5 = this.albumName == null ? "" : this.albumName;
            String s6 = this.albumImage == null ? "" : this.albumImage;
            String s7 = this.startDate == null ? "" : this.startDate;
            String s8 = this.endDate == null ? "" : this.endDate;
            String s9 = this.playTime == null ? "" : this.playTime;
            String s10 = this.status == null ? "0" : this.status;
            return this.message == null ? new Track(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, "") : new Track(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, this.message);
        }

        @Nullable
        public final String component1() {
            return this.trackId;
        }

        @Nullable
        public final String component10() {
            return this.playTime;
        }

        @Nullable
        public final String component11() {
            return this.status;
        }

        @Nullable
        public final String component12() {
            return this.message;
        }

        @Nullable
        public final String component2() {
            return this.trackName;
        }

        @Nullable
        public final String component3() {
            return this.artistId;
        }

        @Nullable
        public final String component4() {
            return this.artistName;
        }

        @Nullable
        public final String component5() {
            return this.albumId;
        }

        @Nullable
        public final String component6() {
            return this.albumName;
        }

        @Nullable
        public final String component7() {
            return this.albumImage;
        }

        @Nullable
        public final String component8() {
            return this.startDate;
        }

        @Nullable
        public final String component9() {
            return this.endDate;
        }

        @NotNull
        public final TrackDto copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable String s4, @Nullable String s5, @Nullable String s6, @Nullable String s7, @Nullable String s8, @Nullable String s9, @Nullable String s10, @Nullable String s11) {
            return new TrackDto(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
        }

        public static TrackDto copy$default(TrackDto voiceAlarm$TrackDto0, String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, int v, Object object0) {
            if((v & 1) != 0) {
                s = voiceAlarm$TrackDto0.trackId;
            }
            if((v & 2) != 0) {
                s1 = voiceAlarm$TrackDto0.trackName;
            }
            if((v & 4) != 0) {
                s2 = voiceAlarm$TrackDto0.artistId;
            }
            if((v & 8) != 0) {
                s3 = voiceAlarm$TrackDto0.artistName;
            }
            if((v & 16) != 0) {
                s4 = voiceAlarm$TrackDto0.albumId;
            }
            if((v & 0x20) != 0) {
                s5 = voiceAlarm$TrackDto0.albumName;
            }
            if((v & 0x40) != 0) {
                s6 = voiceAlarm$TrackDto0.albumImage;
            }
            if((v & 0x80) != 0) {
                s7 = voiceAlarm$TrackDto0.startDate;
            }
            if((v & 0x100) != 0) {
                s8 = voiceAlarm$TrackDto0.endDate;
            }
            if((v & 0x200) != 0) {
                s9 = voiceAlarm$TrackDto0.playTime;
            }
            if((v & 0x400) != 0) {
                s10 = voiceAlarm$TrackDto0.status;
            }
            if((v & 0x800) != 0) {
                s11 = voiceAlarm$TrackDto0.message;
            }
            return voiceAlarm$TrackDto0.copy(s, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof TrackDto)) {
                return false;
            }
            if(!q.b(this.trackId, ((TrackDto)object0).trackId)) {
                return false;
            }
            if(!q.b(this.trackName, ((TrackDto)object0).trackName)) {
                return false;
            }
            if(!q.b(this.artistId, ((TrackDto)object0).artistId)) {
                return false;
            }
            if(!q.b(this.artistName, ((TrackDto)object0).artistName)) {
                return false;
            }
            if(!q.b(this.albumId, ((TrackDto)object0).albumId)) {
                return false;
            }
            if(!q.b(this.albumName, ((TrackDto)object0).albumName)) {
                return false;
            }
            if(!q.b(this.albumImage, ((TrackDto)object0).albumImage)) {
                return false;
            }
            if(!q.b(this.startDate, ((TrackDto)object0).startDate)) {
                return false;
            }
            if(!q.b(this.endDate, ((TrackDto)object0).endDate)) {
                return false;
            }
            if(!q.b(this.playTime, ((TrackDto)object0).playTime)) {
                return false;
            }
            return q.b(this.status, ((TrackDto)object0).status) ? q.b(this.message, ((TrackDto)object0).message) : false;
        }

        @Nullable
        public final String getAlbumId() {
            return this.albumId;
        }

        @Nullable
        public final String getAlbumImage() {
            return this.albumImage;
        }

        @Nullable
        public final String getAlbumName() {
            return this.albumName;
        }

        @Nullable
        public final String getArtistId() {
            return this.artistId;
        }

        @Nullable
        public final String getArtistName() {
            return this.artistName;
        }

        @Nullable
        public final String getEndDate() {
            return this.endDate;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        @Nullable
        public final String getPlayTime() {
            return this.playTime;
        }

        @Nullable
        public final String getStartDate() {
            return this.startDate;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Nullable
        public final String getTrackId() {
            return this.trackId;
        }

        @Nullable
        public final String getTrackName() {
            return this.trackName;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.trackId == null ? 0 : this.trackId.hashCode();
            int v2 = this.trackName == null ? 0 : this.trackName.hashCode();
            int v3 = this.artistId == null ? 0 : this.artistId.hashCode();
            int v4 = this.artistName == null ? 0 : this.artistName.hashCode();
            int v5 = this.albumId == null ? 0 : this.albumId.hashCode();
            int v6 = this.albumName == null ? 0 : this.albumName.hashCode();
            int v7 = this.albumImage == null ? 0 : this.albumImage.hashCode();
            int v8 = this.startDate == null ? 0 : this.startDate.hashCode();
            int v9 = this.endDate == null ? 0 : this.endDate.hashCode();
            int v10 = this.playTime == null ? 0 : this.playTime.hashCode();
            int v11 = this.status == null ? 0 : this.status.hashCode();
            String s = this.message;
            if(s != null) {
                v = s.hashCode();
            }
            return ((((((((((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v4) * 0x1F + v5) * 0x1F + v6) * 0x1F + v7) * 0x1F + v8) * 0x1F + v9) * 0x1F + v10) * 0x1F + v11) * 0x1F + v;
        }

        public final void setAlbumId(@Nullable String s) {
            this.albumId = s;
        }

        public final void setAlbumImage(@Nullable String s) {
            this.albumImage = s;
        }

        public final void setAlbumName(@Nullable String s) {
            this.albumName = s;
        }

        public final void setArtistId(@Nullable String s) {
            this.artistId = s;
        }

        public final void setArtistName(@Nullable String s) {
            this.artistName = s;
        }

        public final void setEndDate(@Nullable String s) {
            this.endDate = s;
        }

        public final void setMessage(@Nullable String s) {
            this.message = s;
        }

        public final void setPlayTime(@Nullable String s) {
            this.playTime = s;
        }

        public final void setStartDate(@Nullable String s) {
            this.startDate = s;
        }

        public final void setStatus(@Nullable String s) {
            this.status = s;
        }

        public final void setTrackId(@Nullable String s) {
            this.trackId = s;
        }

        public final void setTrackName(@Nullable String s) {
            this.trackName = s;
        }

        @Override
        @NotNull
        public String toString() {
            String s = this.artistId;
            String s1 = this.artistName;
            String s2 = this.albumId;
            String s3 = this.albumName;
            String s4 = this.albumImage;
            String s5 = this.startDate;
            String s6 = this.endDate;
            String s7 = this.playTime;
            String s8 = this.status;
            String s9 = this.message;
            StringBuilder stringBuilder0 = d.o("TrackDto(trackId=", this.trackId, ", trackName=", this.trackName, ", artistId=");
            d.u(stringBuilder0, s, ", artistName=", s1, ", albumId=");
            d.u(stringBuilder0, s2, ", albumName=", s3, ", albumImage=");
            d.u(stringBuilder0, s4, ", startDate=", s5, ", endDate=");
            d.u(stringBuilder0, s6, ", playTime=", s7, ", status=");
            return d.n(stringBuilder0, s8, ", message=", s9, ")");
        }
    }

    public static final int $stable;

}

