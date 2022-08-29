import java.util.Arrays;
import java.util.List;

public class Generic <T>{
    private T list[];
    private T tempList[];
    private int capacity = 10;

    public Generic(){
        this.list = (T[]) new Object[capacity];
    }
    public Generic(int capacity){
        this.capacity = capacity;
        this.list = (T[]) new Object[capacity];
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public T[] getTempList() {
        return tempList;
    }

    public void setTempList(T[] tempList) {
        this.tempList = tempList;
    }

    public int size(){
        int number = 0;
        for (int i = 0; i < getCapacity(); i++) {
            if (list[i] != null){
                number++;
            }
        }
        return number;
    }
    public void add(T data){
        if (size() > getCapacity()){
            this.tempList = this.list;
            setCapacity(getCapacity() * 2);
            this.list = (T[]) new Object[getCapacity()];
            this.list = Arrays.copyOf(tempList, getCapacity());
        }
        this.list[size()] = data;
    }
    public T get(int index){
        if (index > size() || index < 0){
            return null;
        }
        return this.list[index];
    }
    public T remove (int index){
        if (size() < index || index <0){
            return null;
        }
        T[] temp = this.list;
        this.list[index] = null;
        for (int i = index; i < size(); i++) {
            if (size() - i == 1) {
                this.list[i]= null;
            }else{
                this.list[i] = temp[i +1];
            }
        }
        return this.list[index];
    }
    public T set(int index, T data){
        if(size() < index || index <0){
            return  null;
        }
        this.list[index] = data;
        return this.list[index];
    }
    public String toString(){
        return "List : " + Arrays.toString(list);
    }
    public int indexOf(T data){
        for (int i = 0; i < size(); i++) {
            if (this.list[i] == data) {
                return i;
            }
        }
        return -12;
    }
    public int lastIndexOf(T data) {
        for (int i = size(); i >= 0; i--) {
            if (this.list[i] == data) {
                return i;
            }
        }
        return -2;
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public T[] toArray(){
        return this.list;
    }
    public void clear(){
        for (int i = 0; i < this.size(); i++) {
            this.list[i]= null;
        }
    }
    public Generic<T> subList(int start ,int finish){
        Generic<T> list1  = new Generic<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            list1.add(this.list[i]);
        }
        return list1;
    }
    public boolean contains(T data) {
        for (int i = 0; i < size(); i++) {
            if (this.list[i] == data)
                return true;
        }
        return false;
    }
}
