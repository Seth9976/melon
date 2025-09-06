package com.iloen.melon.fragments.local;

import B.a;
import G8.g;
import I8.e;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.adapters.common.MelonCursorAdapter;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.add.AddAction.Add;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddPlayableList;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.popup.ContextListPopup;
import com.iloen.melon.types.ContextItemInfo.Params;
import com.iloen.melon.types.ContextItemInfo;
import com.iloen.melon.types.ContextItemType;
import com.iloen.melon.utils.ContextListItemBuilder;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ArrayListCursor;
import com.iloen.melon.utils.ui.CursorUtil;
import com.iloen.melon.utils.ui.ViewUtils;
import i9.k;
import java.io.File;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.c;
import v9.h;
import v9.i;
import x8.f;

@Metadata(d1 = {"\u0000\u00A2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 c2\u00020\u0001:\u0007defghicB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\n\u0010\u000BJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0015\u001A\u00020\t2\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0007H\u0016\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0018\u001A\u00020\u0017H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001B\u0010\u001D\u001A\u0006\u0012\u0002\b\u00030\u001C2\u0006\u0010\u001B\u001A\u00020\u001AH\u0014\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\'\u0010&\u001A\u00020%2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010\"\u001A\u00020!2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J5\u0010-\u001A\u00020%2\f\u0010(\u001A\b\u0012\u0002\b\u0003\u0018\u00010\u001C2\u0006\u0010)\u001A\u00020\u00112\u0006\u0010+\u001A\u00020*2\u0006\u0010,\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u001F\u00101\u001A\u00020%2\b\u0010/\u001A\u0004\u0018\u00010#2\u0006\u00100\u001A\u00020%\u00A2\u0006\u0004\b1\u00102J\r\u00103\u001A\u00020\t\u00A2\u0006\u0004\b3\u0010\u0003J\u0017\u00105\u001A\u00020\t2\u0006\u00104\u001A\u00020#H\u0016\u00A2\u0006\u0004\b5\u00106J\u0017\u00109\u001A\u00020\t2\u0006\u00108\u001A\u000207H\u0014\u00A2\u0006\u0004\b9\u0010:J\u000F\u0010;\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b;\u0010\u0003J\u000F\u0010<\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b<\u0010\u0003J\u0019\u0010?\u001A\u00020\t2\b\u0010>\u001A\u0004\u0018\u00010=H\u0002\u00A2\u0006\u0004\b?\u0010@J]\u0010F\u001A6\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002070Dj\b\u0012\u0004\u0012\u000207`E\u0018\u00010Dj\u001A\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002070Dj\b\u0012\u0004\u0012\u000207`E\u0018\u0001`E2\b\u0010A\u001A\u0004\u0018\u00010=2\u000E\u0010C\u001A\n\u0012\u0004\u0012\u00020=\u0018\u00010BH\u0002\u00A2\u0006\u0004\bF\u0010GJ\u000F\u0010I\u001A\u00020HH\u0002\u00A2\u0006\u0004\bI\u0010JJ\u0019\u0010L\u001A\u00020\t2\b\u0010K\u001A\u0004\u0018\u00010HH\u0002\u00A2\u0006\u0004\bL\u0010MJ\u0017\u0010N\u001A\u00020%2\u0006\u0010,\u001A\u00020*H\u0002\u00A2\u0006\u0004\bN\u0010OJ!\u0010R\u001A\u00020\t2\b\u0010P\u001A\u0004\u0018\u00010#2\u0006\u0010Q\u001A\u00020%H\u0002\u00A2\u0006\u0004\bR\u0010SJ\u001F\u0010W\u001A\u00020\t2\u0006\u0010U\u001A\u00020T2\u0006\u0010V\u001A\u00020#H\u0002\u00A2\u0006\u0004\bW\u0010XR$\u0010Y\u001A\u0012\u0012\u0004\u0012\u00020#0Dj\b\u0012\u0004\u0012\u00020#`E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001A\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001A\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001A\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b_\u0010\\R\u0014\u0010`\u001A\u00020%8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b`\u0010aR\u0014\u0010b\u001A\u00020%8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bb\u0010a\u00A8\u0006j"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "adapter", "childView", "", "rawPosition", "position", "onRecyclerViewItemClick", "(Landroidx/recyclerview/widget/j0;Landroid/view/View;II)Z", "filename", "withMV", "isFile", "(Ljava/lang/String;Z)Z", "goToHome", "playlistId", "onAddSongsToLocalPlaylist", "(Ljava/lang/String;)V", "", "userData", "onAddToNowPlayingList", "(Ljava/lang/Object;)V", "notifyChange", "goToUpFolder", "Ljava/io/File;", "aDirectory", "browseTo", "(Ljava/io/File;)V", "parent", "", "files", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFileList", "(Ljava/io/File;[Ljava/io/File;)Ljava/util/ArrayList;", "Landroid/database/Cursor;", "fetchData", "()Landroid/database/Cursor;", "cursor", "goToDir", "(Landroid/database/Cursor;)V", "showLocalFolderPopup", "(I)Z", "clickFile", "play", "scanFolder", "(Ljava/lang/String;Z)V", "Lcom/iloen/melon/utils/ContextListItemBuilder;", "builder", "title", "showContextListPopup", "(Lcom/iloen/melon/utils/ContextListItemBuilder;Ljava/lang/String;)V", "mFolderHistory", "Ljava/util/ArrayList;", "mCurrentDirectory", "Ljava/io/File;", "mSelectedPath", "Ljava/lang/String;", "mDirectoryFile", "isHomeDir", "()Z", "isTopDir", "Companion", "BrowseCoroutineAsync", "StringComparator", "ScanFileCoroutineAsync", "AddPlaylistSongFolderCoroutineAsync", "LocalFolderListAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalFolderListFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0019\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000BJ\u001C\u0010\r\u001A\u0004\u0018\u00010\u00032\b\u0010\f\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0010\u001A\u00020\t2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0014\u0010\u0006\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$AddPlaylistSongFolderCoroutineAsync;", "Lx8/f;", "Ljava/lang/Void;", "", "", "mClickFile", "mPlaylistId", "<init>", "(Lcom/iloen/melon/fragments/local/LocalFolderListFragment;Ljava/lang/String;Ljava/lang/String;)V", "Lie/H;", "preTask", "()V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "postTask", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AddPlaylistSongFolderCoroutineAsync extends f {
        @Nullable
        private final String mClickFile;
        @NotNull
        private final String mPlaylistId;

        public AddPlaylistSongFolderCoroutineAsync(@Nullable String s, @NotNull String s1) {
            q.g(s1, "mPlaylistId");
            LocalFolderListFragment.this = localFolderListFragment0;
            super();
            this.mClickFile = s;
            this.mPlaylistId = s1;
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        @Nullable
        public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
            Cursor cursor0;
            StringBuilder stringBuilder0 = new StringBuilder();
            if(LocalFolderListFragment.this.isFile(this.mClickFile, false)) {
                stringBuilder0.append("title != \'\' AND _data= \'");
                q.d(this.mClickFile);
                stringBuilder0.append(StringUtils.replacePathString(this.mClickFile));
                stringBuilder0.append("\'");
                cursor0 = MusicUtils.isMelonDCFContents(this.mClickFile) ? MusicUtils.query(LocalFolderListFragment.this.getContext(), k.a, LocalFolderListFragment.sCursorCols, stringBuilder0.toString(), null, "title") : MusicUtils.query(LocalFolderListFragment.this.getContext(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, LocalFolderListFragment.sCursorCols, stringBuilder0.toString(), null, "title");
                if(cursor0 == null) {
                    goto label_46;
                }
                cursor0.moveToFirst();
                Y.t("cursor.getCount()", cursor0.getCount(), LogU.Companion, "LocalFolderListFragment");
                goto label_46;
            }
            ArrayList arrayList0 = new ArrayList();
            File file0 = LocalFolderListFragment.this.mDirectoryFile;
            q.d(file0);
            File[] arr_file = file0.listFiles(new t(LocalFolderListFragment.this, 0));
            stringBuilder0.append("title != \'\' AND ");
            int v1 = 0;
            while(v1 < arr_file.length) {
                File file1 = LocalFolderListFragment.this.mDirectoryFile;
                q.d(file1);
                arrayList0.add(file1.getPath() + "/" + arr_file[v1].getName());
                stringBuilder0.append("_data= \'");
                String s = arr_file[v1].getPath();
                q.f(s, "getPath(...)");
                stringBuilder0.append(StringUtils.replacePathString(s));
                stringBuilder0.append("\'");
                ++v1;
                if(v1 != arr_file.length) {
                    stringBuilder0.append(" OR ");
                }
            }
            if(arr_file.length != 0) {
                Cursor cursor1 = MusicUtils.query(LocalFolderListFragment.this.getContext(), MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, LocalFolderListFragment.sCursorCols, stringBuilder0.toString(), null, "_data");
                if(!R8.q.a.c()) {
                    Context context0 = LocalFolderListFragment.this.getContext();
                    cursor0 = CursorUtil.mergeTrackCursor((context0 == null ? null : context0.getContentResolver()), cursor1, null, LocalFolderListFragment.sCursorCols, LocalFolderListFragment.sCursorColsType, "_data");
                    if(cursor0 != null && cursor0.getCount() > 0) {
                        cursor0.moveToFirst();
                        goto label_44;
                    }
                    return new Integer(-1);
                }
                Cursor cursor2 = MusicUtils.query(LocalFolderListFragment.this.getContext(), k.a, LocalFolderListFragment.sCursorCols, stringBuilder0.toString(), null, "_data");
                Context context1 = LocalFolderListFragment.this.getContext();
                cursor0 = CursorUtil.mergeTrackCursor((context1 == null ? null : context1.getContentResolver()), cursor1, cursor2, LocalFolderListFragment.sCursorCols, LocalFolderListFragment.sCursorColsType, "_data");
                if(cursor0 != null && cursor0.getCount() != 0) {
                label_44:
                    cursor0.moveToFirst();
                    Y.t("cursor.getCount()=", cursor0.getCount(), LogU.Companion, "LocalFolderListFragment");
                label_46:
                    if(cursor0 != null) {
                        ArrayList arrayList1 = new ArrayList();
                        int v2 = cursor0.getCount();
                        for(int v = 0; v < v2; ++v) {
                            arrayList1.add(new Integer(v));
                        }
                        int v3 = Integer.parseInt(this.mPlaylistId);
                        LocalFolderListFragment.this.addToLocalPlaylist(cursor0, null, v3, true);
                        return new Integer(1);
                    }
                    return new Integer(-1);
                }
                return new Integer(-1);
            }
            return new Integer(-1);
        }

        private static final boolean backgroundWork$lambda$0(LocalFolderListFragment localFolderListFragment0, File file0, String s) {
            return localFolderListFragment0.isFile(s, false);
        }

        public void postTask(@Nullable Integer integer0) {
            super.postTask(integer0);
            LocalFolderListFragment.this.showProgress(false);
            if(integer0 != null && ((int)integer0) == -1) {
                ToastManager.show(LocalFolderListFragment.this.getString(0x7F13050B));  // string:localplaylist_no_file_in_directory "디렉토리에 파일이 존재하지 않습니다."
            }
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Integer)object0));
        }

        @Override  // x8.f
        public void preTask() {
            super.preTask();
            LocalFolderListFragment.this.showProgress(true);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0011\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u001A\u0010\f\u001A\u00020\u00032\b\u0010\u000B\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000F\u001A\u00020\b2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$BrowseCoroutineAsync;", "Lx8/f;", "Ljava/lang/Void;", "Landroid/database/Cursor;", "Ljava/io/File;", "mDirectory", "<init>", "(Lcom/iloen/melon/fragments/local/LocalFolderListFragment;Ljava/io/File;)V", "Lie/H;", "preTask", "()V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cursor", "postTask", "(Landroid/database/Cursor;)V", "Ljava/io/File;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class BrowseCoroutineAsync extends f {
        @Nullable
        private final File mDirectory;

        public BrowseCoroutineAsync(@Nullable File file0) {
            this.mDirectory = file0;
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        @Nullable
        public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
            return this.mDirectory == null ? new ArrayListCursor(LocalFolderListFragment.sFileCursorCols, LocalFolderListFragment.this.getFileList(null, null)) : new ArrayListCursor(LocalFolderListFragment.sFileCursorCols, LocalFolderListFragment.this.getFileList(this.mDirectory, this.mDirectory.listFiles()));
        }

        public void postTask(@Nullable Cursor cursor0) {
            super.postTask(cursor0);
            if(!LocalFolderListFragment.this.isFragmentValid()) {
                return;
            }
            LocalFolderListFragment.this.showProgress(false);
            Object object0 = LocalFolderListFragment.this.mFolderHistory.get(LocalFolderListFragment.this.mFolderHistory.size() - 1);
            LogU.Companion.d("LocalFolderListFragment", this.mDirectory + ", " + object0);
            if(LocalFolderListFragment.this.mFolderHistory.size() == 0) {
                LocalFolderListFragment.this.mFolderHistory.add(String.valueOf(this.mDirectory));
            }
            else {
                Object object1 = LocalFolderListFragment.this.mFolderHistory.get(LocalFolderListFragment.this.mFolderHistory.size() - 1);
                if(!String.valueOf(this.mDirectory).equals(object1)) {
                    LocalFolderListFragment.this.mFolderHistory.add(String.valueOf(this.mDirectory));
                }
            }
            LocalFolderListFragment.this.mCurrentDirectory = this.mDirectory;
            File file0 = LocalFolderListFragment.this.mCurrentDirectory;
            MelonSettingInfo.setLastOpenedFolder((file0 == null ? null : file0.getPath()));
            LocalFolderListFragment.this.changeCursor(cursor0);
            LocalFolderListFragment.this.notifyChange();
            LocalFolderListFragment.this.performFetchCompleteOnlyViews();
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Cursor)object0));
        }

        @Override  // x8.f
        public void preTask() {
            super.preTask();
            LocalFolderListFragment.this.showProgress(true);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001A\u00020\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u000BX\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000FR\u001A\u0010\u0010\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u0016\u0010\u0013\u001A\b\u0012\u0004\u0012\u00020\u00050\u000EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000F¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$Companion;", "", "<init>", "()V", "TAG", "", "TOP_DIR", "MELON_HOME_DIR", "COL_TYPE", "COL_NAME", "TYPE_FOLDER", "", "TYPE_FILE", "sCursorCols", "", "[Ljava/lang/String;", "sCursorColsType", "Ljava/lang/Class;", "[Ljava/lang/Class;", "sFileCursorCols", "newInstance", "Lcom/iloen/melon/fragments/local/LocalFolderListFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalFolderListFragment newInstance() {
            LocalFolderListFragment localFolderListFragment0 = new LocalFolderListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putInt("argFragmentTitle", 0x7F131042);  // string:title_folder "폴더"
            localFolderListFragment0.setArguments(bundle0);
            return localFolderListFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001B\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000E\u001A\u00020\t2\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000E\u0010\u000FJ\u001F\u0010\u0013\u001A\u00020\u00022\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0017\u001A\u00020\u00162\b\u0010\u0015\u001A\u0004\u0018\u00010\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u00052\u0006\u0010\f\u001A\u00020\t2\u0006\u0010\r\u001A\u00020\tH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\u0006\u0010\u0019\u001A\u00020\tH\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010\u001F\u001A\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001F\u0010\u001ER\u0014\u0010 \u001A\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010\u001ER\u0014\u0010!\u001A\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\u001E¨\u0006\""}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$LocalFolderListAdapter;", "Lcom/iloen/melon/adapters/common/MelonCursorAdapter;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Landroid/database/Cursor;", "cursor", "<init>", "(Lcom/iloen/melon/fragments/local/LocalFolderListFragment;Landroid/content/Context;Landroid/database/Cursor;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;Landroid/database/Cursor;II)V", "cursorPosition", "", "getCursorItem", "(I)Ljava/lang/Object;", "HOME", "I", "PARENT", "PATH", "FOLDER_OR_FILE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalFolderListAdapter extends MelonCursorAdapter {
        private final int FOLDER_OR_FILE;
        private final int HOME;
        private final int PARENT;
        private final int PATH;

        public LocalFolderListAdapter(@Nullable Context context0, @Nullable Cursor cursor0) {
            super(context0, cursor0);
            this.PARENT = 1;
            this.PATH = 2;
            this.FOLDER_OR_FILE = 3;
        }

        @Override  // com.iloen.melon.adapters.common.r
        @Nullable
        public Object getCursorItem(int v) {
            return null;
        }

        @Override  // com.iloen.melon.adapters.common.MelonCursorAdapter
        public int getHeaderViewItemCount() {
            return 3;
        }

        @Override  // com.iloen.melon.adapters.common.MelonCursorAdapter
        public int getItemViewTypeImpl(int v, int v1) {
            int v2 = this.getAvailableHeaderPosition();
            if(v2 == v) {
                return this.HOME;
            }
            if(v2 + 1 == v) {
                return this.PARENT;
            }
            return v2 + 2 == v ? this.PATH : this.FOLDER_OR_FILE;
        }

        @Override  // com.iloen.melon.adapters.common.MelonCursorAdapter
        public void onBindViewImpl(@Nullable O0 o00, @Nullable Cursor cursor0, int v, int v1) {
            if(cursor0 != null) {
                ViewHolder localFolderListFragment$ViewHolder0 = o00 instanceof ViewHolder ? ((ViewHolder)o00) : null;
                if(localFolderListFragment$ViewHolder0 != null) {
                    int v2 = ((ViewHolder)o00).getItemViewType();
                    if(this.HOME == v2) {
                        boolean z = LocalFolderListFragment.this.isHomeDir();
                        ViewUtils.setEnable(localFolderListFragment$ViewHolder0.getLayout(), !z);
                        ImageView imageView0 = localFolderListFragment$ViewHolder0.getIcon();
                        if(imageView0 != null) {
                            imageView0.setImageResource(0x7F080586);  // drawable:ic_my_list_home
                        }
                        TextView textView0 = localFolderListFragment$ViewHolder0.getTitle();
                        if(textView0 != null) {
                            textView0.setText(0x7F13043F);  // string:folder_browser_string_home "홈"
                        }
                        if(!z) {
                            ViewUtils.setOnClickListener(localFolderListFragment$ViewHolder0.getLayout(), new u(LocalFolderListFragment.this, 0));
                            return;
                        }
                        localFolderListFragment$ViewHolder0.getLayout().setOnTouchListener(null);
                        return;
                    }
                    if(this.PARENT == v2) {
                        ViewUtils.setEnable(localFolderListFragment$ViewHolder0.getLayout(), !LocalFolderListFragment.this.isTopDir());
                        ImageView imageView1 = localFolderListFragment$ViewHolder0.getIcon();
                        if(imageView1 != null) {
                            imageView1.setImageResource(0x7F080585);  // drawable:ic_my_list_folder
                        }
                        TextView textView1 = localFolderListFragment$ViewHolder0.getTitle();
                        if(textView1 != null) {
                            textView1.setText(0x7F130440);  // string:folder_browser_string_upfolder "상위"
                        }
                        ViewUtils.setOnClickListener(localFolderListFragment$ViewHolder0.getLayout(), new u(LocalFolderListFragment.this, 1));
                        return;
                    }
                    if(this.PATH == v2) {
                        localFolderListFragment$ViewHolder0.getLayout().setOnTouchListener(null);
                        localFolderListFragment$ViewHolder0.itemView.setBackgroundResource(0x7F060142);  // color:gray030s
                        TextView textView2 = localFolderListFragment$ViewHolder0.getTitle();
                        if(textView2 != null) {
                            File file0 = LocalFolderListFragment.this.mCurrentDirectory;
                            q.d(file0);
                            textView2.setText(file0.getPath());
                        }
                    }
                    else {
                        ViewUtils.setOnClickListener(localFolderListFragment$ViewHolder0.getLayout(), new com.iloen.melon.fragments.local.f(LocalFolderListFragment.this, v, 3));
                        ViewUtils.setOnLongClickListener(localFolderListFragment$ViewHolder0.getLayout(), new j(LocalFolderListFragment.this, v1, 1));
                        if(localFolderListFragment$ViewHolder0.getIcon() != null) {
                            boolean z1 = false;
                            int v3 = cursor0.getInt(0);
                            ImageView imageView2 = localFolderListFragment$ViewHolder0.getIcon();
                            if(v3 == 0) {
                                z1 = true;
                            }
                            ViewUtils.showWhen(imageView2, z1);
                            if(v3 == 0) {
                                ImageView imageView3 = localFolderListFragment$ViewHolder0.getIcon();
                                if(imageView3 != null) {
                                    imageView3.setImageResource(0x7F080580);  // drawable:ic_my_folder
                                }
                            }
                        }
                        if(localFolderListFragment$ViewHolder0.getTitle() != null) {
                            TextView textView3 = localFolderListFragment$ViewHolder0.getTitle();
                            if(textView3 != null) {
                                textView3.setText(cursor0.getString(1));
                            }
                        }
                    }
                }
            }
        }

        private static final void onBindViewImpl$lambda$0(LocalFolderListFragment localFolderListFragment0, View view0) {
            localFolderListFragment0.goToHome();
        }

        private static final void onBindViewImpl$lambda$1(LocalFolderListFragment localFolderListFragment0, View view0) {
            localFolderListFragment0.goToUpFolder();
        }

        private static final void onBindViewImpl$lambda$2(LocalFolderListFragment localFolderListFragment0, int v, View view0) {
            localFolderListFragment0.onItemClick(view0, v);
        }

        private static final boolean onBindViewImpl$lambda$3(LocalFolderListFragment localFolderListFragment0, int v, View view0) {
            localFolderListFragment0.showLocalFolderPopup(v);
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.MelonCursorAdapter
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            int v1;
            q.g(viewGroup0, "parent");
            if(this.HOME == v || this.PARENT == v) {
                v1 = 0x7F0D0025;  // layout:adapter_local_folder_header
            }
            else if(this.PATH == v) {
                v1 = 0x7F0D0027;  // layout:adapter_local_folder_path
            }
            else {
                v1 = 0x7F0D0026;  // layout:adapter_local_folder_item
            }
            View view0 = LayoutInflater.from(this.getContext()).inflate(v1, viewGroup0, false);
            q.f(view0, "inflate(...)");
            return new ViewHolder(view0);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0019\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u001A\u0010\u000E\u001A\u00020\u00032\b\u0010\r\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u000E\u0010\u000FJ\u0019\u0010\u0011\u001A\u00020\n2\b\u0010\u0010\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$ScanFileCoroutineAsync;", "Lx8/f;", "Ljava/lang/Void;", "", "", "clickFilePath", "", "isPlay", "<init>", "(Lcom/iloen/melon/fragments/local/LocalFolderListFragment;Ljava/lang/String;Z)V", "Lie/H;", "preTask", "()V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "postTask", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "Z", "LG8/g;", "manager", "LG8/g;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ScanFileCoroutineAsync extends f {
        @Nullable
        private final String clickFilePath;
        private final boolean isPlay;
        @NotNull
        private final g manager;

        public ScanFileCoroutineAsync(@Nullable String s, boolean z) {
            this.clickFilePath = s;
            this.isPlay = z;
            this.manager = g.a.m();
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        @Nullable
        public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
            AddPlay addAction$AddPlay0 = this.isPlay ? new AddPlay(false) : Add.INSTANCE;
            if(LocalFolderListFragment.this.isFile(this.clickFilePath, true)) {
                String s = this.clickFilePath;
                if(s == null) {
                    LogU.Companion.e("LocalFolderListFragment", "ScanFileAsyncTask.doInBackground() clickFilePath is null");
                    return new Integer(-1);
                }
                this.manager.getClass();
                H8.k k0 = g.k(s);
                if(k0 == null) {
                    com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
                    logU$Companion0.d("LocalFolderListFragment", "ScanFileAsyncTask.doInBackground() Not in the localDB : " + this.clickFilePath);
                    ArrayList arrayList0 = new ArrayList();
                    arrayList0.add(new File(this.clickFilePath));
                    MelonAppBase.Companion.getClass();
                    e.c(k8.t.a().getContext(), arrayList0);
                    this.manager.getClass();
                    H8.k k1 = g.k(this.clickFilePath);
                    if(k1 == null) {
                        logU$Companion0.e("LocalFolderListFragment", "ScanFileAsyncTask.doInBackground() Not found file info.");
                        return new Integer(-1);
                    }
                    k0 = k1;
                }
                Y.w("ScanFileAsyncTask.doInBackground() File play : ", this.clickFilePath, LogU.Companion, "LocalFolderListFragment");
                String s1 = LocalFolderListFragment.this.mPlaybackMenuId;
                q.f(s1, "access$getMPlaybackMenuId$p$s-105168057(...)");
                this.manager.getClass();
                Playable playable0 = g.h(k0, s1);
                AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(LocalFolderListFragment.this.getActivity(), new AddPlayableList(null, addAction$AddPlay0, false, false, false, null, e.k.z(playable0), 0x20, null), false, 2, null);
                return new Integer(1);
            }
            File file0 = LocalFolderListFragment.this.mDirectoryFile;
            q.d(file0);
            File[] arr_file = file0.listFiles(new t(LocalFolderListFragment.this, 1));
            if(arr_file != null && arr_file.length != 0) {
                Context context0 = Y.a(MelonAppBase.Companion);
                List list0 = Arrays.asList(Arrays.copyOf(arr_file, arr_file.length));
                q.f(list0, "asList(...)");
                e.c(context0, list0);
                List list1 = Arrays.asList(Arrays.copyOf(arr_file, arr_file.length));
                q.f(list1, "asList(...)");
                this.manager.getClass();
                ArrayList arrayList1 = g.l(list1);
                String s2 = LocalFolderListFragment.this.mPlaybackMenuId;
                q.f(s2, "access$getMPlaybackMenuId$p$s-105168057(...)");
                this.manager.getClass();
                ArrayList arrayList2 = new ArrayList(g.i(s2, arrayList1));
                if(!arrayList2.isEmpty()) {
                    AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(LocalFolderListFragment.this.getActivity(), new AddPlayableList(null, addAction$AddPlay0, false, false, false, null, arrayList2, 0x20, null), false, 2, null);
                }
                return new Integer(1);
            }
            LogU.Companion.e("LocalFolderListFragment", "ScanFileAsyncTask.doInBackground() Not found audio files");
            return new Integer(-1);
        }

        private static final boolean backgroundWork$lambda$0(LocalFolderListFragment localFolderListFragment0, File file0, String s) {
            return localFolderListFragment0.isFile(s, false);
        }

        public void postTask(@Nullable Integer integer0) {
            super.postTask(integer0);
            LocalFolderListFragment.this.showProgress(false);
            if(integer0 != null && ((int)integer0) == -1) {
                ToastManager.show(0x7F130436);  // string:file_not_exists_on_mediastore "선택한 파일이 미디어저장소에 등록되어 있지 않습니다."
            }
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Integer)object0));
        }

        @Override  // x8.f
        public void preTask() {
            super.preTask();
            LocalFolderListFragment.this.showProgress(true);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u000022\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004`\u0005B\u000F\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ8\u0010\r\u001A\u00020\u00072\u0016\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\u0016\u0010\u000F\u001A\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001A\n \f*\u0004\u0018\u00010\u000B0\u000BX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$StringComparator;", "Ljava/util/Comparator;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Lkotlin/Comparator;", "mCol", "", "<init>", "(I)V", "collator", "Ljava/text/Collator;", "kotlin.jvm.PlatformType", "compare", "lhs", "rhs", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class StringComparator implements Comparator {
        private final Collator collator;
        private final int mCol;

        public StringComparator(int v) {
            this.mCol = v;
            this.collator = Collator.getInstance();
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(@NotNull ArrayList arrayList0, @NotNull ArrayList arrayList1) {
            q.g(arrayList0, "lhs");
            q.g(arrayList1, "rhs");
            Object object0 = arrayList0.get(this.mCol);
            q.f(object0, "get(...)");
            Object object1 = arrayList1.get(this.mCol);
            q.f(object1, "get(...)");
            return this.collator.compare(object0, object1);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0006\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\tR$\u0010\u000B\u001A\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R$\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalFolderListFragment$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "layout", "Landroid/view/View;", "getLayout", "()Landroid/view/View;", "Landroid/widget/ImageView;", "icon", "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ViewHolder extends O0 {
        public static final int $stable = 8;
        @Nullable
        private ImageView icon;
        @NotNull
        private final View layout;
        @Nullable
        private TextView title;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            super(view0);
            View view1 = view0.findViewById(0x7F0A0DF5);  // id:wrapper_layout
            q.f(view1, "findViewById(...)");
            this.layout = view1;
            View view2 = view0.findViewById(0x7F0A0635);  // id:iv_icon
            if(view2 != null) {
                this.icon = (ImageView)view2;
            }
            View view3 = view0.findViewById(0x7F0A0D34);  // id:tv_title
            if(view3 != null) {
                this.title = (TextView)view3;
            }
        }

        @Nullable
        public final ImageView getIcon() {
            return this.icon;
        }

        @NotNull
        public final View getLayout() {
            return this.layout;
        }

        @Nullable
        public final TextView getTitle() {
            return this.title;
        }

        public final void setIcon(@Nullable ImageView imageView0) {
            this.icon = imageView0;
        }

        public final void setTitle(@Nullable TextView textView0) {
            this.title = textView0;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String COL_NAME = "name";
    @NotNull
    private static final String COL_TYPE = "type";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String MELON_HOME_DIR = null;
    @NotNull
    private static final String TAG = "LocalFolderListFragment";
    @NotNull
    private static final String TOP_DIR = "/";
    private static final int TYPE_FILE = 1;
    private static final int TYPE_FOLDER;
    @Nullable
    private File mCurrentDirectory;
    @Nullable
    private File mDirectoryFile;
    @NotNull
    private final ArrayList mFolderHistory;
    @Nullable
    private String mSelectedPath;
    @NotNull
    private static final String[] sCursorCols;
    @NotNull
    private static final Class[] sCursorColsType;
    @NotNull
    private static final String[] sFileCursorCols;

    static {
        LocalFolderListFragment.Companion = new Companion(null);
        LocalFolderListFragment.$stable = 8;
        LocalFolderListFragment.MELON_HOME_DIR = va.e.h(Environment.getExternalStorageDirectory().getPath(), "/melon");
        LocalFolderListFragment.sCursorCols = new String[]{"_id", "_id", "title", "title_key", "_data", "album", "album_id", "artist", "artist_id", "duration", "is_music", "is_ringtone", "track", "mime_type", "date_added"};
        LocalFolderListFragment.sCursorColsType = new Class[]{Long.TYPE, Long.TYPE, String.class, String.class, String.class, String.class, Long.TYPE, String.class, Long.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE};
        LocalFolderListFragment.sFileCursorCols = new String[]{"type", "name", "_data"};
    }

    public LocalFolderListFragment() {
        this.mFolderHistory = new ArrayList();
    }

    private final void browseTo(File file0) {
        if(this.isFragmentValid() && file0 != null && file0.isDirectory()) {
            new BrowseCoroutineAsync(this, file0).execute(null);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new LocalFolderListAdapter(this, context0, null);
        ((com.iloen.melon.adapters.common.k)j00).setMarkedMode(false);
        ((com.iloen.melon.adapters.common.k)j00).setEditMode(false);
        return j00;
    }

    private final Cursor fetchData() {
        ArrayList arrayList0 = this.getFileList(this.mCurrentDirectory, (this.mCurrentDirectory == null ? null : this.mCurrentDirectory.listFiles()));
        return new ArrayListCursor(LocalFolderListFragment.sFileCursorCols, arrayList0);
    }

    private final ArrayList getFileList(File file0, File[] arr_file) {
        ArrayList arrayList0 = new ArrayList();
        ArrayList arrayList1 = new ArrayList();
        if(arr_file != null) {
            c2.Y y0 = q.j(arr_file);
            while(y0.hasNext()) {
                File file1 = (File)y0.next();
                if(file1.isDirectory() && !file1.isHidden() && file1.canRead()) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(0);
                    arrayList2.add(file1.getName());
                    arrayList2.add(file1.getPath());
                    arrayList0.add(arrayList2);
                }
            }
            StringComparator localFolderListFragment$StringComparator0 = new StringComparator(1);
            Collections.sort(arrayList0, localFolderListFragment$StringComparator0);
            c2.Y y1 = q.j(arr_file);
            while(y1.hasNext()) {
                File file2 = (File)y1.next();
                if(file2.isFile() && !file2.isHidden() && this.isFile(file2.getName(), false)) {
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(1);
                    arrayList3.add(file2.getName());
                    arrayList3.add(file2.getPath());
                    arrayList1.add(arrayList3);
                }
            }
            if(arrayList1.size() > 0) {
                Collections.sort(arrayList1, localFolderListFragment$StringComparator0);
            }
            arrayList1.addAll(0, arrayList0);
        }
        return arrayList1;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "storageboxSaveLocalFolder");
    }

    private final void goToDir(Cursor cursor0) {
        if(cursor0 == null) {
            LogU.Companion.w("LocalFolderListFragment", "goToDir() invalid cursor");
            return;
        }
        String s = cursor0.getString(1);
        String s1 = cursor0.getString(2);
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("LocalFolderListFragment", "goToDir() name: " + s + ", path:" + s1);
        if(q.b(s, ".")) {
            this.browseTo(this.mCurrentDirectory);
            return;
        }
        if(q.b(s, "..")) {
            this.goToUpFolder();
            return;
        }
        File file0 = new File(s1);
        logU$Companion0.d("LocalFolderListFragment", "goToDir() " + file0);
        if(file0.isDirectory()) {
            this.browseTo(file0);
            return;
        }
        if(file0.isFile()) {
            this.scanFolder(file0.getPath(), true);
        }
    }

    public final void goToHome() {
        this.browseTo(c.c());
    }

    private final void goToUpFolder() {
        File file0 = this.mCurrentDirectory;
        File file1 = null;
        if(!TextUtils.isEmpty((file0 == null ? null : file0.getParent()))) {
            if(file0 != null) {
                file1 = file0.getParentFile();
            }
            this.browseTo(file1);
        }
    }

    // 去混淆评级： 低(30)
    public final boolean isFile(@Nullable String s, boolean z) {
        return FilenameUtils.isMusic(s) || FilenameUtils.isVideo(s) && z;
    }

    private final boolean isHomeDir() {
        File file0 = this.mCurrentDirectory;
        if(file0 != null) {
            String s = FileUtils.getSafetyPath(file0);
            return q.b(LocalFolderListFragment.MELON_HOME_DIR, s);
        }
        return false;
    }

    private final boolean isTopDir() {
        return this.mCurrentDirectory == null ? false : "/".equals(FileUtils.getSafetyPath(this.mCurrentDirectory));
    }

    private final void notifyChange() {
        Object object0 = this.getContentAdapter();
        if(!(object0 instanceof LocalFolderListAdapter)) {
            q.e(object0, "null cannot be cast to non-null type com.iloen.melon.fragments.local.LocalFolderListFragment.LocalFolderListAdapter");
            ((LocalFolderListAdapter)object0).notifyDataSetChanged();
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@NotNull String s) {
        q.g(s, "playlistId");
        new AddPlaylistSongFolderCoroutineAsync(this, this.mSelectedPath, s).execute(null);
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onAddToNowPlayingList(@NotNull Object object0) {
        q.g(object0, "userData");
        this.scanFolder(this.mSelectedPath, false);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(this.getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02B1, viewGroup0, false);  // layout:fragment_local_folder
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        this.changeCursor(this.fetchData());
        this.performFetchCompleteOnlyViews();
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onRecyclerViewItemClick(@Nullable j0 j00, @NotNull View view0, int v, int v1) {
        q.g(view0, "childView");
        if(!(j00 instanceof LocalFolderListAdapter)) {
            LogU.Companion.w("LocalFolderListFragment", "onRecyclerViewItemClick() invalid adapter");
            return false;
        }
        Cursor cursor0 = this.getCursor();
        if(cursor0 == null) {
            LogU.Companion.w("LocalFolderListFragment", "onRecyclerViewItemClick() invalid cursor");
            return false;
        }
        if(!cursor0.moveToPosition(v1)) {
            LogU.Companion.w("LocalFolderListFragment", "onRecyclerViewItemClick() failed to movePosition");
            return false;
        }
        this.goToDir(cursor0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        String s1;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        view0.setFocusableInTouchMode(true);
        view0.requestFocus();
        view0.setOnKeyListener(new s(this));
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.mTitle);
            titleBar0.f(true);
        }
        String s = MelonSettingInfo.getLastOpenedFolder();
        if(TextUtils.isEmpty(s)) {
            this.mCurrentDirectory = new File(va.e.h(Environment.getExternalStorageDirectory().getPath(), "/melon"));
        }
        else {
            File file0 = new File(s);
            this.mCurrentDirectory = file0;
            if(!file0.exists()) {
                this.mCurrentDirectory = new File(va.e.h(Environment.getExternalStorageDirectory().getPath(), "/melon"));
            }
        }
        this.mFolderHistory.clear();
        ArrayList arrayList0 = this.mFolderHistory;
        File file1 = this.mCurrentDirectory;
        if(file1 == null) {
            s1 = "";
        }
        else {
            s1 = file1.getPath();
            if(s1 == null) {
                s1 = "";
            }
        }
        arrayList0.add(s1);
    }

    private static final boolean onViewCreated$lambda$0(LocalFolderListFragment localFolderListFragment0, View view0, int v, KeyEvent keyEvent0) {
        if(v == 4) {
            Y.t("onKey() KEYCODE_BACK > size: ", localFolderListFragment0.mFolderHistory.size(), LogU.Companion, "LocalFolderListFragment");
            if(localFolderListFragment0.mFolderHistory.size() == 1) {
                return false;
            }
            localFolderListFragment0.mFolderHistory.remove(localFolderListFragment0.mFolderHistory.size() - 1);
            Object object0 = localFolderListFragment0.mFolderHistory.get(localFolderListFragment0.mFolderHistory.size() - 1);
            q.f(object0, "get(...)");
            localFolderListFragment0.browseTo(new File(((String)object0)));
            return true;
        }
        return false;
    }

    private final void scanFolder(String s, boolean z) {
        if(!this.isAdded()) {
            return;
        }
        new ScanFileCoroutineAsync(this, s, z).execute(null);
    }

    private final void showContextListPopup(ContextListItemBuilder contextListItemBuilder0, String s) {
        if(!this.isAdded()) {
            return;
        }
        ContextListPopup contextListPopup0 = new ContextListPopup(this.getActivity());
        contextListPopup0.setTitle(s);
        contextListPopup0.setListItems(contextListItemBuilder0.build());
        contextListPopup0.setOnMenuItemClickListener(new p(this, 2));
        contextListPopup0.show();
    }

    private static final void showContextListPopup$lambda$2(LocalFolderListFragment localFolderListFragment0, ContextItemInfo contextItemInfo0, ContextItemType contextItemType0, Params contextItemInfo$Params0) {
        if(!ContextItemType.f.equals(contextItemType0) && !ContextItemType.m.equals(contextItemType0)) {
            if(ContextItemType.M.equals(contextItemType0)) {
                localFolderListFragment0.browseTo(localFolderListFragment0.mDirectoryFile);
                return;
            }
            if(ContextItemType.g.equals(contextItemType0)) {
                File file0 = localFolderListFragment0.mDirectoryFile;
                q.d(file0);
                localFolderListFragment0.showTrackAddToLocalPlaylistPopup(file0.getName());
            }
            return;
        }
        localFolderListFragment0.scanFolder(localFolderListFragment0.mSelectedPath, true);
    }

    private final boolean showLocalFolderPopup(int v) {
        Cursor cursor0 = this.getCursor();
        if(cursor0 == null) {
            LogU.Companion.d("LocalFolderListFragment", "showLocalFolderPopup() invalid cursor");
            return false;
        }
        if(!cursor0.moveToPosition(v)) {
            LogU.Companion.d("LocalFolderListFragment", "showLocalFolderPopup() failed to moveToPosition");
            return false;
        }
        this.mSelectedPath = cursor0.getString(2);
        this.mDirectoryFile = new File(this.mSelectedPath);
        ContextListItemBuilder contextListItemBuilder0 = ContextListItemBuilder.newInstance();
        String s = "";
        if(this.isFile((this.mDirectoryFile == null ? null : this.mDirectoryFile.getName()), false)) {
            if(FilenameUtils.isMp4(this.mSelectedPath)) {
                contextListItemBuilder0.add(ContextItemInfo.a(ContextItemType.m));
                File file0 = this.mDirectoryFile;
                if(file0 != null) {
                    String s1 = file0.getName();
                    if(s1 != null) {
                        s = s1;
                    }
                }
                this.showContextListPopup(contextListItemBuilder0, s);
                return true;
            }
            contextListItemBuilder0.add(ContextItemInfo.a(ContextItemType.f)).add(ContextItemInfo.a(ContextItemType.g));
            File file1 = this.mDirectoryFile;
            if(file1 != null) {
                String s2 = file1.getName();
                if(s2 != null) {
                    s = s2;
                }
            }
            this.showContextListPopup(contextListItemBuilder0, s);
            return true;
        }
        contextListItemBuilder0.add(ContextItemInfo.a(ContextItemType.M)).add(ContextItemInfo.a(ContextItemType.f)).add(ContextItemInfo.a(ContextItemType.g));
        File file2 = this.mDirectoryFile;
        if(file2 != null) {
            String s3 = file2.getName();
            if(s3 != null) {
                s = s3;
            }
        }
        this.showContextListPopup(contextListItemBuilder0, s);
        return true;
    }
}

