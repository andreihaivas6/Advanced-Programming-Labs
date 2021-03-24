import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class InfoCommand extends Command {
    public InfoCommand(List<String> arguments) {
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
        int index1 = 1;
        for (Item item : catalog.getItems()) {
            File file = new File(item.getPath());
            Metadata metadata = new Metadata();

            Parser parser = new AutoDetectParser();
            parser.parse(new FileInputStream(file), new BodyContentHandler(), metadata, new ParseContext());

            int index2 = 1;
            System.out.println("Itemul " + index1++);
            for (String metadaName : metadata.names()) {
                System.out.println(index2++ + ". " + metadaName + " -> " + metadata.get(metadaName));
            }
        }
    }
}
