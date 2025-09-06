package androidx.core.widget;

public final class b implements Runnable {
    public final int a;
    public final ContentLoadingProgressBar b;

    public b(ContentLoadingProgressBar contentLoadingProgressBar0, int v) {
        this.a = v;
        this.b = contentLoadingProgressBar0;
        super();
    }

    @Override
    public final void run() {
        ContentLoadingProgressBar contentLoadingProgressBar0 = this.b;
        if(this.a != 0) {
            contentLoadingProgressBar0.getClass();
            contentLoadingProgressBar0.setVisibility(0);
            return;
        }
        contentLoadingProgressBar0.setVisibility(8);
    }
}

