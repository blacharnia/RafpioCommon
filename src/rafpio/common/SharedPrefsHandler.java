package rafpio.common;

import android.content.Context;

public class SharedPrefsHandler {

    public static String getPrefTextValue(Context context, String prefFileName,
            String valueName) {
        return context.getSharedPreferences(prefFileName, 0).getString(
                valueName, "");
    }

    public static boolean setPrefTextValue(Context context,
            String prefFileName, String valueName, String valueContent) {
        return context.getSharedPreferences(prefFileName, 0).edit()
                .putString(valueName, valueContent).commit();
    }
}
