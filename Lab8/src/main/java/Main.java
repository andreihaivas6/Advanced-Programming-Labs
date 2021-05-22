import bonus.ConnectionPool;
import bonus.Task;
import bonus.ThreadPool;
import freemarker.template.TemplateException;
import others.ExportAsHTML;
import others.Import;
import tables.Movie;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws SQLException, IOException, ParseException, TemplateException {
//        others.DatabaseConnection db = new others.DatabaseConnection(); // -> nu se permite instantierea

//        Import myImport = new Import();
//        myImport.importAll();
//        ExportAsHTML myExport = new ExportAsHTML();
//        myExport.exportAll();

        /*
         1 -> Singleton;    2 -> ConnectionPool

         Pentru scenariul:
            - numar taskuri: 1_000
            - numar threaduri: 10_000
            - option: 1 -> Singleton connection
         Primim exceptie.
         */
        ThreadPool.run(1, 1_000, 10_000);
//        ThreadPool.run(2, 1_000, 10_000);


//        ThreadPool.run(2, 1_000_000, 10_000);
//        ThreadPool.run(2, 100_000, 10_000);
    }
}
