package top.isopen.plugin.listener;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;
import top.isopen.plugin.dialog.SoupDialog;

/**
 * @author TimeChaser
 * @since 2021/11/25 11:10
 */
public class ProjectListener implements ProjectManagerListener {

    @Override
    public void projectOpened(@NotNull Project project) {
        SoupDialog soupDialog = new SoupDialog();
        soupDialog.show();
    }
}
