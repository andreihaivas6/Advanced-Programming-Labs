import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportAsHTML {

    private Connection conn = DatabaseConnection.makeConnection();

    public ExportAsHTML() throws SQLException { }

    public void exportAll() throws IOException, TemplateException, SQLException {
        Map<String, Object> data = new HashMap<>();
        data.put("items1", selectAll("MOVIES", 5));
        data.put("items2", selectAll("PERSONS", 4));
        data.put("items3", selectAll("GENRES", 2));

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

    public List<String> selectAll(String table, int numarColoane) throws SQLException {
        String sql = "SELECT * FROM ";
        sql += table + " WHERE id <= 10 ORDER BY id";
        Statement statement = conn.createStatement();

//        statement.setString(1, table);?
        System.out.println(sql);
        ResultSet result = statement.executeQuery(sql);

        List<String> returnList = new ArrayList<>();
        while(result.next()) {
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= numarColoane; i++) {
                row.append(result.getString(i)).append(", ");
            }
            returnList.add(row.toString());
        }
        return returnList;
    }
}
