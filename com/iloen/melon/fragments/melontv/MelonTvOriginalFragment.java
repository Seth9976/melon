package com.iloen.melon.fragments.melontv;

import android.content.Intent;
import android.text.TextUtils;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.f0;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.google.android.exoplayer2.upstream.cache.a;
import com.iloen.melon.activity.ProgramSelectActivity;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.fragments.melontv.program.TvProgramHomeFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.MelonTvOriginalListReq.ParamInfo;
import com.iloen.melon.net.v4x.request.MelonTvOriginalListReq;
import com.iloen.melon.net.v4x.response.MelonTvOriginalListRes;
import com.iloen.melon.utils.Navigator;
import e.b;
import v9.h;
import v9.i;

public class MelonTvOriginalFragment extends MelonTvProgramBaseFragment {
    private static final int PAGE_SIZE = 20;
    private static final int START_INDEX = 1;
    private static final String TAG = "MelonTvOriginalFragment";
    private b activityResult;

    public MelonTvOriginalFragment() {
        this.activityResult = this.registerForActivityResult(new f0(2), new a(23));
    }

    public static void f0(ActivityResult activityResult0) {
        MelonTvOriginalFragment.lambda$new$0(activityResult0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.f.buildUpon().appendPath("original").build().toString();
    }

    private int getStartIndex(i i0) {
        if(i.c.equals(i0)) {
            return this.mAdapter instanceof n8.i ? ((n8.i)this.mAdapter).getCount() + 1 : 1;
        }
        return 1;
    }

    private static void lambda$new$0(ActivityResult activityResult0) {
        if(activityResult0.a == -1) {
            Intent intent0 = activityResult0.b;
            if(intent0 != null) {
                String s = intent0.getStringExtra("argProgramSeqResult");
                if(!TextUtils.isEmpty(s)) {
                    Navigator.open(TvProgramHomeFragment.newInstance(s));
                }
            }
        }
    }

    public static MelonTvOriginalFragment newInstance() {
        return new MelonTvOriginalFragment();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        ParamInfo melonTvOriginalListReq$ParamInfo0 = new ParamInfo();
        melonTvOriginalListReq$ParamInfo0.startIndex = this.getStartIndex(i0);
        melonTvOriginalListReq$ParamInfo0.pageSize = 20;
        RequestBuilder.newInstance(new MelonTvOriginalListReq(this.getContext(), melonTvOriginalListReq$ParamInfo0)).tag("MelonTvOriginalFragment").listener(new Listener() {
            public void onResponse(MelonTvOriginalListRes melonTvOriginalListRes0) {
                if(!MelonTvOriginalFragment.this.prepareFetchComplete(melonTvOriginalListRes0)) {
                    return;
                }
                MelonTvOriginalFragment.this.performFetchComplete(i0, melonTvOriginalListRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MelonTvOriginalListRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.melontv.MelonTvProgramBaseFragment
    public void showDropDownView() {
        MelonTvOriginalListRes melonTvOriginalListRes0;
        j0 j00 = this.mAdapter;
        if(j00 instanceof p) {
            HttpResponse httpResponse0 = ((p)j00).getResponse();
            melonTvOriginalListRes0 = httpResponse0 instanceof MelonTvOriginalListRes ? ((MelonTvOriginalListRes)httpResponse0) : null;
        }
        else {
            melonTvOriginalListRes0 = null;
        }
        if(melonTvOriginalListRes0 != null && melonTvOriginalListRes0.response != null) {
            Intent intent0 = new Intent(this.getActivity(), ProgramSelectActivity.class);
            intent0.putExtra("argMenuSeq", "1");
            this.activityResult.b(intent0);
        }
    }
}

