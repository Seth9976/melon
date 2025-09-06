package com.iloen.melon.fragments.test;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MyMusicMusicDnaListReq;
import com.iloen.melon.net.v4x.response.MyMusicMusicDnaListRes.RESPONSE;
import com.iloen.melon.net.v4x.response.MyMusicMusicDnaListRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.log.LogU;
import v9.h;
import v9.i;

public class TestResponseCacheFragment extends MetaContentBaseFragment {
    private static final String TAG = "TestResponseCacheFragment";

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return null;
    }

    public static void d0(TestResponseCacheFragment testResponseCacheFragment0, RESPONSE myMusicMusicDnaListRes$RESPONSE0) {
    }

    private RESPONSE fetchData() {
        Cursor cursor0 = a.f(this.getContext(), this.getCacheKey());
        if(cursor0 == null) {
            LogU.w("TestResponseCacheFragment", "fetchData() invalid cursor");
            return null;
        }
        MyMusicMusicDnaListRes myMusicMusicDnaListRes0 = cursor0.getCount() <= 0 ? null : ((MyMusicMusicDnaListRes)a.d(cursor0, MyMusicMusicDnaListRes.class));
        if(!cursor0.isClosed()) {
            cursor0.close();
        }
        if(myMusicMusicDnaListRes0 == null) {
            LogU.w("TestResponseCacheFragment", "fetchData() failed to extract contents");
            return null;
        }
        return myMusicMusicDnaListRes0.response;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return Uri.parse(this.getClass().getSimpleName()).toString();
    }

    public static TestResponseCacheFragment newInstance() {
        return new TestResponseCacheFragment();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D02C5, viewGroup0, false);  // layout:fragment_test_response_cache
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        Context context0 = this.getContext();
        if(a.e(300000L, this.getCacheKey(), context0)) {
            RequestBuilder.newInstance(new MyMusicMusicDnaListReq(this.getContext(), "0")).tag(this.getRequestTag()).listener(new Listener() {
                public void onResponse(MyMusicMusicDnaListRes myMusicMusicDnaListRes0) {
                    if(!TestResponseCacheFragment.this.prepareFetchComplete(myMusicMusicDnaListRes0)) {
                        return;
                    }
                    a.a(TestResponseCacheFragment.this.getContext(), myMusicMusicDnaListRes0, TestResponseCacheFragment.this.getCacheKey());
                    TestResponseCacheFragment.this.performFetchCompleteOnlyViews();
                }

                @Override  // com.android.volley.Response$Listener
                public void onResponse(Object object0) {
                    this.onResponse(((MyMusicMusicDnaListRes)object0));
                }
            }).errorListener(this.mResponseErrorListener).request();
            return true;
        }
        this.updateUi(this.fetchData());
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(Bundle bundle0) {
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.setTitle("ResponseCache");
        }
    }

    private void updateUi(RESPONSE myMusicMusicDnaListRes$RESPONSE0) {
    }
}

