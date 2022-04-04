package test.map.whatislife.firebase_Package

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import test.map.whatislife.R

class MyFirebaseMessagingService : FirebaseMessagingService() {

    //새로운토큰을 갱신하려고 만든것
    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

    //실제로 파이어베이스에서 메세지를 수신할때마다 호출
    override fun onMessageReceived(remotemessage: RemoteMessage) {
        super.onMessageReceived(remotemessage)

        createNotificationChannel()

        val type = remotemessage.data["type"]
            ?.let { NotificationType.valueOf(it) }

        val title = remotemessage.data["Title"]
        val message = remotemessage.data["Message"]

        type ?: return


        NotificationManagerCompat.from(this)
            .notify(type.id,createNotification(type, title, message))

    }


    //채널생성
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT)


            channel.description = CHANNEL_DESCRIPTION

            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .createNotificationChannel(channel)
        }
    }

    private fun createNotification(
        type: NotificationType,
        title: String?,
        message: String?,
    ): Notification {

        val notificationBUilder= NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_circle_notifications_24)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)


        when(type){
            NotificationType.NORMAL -> Unit
            NotificationType.EXPANDABLE -> {
                notificationBUilder.setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("\uD83D\uDE00" +
                                "\uD83D\uDE03" +
                                "\uD83D\uDE04" +
                                "\uD83D\uDE01" +
                                "\uD83D\uDE06" +
                                "\uD83D\uDE05" +
                                "\uD83E\uDD23" +
                                "\uD83D\uDE02" +
                                "\uD83D\uDE42" +
                                "\uD83D\uDE43" +
                                "\uD83D\uDE09" +
                                "\uD83D\uDE0A")
                )
            }
            NotificationType.CUSTOM -> {
                notificationBUilder
                    .setStyle(NotificationCompat.DecoratedCustomViewStyle())

            }
        }

        return  notificationBUilder.build()
    }

    companion object {
        private const val CHANNEL_NAME = "Emoji Party"
        private const val CHANNEL_DESCRIPTION = "Emoji Party를 위한 채널"
        private const val CHANNEL_ID = "channel Id"
    }
}