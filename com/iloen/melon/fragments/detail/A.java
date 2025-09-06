package com.iloen.melon.fragments.detail;

import android.graphics.Bitmap;
import com.android.volley.Response.Listener;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.net.v4x.response.ArtistPlylstSongListRes;
import com.iloen.melon.net.v6x.response.AlbumArtistNoteListRes;
import com.iloen.melon.net.v6x.response.AlbumContentsPhotoRes;
import com.iloen.melon.net.v6x.response.AlbumDetailContentsOtherVerRes;
import com.iloen.melon.net.v6x.response.AlbumDetailContentsSeriesRes;
import com.iloen.melon.net.v6x.response.CleanIsBlackRes;
import com.iloen.melon.net.v6x.response.DetailContentsDJPlaylistRes;
import com.iloen.melon.net.v6x.response.DetailContentsMagazineRes;
import com.iloen.melon.net.v6x.response.DetailContentsMvRes;
import com.iloen.melon.net.v6x.response.DetailContentsStationRes;
import com.iloen.melon.net.v6x.response.MelonDjPlaylistListSongRes;
import com.iloen.melon.net.v6x.response.MyMusicPlaylistListSongRes;
import com.iloen.melon.net.v6x.response.PhotoInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.PlaylistListSongBaseRes;
import com.iloen.melon.net.v6x.response.SongContentsSimilarRes;
import com.iloen.melon.utils.template.TemplateImageLoader.CaptureStateListener;
import v9.i;
import zd.M;

public final class a implements Listener, CaptureStateListener {
    public final int a;
    public final Object b;
    public final Object c;

    public a(int v, Object object0, Object object1) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        super();
    }

    @Override  // com.iloen.melon.utils.template.TemplateImageLoader$CaptureStateListener
    public void onCaptureComplete(Bitmap bitmap0) {
        if(this.a != 9) {
            MixMakerPlaylistDetailFragment.drawHeaderView$lambda$15$lambda$10(((CoverView)this.c), ((MixMakerPlaylistDetailFragment)this.b), bitmap0);
            return;
        }
        MixMakerPlaylistBySongIdsDetailFragment.drawHeaderView$lambda$14$lambda$10(((CoverView)this.c), ((MixMakerPlaylistBySongIdsDetailFragment)this.b), bitmap0);
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        switch(this.a) {
            case 0: {
                AlbumDetailContentsArtistNoteFragment.onFetchStart$lambda$2(((AlbumDetailContentsArtistNoteFragment)this.c), ((i)this.b), ((AlbumArtistNoteListRes)object0));
                return;
            }
            case 1: {
                AlbumDetailContentsMagazineFragment.onFetchStart$lambda$3(((AlbumDetailContentsMagazineFragment)this.c), ((i)this.b), ((DetailContentsMagazineRes)object0));
                return;
            }
            case 2: {
                AlbumDetailContentsMvFragment.onFetchStart$lambda$3(((AlbumDetailContentsMvFragment)this.c), ((i)this.b), ((DetailContentsMvRes)object0));
                return;
            }
            case 3: {
                AlbumDetailContentsOtherVerFragment.onFetchStart$lambda$3(((AlbumDetailContentsOtherVerFragment)this.c), ((i)this.b), ((AlbumDetailContentsOtherVerRes)object0));
                return;
            }
            case 4: {
                AlbumDetailContentsPhotoFragment.onFetchStart$lambda$6(((AlbumDetailContentsPhotoFragment)this.c), ((i)this.b), ((AlbumContentsPhotoRes)object0));
                return;
            }
            case 5: {
                AlbumDetailContentsSeriesFragment.onFetchStart$lambda$3(((AlbumDetailContentsSeriesFragment)this.c), ((i)this.b), ((AlbumDetailContentsSeriesRes)object0));
                return;
            }
            case 6: {
                AlbumDetailContentsStationFragment.onFetchStart$lambda$3(((AlbumDetailContentsStationFragment)this.c), ((i)this.b), ((DetailContentsStationRes)object0));
                return;
            }
            case 7: {
                ArtistPlaylistDetailContentsAllSongFragment.onFetchStart$lambda$2(((ArtistPlaylistDetailContentsAllSongFragment)this.c), ((i)this.b), ((ArtistPlylstSongListRes)object0));
                return;
            }
            case 8: {
                DjPlaylistDetailContentsAllSongFragment.onFetchStart$lambda$2(((DjPlaylistDetailContentsAllSongFragment)this.c), ((i)this.b), ((MelonDjPlaylistListSongRes)object0));
                return;
            }
            case 11: {
                PhotoDetailViewFragment.executeSearchPhotoViewReq$lambda$29(((PhotoDetailViewFragment)this.c), ((RESPONSE)this.b), object0);
                return;
            }
            case 12: {
                PlaylistDetailBaseFragment.setTitleBar$lambda$6$lambda$4(((PlaylistDetailBaseFragment)this.c), ((String)this.b), ((CleanIsBlackRes)object0));
                return;
            }
            case 13: {
                PlaylistDetailBaseFragment.contextMenuCheckSongList$lambda$23(((PlaylistDetailBaseFragment)this.c), ((M)this.b), ((PlaylistListSongBaseRes)object0));
                return;
            }
            case 14: {
                PlaylistDetailContentsAllSongFragment.onFetchStart$lambda$2(((PlaylistDetailContentsAllSongFragment)this.c), ((i)this.b), ((MyMusicPlaylistListSongRes)object0));
                return;
            }
            case 15: {
                SongDetailContentsDjPlaylistFragment.onFetchStart$lambda$3(((SongDetailContentsDjPlaylistFragment)this.c), ((i)this.b), ((DetailContentsDJPlaylistRes)object0));
                return;
            }
            case 16: {
                SongDetailContentsMagazineFragment.onFetchStart$lambda$3(((SongDetailContentsMagazineFragment)this.c), ((i)this.b), ((DetailContentsMagazineRes)object0));
                return;
            }
            case 17: {
                SongDetailContentsMvFragment.onFetchStart$lambda$3(((SongDetailContentsMvFragment)this.c), ((i)this.b), ((DetailContentsMvRes)object0));
                return;
            }
            case 18: {
                SongDetailContentsSimilarFragment.onFetchStart$lambda$9(((SongDetailContentsSimilarFragment)this.c), ((i)this.b), ((SongContentsSimilarRes)object0));
                return;
            }
            default: {
                SongDetailContentsStationFragment.onFetchStart$lambda$3(((SongDetailContentsStationFragment)this.c), ((i)this.b), ((DetailContentsStationRes)object0));
            }
        }
    }
}

