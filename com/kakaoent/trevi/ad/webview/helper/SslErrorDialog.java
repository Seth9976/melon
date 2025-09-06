package com.kakaoent.trevi.ad.webview.helper;

import T9.b;
import T9.c;
import T9.d;
import T9.f;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslCertificate.DName;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.app.g;
import com.kakaoent.trevi.ad.R.drawable;
import com.kakaoent.trevi.ad.R.id;
import com.kakaoent.trevi.ad.R.layout;
import com.kakaoent.trevi.ad.R.string;
import com.kakaoent.trevi.ad.util.TreviLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009C\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0004\b\u00C0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003JA\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u0017\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J?\u0010\u0019\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b\u0019\u0010\u0012J)\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\u001C2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0002\u00A2\u0006\u0004\b\u001F\u0010 J\'\u0010&\u001A\u00020\u00102\u0006\u0010\"\u001A\u00020!2\u0006\u0010$\u001A\u00020#2\u0006\u0010\u000B\u001A\u00020%H\u0002\u00A2\u0006\u0004\b&\u0010\'J!\u0010*\u001A\u00020\u00152\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010)\u001A\u0004\u0018\u00010(H\u0002\u00A2\u0006\u0004\b*\u0010+J\u0019\u0010.\u001A\u00020\u00152\b\u0010-\u001A\u0004\u0018\u00010,H\u0002\u00A2\u0006\u0004\b.\u0010/J!\u00101\u001A\u00020\u00152\b\u0010-\u001A\u0004\u0018\u00010,2\u0006\u00100\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b1\u00102J\u0019\u00105\u001A\u00020\u00152\b\u00104\u001A\u0004\u0018\u000103H\u0002\u00A2\u0006\u0004\b5\u00106J\'\u0010<\u001A\u0002072\u0006\u00108\u001A\u0002072\u0006\u0010:\u001A\u0002092\u0006\u0010;\u001A\u00020\u0013H\u0002\u00A2\u0006\u0004\b<\u0010=JE\u0010>\u001A\u00020\u00102\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b2\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b>\u0010\u0012R\u0014\u0010@\u001A\u00020?8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001A\u00020?8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bB\u0010A\u00A8\u0006C"}, d2 = {"Lcom/kakaoent/trevi/ad/webview/helper/SslErrorDialog;", "", "<init>", "()V", "Landroid/app/Activity;", "activity", "Landroid/webkit/WebView;", "view", "Landroid/webkit/SslErrorHandler;", "handler", "Landroid/net/http/SslError;", "error", "Landroid/webkit/WebViewClient;", "webViewClient", "Landroid/webkit/WebChromeClient;", "webChromeClient", "Lie/H;", "showSSLCertificateOnError", "(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;Landroid/webkit/WebViewClient;Landroid/webkit/WebChromeClient;)V", "", "fromShowSSLCertificateOnError", "", "urlCertificateOnError", "showPageInfo", "(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;Landroid/webkit/WebViewClient;Landroid/webkit/WebChromeClient;ZLjava/lang/String;)V", "showSSLCertificate", "Landroid/content/Context;", "context", "Landroid/net/http/SslCertificate;", "certificate", "Landroidx/appcompat/app/AlertDialog$Builder;", "createSslCertificateDialog", "(Landroid/content/Context;Landroid/net/http/SslCertificate;Landroid/net/http/SslError;)Landroidx/appcompat/app/AlertDialog$Builder;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/widget/LinearLayout;", "parent", "", "addError", "(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;I)V", "Ljava/util/Date;", "certificateDate", "formatCertificateDate", "(Landroid/content/Context;Ljava/util/Date;)Ljava/lang/String;", "Ljava/security/cert/X509Certificate;", "x509Certificate", "getSerialNumber", "(Ljava/security/cert/X509Certificate;)Ljava/lang/String;", "algorithm", "getDigest", "(Ljava/security/cert/X509Certificate;Ljava/lang/String;)Ljava/lang/String;", "", "bytes", "fingerprint", "([B)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "sb", "", "b", "upperCase", "appendByteAsHex", "(Ljava/lang/StringBuilder;BZ)Ljava/lang/StringBuilder;", "onReceivedSslError", "", "DIGITS", "[C", "UPPER_CASE_DIGITS", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class SslErrorDialog {
    @NotNull
    private static final char[] DIGITS;
    @NotNull
    public static final SslErrorDialog INSTANCE;
    @NotNull
    private static final char[] UPPER_CASE_DIGITS;

    static {
        SslErrorDialog.INSTANCE = new SslErrorDialog();
        SslErrorDialog.DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        SslErrorDialog.UPPER_CASE_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    public static void a(boolean z, Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        SslErrorDialog.showPageInfo$lambda$5(z, activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, dialogInterface0, v);
    }

    private final void addError(LayoutInflater layoutInflater0, LinearLayout linearLayout0, int v) {
        View view0 = layoutInflater0.inflate(R.layout.trevi_webview_ssl_warning, linearLayout0, false);
        q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view0).setText(v);
        linearLayout0.addView(((TextView)view0));
    }

    private final StringBuilder appendByteAsHex(StringBuilder stringBuilder0, byte b, boolean z) {
        stringBuilder0.append((z ? SslErrorDialog.UPPER_CASE_DIGITS : SslErrorDialog.DIGITS)[b >> 4 & 15]);
        stringBuilder0.append((z ? SslErrorDialog.UPPER_CASE_DIGITS : SslErrorDialog.DIGITS)[b & 15]);
        return stringBuilder0;
    }

    // 检测为 Lambda 实现
    public static void b(boolean z, Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0) [...]

    public static void c(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        SslErrorDialog.showSSLCertificate$lambda$8(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, dialogInterface0, v);
    }

    private final AlertDialog.Builder createSslCertificateDialog(Context context0, SslCertificate sslCertificate0, SslError sslError0) {
        int v;
        ByteArrayInputStream byteArrayInputStream1;
        LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
        ByteArrayInputStream byteArrayInputStream0 = null;
        View view0 = layoutInflater0.inflate(R.layout.trevi_webview_ssl_certificate, null);
        q.f(view0, "inflate(...)");
        DName sslCertificate$DName0 = sslCertificate0.getIssuedTo();
        if(sslCertificate$DName0 != null) {
            View view1 = view0.findViewById(R.id.to_common);
            q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view1).setText(sslCertificate$DName0.getCName());
            View view2 = view0.findViewById(R.id.to_org);
            q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view2).setText(sslCertificate$DName0.getOName());
            View view3 = view0.findViewById(R.id.to_org_unit);
            q.e(view3, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view3).setText(sslCertificate$DName0.getUName());
        }
        DName sslCertificate$DName1 = sslCertificate0.getIssuedBy();
        if(sslCertificate$DName1 != null) {
            View view4 = view0.findViewById(R.id.by_common);
            q.e(view4, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view4).setText(sslCertificate$DName1.getCName());
            View view5 = view0.findViewById(R.id.by_org);
            q.e(view5, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view5).setText(sslCertificate$DName1.getOName());
            View view6 = view0.findViewById(R.id.by_org_unit);
            q.e(view6, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view6).setText(sslCertificate$DName1.getUName());
        }
        String s = this.formatCertificateDate(context0, sslCertificate0.getValidNotBeforeDate());
        View view7 = view0.findViewById(R.id.issued_on);
        q.e(view7, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view7).setText(s);
        String s1 = this.formatCertificateDate(context0, sslCertificate0.getValidNotAfterDate());
        View view8 = view0.findViewById(R.id.expires_on);
        q.e(view8, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view8).setText(s1);
        try {
            Bundle bundle0 = SslCertificate.saveState(sslCertificate0);
            if(bundle0 == null) {
                goto label_75;
            }
            else {
                byteArrayInputStream1 = new ByteArrayInputStream(bundle0.getByteArray("x509-certificate"));
                goto label_42;
            }
            goto label_80;
        }
        catch(CertificateException certificateException0) {
            goto label_58;
        }
        catch(NullPointerException nullPointerException0) {
            goto label_64;
            try {
            label_42:
                Certificate certificate0 = CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream1);
                q.e(certificate0, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                View view9 = view0.findViewById(R.id.serial_number);
                q.e(view9, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView)view9).setText(this.getSerialNumber(((X509Certificate)certificate0)));
                View view10 = view0.findViewById(R.id.sha256_fingerprint);
                q.e(view10, "null cannot be cast to non-null type android.widget.TextView");
                ((TextView)view10).setText(this.getDigest(((X509Certificate)certificate0), "SHA256"));
                View view11 = view0.findViewById(R.id.sha1_fingerprint);
                q.e(view11, "null cannot be cast to non-null type android.widget.TextView");
                byteArrayInputStream0 = byteArrayInputStream1;
                ((TextView)view11).setText(this.getDigest(((X509Certificate)certificate0), "SHA1"));
                byteArrayInputStream0 = byteArrayInputStream1;
                goto label_75;
            }
            catch(CertificateException certificateException0) {
            }
            catch(NullPointerException nullPointerException0) {
                goto label_63;
            }
            catch(Throwable throwable0) {
                goto label_69;
            }
            byteArrayInputStream0 = byteArrayInputStream1;
            try {
            label_58:
                TreviLog.INSTANCE.e("SslError", "", certificateException0);
                if(byteArrayInputStream0 != null) {
                    goto label_60;
                }
                goto label_80;
            }
            catch(Throwable throwable0) {
                goto label_69;
            }
            try {
            label_60:
                byteArrayInputStream0.close();
                goto label_80;
            }
            catch(IOException iOException0) {
                goto label_79;
            }
        label_63:
            byteArrayInputStream0 = byteArrayInputStream1;
            try {
            label_64:
                TreviLog.INSTANCE.e("SslError", "", nullPointerException0);
                if(byteArrayInputStream0 != null) {
                    goto label_66;
                }
                goto label_80;
            }
            catch(Throwable throwable0) {
                goto label_69;
            }
            try {
            label_66:
                byteArrayInputStream0.close();
                goto label_80;
            }
            catch(IOException iOException0) {
                goto label_79;
            }
        }
        catch(Throwable throwable0) {
        label_69:
            if(byteArrayInputStream0 != null) {
                try {
                    byteArrayInputStream0.close();
                }
                catch(IOException iOException1) {
                    TreviLog.INSTANCE.e("SslError", "", iOException1);
                }
            }
            throw throwable0;
        }
    label_75:
        if(byteArrayInputStream0 != null) {
            try {
                byteArrayInputStream0.close();
            }
            catch(IOException iOException0) {
            label_79:
                TreviLog.INSTANCE.e("SslError", "", iOException0);
            }
        }
    label_80:
        View view12 = view0.findViewById(R.id.placeholder);
        q.e(view12, "null cannot be cast to non-null type android.widget.LinearLayout");
        if(sslError0 == null) {
            v = R.drawable.ic_trevi_dialog_browser_certificate_secure;
            View view13 = layoutInflater0.inflate(R.layout.trevi_webview_ssl_success, ((LinearLayout)view12));
            q.e(view13, "null cannot be cast to non-null type android.widget.LinearLayout");
            View view14 = ((LinearLayout)view13).findViewById(R.id.id_success);
            q.e(view14, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view14).setText(R.string.trevi_ssl_certificate_is_valid);
        }
        else {
            if(sslError0.hasError(3)) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_untrusted);
            }
            if(sslError0.hasError(2)) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_mismatch);
            }
            if(sslError0.hasError(1)) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_expired);
            }
            if(sslError0.hasError(0)) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_not_yet_valid);
            }
            if(sslError0.hasError(4)) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_date_invalid);
            }
            if(sslError0.hasError(5)) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_invalid);
            }
            if(((LinearLayout)view12).getChildCount() == 0) {
                this.addError(layoutInflater0, ((LinearLayout)view12), R.string.trevi_ssl_unknown);
            }
            v = 0x7F0805ED;  // drawable:ic_trevi_dialog_browser_certificate_partially_secure
        }
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(context0);
        alertDialog$Builder0.a.e = alertDialog$Builder0.a.a.getText(R.string.trevi_ssl_certificate);
        alertDialog$Builder0.a.c = v;
        alertDialog$Builder0.a.s = view0;
        return alertDialog$Builder0;
    }

    public static void d(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        SslErrorDialog.onReceivedSslError$lambda$0(sslErrorHandler0, activity0, webView0, sslError0, webViewClient0, webChromeClient0, dialogInterface0, v);
    }

    // 检测为 Lambda 实现
    public static void e(SslErrorHandler sslErrorHandler0, WebView webView0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0) [...]

    // 检测为 Lambda 实现
    public static void f(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0) [...]

    private final String fingerprint(byte[] arr_b) {
        if(arr_b == null) {
            return "";
        }
        StringBuilder stringBuilder0 = new StringBuilder();
        int v = 0;
        while(v < arr_b.length) {
            this.appendByteAsHex(stringBuilder0, arr_b[v], true);
            ++v;
            if(v != arr_b.length) {
                stringBuilder0.append(':');
            }
        }
        String s = stringBuilder0.toString();
        q.f(s, "toString(...)");
        return s;
    }

    private final String formatCertificateDate(Context context0, Date date0) {
        if(date0 == null) {
            return "";
        }
        String s = DateFormat.getDateFormat(context0).format(date0);
        q.f(s, "format(...)");
        return s;
    }

    // 检测为 Lambda 实现
    public static void g(WebViewClient webViewClient0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, DialogInterface dialogInterface0) [...]

    private final String getDigest(X509Certificate x509Certificate0, String s) {
        if(x509Certificate0 == null) {
            return "";
        }
        try {
            byte[] arr_b = x509Certificate0.getEncoded();
            return this.fingerprint(MessageDigest.getInstance(s).digest(arr_b));
        }
        catch(CertificateEncodingException | NoSuchAlgorithmException unused_ex) {
            return "";
        }
    }

    private final String getSerialNumber(X509Certificate x509Certificate0) {
        if(x509Certificate0 == null) {
            return "";
        }
        BigInteger bigInteger0 = x509Certificate0.getSerialNumber();
        return bigInteger0 == null ? "" : this.fingerprint(bigInteger0.toByteArray());
    }

    public static void h(boolean z, Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        SslErrorDialog.showPageInfo$lambda$7(z, activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, dialogInterface0, v);
    }

    public static void i(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        SslErrorDialog.showSSLCertificateOnError$lambda$3(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, dialogInterface0, v);
    }

    public static void j(WebViewClient webViewClient0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, DialogInterface dialogInterface0, int v) {
        SslErrorDialog.showSSLCertificateOnError$lambda$2(webViewClient0, webView0, sslErrorHandler0, sslError0, dialogInterface0, v);
    }

    public final void onReceivedSslError(@Nullable Activity activity0, @NotNull WebView webView0, @Nullable SslErrorHandler sslErrorHandler0, @Nullable SslError sslError0, @NotNull WebViewClient webViewClient0, @Nullable WebChromeClient webChromeClient0) {
        q.g(webView0, "view");
        q.g(webViewClient0, "webViewClient");
        if(activity0 == null || sslErrorHandler0 == null || webChromeClient0 == null) {
            return;
        }
        b b0 = new b(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0);
        c c0 = (DialogInterface dialogInterface0) -> SslErrorDialog.onReceivedSslError$lambda$1(sslErrorHandler0, webView0, webChromeClient0, dialogInterface0);
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(activity0);
        alertDialog$Builder0.a.e = alertDialog$Builder0.a.a.getText(R.string.trevi_security_warning);
        alertDialog$Builder0.a.g = alertDialog$Builder0.a.a.getText(R.string.trevi_ssl_warnings_header);
        alertDialog$Builder0.a.c = 0x1080027;
        alertDialog$Builder0.d(R.string.trevi_ssl_continue, b0);
        alertDialog$Builder0.b(R.string.trevi_view_certificate, b0);
        alertDialog$Builder0.a.j = alertDialog$Builder0.a.a.getText(R.string.trevi_ssl_go_back);
        alertDialog$Builder0.a.k = b0;
        alertDialog$Builder0.a.o = c0;
        g g0 = alertDialog$Builder0.a();
        g0.setCanceledOnTouchOutside(false);
        g0.show();
    }

    private static final void onReceivedSslError$lambda$0(SslErrorHandler sslErrorHandler0, Activity activity0, WebView webView0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        q.g(webView0, "$view");
        q.g(webViewClient0, "$webViewClient");
        switch(v) {
            case -3: {
                SslErrorDialog.INSTANCE.showSSLCertificateOnError(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0);
                return;
            }
            case -2: {
                sslErrorHandler0.cancel();
                if(webView0.canGoBack()) {
                    webView0.goBack();
                    return;
                }
                webChromeClient0.onCloseWindow(webView0);
                return;
            }
            case -1: {
                sslErrorHandler0.proceed();
            }
        }
    }

    private static final void onReceivedSslError$lambda$1(SslErrorHandler sslErrorHandler0, WebView webView0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0) {
        q.g(webView0, "$view");
        sslErrorHandler0.cancel();
        if(webView0.canGoBack()) {
            webView0.goBack();
            return;
        }
        webChromeClient0.onCloseWindow(webView0);
    }

    private final void showPageInfo(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, boolean z, String s) {
        if(webView0 != null && webView0.getParent() != null) {
            View view0 = LayoutInflater.from(activity0).inflate(R.layout.trevi_webview_page_info, null);
            q.f(view0, "inflate(...)");
            String s1 = z ? s : webView0.getUrl();
            String s2 = webView0.getTitle();
            View view1 = view0.findViewById(0x1020014);
            q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view1).setText(s2);
            View view2 = view0.findViewById(0x1020015);
            q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView)view2).setText(s1);
            AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(activity0);
            alertDialog$Builder0.a.e = alertDialog$Builder0.a.a.getText(R.string.trevi_page_info);
            alertDialog$Builder0.a.c = 0x108009B;
            alertDialog$Builder0.a.s = view0;
            f f0 = new f(z, activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, 0);
            alertDialog$Builder0.d(R.string.trevi_webview_ok, f0);
            alertDialog$Builder0.a.o = (DialogInterface dialogInterface0) -> SslErrorDialog.showPageInfo$lambda$6(z, activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, dialogInterface0);
            if(z || webView0.getCertificate() != null) {
                f f1 = new f(z, activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, 1);
                alertDialog$Builder0.b(R.string.trevi_view_certificate, f1);
            }
            g g0 = alertDialog$Builder0.a();
            g0.setCanceledOnTouchOutside(false);
            g0.show();
        }
    }

    private static final void showPageInfo$lambda$5(boolean z, Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        q.g(activity0, "$activity");
        q.g(sslErrorHandler0, "$handler");
        q.g(sslError0, "$error");
        q.g(webViewClient0, "$webViewClient");
        q.g(webChromeClient0, "$webChromeClient");
        if(z) {
            SslErrorDialog.INSTANCE.showSSLCertificateOnError(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0);
        }
    }

    private static final void showPageInfo$lambda$6(boolean z, Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0) {
        q.g(activity0, "$activity");
        q.g(sslErrorHandler0, "$handler");
        q.g(sslError0, "$error");
        q.g(webViewClient0, "$webViewClient");
        q.g(webChromeClient0, "$webChromeClient");
        if(z) {
            SslErrorDialog.INSTANCE.showSSLCertificateOnError(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0);
        }
    }

    private static final void showPageInfo$lambda$7(boolean z, Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        q.g(activity0, "$activity");
        q.g(sslErrorHandler0, "$handler");
        q.g(sslError0, "$error");
        q.g(webViewClient0, "$webViewClient");
        q.g(webChromeClient0, "$webChromeClient");
        if(z) {
            SslErrorDialog.INSTANCE.showSSLCertificateOnError(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0);
            return;
        }
        SslErrorDialog.INSTANCE.showSSLCertificate(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0);
    }

    private final void showSSLCertificate(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0) {
        SslCertificate sslCertificate0 = webView0.getCertificate();
        if(sslCertificate0 == null) {
            return;
        }
        AlertDialog.Builder alertDialog$Builder0 = this.createSslCertificateDialog(activity0, sslCertificate0, sslError0);
        b b0 = new b(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, 2);
        alertDialog$Builder0.d(R.string.trevi_webview_ok, b0);
        alertDialog$Builder0.c((DialogInterface dialogInterface0) -> SslErrorDialog.showSSLCertificate$lambda$9(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, dialogInterface0));
        g g0 = alertDialog$Builder0.a();
        g0.setCanceledOnTouchOutside(false);
        g0.show();
    }

    private static final void showSSLCertificate$lambda$8(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        q.g(activity0, "$activity");
        q.g(webView0, "$view");
        q.g(sslErrorHandler0, "$handler");
        q.g(sslError0, "$error");
        q.g(webViewClient0, "$webViewClient");
        q.g(webChromeClient0, "$webChromeClient");
        SslErrorDialog.INSTANCE.showPageInfo(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, false, null);
    }

    private static final void showSSLCertificate$lambda$9(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0) {
        q.g(activity0, "$activity");
        q.g(webView0, "$view");
        q.g(sslErrorHandler0, "$handler");
        q.g(sslError0, "$error");
        q.g(webViewClient0, "$webViewClient");
        q.g(webChromeClient0, "$webChromeClient");
        SslErrorDialog.INSTANCE.showPageInfo(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, false, null);
    }

    private final void showSSLCertificateOnError(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0) {
        if(sslError0 != null) {
            SslCertificate sslCertificate0 = sslError0.getCertificate();
            if(sslCertificate0 != null) {
                AlertDialog.Builder alertDialog$Builder0 = this.createSslCertificateDialog(activity0, sslCertificate0, sslError0);
                d d0 = new d(webViewClient0, webView0, sslErrorHandler0, sslError0);
                alertDialog$Builder0.d(R.string.trevi_webview_ok, d0);
                b b0 = new b(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, 1);
                alertDialog$Builder0.b(R.string.trevi_page_info_view, b0);
                alertDialog$Builder0.c((DialogInterface dialogInterface0) -> SslErrorDialog.showSSLCertificateOnError$lambda$4(webViewClient0, webView0, sslErrorHandler0, sslError0, dialogInterface0));
                g g0 = alertDialog$Builder0.a();
                g0.setCanceledOnTouchOutside(false);
                g0.show();
            }
        }
    }

    private static final void showSSLCertificateOnError$lambda$2(WebViewClient webViewClient0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, DialogInterface dialogInterface0, int v) {
        q.g(webViewClient0, "$webViewClient");
        q.g(webView0, "$view");
        q.g(sslErrorHandler0, "$handler");
        webViewClient0.onReceivedSslError(webView0, sslErrorHandler0, sslError0);
    }

    private static final void showSSLCertificateOnError$lambda$3(Activity activity0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, WebViewClient webViewClient0, WebChromeClient webChromeClient0, DialogInterface dialogInterface0, int v) {
        q.g(activity0, "$activity");
        q.g(webView0, "$view");
        q.g(sslErrorHandler0, "$handler");
        q.g(webViewClient0, "$webViewClient");
        q.g(webChromeClient0, "$webChromeClient");
        String s = sslError0.getUrl();
        SslErrorDialog.INSTANCE.showPageInfo(activity0, webView0, sslErrorHandler0, sslError0, webViewClient0, webChromeClient0, true, s);
    }

    private static final void showSSLCertificateOnError$lambda$4(WebViewClient webViewClient0, WebView webView0, SslErrorHandler sslErrorHandler0, SslError sslError0, DialogInterface dialogInterface0) {
        q.g(webViewClient0, "$webViewClient");
        q.g(webView0, "$view");
        q.g(sslErrorHandler0, "$handler");
        webViewClient0.onReceivedSslError(webView0, sslErrorHandler0, sslError0);
    }
}

