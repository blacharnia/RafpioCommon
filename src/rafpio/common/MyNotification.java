package rafpio.common;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class MyNotification {

    public void sendNotification(Context context, Activity activity) {

        NotificationManager nm = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);
        CharSequence from = "Messenger";
        StringBuilder message = new StringBuilder("Notification message:");

        Intent startIntent = new Intent(context.getApplicationContext(),
                activity.getClass());

        startIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                startIntent, 0);
        Notification notif = new Notification(R.drawable.ic_launcher,
                "Notification ticker text",
                System.currentTimeMillis());
        notif.flags |= Notification.FLAG_AUTO_CANCEL;
        notif.setLatestEventInfo(context, from, message, contentIntent);
        nm.notify(1, notif);

    }
}
