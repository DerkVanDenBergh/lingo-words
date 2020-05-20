package application;

import domain.*;
import infrastructure.source.FileWordsetSource;
import infrastructure.target.ApiWordsetTarget;

public class WordsetProcessor {

    public boolean exportFileToApi(String fileName, String endPoint, String filter, String format, String language) {
        WordsetSource source = new FileWordsetSource(fileName, filter, language);

        WordsetTarget target = new ApiWordsetTarget(endPoint, format);

        return(exportWordset(source, target));
    }

    public boolean exportWordset(WordsetSource source, WordsetTarget target) {
        try {
            target.export(source.importSet());
        } catch(Exception e) {
            System.out.println(e.toString());
            return(false);
        }
        return(true);
    }
}
