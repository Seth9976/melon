package com.iloen.melon.fragments.genre;

import android.view.View.OnLongClickListener;
import android.view.View;
import com.iloen.melon.net.v5x.response.GenreMoreMasterpieceRes.RESPONSE.ALBUMLIST;

public final class o implements View.OnLongClickListener {
    public final int a;
    public final GenreDetailMoreMasterPieceFragment b;
    public final ALBUMLIST c;
    public final GenreMasterpieceAdapter d;

    public o(GenreDetailMoreMasterPieceFragment genreDetailMoreMasterPieceFragment0, ALBUMLIST genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0, GenreMasterpieceAdapter genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0, int v) {
        this.a = v;
        this.b = genreDetailMoreMasterPieceFragment0;
        this.c = genreMoreMasterpieceRes$RESPONSE$ALBUMLIST0;
        this.d = genreDetailMoreMasterPieceFragment$GenreMasterpieceAdapter0;
        super();
    }

    @Override  // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view0) {
        return this.a == 0 ? GenreMasterpieceAdapter.onBindViewImpl$lambda$2(this.b, this.c, this.d, view0) : GenreMasterpieceAdapter.onBindViewImpl$lambda$3(this.b, this.c, this.d, view0);
    }
}

