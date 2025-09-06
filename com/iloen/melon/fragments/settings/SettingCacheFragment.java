package com.iloen.melon.fragments.settings;

import H0.e;
import Mc.q;
import Ob.b;
import Ob.d;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.custom.a1;
import com.iloen.melon.custom.b1;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.image.ImageCacheManager;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import i5.a;
import i5.n;
import java.io.File;
import kotlin.coroutines.Continuation;
import x8.f;

public class SettingCacheFragment extends SettingBaseFragment {
    class DeleteAsyncCoroutine extends f {
        int RETURN_FAIL;
        int RETURN_SUCCESS;

        private DeleteAsyncCoroutine() {
            this.RETURN_FAIL = -1;
            this.RETURN_SUCCESS = 0;
        }

        public DeleteAsyncCoroutine(int v) {
        }

        public Object backgroundWork(Integer integer0, Continuation continuation0) {
            SettingCacheFragment.mIsDeleting = true;
            if(integer0 == null) {
                return this.RETURN_FAIL;
            }
            int v = (int)integer0;
            if(v == 2) {
                Context context0 = MelonAppBase.instance.getContext();
                if(context0 == null) {
                    return this.RETURN_FAIL;
                }
                FileUtils.deleteSubFiles(u9.f.g.b(context0, "mcache").f, true);
                return this.RETURN_SUCCESS;
            }
            if(v == 1) {
                ImageCacheManager.INSTANCE.reset();
                return this.RETURN_SUCCESS;
            }
            switch(v) {
                case 3: {
                    Context context1 = MelonAppBase.instance.getContext();
                    if(context1 == null) {
                        return this.RETURN_FAIL;
                    }
                    u9.f f0 = u9.f.g.b(context1, "lyric");
                    u9.f f1 = u9.f.g.b(context1, "streamlyric");
                    FileUtils.deleteSubFiles(f0.f, false);
                    FileUtils.deleteSubFiles(f1.f, false);
                    return this.RETURN_SUCCESS;
                }
                case 0x270F: {
                    FileUtils.deleteSubFiles(FileUtils.getSafetyPath(FileUtils.getExoPlayerCacheDir(MelonAppBase.instance.getContext())), false);
                    return this.RETURN_SUCCESS;
                }
                default: {
                    return this.RETURN_SUCCESS;
                }
            }
        }

        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Integer)object0), continuation0);
        }

        public void postTask(Integer integer0) {
            super.postTask(integer0);
            SettingCacheFragment.this.showProgress(false);
            SettingCacheFragment.this.mBtnDeleteAlbumArtView.setClickable(true);
            SettingCacheFragment.this.mBtnDeleteMusicFileView.setClickable(true);
            SettingCacheFragment.this.mBtnDeleteLyricFileView.setClickable(true);
            SettingCacheFragment.mIsDeleting = false;
            if(SettingCacheFragment.this.isFragmentValid() && this.RETURN_SUCCESS == ((int)integer0)) {
                ToastManager.show(0x7F1302E7);  // string:delete_message "삭제되었습니다."
            }
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((Integer)object0));
        }

        @Override  // x8.f
        public void preTask() {
            super.preTask();
            SettingCacheFragment.mIsDeleting = true;
            SettingCacheFragment.this.showProgress(true);
            SettingCacheFragment.this.mBtnDeleteAlbumArtView.setClickable(false);
            SettingCacheFragment.this.mBtnDeleteMusicFileView.setClickable(false);
            SettingCacheFragment.this.mBtnDeleteLyricFileView.setClickable(false);
        }
    }

    private static final int DELETE_EXO_CACHE = 0x270F;
    private static final int DELETE_IMAGE_CACHE = 1;
    private static final int DELETE_LYRIC_FILE = 3;
    private static final int DELETE_STREAM_CACHE = 2;
    private static final String TAG = "SettingCacheFragment";
    private SettingItemView mAvailableStorageSizeView;
    private SettingItemView mBtnDeleteAlbumArtView;
    private SettingItemView mBtnDeleteExoVideoFileView;
    private SettingItemView mBtnDeleteLyricFileView;
    private SettingItemView mBtnDeleteMusicFileView;
    private RadioGroup mCacheStorageOption;
    private SettingItemView mCacheUseRadioView;
    private static boolean mIsDeleting = false;
    private SettingItemView mTotalStorageSizeView;

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsCacheStorage");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309DF;  // string:setting_title_cache "캐시 관리 및 용량 확인"
    }

    private void initPreferenceValue() {
        SettingItemView settingItemView0 = this.mCacheUseRadioView;
        if(settingItemView0 != null) {
            settingItemView0.setRadioOnOff(b.b());
        }
    }

    private void initUIClass() {
        SettingItemView settingItemView0 = (SettingItemView)this.findViewById(0x7F0A05A6);  // id:item_cache_setting_radio
        this.mCacheUseRadioView = settingItemView0;
        settingItemView0.setViewType(12);
        this.mCacheUseRadioView.setRadioBtnClickListener(new b1() {
            @Override  // com.iloen.melon.custom.b1
            public void onRadioBtnClick(boolean z) {
                ViewUtils.setEnable(SettingCacheFragment.this.mCacheStorageOption, z);
                b.d(z);
            }
        });
        b b0 = b.a;
        this.mCacheStorageOption = (RadioGroup)this.findViewById(0x7F0A09A3);  // id:radiogroup_cache_type
        if(!b.b()) {
            ViewUtils.setEnable(this.mCacheStorageOption, false);
        }
        d d0 = b.a();
        if(d0 == d.e) {
            this.mCacheStorageOption.a(0x7F0A0D5B);  // id:type_3gb_container
            this.setAccessibilityManagingCache(this.mCacheStorageOption, 0x7F0A0D5B);  // id:type_3gb_container
        }
        else if(d0 == d.f) {
            this.mCacheStorageOption.a(0x7F0A0D5D);  // id:type_5gb_container
            this.setAccessibilityManagingCache(this.mCacheStorageOption, 0x7F0A0D5D);  // id:type_5gb_container
        }
        else if(d0 == d.g) {
            this.mCacheStorageOption.a(0x7F0A0D57);  // id:type_10gb_container
            this.setAccessibilityManagingCache(this.mCacheStorageOption, 0x7F0A0D57);  // id:type_10gb_container
        }
        else {
            this.mCacheStorageOption.a(0x7F0A0D59);  // id:type_1gb_container
            this.setAccessibilityManagingCache(this.mCacheStorageOption, 0x7F0A0D59);  // id:type_1gb_container
        }
        this.mCacheStorageOption.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                d d0;
                switch(v) {
                    case 0x7F0A0D57: {  // id:type_10gb_container
                        d0 = d.g;
                        break;
                    }
                    case 0x7F0A0D5B: {  // id:type_3gb_container
                        d0 = d.e;
                        break;
                    }
                    case 0x7F0A0D5D: {  // id:type_5gb_container
                        d0 = d.f;
                        break;
                    }
                    default: {
                        d0 = d.d;
                    }
                }
                b0.getClass();
                LogU.info$default(b.b, "setCacheSize() value: " + d0, null, false, 6, null);
                b.d.getClass();
                MelonSettingInfo.setCacheStorageType(e.b0(d0));
                b.e(new q(d0, 10));
                SettingCacheFragment.this.setAccessibilityManagingCache(radioGroup0, v);
            }
        });
        SettingItemView settingItemView1 = (SettingItemView)this.findViewById(0x7F0A05AA);  // id:item_delete_cache_album_art
        this.mBtnDeleteAlbumArtView = settingItemView1;
        settingItemView1.setViewType(11);
        this.mBtnDeleteAlbumArtView.setButtonClickListener(new a1() {
            @Override  // com.iloen.melon.custom.a1
            public void onButtonClick() {
                Glide.get(SettingCacheFragment.this.getContext()).clearMemory();
                r5.b b0 = (r5.b)((n)a.a(SettingCacheFragment.this.getContext())).c.getValue();
                if(b0 != null) {
                    b0.a.clearMemory();
                    b0.b.clearMemory();
                }
                new DeleteAsyncCoroutine(SettingCacheFragment.this, 0).execute(1);
            }
        });
        SettingItemView settingItemView2 = (SettingItemView)this.findViewById(0x7F0A05AB);  // id:item_delete_cache_music_file
        this.mBtnDeleteMusicFileView = settingItemView2;
        settingItemView2.setViewType(11);
        this.mBtnDeleteMusicFileView.setButtonClickListener(new a1() {
            @Override  // com.iloen.melon.custom.a1
            public void onButtonClick() {
                new DeleteAsyncCoroutine(SettingCacheFragment.this, 0).execute(2);
            }
        });
        SettingItemView settingItemView3 = (SettingItemView)this.findViewById(0x7F0A05AD);  // id:item_delete_lyric
        this.mBtnDeleteLyricFileView = settingItemView3;
        settingItemView3.setViewType(11);
        this.mBtnDeleteLyricFileView.setButtonClickListener(new a1() {
            @Override  // com.iloen.melon.custom.a1
            public void onButtonClick() {
                new DeleteAsyncCoroutine(SettingCacheFragment.this, 0).execute(3);
            }
        });
        SettingItemView settingItemView4 = (SettingItemView)this.findViewById(0x7F0A05AC);  // id:item_delete_exo_cache_video_file
        this.mBtnDeleteExoVideoFileView = settingItemView4;
        ViewUtils.showWhen(settingItemView4, !A8.b.d());
        this.mBtnDeleteExoVideoFileView.setViewType(11);
        this.mBtnDeleteExoVideoFileView.setTextColor(0x7F06045C);  // color:red400s
        this.mBtnDeleteExoVideoFileView.setButtonClickListener(new a1() {
            @Override  // com.iloen.melon.custom.a1
            public void onButtonClick() {
                new DeleteAsyncCoroutine(SettingCacheFragment.this, 0).execute(0x270F);
            }
        });
        if(SettingCacheFragment.mIsDeleting) {
            this.mBtnDeleteAlbumArtView.setClickable(false);
            this.mBtnDeleteMusicFileView.setClickable(false);
        }
        else {
            this.mBtnDeleteAlbumArtView.setClickable(true);
            this.mBtnDeleteMusicFileView.setClickable(true);
        }
        SettingItemView settingItemView5 = (SettingItemView)this.findViewById(0x7F0A05CE);  // id:item_setting_total_device_storage
        this.mTotalStorageSizeView = settingItemView5;
        settingItemView5.setViewType(10);
        this.mTotalStorageSizeView.b();
        SettingItemView settingItemView6 = (SettingItemView)this.findViewById(0x7F0A05CD);  // id:item_setting_available_device_storage
        this.mAvailableStorageSizeView = settingItemView6;
        settingItemView6.setViewType(10);
        this.mAvailableStorageSizeView.b();
        this.updateDataStorage();
    }

    public static SettingCacheFragment newInstance() {
        return new SettingCacheFragment();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D0827, viewGroup0, false);  // layout:setting_cache
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        this.updateDataStorage();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initUIClass();
        this.initPreferenceValue();
    }

    private void setAccessibilityManagingCache(RadioGroup radioGroup0, int v) {
        this.setAccessibilityRadioGroup(radioGroup0, v, new String[]{this.getString(0x7F13096E), this.getString(0x7F13096F), this.getString(0x7F130970), this.getString(0x7F13096D)}, new int[]{0x7F0A0D59, 0x7F0A0D5B, 0x7F0A0D5D, 0x7F0A0D57});  // string:setting_cache_1gb "1 GB"
    }

    private void updateDataStorage() {
        long v3;
        SettingItemView settingItemView0 = this.mTotalStorageSizeView;
        if(this.mTotalStorageSizeView != null) {
            if(Environment.getExternalStorageState().equals("mounted")) {
                try {
                    File file0 = Environment.getExternalStorageDirectory();
                    StatFs statFs0 = new StatFs(file0.getPath());
                    long v = statFs0.getBlockSizeLong();
                    long v1 = statFs0.getBlockCountLong();
                    long v2 = statFs0.getAvailableBlocksLong();
                    LogU.v("DownloadUtils", "ExternalStorageDirectory::path = " + file0);
                    LogU.v("DownloadUtils", "blockSize: " + v);
                    LogU.v("DownloadUtils", "totalBlocks: " + v1);
                    v3 = v1 * v;
                    LogU.v("DownloadUtils", "totalBlockSize: " + v3);
                    LogU.v("DownloadUtils", "availableBlocks: " + v2);
                    LogU.v("DownloadUtils", "availableSize: " + v2 * v);
                    goto label_17;
                }
                catch(IllegalArgumentException unused_ex) {
                }
                goto label_16;
            }
            else {
            label_16:
                v3 = 0L;
            }
        label_17:
            settingItemView0.setSubText(O8.d.a(v3));
        }
        SettingItemView settingItemView1 = this.mAvailableStorageSizeView;
        if(settingItemView1 != null) {
            settingItemView1.setSubText(O8.d.a(O8.d.d()));
        }
    }
}

