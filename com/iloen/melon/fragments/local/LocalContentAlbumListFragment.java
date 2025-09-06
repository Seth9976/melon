package com.iloen.melon.fragments.local;

import E9.w;
import G8.f;
import G8.g;
import H8.a;
import H8.k;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.B1;
import com.melon.ui.K1;
import com.melon.ui.k2;
import ie.H;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ob.z;
import oe.e;
import oe.i;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import we.n;
import zd.M;

@Metadata(d1 = {"\u0000\u009A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0007\u0018\u0000 I2\u00020\u0001:\u0003IJKB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0014\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u0010\u001A\u00020\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0014\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0014\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u0019\u001A\u00020\u00182\b\u0010\u001B\u001A\u0004\u0018\u00010\u001A2\b\u0010\u001C\u001A\u0004\u0018\u00010\rH\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u001B\u0010#\u001A\u0006\u0012\u0002\b\u00030\"2\u0006\u0010!\u001A\u00020 H\u0014\u00A2\u0006\u0004\b#\u0010$J!\u0010)\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020%2\b\u0010(\u001A\u0004\u0018\u00010\'H\u0016\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010,\u001A\u00020\u000F2\u0006\u0010+\u001A\u00020\bH\u0016\u00A2\u0006\u0004\b,\u0010-J\u0017\u00100\u001A\u00020\u000F2\u0006\u0010/\u001A\u00020.H\u0007\u00A2\u0006\u0004\b0\u00101J\u000F\u00102\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b2\u0010\u0003J\u000F\u00103\u001A\u00020\u000FH\u0002\u00A2\u0006\u0004\b3\u0010\u0003J \u00106\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\b052\u0006\u00104\u001A\u00020%H\u0082@\u00A2\u0006\u0004\b6\u00107J \u0010:\u001A\n\u0012\u0004\u0012\u000209\u0018\u0001082\u0006\u00104\u001A\u00020%H\u0082@\u00A2\u0006\u0004\b:\u00107J\u0017\u0010;\u001A\u00020\u000F2\u0006\u00104\u001A\u00020%H\u0002\u00A2\u0006\u0004\b;\u0010<J\u001E\u0010>\u001A\b\u0012\u0004\u0012\u00020=082\u0006\u00104\u001A\u00020%H\u0082@\u00A2\u0006\u0004\b>\u00107J\u0017\u0010?\u001A\u00020\u000F2\u0006\u00104\u001A\u00020%H\u0002\u00A2\u0006\u0004\b?\u0010<J\u0017\u0010@\u001A\u00020\u000F2\u0006\u00104\u001A\u00020%H\u0002\u00A2\u0006\u0004\b@\u0010<J\u0017\u0010A\u001A\u00020\u000F2\u0006\u00104\u001A\u00020%H\u0002\u00A2\u0006\u0004\bA\u0010<R\u0014\u0010B\u001A\u00020\b8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010D\u001A\u00020\b8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010CR \u0010E\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u0001058\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001A\u00020%8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010H\u00A8\u0006L"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment;", "Lcom/iloen/melon/fragments/local/LocalContentListFragment;", "<init>", "()V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "", "nResult", "", "clientData", "onRemoveComplete", "(ILjava/lang/Object;)V", "playlistId", "onAddSongsToLocalPlaylist", "(Ljava/lang/String;)V", "Lcom/iloen/melon/eventbus/EventAudioSync$Finish;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventAudioSync$Finish;)V", "startQuery", "removeAlbum", "position", "", "checkedListString", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "LH8/k;", "getCheckedAlbumSongList", "showAlbumListPopup", "(I)V", "Lcom/iloen/melon/playback/Playable;", "getPlayableList", "deleteAlbum", "goAlbumListPage", "showTrackAddToLocalPlaylistPopup", "TAG", "Ljava/lang/String;", "selectedAlbumTitle", "checkedListItems", "[Ljava/lang/String;", "selectedAlbumCount", "I", "Companion", "LocalAlbumAdapter", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class LocalContentAlbumListFragment extends LocalContentListFragment {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment;", "isFlac", "", "playbackMenuId", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final LocalContentAlbumListFragment newInstance(boolean z, @Nullable String s) {
            LocalContentAlbumListFragment localContentAlbumListFragment0 = new LocalContentAlbumListFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putBoolean("argIsFlac", z);
            bundle0.putBoolean("argVisibleWhenActivate", true);
            bundle0.putString("argPlaybackMenuId", s);
            localContentAlbumListFragment0.setArguments(bundle0);
            return localContentAlbumListFragment0;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0011\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u0010\u001A\u00020\u000F2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\u0006\u0010\u000E\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u001D\u0010\u001EJ)\u0010 \u001A\u00020\u000F2\b\u0010\u001F\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0017\u001A\u00020\u0015H\u0016¢\u0006\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment$LocalAlbumAdapter;", "Lcom/iloen/melon/adapters/common/p;", "LH8/a;", "Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment$ViewHolder;", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment;Landroid/content/Context;)V", "Landroid/widget/ImageView;", "imageView", "", "albumId1", "", "albumKey", "path", "Lie/H;", "showBgImage", "(Landroid/widget/ImageView;JLjava/lang/String;Ljava/lang/String;)V", "date", "parseDate", "(Ljava/lang/String;)Ljava/lang/String;", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment$ViewHolder;", "viewHolder", "onBindViewImpl", "(Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment$ViewHolder;II)V", "ALBUM", "I", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class LocalAlbumAdapter extends p {
        private final int ALBUM;

        public LocalAlbumAdapter(@Nullable Context context0) {
            super(context0, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.ALBUM;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(O0 o00, int v, int v1) {
            this.onBindViewImpl(((ViewHolder)o00), v, v1);
        }

        public void onBindViewImpl(@Nullable ViewHolder localContentAlbumListFragment$ViewHolder0, int v, int v1) {
            if(localContentAlbumListFragment$ViewHolder0 != null) {
                LocalContentAlbumListFragment localContentAlbumListFragment0 = LocalContentAlbumListFragment.this;
                a a0 = (a)this.getItem(v1);
                String s = StorageUtils.isScopedStorage() ? a0.b : a0.a;
                this.showBgImage(localContentAlbumListFragment$ViewHolder0.getThumbnailView(), a0.f, a0.d, s);
                ViewUtils.setOnClickListener(localContentAlbumListFragment$ViewHolder0.getBtnPlay(), new com.iloen.melon.fragments.local.a(localContentAlbumListFragment0, v1, 0));
                String s1 = a0.c;
                TextView textView0 = localContentAlbumListFragment$ViewHolder0.getTitleView();
                if(TextUtils.isEmpty(s1)) {
                    s1 = "";
                }
                textView0.setText(s1);
                ViewUtils.setTextViewMarquee(localContentAlbumListFragment$ViewHolder0.getTitleView(), this.isMarqueeNeeded(v1));
                localContentAlbumListFragment$ViewHolder0.getTitleView().requestLayout();
                localContentAlbumListFragment$ViewHolder0.getCountView().setText(StringUtils.getFormattedStringNumber(a0.i));
                if(localContentAlbumListFragment$ViewHolder0.getArtistNameView() != null) {
                    ViewUtils.showWhen(localContentAlbumListFragment$ViewHolder0.getArtistNameView(), !TextUtils.isEmpty(a0.g));
                    TextView textView1 = localContentAlbumListFragment$ViewHolder0.getArtistNameView();
                    q.d(textView1);
                    textView1.setText(a0.g);
                }
                if(localContentAlbumListFragment$ViewHolder0.getIssueDateView() != null) {
                    String s2 = String.valueOf(a0.h);
                    ViewUtils.showWhen(localContentAlbumListFragment$ViewHolder0.getIssueDateView(), !TextUtils.isEmpty(s2));
                    TextView textView2 = localContentAlbumListFragment$ViewHolder0.getIssueDateView();
                    q.d(textView2);
                    textView2.setText(this.parseDate(s2));
                }
                ViewUtils.setOnClickListener(localContentAlbumListFragment$ViewHolder0.getRootView(), new com.iloen.melon.fragments.local.a(localContentAlbumListFragment0, v1, 1));
                ViewUtils.setOnLongClickListener(localContentAlbumListFragment$ViewHolder0.getRootView(), new b(this, v1, localContentAlbumListFragment0, 0));
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
            @e(c = "com.iloen.melon.fragments.local.LocalContentAlbumListFragment$LocalAlbumAdapter$onBindViewImpl$1$1$1", f = "LocalContentAlbumListFragment.kt", l = {451}, m = "invokeSuspend")
            final class com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.onBindViewImpl.1.1.1 extends i implements n {
                final int $position;
                int label;

                public com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.onBindViewImpl.1.1.1(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, Continuation continuation0) {
                    LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                    this.$position = v;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.onBindViewImpl.1.1.1(LocalContentAlbumListFragment.this, this.$position, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.onBindViewImpl.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            this.label = 1;
                            object0 = LocalContentAlbumListFragment.this.getPlayableList(this.$position, this);
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
                    ArrayList arrayList0 = new ArrayList(((List)object0));
                    LocalContentAlbumListFragment.this.playSongs(arrayList0, true, false, false);
                    return H.a;
                }
            }

        }

        private static final void onBindViewImpl$lambda$3$lambda$0(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, View view0) {
            f0.f(localContentAlbumListFragment0).a(new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.onBindViewImpl.1.1.1(localContentAlbumListFragment0, v, null));
        }

        private static final void onBindViewImpl$lambda$3$lambda$1(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, View view0) {
            localContentAlbumListFragment0.goAlbumListPage(v);
        }

        private static final boolean onBindViewImpl$lambda$3$lambda$2(LocalAlbumAdapter localContentAlbumListFragment$LocalAlbumAdapter0, int v, LocalContentAlbumListFragment localContentAlbumListFragment0, View view0) {
            localContentAlbumListFragment$LocalAlbumAdapter0.setWeakMarked(v);
            localContentAlbumListFragment0.showAlbumListPopup(v);
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public O0 onCreateViewHolderImpl(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolderImpl(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0498, viewGroup0, false);  // layout:listitem_local_album
            q.f(view0, "inflate(...)");
            return new ViewHolder(view0);
        }

        private final String parseDate(String s) {
            if(!TextUtils.isEmpty(s) && s.length() >= 4) {
                Locale locale0 = Locale.KOREA;
                SimpleDateFormat simpleDateFormat0 = new SimpleDateFormat("yyyyMMdd", locale0);
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy.MM.dd", locale0);
                try {
                    Date date0 = simpleDateFormat0.parse(s);
                    if(date0 != null) {
                        String s1 = simpleDateFormat1.format(date0);
                        q.f(s1, "format(...)");
                        return s1;
                    }
                }
                catch(ParseException parseException0) {
                    LogU.Companion.w(LocalContentAlbumListFragment.this.TAG, "parseDate() - " + parseException0);
                }
                return s;
            }
            return "";
        }

        private final void showBgImage(ImageView imageView0, long v, String s, String s1) {
            if(imageView0 == null) {
                LogU.Companion.w(LocalContentAlbumListFragment.this.TAG, "showAlbumImage() invalid image view");
                return;
            }
            imageView0.setTag(s);
            D d0 = LocalContentAlbumListFragment.this.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(s1, v, s, null) {
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
                    return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.showBgImage.1(this.$imageView, this.$path, this.$albumId1, this.$albumKey, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.LocalAlbumAdapter.showBgImage.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    ne.a a0 = ne.a.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
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
                    if(q.b(this.$imageView.getTag(), this.$albumKey)) {
                        Glide.with(this.$imageView).load(((Uri)object0)).into(this.$imageView);
                    }
                    return H.a;
                }
            }, 3, null);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000E\b\u0002\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\bR$\u0010\n\u001A\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR$\u0010\u0010\u001A\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u000B\u001A\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000FR\u0017\u0010\u0014\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001A\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001A\u0004\b\u0019\u0010\u0017R$\u0010\u001A\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001A\u0010\u0015\u001A\u0004\b\u001B\u0010\u0017\"\u0004\b\u001C\u0010\u001DR$\u0010\u001E\u001A\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001E\u0010\u0015\u001A\u0004\b\u001F\u0010\u0017\"\u0004\b \u0010\u001D¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentAlbumListFragment$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "Landroid/view/View;", "getRootView", "()Landroid/view/View;", "Landroid/widget/ImageView;", "btnPlay", "Landroid/widget/ImageView;", "getBtnPlay", "()Landroid/widget/ImageView;", "setBtnPlay", "(Landroid/widget/ImageView;)V", "thumbnailView", "getThumbnailView", "setThumbnailView", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "countView", "getCountView", "artistNameView", "getArtistNameView", "setArtistNameView", "(Landroid/widget/TextView;)V", "issueDateView", "getIssueDateView", "setIssueDateView", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ViewHolder extends O0 {
        @Nullable
        private TextView artistNameView;
        @Nullable
        private ImageView btnPlay;
        @NotNull
        private final TextView countView;
        @Nullable
        private TextView issueDateView;
        @NotNull
        private final View rootView;
        @Nullable
        private ImageView thumbnailView;
        @NotNull
        private final TextView titleView;

        public ViewHolder(@NotNull View view0) {
            q.g(view0, "rootView");
            super(view0);
            this.rootView = view0;
            View view1 = view0.findViewById(0x7F0A0D34);  // id:tv_title
            q.f(view1, "findViewById(...)");
            this.titleView = (TextView)view1;
            View view2 = view0.findViewById(0x7F0A0C50);  // id:tv_count
            q.f(view2, "findViewById(...)");
            this.countView = (TextView)view2;
            this.btnPlay = (ImageView)view0.findViewById(0x7F0A0182);  // id:btn_play
            this.thumbnailView = (ImageView)view0.findViewById(0x7F0A069A);  // id:iv_thumb
            this.artistNameView = (TextView)view0.findViewById(0x7F0A0C12);  // id:tv_artist
            this.issueDateView = (TextView)view0.findViewById(0x7F0A0C92);  // id:tv_issue
        }

        @Nullable
        public final TextView getArtistNameView() {
            return this.artistNameView;
        }

        @Nullable
        public final ImageView getBtnPlay() {
            return this.btnPlay;
        }

        @NotNull
        public final TextView getCountView() {
            return this.countView;
        }

        @Nullable
        public final TextView getIssueDateView() {
            return this.issueDateView;
        }

        @NotNull
        public final View getRootView() {
            return this.rootView;
        }

        @Nullable
        public final ImageView getThumbnailView() {
            return this.thumbnailView;
        }

        @NotNull
        public final TextView getTitleView() {
            return this.titleView;
        }

        public final void setArtistNameView(@Nullable TextView textView0) {
            this.artistNameView = textView0;
        }

        public final void setBtnPlay(@Nullable ImageView imageView0) {
            this.btnPlay = imageView0;
        }

        public final void setIssueDateView(@Nullable TextView textView0) {
            this.issueDateView = textView0;
        }

        public final void setThumbnailView(@Nullable ImageView imageView0) {
            this.thumbnailView = imageView0;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[M.values().length];
            try {
                arr_v[24] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[26] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[25] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final String TAG;
    @Nullable
    private String[] checkedListItems;
    private int selectedAlbumCount;
    @NotNull
    private String selectedAlbumTitle;

    static {
        LocalContentAlbumListFragment.Companion = new Companion(null);
        LocalContentAlbumListFragment.$stable = 8;
    }

    public LocalContentAlbumListFragment() {
        this.TAG = "LocalContentAlbumListFragment";
        this.selectedAlbumTitle = "";
    }

    private final Object checkedListString(int v, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new n(v, null) {
            final int $position;
            int label;

            {
                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.checkedListString.2(LocalContentAlbumListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.checkedListString.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        object0 = LocalContentAlbumListFragment.this.getCheckedAlbumSongList(this.$position, this);
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
                int v = 0;
                String[] arr_s = new String[(((List)object0) == null ? 0 : ((List)object0).size())];
                if(((List)object0) != null) {
                    for(Object object1: ((List)object0)) {
                        if(v >= 0) {
                            arr_s[v] = StorageUtils.isScopedStorage() ? ((k)object1).c : ((k)object1).b;
                            ++v;
                            continue;
                        }
                        e.k.O();
                        throw null;
                    }
                }
                return arr_s;
            }
        }, continuation0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new LocalAlbumAdapter(this, this.getContext());
    }

    private final void deleteAlbum(int v) {
        if(this.isAdded()) {
            j0 j00 = this.mAdapter;
            if(j00 != null && j00 instanceof LocalAlbumAdapter) {
                f0.f(this).a(new n(v, this, null) {
                    final j0 $adapter;
                    final int $position;
                    int label;

                    {
                        this.$adapter = j00;
                        this.$position = v;
                        LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.deleteAlbum.1.1(this.$adapter, this.$position, LocalContentAlbumListFragment.this, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.deleteAlbum.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        String s = ((a)((LocalAlbumAdapter)this.$adapter).getItem(this.$position)).c;
                        LocalContentAlbumListFragment.this.selectedAlbumTitle = s;
                        l0 l00 = LocalContentAlbumListFragment.this.getChildFragmentManager();
                        String s1 = LocalContentAlbumListFragment.this.getString(0x7F1300CD);  // string:alert_dlg_title_delete_confirm "안내"
                        c c0 = new c(LocalContentAlbumListFragment.this, 0);
                        com.melon.ui.popup.b.x(l00, s1, LocalContentAlbumListFragment.this.selectedAlbumTitle + "의 모든 파일을 완전히 삭제하시겠습니까?", false, false, null, null, c0, null, null, null, 0xEF8);
                        return H.a;
                    }

                    private static final H invokeSuspend$lambda$0(LocalContentAlbumListFragment localContentAlbumListFragment0) {
                        localContentAlbumListFragment0.removeAlbum();
                        return H.a;
                    }
                });
            }
        }
    }

    private final Object getCheckedAlbumSongList(int v, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new n(v, null) {
            final int $position;
            int label;

            {
                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.getCheckedAlbumSongList.2(LocalContentAlbumListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.getCheckedAlbumSongList.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                j0 j00 = LocalContentAlbumListFragment.this.mAdapter;
                if(j00 != null) {
                    int v = this.$position;
                    LocalContentAlbumListFragment localContentAlbumListFragment0 = LocalContentAlbumListFragment.this;
                    if(j00 instanceof LocalAlbumAdapter) {
                        a a0 = (a)((LocalAlbumAdapter)j00).getItem(v);
                        z6.f f0 = g.a;
                        if(localContentAlbumListFragment0.mIsFlac) {
                            f0.m();
                            q.g(a0.d, "albumKey");
                            return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(a0.d, 13));
                        }
                        f0.m();
                        q.g(a0.d, "albumKey");
                        return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Ac.g(a0.d, 16));
                    }
                }
                return null;
            }
        }, continuation0);
    }

    private final Object getPlayableList(int v, Continuation continuation0) {
        g g1;
        com.iloen.melon.fragments.local.LocalContentAlbumListFragment.getPlayableList.1 localContentAlbumListFragment$getPlayableList$10;
        if(continuation0 instanceof com.iloen.melon.fragments.local.LocalContentAlbumListFragment.getPlayableList.1) {
            localContentAlbumListFragment$getPlayableList$10 = (com.iloen.melon.fragments.local.LocalContentAlbumListFragment.getPlayableList.1)continuation0;
            int v1 = localContentAlbumListFragment$getPlayableList$10.label;
            if((v1 & 0x80000000) == 0) {
                localContentAlbumListFragment$getPlayableList$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                    int I$0;
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getPlayableList(0, this);
                    }
                };
            }
            else {
                localContentAlbumListFragment$getPlayableList$10.label = v1 ^ 0x80000000;
            }
        }
        else {
            localContentAlbumListFragment$getPlayableList$10 = new oe.c(/*ERROR_MISSING_ARG_1/*) {
                int I$0;
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getPlayableList(0, this);
                }
            };
        }
        Object object0 = localContentAlbumListFragment$getPlayableList$10.result;
        ne.a a0 = ne.a.a;
        switch(localContentAlbumListFragment$getPlayableList$10.label) {
            case 0: {
                d5.n.D(object0);
                g g0 = g.a.m();
                localContentAlbumListFragment$getPlayableList$10.L$0 = g0;
                localContentAlbumListFragment$getPlayableList$10.I$0 = v;
                localContentAlbumListFragment$getPlayableList$10.label = 1;
                Object object1 = this.getCheckedAlbumSongList(v, localContentAlbumListFragment$getPlayableList$10);
                if(object1 == a0) {
                    return a0;
                }
                object0 = object1;
                g1 = g0;
                break;
            }
            case 1: {
                g1 = (g)localContentAlbumListFragment$getPlayableList$10.L$0;
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        List list0 = (List)object0;
        if(list0 == null) {
            list0 = je.w.a;
        }
        String s = this.mPlaybackMenuId;
        q.f(s, "mPlaybackMenuId");
        g1.getClass();
        return g.i(s, list0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return this.mIsFlac ? new PvLogDummyReq(this.getContext(), "storageboxSaveFlacAlbum") : new PvLogDummyReq(this.getContext(), "storageboxSaveSongAlbum");
    }

    private final void goAlbumListPage(int v) {
        j0 j00 = this.mAdapter;
        if(j00 != null && j00 instanceof LocalAlbumAdapter) {
            a a0 = (a)((LocalAlbumAdapter)j00).getItem(v);
            LogU.Companion.d(this.TAG, "onRecyclerViewItemClick() album:" + a0.c + ", albumId:" + a0.f);
            ParamInfo localContentNewDbBaseFragment$ParamInfo0 = Builder.Companion.newInstance().album(a0.c).albumKey(a0.d).albumId1(a0.f).isFlac(this.mIsFlac).build();
            LocalContentAlbumSongFragment.Companion.newInstance(localContentNewDbBaseFragment$ParamInfo0, this.mPlaybackMenuId).open();
        }
    }

    @NotNull
    public static final LocalContentAlbumListFragment newInstance(boolean z, @Nullable String s) {
        return LocalContentAlbumListFragment.Companion.newInstance(z, s);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onAddSongsToLocalPlaylist(@NotNull String s) {
        q.g(s, "playlistId");
        LogU.Companion.d(this.TAG, "onAddSongsToLocalPlaylist() playlistId:" + s);
        f0.f(this).a(new n(s, null) {
            final String $playlistId;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;

            {
                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                this.$playlistId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.onAddSongsToLocalPlaylist.1(LocalContentAlbumListFragment.this, this.$playlistId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.onAddSongsToLocalPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                String s1;
                LocalContentAlbumListFragment localContentAlbumListFragment0;
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        j0 j00 = LocalContentAlbumListFragment.this.mAdapter;
                        if(j00 != null) {
                            localContentAlbumListFragment0 = LocalContentAlbumListFragment.this;
                            String s = this.$playlistId;
                            if(j00 instanceof LocalAlbumAdapter) {
                                int v = ((LocalAlbumAdapter)j00).getWeakMarked();
                                this.L$0 = localContentAlbumListFragment0;
                                this.L$1 = s;
                                this.L$2 = null;
                                this.I$0 = 0;
                                this.label = 1;
                                object0 = localContentAlbumListFragment0.getPlayableList(v, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                s1 = s;
                                goto label_24;
                            }
                        }
                        break;
                    }
                    case 1: {
                        j0 j01 = (j0)this.L$2;
                        s1 = (String)this.L$1;
                        localContentAlbumListFragment0 = (LocalContentAlbumListFragment)this.L$0;
                        d5.n.D(object0);
                    label_24:
                        if(((List)object0) == null || ((List)object0).isEmpty()) {
                            ToastManager.show(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
                        }
                        ArrayList arrayList0 = new ArrayList(((List)object0));
                        Integer integer0 = Integer.valueOf(s1);
                        q.f(integer0, "valueOf(...)");
                        localContentAlbumListFragment0.addToLocalPlaylist(arrayList0, integer0.intValue());
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        });
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A09D1);  // id:recycler_view
        if(recyclerView0 != null) {
            recyclerView0.setLayoutManager(new LinearLayoutManager(this.getActivity()));
            recyclerView0.setHasFixedSize(true);
            recyclerView0.setAdapter(this.mAdapter);
        }
        return recyclerView0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02B2, viewGroup0, false);  // layout:fragment_local_list
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@NotNull Finish eventAudioSync$Finish0) {
        q.g(eventAudioSync$Finish0, "event");
        if(this.isFragmentValid() && eventAudioSync$Finish0.getUpdateCount() > 0) {
            this.startQuery();
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull v9.i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        this.startQuery();
        return true;
    }

    @Override  // com.iloen.melon.fragments.local.LocalContentListFragment
    public void onRemoveComplete(int v, @Nullable Object object0) {
        this.showProgress(false);
        this.setSelectAllWithToolbar(false);
        switch(v) {
            case 1: {
                ToastManager.show(0x7F1302ED);  // string:delete_now_playlist_failed_for_album "재생중인 곡이 포함된 앨범은 삭제 할 수 없습니다."
                break;
            }
            case 2: {
                ToastManager.show(0x7F1302E9);  // string:delete_now_multi_failed_for_album "재생중인곡이 포함된 앨범을 제외하고 삭제하였습니다."
                break;
            }
            default: {
                ToastManager.showFormatted(0x7F1302F1, new Object[]{StringUtils.getFormattedStringNumber(this.selectedAlbumCount)});  // string:deleted_songs_of_arg1 "%1$s곡이 삭제되었습니다."
            }
        }
        this.startFetch("album::onRemoveComplete");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    private final void removeAlbum() {
        f0.f(this).a(new n(null) {
            int I$0;
            Object L$0;
            Object L$1;
            int label;

            {
                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.removeAlbum.1(LocalContentAlbumListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.removeAlbum.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        j0 j00 = LocalContentAlbumListFragment.this.getAdapter();
                        if(j00 != null) {
                            LocalContentAlbumListFragment localContentAlbumListFragment0 = LocalContentAlbumListFragment.this;
                            if(j00 instanceof LocalAlbumAdapter) {
                                localContentAlbumListFragment0.showProgress(true);
                                int v = ((LocalAlbumAdapter)j00).getWeakMarked();
                                this.L$0 = localContentAlbumListFragment0;
                                this.L$1 = null;
                                this.I$0 = 0;
                                this.label = 1;
                                object0 = localContentAlbumListFragment0.checkedListString(v, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                localContentAlbumListFragment0.removeSongs(((String[])object0));
                                return H.a;
                            }
                        }
                        break;
                    }
                    case 1: {
                        j0 j01 = (j0)this.L$1;
                        LocalContentAlbumListFragment localContentAlbumListFragment1 = (LocalContentAlbumListFragment)this.L$0;
                        d5.n.D(object0);
                        localContentAlbumListFragment1.removeSongs(((String[])object0));
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return H.a;
            }
        });
    }

    private final void showAlbumListPopup(int v) {
        LogU.Companion.d(this.TAG, "showAlbumListPopup()");
        if(this.isAdded() && (this.mAdapter != null && this.mAdapter instanceof LocalAlbumAdapter)) {
            f0.f(this).a(new n(v, null) {
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                public static final class com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.WhenMappings {
                    public static final int[] $EnumSwitchMapping$0;

                    static {
                        int[] arr_v = new int[M.values().length];
                        try {
                            arr_v[0] = 1;
                        }
                        catch(NoSuchFieldError unused_ex) {
                        }
                        try {
                            arr_v[7] = 2;
                        }
                        catch(NoSuchFieldError unused_ex) {
                        }
                        try {
                            arr_v[22] = 3;
                        }
                        catch(NoSuchFieldError unused_ex) {
                        }
                        com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.WhenMappings.$EnumSwitchMapping$0 = arr_v;
                    }
                }

                final int $position;
                long J$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                Object L$4;
                int label;

                {
                    LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                    this.$position = v;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1(LocalContentAlbumListFragment.this, this.$position, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    List list1;
                    ne.a a0 = ne.a.a;
                    H h0 = H.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            this.label = 1;
                            object0 = LocalContentAlbumListFragment.this.getCheckedAlbumSongList(this.$position, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_10;
                        }
                        case 1: {
                            d5.n.D(object0);
                        label_10:
                            LocalContentAlbumListFragment.this.selectedAlbumCount = ((List)object0) == null ? 0 : ((List)object0).size();
                            j0 j00 = LocalContentAlbumListFragment.this.mAdapter;
                            if(j00 != null) {
                                int v = this.$position;
                                LocalContentAlbumListFragment localContentAlbumListFragment0 = LocalContentAlbumListFragment.this;
                                if(j00 instanceof LocalAlbumAdapter) {
                                    localContentAlbumListFragment0.selectedAlbumTitle = ((a)((LocalAlbumAdapter)j00).getItem(v)).c;
                                }
                            }
                            this.L$0 = null;
                            this.label = 2;
                            object0 = LocalContentAlbumListFragment.this.getPlayableList(this.$position, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_24;
                        }
                        case 2: {
                            List list0 = (List)this.L$0;
                            d5.n.D(object0);
                        label_24:
                            Playable playable0 = (Playable)je.p.m0(((List)object0));
                            if(playable0 == null) {
                                return h0;
                            }
                            long v1 = playable0.getMediaStoreAlbumId();
                            if(StorageUtils.isScopedStorage()) {
                                q.d("");
                            }
                            else {
                                q.d("");
                            }
                            Context context0 = LocalContentAlbumListFragment.this.getContext();
                            this.L$0 = null;
                            this.L$1 = (List)object0;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.L$4 = null;
                            this.J$0 = v1;
                            this.label = 3;
                            Comparable comparable0 = f.a.a(context0, "", v1, "", this);
                            if(comparable0 == a0) {
                                return a0;
                            }
                            list1 = (List)object0;
                            object0 = comparable0;
                            break;
                        }
                        case 3: {
                            String s = (String)this.L$4;
                            String s1 = (String)this.L$3;
                            Playable playable1 = (Playable)this.L$2;
                            list1 = (List)this.L$1;
                            List list2 = (List)this.L$0;
                            d5.n.D(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    zd.c c0 = new zd.c(list1, ((Uri)object0));
                    com.melon.ui.popup.b.o(LocalContentAlbumListFragment.this.getChildFragmentManager(), c0, new d(LocalContentAlbumListFragment.this, this.$position, list1), 12);
                    return h0;

                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                    @e(c = "com.iloen.melon.fragments.local.LocalContentAlbumListFragment$showAlbumListPopup$1$1$2$1", f = "LocalContentAlbumListFragment.kt", l = {}, m = "invokeSuspend")
                    final class com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.1 extends i implements n {
                        final List $playableList;
                        int label;

                        public com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.1(LocalContentAlbumListFragment localContentAlbumListFragment0, List list0, Continuation continuation0) {
                            LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                            this.$playableList = list0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.1(LocalContentAlbumListFragment.this, this.$playableList, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            ArrayList arrayList0 = E9.h.W(this.$playableList);
                            LocalContentAlbumListFragment.this.playSongs(arrayList0, true, false, false);
                            return H.a;
                        }
                    }


                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                    @e(c = "com.iloen.melon.fragments.local.LocalContentAlbumListFragment$showAlbumListPopup$1$1$2$2", f = "LocalContentAlbumListFragment.kt", l = {0x102}, m = "invokeSuspend")
                    final class com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2 extends i implements n {
                        final int $position;
                        int label;

                        public com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, Continuation continuation0) {
                            LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                            this.$position = v;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2(LocalContentAlbumListFragment.this, this.$position, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            ne.a a0 = ne.a.a;
                            switch(this.label) {
                                case 0: {
                                    d5.n.D(object0);
                                    z z0 = LocalContentAlbumListFragment.this.getPlayerUseCase();
                                    this.label = 1;
                                    object0 = z0.o(this);
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
                            if(((Boolean)object0).booleanValue()) {
                                Bc.h h0 = LocalContentAlbumListFragment.this.getPlayerUiHelper();
                                l0 l00 = LocalContentAlbumListFragment.this.getChildFragmentManager();
                                q.f(l00, "getChildFragmentManager(...)");
                                h0.e(l00, new com.iloen.melon.fragments.local.k(LocalContentAlbumListFragment.this, this.$position, 2));
                                return H.a;
                            }
                            LocalContentAlbumListFragment.this.showTrackAddToLocalPlaylistPopup(this.$position);
                            return H.a;

                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
                            @e(c = "com.iloen.melon.fragments.local.LocalContentAlbumListFragment$showAlbumListPopup$1$1$2$2$1$1", f = "LocalContentAlbumListFragment.kt", l = {0x107}, m = "invokeSuspend")
                            final class com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2.1.1 extends i implements n {
                                final int $position;
                                int label;

                                public com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2.1.1(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, Continuation continuation0) {
                                    LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                                    this.$position = v;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2.1.1(LocalContentAlbumListFragment.this, this.$position, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    ne.a a0 = ne.a.a;
                                    switch(this.label) {
                                        case 0: {
                                            d5.n.D(object0);
                                            z z0 = LocalContentAlbumListFragment.this.getPlayerUseCase();
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
                                    LocalContentAlbumListFragment.this.showTrackAddToLocalPlaylistPopup(this.$position);
                                    return H.a;
                                }
                            }

                        }

                        private static final H invokeSuspend$lambda$0(LocalContentAlbumListFragment localContentAlbumListFragment0, int v) {
                            BuildersKt__Builders_commonKt.launch$default(f0.f(localContentAlbumListFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2.1.1(localContentAlbumListFragment0, v, null), 2, null);
                            return H.a;
                        }
                    }

                }

                private static final H invokeSuspend$lambda$1(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, List list0, k2 k20) {
                    if(k20 instanceof K1) {
                        switch(((K1)k20).b.a.ordinal()) {
                            case 0: {
                                D d0 = localContentAlbumListFragment0.getViewLifecycleOwner();
                                q.f(d0, "getViewLifecycleOwner(...)");
                                BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.1(localContentAlbumListFragment0, list0, null), 2, null);
                                return H.a;
                            }
                            case 7: {
                                BuildersKt__Builders_commonKt.launch$default(f0.f(localContentAlbumListFragment0), Dispatchers.getMain(), null, new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showAlbumListPopup.1.1.2.2(localContentAlbumListFragment0, v, null), 2, null);
                                return H.a;
                            }
                            case 22: {
                                localContentAlbumListFragment0.deleteAlbum(v);
                                return H.a;
                            }
                            default: {
                                return H.a;
                            }
                        }
                    }
                    if(k20 instanceof B1) {
                        localContentAlbumListFragment0.deleteAlbum(v);
                    }
                    return H.a;
                }
            });
        }
    }

    private final void showTrackAddToLocalPlaylistPopup(int v) {
        this.showTrackAddToLocalPlaylistPopup(this.selectedAlbumTitle, new com.iloen.melon.fragments.local.i(this, v, 2));

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.local.LocalContentAlbumListFragment$showTrackAddToLocalPlaylistPopup$1$1", f = "LocalContentAlbumListFragment.kt", l = {378}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showTrackAddToLocalPlaylistPopup.1.1 extends i implements n {
            final int $position;
            int label;

            public com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showTrackAddToLocalPlaylistPopup.1.1(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, Continuation continuation0) {
                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                this.$position = v;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showTrackAddToLocalPlaylistPopup.1.1(LocalContentAlbumListFragment.this, this.$position, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showTrackAddToLocalPlaylistPopup.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        object0 = LocalContentAlbumListFragment.this.getPlayableList(this.$position, this);
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
                ArrayList arrayList0 = new ArrayList(((List)object0));
                LocalContentAlbumListFragment.this.playSongs(arrayList0, false, false, false);
                return H.a;
            }
        }

    }

    private static final void showTrackAddToLocalPlaylistPopup$lambda$4(LocalContentAlbumListFragment localContentAlbumListFragment0, int v, M m0) {
        switch((m0 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[m0.ordinal()])) {
            case 1: {
                f0.f(localContentAlbumListFragment0).a(new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.showTrackAddToLocalPlaylistPopup.1.1(localContentAlbumListFragment0, v, null));
                return;
            }
            case 2: {
                localContentAlbumListFragment0.showLocalPlaylistPopup();
                return;
            }
            case 3: {
                localContentAlbumListFragment0.onAddToPlaylist(null);
            }
        }
    }

    private final void startQuery() {
        f0.f(this).a(new n(null) {
            int label;

            {
                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.startQuery.1(LocalContentAlbumListFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.startQuery.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        com.iloen.melon.fragments.local.LocalContentAlbumListFragment.startQuery.1.playlistList.1 localContentAlbumListFragment$startQuery$1$playlistList$10 = new n(null) {
                            int label;

                            {
                                LocalContentAlbumListFragment.this = localContentAlbumListFragment0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.local.LocalContentAlbumListFragment.startQuery.1.playlistList.1(LocalContentAlbumListFragment.this, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.local.LocalContentAlbumListFragment.startQuery.1.playlistList.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                if(this.label != 0) {
                                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                }
                                d5.n.D(object0);
                                z6.f f0 = g.a;
                                if(LocalContentAlbumListFragment.this.mIsFlac) {
                                    f0.m();
                                    return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Cc.K1(29));
                                }
                                f0.m();
                                return (List)w.N(((LocalContentDatabase_Impl)g.g().b), true, false, new Cc.K1(18));
                            }
                        };
                        this.label = 1;
                        object0 = BuildersKt.withContext(Dispatchers.getIO(), localContentAlbumListFragment$startQuery$1$playlistList$10, this);
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
                j0 j00 = LocalContentAlbumListFragment.this.mAdapter;
                if(j00 != null) {
                    LocalContentAlbumListFragment localContentAlbumListFragment0 = LocalContentAlbumListFragment.this;
                    if(j00 instanceof LocalAlbumAdapter) {
                        ((LocalAlbumAdapter)j00).clear();
                        ((LocalAlbumAdapter)j00).addAll(((List)object0));
                        ((LocalAlbumAdapter)j00).notifyDataSetChanged();
                        localContentAlbumListFragment0.performFetchCompleteOnlyViews();
                    }
                }
                return H.a;
            }
        });
    }
}

