package com.iloen.melon.fragments.searchandadd;

import androidx.lifecycle.K;
import androidx.lifecycle.L;
import androidx.lifecycle.m0;
import java.util.ArrayList;
import java.util.Iterator;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0003J)\u0010\n\u001A\u00020\u00042\u001A\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u00A2\u0006\u0004\b\n\u0010\u000BJ)\u0010\f\u001A\u00020\u00042\u001A\u0010\t\u001A\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u00A2\u0006\u0004\b\f\u0010\u000BJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0011\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001A\u00020\u000E2\u0016\u0010\t\u001A\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00A2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0015\u001A\u00020\u00042\u0016\u0010\t\u001A\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u00A2\u0006\u0004\b\u0015\u0010\u000BJ\u0015\u0010\u0016\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u0007\u00A2\u0006\u0004\b\u0016\u0010\u0010J\r\u0010\u0017\u001A\u00020\u0004\u00A2\u0006\u0004\b\u0017\u0010\u0003R.\u0010\u0019\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0019\u0010\u001AR.\u0010\u001B\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0\u00188\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001B\u0010\u001AR$\u0010\u001C\u001A\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F\"\u0004\b \u0010\u0012R+\u0010$\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0!8F\u00A2\u0006\u0006\u001A\u0004\b\"\u0010#R+\u0010&\u001A\u001C\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b0!8F\u00A2\u0006\u0006\u001A\u0004\b%\u0010#\u00A8\u0006("}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "Landroidx/lifecycle/m0;", "<init>", "()V", "Lie/H;", "onCleared", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "newSongList", "setSongList", "(Ljava/util/ArrayList;)V", "setLastAddedSongList", "songId", "", "addSong", "(Ljava/lang/String;)Z", "removeSong", "(Ljava/lang/String;)V", "addSongList", "(Ljava/util/ArrayList;)Z", "removeSongList", "containsSongId", "clearData", "Landroidx/lifecycle/L;", "_songList", "Landroidx/lifecycle/L;", "_lastAddedSongList", "overSelectMessage", "Ljava/lang/String;", "getOverSelectMessage", "()Ljava/lang/String;", "setOverSelectMessage", "Landroidx/lifecycle/K;", "getSongList", "()Landroidx/lifecycle/K;", "songList", "getLastAddedSongList", "lastAddedSongList", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchViewModel extends m0 {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel$Companion;", "", "<init>", "()V", "LAST_ADDED_SONG_LIMIT", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int LAST_ADDED_SONG_LIMIT = 10;
    @NotNull
    private final L _lastAddedSongList;
    @NotNull
    private final L _songList;
    @Nullable
    private String overSelectMessage;

    static {
        PlaylistSearchViewModel.Companion = new Companion(null);
        PlaylistSearchViewModel.$stable = 8;
    }

    public PlaylistSearchViewModel() {
        this._songList = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
        this._lastAddedSongList = new L();  // 初始化器: Landroidx/lifecycle/K;-><init>()V
    }

    public final boolean addSong(@NotNull String s) {
        q.g(s, "songId");
        ArrayList arrayList0 = (ArrayList)this.getSongList().getValue();
        if(arrayList0 != null && !this.containsSongId(s) && arrayList0.size() < 1000) {
            ArrayList arrayList1 = (ArrayList)this.getSongList().getValue();
            if(arrayList1 != null) {
                arrayList1.add(0, s);
            }
            Object object0 = this.getSongList().getValue();
            this._songList.setValue(object0);
            ArrayList arrayList2 = (ArrayList)this.getLastAddedSongList().getValue();
            if(arrayList2 != null && !arrayList2.contains(s)) {
                if(arrayList2.size() > 9) {
                    arrayList2.remove(9);
                }
                arrayList2.add(0, s);
            }
            return true;
        }
        return false;
    }

    public final boolean addSongList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "newSongList");
        ArrayList arrayList1 = (ArrayList)this.getSongList().getValue();
        if(arrayList1 != null) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            int v = 0;
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                q.f(object0, "next(...)");
                if(arrayList1.contains(((String)object0))) {
                    ++v;
                }
            }
            if(arrayList0.size() - v + arrayList1.size() <= 1000) {
                for(Object object1: p.C0(arrayList0)) {
                    String s = (String)object1;
                    if(!arrayList1.contains(s)) {
                        arrayList1.add(0, s);
                    }
                }
                Object object2 = this.getSongList().getValue();
                this._songList.setValue(object2);
                return true;
            }
        }
        return false;
    }

    public final void clearData() {
        ArrayList arrayList0 = (ArrayList)this._songList.getValue();
        if(arrayList0 != null) {
            arrayList0.clear();
        }
        ArrayList arrayList1 = (ArrayList)this._lastAddedSongList.getValue();
        if(arrayList1 != null) {
            arrayList1.clear();
        }
    }

    public final boolean containsSongId(@NotNull String s) {
        q.g(s, "songId");
        ArrayList arrayList0 = (ArrayList)this.getSongList().getValue();
        return arrayList0 == null ? false : arrayList0.contains(s);
    }

    @NotNull
    public final K getLastAddedSongList() {
        return this._lastAddedSongList;
    }

    @Nullable
    public final String getOverSelectMessage() {
        return this.overSelectMessage;
    }

    @NotNull
    public final K getSongList() {
        return this._songList;
    }

    @Override  // androidx.lifecycle.m0
    public void onCleared() {
        this.clearData();
    }

    public final void removeSong(@NotNull String s) {
        q.g(s, "songId");
        if(this.containsSongId(s)) {
            ArrayList arrayList0 = (ArrayList)this.getSongList().getValue();
            if(arrayList0 != null) {
                arrayList0.remove(s);
            }
            Object object0 = this.getSongList().getValue();
            this._songList.setValue(object0);
        }
    }

    public final void removeSongList(@NotNull ArrayList arrayList0) {
        q.g(arrayList0, "newSongList");
        ArrayList arrayList1 = (ArrayList)this.getSongList().getValue();
        if(arrayList1 != null) {
            arrayList1.removeAll(arrayList0);
        }
        Object object0 = this.getSongList().getValue();
        this._songList.setValue(object0);
    }

    public final void setLastAddedSongList(@Nullable ArrayList arrayList0) {
        this._lastAddedSongList.postValue(arrayList0);
    }

    public final void setOverSelectMessage(@Nullable String s) {
        this.overSelectMessage = s;
    }

    public final void setSongList(@Nullable ArrayList arrayList0) {
        this._songList.postValue(arrayList0);
    }
}

