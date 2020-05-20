package application.command;

import picocli.CommandLine;

@CommandLine.Command(
        name = "Wordset-Export",
        description = "Exports a wordset from a file",
        subcommands = {
                ExportFileCommand.class
        }
)
public class ExportCommand implements Runnable{

    public static void main(String[] args) {
        CommandLine.run(new ExportCommand(), System.err, args);
    }

    @Override
    public void run() {
        System.out.println("Please use one of the subcommands.");
    }
}
