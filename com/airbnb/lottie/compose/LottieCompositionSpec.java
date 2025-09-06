package com.airbnb.lottie.compose;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000B\f\r¨\u0006\u000E"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "", "Asset", "ContentProvider", "File", "JsonString", "RawRes", "Url", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$Asset;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$ContentProvider;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$File;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$JsonString;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec$Url;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public interface LottieCompositionSpec {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$Asset;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "assetName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getAssetName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Asset implements LottieCompositionSpec {
        @NotNull
        private final String assetName;

        private Asset(String s) {
            this.assetName = s;
        }

        public static final Asset box-impl(String s) {
            return new Asset(s);
        }

        @NotNull
        public static String constructor-impl(@NotNull String s) [...] // 潜在的解密器

        @Override
        public boolean equals(Object object0) {
            return Asset.equals-impl(this.assetName, object0);
        }

        // 去混淆评级： 低(20)
        public static boolean equals-impl(String s, Object object0) {
            return object0 instanceof Asset ? q.b(s, ((Asset)object0).unbox-impl()) : false;
        }

        public static final boolean equals-impl0(String s, String s1) {
            return q.b(s, s1);
        }

        @NotNull
        public final String getAssetName() {
            return this.assetName;
        }

        @Override
        public int hashCode() {
            return Asset.hashCode-impl(this.assetName);
        }

        public static int hashCode-impl(String s) {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return Asset.toString-impl(this.assetName);
        }

        public static String toString-impl(String s) {
            return "Asset(assetName=" + s + ")";
        }

        public final String unbox-impl() {
            return this.assetName;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0016"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$ContentProvider;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "uri", "Landroid/net/Uri;", "constructor-impl", "(Landroid/net/Uri;)Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "equals", "", "other", "", "equals-impl", "(Landroid/net/Uri;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroid/net/Uri;)I", "toString", "", "toString-impl", "(Landroid/net/Uri;)Ljava/lang/String;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class ContentProvider implements LottieCompositionSpec {
        @NotNull
        private final Uri uri;

        private ContentProvider(Uri uri0) {
            this.uri = uri0;
        }

        public static final ContentProvider box-impl(Uri uri0) {
            return new ContentProvider(uri0);
        }

        @NotNull
        public static Uri constructor-impl(@NotNull Uri uri0) {
            q.g(uri0, "uri");
            return uri0;
        }

        @Override
        public boolean equals(Object object0) {
            return ContentProvider.equals-impl(this.uri, object0);
        }

        // 去混淆评级： 低(20)
        public static boolean equals-impl(Uri uri0, Object object0) {
            return object0 instanceof ContentProvider ? q.b(uri0, ((ContentProvider)object0).unbox-impl()) : false;
        }

        public static final boolean equals-impl0(Uri uri0, Uri uri1) {
            return q.b(uri0, uri1);
        }

        @NotNull
        public final Uri getUri() {
            return this.uri;
        }

        @Override
        public int hashCode() {
            return ContentProvider.hashCode-impl(this.uri);
        }

        public static int hashCode-impl(Uri uri0) {
            return uri0.hashCode();
        }

        @Override
        public String toString() {
            return "ContentProvider(uri=" + this.uri + ")";
        }

        public static String toString-impl(Uri uri0) [...] // Inlined contents

        public final Uri unbox-impl() {
            return this.uri;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$File;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "fileName", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getFileName", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class File implements LottieCompositionSpec {
        @NotNull
        private final String fileName;

        private File(String s) {
            this.fileName = s;
        }

        public static final File box-impl(String s) {
            return new File(s);
        }

        @NotNull
        public static String constructor-impl(@NotNull String s) {
            q.g(s, "fileName");
            return s;
        }

        @Override
        public boolean equals(Object object0) {
            return File.equals-impl(this.fileName, object0);
        }

        // 去混淆评级： 低(20)
        public static boolean equals-impl(String s, Object object0) {
            return object0 instanceof File ? q.b(s, ((File)object0).unbox-impl()) : false;
        }

        public static final boolean equals-impl0(String s, String s1) {
            return q.b(s, s1);
        }

        @NotNull
        public final String getFileName() {
            return this.fileName;
        }

        @Override
        public int hashCode() {
            return File.hashCode-impl(this.fileName);
        }

        public static int hashCode-impl(String s) {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return File.toString-impl(this.fileName);
        }

        public static String toString-impl(String s) {
            return "File(fileName=" + s + ")";
        }

        public final String unbox-impl() {
            return this.fileName;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$JsonString;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "jsonString", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getJsonString", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class JsonString implements LottieCompositionSpec {
        @NotNull
        private final String jsonString;

        private JsonString(String s) {
            this.jsonString = s;
        }

        public static final JsonString box-impl(String s) {
            return new JsonString(s);
        }

        @NotNull
        public static String constructor-impl(@NotNull String s) {
            q.g(s, "jsonString");
            return s;
        }

        @Override
        public boolean equals(Object object0) {
            return JsonString.equals-impl(this.jsonString, object0);
        }

        // 去混淆评级： 低(20)
        public static boolean equals-impl(String s, Object object0) {
            return object0 instanceof JsonString ? q.b(s, ((JsonString)object0).unbox-impl()) : false;
        }

        public static final boolean equals-impl0(String s, String s1) {
            return q.b(s, s1);
        }

        @NotNull
        public final String getJsonString() {
            return this.jsonString;
        }

        @Override
        public int hashCode() {
            return JsonString.hashCode-impl(this.jsonString);
        }

        public static int hashCode-impl(String s) {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return JsonString.toString-impl(this.jsonString);
        }

        public static String toString-impl(String s) {
            return "JsonString(jsonString=" + s + ")";
        }

        public final String unbox-impl() {
            return this.jsonString;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0005J\u0010\u0010\u0010\u001A\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$RawRes;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "resId", "", "constructor-impl", "(I)I", "getResId", "()I", "equals", "", "other", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class RawRes implements LottieCompositionSpec {
        private final int resId;

        private RawRes(int v) {
            this.resId = v;
        }

        public static final RawRes box-impl(int v) {
            return new RawRes(v);
        }

        public static int constructor-impl(int v) [...] // Inlined contents

        @Override
        public boolean equals(Object object0) {
            return RawRes.equals-impl(this.resId, object0);
        }

        public static boolean equals-impl(int v, Object object0) {
            return object0 instanceof RawRes ? v == ((RawRes)object0).unbox-impl() : false;
        }

        public static final boolean equals-impl0(int v, int v1) {
            return v == v1;
        }

        public final int getResId() {
            return this.resId;
        }

        @Override
        public int hashCode() {
            return RawRes.hashCode-impl(this.resId);
        }

        public static int hashCode-impl(int v) {
            return v;
        }

        @Override
        public String toString() {
            return RawRes.toString-impl(this.resId);
        }

        public static String toString-impl(int v) {
            return "RawRes(resId=" + v + ")";
        }

        public final int unbox-impl() {
            return this.resId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087@\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u000BHÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001A\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec$Url;", "Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "url", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "equals", "", "other", "", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
    public static final class Url implements LottieCompositionSpec {
        @NotNull
        private final String url;

        private Url(String s) {
            this.url = s;
        }

        public static final Url box-impl(String s) {
            return new Url(s);
        }

        @NotNull
        public static String constructor-impl(@NotNull String s) {
            q.g(s, "url");
            return s;
        }

        @Override
        public boolean equals(Object object0) {
            return Url.equals-impl(this.url, object0);
        }

        // 去混淆评级： 低(20)
        public static boolean equals-impl(String s, Object object0) {
            return object0 instanceof Url ? q.b(s, ((Url)object0).unbox-impl()) : false;
        }

        public static final boolean equals-impl0(String s, String s1) {
            return q.b(s, s1);
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @Override
        public int hashCode() {
            return Url.hashCode-impl(this.url);
        }

        public static int hashCode-impl(String s) {
            return s.hashCode();
        }

        @Override
        public String toString() {
            return Url.toString-impl(this.url);
        }

        public static String toString-impl(String s) {
            return "Url(url=" + s + ")";
        }

        public final String unbox-impl() {
            return this.url;
        }
    }

}

