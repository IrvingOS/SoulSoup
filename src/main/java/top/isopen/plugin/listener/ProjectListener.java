package top.isopen.plugin.listener;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import org.jetbrains.annotations.NotNull;
import top.isopen.plugin.dialog.SoupDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TimeChaser
 * @since 2021/11/25 11:10
 */
public class ProjectListener implements ProjectManagerListener {

    private static final List<Project> PROJECT_LIST = new ArrayList<>();

    @Override
    public void projectOpened(@NotNull Project project) {
        if (!PROJECT_LIST.contains(project)) {
            SoupDialog soupDialog = new SoupDialog();
            soupDialog.show();
            PROJECT_LIST.add(project);
        }
    }
}
