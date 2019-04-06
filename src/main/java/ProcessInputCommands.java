public class ProcessInputCommands {

    public static Folder upCommand(Folder currentDir) {
        if(currentDir.isRoot()){
            System.out.println("Cannot move up from root directory");
        }
        else{
            currentDir = currentDir.getParent();
        }
        return currentDir;
    }

    public static Folder cdCommand(String[] inputParts, Folder currentDir, Folder rootDirectory) {
        if(inputParts.length == 1){
            System.out.println("Invalid command. Please enter command and folder name");
        }
        else{
            try{
                if(!currentDir.isChildPresent(inputParts[1]) && !inputParts[1].equals("/") && !inputParts[1].equals("..")){
                    System.out.println("Subdirectory does not exist");
                }
                else {
                    switch (inputParts[1]) {
                        case "/":
                            if(currentDir.getParent() == null){
                                System.out.println("You are on the root folder");
                            }
                            else {
                                currentDir = rootDirectory;
                            }
                            break;
                        case "..":
                            if(currentDir.getParent() == null){
                                System.out.println("You are on the root folder, no parent folder");
                            }
                            else{
                                currentDir = currentDir.getParent();
                            }
                            break;
                        default:
                            currentDir = currentDir.getChild(inputParts[1]);
                            break;
                    }
                }

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return currentDir;
    }

    public static void dirCommand( Folder currentDir) {
        String path = getPath(currentDir);
        System.out.println("Directory of " + path + ":");
        try{
            currentDir.printChildren();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void mkdirCommand(String[] inputParts, Folder currentDir) {
        if (inputParts.length == 1) {
            System.out.println("Invalid mkdir command. Enter directory name.");
        }else {
            try {
                currentDir.addChild(new Folder(inputParts[1], currentDir));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String getPath(Folder dir) {
        String path = dir.getName();
        dir = dir.getParent();
        while (dir != null) {
            path = dir.getName() + "\\" + path;
            dir = dir.getParent();
        }
        return path;
    }
}
