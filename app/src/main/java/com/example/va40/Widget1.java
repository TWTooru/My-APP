package com.example.va40;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RemoteViews;


public class Widget1 extends AppWidgetProvider {
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget1);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    private ImageView go;
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        Intent i =new Intent(context, VApassport.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(context, 0, i, 0);
        RemoteViews myRemoteViews = new RemoteViews(context.getPackageName(),R.layout.widget1);
        myRemoteViews.setOnClickPendingIntent(R.id.widget_go, pendingIntent);



    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}