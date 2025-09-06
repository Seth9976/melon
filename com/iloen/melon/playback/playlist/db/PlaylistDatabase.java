package com.iloen.melon.playback.playlist.db;

import E9.w;
import H4.a;
import android.content.Context;
import androidx.room.A;
import androidx.room.B;
import androidx.room.H;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/PlaylistDatabase;", "Landroidx/room/H;", "<init>", "()V", "Lcom/iloen/melon/playback/playlist/db/PlaylistDao;", "playlistDao", "()Lcom/iloen/melon/playback/playlist/db/PlaylistDao;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistDatabase extends H {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\bJ\u0010\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\fH\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/iloen/melon/playback/playlist/db/PlaylistDatabase$Companion;", "", "<init>", "()V", "TAG", "", "PLAYLIST_DATABASE_NAME", "instance", "Lcom/iloen/melon/playback/playlist/db/PlaylistDatabase;", "getInstance", "buildDatabase", "context", "Landroid/content/Context;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        private final PlaylistDatabase buildDatabase(Context context0) {
            A a0 = w.o(context0, PlaylistDatabase.class, "playlist-db");
            com.iloen.melon.playback.playlist.db.PlaylistDatabase.Companion.buildDatabase.1 playlistDatabase$Companion$buildDatabase$10 = new com.iloen.melon.playback.playlist.db.PlaylistDatabase.Companion.buildDatabase.1();
            a0.d.add(playlistDatabase$Companion$buildDatabase$10);
            return (PlaylistDatabase)a0.b();

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/iloen/melon/playback/playlist/db/PlaylistDatabase$Companion$buildDatabase$1", "Landroidx/room/B;", "LH4/a;", "db", "Lie/H;", "onCreate", "(LH4/a;)V", "onOpen", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public final class com.iloen.melon.playback.playlist.db.PlaylistDatabase.Companion.buildDatabase.1 extends B {
                @Override  // androidx.room.B
                public void onCreate(a a0) {
                    q.g(a0, "db");
                    LogU.Companion.d("PlaylistDatabase", "onCreate()");
                }

                @Override  // androidx.room.B
                public void onOpen(a a0) {
                    q.g(a0, "db");
                    LogU.Companion.d("PlaylistDatabase", "onOpen()");
                }
            }

        }

        @NotNull
        public final PlaylistDatabase getInstance() {
            PlaylistDatabase playlistDatabase0 = PlaylistDatabase.instance;
            if(playlistDatabase0 == null) {
                synchronized(this) {
                    PlaylistDatabase playlistDatabase1 = PlaylistDatabase.instance;
                    if(playlistDatabase1 == null) {
                        MelonAppBase.Companion.getClass();
                        Context context0 = t.a().getContext();
                        playlistDatabase1 = PlaylistDatabase.Companion.buildDatabase(context0);
                        PlaylistDatabase.instance = playlistDatabase1;
                    }
                    return playlistDatabase1;
                }
            }
            return playlistDatabase0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PLAYLIST_DATABASE_NAME = "playlist-db";
    @NotNull
    private static final String TAG = "PlaylistDatabase";
    @Nullable
    private static volatile PlaylistDatabase instance;

    static {
        PlaylistDatabase.Companion = new Companion(null);
        PlaylistDatabase.$stable = 8;
    }

    @NotNull
    public abstract PlaylistDao playlistDao();
}

