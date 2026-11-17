package FileSystemDesign;

public class File implements FileSystemComponent{
    public String name;
    public Integer size;

    public File(String name, Integer size){
        this.name=name;
        this.size=size;
    }

    @Override 
    public String getName(){
        return this.name;
    }

    @Override 
    public Integer getSize(){
        return this.size;
    }

    @Override 
    public void printAll(){
        System.out.println("File name is: "+this.name);
    }
}
