package y2;

import U4.x;
import android.content.res.AssetManager.AssetInputStream;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import df.v;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

public final class g {
    public static final byte[] A;
    public static final byte[] B;
    public static final byte[] C;
    public static final byte[] D;
    public static final String[] E;
    public static final int[] F;
    public static final byte[] G;
    public static final d H;
    public static final d[][] I;
    public static final d[] J;
    public static final HashMap[] K;
    public static final HashMap[] L;
    public static final Set M;
    public static final HashMap N;
    public static final Charset O;
    public static final byte[] P;
    public static final byte[] Q;
    public final FileDescriptor a;
    public final AssetManager.AssetInputStream b;
    public int c;
    public final HashMap[] d;
    public final HashSet e;
    public ByteOrder f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public int k;
    public c l;
    public static final boolean m;
    public static final List n;
    public static final List o;
    public static final int[] p;
    public static final int[] q;
    public static final byte[] r;
    public static final byte[] s;
    public static final byte[] t;
    public static final byte[] u;
    public static final byte[] v;
    public static final byte[] w;
    public static final byte[] x;
    public static final byte[] y;
    public static final byte[] z;

    static {
        g.m = Log.isLoggable("ExifInterface", 3);
        g.n = Arrays.asList(new Integer[]{1, 6, 3, 8});
        g.o = Arrays.asList(new Integer[]{2, 7, 4, 5});
        g.p = new int[]{8, 8, 8};
        g.q = new int[]{8};
        g.r = new byte[]{-1, -40, -1};
        g.s = new byte[]{102, 0x74, 0x79, 0x70};
        g.t = new byte[]{109, 105, 102, 49};
        g.u = new byte[]{104, 101, 105, 99};
        g.v = new byte[]{97, 0x76, 105, 102};
        g.w = new byte[]{97, 0x76, 105, 0x73};
        g.x = new byte[]{0x4F, 76, 89, 77, 80, 0};
        g.y = new byte[]{0x4F, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        g.z = new byte[]{(byte)0x89, 80, 78, 71, 13, 10, 26, 10};
        g.A = "XML:com.adobe.xmp\u0000\u0000\u0000\u0000\u0000".getBytes(StandardCharsets.UTF_8);
        g.B = new byte[]{82, 73, 70, 70};
        g.C = new byte[]{87, 69, 66, 80};
        g.D = new byte[]{69, 88, 73, 70};
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        g.E = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
        g.F = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        g.G = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        d[] arr_d = {new d("NewSubfileType", 0xFE, 4), new d("SubfileType", 0xFF, 4), new d(0x100, 3, 4, "ImageWidth"), new d(0x101, 3, 4, "ImageLength"), new d("BitsPerSample", 0x102, 3), new d("Compression", 0x103, 3), new d("PhotometricInterpretation", 0x106, 3), new d("ImageDescription", 270, 2), new d("Make", 0x10F, 2), new d("Model", 0x110, 2), new d(273, 3, 4, "StripOffsets"), new d("Orientation", 274, 3), new d("SamplesPerPixel", 277, 3), new d(278, 3, 4, "RowsPerStrip"), new d(279, 3, 4, "StripByteCounts"), new d("XResolution", 282, 5), new d("YResolution", 283, 5), new d("PlanarConfiguration", 284, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 0x13F, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 0x201, 4), new d("JPEGInterchangeFormatLength", 0x202, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 0x8298, 2), new d("ExifIFDPointer", 0x8769, 4), new d("GPSInfoIFDPointer", 0x8825, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        d d0 = new d("ExposureTime", 0x829A, 5);
        d d1 = new d("FNumber", 0x829D, 5);
        d d2 = new d("ExposureProgram", 34850, 3);
        d d3 = new d("SpectralSensitivity", 0x8824, 2);
        d d4 = new d("PhotographicSensitivity", 0x8827, 3);
        d d5 = new d("OECF", 0x8828, 7);
        d d6 = new d("SensitivityType", 0x8830, 3);
        d d7 = new d("StandardOutputSensitivity", 0x8831, 4);
        d d8 = new d("RecommendedExposureIndex", 0x8832, 4);
        d d9 = new d("ISOSpeed", 0x8833, 4);
        d d10 = new d("ISOSpeedLatitudeyyy", 0x8834, 4);
        d d11 = new d("ISOSpeedLatitudezzz", 0x8835, 4);
        d d12 = new d("ExifVersion", 0x9000, 2);
        d d13 = new d("DateTimeOriginal", 0x9003, 2);
        d d14 = new d("DateTimeDigitized", 0x9004, 2);
        d d15 = new d("OffsetTime", 0x9010, 2);
        d d16 = new d("OffsetTimeOriginal", 0x9011, 2);
        d d17 = new d("OffsetTimeDigitized", 0x9012, 2);
        d d18 = new d("ComponentsConfiguration", 0x9101, 7);
        d d19 = new d("CompressedBitsPerPixel", 0x9102, 5);
        d d20 = new d("ShutterSpeedValue", 0x9201, 10);
        d d21 = new d("ApertureValue", 0x9202, 5);
        d d22 = new d("BrightnessValue", 0x9203, 10);
        d d23 = new d("ExposureBiasValue", 0x9204, 10);
        d d24 = new d("MaxApertureValue", 0x9205, 5);
        d d25 = new d("SubjectDistance", 0x9206, 5);
        d d26 = new d("MeteringMode", 0x9207, 3);
        d d27 = new d("LightSource", 0x9208, 3);
        d d28 = new d("Flash", 0x9209, 3);
        d d29 = new d("FocalLength", 0x920A, 5);
        d d30 = new d("SubjectArea", 0x9214, 3);
        d d31 = new d("MakerNote", 37500, 7);
        d d32 = new d("UserComment", 37510, 7);
        d d33 = new d("SubSecTime", 0x9290, 2);
        d d34 = new d("SubSecTimeOriginal", 0x9291, 2);
        d d35 = new d("SubSecTimeDigitized", 0x9292, 2);
        d d36 = new d("FlashpixVersion", 0xA000, 7);
        d d37 = new d("ColorSpace", 0xA001, 3);
        d d38 = new d(0xA002, 3, 4, "PixelXDimension");
        d d39 = new d(0xA003, 3, 4, "PixelYDimension");
        d d40 = new d("RelatedSoundFile", 0xA004, 2);
        d d41 = new d("InteroperabilityIFDPointer", 0xA005, 4);
        d d42 = new d("FlashEnergy", 0xA20B, 5);
        d d43 = new d("SpatialFrequencyResponse", 0xA20C, 7);
        d d44 = new d("FocalPlaneXResolution", 0xA20E, 5);
        d d45 = new d("FocalPlaneYResolution", 0xA20F, 5);
        d d46 = new d("FocalPlaneResolutionUnit", 0xA210, 3);
        d d47 = new d("SubjectLocation", 0xA214, 3);
        d d48 = new d("ExposureIndex", 0xA215, 5);
        d d49 = new d("SensingMethod", 0xA217, 3);
        d d50 = new d("FileSource", 0xA300, 7);
        d d51 = new d("SceneType", 0xA301, 7);
        d d52 = new d("CFAPattern", 0xA302, 7);
        d d53 = new d("CustomRendered", 0xA401, 3);
        d d54 = new d("ExposureMode", 0xA402, 3);
        d d55 = new d("WhiteBalance", 0xA403, 3);
        d d56 = new d("DigitalZoomRatio", 0xA404, 5);
        d d57 = new d("FocalLengthIn35mmFilm", 0xA405, 3);
        d d58 = new d("SceneCaptureType", 0xA406, 3);
        d d59 = new d("GainControl", 0xA407, 3);
        d d60 = new d("Contrast", 0xA408, 3);
        d d61 = new d("Saturation", 0xA409, 3);
        d d62 = new d("Sharpness", 0xA40A, 3);
        d d63 = new d("DeviceSettingDescription", 0xA40B, 7);
        d d64 = new d("SubjectDistanceRange", 0xA40C, 3);
        d d65 = new d("ImageUniqueID", 0xA420, 2);
        d d66 = new d("CameraOwnerName", 0xA430, 2);
        d d67 = new d("BodySerialNumber", 42033, 2);
        d d68 = new d("LensSpecification", 42034, 5);
        d d69 = new d("LensMake", 42035, 2);
        d d70 = new d("LensModel", 42036, 2);
        d d71 = new d("Gamma", 0xA500, 5);
        d d72 = new d("DNGVersion", 50706, 1);
        d d73 = new d(50720, 3, 4, "DefaultCropSize");
        d d74 = new d("GPSVersionID", 0, 1);
        d d75 = new d("GPSLatitudeRef", 1, 2);
        d d76 = new d(2, 5, 10, "GPSLatitude");
        d d77 = new d("GPSLongitudeRef", 3, 2);
        d d78 = new d(4, 5, 10, "GPSLongitude");
        d d79 = new d("GPSAltitudeRef", 5, 1);
        d d80 = new d("GPSAltitude", 6, 5);
        d d81 = new d("GPSTimeStamp", 7, 5);
        d d82 = new d("GPSSatellites", 8, 2);
        d d83 = new d("GPSStatus", 9, 2);
        d d84 = new d("GPSMeasureMode", 10, 2);
        d d85 = new d("GPSDOP", 11, 5);
        d d86 = new d("GPSSpeedRef", 12, 2);
        d d87 = new d("GPSSpeed", 13, 5);
        d d88 = new d("GPSTrackRef", 14, 2);
        d d89 = new d("GPSTrack", 15, 5);
        d d90 = new d("GPSImgDirectionRef", 16, 2);
        d d91 = new d("GPSImgDirection", 17, 5);
        d d92 = new d("GPSMapDatum", 18, 2);
        d d93 = new d("GPSDestLatitudeRef", 19, 2);
        d d94 = new d("GPSDestLatitude", 20, 5);
        d d95 = new d("GPSDestLongitudeRef", 21, 2);
        d d96 = new d("GPSDestLongitude", 22, 5);
        d d97 = new d("GPSDestBearingRef", 23, 2);
        d d98 = new d("GPSDestBearing", 24, 5);
        d d99 = new d("GPSDestDistanceRef", 25, 2);
        d d100 = new d("GPSDestDistance", 26, 5);
        d d101 = new d("GPSProcessingMethod", 27, 7);
        d d102 = new d("GPSAreaInformation", 28, 7);
        d d103 = new d("GPSDateStamp", 29, 2);
        d d104 = new d("GPSDifferential", 30, 3);
        d d105 = new d("GPSHPositioningError", 0x1F, 5);
        d d106 = new d("InteroperabilityIndex", 1, 2);
        d d107 = new d("NewSubfileType", 0xFE, 4);
        d d108 = new d("SubfileType", 0xFF, 4);
        d d109 = new d(0x100, 3, 4, "ThumbnailImageWidth");
        d d110 = new d(0x101, 3, 4, "ThumbnailImageLength");
        d d111 = new d("BitsPerSample", 0x102, 3);
        d d112 = new d("Compression", 0x103, 3);
        d d113 = new d("PhotometricInterpretation", 0x106, 3);
        d d114 = new d("ImageDescription", 270, 2);
        d d115 = new d("Make", 0x10F, 2);
        d d116 = new d("Model", 0x110, 2);
        d d117 = new d(273, 3, 4, "StripOffsets");
        d d118 = new d("ThumbnailOrientation", 274, 3);
        d d119 = new d("SamplesPerPixel", 277, 3);
        d d120 = new d(278, 3, 4, "RowsPerStrip");
        d d121 = new d(279, 3, 4, "StripByteCounts");
        d d122 = new d("XResolution", 282, 5);
        d d123 = new d("YResolution", 283, 5);
        d d124 = new d("PlanarConfiguration", 284, 3);
        d d125 = new d("ResolutionUnit", 296, 3);
        d d126 = new d("TransferFunction", 301, 3);
        d d127 = new d("Software", 305, 2);
        d d128 = new d("DateTime", 306, 2);
        d d129 = new d("Artist", 315, 2);
        d d130 = new d("WhitePoint", 318, 5);
        d d131 = new d("PrimaryChromaticities", 0x13F, 5);
        d d132 = new d("SubIFDPointer", 330, 4);
        d d133 = new d("JPEGInterchangeFormat", 0x201, 4);
        d d134 = new d("JPEGInterchangeFormatLength", 0x202, 4);
        d d135 = new d("YCbCrCoefficients", 529, 5);
        d d136 = new d("YCbCrSubSampling", 530, 3);
        d d137 = new d("YCbCrPositioning", 531, 3);
        d d138 = new d("ReferenceBlackWhite", 532, 5);
        d d139 = new d("Copyright", 0x8298, 2);
        d d140 = new d("ExifIFDPointer", 0x8769, 4);
        d d141 = new d("GPSInfoIFDPointer", 0x8825, 4);
        d d142 = new d("DNGVersion", 50706, 1);
        d d143 = new d(50720, 3, 4, "DefaultCropSize");
        g.H = new d("StripOffsets", 273, 3);
        d d144 = new d("ThumbnailImage", 0x100, 7);
        d d145 = new d("CameraSettingsIFDPointer", 0x2020, 4);
        d d146 = new d("ImageProcessingIFDPointer", 0x2040, 4);
        d d147 = new d("PreviewImageStart", 0x101, 4);
        d d148 = new d("PreviewImageLength", 0x102, 4);
        d d149 = new d("AspectFrame", 4371, 3);
        d d150 = new d("ColorSpace", 55, 3);
        g.I = new d[][]{arr_d, new d[]{d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15, d16, d17, d18, d19, d20, d21, d22, d23, d24, d25, d26, d27, d28, d29, d30, d31, d32, d33, d34, d35, d36, d37, d38, d39, d40, d41, d42, d43, d44, d45, d46, d47, d48, d49, d50, d51, d52, d53, d54, d55, d56, d57, d58, d59, d60, d61, d62, d63, d64, d65, d66, d67, d68, d69, d70, d71, d72, d73}, new d[]{d74, d75, d76, d77, d78, d79, d80, d81, d82, d83, d84, d85, d86, d87, d88, d89, d90, d91, d92, d93, d94, d95, d96, d97, d98, d99, d100, d101, d102, d103, d104, d105}, new d[]{d106}, new d[]{d107, d108, d109, d110, d111, d112, d113, d114, d115, d116, d117, d118, d119, d120, d121, d122, d123, d124, d125, d126, d127, d128, d129, d130, d131, d132, d133, d134, d135, d136, d137, d138, d139, d140, d141, d142, d143}, arr_d, new d[]{d144, d145, d146}, new d[]{d147, d148}, new d[]{d149}, new d[]{d150}};
        g.J = new d[]{new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 0x8769, 4), new d("GPSInfoIFDPointer", 0x8825, 4), new d("InteroperabilityIFDPointer", 0xA005, 4), new d("CameraSettingsIFDPointer", 0x2020, 1), new d("ImageProcessingIFDPointer", 0x2040, 1)};
        g.K = new HashMap[10];
        g.L = new HashMap[10];
        g.M = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance"})));
        g.N = new HashMap();
        Charset charset0 = Charset.forName("US-ASCII");
        g.O = charset0;
        g.P = "Exif\u0000\u0000".getBytes(charset0);
        g.Q = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charset0);
        Locale locale0 = Locale.US;
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale0).setTimeZone(TimeZone.getTimeZone("UTC"));
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale0).setTimeZone(TimeZone.getTimeZone("UTC"));
        for(int v = 0; true; ++v) {
            d[][] arr2_d = g.I;
            if(v >= arr2_d.length) {
                break;
            }
            g.K[v] = new HashMap();
            g.L[v] = new HashMap();
            d[] arr_d1 = arr2_d[v];
            for(int v1 = 0; v1 < arr_d1.length; ++v1) {
                d d151 = arr_d1[v1];
                g.K[v].put(d151.a, d151);
                g.L[v].put(d151.b, d151);
            }
        }
        g.N.put(g.J[0].a, 5);
        g.N.put(g.J[1].a, 1);
        g.N.put(g.J[2].a, 2);
        g.N.put(g.J[3].a, 3);
        g.N.put(g.J[4].a, 7);
        g.N.put(g.J[5].a, 8);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
        Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
        Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
    }

    public g(InputStream inputStream0) {
        b b0;
        d[][] arr2_d = g.I;
        this.d = new HashMap[arr2_d.length];
        this.e = new HashSet(arr2_d.length);
        this.f = ByteOrder.BIG_ENDIAN;
        if(inputStream0 == null) {
            throw new NullPointerException("inputStream cannot be null");
        }
        boolean z = g.m;
        if(inputStream0 instanceof AssetManager.AssetInputStream) {
            this.b = (AssetManager.AssetInputStream)inputStream0;
            this.a = null;
        }
        else if(inputStream0 instanceof FileInputStream) {
            FileDescriptor fileDescriptor0 = ((FileInputStream)inputStream0).getFD();
            try {
                Os.lseek(fileDescriptor0, 0L, OsConstants.SEEK_CUR);
            }
            catch(Exception unused_ex) {
                if(z) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
                this.b = null;
                this.a = null;
                goto label_25;
            }
            this.b = null;
            this.a = ((FileInputStream)inputStream0).getFD();
        }
        else {
            this.b = null;
            this.a = null;
        }
    label_25:
        try {
            for(int v = 0; v < arr2_d.length; ++v) {
                this.d[v] = new HashMap();
            }
            BufferedInputStream bufferedInputStream0 = new BufferedInputStream(inputStream0, 5000);
            int v1 = this.g(bufferedInputStream0);
            this.c = v1;
            if(v1 == 4 || v1 == 9 || v1 == 13 || v1 == 14) {
                b0 = new b(bufferedInputStream0);
                int v3 = this.c;
                switch(v3) {
                    case 4: {
                        goto label_53;
                    }
                    case 9: {
                        goto label_55;
                    }
                    case 13: {
                        goto label_57;
                    }
                }
            }
            else {
                f f0 = new f(bufferedInputStream0);
                int v2 = this.c;
                switch(v2) {
                    case 7: {
                        this.h(f0);
                        break;
                    }
                    case 10: {
                        this.m(f0);
                        break;
                    }
                    case 12: 
                    case 15: {
                        this.e(f0, v2);
                        break;
                    }
                    default: {
                        this.k(f0);
                    }
                }
                f0.f(((long)this.h));
                this.w(f0);
            }
            goto label_71;
        }
        catch(IOException | UnsupportedOperationException iOException0) {
            goto label_62;
        }
        catch(Throwable throwable0) {
            goto label_67;
        }
        if(v3 == 14) {
            try {
                try {
                    this.n(b0);
                    goto label_71;
                label_53:
                    this.f(b0, 0, 0);
                    goto label_71;
                label_55:
                    this.j(b0);
                    goto label_71;
                label_57:
                    this.i(b0);
                    goto label_71;
                label_62:
                    if(z) {
                        goto label_63;
                    }
                    goto label_64;
                }
                catch(IOException | UnsupportedOperationException iOException0) {
                    goto label_62;
                }
            label_63:
                Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file (ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", iOException0);
            }
            catch(Throwable throwable0) {
                goto label_67;
            }
        label_64:
            this.a();
            if(z) {
                this.r();
                return;
            }
            return;
        label_67:
            this.a();
            if(z) {
                this.r();
            }
            throw throwable0;
        }
    label_71:
        this.a();
        if(z) {
            this.r();
        }
    }

    public final void a() {
        String s = this.b("DateTimeOriginal");
        HashMap[] arr_hashMap = this.d;
        if(s != null && this.b("DateTime") == null) {
            HashMap hashMap0 = arr_hashMap[0];
            byte[] arr_b = (s + "\u0000").getBytes(g.O);
            hashMap0.put("DateTime", new c(arr_b, 2, arr_b.length));
        }
        if(this.b("ImageWidth") == null) {
            arr_hashMap[0].put("ImageWidth", c.a(0L, this.f));
        }
        if(this.b("ImageLength") == null) {
            arr_hashMap[0].put("ImageLength", c.a(0L, this.f));
        }
        if(this.b("Orientation") == null) {
            arr_hashMap[0].put("Orientation", c.a(0L, this.f));
        }
        if(this.b("LightSource") == null) {
            arr_hashMap[1].put("LightSource", c.a(0L, this.f));
        }
    }

    public final String b(String s) {
        c c0 = this.d(s);
        if(c0 != null) {
            int v = c0.a;
            if(s.equals("GPSTimeStamp")) {
                if(v != 5 && v != 10) {
                    x.u(v, "GPS Timestamp format is not rational. format=", "ExifInterface");
                    return null;
                }
                e[] arr_e = (e[])c0.g(this.f);
                if(arr_e != null && arr_e.length == 3) {
                    return String.format("%02d:%02d:%02d", ((int)(((float)arr_e[0].a) / ((float)arr_e[0].b))), ((int)(((float)arr_e[1].a) / ((float)arr_e[1].b))), ((int)(((float)arr_e[2].a) / ((float)arr_e[2].b))));
                }
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(arr_e));
                return null;
            }
            if(g.M.contains(s)) {
                try {
                    return Double.toString(c0.d(this.f));
                }
                catch(NumberFormatException unused_ex) {
                    return null;
                }
            }
            return c0.f(this.f);
        }
        return null;
    }

    public final int c() {
        c c0 = this.d("Orientation");
        if(c0 != null) {
            try {
                return c0.e(this.f);
            }
            catch(NumberFormatException unused_ex) {
            }
        }
        return 1;
    }

    public final c d(String s) {
        if("ISOSpeedRatings".equals(s)) {
            if(g.m) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            s = "PhotographicSensitivity";
        }
        if("Xmp".equals(s) && (this.c == 9 || this.c == 12 || this.c == 13 || this.c == 15)) {
            c c0 = this.l;
            if(c0 != null) {
                return c0;
            }
        }
        for(int v = 0; v < g.I.length; ++v) {
            c c1 = (c)this.d[v].get(s);
            if(c1 != null) {
                return c1;
            }
        }
        if("Xmp".equals(s)) {
            return this.l == null ? null : this.l;
        }
        return null;
    }

    public final void e(f f0, int v) {
        RuntimeException runtimeException1;
        Throwable throwable1;
        int v2;
        String s6;
        String s5;
        String s4;
        int v1 = Build.VERSION.SDK_INT;
        if(v1 < 28) {
            throw new UnsupportedOperationException("Reading EXIF from HEIC files is supported from SDK 28 and above");
        }
        if(v == 15 && v1 < 0x1F) {
            throw new UnsupportedOperationException("Reading EXIF from AVIF files is supported from SDK 31 and above");
        }
        MediaMetadataRetriever mediaMetadataRetriever0 = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever0.setDataSource(new a(f0));
                String s = mediaMetadataRetriever0.extractMetadata(33);
                String s1 = mediaMetadataRetriever0.extractMetadata(34);
                String s2 = mediaMetadataRetriever0.extractMetadata(26);
                String s3 = mediaMetadataRetriever0.extractMetadata(17);
                if("yes".equals(s2)) {
                    s4 = mediaMetadataRetriever0.extractMetadata(29);
                    s5 = mediaMetadataRetriever0.extractMetadata(30);
                    s6 = mediaMetadataRetriever0.extractMetadata(0x1F);
                }
                else if("yes".equals(s3)) {
                    s4 = mediaMetadataRetriever0.extractMetadata(18);
                    s5 = mediaMetadataRetriever0.extractMetadata(19);
                    s6 = mediaMetadataRetriever0.extractMetadata(24);
                }
                else {
                    s4 = null;
                    s6 = null;
                    s5 = null;
                }
                HashMap[] arr_hashMap = this.d;
                if(s4 != null) {
                    arr_hashMap[0].put("ImageWidth", c.c(Integer.parseInt(s4), this.f));
                }
                if(s5 != null) {
                    arr_hashMap[0].put("ImageLength", c.c(Integer.parseInt(s5), this.f));
                }
                if(s6 != null) {
                    switch(Integer.parseInt(s6)) {
                        case 90: {
                            v2 = 6;
                            break;
                        }
                        case 180: {
                            v2 = 3;
                            break;
                        }
                        case 270: {
                            v2 = 8;
                            break;
                        }
                        default: {
                            v2 = 1;
                        }
                    }
                    arr_hashMap[0].put("Orientation", c.c(v2, this.f));
                }
                if(s != null && s1 != null) {
                    int v3 = Integer.parseInt(s);
                    int v4 = Integer.parseInt(s1);
                    if(v4 <= 6) {
                        throw new IOException("Invalid exif length");
                    }
                    f0.f(((long)v3));
                    byte[] arr_b = new byte[6];
                    f0.readFully(arr_b);
                    if(!Arrays.equals(arr_b, g.P)) {
                        throw new IOException("Invalid identifier");
                    }
                    byte[] arr_b1 = new byte[v4 - 6];
                    f0.readFully(arr_b1);
                    this.h = v3 + 6;
                    this.t(0, arr_b1);
                }
                String s7 = mediaMetadataRetriever0.extractMetadata(41);
                String s8 = mediaMetadataRetriever0.extractMetadata(42);
                if(s7 != null && s8 != null) {
                    int v5 = Integer.parseInt(s7);
                    int v6 = Integer.parseInt(s8);
                    f0.f(((long)v5));
                    byte[] arr_b2 = new byte[v6];
                    f0.readFully(arr_b2);
                    this.l = new c(((long)v5), arr_b2, 1, v6);
                }
                if(g.m) {
                    Log.d("ExifInterface", "Heif meta: " + s4 + "x" + s5 + ", rotation " + s6);
                }
                goto label_72;
            }
            catch(RuntimeException runtimeException0) {
                runtimeException1 = runtimeException0;
                throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", runtimeException1);
            }
            throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.", runtimeException1);
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
        }
        try {
            mediaMetadataRetriever0.release();
        }
        catch(IOException unused_ex) {
        }
        throw throwable1;
        try {
        label_72:
            mediaMetadataRetriever0.release();
        }
        catch(IOException unused_ex) {
        }
    }

    public final void f(b b0, int v, int v1) {
        boolean z = g.m;
        if(z) {
            Log.d("ExifInterface", "getJpegAttributes starting with: " + b0);
        }
        b0.c = ByteOrder.BIG_ENDIAN;
        int v2 = b0.readByte();
        if(v2 != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(v2 & 0xFF));
        }
        if(b0.readByte() != -40) {
            throw new IOException("Invalid marker: ff");
        }
        for(int v3 = 2; true; v3 = v8 + v7) {
            int v4 = b0.readByte();
            if(v4 != -1) {
                throw new IOException("Invalid marker:" + Integer.toHexString(v4 & 0xFF));
            }
            int v5 = b0.readByte();
            if(z) {
                Log.d("ExifInterface", "Found JPEG segment indicator: " + Integer.toHexString(v5 & 0xFF));
            }
            if(v5 == -39 || v5 == -38) {
                b0.c = this.f;
                return;
            }
            int v6 = b0.readUnsignedShort();
            int v7 = v6 - 2;
            int v8 = v3 + 4;
            if(z) {
                Log.d("ExifInterface", "JPEG segment: " + Integer.toHexString(v5 & 0xFF) + " (length: " + v6 + ")");
            }
            if(v7 < 0) {
                throw new IOException("Invalid length");
            }
            if(v5 == 0xFFFFFFE1) {
                byte[] arr_b2 = new byte[v7];
                b0.readFully(arr_b2);
                byte[] arr_b3 = g.P;
                if(v.J(arr_b2, arr_b3)) {
                    byte[] arr_b4 = Arrays.copyOfRange(arr_b2, arr_b3.length, v7);
                    this.h = v + v8 + arr_b3.length;
                    this.t(v1, arr_b4);
                    this.w(new b(arr_b4));
                }
                else {
                    byte[] arr_b5 = g.Q;
                    if(v.J(arr_b2, arr_b5)) {
                        byte[] arr_b6 = Arrays.copyOfRange(arr_b2, arr_b5.length, v7);
                        this.l = new c(((long)(v8 + arr_b5.length)), arr_b6, 1, arr_b6.length);
                    }
                }
                v8 += v7;
                v7 = 0;
            }
            else {
                HashMap[] arr_hashMap = this.d;
                if(v5 == -2) {
                    byte[] arr_b = new byte[v7];
                    b0.readFully(arr_b);
                    if(this.b("UserComment") == null) {
                        HashMap hashMap0 = arr_hashMap[1];
                        byte[] arr_b1 = (new String(arr_b, g.O) + "\u0000").getBytes(g.O);
                        hashMap0.put("UserComment", new c(arr_b1, 2, arr_b1.length));
                    }
                    v7 = 0;
                }
                else if(v5 == 0xFFFFFFC0 || v5 == 0xFFFFFFC1 || v5 == -62 || v5 == -61 || (v5 == -59 || v5 == -58 || v5 == -57) || (v5 == -55 || v5 == -54 || v5 == -53) || (v5 == -51 || v5 == -50 || v5 == -49)) {
                    b0.c(1);
                    arr_hashMap[v1].put((v1 == 4 ? "ThumbnailImageLength" : "ImageLength"), c.a(b0.readUnsignedShort(), this.f));
                    arr_hashMap[v1].put((v1 == 4 ? "ThumbnailImageWidth" : "ImageWidth"), c.a(b0.readUnsignedShort(), this.f));
                    v7 = v6 - 7;
                }
            }
            if(v7 < 0) {
                break;
            }
            b0.c(v7);
        }
        throw new IOException("Invalid length");
    }

    public final int g(BufferedInputStream bufferedInputStream0) {
        boolean z4;
        b b6;
        b b5;
        b b4;
        boolean z3;
        int v7;
        b b2;
        long v6;
        long v3;
        long v2;
        b b0;
        bufferedInputStream0.mark(5000);
        byte[] arr_b = new byte[5000];
        bufferedInputStream0.read(arr_b);
        bufferedInputStream0.reset();
        int v = 0;
        while(true) {
            byte[] arr_b1 = g.r;
            if(v >= arr_b1.length) {
                break;
            }
            if(arr_b[v] != arr_b1[v]) {
                byte[] arr_b2 = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                int v1 = 0;
                while(v1 < arr_b2.length) {
                    if(arr_b[v1] != arr_b2[v1]) {
                        try {
                            b0 = null;
                            b0 = new b(arr_b);
                            goto label_18;
                        }
                        catch(Exception exception0) {
                            goto label_52;
                        }
                        catch(Throwable throwable0) {
                        }
                        b b1 = null;
                        goto label_58;
                        try {
                        label_18:
                            v2 = (long)b0.readInt();
                            byte[] arr_b3 = new byte[4];
                            b0.readFully(arr_b3);
                            if(!Arrays.equals(arr_b3, g.s)) {
                                goto label_75;
                            }
                            else if(Long.compare(v2, 1L) == 0) {
                                v3 = 16L;
                                v2 = b0.readLong();
                                if(v2 < 16L) {
                                    goto label_26;
                                }
                                else {
                                    goto label_30;
                                }
                            }
                            else {
                                goto label_29;
                            }
                            goto label_77;
                        }
                        catch(Exception exception0) {
                            goto label_52;
                        }
                        catch(Throwable throwable0) {
                            goto label_57;
                        }
                    label_26:
                        b0.close();
                        int v4 = 0;
                        goto label_77;
                    label_29:
                        v3 = 8L;
                    label_30:
                        if(v2 > 5000L) {
                            v2 = 5000L;
                        }
                        long v5 = v2 - v3;
                        if(v5 >= 8L) {
                            try {
                                byte[] arr_b4 = new byte[4];
                                v6 = 0L;
                                boolean z = false;
                                boolean z1 = false;
                                boolean z2 = false;
                                while(true) {
                                label_39:
                                    if(v6 >= v5 / 4L) {
                                        goto label_72;
                                    }
                                    try {
                                        b0.readFully(arr_b4);
                                        if(v6 != 1L) {
                                            goto label_42;
                                        }
                                        ++v6;
                                        continue;
                                    }
                                    catch(EOFException unused_ex) {
                                        goto label_72;
                                    }
                                label_42:
                                    if(Arrays.equals(arr_b4, g.t)) {
                                        try {
                                            try {
                                                z = true;
                                            }
                                            catch(Exception exception0) {
                                            label_52:
                                                if(g.m) {
                                                    Log.d("ExifInterface", "Exception parsing HEIF file type box.", exception0);
                                                }
                                                if(b0 == null) {
                                                    v4 = 0;
                                                    goto label_77;
                                                }
                                                goto label_72;
                                            }
                                        }
                                        catch(Throwable throwable0) {
                                            goto label_57;
                                        }
                                    }
                                    else if(Arrays.equals(arr_b4, g.u)) {
                                        z1 = true;
                                    }
                                    else if(Arrays.equals(arr_b4, g.v) || Arrays.equals(arr_b4, g.w)) {
                                        z2 = true;
                                    }
                                    goto label_61;
                                }
                            }
                            catch(Exception exception0) {
                                goto label_52;
                            }
                            catch(Throwable throwable0) {
                            label_57:
                                b1 = b0;
                            }
                        label_58:
                            if(b1 != null) {
                                b1.close();
                            }
                            throw throwable0;
                        label_61:
                            if(z) {
                                if(z1) {
                                    b0.close();
                                    v4 = 12;
                                    goto label_77;
                                }
                                if(z2) {
                                    b0.close();
                                    v4 = 15;
                                    goto label_77;
                                }
                            }
                            ++v6;
                            goto label_39;
                        }
                    label_72:
                        b0.close();
                        v4 = 0;
                        goto label_77;
                    label_75:
                        b0.close();
                        v4 = 0;
                    label_77:
                        if(v4 != 0) {
                            return v4;
                        }
                        try {
                            b2 = null;
                            b2 = new b(arr_b);
                            goto label_85;
                        }
                        catch(Exception unused_ex) {
                            goto label_90;
                        }
                        catch(Throwable throwable1) {
                        }
                        b b3 = null;
                        goto label_96;
                        try {
                        label_85:
                            ByteOrder byteOrder0 = g.s(b2);
                            this.f = byteOrder0;
                            b2.c = byteOrder0;
                            v7 = b2.readShort();
                            goto label_99;
                        }
                        catch(Exception unused_ex) {
                        label_90:
                            if(b2 != null) {
                                b2.close();
                            }
                            z3 = false;
                            goto label_101;
                        }
                        catch(Throwable throwable1) {
                            b3 = b2;
                        }
                    label_96:
                        if(b3 != null) {
                            b3.close();
                        }
                        throw throwable1;
                    label_99:
                        z3 = v7 == 20306 || v7 == 21330;
                        b2.close();
                    label_101:
                        if(z3) {
                            return 7;
                        }
                        try {
                            b4 = new b(arr_b);
                        }
                        catch(Exception unused_ex) {
                            b5 = null;
                            goto label_116;
                        }
                        catch(Throwable throwable2) {
                            b6 = null;
                            goto label_122;
                        }
                        try {
                            ByteOrder byteOrder1 = g.s(b4);
                            this.f = byteOrder1;
                            b4.c = byteOrder1;
                            if(b4.readShort() == 85) {
                                z4 = true;
                            }
                            else {
                                goto label_127;
                            }
                            goto label_128;
                        }
                        catch(Exception unused_ex) {
                            b5 = b4;
                        label_116:
                            if(b5 != null) {
                                b5.close();
                            }
                            z4 = false;
                            goto label_129;
                        }
                        catch(Throwable throwable2) {
                            b6 = b4;
                        }
                    label_122:
                        if(b6 != null) {
                            b6.close();
                        }
                        throw throwable2;
                    label_127:
                        z4 = false;
                    label_128:
                        b4.close();
                    label_129:
                        if(z4) {
                            return 10;
                        }
                        for(int v8 = 0; true; ++v8) {
                            boolean z5 = true;
                            byte[] arr_b5 = g.z;
                            if(v8 >= arr_b5.length) {
                                break;
                            }
                            if(arr_b[v8] != arr_b5[v8]) {
                                z5 = false;
                                break;
                            }
                        }
                        if(z5) {
                            return 13;
                        }
                        for(int v9 = 0; true; ++v9) {
                            byte[] arr_b6 = g.B;
                            if(v9 >= arr_b6.length) {
                                break;
                            }
                            if(arr_b[v9] != arr_b6[v9]) {
                                return 0;
                            }
                        }
                        for(int v10 = 0; true; ++v10) {
                            byte[] arr_b7 = g.C;
                            if(v10 >= arr_b7.length) {
                                return 14;
                            }
                            if(arr_b[arr_b6.length + v10 + 4] != arr_b7[v10]) {
                                break;
                            }
                        }
                        return 0;
                    }
                    ++v1;
                }
                return 9;
            }
            ++v;
        }
        return 4;
    }

    public final void h(f f0) {
        this.k(f0);
        HashMap[] arr_hashMap = this.d;
        c c0 = (c)arr_hashMap[1].get("MakerNote");
        if(c0 != null) {
            f f1 = new f(c0.d);
            f1.c = this.f;
            byte[] arr_b = new byte[g.x.length];
            f1.readFully(arr_b);
            f1.f(0L);
            byte[] arr_b1 = g.y;
            byte[] arr_b2 = new byte[arr_b1.length];
            f1.readFully(arr_b2);
            if(Arrays.equals(arr_b, g.x)) {
                f1.f(8L);
            }
            else if(Arrays.equals(arr_b2, arr_b1)) {
                f1.f(12L);
            }
            this.u(f1, 6);
            c c1 = (c)arr_hashMap[7].get("PreviewImageStart");
            c c2 = (c)arr_hashMap[7].get("PreviewImageLength");
            if(c1 != null && c2 != null) {
                arr_hashMap[5].put("JPEGInterchangeFormat", c1);
                arr_hashMap[5].put("JPEGInterchangeFormatLength", c2);
            }
            c c3 = (c)arr_hashMap[8].get("AspectFrame");
            if(c3 != null) {
                int[] arr_v = (int[])c3.g(this.f);
                if(arr_v == null || arr_v.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(arr_v));
                }
                else {
                    int v = arr_v[2];
                    int v1 = arr_v[0];
                    if(v > v1) {
                        int v2 = arr_v[3];
                        int v3 = arr_v[1];
                        if(v2 > v3) {
                            int v4 = v - v1 + 1;
                            int v5 = v2 - v3 + 1;
                            if(v4 < v5) {
                                int v6 = v4 + v5;
                                v5 = v6 - v5;
                                v4 = v6 - v5;
                            }
                            c c4 = c.c(v4, this.f);
                            c c5 = c.c(v5, this.f);
                            arr_hashMap[0].put("ImageWidth", c4);
                            arr_hashMap[0].put("ImageLength", c5);
                        }
                    }
                }
            }
        }
    }

    public final void i(b b0) {
        if(g.m) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + b0);
        }
        b0.c = ByteOrder.BIG_ENDIAN;
        int v = b0.b;
        b0.c(g.z.length);
        boolean z = false;
        boolean z1 = false;
        try {
            while(!z || !z1) {
                int v1 = b0.readInt();
                int v2 = b0.readInt();
                int v3 = b0.b + v1 + 4;
                int v4 = b0.b - v;
                if(v4 == 16 && v2 != 1229472850) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appear as the first chunk");
                }
                if(v2 == 0x49454E44) {
                    break;
                }
                if(v2 == 1700284774 && !z) {
                    this.h = v4;
                    byte[] arr_b = new byte[v1];
                    b0.readFully(arr_b);
                    int v5 = b0.readInt();
                    CRC32 cRC320 = new CRC32();
                    cRC320.update(101);
                    cRC320.update(0x6558);
                    cRC320.update(0x655849);
                    cRC320.update(1700284774);
                    cRC320.update(arr_b);
                    if(((int)cRC320.getValue()) != v5) {
                        throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + v5 + ", calculated CRC value: " + cRC320.getValue());
                    }
                    this.t(0, arr_b);
                    this.z();
                    this.w(new b(arr_b));
                    z = true;
                }
                else if(v2 == 0x69545874 && !z1) {
                    byte[] arr_b1 = g.A;
                    if(v1 >= arr_b1.length) {
                        byte[] arr_b2 = new byte[arr_b1.length];
                        b0.readFully(arr_b2);
                        if(Arrays.equals(arr_b2, arr_b1)) {
                            int v6 = b0.b - v;
                            int v7 = v1 - arr_b1.length;
                            byte[] arr_b3 = new byte[v7];
                            b0.readFully(arr_b3);
                            this.l = new c(((long)v6), arr_b3, 1, v7);
                            z1 = true;
                        }
                    }
                }
                b0.c(v3 - b0.b);
            }
            return;
        }
        catch(EOFException eOFException0) {
        }
        throw new IOException("Encountered corrupt PNG file.", eOFException0);
    }

    public final void j(b b0) {
        boolean z = g.m;
        if(z) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + b0);
        }
        b0.c(84);
        byte[] arr_b = new byte[4];
        byte[] arr_b1 = new byte[4];
        byte[] arr_b2 = new byte[4];
        b0.readFully(arr_b);
        b0.readFully(arr_b1);
        b0.readFully(arr_b2);
        int v = ByteBuffer.wrap(arr_b).getInt();
        int v1 = ByteBuffer.wrap(arr_b1).getInt();
        int v2 = ByteBuffer.wrap(arr_b2).getInt();
        byte[] arr_b3 = new byte[v1];
        b0.c(v - b0.b);
        b0.readFully(arr_b3);
        this.f(new b(arr_b3), v, 5);
        b0.c(v2 - b0.b);
        b0.c = ByteOrder.BIG_ENDIAN;
        int v3 = b0.readInt();
        if(z) {
            va.e.f(v3, "numberOfDirectoryEntry: ", "ExifInterface");
        }
        for(int v4 = 0; v4 < v3; ++v4) {
            int v5 = b0.readUnsignedShort();
            int v6 = b0.readUnsignedShort();
            if(v5 == g.H.a) {
                int v7 = b0.readShort();
                int v8 = b0.readShort();
                c c0 = c.c(v7, this.f);
                c c1 = c.c(v8, this.f);
                this.d[0].put("ImageLength", c0);
                this.d[0].put("ImageWidth", c1);
                if(!z) {
                    break;
                }
                Log.d("ExifInterface", "Updated to length: " + v7 + ", width: " + v8);
                return;
            }
            b0.c(v6);
        }
    }

    public final void k(f f0) {
        this.q(f0);
        this.u(f0, 0);
        this.y(f0, 0);
        this.y(f0, 5);
        this.y(f0, 4);
        this.z();
        if(this.c == 8) {
            HashMap[] arr_hashMap = this.d;
            c c0 = (c)arr_hashMap[1].get("MakerNote");
            if(c0 != null) {
                f f1 = new f(c0.d);
                f1.c = this.f;
                f1.c(6);
                this.u(f1, 9);
                c c1 = (c)arr_hashMap[9].get("ColorSpace");
                if(c1 != null) {
                    arr_hashMap[1].put("ColorSpace", c1);
                }
            }
        }
    }

    public final int l() {
        switch(this.c()) {
            case 3: 
            case 4: {
                return 180;
            }
            case 6: 
            case 7: {
                return 90;
            }
            case 5: 
            case 8: {
                return 270;
            }
            default: {
                return 0;
            }
        }
    }

    public final void m(f f0) {
        if(g.m) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + f0);
        }
        this.k(f0);
        HashMap[] arr_hashMap = this.d;
        c c0 = (c)arr_hashMap[0].get("JpgFromRaw");
        if(c0 != null) {
            this.f(new b(c0.d), ((int)c0.c), 5);
        }
        c c1 = (c)arr_hashMap[0].get("ISO");
        if(c1 != null && ((c)arr_hashMap[1].get("PhotographicSensitivity")) == null) {
            arr_hashMap[1].put("PhotographicSensitivity", c1);
        }
    }

    public final void n(b b0) {
        if(g.m) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + b0);
        }
        b0.c = ByteOrder.LITTLE_ENDIAN;
        b0.c(g.B.length);
        int v = b0.readInt();
        b0.c(g.C.length);
        int v1 = g.C.length + 8;
        try {
            while(true) {
                byte[] arr_b = new byte[4];
                b0.readFully(arr_b);
                int v2 = b0.readInt();
                if(Arrays.equals(g.D, arr_b)) {
                    byte[] arr_b1 = new byte[v2];
                    b0.readFully(arr_b1);
                    byte[] arr_b2 = g.P;
                    if(v.J(arr_b1, arr_b2)) {
                        arr_b1 = Arrays.copyOfRange(arr_b1, arr_b2.length, v2);
                    }
                    this.h = v1 + 8;
                    this.t(0, arr_b1);
                    this.w(new b(arr_b1));
                    return;
                }
                if(v2 % 2 == 1) {
                    ++v2;
                }
                v1 = v1 + 8 + v2;
                if(v1 == v + 8) {
                    return;
                }
                if(v1 > v + 8) {
                    break;
                }
                b0.c(v2);
            }
            throw new IOException("Encountered WebP file with invalid chunk size");
        }
        catch(EOFException eOFException0) {
        }
        throw new IOException("Encountered corrupt WebP file.", eOFException0);
    }

    public final void o(b b0, HashMap hashMap0) {
        c c0 = (c)hashMap0.get("JPEGInterchangeFormat");
        c c1 = (c)hashMap0.get("JPEGInterchangeFormatLength");
        if(c0 != null && c1 != null) {
            int v = c0.e(this.f);
            int v1 = c1.e(this.f);
            if(this.c == 7) {
                v += this.i;
            }
            if(v > 0 && v1 > 0 && this.b == null && this.a == null) {
                b0.c(v);
                b0.readFully(new byte[v1]);
            }
            if(g.m) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + v + ", length: " + v1);
            }
        }
    }

    public final boolean p(HashMap hashMap0) {
        c c0 = (c)hashMap0.get("ImageLength");
        c c1 = (c)hashMap0.get("ImageWidth");
        return c0 != null && c1 != null && (c0.e(this.f) <= 0x200 && c1.e(this.f) <= 0x200);
    }

    public final void q(f f0) {
        ByteOrder byteOrder0 = g.s(f0);
        this.f = byteOrder0;
        f0.c = byteOrder0;
        int v = f0.readUnsignedShort();
        if(this.c != 7 && this.c != 10 && v != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(v));
        }
        int v1 = f0.readInt();
        if(v1 < 8) {
            throw new IOException("Invalid first Ifd offset: " + v1);
        }
        if(v1 - 8 > 0) {
            f0.c(v1 - 8);
        }
    }

    public final void r() {
        for(int v = 0; true; ++v) {
            HashMap[] arr_hashMap = this.d;
            if(v >= arr_hashMap.length) {
                break;
            }
            StringBuilder stringBuilder0 = x.n(v, "The size of tag group[", "]: ");
            stringBuilder0.append(arr_hashMap[v].size());
            Log.d("ExifInterface", stringBuilder0.toString());
            for(Object object0: arr_hashMap[v].entrySet()) {
                c c0 = (c)((Map.Entry)object0).getValue();
                Log.d("ExifInterface", "tagName: " + ((String)((Map.Entry)object0).getKey()) + ", tagType: " + c0.toString() + ", tagValue: \'" + c0.f(this.f) + "\'");
            }
        }
    }

    public static ByteOrder s(b b0) {
        int v = b0.readShort();
        boolean z = g.m;
        switch(v) {
            case 0x4949: {
                if(z) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align II");
                }
                return ByteOrder.LITTLE_ENDIAN;
            }
            case 0x4D4D: {
                if(z) {
                    Log.d("ExifInterface", "readExifSegment: Byte Align MM");
                }
                return ByteOrder.BIG_ENDIAN;
            }
            default: {
                throw new IOException("Invalid byte order: " + Integer.toHexString(v));
            }
        }
    }

    public final void t(int v, byte[] arr_b) {
        f f0 = new f(arr_b);
        this.q(f0);
        this.u(f0, v);
    }

    // This method was un-flattened
    public final void u(f f0, int v) {
        long v16;
        long v14;
        d d1;
        long v13;
        int v12;
        HashSet hashSet2;
        HashSet hashSet1;
        HashMap[] arr_hashMap1;
        int v8;
        int v1 = f0.e;
        HashSet hashSet0 = this.e;
        hashSet0.add(f0.b);
        int v2 = f0.readShort();
        boolean z = g.m;
        if(z) {
            va.e.f(v2, "numberOfDirectoryEntry: ", "ExifInterface");
        }
        if(v2 > 0) {
            int v3 = 0;
            while(true) {
                HashMap[] arr_hashMap = this.d;
                if(v3 >= v2) {
                    break;
                }
                int v4 = f0.readUnsignedShort();
                int v5 = f0.readUnsignedShort();
                int v6 = f0.readInt();
                long v7 = ((long)f0.b) + 4L;
                d d0 = (d)g.K[v].get(v4);
                if(z) {
                    v8 = v3;
                    arr_hashMap1 = arr_hashMap;
                    hashSet1 = hashSet0;
                    Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", v, v4, (d0 == null ? null : d0.b), v5, v6));
                }
                else {
                    hashSet1 = hashSet0;
                    v8 = v3;
                    arr_hashMap1 = arr_hashMap;
                }
                if(d0 == null) {
                    if(z) {
                        va.e.f(v4, "Skip the tag entry since tag number is not defined: ", "ExifInterface");
                    }
                    f0.f(v7);
                    hashSet2 = hashSet1;
                }
                else if(v5 > 0) {
                    int[] arr_v = g.F;
                    if(v5 < arr_v.length) {
                        int v9 = d0.c;
                        if(v9 == 7 || v5 == 7 || v9 == v5 || (d0.d == v5 || (v9 == 4 || d0.d == 4) && v5 == 3 || (v9 == 9 || d0.d == 9) && v5 == 8 || (v9 == 12 || d0.d == 12) && v5 == 11)) {
                            if(v5 == 7) {
                                v5 = v9;
                            }
                            long v10 = ((long)v6) * ((long)arr_v[v5]);
                            if(v10 >= 0L && v10 <= 0x7FFFFFFFL) {
                                if(Long.compare(v10, 4L) > 0) {
                                    int v11 = f0.readInt();
                                    if(z) {
                                        va.e.f(v11, "seek to data offset: ", "ExifInterface");
                                    }
                                    v12 = v4;
                                    if(this.c != 7) {
                                    label_71:
                                        d1 = d0;
                                        v13 = v7;
                                    }
                                    else if("MakerNote".equals(d0.b)) {
                                        this.i = v11;
                                        goto label_71;
                                    }
                                    else if(v == 6 && "ThumbnailImage".equals(d0.b)) {
                                        this.j = v11;
                                        this.k = v6;
                                        c c0 = c.c(6, this.f);
                                        v13 = v7;
                                        c c1 = c.a(this.j, this.f);
                                        d1 = d0;
                                        c c2 = c.a(this.k, this.f);
                                        arr_hashMap1[4].put("Compression", c0);
                                        arr_hashMap1[4].put("JPEGInterchangeFormat", c1);
                                        arr_hashMap1[4].put("JPEGInterchangeFormatLength", c2);
                                    }
                                    f0.f(((long)v11));
                                }
                                else {
                                    v13 = v7;
                                    v12 = v4;
                                    d1 = d0;
                                }
                                Integer integer0 = (Integer)g.N.get(v12);
                                if(z) {
                                    Log.d("ExifInterface", "nextIfdType: " + integer0 + " byteCount: " + v10);
                                }
                                if(integer0 == null) {
                                    hashSet2 = hashSet1;
                                    int v15 = f0.b + this.h;
                                    byte[] arr_b = new byte[((int)v10)];
                                    f0.readFully(arr_b);
                                    c c3 = new c(((long)v15), arr_b, v5, v6);
                                    String s = d1.b;
                                    arr_hashMap1[v].put(s, c3);
                                    if("DNGVersion".equals(s)) {
                                        this.c = 3;
                                    }
                                    if(("Make".equals(s) || "Model".equals(s)) && c3.f(this.f).contains("PENTAX") || "Compression".equals(s) && c3.e(this.f) == 0xFFFF) {
                                        this.c = 8;
                                    }
                                    if(((long)f0.b) != v13) {
                                        f0.f(v13);
                                    }
                                }
                                else {
                                    switch(v5) {
                                        case 3: {
                                            v14 = (long)f0.readUnsignedShort();
                                            break;
                                        }
                                        case 4: {
                                            v14 = ((long)f0.readInt()) & 0xFFFFFFFFL;
                                            break;
                                        }
                                        case 8: {
                                            v14 = (long)f0.readShort();
                                            break;
                                        }
                                        case 9: 
                                        case 13: {
                                            v14 = (long)f0.readInt();
                                            break;
                                        }
                                        default: {
                                            v14 = -1L;
                                        }
                                    }
                                    if(z) {
                                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", v14, d1.b));
                                    }
                                    if(Long.compare(v14, 0L) > 0 && (v1 == -1 || v14 < ((long)v1))) {
                                        hashSet2 = hashSet1;
                                        if(!hashSet2.contains(((int)v14))) {
                                            f0.f(v14);
                                            this.u(f0, ((int)integer0));
                                        }
                                        else if(z) {
                                            Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + integer0 + " (at " + v14 + ")");
                                        }
                                    }
                                    else {
                                        hashSet2 = hashSet1;
                                        if(z) {
                                            Log.d("ExifInterface", (v1 == -1 ? va.e.a(v14, "Skip jump into the IFD since its offset is invalid: ") : va.e.a(v14, "Skip jump into the IFD since its offset is invalid: ") + " (total length: " + v1 + ")"));
                                        }
                                    }
                                    f0.f(v13);
                                }
                            }
                            else {
                                if(z) {
                                    va.e.f(v6, "Skip the tag entry since the number of components is invalid: ", "ExifInterface");
                                }
                                f0.f(v7);
                                hashSet2 = hashSet1;
                            }
                        }
                        else {
                            if(z) {
                                Log.d("ExifInterface", "Skip the tag entry since data format (" + g.E[v5] + ") is unexpected for tag: " + d0.b);
                            }
                            f0.f(v7);
                            hashSet2 = hashSet1;
                        }
                    }
                    else {
                        v16 = v7;
                        goto label_125;
                    }
                }
                else {
                    v16 = v7;
                label_125:
                    if(z) {
                        va.e.f(v5, "Skip the tag entry since data format is invalid: ", "ExifInterface");
                    }
                    f0.f(v16);
                    hashSet2 = hashSet1;
                }
                v3 = (short)(v8 + 1);
                hashSet0 = hashSet2;
            }
            int v17 = f0.readInt();
            if(z) {
                Log.d("ExifInterface", String.format("nextIfdOffset: %d", v17));
            }
            if(((long)v17) > 0L) {
                if(!hashSet0.contains(v17)) {
                    f0.f(((long)v17));
                    if(arr_hashMap[4].isEmpty()) {
                        this.u(f0, 4);
                        return;
                    }
                    if(arr_hashMap[5].isEmpty()) {
                        this.u(f0, 5);
                    }
                }
                else if(z) {
                    va.e.f(v17, "Stop reading file since re-reading an IFD may cause an infinite loop: ", "ExifInterface");
                }
            }
            else if(z) {
                va.e.f(v17, "Stop reading file since a wrong offset may cause an infinite loop: ", "ExifInterface");
            }
        }
    }

    public final void v(int v, String s, String s1) {
        HashMap[] arr_hashMap = this.d;
        if(!arr_hashMap[v].isEmpty() && arr_hashMap[v].get(s) != null) {
            HashMap hashMap0 = arr_hashMap[v];
            hashMap0.put(s1, ((c)hashMap0.get(s)));
            arr_hashMap[v].remove(s);
        }
    }

    public final void w(b b0) {
        HashMap hashMap0 = this.d[4];
        c c0 = (c)hashMap0.get("Compression");
        if(c0 != null) {
            int v = c0.e(this.f);
            switch(v) {
                case 1: {
                    break;
                }
                case 6: {
                    this.o(b0, hashMap0);
                    return;
                label_8:
                    if(v != 7) {
                        return;
                    }
                    break;
                }
                default: {
                    goto label_8;
                }
            }
            c c1 = (c)hashMap0.get("BitsPerSample");
            if(c1 == null) {
            label_71:
                if(g.m) {
                    Log.d("ExifInterface", "Unsupported data type value");
                }
            }
            else {
                int[] arr_v = (int[])c1.g(this.f);
                int[] arr_v1 = g.p;
                if(Arrays.equals(arr_v1, arr_v)) {
                label_20:
                    c c3 = (c)hashMap0.get("StripOffsets");
                    c c4 = (c)hashMap0.get("StripByteCounts");
                    if(c3 != null && c4 != null) {
                        long[] arr_v2 = v.s(c3.g(this.f));
                        long[] arr_v3 = v.s(c4.g(this.f));
                        if(arr_v2 == null || arr_v2.length == 0) {
                            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
                            return;
                        }
                        if(arr_v3 == null || arr_v3.length == 0) {
                            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
                            return;
                        }
                        if(arr_v2.length != arr_v3.length) {
                            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
                            return;
                        }
                        long v2 = 0L;
                        for(int v3 = 0; v3 < arr_v3.length; ++v3) {
                            v2 += arr_v3[v3];
                        }
                        byte[] arr_b = new byte[((int)v2)];
                        this.g = true;
                        int v5 = 0;
                        int v6 = 0;
                        for(int v4 = 0; v4 < arr_v2.length; ++v4) {
                            int v7 = (int)arr_v2[v4];
                            int v8 = (int)arr_v3[v4];
                            if(v4 < arr_v2.length - 1 && ((long)(v7 + v8)) != arr_v2[v4 + 1]) {
                                this.g = false;
                            }
                            int v9 = v7 - v5;
                            if(v9 < 0) {
                                Log.d("ExifInterface", "Invalid strip offset value");
                                return;
                            }
                            try {
                                b0.c(v9);
                            }
                            catch(EOFException unused_ex) {
                                Log.d("ExifInterface", "Failed to skip " + v9 + " bytes.");
                                return;
                            }
                            byte[] arr_b1 = new byte[v8];
                            try {
                                b0.readFully(arr_b1);
                            }
                            catch(EOFException unused_ex) {
                                Log.d("ExifInterface", "Failed to read " + v8 + " bytes.");
                                return;
                            }
                            v5 = v5 + v9 + v8;
                            System.arraycopy(arr_b1, 0, arr_b, v6, v8);
                            v6 += v8;
                        }
                        if(this.g) {
                            long v10 = arr_v2[0];
                            return;
                        }
                    }
                }
                else if(this.c == 3) {
                    c c2 = (c)hashMap0.get("PhotometricInterpretation");
                    if(c2 == null) {
                        goto label_71;
                    }
                    else {
                        int v1 = c2.e(this.f);
                        if((v1 != 1 || !Arrays.equals(arr_v, g.q)) && (v1 != 6 || !Arrays.equals(arr_v, arr_v1))) {
                            goto label_71;
                        }
                        else {
                            goto label_20;
                        }
                    }
                }
                else {
                    goto label_71;
                }
            }
            return;
        }
        this.o(b0, hashMap0);
    }

    public final void x(int v, int v1) {
        HashMap[] arr_hashMap = this.d;
        boolean z = g.m;
        if(!arr_hashMap[v].isEmpty() && !arr_hashMap[v1].isEmpty()) {
            c c0 = (c)arr_hashMap[v].get("ImageLength");
            c c1 = (c)arr_hashMap[v].get("ImageWidth");
            c c2 = (c)arr_hashMap[v1].get("ImageLength");
            c c3 = (c)arr_hashMap[v1].get("ImageWidth");
            if(c0 != null && c1 != null) {
                if(c2 != null && c3 != null) {
                    int v2 = c0.e(this.f);
                    int v3 = c1.e(this.f);
                    if(v2 < c2.e(this.f) && v3 < c3.e(this.f)) {
                        HashMap hashMap0 = arr_hashMap[v];
                        arr_hashMap[v] = arr_hashMap[v1];
                        arr_hashMap[v1] = hashMap0;
                    }
                }
                else if(z) {
                    Log.d("ExifInterface", "Second image does not contain valid size information");
                }
            }
            else if(z) {
                Log.d("ExifInterface", "First image does not contain valid size information");
            }
        }
        else if(z) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    public final void y(f f0, int v) {
        c c6;
        c c5;
        HashMap[] arr_hashMap = this.d;
        c c0 = (c)arr_hashMap[v].get("DefaultCropSize");
        c c1 = (c)arr_hashMap[v].get("SensorTopBorder");
        c c2 = (c)arr_hashMap[v].get("SensorLeftBorder");
        c c3 = (c)arr_hashMap[v].get("SensorBottomBorder");
        c c4 = (c)arr_hashMap[v].get("SensorRightBorder");
        if(c0 != null) {
            if(c0.a == 5) {
                e[] arr_e = (e[])c0.g(this.f);
                if(arr_e != null && arr_e.length == 2) {
                    c5 = c.b(arr_e[0], this.f);
                    c6 = c.b(arr_e[1], this.f);
                    arr_hashMap[v].put("ImageWidth", c5);
                    arr_hashMap[v].put("ImageLength", c6);
                    return;
                }
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(arr_e));
                return;
            }
            int[] arr_v = (int[])c0.g(this.f);
            if(arr_v != null && arr_v.length == 2) {
                c5 = c.c(arr_v[0], this.f);
                c6 = c.c(arr_v[1], this.f);
                arr_hashMap[v].put("ImageWidth", c5);
                arr_hashMap[v].put("ImageLength", c6);
                return;
            }
            Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(arr_v));
            return;
        }
        if(c1 != null && c2 != null && c3 != null && c4 != null) {
            int v1 = c1.e(this.f);
            int v2 = c3.e(this.f);
            int v3 = c4.e(this.f);
            int v4 = c2.e(this.f);
            if(v2 > v1 && v3 > v4) {
                c c7 = c.c(v2 - v1, this.f);
                c c8 = c.c(v3 - v4, this.f);
                arr_hashMap[v].put("ImageLength", c7);
                arr_hashMap[v].put("ImageWidth", c8);
            }
        }
        else if(((c)arr_hashMap[v].get("ImageLength")) == null || ((c)arr_hashMap[v].get("ImageWidth")) == null) {
            c c9 = (c)arr_hashMap[v].get("JPEGInterchangeFormat");
            if(c9 != null && ((c)arr_hashMap[v].get("JPEGInterchangeFormatLength")) != null) {
                int v5 = c9.e(this.f);
                int v6 = c9.e(this.f);
                f0.f(((long)v5));
                byte[] arr_b = new byte[v6];
                f0.readFully(arr_b);
                this.f(new b(arr_b), v5, v);
            }
        }
    }

    public final void z() {
        this.x(0, 5);
        this.x(0, 4);
        this.x(5, 4);
        HashMap[] arr_hashMap = this.d;
        c c0 = (c)arr_hashMap[1].get("PixelXDimension");
        c c1 = (c)arr_hashMap[1].get("PixelYDimension");
        if(c0 != null && c1 != null) {
            arr_hashMap[0].put("ImageWidth", c0);
            arr_hashMap[0].put("ImageLength", c1);
        }
        if(arr_hashMap[4].isEmpty() && this.p(arr_hashMap[5])) {
            arr_hashMap[4] = arr_hashMap[5];
            arr_hashMap[5] = new HashMap();
        }
        if(!this.p(arr_hashMap[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        this.v(0, "ThumbnailOrientation", "Orientation");
        this.v(0, "ThumbnailImageLength", "ImageLength");
        this.v(0, "ThumbnailImageWidth", "ImageWidth");
        this.v(5, "ThumbnailOrientation", "Orientation");
        this.v(5, "ThumbnailImageLength", "ImageLength");
        this.v(5, "ThumbnailImageWidth", "ImageWidth");
        this.v(4, "Orientation", "ThumbnailOrientation");
        this.v(4, "ImageLength", "ThumbnailImageLength");
        this.v(4, "ImageWidth", "ThumbnailImageWidth");
    }
}

