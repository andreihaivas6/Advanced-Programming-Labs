import freemarker.template.TemplateException;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ParseException, TemplateException {
//        DatabaseConnection db = new DatabaseConnection(); // -> nu se permite instantierea

        Import myImport = new Import();
//        myImport.importAll();

        ExportAsHTML myExport = new ExportAsHTML();
        myExport.exportAll();
    }
}
