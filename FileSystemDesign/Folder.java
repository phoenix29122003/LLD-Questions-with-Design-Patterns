package FileSystemDesign;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent{
    public String name;
    public List<FileSystemComponent>folderComponents;

    public Folder(String name){
        this.name=name;
        this.folderComponents=new ArrayList<>();
    }

    @Override 
    public String getName(){
        return this.name;
    }

    @Override 
    public Integer getSize(){
        Integer size=0;
        for(FileSystemComponent component:folderComponents){
            size+=component.getSize();
        }
        return size;
    }

    public void addComponent(FileSystemComponent component){
        this.folderComponents.add(component);
    }

    @Override 
    public void printAll(){
        System.out.println("Folder name is: "+this.name);
        for(FileSystemComponent component:folderComponents){
            component.printAll();
        }
    }

}
