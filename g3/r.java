package g3;

import h7.u0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

public class r extends g {
    public final int c;

    public r() {
        super(2008);
        this.c = 1;
    }

    public r(int v, int v1, IOException iOException0) {
        if(v == 2000 && v1 == 1) {
            v = 2001;
        }
        super(v, iOException0);
        this.c = v1;
    }

    public r(String s, IOException iOException0, int v) {
        if(v == 2000) {
            v = 2001;
        }
        super(v, iOException0, s);
        this.c = 1;
    }

    public static r a(int v, IOException iOException0) {
        int v1;
        String s = iOException0.getMessage();
        if(iOException0 instanceof SocketTimeoutException) {
            v1 = 2002;
        }
        else if(iOException0 instanceof InterruptedIOException) {
            v1 = 1004;
        }
        else {
            v1 = s == null || !u0.U(s).matches("cleartext.*not permitted.*") ? 2001 : 2007;
        }
        return v1 == 2007 ? new q("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException0, 2007) : new r(v1, v, iOException0);  // 初始化器: Lg3/r;-><init>(Ljava/lang/String;Ljava/io/IOException;I)V
    }
}

