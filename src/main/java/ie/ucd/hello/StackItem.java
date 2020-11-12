package ie.ucd.hello;


public class StackItem {
    private String item;

    public StackItem(String item) {
        this.item = item;
    }

    public StackItem() {}
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }  
}