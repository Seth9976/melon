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
import com.iloen.melon.net.v4x.request.MelonTvBroadcastListReq.ParamInfo;
import com.iloen.melon.net.v4x.request.MelonTvBroadcastListReq;
import com.iloen.melon.net.v4x.response.MelonTvBroadcastListRes;
import com.iloen.melon.utils.Navigator;
import e.b;
import v9.h;
import v9.i;

public class MelonTvBroadcastFragment extends MelonTvProgramBaseFragment {
    private static final int PAGE_SIZE = 20;
    private static final int START_INDEX = 1;
    private static final String TAG = "MelonTvBroadcastFragment";
    private b activityResult;

    public MelonTvBroadcastFragment() {
        this.activityResult = this.registerForActivityResult(new f0(2), new a(22));
    }

    public static void f0(ActivityResult activityResult0) {
        MelonTvBroadcastFragment.lambda$new$0(activityResult0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    public String getCacheKey() {
        return MelonContentUris.f.buildUpon().appendPath("broadcast").build().toString();
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

    public static MelonTvBroadcastFragment newInstance() {
        return new MelonTvBroadcastFragment();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(i i0, h h0, String s) {
        ParamInfo melonTvBroadcastListReq$ParamInfo0 = new ParamInfo();
        melonTvBroadcastListReq$ParamInfo0.pageSize = 20;
        melonTvBroadcastListReq$ParamInfo0.startIndex = this.getStartIndex(i0);
        RequestBuilder.newInstance(new MelonTvBroadcastListReq(this.getContext(), melonTvBroadcastListReq$ParamInfo0)).tag("MelonTvBroadcastFragment").listener(new Listener() {
            public void onResponse(MelonTvBroadcastListRes melonTvBroadcastListRes0) {
                if(!MelonTvBroadcastFragment.this.prepareFetchComplete(melonTvBroadcastListRes0)) {
                    return;
                }
                MelonTvBroadcastFragment.this.performFetchComplete(i0, melonTvBroadcastListRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((MelonTvBroadcastListRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.melontv.MelonTvProgramBaseFragment
    public void showDropDownView() {
        MelonTvBroadcastListRes melonTvBroadcastListRes0;
        j0 j00 = this.mAdapter;
        if(j00 instanceof p) {
            HttpResponse httpResponse0 = ((p)j00).getResponse();
            melonTvBroadcastListRes0 = httpResponse0 instanceof MelonTvBroadcastListRes ? ((MelonTvBroadcastListRes)httpResponse0) : null;
        }
        else {
            melonTvBroadcastListRes0 = null;
        }
        if(melonTvBroadcastListRes0 != null && melonTvBroadcastListRes0.response != null) {
            Intent intent0 = new Intent(this.getActivity(), ProgramSelectActivity.class);
            intent0.putExtra("argMenuSeq", "3");
            this.activityResult.b(intent0);
        }
    }
}

