import java.util.ArrayList;

public class Folder {
    private String name;
    private boolean isRoot;
    private Folder parent;
    private ArrayList<Folder> children;

    public Folder(final String name, final Folder parent){
        this.name = name;
        this.isRoot = false;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Folder() {
        this.name = "root";
        this.parent = null;
        this.isRoot = true;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public Folder getParent() {
        return parent;
    }

    public ArrayList<Folder> getChildren() {
        return children;
    }

    public void addChild(Folder folder){
        if (isChildPresent(folder.getName())){
            System.out.println("Subdirectory already exists");
            return;
        }

        this.children.add(folder);
    }

    public boolean isChildPresent(final String name){
        if (this.children != null && !this.children.isEmpty()) {
            for (Folder childNode : this.children) {
                if (childNode.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Folder getChild(String name) {
        if (this.children != null && !this.children.isEmpty()) {
            for (Folder childNode : this.children) {
                if (childNode.getName().equals(name))
                    return childNode;
            }
        }
        System.out.println("Subdirectory does not exist");
        return null;
    }

    public void printChildren(){

        if (children != null && !children.isEmpty()) {

            for (int i = 0; i < children.size(); i++) {
                if ((i + 1) % 10 == 0 && i != 0) {
                    System.out.print(children.get(i).getName() + "\n");
                } else {
                    System.out.print(children.get(i).getName() + " ");
                }
            }

            return;
        }
        System.out.println("Subdirectory does not exist");
    }
}
