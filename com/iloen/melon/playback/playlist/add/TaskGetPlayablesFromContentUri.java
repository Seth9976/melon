package com.iloen.melon.playback.playlist.add;

import G8.g;
import H8.k;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.Song;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.cipher.Base62UUID;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.ui.CursorUtil;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import je.w;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;
import z6.f;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u000BJ\u0018\u0010\f\u001A\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0003J\u0012\u0010\u000F\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\u000EH\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/playback/playlist/add/TaskGetPlayablesFromContentUri;", "", "mediaUri", "Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "log", "Lcom/iloen/melon/utils/log/LogU;", "execute", "", "Lcom/iloen/melon/playback/Playable;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getListFromMediaStoreCursor", "c", "Landroid/database/Cursor;", "fromMediaStoreCursor", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TaskGetPlayablesFromContentUri {
    public static final int $stable = 8;
    @NotNull
    private final LogU log;
    @NotNull
    private final Uri mediaUri;

    public TaskGetPlayablesFromContentUri(@NotNull Uri uri0) {
        q.g(uri0, "mediaUri");
        super();
        this.mediaUri = uri0;
        this.log = new LogU("TaskGetPlayablesFromContentUri");
    }

    @Nullable
    public final Object execute(@NotNull Continuation continuation0) {
        LogU.debug$default(this.log, "getAddPlayableListInfo() mediaUri: " + this.mediaUri, null, false, 6, null);
        return "content".equals(this.mediaUri.getScheme()) ? BuildersKt.withContext(Dispatchers.getIO(), new n(null) {
            int label;

            {
                TaskGetPlayablesFromContentUri.this = taskGetPlayablesFromContentUri0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromContentUri.execute.2(TaskGetPlayablesFromContentUri.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.playlist.add.TaskGetPlayablesFromContentUri.execute.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Cursor cursor0;
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                try {
                    MelonAppBase.Companion.getClass();
                    cursor0 = t.a().getContext().getContentResolver().query(TaskGetPlayablesFromContentUri.this.mediaUri, null, null, null, null);
                }
                catch(Exception exception0) {
                    LogU.warn$default(TaskGetPlayablesFromContentUri.this.log, "query exception " + exception0, null, false, 6, null);
                    cursor0 = null;
                }
                if(cursor0 != null) {
                    cursor0.moveToFirst();
                }
                return TaskGetPlayablesFromContentUri.this.getListFromMediaStoreCursor(cursor0);
            }
        }, continuation0) : w.a;
    }

    private final Playable fromMediaStoreCursor(Cursor cursor0) {
        k k0;
        String s8;
        String s7;
        if(cursor0 == null || cursor0.isClosed()) {
            q.f(Playable.EMPTY, "EMPTY");
            return Playable.EMPTY;
        }
        try {
            int v = cursor0.getColumnIndex("_data");
            int v1 = cursor0.getColumnIndex("title");
            int v2 = cursor0.getColumnIndex("artist");
            int v3 = cursor0.getColumnIndex("artist_id");
            int v4 = cursor0.getColumnIndex("album");
            int v5 = cursor0.getColumnIndex("album_id");
            int v6 = cursor0.getColumnIndex("duration");
            int v7 = cursor0.getColumnIndex("_display_name");
            int v8 = cursor0.getColumnIndex("_id");
            if(v < 0) {
                q.f(Playable.EMPTY, "EMPTY");
                return Playable.EMPTY;
            }
            String s = "";
            String s1 = cursor0.getString(v);
            String s2 = v1 < 0 ? "" : cursor0.getString(v1);
            if(FilenameUtils.isDcf(s1)) {
                s2 = StringUtils.getTitleForDCF(s2);
            }
            long v9 = cursor0.getLong(v6);
            String s3 = cursor0.getString(v2);
            StringIds stringIds0 = v3 == -1 ? StringIds.a : StringIds.e(cursor0.getString(v3));
            String s4 = cursor0.getString(v4);
            long v10 = v5 < 0 ? -1L : cursor0.getLong(v5);
            String s5 = cursor0.getString(v7);
            CType cType0 = CType.SONG;
            String s6 = cursor0.getString(v8);
            long v11 = cursor0.getLong(v8);
            if(StorageUtils.isScopedStorage()) {
                s7 = CursorUtil.getAudioContentUri(v11).toString();
                q.f(s7, "toString(...)");
            }
            else {
                s7 = "";
            }
            int v12 = cursor0.getColumnIndex("audio_id1");
            long v13 = v12 == -1 ? -1L : cursor0.getLong(v12);
            if(v12 == -1 || v13 == -1L) {
                v12 = cursor0.getColumnIndex("audio_id2");
            }
            if(v12 != -1 && v13 == -1L) {
                v13 = cursor0.getLong(v12);
            }
            if(v12 == -1 || v13 == -1L) {
                v12 = cursor0.getColumnIndex("_id");
            }
            if(v12 != -1 && v13 == -1L) {
                v13 = cursor0.getLong(v12);
            }
            if(v12 == -1 || v13 == -1L) {
                v12 = cursor0.getColumnIndex("_id2");
            }
            if(v12 != -1 && v13 == -1L) {
                v13 = cursor0.getLong(v12);
            }
            if(v13 != -1L && MusicUtils.isEducationContents(s1)) {
                cType0 = CType.EDU;
            }
            Song song0 = Song.f(s1, true);
            if(song0 == null) {
                s8 = "";
            }
            else {
                s8 = song0.b;
                if(TextUtils.isEmpty(s8)) {
                    s8 = "";
                }
            }
            Playable playable0 = Playable.newBuilder(1).isMelonSong(!TextUtils.isEmpty(s8)).data(s1).uriString(s7).songIdTitle(s8, s2).artists(StringUtils.makeArtistMap(stringIds0, s3)).albumName(s4).mediaStoreAlbumId(v10).duration(v9).displayName(s5).cType(cType0).menuId("").originMenuId("").hasMv(0).isAdult(0).dbContentId(s6).trackId(Base62UUID.randomUUID()).build();
            boolean z = StorageUtils.isScopedStorage();
            f f0 = g.a;
            if(z) {
                q.f("", "getUriString(...)");
                q.f("", "getData(...)");
                f0.m();
                Uri uri0 = Uri.parse("");
                q.f(uri0, "parse(...)");
                k0 = g.j(uri0);
            }
            else {
                f0.m();
                q.f("", "getData(...)");
                k0 = g.k("");
            }
            LogU.debug$default(this.log, "localContent " + k0, null, false, 6, null);
            if(k0 != null) {
                playable0.setMediaStoreAlbumId(k0.w);
                playable0.setLocalAlbumKey(k0.p);
            }
            if(StorageUtils.isScopedStorage()) {
                q.f("", "getUriString(...)");
                if(k0 != null) {
                    String s9 = k0.c;
                    if(s9 != null) {
                        s = s9;
                    }
                }
                playable0.setUriString(s);
            }
            q.d(playable0);
            return playable0;
        }
        catch(IllegalStateException unused_ex) {
            q.f(Playable.EMPTY, "EMPTY");
            return Playable.EMPTY;
        }
    }

    private final List getListFromMediaStoreCursor(Cursor cursor0) {
        List list0 = new ArrayList();
        if(cursor0 != null && cursor0.moveToFirst()) {
            while(true) {
                Playable playable0 = this.fromMediaStoreCursor(cursor0);
                if(!q.b(Playable.EMPTY, playable0)) {
                    list0.add(playable0);
                }
                if(!cursor0.moveToNext()) {
                    break;
                }
            }
        }
        LogU.debug$default(this.log, "getListFromLocalCursor() size: " + list0.size(), null, false, 6, null);
        return list0;
    }
}

