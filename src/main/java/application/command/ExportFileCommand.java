package application.command;

import application.WordsetProcessor;
import picocli.CommandLine;

@CommandLine.Command(
        name = "file"
)
public class ExportFileCommand implements Runnable {

    @CommandLine.Option(names = {"-f", "--file"}, required = true)
    private String filePath;

    @CommandLine.Option(names = {"-t", "--target"}, required = true)
    private String target;

    @CommandLine.Option(names = {"-e", "--endpoint"})
    private String endpoint;

    @CommandLine.Option(names = {"-fi", "--filter"})
    private String filter;

    @CommandLine.Option(names = {"-rf", "--requestformat"})
    private String format;

    @CommandLine.Option(names = {"-l", "--language"})
    private String language;

    @Override
    public void run() {
        WordsetProcessor processor = new WordsetProcessor();

        switch(target) {
            case "api":
                if(endpoint != null) {
                    if(filter == null) {
                        filter = "alphabetical";
                    }
                    if(format == null) {
                        format = "json";
                    }
                    if(language == null) {
                        language = "nl-nl";
                    }
                    if(processor.exportFileToApi(filePath, endpoint, filter, format, language)) {
                        System.out.println("Export succeeded.");
                    } else {
                        System.out.println("Export failed!");
                    }

                } else {
                    System.out.println("Provide endpoint for API export.");
                }
                break;
            case "file":
                // code
                break;
            default:
                System.out.println("Invalid target, available options are [api, file].");
        }
    }
}
