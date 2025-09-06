package com.iloen.melon.fragments.local;

import Bc.h;
import G8.f;
import M6.B;
import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.provider.MediaStore;
import android.widget.ImageView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.iloen.melon.adapters.common.ListMarker;
import com.iloen.melon.adapters.common.d;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.adapters.common.s;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.SongMetaParser;
import com.iloen.melon.utils.system.ToastManager;
import com.melon.ui.K1;
import com.melon.ui.L1;
import com.melon.ui.N1;
import com.melon.ui.f2;
import com.melon.ui.k2;
import com.melon.ui.w1;
import com.melon.ui.x1;
import d9.j;
import e.b;
import e9.a;
import ie.H;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import je.y;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ob.z;
import oc.O;
import oc.Q;
import oe.e;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;
import v9.m;
import we.n;
import zd.B0;
import zd.M;

@Metadata(d1 = {"\u0000\u00AE\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\'\u0018\u00002\u00020\u00012\u00020\u0002:\b\u0092\u0001\u0093\u0001\u0094\u0001\u0095\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H&\u00A2\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH&\u00A2\u0006\u0004\b\t\u0010\u0004J\'\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0017\u001A\u00020\u0013H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0016J\u0019\u0010\u001B\u001A\u00020\b2\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0014\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001E\u001A\u00020\b2\b\u0010\u001D\u001A\u0004\u0018\u00010\u000EH\u0014\u00A2\u0006\u0004\b\u001E\u0010\u001FJ#\u0010\u001E\u001A\u00020\b2\b\u0010\u001D\u001A\u0004\u0018\u00010\u000E2\b\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b\u001E\u0010\"J+\u0010%\u001A\u00020\b2\b\u0010#\u001A\u0004\u0018\u00010\u000E2\u0006\u0010$\u001A\u00020\u00102\b\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b%\u0010&J\u0019\u0010\'\u001A\u00020\b2\b\u0010!\u001A\u0004\u0018\u00010 H\u0004\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010*\u001A\u00020\b2\u0006\u0010)\u001A\u00020\u0010H\u0014\u00A2\u0006\u0004\b*\u0010+J\u001F\u0010.\u001A\u00020\b2\u0010\u0010-\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0018\u00010,\u00A2\u0006\u0004\b.\u0010/J!\u00102\u001A\u00020\b2\u0006\u00100\u001A\u00020\u00052\b\u00101\u001A\u0004\u0018\u00010\u0019H\u0016\u00A2\u0006\u0004\b2\u00103J3\u0010:\u001A\u00020\b2\b\u00105\u001A\u0004\u0018\u0001042\u0006\u00106\u001A\u00020\u000E2\u0006\u00108\u001A\u0002072\b\u00109\u001A\u0004\u0018\u00010\u000EH\u0004\u00A2\u0006\u0004\b:\u0010;J\u0017\u0010>\u001A\u00020\b2\u0006\u0010=\u001A\u00020<H\u0007\u00A2\u0006\u0004\b>\u0010?J\u0019\u0010@\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0018\u00010,H\u0002\u00A2\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001A\u00020\b2\u0006\u0010!\u001A\u00020 H\u0002\u00A2\u0006\u0004\bB\u0010(J\u0017\u0010C\u001A\u00020\b2\u0006\u0010)\u001A\u00020\u0010H\u0002\u00A2\u0006\u0004\bC\u0010+J\u000F\u0010D\u001A\u00020\bH\u0002\u00A2\u0006\u0004\bD\u0010\u0004J+\u0010J\u001A\b\u0012\u0004\u0012\u00020H0G2\u0006\u0010F\u001A\u00020E2\f\u0010I\u001A\b\u0012\u0004\u0012\u00020H0GH\u0002\u00A2\u0006\u0004\bJ\u0010KR\u001A\u0010L\u001A\u00020\u000E8\u0016X\u0096D\u00A2\u0006\f\n\u0004\bL\u0010M\u001A\u0004\bN\u0010OR\"\u0010Q\u001A\u00020P8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bQ\u0010R\u001A\u0004\bS\u0010T\"\u0004\bU\u0010VR\"\u0010X\u001A\u00020W8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bX\u0010Y\u001A\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\"\u0010^\u001A\u00020\u00058\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b^\u0010_\u001A\u0004\b`\u0010\u0007\"\u0004\ba\u0010bR\"\u0010\u001D\u001A\u0002078\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b\u001D\u0010c\u001A\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010h\u001A\u00020\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bh\u0010M\u001A\u0004\bi\u0010O\"\u0004\bj\u0010\u001FR\"\u0010k\u001A\u00020\u00058\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bk\u0010_\u001A\u0004\bl\u0010\u0007\"\u0004\bm\u0010bR$\u0010n\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bn\u0010M\u001A\u0004\bo\u0010O\"\u0004\bp\u0010\u001FR$\u00109\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b9\u0010M\u001A\u0004\bq\u0010O\"\u0004\br\u0010\u001FR$\u0010s\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bs\u0010M\u001A\u0004\bt\u0010O\"\u0004\bu\u0010\u001FR$\u0010v\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\bv\u0010M\u001A\u0004\bw\u0010O\"\u0004\bx\u0010\u001FR\"\u00108\u001A\u0002078\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b8\u0010c\u001A\u0004\by\u0010e\"\u0004\bz\u0010gR\"\u0010{\u001A\u00020\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0012\n\u0004\b{\u0010M\u001A\u0004\b|\u0010O\"\u0004\b}\u0010\u001FR%\u0010~\u001A\u0004\u0018\u00010\u000E8\u0004@\u0004X\u0084\u000E\u00A2\u0006\u0013\n\u0004\b~\u0010M\u001A\u0004\b\u007F\u0010O\"\u0005\b\u0080\u0001\u0010\u001FR \u0010\u0082\u0001\u001A\u00030\u0081\u00018\u0004X\u0084\u0004\u00A2\u0006\u0010\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u001A\u0006\b\u0084\u0001\u0010\u0085\u0001R \u0010\u0087\u0001\u001A\u00030\u0086\u00018\u0004X\u0084\u0004\u00A2\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001A\u0006\b\u0089\u0001\u0010\u008A\u0001R#\u0010\u008B\u0001\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u000E\u0018\u00010,8\u0002@\u0002X\u0082\u000E\u00A2\u0006\b\n\u0006\b\u008B\u0001\u0010\u008C\u0001R)\u0010\u0090\u0001\u001A\u0014\u0012\u000F\u0012\r \u008F\u0001*\u0005\u0018\u00010\u008E\u00010\u008E\u00010\u008D\u00018\u0002X\u0082\u0004\u00A2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u00A8\u0006\u0096\u0001"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "Le9/a;", "<init>", "()V", "", "getLocalTrackType", "()I", "Lie/H;", "startQuery", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "userData", "onAddToNowPlayingList", "(Ljava/lang/Object;)V", "playlistId", "onAddSongsToLocalPlaylist", "(Ljava/lang/String;)V", "Lcom/iloen/melon/playback/Playable;", "playable", "(Ljava/lang/String;Lcom/iloen/melon/playback/Playable;)V", "title", "isEdu", "showTrackAddToLocalPlaylistPopup", "(Ljava/lang/String;ZLcom/iloen/melon/playback/Playable;)V", "showMoreContextPopup", "(Lcom/iloen/melon/playback/Playable;)V", "removeAll", "showDeleteConfirmPopup", "(Z)V", "", "removeList", "remove", "([Ljava/lang/String;)V", "nResult", "clientData", "onRemoveComplete", "(ILjava/lang/Object;)V", "Landroid/widget/ImageView;", "imageView", "path", "", "albumId1", "albumKey", "showAlbumImage", "(Landroid/widget/ImageView;Ljava/lang/String;JLjava/lang/String;)V", "Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAudioSync$Finish;)V", "checkedListString", "()[Ljava/lang/String;", "lyricDownload", "showDeleteConfirmPopupReal", "removeSongs", "Landroid/content/Context;", "context", "", "Landroid/net/Uri;", "selections", "neededPermissions", "(Landroid/content/Context;Ljava/util/List;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "delType", "I", "getDelType", "setDelType", "(I)V", "J", "getPlaylistId", "()J", "setPlaylistId", "(J)V", "playlistName", "getPlaylistName", "setPlaylistName", "delSongCount", "getDelSongCount", "setDelSongCount", "album", "getAlbum", "setAlbum", "getAlbumKey", "setAlbumKey", "artist", "getArtist", "setArtist", "genre", "getGenre", "setGenre", "getAlbumId1", "setAlbumId1", "artistId1", "getArtistId1", "setArtistId1", "artistId2", "getArtistId2", "setArtistId2", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIoDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "mainDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMainDispatcher", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "deletedSongList", "[Ljava/lang/String;", "Le/b;", "Landroidx/activity/result/IntentSenderRequest;", "kotlin.jvm.PlatformType", "activityResult", "Le/b;", "DelType", "LocalTrackType", "ParamInfo", "LocalContentBaseSongAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LocalContentNewDbBaseFragment extends Hilt_LocalContentNewDbBaseFragment implements a {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$DelType;", "", "<init>", "()V", "NONE", "", "ONE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DelType {
        public static final int $stable = 0;
        @NotNull
        public static final DelType INSTANCE = null;
        public static final int NONE = 0;
        public static final int ONE = 1;

        static {
            DelType.INSTANCE = new DelType();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003B#\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0006\u0012\u0010\u0010\t\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000BJ%\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00040\b2\u000E\u0010\t\u001A\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0013\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$LocalContentBaseSongAdapter;", "T", "U", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/playback/Playable;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "", "getPlayableItems", "(Ljava/util/List;)Ljava/util/List;", "getPlayableListForPlay", "()Ljava/util/List;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static abstract class LocalContentBaseSongAdapter extends p {
        public static final int $stable = 8;

        public LocalContentBaseSongAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.q
        @NotNull
        public List getPlayableItems(@Nullable List list0) {
            List list1 = super.getPlayableItems(list0);
            q.f(list1, "getPlayableItems(...)");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list1));
            for(Object object0: list1) {
                arrayList0.add(Playable.copyValueOf(((Playable)object0)));
            }
            return je.p.Q0(arrayList0);
        }

        @NotNull
        public final List getPlayableListForPlay() {
            List list0 = this.getList();
            q.e(list0, "null cannot be cast to non-null type kotlin.collections.List<com.iloen.melon.playback.Playable?>");
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, list0));
            for(Object object0: list0) {
                arrayList0.add(Playable.copyValueOf(((Playable)object0)));
            }
            return je.p.Q0(arrayList0);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$LocalTrackType;", "", "<init>", "()V", "ALL_CONTENT", "", "ARTIST", "ALBUM", "GENRE", "PLAYLIST", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class LocalTrackType {
        public static final int $stable = 0;
        public static final int ALBUM = 2;
        public static final int ALL_CONTENT = 0;
        public static final int ARTIST = 1;
        public static final int GENRE = 3;
        @NotNull
        public static final LocalTrackType INSTANCE = null;
        public static final int PLAYLIST = 4;

        static {
            LocalTrackType.INSTANCE = new LocalTrackType();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000B\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001A\u0010\u0013\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001A\u0010\u0016\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001A\u0010\u0019\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001A\u0010\u0007\"\u0004\b\u001B\u0010\tR\u001A\u0010\u001C\u001A\u00020\u001DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u001E\"\u0004\b\u001F\u0010 R\u001A\u0010!\u001A\u00020\u001DX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b!\u0010\u001E\"\u0004\b\"\u0010 ¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo;", "", "<init>", "()V", "album", "", "getAlbum", "()Ljava/lang/String;", "setAlbum", "(Ljava/lang/String;)V", "albumId1", "", "getAlbumId1", "()J", "setAlbumId1", "(J)V", "albumKey", "getAlbumKey", "setAlbumKey", "artist", "getArtist", "setArtist", "artistId", "getArtistId", "setArtistId", "genre", "getGenre", "setGenre", "isFlac", "", "()Z", "setFlac", "(Z)V", "isEdu", "setEdu", "Builder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ParamInfo {
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00002\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00002\u0006\u0010\b\u001A\u00020\u0007J\u000E\u0010\t\u001A\u00020\u00002\u0006\u0010\n\u001A\u00020\u000BJ\u000E\u0010\f\u001A\u00020\u00002\u0006\u0010\f\u001A\u00020\u0007J\u000E\u0010\r\u001A\u00020\u00002\u0006\u0010\r\u001A\u00020\u0007J\u000E\u0010\u000E\u001A\u00020\u00002\u0006\u0010\u000E\u001A\u00020\u0007J\u000E\u0010\u000F\u001A\u00020\u00002\u0006\u0010\u000F\u001A\u00020\u0010J\u000E\u0010\u0011\u001A\u00020\u00002\u0006\u0010\u0011\u001A\u00020\u0010J\u0006\u0010\u0012\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo$Builder;", "", "<init>", "()V", "info", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo;", "album", "", "albumKey", "albumId1", "albumId", "", "artist", "artistId", "genre", "isFlac", "", "isEdu", "build", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Builder {
            @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo$Builder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentNewDbBaseFragment$ParamInfo$Builder;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            public static final class Companion {
                private Companion() {
                }

                public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
                }

                @NotNull
                public final Builder newInstance() {
                    return new Builder(null);
                }
            }

            public static final int $stable;
            @NotNull
            public static final Companion Companion;
            @NotNull
            private final ParamInfo info;

            static {
                Builder.Companion = new Companion(null);
                Builder.$stable = 8;
            }

            private Builder() {
                this.info = new ParamInfo(null);
            }

            public Builder(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final Builder album(@NotNull String s) {
                q.g(s, "album");
                this.info.setAlbum(s);
                return this;
            }

            @NotNull
            public final Builder albumId1(long v) {
                this.info.setAlbumId1(v);
                return this;
            }

            @NotNull
            public final Builder albumKey(@NotNull String s) {
                q.g(s, "albumKey");
                this.info.setAlbumKey(s);
                return this;
            }

            @NotNull
            public final Builder artist(@NotNull String s) {
                q.g(s, "artist");
                this.info.setArtist(s);
                return this;
            }

            @NotNull
            public final Builder artistId(@NotNull String s) {
                q.g(s, "artistId");
                this.info.setArtistId(s);
                return this;
            }

            @NotNull
            public final ParamInfo build() {
                return this.info;
            }

            @NotNull
            public final Builder genre(@NotNull String s) {
                q.g(s, "genre");
                this.info.setGenre(s);
                return this;
            }

            @NotNull
            public final Builder isEdu(boolean z) {
                this.info.setEdu(z);
                return this;
            }

            @NotNull
            public final Builder isFlac(boolean z) {
                this.info.setFlac(z);
                return this;
            }
        }

        public static final int $stable = 8;
        @NotNull
        private String album;
        private long albumId1;
        @NotNull
        private String albumKey;
        @NotNull
        private String artist;
        @NotNull
        private String artistId;
        @NotNull
        private String genre;
        private boolean isEdu;
        private boolean isFlac;

        private ParamInfo() {
            this.album = "";
            this.albumId1 = -1L;
            this.albumKey = "";
            this.artist = "";
            this.artistId = "";
            this.genre = "";
        }

        public ParamInfo(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final String getAlbum() [...] // 潜在的解密器

        public final long getAlbumId1() {
            return this.albumId1;
        }

        @NotNull
        public final String getAlbumKey() [...] // 潜在的解密器

        @NotNull
        public final String getArtist() [...] // 潜在的解密器

        @NotNull
        public final String getArtistId() [...] // 潜在的解密器

        @NotNull
        public final String getGenre() [...] // 潜在的解密器

        public final boolean isEdu() {
            return this.isEdu;
        }

        public final boolean isFlac() {
            return this.isFlac;
        }

        public final void setAlbum(@NotNull String s) {
            q.g(s, "<set-?>");
            this.album = s;
        }

        public final void setAlbumId1(long v) {
            this.albumId1 = v;
        }

        public final void setAlbumKey(@NotNull String s) {
            q.g(s, "<set-?>");
            this.albumKey = s;
        }

        public final void setArtist(@NotNull String s) {
            q.g(s, "<set-?>");
            this.artist = s;
        }

        public final void setArtistId(@NotNull String s) {
            q.g(s, "<set-?>");
            this.artistId = s;
        }

        public final void setEdu(boolean z) {
            this.isEdu = z;
        }

        public final void setFlac(boolean z) {
            this.isFlac = z;
        }

        public final void setGenre(@NotNull String s) {
            q.g(s, "<set-?>");
            this.genre = s;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[9] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[10] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[16] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[0] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[7] = 5;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[22] = 6;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[62] = 7;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 8;
    @NotNull
    private final String TAG;
    @NotNull
    private final b activityResult;
    @Nullable
    private String album;
    private long albumId1;
    @Nullable
    private String albumKey;
    @Nullable
    private String artist;
    @NotNull
    private String artistId1;
    @Nullable
    private String artistId2;
    private int delSongCount;
    private int delType;
    @Nullable
    private String[] deletedSongList;
    @Nullable
    private String genre;
    @NotNull
    private final CoroutineDispatcher ioDispatcher;
    @NotNull
    private final MainCoroutineDispatcher mainDispatcher;
    @Inject
    public h playerUiHelper;
    @Inject
    public z playerUseCase;
    private long playlistId;
    @NotNull
    private String playlistName;

    public LocalContentNewDbBaseFragment() {
        this.TAG = "LocalContentNewDbBaseFragment";
        this.playlistId = -1L;
        this.playlistName = "";
        this.albumId1 = -1L;
        this.artistId1 = "";
        this.ioDispatcher = Dispatchers.getIO();
        this.mainDispatcher = Dispatchers.getMain();
        b b0 = this.registerForActivityResult(new f0(3), new com.iloen.melon.fragments.local.p(this, 1));
        q.f(b0, "registerForActivityResult(...)");
        this.activityResult = b0;
    }

    private static final void activityResult$lambda$0(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            localContentNewDbBaseFragment0.remove(localContentNewDbBaseFragment0.deletedSongList);
        }
    }

    private final String[] checkedListString() {
        if(this.getLocalTrackType() == 4) {
            return new String[]{String.valueOf(this.playlistId)};
        }
        ArrayList arrayList0 = new ArrayList();
        m m0 = this.getMarkedList(false);
        if(m0.a) {
            arrayList0.addAll(this.getWeakMarkedList());
        }
        else {
            arrayList0.addAll(m0.d);
        }
        int v1 = arrayList0.size();
        j0 j00 = this.getAdapter();
        if(j00 != null && j00 instanceof p) {
            List list0 = ((p)j00).getList();
            String[] arr_s = new String[v1];
            for(int v = 0; v < v1; ++v) {
                Object object0 = arrayList0.get(v);
                q.f(object0, "get(...)");
                if(list0.get(((Number)object0).intValue()) instanceof Playable) {
                    boolean z = !StorageUtils.isScopedStorage();
                    arr_s[v] = "";
                }
            }
            return arr_s;
        }
        return null;
    }

    @Nullable
    public final String getAlbum() {
        return this.album;
    }

    public final long getAlbumId1() {
        return this.albumId1;
    }

    @Nullable
    public final String getAlbumKey() {
        return this.albumKey;
    }

    @Nullable
    public final String getArtist() {
        return this.artist;
    }

    @NotNull
    public final String getArtistId1() {
        return this.artistId1;
    }

    @Nullable
    public final String getArtistId2() {
        return this.artistId2;
    }

    public final int getDelSongCount() {
        return this.delSongCount;
    }

    public final int getDelType() {
        return this.delType;
    }

    @Nullable
    public final String getGenre() {
        return this.genre;
    }

    @NotNull
    public final CoroutineDispatcher getIoDispatcher() {
        return this.ioDispatcher;
    }

    public abstract int getLocalTrackType();

    @NotNull
    public final MainCoroutineDispatcher getMainDispatcher() {
        return this.mainDispatcher;
    }

    @NotNull
    public final h getPlayerUiHelper() {
        h h0 = this.playerUiHelper;
        if(h0 != null) {
            return h0;
        }
        q.m("playerUiHelper");
        throw null;
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    public final long getPlaylistId() {
        return this.playlistId;
    }

    @NotNull
    public final String getPlaylistName() {
        return this.playlistName;
    }

    @NotNull
    public String getTAG() {
        return this.TAG;
    }

    private final void lyricDownload(Playable playable0) {
        String s = this.getTAG();
        LogU.Companion.d(s, "lyricDownload");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(null) {
            final Playable $playable;
            int label;

            {
                this.$playable = playable0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.lyricDownload.1(this.$playable, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.lyricDownload.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                q.g(this.$playable, "playable");
                j.a().f(this.$playable, true);
                return H.a;
            }
        }, 3, null);
    }

    private final List neededPermissions(Context context0, List list0) {
        List list1 = new ArrayList();
        for(Object object0: list0) {
            if(context0.checkUriPermission(((Uri)object0), Process.myPid(), Process.myUid(), 2) != 0) {
                list1.add(object0);
            }
        }
        return list1;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@Nullable String s) {
        ArrayList arrayList0 = new ArrayList();
        m m0 = this.getMarkedList(false);
        if(m0.a) {
            arrayList0.addAll(this.getWeakMarkedList());
        }
        else {
            arrayList0.addAll(m0.d);
        }
        j0 j00 = this.getAdapter();
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MetaInfoAdapter");
        ArrayList arrayList1 = (ArrayList)((s)j00).getPlayableItems(arrayList0);
        if(arrayList1 != null && arrayList1.size() != 0) {
            if(s == null) {
                s = "0";
            }
            Integer integer0 = Integer.valueOf(s);
            q.f(integer0, "valueOf(...)");
            this.addToLocalPlaylist(arrayList1, integer0.intValue());
            this.setSelectAllWithToolbar(false);
            return;
        }
        ToastManager.show(0x7F130506);  // string:localplaylist_alert_no_songs_to_be_added "추가할 곡이 없습니다."
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@Nullable String s, @Nullable Playable playable0) {
        if(playable0 == null) {
            return;
        }
        ArrayList arrayList0 = new ArrayList();
        arrayList0.add(playable0);
        if(s == null) {
            s = "0";
        }
        Integer integer0 = Integer.valueOf(s);
        q.f(integer0, "valueOf(...)");
        this.addToLocalPlaylist(arrayList0, integer0.intValue());
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onAddToNowPlayingList(@Nullable Object object0) {
        this.playSongs(false, false, false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull Finish eventAudioSync$Finish0) {
        q.g(eventAudioSync$Finish0, "event");
        if(this.isFragmentValid() && eventAudioSync$Finish0.getType() != 0 && eventAudioSync$Finish0.getUpdateCount() > 0) {
            this.startQuery();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull v9.h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        this.startQuery();
        return true;
    }

    @Override  // e9.a
    public void onRemoveComplete(int v, @Nullable Object object0) {
        String s;
        this.showProgress(false);
        if(this.getContentAdapter() != null) {
            this.setSelectAllWithToolbar(false);
            switch(v) {
                case 1: {
                    ToastManager.show(0x7F1302EC);  // string:delete_now_playlist_failed "재생중인 곡은 삭제 할 수 없습니다."
                    break;
                }
                case 2: {
                    ToastManager.show(0x7F1302E8);  // string:delete_now_multi_failed "재생중인곡을 제외하고 삭제하였습니다."
                    break;
                }
                default: {
                    FragmentActivity fragmentActivity0 = this.getActivity();
                    if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                        if(this.delType != 1) {
                            s = this.getLocalTrackType() == 4 ? this.getString(0x7F130841) : this.getString(0x7F131097);  // string:playlist_track_all_del_complete "전체 곡이 로컬 플레이리스트에서 삭제되었습니다."
                            q.d(s);
                        }
                        else if(this.getLocalTrackType() == 4) {
                            s = o.i(this.delSongCount, this.getString(0x7F130842));  // string:playlist_track_sel_del_complete "곡이 로컬 플레이리스트에서 삭제되었습니다."
                        }
                        else {
                            s = o.i(this.delSongCount, this.getString(0x7F1302A2));  // string:currentdownload_track_del "곡이 삭제되었습니다."
                        }
                        String s1 = this.getTAG();
                        LogU.Companion.d(s1, "Msg : " + s);
                        ToastManager.show(s);
                    }
                }
            }
            this.delType = 0;
            this.startFetch("file::onRemoveComplete");
            return;
        }
        String s2 = this.getTAG();
        LogU.Companion.d(s2, "RemoveComplete mAdapter == null return..");
        this.delType = 0;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        super.onRestoreInstanceState(bundle0);
        this.album = bundle0.getString("album", "");
        this.albumKey = bundle0.getString("album_key", "");
        this.albumId1 = bundle0.getLong("albumid1", -1L);
        this.artist = bundle0.getString("artist", "");
        String s = bundle0.getString("artistid1", "");
        q.f(s, "getString(...)");
        this.artistId1 = s;
        this.artistId2 = bundle0.getString("artistid2", "");
        this.genre = bundle0.getString("genrename", "");
        this.playlistId = bundle0.getLong("playlistid", -1L);
        String s1 = bundle0.getString("playlistname", "");
        q.f(s1, "getString(...)");
        this.playlistName = s1;
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("album", this.album);
        bundle0.putString("album_key", this.albumKey);
        bundle0.putLong("albumid1", this.albumId1);
        bundle0.putString("artist", this.artist);
        bundle0.putString("artistid1", this.artistId1);
        bundle0.putString("artistid2", this.artistId2);
        bundle0.putString("genrename", this.genre);
        bundle0.putLong("playlistid", this.playlistId);
        bundle0.putString("playlistname", this.playlistName);
    }

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(@NotNull RecoverableSecurityException recoverableSecurityException0) {
        q.g(recoverableSecurityException0, "exception");
    }

    public final void remove(@Nullable String[] arr_s) {
        if(this.isAdded()) {
            this.showProgress(true);
            Context context0 = this.getContext();
            if(context0 != null) {
                e9.b b0 = new e9.b(context0, this);
                if(this.getLocalTrackType() == 4) {
                    ArrayList arrayList0 = new ArrayList();
                    m m0 = this.getMarkedList(false);
                    j0 j00 = this.getAdapter();
                    q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.MetaInfoAdapter");
                    List list0 = ((s)j00).getPlayableItems(m0.d);
                    q.e(list0, "null cannot be cast to non-null type java.util.ArrayList<com.iloen.melon.playback.Playable>");
                    arrayList0.addAll(((ArrayList)list0));
                    b0.d = 6;
                    b0.f = arrayList0;
                }
                else {
                    b0.d = 0;
                }
                b0.a(arr_s, null);
            }
        }
    }

    private final void removeSongs() {
        List list0;
        if(this.getLocalTrackType() != 4 && StorageUtils.isScopedStorage()) {
            this.deletedSongList = this.checkedListString();
            Context context0 = this.getContext();
            if(context0 == null) {
                return;
            }
            String[] arr_s = this.deletedSongList;
            if(arr_s == null) {
                list0 = null;
            }
            else {
                ArrayList arrayList0 = new ArrayList(arr_s.length);
                for(int v = 0; v < arr_s.length; ++v) {
                    arrayList0.add(Uri.parse(arr_s[v]));
                }
                list0 = this.neededPermissions(context0, arrayList0);
            }
            if(list0 != null && !list0.isEmpty()) {
                try {
                    PendingIntent pendingIntent0 = MediaStore.createDeleteRequest(context0.getContentResolver(), list0);
                    q.f(pendingIntent0, "createDeleteRequest(...)");
                    IntentSender intentSender0 = pendingIntent0.getIntentSender();
                    q.f(intentSender0, "getIntentSender(...)");
                    IntentSenderRequest intentSenderRequest0 = new IntentSenderRequest(intentSender0, null, 0, 0);
                    this.activityResult.b(intentSenderRequest0);
                }
                catch(Exception exception0) {
                    String s = this.getTAG();
                    LogU.Companion.d(s, "removeSongs() permission Exception : " + exception0);
                }
                return;
            }
            this.remove(this.checkedListString());
            return;
        }
        this.remove(this.checkedListString());
    }

    public final void setAlbum(@Nullable String s) {
        this.album = s;
    }

    public final void setAlbumId1(long v) {
        this.albumId1 = v;
    }

    public final void setAlbumKey(@Nullable String s) {
        this.albumKey = s;
    }

    public final void setArtist(@Nullable String s) {
        this.artist = s;
    }

    public final void setArtistId1(@NotNull String s) {
        q.g(s, "<set-?>");
        this.artistId1 = s;
    }

    public final void setArtistId2(@Nullable String s) {
        this.artistId2 = s;
    }

    public final void setDelSongCount(int v) {
        this.delSongCount = v;
    }

    public final void setDelType(int v) {
        this.delType = v;
    }

    public final void setGenre(@Nullable String s) {
        this.genre = s;
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setPlaylistId(long v) {
        this.playlistId = v;
    }

    public final void setPlaylistName(@NotNull String s) {
        q.g(s, "<set-?>");
        this.playlistName = s;
    }

    public final void showAlbumImage(@Nullable ImageView imageView0, @NotNull String s, long v, @Nullable String s1) {
        q.g(s, "path");
        if(imageView0 == null) {
            String s2 = this.getTAG();
            LogU.Companion.w(s2, "showAlbumImage() invalid image view");
            return;
        }
        imageView0.setTag(s);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(d0), null, null, new n(s, v, s1, null) {
            final long $albumId1;
            final String $albumKey;
            final ImageView $imageView;
            final String $path;
            int label;

            {
                this.$imageView = imageView0;
                this.$path = s;
                this.$albumId1 = v;
                this.$albumKey = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showAlbumImage.1(this.$imageView, this.$path, this.$albumId1, this.$albumKey, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showAlbumImage.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.$imageView.setImageDrawable(null);
                        Context context0 = this.$imageView.getContext();
                        this.label = 1;
                        object0 = f.a.a(context0, this.$path, this.$albumId1, this.$albumKey, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(q.b(this.$imageView.getTag(), this.$path)) {
                    ((RequestBuilder)Glide.with(this.$imageView).load(((Uri)object0)).error(0x7F08093C)).into(this.$imageView);  // drawable:transparent
                }
                return H.a;
            }
        }, 3, null);
    }

    public void showDeleteConfirmPopup(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(this), Dispatchers.getDefault(), null, new n(z, null) {
            final boolean $removeAll;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;

            {
                LocalContentNewDbBaseFragment.this = localContentNewDbBaseFragment0;
                this.$removeAll = z;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1(LocalContentNewDbBaseFragment.this, this.$removeAll, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                y y0;
                String[] arr_s1;
                ne.a a0 = ne.a.a;
                H h0 = H.a;
                boolean z = true;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        arr_s1 = LocalContentNewDbBaseFragment.this.checkedListString();
                        if(arr_s1 != null) {
                            B b0 = ((d3)LocalContentNewDbBaseFragment.this.playlistManager).g();
                            this.L$0 = arr_s1;
                            this.label = 1;
                            object0 = ListenableFutureKt.await(b0, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_22;
                        }
                        break;
                    }
                    case 1: {
                        arr_s1 = (String[])this.L$0;
                        d5.n.D(object0);
                    label_22:
                        Q q1 = ((oc.H)object0).getState();
                        if(q1 instanceof O) {
                            LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                            Iterator iterator0 = ((O)q1).d().iterator();
                            while(iterator0.hasNext()) {
                                iterator0.next();
                            }
                            y0 = linkedHashSet0;
                        }
                        else {
                            y0 = y.a;
                        }
                        for(int v = 0; true; ++v) {
                            if(v >= arr_s1.length) {
                                z = false;
                                break;
                            }
                            if(je.p.d0(y0, arr_s1[v])) {
                                break;
                            }
                        }
                        com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1 localContentNewDbBaseFragment$showDeleteConfirmPopup$1$10 = new n(LocalContentNewDbBaseFragment.this, this.$removeAll, null) {
                            final boolean $isInSelectRepeatList;
                            final boolean $removeAll;
                            int label;

                            {
                                this.$isInSelectRepeatList = z;
                                LocalContentNewDbBaseFragment.this = localContentNewDbBaseFragment0;
                                this.$removeAll = z1;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1(this.$isInSelectRepeatList, LocalContentNewDbBaseFragment.this, this.$removeAll, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                if(this.$isInSelectRepeatList) {
                                    h h0 = LocalContentNewDbBaseFragment.this.getPlayerUiHelper();
                                    l0 l00 = LocalContentNewDbBaseFragment.this.getChildFragmentManager();
                                    q.f(l00, "getChildFragmentManager(...)");
                                    h0.e(l00, new r(LocalContentNewDbBaseFragment.this, this.$removeAll));
                                    return H.a;
                                }
                                LocalContentNewDbBaseFragment.this.showDeleteConfirmPopupReal(this.$removeAll);
                                return H.a;

                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                                @e(c = "com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment$showDeleteConfirmPopup$1$1$1$1", f = "LocalContentNewDbBaseFragment.kt", l = {474}, m = "invokeSuspend")
                                final class com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1.1.1 extends oe.i implements n {
                                    final boolean $removeAll;
                                    int label;

                                    public com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1.1.1(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, boolean z, Continuation continuation0) {
                                        LocalContentNewDbBaseFragment.this = localContentNewDbBaseFragment0;
                                        this.$removeAll = z;
                                        super(2, continuation0);
                                    }

                                    @Override  // oe.a
                                    public final Continuation create(Object object0, Continuation continuation0) {
                                        return new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1.1.1(LocalContentNewDbBaseFragment.this, this.$removeAll, continuation0);
                                    }

                                    @Override  // we.n
                                    public Object invoke(Object object0, Object object1) {
                                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                    }

                                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                        return ((com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                    }

                                    @Override  // oe.a
                                    public final Object invokeSuspend(Object object0) {
                                        ne.a a0 = ne.a.a;
                                        switch(this.label) {
                                            case 0: {
                                                d5.n.D(object0);
                                                z z0 = LocalContentNewDbBaseFragment.this.getPlayerUseCase();
                                                this.label = 1;
                                                if(z0.b(0x7F13090F, this) == a0) {  // string:section_repeat_mode_release_toast "반복재생이 해제되었습니다.\n반복재생은 재생 목록에서 재설정 가능합니다."
                                                    return a0;
                                                }
                                                break;
                                            }
                                            case 1: {
                                                d5.n.D(object0);
                                                break;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                        LocalContentNewDbBaseFragment.this.showDeleteConfirmPopupReal(this.$removeAll);
                                        return H.a;
                                    }
                                }

                            }

                            private static final H invokeSuspend$lambda$0(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, boolean z) {
                                BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(localContentNewDbBaseFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showDeleteConfirmPopup.1.1.1.1(localContentNewDbBaseFragment0, z, null), 2, null);
                                return H.a;
                            }
                        };
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.I$0 = z;
                        this.label = 2;
                        if(BuildersKt.withContext(Dispatchers.getMain(), localContentNewDbBaseFragment$showDeleteConfirmPopup$1$10, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 2: {
                        Set set0 = (Set)this.L$3;
                        Q q0 = (Q)this.L$2;
                        oc.H h1 = (oc.H)this.L$1;
                        String[] arr_s = (String[])this.L$0;
                        d5.n.D(object0);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return h0;
            }
        }, 2, null);
    }

    private final void showDeleteConfirmPopupReal(boolean z) {
        String s;
        int v;
        if(!z) {
            Object object0 = this.getContentAdapter();
            if(object0 instanceof ListMarker) {
                v = ((ListMarker)object0).getMarkedCount();
                if(v == 0) {
                    v = 1;
                }
            }
            else {
                v = 0;
            }
            this.delSongCount = v;
            s = this.getLocalTrackType() == 4 ? o.i(v, this.getString(0x7F130089)) : o.i(v, this.getString(0x7F130095));  // string:alert_dlg_body_delete_local_playlist_select_content "곡을 로컬 플레이리스트에서 삭제 하시겠습니까?"
        }
        else if(this.getLocalTrackType() == 4) {
            s = this.getString(0x7F13008F);  // string:alert_dlg_body_delete_playlist_all_content "전체곡을 로컬 플레이리스트에서 삭제하시겠습니까?"
        }
        else {
            s = this.getString(0x7F130085);  // string:alert_dlg_body_delete_download_content "모든 파일을 완전히 하시겠습니까?"
        }
        q.d(s);
        com.melon.ui.popup.b.x(this.getChildFragmentManager(), this.getString(0x7F1300CD), s, false, false, null, null, new c(this, 4), null, null, null, 0xEF8);  // string:alert_dlg_title_delete_confirm "안내"
    }

    private static final H showDeleteConfirmPopupReal$lambda$4(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0) {
        localContentNewDbBaseFragment0.removeSongs();
        return H.a;
    }

    public final void showMoreContextPopup(@Nullable Playable playable0) {
        if(this.isAdded() && this.isPossiblePopupShow()) {
            if(!(this.getAdapter() instanceof d) || !(this.getAdapter() instanceof ListMarker)) {
                goto label_27;
            }
            j0 j00 = this.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.adapters.common.EditMode");
            if(((d)j00).isInEditMode()) {
                String s = this.getTAG();
                LogU.Companion.d(s, "showMoreContextPopup() - ignore in edit mode");
                return;
            }
            if(playable0 != null) {
                if(!playable0.isTypeOfEdu() && !playable0.isMelonSong()) {
                    ToastManager.show(this.getString(0x7F13050C));  // string:localplaylist_only_melon_download "멜론에서 다운받은 곡만 상세정보 확인이 가능합니다."
                    return;
                }
                playable0.setMenuid(this.mPlaybackMenuId);
                String s1 = this.getTAG();
                LogU.Companion.d(s1, "playback menu id : " + this.mPlaybackMenuId);
                long v = playable0.getMediaStoreAlbumId();
                if(StorageUtils.isScopedStorage()) {
                    q.d("");
                }
                else {
                    q.d("");
                }
                kotlin.jvm.internal.H h0 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                D d0 = this.getViewLifecycleOwner();
                q.f(d0, "getViewLifecycleOwner(...)");
                BuildersKt__Builders_commonKt.launch$default(androidx.lifecycle.f0.f(d0), null, null, new n(this, "", v, "", null) {
                    final long $albumId1;
                    final String $albumKey;
                    final String $imgPath;
                    final kotlin.jvm.internal.H $uri;
                    Object L$0;
                    int label;

                    {
                        this.$uri = h0;
                        LocalContentNewDbBaseFragment.this = localContentNewDbBaseFragment0;
                        this.$imgPath = s;
                        this.$albumId1 = v;
                        this.$albumKey = s1;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showMoreContextPopup.1(this.$uri, LocalContentNewDbBaseFragment.this, this.$imgPath, this.$albumId1, this.$albumKey, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.local.LocalContentNewDbBaseFragment.showMoreContextPopup.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        kotlin.jvm.internal.H h1;
                        ne.a a0 = ne.a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                kotlin.jvm.internal.H h0 = this.$uri;
                                Context context0 = LocalContentNewDbBaseFragment.this.getContext();
                                this.L$0 = h0;
                                this.label = 1;
                                Comparable comparable0 = f.a.a(context0, this.$imgPath, this.$albumId1, this.$albumKey, this);
                                if(comparable0 == a0) {
                                    return a0;
                                }
                                h1 = h0;
                                object0 = comparable0;
                                break;
                            }
                            case 1: {
                                h1 = (kotlin.jvm.internal.H)this.L$0;
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        h1.a = object0;
                        return H.a;
                    }
                }, 3, null);
                B0 b00 = new B0(playable0, ((Uri)h0.a));
                com.melon.ui.popup.b.o(this.getChildFragmentManager(), b00, new Hd.D(this, playable0, false, "", 2), 4);
                return;
            label_27:
                String s2 = this.getTAG();
                LogU.Companion.d(s2, "showMoreContextPopup() - invalid adapter");
            }
        }
    }

    private static final H showMoreContextPopup$lambda$3(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, Playable playable0, boolean z, String s, k2 k20) {
        q.g(k20, "onEvent");
        H h0 = H.a;
        if(k20 instanceof x1) {
            localContentNewDbBaseFragment0.showArtistInfoPage(playable0, true);
            return h0;
        }
        if(k20 instanceof f2) {
            localContentNewDbBaseFragment0.showSongInfoPage("");
            return h0;
        }
        if(k20 instanceof w1) {
            localContentNewDbBaseFragment0.showAlbumInfoPage(playable0);
            return h0;
        }
        if(k20 instanceof N1) {
            localContentNewDbBaseFragment0.showMvInfoPage(playable0);
            return h0;
        }
        if(k20 instanceof L1) {
            if(localContentNewDbBaseFragment0.checkLoginIfNeedToShowMsg()) {
                File file0 = SongMetaParser.getLyricFile(playable0);
                if(file0 != null && file0.exists()) {
                    ToastManager.show(localContentNewDbBaseFragment0.getString(0x7F130508));  // string:localplaylist_download_lyric_already "이미 다운로드한 가사가 있습니다."
                    return h0;
                }
                localContentNewDbBaseFragment0.lyricDownload(playable0);
                return h0;
            }
        }
        else if(k20 instanceof K1) {
            switch(((K1)k20).b.a.ordinal()) {
                case 0: {
                    localContentNewDbBaseFragment0.playSong(playable0, true);
                    break;
                }
                case 7: {
                    localContentNewDbBaseFragment0.showTrackAddToLocalPlaylistPopup(localContentNewDbBaseFragment0.getString(0x7F1300D2), playable0.isTypeOfEdu(), playable0);  // string:alert_dlg_title_myalbum_add "담기"
                    return h0;
                }
                case 9: {
                    localContentNewDbBaseFragment0.showSongInfoPage("");
                    return h0;
                }
                case 10: {
                    localContentNewDbBaseFragment0.showAlbumInfoPage(playable0);
                    return h0;
                }
                case 16: {
                    localContentNewDbBaseFragment0.showMvInfoPage(playable0);
                    return h0;
                }
                case 22: {
                    localContentNewDbBaseFragment0.delType = 1;
                    localContentNewDbBaseFragment0.showDeleteConfirmPopup(false);
                    return h0;
                }
                default: {
                    return h0;
                }
            }
        }
        return h0;
    }

    public void showTrackAddToLocalPlaylistPopup(@Nullable String s, boolean z, @Nullable Playable playable0) {
        this.showTrackAddToLocalPlaylistPopup(s, new com.iloen.melon.fragments.local.q(this, playable0));
    }

    private static final void showTrackAddToLocalPlaylistPopup$lambda$2(LocalContentNewDbBaseFragment localContentNewDbBaseFragment0, Playable playable0, M m0) {
        if(M.S == m0) {
            localContentNewDbBaseFragment0.playSong(playable0, false);
            return;
        }
        if(M.V == m0) {
            localContentNewDbBaseFragment0.showLocalPlaylistPopup(playable0);
        }
    }

    public abstract void startQuery();
}

