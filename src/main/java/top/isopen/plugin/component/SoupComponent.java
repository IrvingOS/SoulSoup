package top.isopen.plugin.component;

import com.intellij.openapi.components.ApplicationComponent;
import top.isopen.plugin.dialog.SoupDialog;

/**
 * @author TimeChaser
 * @since 2021/11/25 14:17
 */
public class SoupComponent implements ApplicationComponent {

    @Override
    public void initComponent() {
        SoupDialog soupDialog = new SoupDialog();
        soupDialog.show();
    }
}
