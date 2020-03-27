package com.example.myapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

class Notification_c extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notif1 = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent reapeating_intent = new Intent(context, RE_C.class);
        reapeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,reapeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentTitle("Important")
                .setContentText("D'ont forgot to clean your hands well and keep drinking water")
                .setAutoCancel(true);
        assert notif1 != null;
        notif1.notify(100,builder.build());


    }
}
