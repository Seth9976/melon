package com.iloen.melon.player.playlist.common;

import A7.d;
import U4.x;
import com.iloen.melon.fragments.artistchannel.viewholder.f;
import com.iloen.melon.playback.playlist.PlaylistId;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.e;
import we.a;
import we.k;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/playlist/common/DeletePlaylist;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "DeletePlaylistByIndices", "DeletePlaylistByPlayables", "DeleteDrawerPlaylist", "DeleteViewModeDrawerPlaylist", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeleteDrawerPlaylist;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeletePlaylistByIndices;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeletePlaylistByPlayables;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeleteViewModeDrawerPlaylist;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DeletePlaylist implements PlaylistDeleteUserEvent {
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0005\u0012\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0014\b\u0002\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000B\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u0016\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001A\u00020\u0005H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0013J\u0016\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u001C\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018JZ\u0010\u0019\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u00052\b\b\u0002\u0010\u0007\u001A\u00020\u00052\u000E\b\u0002\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000BH\u00C6\u0001\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\u001BH\u00D6\u0001\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0010\u0010\u001E\u001A\u00020\u0003H\u00D6\u0001\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001A\u0010\"\u001A\u00020\u00052\b\u0010!\u001A\u0004\u0018\u00010 H\u00D6\u0003\u00A2\u0006\u0004\b\"\u0010#R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00A2\u0006\f\n\u0004\b$\u0010%\u001A\u0004\b&\u0010\u0011R\u0017\u0010\u0006\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010\u0013R\u0017\u0010\u0007\u001A\u00020\u00058\u0006\u00A2\u0006\f\n\u0004\b*\u0010(\u001A\u0004\b+\u0010\u0013R\u001D\u0010\n\u001A\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00A2\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010\u0016R#\u0010\r\u001A\u000E\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000B8\u0006\u00A2\u0006\f\n\u0004\b/\u00100\u001A\u0004\b1\u0010\u0018\u00A8\u00062"}, d2 = {"Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeleteDrawerPlaylist;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist;", "", "", "indices", "", "confirmWhenOnSelectRepeat", "confirmBeforeDelete", "Lkotlin/Function0;", "Lie/H;", "beforeDeleteTask", "Lkotlin/Function1;", "Loc/U;", "afterDeleteTask", "<init>", "(Ljava/util/List;ZZLwe/a;Lwe/k;)V", "component1", "()Ljava/util/List;", "component2", "()Z", "component3", "component4", "()Lwe/a;", "component5", "()Lwe/k;", "copy", "(Ljava/util/List;ZZLwe/a;Lwe/k;)Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeleteDrawerPlaylist;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "getIndices", "b", "Z", "getConfirmWhenOnSelectRepeat", "c", "getConfirmBeforeDelete", "d", "Lwe/a;", "getBeforeDeleteTask", "e", "Lwe/k;", "getAfterDeleteTask", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DeleteDrawerPlaylist extends DeletePlaylist {
        public static final int $stable = 8;
        public final List a;
        public final boolean b;
        public final boolean c;
        public final a d;
        public final k e;

        public DeleteDrawerPlaylist(@NotNull List list0, boolean z, boolean z1, @NotNull a a0, @NotNull k k0) {
            q.g(list0, "indices");
            q.g(a0, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            super(null);
            this.a = list0;
            this.b = z;
            this.c = z1;
            this.d = a0;
            this.e = k0;
        }

        public DeleteDrawerPlaylist(List list0, boolean z, boolean z1, a a0, k k0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                z = true;
            }
            if((v & 4) != 0) {
                z1 = true;
            }
            if((v & 8) != 0) {
                a0 = new e(24);
            }
            if((v & 16) != 0) {
                k0 = new f(24);
            }
            this(list0, z, z1, a0, k0);
        }

        @NotNull
        public final List component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final a component4() {
            return this.d;
        }

        @NotNull
        public final k component5() {
            return this.e;
        }

        @NotNull
        public final DeleteDrawerPlaylist copy(@NotNull List list0, boolean z, boolean z1, @NotNull a a0, @NotNull k k0) {
            q.g(list0, "indices");
            q.g(a0, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            return new DeleteDrawerPlaylist(list0, z, z1, a0, k0);
        }

        public static DeleteDrawerPlaylist copy$default(DeleteDrawerPlaylist deletePlaylist$DeleteDrawerPlaylist0, List list0, boolean z, boolean z1, a a0, k k0, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = deletePlaylist$DeleteDrawerPlaylist0.a;
            }
            if((v & 2) != 0) {
                z = deletePlaylist$DeleteDrawerPlaylist0.b;
            }
            if((v & 4) != 0) {
                z1 = deletePlaylist$DeleteDrawerPlaylist0.c;
            }
            if((v & 8) != 0) {
                a0 = deletePlaylist$DeleteDrawerPlaylist0.d;
            }
            if((v & 16) != 0) {
                k0 = deletePlaylist$DeleteDrawerPlaylist0.e;
            }
            return deletePlaylist$DeleteDrawerPlaylist0.copy(list0, z, z1, a0, k0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DeleteDrawerPlaylist)) {
                return false;
            }
            if(!q.b(this.a, ((DeleteDrawerPlaylist)object0).a)) {
                return false;
            }
            if(this.b != ((DeleteDrawerPlaylist)object0).b) {
                return false;
            }
            if(this.c != ((DeleteDrawerPlaylist)object0).c) {
                return false;
            }
            return q.b(this.d, ((DeleteDrawerPlaylist)object0).d) ? q.b(this.e, ((DeleteDrawerPlaylist)object0).e) : false;
        }

        @NotNull
        public final k getAfterDeleteTask() {
            return this.e;
        }

        @NotNull
        public final a getBeforeDeleteTask() {
            return this.d;
        }

        public final boolean getConfirmBeforeDelete() {
            return this.c;
        }

        public final boolean getConfirmWhenOnSelectRepeat() {
            return this.b;
        }

        @NotNull
        public final List getIndices() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.e.hashCode() + (this.d.hashCode() + d.e(d.e(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c)) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "DeleteDrawerPlaylist(indices=" + this.a + ", confirmWhenOnSelectRepeat=" + this.b + ", confirmBeforeDelete=" + this.c + ", beforeDeleteTask=" + this.d + ", afterDeleteTask=" + this.e + ")";
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001C\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rH\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJd\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rH\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010#J\u001A\u0010&\u001A\u00020\u00072\b\u0010%\u001A\u0004\u0018\u00010$H\u00D6\u0003\u00A2\u0006\u0004\b&\u0010\'R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010\u0013R\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00A2\u0006\f\n\u0004\b+\u0010,\u001A\u0004\b-\u0010\u0015R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u0010\u0017R\u0017\u0010\t\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b1\u0010/\u001A\u0004\b2\u0010\u0017R\u001D\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8\u0006\u00A2\u0006\f\n\u0004\b3\u00104\u001A\u0004\b5\u0010\u001AR#\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r8\u0006\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u0010\u001C\u00A8\u00069"}, d2 = {"Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeletePlaylistByIndices;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "", "", "indices", "", "confirmWhenOnSelectRepeat", "confirmBeforeDelete", "Lkotlin/Function0;", "Lie/H;", "beforeDeleteTask", "Lkotlin/Function1;", "Loc/U;", "afterDeleteTask", "<init>", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Ljava/util/List;ZZLwe/a;Lwe/k;)V", "component1", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "component2", "()Ljava/util/List;", "component3", "()Z", "component4", "component5", "()Lwe/a;", "component6", "()Lwe/k;", "copy", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Ljava/util/List;ZZLwe/a;Lwe/k;)Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeletePlaylistByIndices;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "b", "Ljava/util/List;", "getIndices", "c", "Z", "getConfirmWhenOnSelectRepeat", "d", "getConfirmBeforeDelete", "e", "Lwe/a;", "getBeforeDeleteTask", "f", "Lwe/k;", "getAfterDeleteTask", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DeletePlaylistByIndices extends DeletePlaylist {
        public static final int $stable = 8;
        public final PlaylistId a;
        public final List b;
        public final boolean c;
        public final boolean d;
        public final a e;
        public final k f;

        public DeletePlaylistByIndices(@NotNull PlaylistId playlistId0, @NotNull List list0, boolean z, boolean z1, @NotNull a a0, @NotNull k k0) {
            q.g(playlistId0, "playlistId");
            q.g(list0, "indices");
            q.g(a0, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            super(null);
            this.a = playlistId0;
            this.b = list0;
            this.c = z;
            this.d = z1;
            this.e = a0;
            this.f = k0;
        }

        public DeletePlaylistByIndices(PlaylistId playlistId0, List list0, boolean z, boolean z1, a a0, k k0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                z = true;
            }
            if((v & 8) != 0) {
                z1 = true;
            }
            if((v & 16) != 0) {
                a0 = new e(24);
            }
            if((v & 0x20) != 0) {
                k0 = new f(25);
            }
            this(playlistId0, list0, z, z1, a0, k0);
        }

        @NotNull
        public final PlaylistId component1() {
            return this.a;
        }

        @NotNull
        public final List component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final a component5() {
            return this.e;
        }

        @NotNull
        public final k component6() {
            return this.f;
        }

        @NotNull
        public final DeletePlaylistByIndices copy(@NotNull PlaylistId playlistId0, @NotNull List list0, boolean z, boolean z1, @NotNull a a0, @NotNull k k0) {
            q.g(playlistId0, "playlistId");
            q.g(list0, "indices");
            q.g(a0, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            return new DeletePlaylistByIndices(playlistId0, list0, z, z1, a0, k0);
        }

        public static DeletePlaylistByIndices copy$default(DeletePlaylistByIndices deletePlaylist$DeletePlaylistByIndices0, PlaylistId playlistId0, List list0, boolean z, boolean z1, a a0, k k0, int v, Object object0) {
            if((v & 1) != 0) {
                playlistId0 = deletePlaylist$DeletePlaylistByIndices0.a;
            }
            if((v & 2) != 0) {
                list0 = deletePlaylist$DeletePlaylistByIndices0.b;
            }
            if((v & 4) != 0) {
                z = deletePlaylist$DeletePlaylistByIndices0.c;
            }
            if((v & 8) != 0) {
                z1 = deletePlaylist$DeletePlaylistByIndices0.d;
            }
            if((v & 16) != 0) {
                a0 = deletePlaylist$DeletePlaylistByIndices0.e;
            }
            if((v & 0x20) != 0) {
                k0 = deletePlaylist$DeletePlaylistByIndices0.f;
            }
            return deletePlaylist$DeletePlaylistByIndices0.copy(playlistId0, list0, z, z1, a0, k0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DeletePlaylistByIndices)) {
                return false;
            }
            if(this.a != ((DeletePlaylistByIndices)object0).a) {
                return false;
            }
            if(!q.b(this.b, ((DeletePlaylistByIndices)object0).b)) {
                return false;
            }
            if(this.c != ((DeletePlaylistByIndices)object0).c) {
                return false;
            }
            if(this.d != ((DeletePlaylistByIndices)object0).d) {
                return false;
            }
            return q.b(this.e, ((DeletePlaylistByIndices)object0).e) ? q.b(this.f, ((DeletePlaylistByIndices)object0).f) : false;
        }

        @NotNull
        public final k getAfterDeleteTask() {
            return this.f;
        }

        @NotNull
        public final a getBeforeDeleteTask() {
            return this.e;
        }

        public final boolean getConfirmBeforeDelete() {
            return this.d;
        }

        public final boolean getConfirmWhenOnSelectRepeat() {
            return this.c;
        }

        @NotNull
        public final List getIndices() {
            return this.b;
        }

        @NotNull
        public final PlaylistId getPlaylistId() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.f.hashCode() + (this.e.hashCode() + d.e(d.e(d.d(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d)) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("DeletePlaylistByIndices(playlistId=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", indices=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", confirmWhenOnSelectRepeat=");
            x.y(stringBuilder0, this.c, ", confirmBeforeDelete=", this.d, ", beforeDeleteTask=");
            stringBuilder0.append(this.e);
            stringBuilder0.append(", afterDeleteTask=");
            stringBuilder0.append(this.f);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001C\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rH\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJd\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rH\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010#\u001A\u00020\"H\u00D6\u0001\u00A2\u0006\u0004\b#\u0010$J\u001A\u0010\'\u001A\u00020\u00072\b\u0010&\u001A\u0004\u0018\u00010%H\u00D6\u0003\u00A2\u0006\u0004\b\'\u0010(R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b)\u0010*\u001A\u0004\b+\u0010\u0013R\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00A2\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010\u0015R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b/\u00100\u001A\u0004\b1\u0010\u0017R\u0017\u0010\t\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b2\u00100\u001A\u0004\b3\u0010\u0017R\u001D\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u0010\u001AR#\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r8\u0006\u00A2\u0006\f\n\u0004\b7\u00108\u001A\u0004\b9\u0010\u001C\u00A8\u0006:"}, d2 = {"Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeletePlaylistByPlayables;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "", "Lcom/iloen/melon/playback/Playable;", "playables", "", "confirmWhenOnSelectRepeat", "confirmBeforeDelete", "Lkotlin/Function0;", "Lie/H;", "beforeDeleteTask", "Lkotlin/Function1;", "Loc/U;", "afterDeleteTask", "<init>", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Ljava/util/List;ZZLwe/a;Lwe/k;)V", "component1", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "component2", "()Ljava/util/List;", "component3", "()Z", "component4", "component5", "()Lwe/a;", "component6", "()Lwe/k;", "copy", "(Lcom/iloen/melon/playback/playlist/PlaylistId;Ljava/util/List;ZZLwe/a;Lwe/k;)Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeletePlaylistByPlayables;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "b", "Ljava/util/List;", "getPlayables", "c", "Z", "getConfirmWhenOnSelectRepeat", "d", "getConfirmBeforeDelete", "e", "Lwe/a;", "getBeforeDeleteTask", "f", "Lwe/k;", "getAfterDeleteTask", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DeletePlaylistByPlayables extends DeletePlaylist {
        public static final int $stable = 8;
        public final PlaylistId a;
        public final List b;
        public final boolean c;
        public final boolean d;
        public final a e;
        public final k f;

        public DeletePlaylistByPlayables(@NotNull PlaylistId playlistId0, @NotNull List list0, boolean z, boolean z1, @NotNull a a0, @NotNull k k0) {
            q.g(playlistId0, "playlistId");
            q.g(list0, "playables");
            q.g(a0, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            super(null);
            this.a = playlistId0;
            this.b = list0;
            this.c = z;
            this.d = z1;
            this.e = a0;
            this.f = k0;
        }

        public DeletePlaylistByPlayables(PlaylistId playlistId0, List list0, boolean z, boolean z1, a a0, k k0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                z = true;
            }
            if((v & 8) != 0) {
                z1 = true;
            }
            if((v & 16) != 0) {
                a0 = new e(24);
            }
            if((v & 0x20) != 0) {
                k0 = new f(26);
            }
            this(playlistId0, list0, z, z1, a0, k0);
        }

        @NotNull
        public final PlaylistId component1() {
            return this.a;
        }

        @NotNull
        public final List component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final a component5() {
            return this.e;
        }

        @NotNull
        public final k component6() {
            return this.f;
        }

        @NotNull
        public final DeletePlaylistByPlayables copy(@NotNull PlaylistId playlistId0, @NotNull List list0, boolean z, boolean z1, @NotNull a a0, @NotNull k k0) {
            q.g(playlistId0, "playlistId");
            q.g(list0, "playables");
            q.g(a0, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            return new DeletePlaylistByPlayables(playlistId0, list0, z, z1, a0, k0);
        }

        public static DeletePlaylistByPlayables copy$default(DeletePlaylistByPlayables deletePlaylist$DeletePlaylistByPlayables0, PlaylistId playlistId0, List list0, boolean z, boolean z1, a a0, k k0, int v, Object object0) {
            if((v & 1) != 0) {
                playlistId0 = deletePlaylist$DeletePlaylistByPlayables0.a;
            }
            if((v & 2) != 0) {
                list0 = deletePlaylist$DeletePlaylistByPlayables0.b;
            }
            if((v & 4) != 0) {
                z = deletePlaylist$DeletePlaylistByPlayables0.c;
            }
            if((v & 8) != 0) {
                z1 = deletePlaylist$DeletePlaylistByPlayables0.d;
            }
            if((v & 16) != 0) {
                a0 = deletePlaylist$DeletePlaylistByPlayables0.e;
            }
            if((v & 0x20) != 0) {
                k0 = deletePlaylist$DeletePlaylistByPlayables0.f;
            }
            return deletePlaylist$DeletePlaylistByPlayables0.copy(playlistId0, list0, z, z1, a0, k0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DeletePlaylistByPlayables)) {
                return false;
            }
            if(this.a != ((DeletePlaylistByPlayables)object0).a) {
                return false;
            }
            if(!q.b(this.b, ((DeletePlaylistByPlayables)object0).b)) {
                return false;
            }
            if(this.c != ((DeletePlaylistByPlayables)object0).c) {
                return false;
            }
            if(this.d != ((DeletePlaylistByPlayables)object0).d) {
                return false;
            }
            return q.b(this.e, ((DeletePlaylistByPlayables)object0).e) ? q.b(this.f, ((DeletePlaylistByPlayables)object0).f) : false;
        }

        @NotNull
        public final k getAfterDeleteTask() {
            return this.f;
        }

        @NotNull
        public final a getBeforeDeleteTask() {
            return this.e;
        }

        public final boolean getConfirmBeforeDelete() {
            return this.d;
        }

        public final boolean getConfirmWhenOnSelectRepeat() {
            return this.c;
        }

        @NotNull
        public final List getPlayables() {
            return this.b;
        }

        @NotNull
        public final PlaylistId getPlaylistId() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.f.hashCode() + (this.e.hashCode() + d.e(d.e(d.d(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d)) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("DeletePlaylistByPlayables(playlistId=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", playables=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", confirmWhenOnSelectRepeat=");
            x.y(stringBuilder0, this.c, ", confirmBeforeDelete=", this.d, ", beforeDeleteTask=");
            stringBuilder0.append(this.e);
            stringBuilder0.append(", afterDeleteTask=");
            stringBuilder0.append(this.f);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007\u0012\b\b\u0002\u0010\t\u001A\u00020\u0007\u0012\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0014\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0016\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u000B0\nH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001C\u0010\u001B\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rH\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJd\u0010\u001D\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001A\u00020\u00072\b\b\u0002\u0010\t\u001A\u00020\u00072\u000E\b\u0002\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n2\u0014\b\u0002\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\rH\u00C6\u0001\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010 \u001A\u00020\u001FH\u00D6\u0001\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u0005H\u00D6\u0001\u00A2\u0006\u0004\b\"\u0010#J\u001A\u0010&\u001A\u00020\u00072\b\u0010%\u001A\u0004\u0018\u00010$H\u00D6\u0003\u00A2\u0006\u0004\b&\u0010\'R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b(\u0010)\u001A\u0004\b*\u0010\u0013R\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00A2\u0006\f\n\u0004\b+\u0010,\u001A\u0004\b-\u0010\u0015R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u0010\u0017R\u0017\u0010\t\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b1\u0010/\u001A\u0004\b2\u0010\u0017R\u001D\u0010\f\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8\u0006\u00A2\u0006\f\n\u0004\b3\u00104\u001A\u0004\b5\u0010\u001AR#\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000B0\r8\u0006\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u0010\u001C\u00A8\u00069"}, d2 = {"Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeleteViewModeDrawerPlaylist;", "Lcom/iloen/melon/player/playlist/common/DeletePlaylist;", "Lnc/a;", "viewModeDrawerPlaylist", "", "", "indices", "", "confirmWhenOnSelectRepeat", "confirmBeforeDelete", "Lkotlin/Function0;", "Lie/H;", "beforeDeleteTask", "Lkotlin/Function1;", "Loc/U;", "afterDeleteTask", "<init>", "(Lnc/a;Ljava/util/List;ZZLwe/a;Lwe/k;)V", "component1", "()Lnc/a;", "component2", "()Ljava/util/List;", "component3", "()Z", "component4", "component5", "()Lwe/a;", "component6", "()Lwe/k;", "copy", "(Lnc/a;Ljava/util/List;ZZLwe/a;Lwe/k;)Lcom/iloen/melon/player/playlist/common/DeletePlaylist$DeleteViewModeDrawerPlaylist;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lnc/a;", "getViewModeDrawerPlaylist", "b", "Ljava/util/List;", "getIndices", "c", "Z", "getConfirmWhenOnSelectRepeat", "d", "getConfirmBeforeDelete", "e", "Lwe/a;", "getBeforeDeleteTask", "f", "Lwe/k;", "getAfterDeleteTask", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DeleteViewModeDrawerPlaylist extends DeletePlaylist {
        public static final int $stable = 8;
        public final nc.a a;
        public final List b;
        public final boolean c;
        public final boolean d;
        public final a e;
        public final k f;

        public DeleteViewModeDrawerPlaylist(@NotNull nc.a a0, @NotNull List list0, boolean z, boolean z1, @NotNull a a1, @NotNull k k0) {
            q.g(a0, "viewModeDrawerPlaylist");
            q.g(list0, "indices");
            q.g(a1, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            super(null);
            this.a = a0;
            this.b = list0;
            this.c = z;
            this.d = z1;
            this.e = a1;
            this.f = k0;
        }

        public DeleteViewModeDrawerPlaylist(nc.a a0, List list0, boolean z, boolean z1, a a1, k k0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                z = true;
            }
            if((v & 8) != 0) {
                z1 = true;
            }
            if((v & 16) != 0) {
                a1 = new e(24);
            }
            if((v & 0x20) != 0) {
                k0 = new f(27);
            }
            this(a0, list0, z, z1, a1, k0);
        }

        @NotNull
        public final nc.a component1() {
            return this.a;
        }

        @NotNull
        public final List component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        public final boolean component4() {
            return this.d;
        }

        @NotNull
        public final a component5() {
            return this.e;
        }

        @NotNull
        public final k component6() {
            return this.f;
        }

        @NotNull
        public final DeleteViewModeDrawerPlaylist copy(@NotNull nc.a a0, @NotNull List list0, boolean z, boolean z1, @NotNull a a1, @NotNull k k0) {
            q.g(a0, "viewModeDrawerPlaylist");
            q.g(list0, "indices");
            q.g(a1, "beforeDeleteTask");
            q.g(k0, "afterDeleteTask");
            return new DeleteViewModeDrawerPlaylist(a0, list0, z, z1, a1, k0);
        }

        public static DeleteViewModeDrawerPlaylist copy$default(DeleteViewModeDrawerPlaylist deletePlaylist$DeleteViewModeDrawerPlaylist0, nc.a a0, List list0, boolean z, boolean z1, a a1, k k0, int v, Object object0) {
            if((v & 1) != 0) {
                a0 = deletePlaylist$DeleteViewModeDrawerPlaylist0.a;
            }
            if((v & 2) != 0) {
                list0 = deletePlaylist$DeleteViewModeDrawerPlaylist0.b;
            }
            if((v & 4) != 0) {
                z = deletePlaylist$DeleteViewModeDrawerPlaylist0.c;
            }
            if((v & 8) != 0) {
                z1 = deletePlaylist$DeleteViewModeDrawerPlaylist0.d;
            }
            if((v & 16) != 0) {
                a1 = deletePlaylist$DeleteViewModeDrawerPlaylist0.e;
            }
            if((v & 0x20) != 0) {
                k0 = deletePlaylist$DeleteViewModeDrawerPlaylist0.f;
            }
            return deletePlaylist$DeleteViewModeDrawerPlaylist0.copy(a0, list0, z, z1, a1, k0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DeleteViewModeDrawerPlaylist)) {
                return false;
            }
            if(!q.b(this.a, ((DeleteViewModeDrawerPlaylist)object0).a)) {
                return false;
            }
            if(!q.b(this.b, ((DeleteViewModeDrawerPlaylist)object0).b)) {
                return false;
            }
            if(this.c != ((DeleteViewModeDrawerPlaylist)object0).c) {
                return false;
            }
            if(this.d != ((DeleteViewModeDrawerPlaylist)object0).d) {
                return false;
            }
            return q.b(this.e, ((DeleteViewModeDrawerPlaylist)object0).e) ? q.b(this.f, ((DeleteViewModeDrawerPlaylist)object0).f) : false;
        }

        @NotNull
        public final k getAfterDeleteTask() {
            return this.f;
        }

        @NotNull
        public final a getBeforeDeleteTask() {
            return this.e;
        }

        public final boolean getConfirmBeforeDelete() {
            return this.d;
        }

        public final boolean getConfirmWhenOnSelectRepeat() {
            return this.c;
        }

        @NotNull
        public final List getIndices() {
            return this.b;
        }

        @NotNull
        public final nc.a getViewModeDrawerPlaylist() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.f.hashCode() + (this.e.hashCode() + d.e(d.e(d.d(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d)) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("DeleteViewModeDrawerPlaylist(viewModeDrawerPlaylist=");
            stringBuilder0.append(this.a);
            stringBuilder0.append(", indices=");
            stringBuilder0.append(this.b);
            stringBuilder0.append(", confirmWhenOnSelectRepeat=");
            x.y(stringBuilder0, this.c, ", confirmBeforeDelete=", this.d, ", beforeDeleteTask=");
            stringBuilder0.append(this.e);
            stringBuilder0.append(", afterDeleteTask=");
            stringBuilder0.append(this.f);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    public static final int $stable;

    public DeletePlaylist(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

