package br.com.goncalves.pugnotification.notification;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;

public class Simple extends Basic {
    private static final String TAG = Simple.class.getSimpleName();
    private int mProgress;
    private int mMax;
    private boolean mIndeterminate;

    public Simple(Builder builder, int identifier, String tag) {
        super(builder, identifier, tag);
    }

    @Override
    public void build() {
        builder.setProgress(mMax, mProgress, mIndeterminate);
        super.build();
        super.notificationNotify();
    }

    public void build(int flags){
        builder.setProgress(mMax, mProgress, mIndeterminate);
        super.build(flags);
        super.notificationNotify();
    }

    public Simple update(int identifier) {
        Builder builder = new NotificationCompat.Builder(PugNotification.mSingleton.mContext);
        builder.setProgress(mMax, mProgress, mIndeterminate);

        notification = builder.build();
        notification.flags |= Notification.FLAG_NO_CLEAR;
        notificationNotify(identifier);
        return this;
    }

    public Simple setProgress(int progress, int max, boolean indeterminate) {
        this.mProgress = progress;
        this.mMax = max;
        this.mIndeterminate = indeterminate;
        return this;
    }
}
