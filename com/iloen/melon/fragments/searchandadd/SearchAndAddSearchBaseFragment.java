package com.iloen.melon.fragments.searchandadd;

import com.iloen.melon.custom.InputBarView;
import com.iloen.melon.custom.SearchBarView;
import com.iloen.melon.custom.V0;
import com.iloen.melon.net.v4x.common.SearchOrderBy;
import com.iloen.melon.utils.log.LogU;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \u001A2\u00020\u0001:\u0001\u001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\r\u0010\u000ER\u0016\u0010\u000F\u001A\u00020\u000B8\u0004@\u0004X\u0085\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R$\u0010\u0011\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\bR\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00048\u0004@\u0004X\u0085\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0018\u001A\u00020\u00178\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/SearchAndAddSearchBaseFragment;", "Lcom/iloen/melon/fragments/searchandadd/SearchAndAddBaseFragment;", "<init>", "()V", "", "keyword", "Lie/H;", "changeKeyword", "(Ljava/lang/String;)V", "tag", "searchKeyword", "", "sortType", "convertSortTypeToOrderBy", "(I)I", "orderBy", "I", "prevKeyword", "Ljava/lang/String;", "getPrevKeyword", "()Ljava/lang/String;", "setPrevKeyword", "mKeyword", "Lcom/iloen/melon/custom/V0;", "onSearchBarListener", "Lcom/iloen/melon/custom/V0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SearchAndAddSearchBaseFragment extends SearchAndAddBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/searchandadd/SearchAndAddSearchBaseFragment$Companion;", "", "<init>", "()V", "TAG", "", "PAGE_SIZE", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final int PAGE_SIZE = 25;
    @NotNull
    private static final String TAG = "SearchAndAddSearchBaseFragment";
    @Nullable
    protected String mKeyword;
    @NotNull
    protected final V0 onSearchBarListener;
    protected int orderBy;
    @Nullable
    private String prevKeyword;

    static {
        SearchAndAddSearchBaseFragment.Companion = new Companion(null);
        SearchAndAddSearchBaseFragment.$stable = 8;
    }

    public SearchAndAddSearchBaseFragment() {
        this.orderBy = SearchOrderBy.ACCURACY;
        this.onSearchBarListener = new V0() {
            @Override  // com.iloen.melon.custom.Y
            public void onActionClick(InputBarView inputBarView0) {
                q.g(inputBarView0, "view");
            }

            @Override  // com.iloen.melon.custom.Y
            public void onClearClick(InputBarView inputBarView0) {
                q.g(inputBarView0, "view");
                SearchAndAddSearchBaseFragment.this.changeKeyword(SearchAndAddSearchBaseFragment.this.getPrevKeyword());
            }

            @Override  // com.iloen.melon.custom.V0
            public void onClearKeyword(SearchBarView searchBarView0) {
                q.g(searchBarView0, "view");
                SearchAndAddSearchBaseFragment.this.changeKeyword(SearchAndAddSearchBaseFragment.this.getPrevKeyword());
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchClick(SearchBarView searchBarView0, String s) {
                q.g(searchBarView0, "view");
                q.g(s, "keyword");
                SearchAndAddSearchBaseFragment.this.searchKeyword("onSearchClick");
            }

            @Override  // com.iloen.melon.custom.V0
            public void onSearchKeyword(SearchBarView searchBarView0, String s) {
                q.g(searchBarView0, "view");
                q.g(s, "keyword");
                SearchAndAddSearchBaseFragment.this.changeKeyword(s);
            }
        };
    }

    public final void changeKeyword(@Nullable String s) {
        Y.w("changeKeyword() keyword : ", s, LogU.Companion, "SearchAndAddSearchBaseFragment");
        this.mKeyword = s;
    }

    public int convertSortTypeToOrderBy(int v) {
        switch(v) {
            case 0: {
                return SearchOrderBy.ACCURACY;
            }
            case 1: {
                return SearchOrderBy.POPULARITY;
            }
            case 2: {
                return SearchOrderBy.RECENTLY;
            }
            default: {
                return SearchOrderBy.ACCURACY;
            }
        }
    }

    @Nullable
    public final String getPrevKeyword() {
        return this.prevKeyword;
    }

    public final void searchKeyword(@Nullable String s) {
        Y.w("searchKeyword() keyword : ", this.mKeyword, LogU.Companion, "SearchAndAddSearchBaseFragment");
        this.prevKeyword = this.mKeyword;
        this.changeKeyword(this.mKeyword);
        this.startFetch(s);
    }

    public final void setPrevKeyword(@Nullable String s) {
        this.prevKeyword = s;
    }
}

