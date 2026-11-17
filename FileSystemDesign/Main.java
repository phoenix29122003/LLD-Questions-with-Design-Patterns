package FileSystemDesign;

public class Main {
    public static void main(String args[]){
        File file1=new File("File1", 1);
        File file2=new File("File2", 2);
        File file3=new File("File3", 3);

        Folder folder1=new Folder("Folder1");
        Folder folder2=new Folder("Folder2");

        folder2.addComponent(file2);
        folder2.addComponent(file3);

        folder1.addComponent(folder2);
        folder1.addComponent(file1);

        System.out.println(folder1.getSize());
        folder1.printAll();
    }
}
