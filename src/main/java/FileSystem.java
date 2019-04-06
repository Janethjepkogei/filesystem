import java.util.Scanner;

public class FileSystem {

    static Folder currentDir, rootDirectory;

    public static void main(String[] args) {

            try {
                rootDirectory = new Folder();
                currentDir = rootDirectory;
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
            System.out.println("Problem 5 by team X");
            parseInput();
    }

    private static void parseInput() {

        Scanner scn = new Scanner(System.in);

        String input = scn.nextLine();

        if(!input.equals("exit")){
            processInput(input);
            parseInput();
        }
    }

    private static void processInput(final String input) {
        System.out.println("Command: " + input);
        String [] inputParts = input.split(" ");

        switch(inputParts[0]) {
            case "dir":
                ProcessInputCommands.dirCommand(currentDir);
                break;
            case "cd":
               currentDir = ProcessInputCommands.cdCommand(inputParts, currentDir, rootDirectory);
                break;
            case "mkdir":
                ProcessInputCommands.mkdirCommand(inputParts, currentDir);
                break;
            case "up":
                currentDir = ProcessInputCommands.upCommand(currentDir);
                break;
            default:
                System.out.println("Invalid command: "+ input);
        }
    }


}

