package com.iloen.melon.playback;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u000E2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/playback/PlayableAlbumUriData;", "", "smallAlbumUri", "Landroid/net/Uri;", "largeAlbumUri", "<init>", "(Landroid/net/Uri;Landroid/net/Uri;)V", "getSmallAlbumUri", "()Landroid/net/Uri;", "getLargeAlbumUri", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableAlbumUriData {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/PlayableAlbumUriData$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/iloen/melon/playback/PlayableAlbumUriData;", "getEMPTY", "()Lcom/iloen/melon/playback/PlayableAlbumUriData;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlayableAlbumUriData getEMPTY() {
            return PlayableAlbumUriData.EMPTY;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private static final PlayableAlbumUriData EMPTY;
    @NotNull
    private final Uri largeAlbumUri;
    @NotNull
    private final Uri smallAlbumUri;

    static {
        PlayableAlbumUriData.Companion = new Companion(null);
        PlayableAlbumUriData.$stable = 8;
        Uri uri0 = Uri.EMPTY;
        q.f(uri0, "EMPTY");
        q.f(uri0, "EMPTY");
        PlayableAlbumUriData.EMPTY = new PlayableAlbumUriData(uri0, uri0);
    }

    public PlayableAlbumUriData(@NotNull Uri uri0, @NotNull Uri uri1) {
        q.g(uri0, "smallAlbumUri");
        q.g(uri1, "largeAlbumUri");
        super();
        this.smallAlbumUri = uri0;
        this.largeAlbumUri = uri1;
    }

    @NotNull
    public final Uri component1() {
        return this.smallAlbumUri;
    }

    @NotNull
    public final Uri component2() {
        return this.largeAlbumUri;
    }

    @NotNull
    public final PlayableAlbumUriData copy(@NotNull Uri uri0, @NotNull Uri uri1) {
        q.g(uri0, "smallAlbumUri");
        q.g(uri1, "largeAlbumUri");
        return new PlayableAlbumUriData(uri0, uri1);
    }

    public static PlayableAlbumUriData copy$default(PlayableAlbumUriData playableAlbumUriData0, Uri uri0, Uri uri1, int v, Object object0) {
        if((v & 1) != 0) {
            uri0 = playableAlbumUriData0.smallAlbumUri;
        }
        if((v & 2) != 0) {
            uri1 = playableAlbumUriData0.largeAlbumUri;
        }
        return playableAlbumUriData0.copy(uri0, uri1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof PlayableAlbumUriData)) {
            return false;
        }
        return q.b(this.smallAlbumUri, ((PlayableAlbumUriData)object0).smallAlbumUri) ? q.b(this.largeAlbumUri, ((PlayableAlbumUriData)object0).largeAlbumUri) : false;
    }

    @NotNull
    public final Uri getLargeAlbumUri() {
        return this.largeAlbumUri;
    }

    @NotNull
    public final Uri getSmallAlbumUri() {
        return this.smallAlbumUri;
    }

    @Override
    public int hashCode() {
        return this.largeAlbumUri.hashCode() + this.smallAlbumUri.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "PlayableAlbumUriData(smallAlbumUri=" + this.smallAlbumUri + ", largeAlbumUri=" + this.largeAlbumUri + ")";
    }
}

