package CounterOfElementsAndImmutableCollection;

import java.util.ArrayList;

public class CounterOfElements<T> {
    private ArrayList<Cell> cells = new ArrayList<>();

    public void count(ArrayList<T> arrayList){
        for(T value : arrayList){
            int index = indexOfCell(value);
            if(index == -1){
                cells.add(new Cell(value,1));
            } else{
                cells.get(index).incrementQuantity();
            }
        }
    }

    public int indexOfCell(T value){
        for(Cell c : cells){
            if(value.equals(c.getValue())){
                return cells.indexOf(c);
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder("{");
        cells.forEach(cell -> info.append(cell.getValue()+"="+cell.getQuantity()+" "));
        info.append("}\n");
        return info.toString();
    }
}

class Cell<T>{
    private T value;
    private int quantity;

    public Cell(T value, int quantity){
        this.value = value;
        this.quantity = quantity;
    }

    public T getValue() {
        return value;
    }
    public int getQuantity() {
        return quantity;
    }
    public void incrementQuantity(){
        quantity++;
    }
}
