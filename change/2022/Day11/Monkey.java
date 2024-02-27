import java.util.ArrayList;

public class Monkey {
    private String name;
    private ArrayList<Integer> items;
    private String operation;
    private String test;
    private String ifTrue;
    private String ifFalse;
    private int itemsSeen; 

    public Monkey(String name, ArrayList<Integer> items, String operation, String test, String ifTrue, String ifFalse) {
        this.name = name;
        this.items = items;
        this.operation = operation;
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.itemsSeen = 0;
    }
    public Monkey(){

    }

    public void addItem(Integer item){
        this.items.add(item);
    }
    
    public String print(){
        return "\nNew Monkey\nName: "+this.name+"\nItems: "+this.items+"\nOperation: "+this.operation+"\nTest: "+this.test+"\nIfTrue: "+this.ifTrue+"\nIfFalse: "+this.ifFalse;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }

    public String getOperation() {
        return this.operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getTest() {
        return this.test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getIfTrue() {
        return this.ifTrue;
    }

    public void setIfTrue(String ifTrue) {
        this.ifTrue = ifTrue;
    }

    public String getIfFalse() {
        return this.ifFalse;
    }

    public void setIfFalse(String ifFalse) {
        this.ifFalse = ifFalse;
    }

    public int getItemsSeen() {
        return this.itemsSeen;
    }

    public void setItemsSeen(int itemsSeen) {
        this.itemsSeen = itemsSeen;
    }

    public void addItemsSeen(){
        this.itemsSeen++;
    }
}
