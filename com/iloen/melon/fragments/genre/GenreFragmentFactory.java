package com.iloen.melon.fragments.genre;

import A7.d;
import Mc.B;
import Mc.I;
import Mc.L;
import Mc.m;
import Mc.v;
import android.os.Bundle;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.c0;
import kotlin.jvm.internal.q;

public class GenreFragmentFactory {
    private static final String TAG = "GenreFragmentFactory";

    public static c0 create(String s, String s1, String s2) {
        StringBuilder stringBuilder0 = d.o("create() - genreCode: ", s, ", genreName: ", s1, ", guiType: ");
        stringBuilder0.append(s2);
        LogU.d("GenreFragmentFactory", stringBuilder0.toString());
        if("2".equals(s2)) {
            q.g(s, "genreCode");
            q.g(s1, "menuName");
            c0 c00 = new v();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argGenreCode", s);
            c00.setArguments(bundle0);
            return c00;
        }
        if("3".equals(s2)) {
            q.g(s, "genreCode");
            q.g(s1, "menuName");
            c0 c01 = new B();
            Bundle bundle1 = new Bundle();
            bundle1.putString("argGenreCode", s);
            bundle1.putString("argMenuName", s1);
            c01.setArguments(bundle1);
            return c01;
        }
        if("4".equals(s2)) {
            q.g(s, "genreCode");
            q.g(s1, "menuName");
            c0 c02 = new I();
            Bundle bundle2 = new Bundle();
            bundle2.putString("argGenreCode", s);
            c02.setArguments(bundle2);
            return c02;
        }
        if("5".equals(s2)) {
            q.g(s, "genreCode");
            q.g(s1, "menuName");
            c0 c03 = new L();
            Bundle bundle3 = new Bundle();
            bundle3.putString("argGenreCode", s);
            c03.setArguments(bundle3);
            return c03;
        }
        q.g(s, "genreCode");
        q.g(s1, "menuName");
        c0 c04 = new m();
        Bundle bundle4 = new Bundle();
        bundle4.putString("argGenreCode", s);
        c04.setArguments(bundle4);
        return c04;
    }

    public static MelonBaseFragment createMore(String s, More_Fragment_Type genre$More_Fragment_Type0) {
        return GenreFragmentFactory.createMore(s, genre$More_Fragment_Type0, null, null, null, false);
    }

    public static MelonBaseFragment createMore(String s, More_Fragment_Type genre$More_Fragment_Type0, String s1, String s2, String s3, boolean z) {
        if(genre$More_Fragment_Type0 == More_Fragment_Type.GUI_MORE_ARTIST) {
            return GenreDetailMoreArtistFragment.Companion.newInstance(s, s1, s2, s3);
        }
        if(genre$More_Fragment_Type0 == More_Fragment_Type.GUI_MORE_NEW_SONG) {
            return GenreDetailMoreNewSongFragment.Companion.newInstance(s, z);
        }
        return genre$More_Fragment_Type0 == More_Fragment_Type.GUI_MORE_PLAYLIST ? GenreDetailMorePlaylistFragment.Companion.newInstance(s) : GenreDetailMoreIntroFragment.Companion.newInstance(s);
    }
}

