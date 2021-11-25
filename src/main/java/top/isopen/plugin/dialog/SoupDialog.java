package top.isopen.plugin.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;
import top.isopen.plugin.service.SoupService;

import javax.swing.*;

/**
 * @author TimeChaser
 * @since 2021/11/25 14:21
 */
public class SoupDialog extends DialogWrapper {

    public static final String      ERROR = "碗都碎了，明天再来吧！";
    private final       SoupService soupService;
    private             JPanel      panel;
    private             JLabel      label;

    public SoupDialog() {
        super(true);
        this.soupService = new SoupService();
        setTitle("Soul Soup");
        init();
    }

    @Override
    protected @Nullable
    JComponent createCenterPanel() {
        panel = new JPanel();
        String soup = soupService.getContent();
        label = new JLabel(soup != null ? soup : ERROR);
        panel.add(label);
        return panel;
    }

    @Override
    protected JComponent createSouthPanel() {
        panel = new JPanel();
        JButton ok = new JButton("I`m OK");
        ok.addActionListener(e -> {
            super.close(0);
        });
        JButton oneMore = new JButton("One more");
        oneMore.addActionListener(e -> {
            String soup = soupService.getContent();
            label.setText(soup != null ? soup : ERROR);
        });
        panel.add(ok);
        panel.add(oneMore);
        return panel;
    }
}
