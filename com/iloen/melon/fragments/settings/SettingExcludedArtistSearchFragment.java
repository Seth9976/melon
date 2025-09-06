package com.iloen.melon.fragments.settings;

import Tf.o;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.l0;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.media3.session.S0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.SortingBarView;
import com.iloen.melon.custom.V0;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.ListArtistReq.Params;
import com.iloen.melon.net.v4x.request.ListArtistReq;
import com.iloen.melon.net.v4x.response.ListArtistRes.Response.CONTENTSLIST;
import com.iloen.melon.net.v4x.response.ListArtistRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.InputMethodUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.viewholders.ExcludedArtistHolder;
import com.melon.ui.popup.b;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.e;
import v9.h;
import we.n;
import z9.F;
import z9.i;
import z9.j;
import z9.k;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ#\u0010\u000F\u001A\u00020\t2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u001B\u0010\u0013\u001A\u00020\u00062\n\u0010\u0012\u001A\u00060\u0011R\u00020\u0000H\u0002\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0003J\u000F\u0010\u001A\u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ-\u0010#\u001A\u0004\u0018\u00010\"2\u0006\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b#\u0010$J!\u0010&\u001A\u00020\u00062\u0006\u0010%\u001A\u00020\"2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b&\u0010\'J-\u0010*\u001A\u00020\t2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010)\u001A\u0004\u0018\u00010(2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b*\u0010+J\u000F\u0010-\u001A\u00020,H\u0014\u00A2\u0006\u0004\b-\u0010.J\u001B\u00102\u001A\u0006\u0012\u0002\b\u0003012\u0006\u00100\u001A\u00020/H\u0014\u00A2\u0006\u0004\b2\u00103J\u000F\u00104\u001A\u00020\u0006H\u0016\u00A2\u0006\u0004\b4\u0010\u0003R\u0016\u00105\u001A\u00020\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010:\u001A\u0002098\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u0012\u001A\u00060\u0011R\u00020\u00008BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b<\u0010=\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "reason", "Lie/H;", "searchArtistList", "(Ljava/lang/String;)V", "", "isValidSearchKeyword", "()Z", "Lv9/i;", "type", "keyword", "requestListArtist", "(Lv9/i;Ljava/lang/String;)Z", "Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter;", "adapter", "updateErrorUI", "(Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter;)V", "condition", "showSearchBar", "(Z)V", "hideSoftKey", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/h;", "param", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "onPause", "sortType", "I", "searchKeyword", "Ljava/lang/String;", "Lcom/iloen/melon/custom/SearchBarView;", "searchBarView", "Lcom/iloen/melon/custom/SearchBarView;", "getAdapter", "()Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter;", "Companion", "ExcludedArtistSearchAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingExcludedArtistSearchFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001A\u00020\rH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$Companion;", "", "<init>", "()V", "TAG", "", "SORT_EXACT", "", "SORT_POPULAR", "SORT_ALPHABET", "VIEW_TYPE_SORT", "VIEW_TYPE_ARTIST", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingExcludedArtistSearchFragment newInstance() {
            return new SettingExcludedArtistSearchFragment();
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001DB!\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u000F\u0010\u0010J\u001F\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001A\u00020\u00032\b\u0010\u0016\u001A\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001B\u001A\u00020\u000B2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/net/v4x/response/ListArtistRes$Response$CONTENTSLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment;Landroid/content/Context;Ljava/util/List;)V", "item", "Lie/H;", "insertExcludedArtist", "(Lcom/iloen/melon/net/v4x/response/ListArtistRes$Response$CONTENTSLIST;)V", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "SortViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ExcludedArtistSearchAdapter extends p {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter$SortViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/settings/SettingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/custom/SortingBarView;", "sortingBarView", "Lcom/iloen/melon/custom/SortingBarView;", "getSortingBarView", "()Lcom/iloen/melon/custom/SortingBarView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SortViewHolder extends O0 {
            @NotNull
            private final SortingBarView sortingBarView;

            public SortViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                ExcludedArtistSearchAdapter.this = settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0AB8);  // id:sort_bar
                q.f(view1, "findViewById(...)");
                this.sortingBarView = (SortingBarView)view1;
                ((SortingBarView)view1).setSortBarStyle(2);
                ((SortingBarView)view1).setItems(new String[]{"정확도", "인기순", "가나다순"});
            }

            @NotNull
            public final SortingBarView getSortingBarView() {
                return this.sortingBarView;
            }
        }

        public ExcludedArtistSearchAdapter(@Nullable Context context0, @Nullable List list0) {
            super(context0, list0);
            e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
            e0.d = -1;
            e0.e = -1;
            e0.g = -1;
            e0.i = -1;
            e0.k = -1;
            e0.l = -1;
            e0.f = settingExcludedArtistSearchFragment0.getString(0x7F1303F9);  // string:excluded_artist_search "아티스트를 검색하세요."
            this.setEmptyViewInfo(e0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.getCount() <= 0 ? 0 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.getHeaderViewItemCount() <= 0 || v != this.getAvailableHeaderPosition() ? 2 : 1;
        }

        private final void insertExcludedArtist(CONTENTSLIST listArtistRes$Response$CONTENTSLIST0) {
            D d0 = SettingExcludedArtistSearchFragment.this.getViewLifecycleOwner();
            q.f(d0, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(listArtistRes$Response$CONTENTSLIST0, null) {
                final CONTENTSLIST $item;
                int label;

                {
                    SettingExcludedArtistSearchFragment.this = settingExcludedArtistSearchFragment0;
                    this.$item = listArtistRes$Response$CONTENTSLIST0;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.iloen.melon.fragments.settings.SettingExcludedArtistSearchFragment.ExcludedArtistSearchAdapter.insertExcludedArtist.1(SettingExcludedArtistSearchFragment.this, this.$item, continuation0);
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.fragments.settings.SettingExcludedArtistSearchFragment.ExcludedArtistSearchAdapter.insertExcludedArtist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    a a0 = a.a;
                    H h0 = H.a;
                    switch(this.label) {
                        case 0: {
                            d5.n.D(object0);
                            LogU.Companion.d("SettingExcludedArtistSearchFragment", "insertExcludedArtist()");
                            this.label = 1;
                            object0 = F.a.f(this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_11;
                        }
                        case 1: {
                            d5.n.D(object0);
                        label_11:
                            if(((Number)object0).intValue() >= 100) {
                                ToastManager.show(0x7F130962);  // string:setting_banned_contents_artist_limit "100명까지 제외 가능합니다. 제외한 아티스트 삭제 후 시도해주세요."
                                return h0;
                            }
                            SettingExcludedArtistSearchFragment.this.showProgress(true);
                            this.label = 2;
                            object0 = F.q(1001, this.$item.artistId, null, this);
                            if(object0 == a0) {
                                return a0;
                            }
                            goto label_20;
                        }
                        case 2: {
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    d5.n.D(object0);
                label_20:
                    if(!SettingExcludedArtistSearchFragment.this.isFragmentValid()) {
                        return h0;
                    }
                    SettingExcludedArtistSearchFragment.this.showProgress(false);
                    if(((k)object0) instanceof j) {
                        SettingExcludedArtistSearchFragment.this.performBackPress();
                        return h0;
                    }
                    if(!(((k)object0) instanceof i)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                    ToastManager.show(((i)(((k)object0))).a);
                    return h0;
                }
            }, 3, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof SortViewHolder) {
                SortingBarView sortingBarView0 = ((SortViewHolder)o00).getSortingBarView();
                sortingBarView0.setSelection(SettingExcludedArtistSearchFragment.this.sortType);
                sortingBarView0.setSortBarHeight(ScreenUtils.dipToPixel(sortingBarView0.getContext(), 34.0f));
                sortingBarView0.setOnSortSelectionListener(new s(SettingExcludedArtistSearchFragment.this, 0));
                return;
            }
            if(o00 instanceof ExcludedArtistHolder) {
                Object object0 = this.getItem(v1);
                q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.v4x.response.ListArtistRes.Response.CONTENTSLIST");
                Glide.with(this.getContext()).load(((CONTENTSLIST)object0).artistImg).apply(RequestOptions.circleCropTransform()).into(((ExcludedArtistHolder)o00).thumbIv);
                ((ExcludedArtistHolder)o00).artistNameTv.setText(((CONTENTSLIST)object0).artistName);
                ((ExcludedArtistHolder)o00).artistNewsTv.setText(((CONTENTSLIST)object0).actGenre);
                ViewUtils.hideWhen(((ExcludedArtistHolder)o00).friendshipLayout, true);
                TextView textView0 = ((ExcludedArtistHolder)o00).a;
                if(textView0 != null) {
                    if(((CONTENTSLIST)object0).isExcArtist) {
                        ViewUtils.hideWhen(textView0, true);
                        return;
                    }
                    ViewUtils.showWhen(textView0, true);
                    textView0.setText(0x7F1303F7);  // string:excluded_artist_add "추가"
                    ViewUtils.setOnClickListener(textView0, new com.iloen.melon.fragments.settings.q(1, this, ((CONTENTSLIST)object0)));
                }
            }
        }

        private static final void onBindViewImpl$lambda$2$lambda$1(SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, int v) {
            if(settingExcludedArtistSearchFragment0.sortType == v) {
                return;
            }
            settingExcludedArtistSearchFragment0.sortType = v;
            settingExcludedArtistSearchFragment0.searchArtistList("Change sortType");
        }

        private static final void onBindViewImpl$lambda$6$lambda$5$lambda$4$lambda$3(ExcludedArtistSearchAdapter settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0, CONTENTSLIST listArtistRes$Response$CONTENTSLIST0, View view0) {
            settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0.insertExcludedArtist(listArtistRes$Response$CONTENTSLIST0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            if(v == 1) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D082C, viewGroup0, false);  // layout:setting_excluded_artist_sortbar
                q.f(view0, "inflate(...)");
                return new SortViewHolder(this, view0);
            }
            return new ExcludedArtistHolder(LayoutInflater.from(this.getContext()).inflate(0x7F0D0456, viewGroup0, false));  // layout:listitem_artist
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int SORT_ALPHABET = 2;
    private static final int SORT_EXACT = 0;
    private static final int SORT_POPULAR = 1;
    @NotNull
    private static final String TAG = "SettingExcludedArtistSearchFragment";
    private static final int VIEW_TYPE_ARTIST = 2;
    private static final int VIEW_TYPE_SORT = 1;
    private SearchBarView searchBarView;
    @NotNull
    private String searchKeyword;
    private int sortType;

    static {
        SettingExcludedArtistSearchFragment.Companion = new Companion(null);
        SettingExcludedArtistSearchFragment.$stable = 8;
    }

    public SettingExcludedArtistSearchFragment() {
        this.searchKeyword = "";
    }

    public static void L(SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, boolean z, VolleyError volleyError0) {
        SettingExcludedArtistSearchFragment.requestListArtist$lambda$2(settingExcludedArtistSearchFragment0, z, volleyError0);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new ExcludedArtistSearchAdapter(this, context0, null);
    }

    private final ExcludedArtistSearchAdapter getAdapter() {
        j0 j00 = this.mAdapter;
        q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.settings.SettingExcludedArtistSearchFragment.ExcludedArtistSearchAdapter");
        return (ExcludedArtistSearchAdapter)j00;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1303FB;  // string:excluded_artist_search_title "아티스트 검색"
    }

    private final void hideSoftKey() {
        SearchBarView searchBarView0 = this.searchBarView;
        if(searchBarView0 != null) {
            searchBarView0.a();
            return;
        }
        q.m("searchBarView");
        throw null;
    }

    private final boolean isValidSearchKeyword() {
        if(TextUtils.isEmpty(this.searchKeyword)) {
            l0 l00 = this.getChildFragmentManager();
            String s = this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
            String s1 = this.getString(0x7F1303F8);  // string:excluded_artist_popup_description "검색어를 입력하세요."
            b.d(b.a, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
            LogU.Companion.d("SettingExcludedArtistSearchFragment", "isValidSearchKeyword() - searchKeyword empty");
            return false;
        }
        return true;
    }

    @NotNull
    public static final SettingExcludedArtistSearchFragment newInstance() {
        return SettingExcludedArtistSearchFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D082B, viewGroup0, false);  // layout:setting_excluded_artist_search
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        return this.requestListArtist(i0, this.searchKeyword);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
        this.hideSoftKey();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A0A36);  // id:search_bar
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SearchBarView");
        ((SearchBarView)view1).setOnSearchBarListener(new V0() {
            @Override  // com.iloen.melon.custom.Y
            public void onActionClick(InputBarView inputBarView0) {
            }

            @Override  // com.iloen.melon.custom.Y
            public void onClearClick(InputBarView inputBarView0) {
                SettingExcludedArtistSearchFragment.this.searchKeyword = "";
            }

            @Override  // com.iloen.melon.custom.V0
            public void onClearKeyword(SearchBarView searchBarView0) {
                SettingExcludedArtistSearchFragment.this.searchKeyword = "";
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchClick(SearchBarView searchBarView0, String s) {
                SettingExcludedArtistSearchFragment.this.searchArtistList("call by onSearchKeyword");
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchKeyword(SearchBarView searchBarView0, String s) {
                String s1;
                SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0 = SettingExcludedArtistSearchFragment.this;
                if(s == null) {
                    s1 = "";
                }
                else {
                    s1 = o.e1(s).toString();
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                settingExcludedArtistSearchFragment0.searchKeyword = s1;
            }
        });
        InputMethodUtils.showInputMethod(((SearchBarView)view1).getContext(), ((SearchBarView)view1).getInputTextView());
        this.searchBarView = (SearchBarView)view1;
    }

    private final boolean requestListArtist(v9.i i0, String s) {
        com.iloen.melon.utils.log.LogU.Companion logU$Companion0 = LogU.Companion;
        String s1 = i0 == null ? "Unknown type" : i0;
        logU$Companion0.d("SettingExcludedArtistSearchFragment", "requestListArtist() - type: " + s1);
        if(TextUtils.isEmpty(s)) {
            return false;
        }
        boolean z = v9.i.b.equals(i0);
        Params listArtistReq$Params0 = new Params();
        listArtistReq$Params0.startIndex = z ? 1 : this.getAdapter().getCount() + 1;
        int v = this.sortType;
        switch(v) {
            case 0: {
                listArtistReq$Params0.orderBy = "EXACT";
                break;
            }
            case 1: {
                listArtistReq$Params0.orderBy = "POP";
                break;
            }
            default: {
                if(v == 2) {
                    listArtistReq$Params0.orderBy = "ALPHABET";
                }
            }
        }
        RequestBuilder.newInstance(new ListArtistReq(this.getContext(), s, listArtistReq$Params0)).tag("SettingExcludedArtistSearchFragment").listener(new r(this, z, i0)).errorListener(new S0(this, z, 5)).request();
        return true;
    }

    private static final void requestListArtist$lambda$1(SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, boolean z, v9.i i0, ListArtistRes listArtistRes0) {
        settingExcludedArtistSearchFragment0.showSearchBar(true);
        if(!settingExcludedArtistSearchFragment0.prepareFetchComplete(listArtistRes0)) {
            settingExcludedArtistSearchFragment0.getAdapter().clear(true);
            return;
        }
        if(z) {
            settingExcludedArtistSearchFragment0.getAdapter().clear(true);
        }
        settingExcludedArtistSearchFragment0.performFetchComplete(i0, listArtistRes0);
    }

    private static final void requestListArtist$lambda$2(SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, boolean z, VolleyError volleyError0) {
        settingExcludedArtistSearchFragment0.showProgress(false);
        settingExcludedArtistSearchFragment0.showSearchBar(false);
        if(z) {
            settingExcludedArtistSearchFragment0.getAdapter().clear(true);
        }
        settingExcludedArtistSearchFragment0.updateErrorUI(settingExcludedArtistSearchFragment0.getAdapter());
    }

    private final void searchArtistList(String s) {
        LogU.Companion.d("SettingExcludedArtistSearchFragment", "searchArtistList()");
        this.hideSoftKey();
        if(this.isValidSearchKeyword()) {
            this.startFetch(s);
        }
    }

    private final void showSearchBar(boolean z) {
        SearchBarView searchBarView0 = this.searchBarView;
        if(searchBarView0 != null) {
            ViewUtils.showWhen(searchBarView0, z);
            return;
        }
        q.m("searchBarView");
        throw null;
    }

    private final void updateErrorUI(ExcludedArtistSearchAdapter settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0) {
        v9.o o0 = new v9.o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.b = -1;
        o0.c = -1;
        o0.e = -1;
        o0.h = -1;
        o0.i = -1;
        o0.g = new com.iloen.melon.fragments.settings.q(0, settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0, this);
        o0.f = new c(this, 2);
        settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0.setErrorViewInfo(o0);
        settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0.showErrorView(true);
    }

    private static final void updateErrorUI$lambda$5$lambda$3(ExcludedArtistSearchAdapter settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0, SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, View view0) {
        if(NetUtils.isConnected()) {
            settingExcludedArtistSearchFragment$ExcludedArtistSearchAdapter0.showErrorView(false);
            settingExcludedArtistSearchFragment0.startFetch(v9.i.b, h.b, true, "onRetryClick");
            return;
        }
        NetUtils.showNetworkInfoPopupIfNotConnected(settingExcludedArtistSearchFragment0.getContext());
    }

    private static final void updateErrorUI$lambda$5$lambda$4(SettingExcludedArtistSearchFragment settingExcludedArtistSearchFragment0, View view0) {
        SettingMainFragment.Companion.newInstance(true).open();
    }
}

