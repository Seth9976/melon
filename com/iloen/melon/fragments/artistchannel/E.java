package com.iloen.melon.fragments.artistchannel;

import a9.d;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.Response.Listener;
import java.util.List;

public final class e implements d, Listener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public e(TextView textView0, TextView textView1, ArtistPickItemFragment artistPickItemFragment0) {
        this.a = 4;
        super();
        this.b = textView0;
        this.c = textView1;
        this.d = artistPickItemFragment0;
    }

    public e(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.c = object0;
        this.b = object1;
        this.d = object2;
        super();
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        com.iloen.melon.fragments.artistchannel.ArtistPickItemFragment.requestUserActionCountApi.2.invokeSuspend$lambda$4$lambda$2(((TextView)this.b), ((TextView)this.c), ((ArtistPickItemFragment)this.d), object0);
    }

    @Override  // a9.d
    public void onSelected(int v) {
        switch(this.a) {
            case 0: {
                AlbumAdapter.onBindViewImpl$lambda$3$lambda$2(((ArtistDetailContentsAlbumFragment)this.c), ((TextView)this.b), ((AlbumAdapter)this.d), v);
                return;
            }
            case 1: {
                MagazineAdapter.onBindViewImpl$lambda$1$lambda$0(((ArtistDetailContentsMagazineFragment)this.c), ((TextView)this.b), ((MagazineAdapter)this.d), v);
                return;
            }
            case 2: {
                PhotoAdapter.onBindViewImpl$lambda$2$lambda$1(((ArtistDetailContentsPhotoFragment)this.c), ((TextView)this.b), ((PhotoAdapter)this.d), v);
                return;
            }
            case 3: {
                VideoAdapter.onBindViewImpl$lambda$3$lambda$2(((ArtistDetailContentsVideoFragment)this.c), ((TextView)this.b), ((VideoAdapter)this.d), v);
                return;
            }
            default: {
                ArtistDetailContentsSongFragment.makeAllSelectAndOrderButton$lambda$8$lambda$7$lambda$6(((List)this.c), ((ArtistDetailContentsSongFragment)this.b), ((FragmentActivity)this.d), v);
            }
        }
    }
}

