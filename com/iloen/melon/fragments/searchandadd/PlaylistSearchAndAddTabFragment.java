package com.iloen.melon.fragments.searchandadd;

import De.d;
import F8.K;
import F8.m;
import F8.r;
import S2.c;
import Tf.v;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView.OnEditorActionListener;
import android.widget.TextView;
import androidx.appcompat.app.o;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.lifecycle.o0;
import androidx.lifecycle.q0;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.constants.CType;
import com.iloen.melon.constants.MelonLimits.TextLimit;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.U0;
import com.iloen.melon.custom.tablayout.TabInfo;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.fragments.MelonPagerFragment;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.NotificationActionTypeHelper;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.common.SearchOrderBy;
import com.iloen.melon.net.v4x.request.DjPlaylistEditSearchSongListReq;
import com.iloen.melon.net.v4x.request.SearchSongListBaseReq.Params;
import com.iloen.melon.net.v4x.response.SearchSongListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.SearchSongListRes;
import com.iloen.melon.net.v6x.request.SearchAutocompleteKwdReq;
import com.iloen.melon.net.v6x.response.SearchAutocompleteKwdRes.SearchAutoKeywordBase;
import com.iloen.melon.net.v6x.response.SearchAutocompleteKwdRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.popup.InstantPlayPopup;
import com.iloen.melon.task.request.TaskGetSongInfo.ResultListener;
import com.iloen.melon.task.request.TaskGetSongInfo;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.SongHolder;
import com.melon.net.res.common.SongInfoBase;
import d3.g;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import je.n;
import je.p;
import je.w;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import o9.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00C4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 p2\u00020\u0001:\u0003pqrB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ-\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u000F2\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0006H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0003J\u001F\u0010\u0019\u001A\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u0018H\u0014\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001B\u001A\u00020\u00172\u0006\u0010\u001D\u001A\u00020\u001CH\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b!\u0010\u0003J\u0017\u0010$\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\"H\u0002\u00A2\u0006\u0004\b$\u0010%J+\u0010(\u001A\u00020\u00062\u001A\u0010\'\u001A\u0016\u0012\u0004\u0012\u00020&\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020&\u0018\u0001`\u0018H\u0002\u00A2\u0006\u0004\b(\u0010)J\u0017\u0010+\u001A\u00020\u00062\u0006\u0010*\u001A\u00020&H\u0002\u00A2\u0006\u0004\b+\u0010,J\u0017\u0010-\u001A\u00020\u00062\u0006\u0010*\u001A\u00020&H\u0002\u00A2\u0006\u0004\b-\u0010,J\u000F\u0010.\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b.\u0010/J\u001F\u0010-\u001A\u00020\u00062\u0006\u0010*\u001A\u00020&2\u0006\u00100\u001A\u00020\u001CH\u0002\u00A2\u0006\u0004\b-\u00101J\u0019\u00104\u001A\u00020\u00062\b\u00103\u001A\u0004\u0018\u000102H\u0002\u00A2\u0006\u0004\b4\u00105J\u0017\u00108\u001A\u00020\u00062\u0006\u00107\u001A\u000206H\u0002\u00A2\u0006\u0004\b8\u00109J\u000F\u0010:\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b:\u0010\u0003R\u0018\u0010;\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010=\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010?\u001A\u00020>8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u001A\u0010B\u001A\u00060AR\u00020\u00008\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010E\u001A\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010H\u001A\u00020G8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010<R\u0016\u0010L\u001A\u00020K8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bN\u0010<R\u0018\u0010O\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bO\u0010<R\u0018\u0010P\u001A\u0004\u0018\u00010\u000F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bP\u0010<R\u0018\u0010R\u001A\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001A\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010UR.\u0010W\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010V\u0018\u00010\u0016j\f\u0012\u0006\u0012\u0004\u0018\u00010V\u0018\u0001`\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010Y\u001A\u00020\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001A\u00020\"8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b[\u0010ZR\u0016\u0010\\\u001A\u00020\u001C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\\\u0010]R?\u0010d\u001A&\u0012\f\u0012\n _*\u0004\u0018\u00010&0& _*\u0012\u0012\u000E\b\u0001\u0012\n _*\u0004\u0018\u00010&0&0^0^8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\b`\u0010a\u001A\u0004\bb\u0010cR\u001B\u0010i\u001A\u00020e8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bf\u0010a\u001A\u0004\bg\u0010hR\u0018\u0010k\u001A\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010n\u001A\u00060mR\u00020\u00008\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bn\u0010o\u00A8\u0006s"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;", "Lcom/iloen/melon/fragments/MelonPagerFragment;", "<init>", "()V", "Landroid/os/Bundle;", "outState", "Lie/H;", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "buildTabIndicator", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/tablayout/TabInfo;", "Lkotlin/collections/ArrayList;", "makeTabInfo", "()Ljava/util/ArrayList;", "tabInfo", "", "position", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "makeTabFragment", "(Lcom/iloen/melon/custom/tablayout/TabInfo;I)Lcom/iloen/melon/fragments/MelonBaseFragment;", "onPause", "", "searchOn", "changeSearchMode", "(Z)V", "", "songIdList", "requestRecentAddedSong", "(Ljava/util/ArrayList;)V", "keyword", "fetchAutoComplete", "(Ljava/lang/String;)V", "fetchSearchResult", "getSearchOrder", "()I", "startPos", "(Ljava/lang/String;I)V", "Lcom/iloen/melon/playback/Playable;", "playable", "showInstantPlayPopup", "(Lcom/iloen/melon/playback/Playable;)V", "Landroid/widget/TextView;", "tvToggleButton", "showContextPopupSort", "(Landroid/widget/TextView;)V", "save", "tabLayout", "Landroid/view/View;", "tabUnderline", "Landroidx/recyclerview/widget/RecyclerView;", "searchRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;", "searchListAdapter", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;", "Landroid/text/TextWatcher;", "textWatcher", "Landroid/text/TextWatcher;", "Lcom/iloen/melon/custom/MelonEditText;", "etSearch", "Lcom/iloen/melon/custom/MelonEditText;", "layoutSearch", "Landroid/widget/RelativeLayout;", "layoutSearchBar", "Landroid/widget/RelativeLayout;", "ivSearchBack", "ivSearch", "ivDeleteKeyword", "Lcom/iloen/melon/popup/InstantPlayPopup;", "instantPlayPopup", "Lcom/iloen/melon/popup/InstantPlayPopup;", "originalSongIds", "Ljava/lang/String;", "Lcom/melon/net/res/common/SongInfoBase;", "recentAddedSongList", "Ljava/util/ArrayList;", "hasSearchFocus", "Z", "hasSearchMore", "orderBy", "I", "", "kotlin.jvm.PlatformType", "filterNameList$delegate", "Lie/j;", "getFilterNameList", "()[Ljava/lang/String;", "filterNameList", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel$delegate", "getPlaylistSearchViewModel", "()Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchViewModel;", "playlistSearchViewModel", "LF8/K;", "completeButton", "LF8/K;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$AutoCompleteKeywordHandler;", "autoCompleteKeywordHandler", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$AutoCompleteKeywordHandler;", "Companion", "AutoCompleteKeywordHandler", "SearchListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlaylistSearchAndAddTabFragment extends MelonPagerFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0011\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001A\u00020\t2\b\u0010\u0004\u001A\u0004\u0018\u00010\u00022\u0006\u0010\b\u001A\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$AutoCompleteKeywordHandler;", "Lcom/iloen/melon/custom/U0;", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;", "ref", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;)V", "Landroid/os/Message;", "msg", "Lie/H;", "handleMessage", "(Lcom/iloen/melon/fragments/MelonBaseFragment;Landroid/os/Message;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class AutoCompleteKeywordHandler extends U0 {
        public AutoCompleteKeywordHandler(@Nullable PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment1) {
            super(playlistSearchAndAddTabFragment1);
        }

        public void handleMessage(@Nullable MelonBaseFragment melonBaseFragment0, @NotNull Message message0) {
            q.g(message0, "msg");
            if(message0.what == 5000) {
                if(PlaylistSearchAndAddTabFragment.this.autoCompleteKeywordHandler.hasMessages(5000)) {
                    PlaylistSearchAndAddTabFragment.this.autoCompleteKeywordHandler.removeMessages(5000);
                    Message message1 = PlaylistSearchAndAddTabFragment.this.autoCompleteKeywordHandler.obtainMessage(message0.what, message0.arg1, message0.arg2, message0.obj);
                    PlaylistSearchAndAddTabFragment.this.autoCompleteKeywordHandler.sendMessageDelayed(message1, 100L);
                    return;
                }
                MelonEditText melonEditText0 = PlaylistSearchAndAddTabFragment.this.etSearch;
                if(melonEditText0 != null) {
                    String s = String.valueOf(melonEditText0.getText());
                    PlaylistSearchAndAddTabFragment.this.fetchAutoComplete(s);
                    return;
                }
                q.m("etSearch");
                throw null;
            }
        }

        @Override  // com.iloen.melon.custom.U0
        public void handleMessage(Object object0, Message message0) {
            this.handleMessage(((MelonBaseFragment)object0), message0);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001A\u0010\u001B\u001A\u00020\u001C2\b\u0010\u001D\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u001E\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0017\u001A\u00020\u0018X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0019\u001A\u00020\u001AX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SEARCH_RESULT_VALUES", "ARG_ORIGINAL_SONG_IDS", "ARG_OVER_SELECT_MESSAGE", "LIST_TYPE_KEYWORD", "", "LIST_TYPE_RECENT_ADDED_SONG", "LIST_TYPE_SEARCH_RESULT", "FILTER_INDEX_POPULARITY", "FILTER_INDEX_ACCURACY", "FILTER_INDEX_RECENTLY", "VIEW_TYPE_FILTER", "VIEW_TYPE_KEYWORD", "VIEW_TYPE_SONG", "VIEW_TYPE_SONG_EMPTY", "VIEW_TYPE_SEARCH_RESULT_ERROR", "MSG_AUTO_COMPLETE_KEYWORD", "DELAY_AUTO_COMPLETE_KEYWORD", "SEARCH_MODE_CHANGE_ANIMATION_DURATION", "", "SEARCH_MODE_EDIT_TEXT_ANIMATION_DISTANCE", "", "newInstance", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;", "originalSongIds", "overSelectMessage", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistSearchAndAddTabFragment newInstance(@Nullable String s, @NotNull String s1) {
            q.g(s1, "overSelectMessage");
            PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = new PlaylistSearchAndAddTabFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argOriginalSongIds", s);
            bundle0.putString("argOverSelectMessage", s1);
            playlistSearchAndAddTabFragment0.setArguments(bundle0);
            return playlistSearchAndAddTabFragment0;
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0010\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000534567B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u001B\u0010\t\u001A\u00020\b2\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00060\u0005\u00A2\u0006\u0004\b\t\u0010\nJ-\u0010\u000F\u001A\u00020\b2\u001E\u0010\u000E\u001A\u001A\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000Bj\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`\r\u00A2\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0011\u001A\u00020\b2\u001E\u0010\u000E\u001A\u001A\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000Bj\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f`\r\u00A2\u0006\u0004\b\u0011\u0010\u0010J1\u0010\u0012\u001A\u00020\b2\"\u0010\u000E\u001A\u001E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u00010\u000Bj\u000E\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f\u0018\u0001`\r\u00A2\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0015\u001A\u00020\b2\u0006\u0010\u0014\u001A\u00020\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001A\u00020\b2\u0006\u0010\u0018\u001A\u00020\u0017\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0017\u0010\u001C\u001A\u00020\u00172\u0006\u0010\u001B\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u001F\u0010!\u001A\u00020\u00022\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u001F\u0010$\u001A\u00020\b2\u0006\u0010#\u001A\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b$\u0010%J\u000F\u0010&\u001A\u00020\u0017H\u0016\u00A2\u0006\u0004\b&\u0010\'R\u0014\u0010)\u001A\u00020(8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b)\u0010*R$\u0010\u0018\u001A\u00020\u00172\u0006\u0010+\u001A\u00020\u00178\u0006@BX\u0086\u000E\u00A2\u0006\f\n\u0004\b\u0018\u0010,\u001A\u0004\b-\u0010\'R\u0018\u0010\u0014\u001A\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0014\u0010.R(\u0010/\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000Bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u00100R(\u00101\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000Bj\n\u0012\u0006\u0012\u0004\u0018\u00010\f`\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u00100R$\u00102\u001A\u0012\u0012\u0004\u0012\u00020\u00060\u000Bj\b\u0012\u0004\u0012\u00020\u0006`\r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u00100\u00A8\u00068"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;", "Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/O0;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;)V", "", "Lcom/iloen/melon/net/v6x/response/SearchAutocompleteKwdRes$SearchAutoKeywordBase;", "keywordList", "Lie/H;", "setRecentKeywordList", "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "Lcom/melon/net/res/common/SongInfoBase;", "Lkotlin/collections/ArrayList;", "newSongList", "setLastAddedSongList", "(Ljava/util/ArrayList;)V", "setSearchResultSongList", "addSearchResultSongList", "Lcom/iloen/melon/net/HttpResponse$Notification;", "notification", "setSearchResultError", "(Lcom/iloen/melon/net/HttpResponse$Notification;)V", "", "listType", "changeListType", "(I)V", "position", "getItemViewType", "(I)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "vh", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;I)V", "getItemCount", "()I", "", "FONT_COLOR", "Ljava/lang/String;", "value", "I", "getListType", "Lcom/iloen/melon/net/HttpResponse$Notification;", "songList", "Ljava/util/ArrayList;", "searchResultSongList", "recentKeywordList", "ToggleFilterHolder", "SearchSongHolder", "KeywordHolder", "SongEmptyListHolder", "SearchErrorHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class SearchListAdapter extends j0 {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter$KeywordHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvKeyword", "Landroid/widget/TextView;", "getTvKeyword", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class KeywordHolder extends O0 {
            @NotNull
            private final TextView tvKeyword;

            public KeywordHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchListAdapter.this = playlistSearchAndAddTabFragment$SearchListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A06CF);  // id:keyword
                q.f(view1, "findViewById(...)");
                this.tvKeyword = (TextView)view1;
                ViewUtils.hideWhen(view0.findViewById(0x7F0A039C), true);  // id:delete_btn
            }

            @NotNull
            public final TextView getTvKeyword() {
                return this.tvKeyword;
            }
        }

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter$SearchErrorHolder;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter$SongEmptyListHolder;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;", "Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment;", "view", "Landroid/view/View;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;Landroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SearchErrorHolder extends SongEmptyListHolder {
            public SearchErrorHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchListAdapter.this = playlistSearchAndAddTabFragment$SearchListAdapter0;
                super(view0);
            }
        }

        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001A\u0010\u0006\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter$SearchSongHolder;", "Lcom/iloen/melon/viewholders/SongHolder;", "view", "Landroid/view/View;", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;Landroid/view/View;)V", "layoutSectionTitle", "getLayoutSectionTitle", "()Landroid/view/View;", "setLayoutSectionTitle", "(Landroid/view/View;)V", "ivAddBtn", "Landroid/widget/ImageView;", "getIvAddBtn", "()Landroid/widget/ImageView;", "setIvAddBtn", "(Landroid/widget/ImageView;)V", "ivPlayHighlight", "getIvPlayHighlight", "setIvPlayHighlight", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SearchSongHolder extends SongHolder {
            @NotNull
            private ImageView ivAddBtn;
            @NotNull
            private View ivPlayHighlight;
            @NotNull
            private View layoutSectionTitle;

            public SearchSongHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchListAdapter.this = playlistSearchAndAddTabFragment$SearchListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0740);  // id:layout_section_title
                q.f(view1, "findViewById(...)");
                this.layoutSectionTitle = view1;
                View view2 = view0.findViewById(0x7F0A05E2);  // id:iv_add_btn
                q.f(view2, "findViewById(...)");
                this.ivAddBtn = (ImageView)view2;
                View view3 = view0.findViewById(0x7F0A0661);  // id:iv_play_highlight
                q.f(view3, "findViewById(...)");
                this.ivPlayHighlight = view3;
            }

            @NotNull
            public final ImageView getIvAddBtn() {
                return this.ivAddBtn;
            }

            @NotNull
            public final View getIvPlayHighlight() {
                return this.ivPlayHighlight;
            }

            @NotNull
            public final View getLayoutSectionTitle() {
                return this.layoutSectionTitle;
            }

            public final void setIvAddBtn(@NotNull ImageView imageView0) {
                q.g(imageView0, "<set-?>");
                this.ivAddBtn = imageView0;
            }

            public final void setIvPlayHighlight(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.ivPlayHighlight = view0;
            }

            public final void setLayoutSectionTitle(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.layoutSectionTitle = view0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0092\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\"\u0010\f\u001A\u00020\u00028\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001A\u0004\b\r\u0010\t\"\u0004\b\u000E\u0010\u000BR\"\u0010\u0010\u001A\u00020\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter$SongEmptyListHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;Landroid/view/View;)V", "emptyLayout", "Landroid/view/View;", "getEmptyLayout", "()Landroid/view/View;", "setEmptyLayout", "(Landroid/view/View;)V", "emptyImage", "getEmptyImage", "setEmptyImage", "Landroid/widget/TextView;", "emptyText", "Landroid/widget/TextView;", "getEmptyText", "()Landroid/widget/TextView;", "setEmptyText", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        class SongEmptyListHolder extends O0 {
            @NotNull
            private View emptyImage;
            @NotNull
            private View emptyLayout;
            @NotNull
            private TextView emptyText;

            public SongEmptyListHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchListAdapter.this = playlistSearchAndAddTabFragment$SearchListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A042B);  // id:empty_layout
                q.f(view1, "findViewById(...)");
                this.emptyLayout = view1;
                View view2 = view0.findViewById(0x7F0A042A);  // id:empty_image
                q.f(view2, "findViewById(...)");
                this.emptyImage = view2;
                View view3 = view0.findViewById(0x7F0A042F);  // id:empty_text
                q.f(view3, "findViewById(...)");
                this.emptyText = (TextView)view3;
            }

            @NotNull
            public final View getEmptyImage() {
                return this.emptyImage;
            }

            @NotNull
            public final View getEmptyLayout() {
                return this.emptyLayout;
            }

            @NotNull
            public final TextView getEmptyText() {
                return this.emptyText;
            }

            public final void setEmptyImage(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.emptyImage = view0;
            }

            public final void setEmptyLayout(@NotNull View view0) {
                q.g(view0, "<set-?>");
                this.emptyLayout = view0;
            }

            public final void setEmptyText(@NotNull TextView textView0) {
                q.g(textView0, "<set-?>");
                this.emptyText = textView0;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter$ToggleFilterHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/searchandadd/PlaylistSearchAndAddTabFragment$SearchListAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "tvToggleButton", "Landroid/widget/TextView;", "getTvToggleButton", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ToggleFilterHolder extends O0 {
            @NotNull
            private final TextView tvToggleButton;

            public ToggleFilterHolder(@NotNull View view0) {
                q.g(view0, "view");
                SearchListAdapter.this = playlistSearchAndAddTabFragment$SearchListAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0D42);  // id:tv_toggle_button
                q.f(view1, "findViewById(...)");
                this.tvToggleButton = (TextView)view1;
                ((TextView)view1).setOnClickListener(new k(PlaylistSearchAndAddTabFragment.this, 0));
                String[] arr_s = PlaylistSearchAndAddTabFragment.this.getFilterNameList();
                ((TextView)view1).setText(arr_s[PlaylistSearchAndAddTabFragment.this.orderBy]);
            }

            private static final void _init_$lambda$0(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
                q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
                playlistSearchAndAddTabFragment0.showContextPopupSort(((TextView)view0));
            }

            @NotNull
            public final TextView getTvToggleButton() {
                return this.tvToggleButton;
            }
        }

        @NotNull
        private final String FONT_COLOR;
        private int listType;
        @Nullable
        private Notification notification;
        @NotNull
        private final ArrayList recentKeywordList;
        @NotNull
        private final ArrayList searchResultSongList;
        @NotNull
        private final ArrayList songList;

        public SearchListAdapter() {
            this.FONT_COLOR = o.j(ColorUtils.getColor(playlistSearchAndAddTabFragment0.getContext(), 0x7F06017C), "font color=\"", "\"");  // color:green500s_support_high_contrast
            this.listType = 1;
            this.songList = new ArrayList();
            this.searchResultSongList = new ArrayList();
            this.recentKeywordList = new ArrayList();
        }

        public final void addSearchResultSongList(@Nullable ArrayList arrayList0) {
            if(arrayList0 != null) {
                this.listType = 2;
                this.searchResultSongList.addAll(arrayList0);
                this.notifyDataSetChanged();
            }
        }

        public final void changeListType(int v) {
            if(this.listType != v) {
                this.listType = v;
                RecyclerView recyclerView0 = PlaylistSearchAndAddTabFragment.this.searchRecyclerView;
                if(recyclerView0 != null) {
                    w0 w00 = recyclerView0.getLayoutManager();
                    if(w00 != null) {
                        w00.removeAllViews();
                    }
                    this.notifyDataSetChanged();
                    return;
                }
                q.m("searchRecyclerView");
                throw null;
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemCount() {
            int v = this.listType;
            if(v == 0) {
                return this.recentKeywordList.size();
            }
            if(v == 1) {
                return this.songList.size() >= 1 ? this.songList.size() : 1;
            }
            return this.searchResultSongList.size() >= 1 ? this.searchResultSongList.size() + 1 : 1;
        }

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            if(v == 0 && this.listType == 2) {
                return this.notification == null ? 1000 : 1004;
            }
            int v1 = this.listType;
            if(v1 == 0) {
                return 1001;
            }
            return (v1 != 1 || this.songList.size() >= 1) && (this.listType != 2 || this.searchResultSongList.size() >= 1) ? 1002 : 1003;
        }

        public final int getListType() {
            return this.listType;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v) {
            String s = null;
            q.g(o00, "vh");
            boolean z = false;
            if(o00 instanceof KeywordHolder) {
                Object object0 = this.recentKeywordList.get(v);
                q.f(object0, "get(...)");
                String s1 = ((SearchAutoKeywordBase)object0).keyword;
                q.d(s1);
                ((KeywordHolder)o00).getTvKeyword().setText(Html.fromHtml(v.p0(v.p0(s1, "span class=\'word_point\'", this.FONT_COLOR), "span", "font"), 0));
                f f0 = new f(2, o00, PlaylistSearchAndAddTabFragment.this);
                o00.itemView.setOnClickListener(f0);
                return;
            }
            if(o00 instanceof SongEmptyListHolder) {
                ViewUtils.showWhen(((SongEmptyListHolder)o00).getEmptyLayout(), true);
                ViewUtils.hideWhen(((SongEmptyListHolder)o00).getEmptyImage(), true);
                ((SongEmptyListHolder)o00).getEmptyText().setText(PlaylistSearchAndAddTabFragment.this.getString((this.listType == 1 ? 0x7F130828 : 0x7F130829)));  // string:playlist_edit_recent_add_song_list_empty "최근 추가한 곡이 없습니다."
                return;
            }
            if(o00 instanceof SearchErrorHolder) {
                ViewUtils.showWhen(((SearchErrorHolder)o00).getEmptyLayout(), true);
                ViewUtils.hideWhen(((SearchErrorHolder)o00).getEmptyImage(), true);
                if(NotificationActionTypeHelper.isViewTypeNotifyScreen(this.notification) && NotificationActionTypeHelper.isStatusNormal(this.notification)) {
                    TextView textView0 = ((SearchErrorHolder)o00).getEmptyText();
                    Notification httpResponse$Notification0 = this.notification;
                    if(httpResponse$Notification0 != null) {
                        s = httpResponse$Notification0.message;
                    }
                    textView0.setText(s);
                    return;
                }
                ((SearchErrorHolder)o00).getEmptyText().setText(PlaylistSearchAndAddTabFragment.this.getString(0x7F130389));  // string:empty_content_list "목록이 없습니다."
                return;
            }
            if(o00 instanceof SearchSongHolder) {
                SongInfoBase songInfoBase0 = this.listType == 1 ? ((SongInfoBase)this.songList.get(v)) : ((SongInfoBase)this.searchResultSongList.get(v - 1));
                if(songInfoBase0 != null) {
                    PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = PlaylistSearchAndAddTabFragment.this;
                    ViewUtils.setEnable(o00.itemView, songInfoBase0.canService);
                    if(this.listType == 1) {
                        View view0 = ((SearchSongHolder)o00).getLayoutSectionTitle();
                        if(v == 0) {
                            z = true;
                        }
                        ViewUtils.showWhen(view0, z);
                    }
                    if(songInfoBase0.canService) {
                        ((SearchSongHolder)o00).getIvAddBtn().setImageResource((playlistSearchAndAddTabFragment0.getPlaylistSearchViewModel().containsSongId((songInfoBase0.songId == null ? "" : songInfoBase0.songId)) ? 0x7F0800E0 : 0x7F0800DF));  // drawable:btn_add_24_on
                        ViewUtils.setOnClickListener(((SearchSongHolder)o00).getIvAddBtn(), new h(playlistSearchAndAddTabFragment0, songInfoBase0, this, v, 1));
                    }
                    else {
                        ViewUtils.setOnClickListener(o00.itemView, null);
                        int v1 = ColorUtils.getColor(playlistSearchAndAddTabFragment0.getContext(), 0x7F06048A);  // color:transparent
                        o00.itemView.setBackgroundColor(v1);
                    }
                    ImageView imageView0 = ((SearchSongHolder)o00).thumbnailIv;
                    if(imageView0 != null) {
                        Glide.with(imageView0.getContext()).load(songInfoBase0.albumImg).into(((SearchSongHolder)o00).thumbnailIv);
                    }
                    ((SearchSongHolder)o00).titleTv.setText(songInfoBase0.songName);
                    ((SearchSongHolder)o00).artistTv.setText(ProtocolUtils.getArtistNames(songInfoBase0.artistList));
                    ViewUtils.showWhen(((SearchSongHolder)o00).list19Iv, songInfoBase0.isAdult);
                    ViewUtils.showWhen(((SearchSongHolder)o00).listFreeIv, songInfoBase0.isFree);
                    ViewUtils.showWhen(((SearchSongHolder)o00).listHoldbackIv, songInfoBase0.isHoldback);
                }
            }
        }

        private static final void onBindViewHolder$lambda$3(O0 o00, PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
            String s = ((KeywordHolder)o00).getTvKeyword().getText().toString();
            MelonEditText melonEditText0 = playlistSearchAndAddTabFragment0.etSearch;
            if(melonEditText0 != null) {
                melonEditText0.setText(s);
                MelonEditText melonEditText1 = playlistSearchAndAddTabFragment0.etSearch;
                if(melonEditText1 != null) {
                    MelonEditText melonEditText2 = playlistSearchAndAddTabFragment0.etSearch;
                    if(melonEditText2 != null) {
                        Editable editable0 = melonEditText2.getText();
                        melonEditText1.setSelection((editable0 == null ? 0 : editable0.length()));
                        ViewUtils.showWhen(playlistSearchAndAddTabFragment0.ivDeleteKeyword, true);
                        playlistSearchAndAddTabFragment0.fetchSearchResult(s);
                        return;
                    }
                    q.m("etSearch");
                    throw null;
                }
                q.m("etSearch");
                throw null;
            }
            q.m("etSearch");
            throw null;
        }

        private static final void onBindViewHolder$lambda$5$lambda$4(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, SongInfoBase songInfoBase0, SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0, int v, View view0) {
            PlaylistSearchViewModel playlistSearchViewModel0 = playlistSearchAndAddTabFragment0.getPlaylistSearchViewModel();
            String s = songInfoBase0.songId;
            String s1 = "";
            if(s == null) {
                s = "";
            }
            if(playlistSearchViewModel0.containsSongId(s)) {
                PlaylistSearchViewModel playlistSearchViewModel1 = playlistSearchAndAddTabFragment0.getPlaylistSearchViewModel();
                String s2 = songInfoBase0.songId;
                if(s2 != null) {
                    s1 = s2;
                }
                playlistSearchViewModel1.removeSong(s1);
            }
            else {
                PlaylistSearchViewModel playlistSearchViewModel2 = playlistSearchAndAddTabFragment0.getPlaylistSearchViewModel();
                String s3 = songInfoBase0.songId;
                if(s3 != null) {
                    s1 = s3;
                }
                if(!playlistSearchViewModel2.addSong(s1)) {
                    ToastManager.show(playlistSearchAndAddTabFragment0.getPlaylistSearchViewModel().getOverSelectMessage());
                }
            }
            playlistSearchAndAddTabFragment$SearchListAdapter0.notifyItemChanged(v);
        }

        @Override  // androidx.recyclerview.widget.j0
        @NotNull
        public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            switch(v) {
                case 1000: {
                    View view1 = LayoutInflater.from(PlaylistSearchAndAddTabFragment.this.getContext()).inflate(0x7F0D0275, viewGroup0, false);  // layout:filter_playlist_search_toggle
                    q.f(view1, "inflate(...)");
                    return new ToggleFilterHolder(this, view1);
                }
                case 1001: {
                    View view2 = LayoutInflater.from(PlaylistSearchAndAddTabFragment.this.getContext()).inflate(0x7F0D0811, viewGroup0, false);  // layout:search_recent_keword_item_layout
                    q.f(view2, "inflate(...)");
                    return new KeywordHolder(this, view2);
                }
                case 1002: {
                    View view3 = LayoutInflater.from(PlaylistSearchAndAddTabFragment.this.getContext()).inflate(0x7F0D04A9, viewGroup0, false);  // layout:listitem_song_dj_search
                    q.f(view3, "inflate(...)");
                    return new SearchSongHolder(this, view3);
                }
                case 1004: {
                    View view4 = LayoutInflater.from(PlaylistSearchAndAddTabFragment.this.getContext()).inflate(0x7F0D0022, viewGroup0, false);  // layout:adapter_empty_view
                    q.f(view4, "inflate(...)");
                    return new SearchErrorHolder(this, view4);
                }
                default: {
                    View view0 = LayoutInflater.from(PlaylistSearchAndAddTabFragment.this.getContext()).inflate(0x7F0D0022, viewGroup0, false);  // layout:adapter_empty_view
                    q.f(view0, "inflate(...)");
                    return new SongEmptyListHolder(this, view0);
                }
            }
        }

        public final void setLastAddedSongList(@Nullable ArrayList arrayList0) {
            if(arrayList0 != null) {
                this.listType = 1;
                this.songList.clear();
                this.songList.addAll(arrayList0);
                RecyclerView recyclerView0 = PlaylistSearchAndAddTabFragment.this.searchRecyclerView;
                if(recyclerView0 != null) {
                    w0 w00 = recyclerView0.getLayoutManager();
                    if(w00 != null) {
                        w00.removeAllViews();
                    }
                    this.notifyDataSetChanged();
                    return;
                }
                q.m("searchRecyclerView");
                throw null;
            }
        }

        public final void setRecentKeywordList(@NotNull List list0) {
            q.g(list0, "keywordList");
            this.listType = 0;
            this.recentKeywordList.clear();
            this.recentKeywordList.addAll(list0);
            RecyclerView recyclerView0 = PlaylistSearchAndAddTabFragment.this.searchRecyclerView;
            if(recyclerView0 != null) {
                w0 w00 = recyclerView0.getLayoutManager();
                if(w00 != null) {
                    w00.removeAllViews();
                }
                this.notifyDataSetChanged();
                return;
            }
            q.m("searchRecyclerView");
            throw null;
        }

        public final void setSearchResultError(@NotNull Notification httpResponse$Notification0) {
            q.g(httpResponse$Notification0, "notification");
            this.notification = httpResponse$Notification0;
            this.searchResultSongList.clear();
            RecyclerView recyclerView0 = PlaylistSearchAndAddTabFragment.this.searchRecyclerView;
            if(recyclerView0 != null) {
                w0 w00 = recyclerView0.getLayoutManager();
                if(w00 != null) {
                    w00.removeAllViews();
                }
                this.notifyDataSetChanged();
                return;
            }
            q.m("searchRecyclerView");
            throw null;
        }

        public final void setSearchResultSongList(@NotNull ArrayList arrayList0) {
            q.g(arrayList0, "newSongList");
            this.listType = 2;
            this.notification = null;
            this.searchResultSongList.clear();
            this.searchResultSongList.addAll(arrayList0);
            RecyclerView recyclerView0 = PlaylistSearchAndAddTabFragment.this.searchRecyclerView;
            if(recyclerView0 != null) {
                w0 w00 = recyclerView0.getLayoutManager();
                if(w00 != null) {
                    w00.removeAllViews();
                }
                this.notifyDataSetChanged();
                return;
            }
            q.m("searchRecyclerView");
            throw null;
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final String ARG_ORIGINAL_SONG_IDS = "argOriginalSongIds";
    @NotNull
    public static final String ARG_OVER_SELECT_MESSAGE = "argOverSelectMessage";
    @NotNull
    public static final String ARG_SEARCH_RESULT_VALUES = "argSearchResultValues";
    @NotNull
    public static final Companion Companion = null;
    private static final int DELAY_AUTO_COMPLETE_KEYWORD = 100;
    private static final int FILTER_INDEX_ACCURACY = 1;
    private static final int FILTER_INDEX_POPULARITY = 0;
    private static final int FILTER_INDEX_RECENTLY = 2;
    private static final int LIST_TYPE_KEYWORD = 0;
    private static final int LIST_TYPE_RECENT_ADDED_SONG = 1;
    private static final int LIST_TYPE_SEARCH_RESULT = 2;
    private static final int MSG_AUTO_COMPLETE_KEYWORD = 5000;
    private static final long SEARCH_MODE_CHANGE_ANIMATION_DURATION = 300L;
    private static final float SEARCH_MODE_EDIT_TEXT_ANIMATION_DISTANCE = 30.0f;
    @NotNull
    private static final String TAG = "PlaylistSearchAndAddTabFragment";
    private static final int VIEW_TYPE_FILTER = 1000;
    private static final int VIEW_TYPE_KEYWORD = 1001;
    private static final int VIEW_TYPE_SEARCH_RESULT_ERROR = 1004;
    private static final int VIEW_TYPE_SONG = 1002;
    private static final int VIEW_TYPE_SONG_EMPTY = 1003;
    @NotNull
    private final AutoCompleteKeywordHandler autoCompleteKeywordHandler;
    @Nullable
    private K completeButton;
    private MelonEditText etSearch;
    @NotNull
    private final j filterNameList$delegate;
    private boolean hasSearchFocus;
    private boolean hasSearchMore;
    @Nullable
    private InstantPlayPopup instantPlayPopup;
    @Nullable
    private View ivDeleteKeyword;
    @Nullable
    private View ivSearch;
    @Nullable
    private View ivSearchBack;
    @Nullable
    private View layoutSearch;
    private RelativeLayout layoutSearchBar;
    private int orderBy;
    @Nullable
    private String originalSongIds;
    @NotNull
    private final j playlistSearchViewModel$delegate;
    @Nullable
    private ArrayList recentAddedSongList;
    private SearchListAdapter searchListAdapter;
    private RecyclerView searchRecyclerView;
    @Nullable
    private View tabLayout;
    @Nullable
    private View tabUnderline;
    @Nullable
    private TextWatcher textWatcher;

    static {
        PlaylistSearchAndAddTabFragment.Companion = new Companion(null);
        PlaylistSearchAndAddTabFragment.$stable = 8;
    }

    public PlaylistSearchAndAddTabFragment() {
        this.filterNameList$delegate = g.Q(new com.iloen.melon.fragments.searchandadd.j(this, 0));
        this.playlistSearchViewModel$delegate = g.Q(new com.iloen.melon.fragments.searchandadd.j(this, 1));
        this.autoCompleteKeywordHandler = new AutoCompleteKeywordHandler(this, this);
    }

    public static void C(VolleyError volleyError0) {
        PlaylistSearchAndAddTabFragment.fetchSearchResult$lambda$16(volleyError0);
    }

    public static void K(VolleyError volleyError0) {
        PlaylistSearchAndAddTabFragment.fetchAutoComplete$lambda$15(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void buildTabIndicator() {
        super.buildTabIndicator();
        this.mTabContainer.findViewById(0x7F0A0D6B).setVisibility(4);  // id:underline
    }

    private final void changeSearchMode(boolean z) {
        if(z) {
            com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddTabFragment.changeSearchMode.animation.1 playlistSearchAndAddTabFragment$changeSearchMode$animation$10 = new Animation() {
                @Override  // android.view.animation.Animation
                public void applyTransformation(float f, Transformation transformation0) {
                    RelativeLayout relativeLayout0 = PlaylistSearchAndAddTabFragment.this.layoutSearchBar;
                    if(relativeLayout0 != null) {
                        int v = ScreenUtils.dipToPixel(relativeLayout0.getContext(), 30.0f);
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
                        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        ((RelativeLayout.LayoutParams)viewGroup$LayoutParams0).leftMargin = (int)(((float)v) * f);
                        relativeLayout0.setLayoutParams(((RelativeLayout.LayoutParams)viewGroup$LayoutParams0));
                        return;
                    }
                    q.m("layoutSearchBar");
                    throw null;
                }
            };
            playlistSearchAndAddTabFragment$changeSearchMode$animation$10.setDuration(300L);
            playlistSearchAndAddTabFragment$changeSearchMode$animation$10.setAnimationListener(new Animation.AnimationListener() {
                @Override  // android.view.animation.Animation$AnimationListener
                public void onAnimationEnd(Animation animation0) {
                    q.g(animation0, "animation");
                    ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.ivSearchBack, true);
                    ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.layoutSearch, true);
                    ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.tabLayout, true);
                    ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.tabUnderline, true);
                }

                @Override  // android.view.animation.Animation$AnimationListener
                public void onAnimationRepeat(Animation animation0) {
                    q.g(animation0, "animation");
                }

                @Override  // android.view.animation.Animation$AnimationListener
                public void onAnimationStart(Animation animation0) {
                    q.g(animation0, "animation");
                }
            });
            RelativeLayout relativeLayout0 = this.layoutSearchBar;
            if(relativeLayout0 != null) {
                relativeLayout0.startAnimation(playlistSearchAndAddTabFragment$changeSearchMode$animation$10);
                return;
            }
            q.m("layoutSearchBar");
            throw null;
        }
        com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddTabFragment.changeSearchMode.animation.2 playlistSearchAndAddTabFragment$changeSearchMode$animation$20 = new Animation() {
            @Override  // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation0) {
                RelativeLayout relativeLayout0 = PlaylistSearchAndAddTabFragment.this.layoutSearchBar;
                if(relativeLayout0 != null) {
                    int v = ScreenUtils.dipToPixel(relativeLayout0.getContext(), 30.0f);
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
                    q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                    ((RelativeLayout.LayoutParams)viewGroup$LayoutParams0).leftMargin = (int)((1.0f - f) * ((float)v));
                    relativeLayout0.setLayoutParams(((RelativeLayout.LayoutParams)viewGroup$LayoutParams0));
                    return;
                }
                q.m("layoutSearchBar");
                throw null;
            }
        };
        playlistSearchAndAddTabFragment$changeSearchMode$animation$20.setAnimationListener(new Animation.AnimationListener() {
            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationEnd(Animation animation0) {
                q.g(animation0, "animation");
                MelonEditText melonEditText0 = PlaylistSearchAndAddTabFragment.this.etSearch;
                if(melonEditText0 != null) {
                    melonEditText0.setText("");
                    Context context0 = PlaylistSearchAndAddTabFragment.this.getContext();
                    MelonEditText melonEditText1 = PlaylistSearchAndAddTabFragment.this.etSearch;
                    if(melonEditText1 != null) {
                        InputMethodUtils.hideInputMethod(context0, melonEditText1);
                        ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.ivDeleteKeyword, true);
                        ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.ivSearchBack, false);
                        ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.layoutSearch, true);
                        ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.tabLayout, true);
                        ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.tabUnderline, true);
                        return;
                    }
                    q.m("etSearch");
                    throw null;
                }
                q.m("etSearch");
                throw null;
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationRepeat(Animation animation0) {
                q.g(animation0, "animation");
            }

            @Override  // android.view.animation.Animation$AnimationListener
            public void onAnimationStart(Animation animation0) {
                q.g(animation0, "animation");
            }
        });
        playlistSearchAndAddTabFragment$changeSearchMode$animation$20.setDuration(300L);
        RelativeLayout relativeLayout1 = this.layoutSearchBar;
        if(relativeLayout1 != null) {
            relativeLayout1.startAnimation(playlistSearchAndAddTabFragment$changeSearchMode$animation$20);
            return;
        }
        q.m("layoutSearchBar");
        throw null;
    }

    private final void fetchAutoComplete(String s) {
        RequestBuilder.newInstance(new SearchAutocompleteKwdReq(this.getContext(), s)).tag("PlaylistSearchAndAddTabFragment").listener(new Listener() {
            public void onResponse(SearchAutocompleteKwdRes searchAutocompleteKwdRes0) {
                SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = PlaylistSearchAndAddTabFragment.this.searchListAdapter;
                if(playlistSearchAndAddTabFragment$SearchListAdapter0 != null) {
                    if(playlistSearchAndAddTabFragment$SearchListAdapter0.getListType() == 0 && searchAutocompleteKwdRes0 != null) {
                        PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = PlaylistSearchAndAddTabFragment.this;
                        if(searchAutocompleteKwdRes0.isSuccessful() && (searchAutocompleteKwdRes0.keywordList != null && searchAutocompleteKwdRes0.keywordList.size() > 0)) {
                            SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter1 = playlistSearchAndAddTabFragment0.searchListAdapter;
                            if(playlistSearchAndAddTabFragment$SearchListAdapter1 != null) {
                                List list0 = searchAutocompleteKwdRes0.keywordList;
                                q.f(list0, "keywordList");
                                playlistSearchAndAddTabFragment$SearchListAdapter1.setRecentKeywordList(list0);
                                return;
                            }
                            q.m("searchListAdapter");
                            throw null;
                        }
                    }
                    return;
                }
                q.m("searchListAdapter");
                throw null;
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((SearchAutocompleteKwdRes)object0));
            }
        }).errorListener(new e(9)).request();
    }

    private static final void fetchAutoComplete$lambda$15(VolleyError volleyError0) {
        a.v("requestAutoComplete() ", volleyError0.getMessage(), LogU.Companion, "PlaylistSearchAndAddTabFragment");
    }

    private final void fetchSearchResult(String s) {
        this.fetchSearchResult(s, 1);
    }

    private final void fetchSearchResult(String s, int v) {
        if(Tf.o.H0(s)) {
            return;
        }
        SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = this.searchListAdapter;
        if(playlistSearchAndAddTabFragment$SearchListAdapter0 != null) {
            playlistSearchAndAddTabFragment$SearchListAdapter0.changeListType(2);
            Params searchSongListBaseReq$Params0 = new Params();
            searchSongListBaseReq$Params0.startIndex = v;
            searchSongListBaseReq$Params0.pageSize = 25;
            searchSongListBaseReq$Params0.orderBy = this.getSearchOrder();
            RequestBuilder.newInstance(new DjPlaylistEditSearchSongListReq(this.getContext(), s, searchSongListBaseReq$Params0)).tag("PlaylistSearchAndAddTabFragment").listener(new Listener() {
                public void onResponse(SearchSongListRes searchSongListRes0) {
                    SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = v.searchListAdapter;
                    if(playlistSearchAndAddTabFragment$SearchListAdapter0 != null) {
                        if(playlistSearchAndAddTabFragment$SearchListAdapter0.getListType() == 2 && searchSongListRes0 != null) {
                            PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = v;
                            int v = this.$startPos;
                            if(searchSongListRes0.isSuccessful()) {
                                playlistSearchAndAddTabFragment0.hasSearchMore = searchSongListRes0.response == null ? false : searchSongListRes0.response.hasMore;
                                RESPONSE searchSongListRes$RESPONSE0 = searchSongListRes0.response;
                                if(searchSongListRes$RESPONSE0 != null) {
                                    ArrayList arrayList0 = searchSongListRes$RESPONSE0.contentslist;
                                    if(arrayList0 != null && arrayList0.size() > 0) {
                                        if(v == 1) {
                                            SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter1 = playlistSearchAndAddTabFragment0.searchListAdapter;
                                            if(playlistSearchAndAddTabFragment$SearchListAdapter1 != null) {
                                                playlistSearchAndAddTabFragment$SearchListAdapter1.setSearchResultSongList(arrayList0);
                                                return;
                                            }
                                            q.m("searchListAdapter");
                                            throw null;
                                        }
                                        SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter2 = playlistSearchAndAddTabFragment0.searchListAdapter;
                                        if(playlistSearchAndAddTabFragment$SearchListAdapter2 != null) {
                                            playlistSearchAndAddTabFragment$SearchListAdapter2.addSearchResultSongList(arrayList0);
                                            return;
                                        }
                                        q.m("searchListAdapter");
                                        throw null;
                                    }
                                }
                            }
                        }
                        return;
                    }
                    q.m("searchListAdapter");
                    throw null;
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((SearchSongListRes)object0));
                }
            }).errorListener(new e(8)).request();
            return;
        }
        q.m("searchListAdapter");
        throw null;
    }

    private static final void fetchSearchResult$lambda$16(VolleyError volleyError0) {
        a.v("fetchSearchResult() ", volleyError0.getMessage(), LogU.Companion, "PlaylistSearchAndAddTabFragment");
    }

    private static final String[] filterNameList_delegate$lambda$0(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0) {
        return playlistSearchAndAddTabFragment0.getResources().getStringArray(0x7F030047);  // array:sortingbar_playlist_search
    }

    private final String[] getFilterNameList() {
        return (String[])this.filterNameList$delegate.getValue();
    }

    private final PlaylistSearchViewModel getPlaylistSearchViewModel() {
        return (PlaylistSearchViewModel)this.playlistSearchViewModel$delegate.getValue();
    }

    private final int getSearchOrder() {
        int v = this.orderBy;
        if(v == 0) {
            return SearchOrderBy.POPULARITY;
        }
        return v == 1 ? SearchOrderBy.ACCURACY : SearchOrderBy.RECENTLY;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public I makeTabFragment(TabInfo tabInfo0, int v) {
        return this.makeTabFragment(tabInfo0, v);
    }

    @NotNull
    public MelonBaseFragment makeTabFragment(@NotNull TabInfo tabInfo0, int v) {
        q.g(tabInfo0, "tabInfo");
        switch(v) {
            case 0: {
                return PlaylistSearchAndAddLikeFragment.Companion.newInstance();
            }
            case 1: {
                return PlaylistSearchAndAddSongListFragment.Companion.newInstance();
            }
            case 2: {
                return PlaylistSearchAndAddRecentFragment.Companion.newInstance();
            }
            default: {
                return PlaylistSearchAndAddPlaylistFragment.Companion.newInstance();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    @NotNull
    public ArrayList makeTabInfo() {
        ArrayList arrayList0 = new ArrayList();
        String[] arr_s = this.getResources().getStringArray(0x7F030029);  // array:search_and_add_playlist_make
        q.f(arr_s, "getStringArray(...)");
        for(int v = 0; v < arr_s.length; ++v) {
            String s = arr_s[v];
            TabInfo tabInfo0 = new TabInfo();  // 初始化器: Ljava/lang/Object;-><init>()V
            tabInfo0.a = 2;
            tabInfo0.b = s;
            tabInfo0.c = 0;
            tabInfo0.d = null;
            tabInfo0.e = v;
            tabInfo0.f = 0;
            tabInfo0.g = 0;
            tabInfo0.h = 0;
            tabInfo0.i = -1;
            tabInfo0.j = -1.0f;
            tabInfo0.k = -1.0f;
            tabInfo0.l = -1.0f;
            tabInfo0.m = -1.0f;
            tabInfo0.n = 1.0f;
            tabInfo0.o = -1;
            arrayList0.add(tabInfo0);
        }
        return arrayList0;
    }

    @NotNull
    public static final PlaylistSearchAndAddTabFragment newInstance(@Nullable String s, @NotNull String s1) {
        return PlaylistSearchAndAddTabFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            Bundle bundle1 = this.getArguments();
            if(bundle1 != null) {
                this.originalSongIds = bundle1.getString("argOriginalSongIds");
                this.getPlaylistSearchViewModel().setOverSelectMessage(bundle1.getString("argOverSelectMessage"));
            }
        }
        this.getPlaylistSearchViewModel().getSongList().observe(this.requireActivity(), new PlaylistSearchAndAddTabFragment.sam.androidx_lifecycle_Observer.0(new com.iloen.melon.fragments.searchandadd.a(this, 4)));
        String s = this.originalSongIds;
        if(s != null) {
            if(s.length() > 0) {
                String[] arr_s = (String[])Tf.o.R0(s, new String[]{","}, 0, 6).toArray(new String[0]);
                ArrayList arrayList0 = new ArrayList(Arrays.asList(Arrays.copyOf(arr_s, arr_s.length)));
                this.getPlaylistSearchViewModel().setSongList(arrayList0);
                return;
            }
            this.getPlaylistSearchViewModel().setSongList(new ArrayList());
        }
    }

    private static final H onCreate$lambda$4(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, ArrayList arrayList0) {
        if(arrayList0 != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = arrayList0.size();
            int v1 = 0;
            for(int v2 = 0; v2 < v; ++v2) {
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(((String)arrayList0.get(v2)));
            }
            K k0 = playlistSearchAndAddTabFragment0.completeButton;
            if(k0 != null) {
                String s = String.valueOf(arrayList0.size());
                q.g(s, "strCount");
                TextView textView0 = k0.m;
                if(textView0 != null) {
                    textView0.setText(s);
                    goto label_21;
                }
                q.m("tvButtonSearchCount");
                throw null;
            }
        label_21:
            K k1 = playlistSearchAndAddTabFragment0.completeButton;
            if(k1 != null) {
                boolean z = arrayList0.size() > 0;
                View view0 = k1.k;
                if(view0 != null) {
                    view0.setEnabled(z);
                    View view1 = k1.j;
                    if(view1 != null) {
                        if(!z) {
                            v1 = 4;
                        }
                        view1.setVisibility(v1);
                        k1.j((z ? k1.g : 3));
                        goto label_38;
                    }
                    q.m("layoutSearchCount");
                    throw null;
                }
                q.m("layoutContainer");
                throw null;
            }
        label_38:
            SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = playlistSearchAndAddTabFragment0.searchListAdapter;
            if(playlistSearchAndAddTabFragment$SearchListAdapter0 != null) {
                playlistSearchAndAddTabFragment$SearchListAdapter0.notifyDataSetChanged();
                return H.a;
            }
            q.m("searchListAdapter");
            throw null;
        }
        return H.a;
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D02BE, viewGroup0, false);  // layout:fragment_playlist_search_and_add_pager
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        View view0;
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null) {
            view0 = null;
        }
        else {
            Window window0 = fragmentActivity0.getWindow();
            view0 = window0 == null ? null : window0.getCurrentFocus();
        }
        if(view0 != null) {
            InputMethodUtils.hideInputMethod(this.getContext(), view0);
        }
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argOriginalSongIds", "argOriginalSongIds");
    }

    @Override  // com.iloen.melon.fragments.MelonPagerFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        List list1;
        List list0;
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            r r0 = new r(0);
            r0.c = new k(this, 2);
            K k0 = new K(0, true);
            this.completeButton = k0;
            k0.c = new k(this, 3);
            r0.g(new m(2, false));
            r0.g(k0);
            titleBar0.a(r0);
            titleBar0.setTitle("곡 추가");
        }
        this.tabLayout = this.findViewById(0x7F0A0B14);  // id:tab_layout
        this.tabUnderline = this.findViewById(0x7F0A0B17);  // id:tab_underline
        this.layoutSearch = this.findViewById(0x7F0A073D);  // id:layout_search
        View view1 = this.findViewById(0x7F0A073E);  // id:layout_search_bar
        q.e(view1, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.layoutSearchBar = (RelativeLayout)view1;
        this.ivSearchBack = this.findViewById(0x7F0A0685);  // id:iv_search_back
        View view2 = this.findViewById(0x7F0A0684);  // id:iv_search
        this.ivSearch = view2;
        ViewUtils.setOnClickListener(view2, new k(this, 4));
        ViewUtils.setOnClickListener(this.ivSearchBack, new k(this, 5));
        View view3 = this.findViewById(0x7F0A061E);  // id:iv_delete_keyword
        this.ivDeleteKeyword = view3;
        ViewUtils.setOnClickListener(view3, new k(this, 1));
        View view4 = this.findViewById(0x7F0A0454);  // id:et_search
        q.e(view4, "null cannot be cast to non-null type com.iloen.melon.custom.MelonEditText");
        this.etSearch = (MelonEditText)view4;
        ((MelonEditText)view4).setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override  // android.widget.TextView$OnEditorActionListener
            public boolean onEditorAction(TextView textView0, int v, KeyEvent keyEvent0) {
                if(v != 3 && v != 6) {
                    return true;
                }
                MelonEditText melonEditText0 = PlaylistSearchAndAddTabFragment.this.etSearch;
                if(melonEditText0 != null) {
                    Editable editable0 = melonEditText0.getText();
                    if(editable0 != null && !Tf.o.H0(editable0)) {
                        PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = PlaylistSearchAndAddTabFragment.this;
                        MelonEditText melonEditText1 = playlistSearchAndAddTabFragment0.etSearch;
                        if(melonEditText1 != null) {
                            playlistSearchAndAddTabFragment0.fetchSearchResult(String.valueOf(melonEditText1.getText()));
                            Context context0 = PlaylistSearchAndAddTabFragment.this.getContext();
                            MelonEditText melonEditText2 = PlaylistSearchAndAddTabFragment.this.etSearch;
                            if(melonEditText2 != null) {
                                InputMethodUtils.hideInputMethod(context0, melonEditText2);
                                return true;
                            }
                            q.m("etSearch");
                            throw null;
                        }
                        q.m("etSearch");
                        throw null;
                    }
                    ToastManager.showShort(0x7F1300B9);  // string:alert_dlg_body_search_text_empty "검색어를 입력해주세요."
                    return false;
                }
                q.m("etSearch");
                throw null;
            }
        });
        MelonEditText melonEditText0 = this.etSearch;
        if(melonEditText0 != null) {
            melonEditText0.setOnFocusChangeListener((View view0, boolean z) -> if(!this.hasSearchFocus && z) {
                this.hasSearchFocus = true;
                this.changeSearchMode(true);
            });
            com.iloen.melon.fragments.searchandadd.PlaylistSearchAndAddTabFragment.onViewCreated.8 playlistSearchAndAddTabFragment$onViewCreated$80 = new TextWatcher() {
                @Override  // android.text.TextWatcher
                public void afterTextChanged(Editable editable0) {
                    q.g(editable0, "s");
                    MelonEditText melonEditText0 = PlaylistSearchAndAddTabFragment.this.etSearch;
                    if(melonEditText0 != null) {
                        if(melonEditText0.getSelectionEnd() > 0) {
                            ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.ivDeleteKeyword, true);
                            SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = PlaylistSearchAndAddTabFragment.this.searchListAdapter;
                            if(playlistSearchAndAddTabFragment$SearchListAdapter0 != null) {
                                playlistSearchAndAddTabFragment$SearchListAdapter0.changeListType(0);
                                PlaylistSearchAndAddTabFragment.this.autoCompleteKeywordHandler.sendEmptyMessageDelayed(5000, 100L);
                                return;
                            }
                            q.m("searchListAdapter");
                            throw null;
                        }
                        ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.ivDeleteKeyword, true);
                        SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter1 = PlaylistSearchAndAddTabFragment.this.searchListAdapter;
                        if(playlistSearchAndAddTabFragment$SearchListAdapter1 != null) {
                            playlistSearchAndAddTabFragment$SearchListAdapter1.changeListType(1);
                            if(PlaylistSearchAndAddTabFragment.this.hasSearchFocus) {
                                ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.layoutSearch, true);
                                ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.tabLayout, true);
                                return;
                            }
                            ViewUtils.hideWhen(PlaylistSearchAndAddTabFragment.this.layoutSearch, true);
                            ViewUtils.showWhen(PlaylistSearchAndAddTabFragment.this.tabLayout, true);
                            return;
                        }
                        q.m("searchListAdapter");
                        throw null;
                    }
                    q.m("etSearch");
                    throw null;
                }

                @Override  // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    q.g(charSequence0, "s");
                }

                @Override  // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                    q.g(charSequence0, "s");
                }
            };
            this.textWatcher = playlistSearchAndAddTabFragment$onViewCreated$80;
            MelonEditText melonEditText1 = this.etSearch;
            if(melonEditText1 != null) {
                melonEditText1.setTextWatcher(playlistSearchAndAddTabFragment$onViewCreated$80);
                MelonEditText melonEditText2 = this.etSearch;
                if(melonEditText2 != null) {
                    melonEditText2.setTextLimit(MelonLimits.TextLimit.b);
                    View view5 = this.findViewById(0x7F0A0A48);  // id:search_recycler_view
                    q.e(view5, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                    this.searchRecyclerView = (RecyclerView)view5;
                    ((RecyclerView)view5).setLayoutManager(new LinearLayoutManager(this.getContext()));
                    SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = new SearchListAdapter(this);
                    this.searchListAdapter = playlistSearchAndAddTabFragment$SearchListAdapter0;
                    RecyclerView recyclerView0 = this.searchRecyclerView;
                    if(recyclerView0 != null) {
                        recyclerView0.setAdapter(playlistSearchAndAddTabFragment$SearchListAdapter0);
                        RecyclerView recyclerView1 = this.searchRecyclerView;
                        if(recyclerView1 != null) {
                            recyclerView1.addOnScrollListener(new A0() {
                                @Override  // androidx.recyclerview.widget.A0
                                public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                                    q.g(recyclerView0, "recyclerView");
                                    super.onScrollStateChanged(recyclerView0, v);
                                }

                                @Override  // androidx.recyclerview.widget.A0
                                public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                                    q.g(recyclerView0, "recyclerView");
                                    super.onScrolled(recyclerView0, v, v1);
                                    SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = PlaylistSearchAndAddTabFragment.this.searchListAdapter;
                                    if(playlistSearchAndAddTabFragment$SearchListAdapter0 != null) {
                                        if(playlistSearchAndAddTabFragment$SearchListAdapter0.getListType() == 2) {
                                            LinearLayoutManager linearLayoutManager0 = (LinearLayoutManager)recyclerView0.getLayoutManager();
                                            if(linearLayoutManager0 != null) {
                                                int v2 = linearLayoutManager0.findLastCompletelyVisibleItemPosition();
                                                PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = PlaylistSearchAndAddTabFragment.this;
                                                if(playlistSearchAndAddTabFragment0.hasSearchMore) {
                                                    j0 j00 = recyclerView0.getAdapter();
                                                    int v3 = j00 == null ? 0 : j00.getItemCount();
                                                    if(v2 >= v3 - 1) {
                                                        MelonEditText melonEditText0 = playlistSearchAndAddTabFragment0.etSearch;
                                                        if(melonEditText0 != null) {
                                                            playlistSearchAndAddTabFragment0.fetchSearchResult(String.valueOf(melonEditText0.getText()), v3);
                                                            return;
                                                        }
                                                        q.m("etSearch");
                                                        throw null;
                                                    }
                                                }
                                            }
                                        }
                                        return;
                                    }
                                    q.m("searchListAdapter");
                                    throw null;
                                }
                            });
                            String s = MelonPrefs.getInstance().getString("DJ_PLAYLIST_LAST_ADDED_SONG_LIST", "");
                            if(s != null) {
                                Pattern pattern0 = Pattern.compile(",");
                                q.f(pattern0, "compile(...)");
                                Tf.o.P0(0);
                                Matcher matcher0 = pattern0.matcher(s);
                                if(matcher0.find()) {
                                    ArrayList arrayList0 = new ArrayList(10);
                                    int v = 0;
                                    do {
                                        v = o.c(matcher0, s, v, arrayList0);
                                    }
                                    while(matcher0.find());
                                    o.w(v, s, arrayList0);
                                    list0 = arrayList0;
                                }
                                else {
                                    list0 = e.k.z(s.toString());
                                }
                                if(!list0.isEmpty()) {
                                    ListIterator listIterator0 = list0.listIterator(list0.size());
                                    while(listIterator0.hasPrevious()) {
                                        if(((String)listIterator0.previous()).length() == 0) {
                                            continue;
                                        }
                                        list1 = p.K0(listIterator0.nextIndex() + 1, list0);
                                        goto label_76;
                                    }
                                }
                                list1 = w.a;
                            label_76:
                                String[] arr_s = (String[])list1.toArray(new String[0]);
                                if(arr_s != null) {
                                    ArrayList arrayList1 = new ArrayList(Arrays.asList(Arrays.copyOf(arr_s, arr_s.length)));
                                    this.getPlaylistSearchViewModel().setLastAddedSongList(arrayList1);
                                    this.requestRecentAddedSong(arrayList1);
                                }
                            }
                            return;
                        }
                        q.m("searchRecyclerView");
                        throw null;
                    }
                    q.m("searchRecyclerView");
                    throw null;
                }
                q.m("etSearch");
                throw null;
            }
            q.m("etSearch");
            throw null;
        }
        q.m("etSearch");
        throw null;
    }

    private static final void onViewCreated$lambda$10(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
        MelonEditText melonEditText0 = playlistSearchAndAddTabFragment0.etSearch;
        if(melonEditText0 != null) {
            melonEditText0.clearFocus();
            playlistSearchAndAddTabFragment0.hasSearchFocus = false;
            playlistSearchAndAddTabFragment0.changeSearchMode(false);
            return;
        }
        q.m("etSearch");
        throw null;
    }

    private static final void onViewCreated$lambda$11(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
        MelonEditText melonEditText0 = playlistSearchAndAddTabFragment0.etSearch;
        if(melonEditText0 != null) {
            melonEditText0.setText("");
            return;
        }
        q.m("etSearch");
        throw null;
    }

    // 检测为 Lambda 实现
    private static final void onViewCreated$lambda$12(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0, boolean z) [...]

    private static final void onViewCreated$lambda$6(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
        playlistSearchAndAddTabFragment0.performBackPress();
    }

    private static final void onViewCreated$lambda$8$lambda$7(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
        playlistSearchAndAddTabFragment0.save();
    }

    private static final void onViewCreated$lambda$9(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, View view0) {
        MelonEditText melonEditText0 = playlistSearchAndAddTabFragment0.etSearch;
        if(melonEditText0 != null) {
            playlistSearchAndAddTabFragment0.fetchSearchResult(String.valueOf(melonEditText0.getText()));
            return;
        }
        q.m("etSearch");
        throw null;
    }

    private static final PlaylistSearchViewModel playlistSearchViewModel_delegate$lambda$1(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0) {
        FragmentActivity fragmentActivity0 = playlistSearchAndAddTabFragment0.requireActivity();
        q.f(fragmentActivity0, "requireActivity(...)");
        q0 q00 = fragmentActivity0.getViewModelStore();
        o0 o00 = fragmentActivity0.getDefaultViewModelProviderFactory();
        c c0 = fragmentActivity0.getDefaultViewModelCreationExtras();
        q.g(q00, "store");
        q.g(o00, "factory");
        b b0 = a.p(c0, "defaultCreationExtras", q00, o00, c0);
        d d0 = df.d.y(PlaylistSearchViewModel.class);
        String s = d0.l();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (PlaylistSearchViewModel)b0.s(d0, "androidx.lifecycle.ViewModelProvider.DefaultKey:" + s);
    }

    private final void requestRecentAddedSong(ArrayList arrayList0) {
        if(arrayList0 != null && arrayList0.size() != 0) {
            TaskGetSongInfo taskGetSongInfo0 = new TaskGetSongInfo(arrayList0, CType.SONG);
            taskGetSongInfo0.setResultListener(new ResultListener() {
                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onFinishTask(Throwable throwable0) {
                    if(taskGetSongInfo0.isFragmentValid()) {
                        if(throwable0 != null) {
                            ToastManager.show(throwable0.getMessage());
                            return;
                        }
                        List list0 = this.$task.getSongInfoList();
                        taskGetSongInfo0.recentAddedSongList = list0 instanceof ArrayList ? ((ArrayList)list0) : null;
                        ArrayList arrayList0 = taskGetSongInfo0.recentAddedSongList;
                        if(arrayList0 != null) {
                            PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0 = taskGetSongInfo0;
                            SearchListAdapter playlistSearchAndAddTabFragment$SearchListAdapter0 = playlistSearchAndAddTabFragment0.searchListAdapter;
                            if(playlistSearchAndAddTabFragment$SearchListAdapter0 == null) {
                                q.m("searchListAdapter");
                                throw null;
                            }
                            playlistSearchAndAddTabFragment$SearchListAdapter0.setLastAddedSongList(arrayList0);
                            if(playlistSearchAndAddTabFragment0.hasSearchFocus) {
                                ViewUtils.showWhen(playlistSearchAndAddTabFragment0.layoutSearch, true);
                                ViewUtils.hideWhen(playlistSearchAndAddTabFragment0.tabLayout, true);
                            }
                        }
                    }
                }

                @Override  // com.iloen.melon.task.request.TaskGetSongInfo$ResultListener
                public void onStartTask() {
                }
            });
            taskGetSongInfo0.executeAsync();
        }
    }

    private final void save() {
        String s;
        ArrayList arrayList0 = (ArrayList)this.getPlaylistSearchViewModel().getLastAddedSongList().getValue();
        if(arrayList0 != null) {
            StringBuilder stringBuilder0 = new StringBuilder();
            int v = 0;
            for(Object object0: arrayList0) {
                if(v > 9) {
                    break;
                }
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(((String)object0));
                ++v;
            }
            MelonPrefs.getInstance().setString("DJ_PLAYLIST_LAST_ADDED_SONG_LIST", stringBuilder0.toString());
        }
        ArrayList arrayList1 = (ArrayList)this.getPlaylistSearchViewModel().getSongList().getValue();
        if(arrayList1 == null) {
            s = null;
        }
        else {
            StringBuilder stringBuilder1 = new StringBuilder();
            Iterator iterator1 = arrayList1.iterator();
            q.f(iterator1, "iterator(...)");
            while(iterator1.hasNext()) {
                Object object1 = iterator1.next();
                q.f(object1, "next(...)");
                if(stringBuilder1.length() > 0) {
                    stringBuilder1.append(",");
                }
                stringBuilder1.append(((String)object1));
            }
            s = stringBuilder1.toString();
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            Intent intent0 = new Intent();
            intent0.putExtra("argSearchResultValues", s);
            if(fragmentActivity0.getParent() == null) {
                fragmentActivity0.setResult(-1, intent0);
            }
            else {
                fragmentActivity0.getParent().setResult(-1, intent0);
            }
            fragmentActivity0.onBackPressed();
        }
    }

    private final void showContextPopupSort(TextView textView0) {
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 == null || this.isRetainedPopupShowing()) {
            return;
        }
        BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
        bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
        bottomSingleFilterListPopup0.setFilterItem(n.z0(this.getFilterNameList()), this.orderBy);
        bottomSingleFilterListPopup0.setFilterListener(new com.iloen.melon.fragments.searchandadd.b(this, textView0, 1));
        bottomSingleFilterListPopup0.setOnDismissListener(this.mDialogDismissListener);
        this.mRetainDialog = bottomSingleFilterListPopup0;
        bottomSingleFilterListPopup0.show();
    }

    private static final void showContextPopupSort$lambda$18(PlaylistSearchAndAddTabFragment playlistSearchAndAddTabFragment0, TextView textView0, int v) {
        if(v == playlistSearchAndAddTabFragment0.orderBy) {
            return;
        }
        playlistSearchAndAddTabFragment0.orderBy = v;
        String[] arr_s = playlistSearchAndAddTabFragment0.getFilterNameList();
        textView0.setText(arr_s[playlistSearchAndAddTabFragment0.orderBy]);
        MelonEditText melonEditText0 = playlistSearchAndAddTabFragment0.etSearch;
        if(melonEditText0 != null) {
            playlistSearchAndAddTabFragment0.fetchSearchResult(String.valueOf(melonEditText0.getText()));
            return;
        }
        q.m("etSearch");
        throw null;
    }

    private final void showInstantPlayPopup(Playable playable0) {
        MelonAppBase.Companion.getClass();
        if(!t.a().isCarConnected()) {
            if(this.getActivity() != null) {
                InstantPlayPopup instantPlayPopup0 = new InstantPlayPopup(playable0);
                this.instantPlayPopup = instantPlayPopup0;
                l0 l00 = this.getChildFragmentManager();
                q.f(l00, "getChildFragmentManager(...)");
                instantPlayPopup0.show(l00, "InstantPlayPopup");
            }
            return;
        }
        ToastManager.show("기기 연동 중 상태에서는 해당 기능을 지원하지 않습니다.");
    }
}

