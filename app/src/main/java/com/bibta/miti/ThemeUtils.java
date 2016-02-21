package com.bibta.miti;

import android.content.Context;
import android.util.TypedValue;

/**
 * Helper class to work on theme related jobs.
 */
public class ThemeUtils {

    /**
     * Get color from current theme.
     * @param context Context with the required theme.
     * @param attribute Color attribute to get from the theme.
     * @return Color as integer represented by the attributed in current theme.
     */
    public static int getThemeColor(Context context, int attribute) {
        TypedValue value = new TypedValue();
        context.getTheme().resolveAttribute(attribute, value, true);
        return value.data;
    }
}
