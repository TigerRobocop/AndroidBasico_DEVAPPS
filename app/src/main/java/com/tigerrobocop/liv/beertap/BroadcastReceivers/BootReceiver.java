package com.tigerrobocop.liv.beertap.BroadcastReceivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tigerrobocop.liv.beertap.DetailsActivity;
import com.tigerrobocop.liv.beertap.NewItemActivity;
import com.tigerrobocop.liv.beertap.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Livia on 13/08/2017.
 */

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        intent = new Intent(context, NewItemActivity.class);

        PendingIntent pIntent = PendingIntent.getActivity(context
                , (int) System.currentTimeMillis(), intent, 0);

        Notification noti = new Notification.Builder(context)
                .setContentTitle(context.getResources().getString(R.string.notif_add_new))
                .setContentText(context.getResources().getString(R.string.notif_add_new_content)).setSmallIcon(R.drawable.icon)
                .setContentIntent(pIntent).build();


        NotificationManager notificationManager = (NotificationManager)context.getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        noti.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, noti);

    }
}
