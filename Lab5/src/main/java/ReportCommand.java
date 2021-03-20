import freemarker.template.Configuration;
import freemarker.template.Template;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportCommand extends Command {
    public ReportCommand(List<String> arguments) {
        super(arguments);
    }

    @Override
    public void tryArguments() {
        if (super.getArguments().size() != 0) {
            throw new IllegalArgumentException("Argumente gresite");
        }
    }

    @Override
    public void run(Catalog catalog) throws Exception {
        Map<String, Object> data = new HashMap<>();
        data.put("nume", catalog.getName());
        data.put("items", catalog.getItems());

        Configuration config = new Configuration();
        Template template = config.getTemplate("catalog.ftl");

        File outputHtml = new File("catalog.html");
        Writer file = new FileWriter(outputHtml);
        template.process(data, file);
        file.flush();
        file.close();

        if(!Desktop.isDesktopSupported()) {
            throw new RuntimeException("Desktop nu este suportat de sistem.");
        }
        Desktop.getDesktop().open(outputHtml);
    }
}
