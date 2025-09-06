package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData.Justification;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader.Options;
import com.airbnb.lottie.parser.moshi.JsonReader;

public class DocumentDataParser implements ValueParser {
    public static final DocumentDataParser INSTANCE;
    private static final Options NAMES;

    static {
        DocumentDataParser.INSTANCE = new DocumentDataParser();
        DocumentDataParser.NAMES = Options.of(new String[]{"t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz"});
    }

    public DocumentData parse(JsonReader jsonReader0, float f) {
        jsonReader0.beginObject();
        Justification documentData$Justification0 = Justification.CENTER;
        String s = null;
        String s1 = null;
        PointF pointF0 = null;
        PointF pointF1 = null;
        float f1 = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int v = 0;
        int v1 = 0;
        int v2 = 0;
        boolean z = true;
        while(jsonReader0.hasNext()) {
            switch(jsonReader0.selectName(DocumentDataParser.NAMES)) {
                case 0: {
                    s = jsonReader0.nextString();
                    break;
                }
                case 1: {
                    s1 = jsonReader0.nextString();
                    break;
                }
                case 2: {
                    f1 = (float)jsonReader0.nextDouble();
                    break;
                }
                case 3: {
                    int v3 = jsonReader0.nextInt();
                    Justification documentData$Justification1 = Justification.CENTER;
                    if(v3 <= documentData$Justification1.ordinal() && v3 >= 0) {
                        documentData$Justification0 = Justification.values()[v3];
                        break;
                    }
                    else {
                        documentData$Justification0 = documentData$Justification1;
                        continue;
                    }
                    v = jsonReader0.nextInt();
                    break;
                }
                case 4: {
                    v = jsonReader0.nextInt();
                    break;
                }
                case 5: {
                    f2 = (float)jsonReader0.nextDouble();
                    break;
                }
                case 6: {
                    f3 = (float)jsonReader0.nextDouble();
                    break;
                }
                case 7: {
                    v1 = JsonUtils.jsonToColor(jsonReader0);
                    break;
                }
                case 8: {
                    v2 = JsonUtils.jsonToColor(jsonReader0);
                    break;
                }
                case 9: {
                    f4 = (float)jsonReader0.nextDouble();
                    break;
                }
                case 10: {
                    z = jsonReader0.nextBoolean();
                    break;
                }
                case 11: {
                    jsonReader0.beginArray();
                    PointF pointF2 = new PointF(((float)jsonReader0.nextDouble()) * f, ((float)jsonReader0.nextDouble()) * f);
                    jsonReader0.endArray();
                    pointF0 = pointF2;
                    break;
                }
                case 12: {
                    jsonReader0.beginArray();
                    PointF pointF3 = new PointF(((float)jsonReader0.nextDouble()) * f, ((float)jsonReader0.nextDouble()) * f);
                    jsonReader0.endArray();
                    pointF1 = pointF3;
                    break;
                }
                default: {
                    jsonReader0.skipName();
                    jsonReader0.skipValue();
                }
            }
        }
        jsonReader0.endObject();
        return new DocumentData(s, s1, f1, documentData$Justification0, v, f2, f3, v1, v2, f4, z, pointF0, pointF1);
    }

    @Override  // com.airbnb.lottie.parser.ValueParser
    public Object parse(JsonReader jsonReader0, float f) {
        return this.parse(jsonReader0, f);
    }
}

