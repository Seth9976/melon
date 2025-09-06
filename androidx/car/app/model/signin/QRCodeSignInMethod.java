package androidx.car.app.model.signin;

import android.net.Uri;
import java.util.Objects;
import w.c;

public final class QRCodeSignInMethod implements c {
    private final Uri mUri;

    private QRCodeSignInMethod() {
        this.mUri = null;
    }

    public QRCodeSignInMethod(Uri uri0) {
        Objects.requireNonNull(uri0);
        this.mUri = uri0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof QRCodeSignInMethod ? Objects.equals(this.mUri, ((QRCodeSignInMethod)object0).mUri) : false;
    }

    public Uri getUri() {
        Objects.requireNonNull(this.mUri);
        return this.mUri;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mUri});
    }
}

