package top.isopen.plugin.component;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import top.isopen.plugin.service.SoupService;

/**
 * @author TimeChaser
 * @since 2021/11/25 16:13
 */
public class SoupNotification extends AnAction {

    private final SoupService soupService = new SoupService();

    @Override
    public void actionPerformed(AnActionEvent e) {
        Notifications.Bus.notify(new Notification("IsOpen", "Soul Soup", soupService.getContent(), NotificationType.INFORMATION));
    }
}
