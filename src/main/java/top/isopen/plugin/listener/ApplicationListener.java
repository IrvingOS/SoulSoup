package top.isopen.plugin.listener;

import com.intellij.ide.AppLifecycleListener;

/**
 * @author TimeChaser
 * @since 2021/11/25 11:05
 */
public class ApplicationListener implements AppLifecycleListener {

    @Override
    public void welcomeScreenDisplayed() {
        AppLifecycleListener.super.welcomeScreenDisplayed();
        System.out.println("welcomeScreenDisplayed");
    }

    @Override
    public void appStarted() {
        System.out.println("appStarted");
    }
}