package com.keinen.flyweightPattern;

import java.awt.*;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;

enum FontEffect {
    BOLD, ITALIC, SUPERSCRIPT, SUBSCRIPT, STRIKETHROUGH
}

final class FontData {
    private static final WeakHashMap<FontData, WeakReference<FontData>> flyweightData = new WeakHashMap<FontData, WeakReference<FontData>>();
    private final int pointSize;
    private final String fontFace;
    private final Color color;
    private final Set<FontEffect> effects;

    public FontData(int pointSize, String fontFace, Color color, EnumSet<FontEffect> effects) {
        this.pointSize = pointSize;
        this.fontFace = fontFace;
        this.color = color;
        this.effects = Collections.unmodifiableSet(effects);
    }

    public static FontData create(int pointSize, String fontFace, Color color, FontEffect... effects) {
        EnumSet<FontEffect> effectSet = EnumSet.noneOf(FontEffect.class);
        for (FontEffect fontEffect : effects) {
            effectSet.add(fontEffect);
        }

        FontData data = new FontData(pointSize, fontFace, color, effectsSet);
        if(!flyweightData.containsKey(data)) {
            flyweightData.put(data, new WeakReference(data));
        }

        return flyweightData.get(data).get();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof FontData) {
            if (obj == this) {
                return true;
            }

            FontData other = (FontData) obj;
            return other.pointSize == pointSize && other.fontFace.equals(fontFace)
                    && other.color.equals(color) && other.effects.equals(effects);
        }
        return false;
    }

    @Override
    public  int hashCode() {
        return (pointSize*37 + effects.hashCode()*13) * fontFace.hashCode();
    }
}

public class flyweightPattern {

    public static void main(String[] args) {

    }
}
