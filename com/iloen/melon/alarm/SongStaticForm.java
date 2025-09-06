package com.iloen.melon.alarm;

import A7.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0014\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0015\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0016\u001A\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0017\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001A\u00020\u00192\b\u0010\u001A\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001B\u001A\u00020\u001CHÖ\u0001J\t\u0010\u001D\u001A\u00020\u0003HÖ\u0001R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\n\"\u0004\b\u000E\u0010\fR\u001C\u0010\u0005\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\n\"\u0004\b\u0010\u0010\fR\u001C\u0010\u0006\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/alarm/SongStaticForm;", "", "songId", "", "songName", "artistId", "artistName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSongId", "()Ljava/lang/String;", "setSongId", "(Ljava/lang/String;)V", "getSongName", "setSongName", "getArtistId", "setArtistId", "getArtistName", "setArtistName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongStaticForm {
    public static final int $stable = 8;
    @Nullable
    private String artistId;
    @Nullable
    private String artistName;
    @Nullable
    private String songId;
    @Nullable
    private String songName;

    public SongStaticForm() {
        this(null, null, null, null, 15, null);
    }

    public SongStaticForm(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        this.songId = s;
        this.songName = s1;
        this.artistId = s2;
        this.artistName = s3;
    }

    public SongStaticForm(String s, String s1, String s2, String s3, int v, DefaultConstructorMarker defaultConstructorMarker0) {
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
        this(s, s1, s2, s3);
    }

    @Nullable
    public final String component1() {
        return this.songId;
    }

    @Nullable
    public final String component2() {
        return this.songName;
    }

    @Nullable
    public final String component3() {
        return this.artistId;
    }

    @Nullable
    public final String component4() {
        return this.artistName;
    }

    @NotNull
    public final SongStaticForm copy(@Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3) {
        return new SongStaticForm(s, s1, s2, s3);
    }

    public static SongStaticForm copy$default(SongStaticForm songStaticForm0, String s, String s1, String s2, String s3, int v, Object object0) {
        if((v & 1) != 0) {
            s = songStaticForm0.songId;
        }
        if((v & 2) != 0) {
            s1 = songStaticForm0.songName;
        }
        if((v & 4) != 0) {
            s2 = songStaticForm0.artistId;
        }
        if((v & 8) != 0) {
            s3 = songStaticForm0.artistName;
        }
        return songStaticForm0.copy(s, s1, s2, s3);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SongStaticForm)) {
            return false;
        }
        if(!q.b(this.songId, ((SongStaticForm)object0).songId)) {
            return false;
        }
        if(!q.b(this.songName, ((SongStaticForm)object0).songName)) {
            return false;
        }
        return q.b(this.artistId, ((SongStaticForm)object0).artistId) ? q.b(this.artistName, ((SongStaticForm)object0).artistName) : false;
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
    public final String getSongId() {
        return this.songId;
    }

    @Nullable
    public final String getSongName() {
        return this.songName;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = this.songId == null ? 0 : this.songId.hashCode();
        int v2 = this.songName == null ? 0 : this.songName.hashCode();
        int v3 = this.artistId == null ? 0 : this.artistId.hashCode();
        String s = this.artistName;
        if(s != null) {
            v = s.hashCode();
        }
        return ((v1 * 0x1F + v2) * 0x1F + v3) * 0x1F + v;
    }

    public final void setArtistId(@Nullable String s) {
        this.artistId = s;
    }

    public final void setArtistName(@Nullable String s) {
        this.artistName = s;
    }

    public final void setSongId(@Nullable String s) {
        this.songId = s;
    }

    public final void setSongName(@Nullable String s) {
        this.songName = s;
    }

    @Override
    @NotNull
    public String toString() {
        String s = this.artistId;
        String s1 = this.artistName;
        return d.n(d.o("SongStaticForm(songId=", this.songId, ", songName=", this.songName, ", artistId="), s, ", artistName=", s1, ")");
    }
}

