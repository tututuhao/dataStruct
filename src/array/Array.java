package array;

public class Array<E> {
    private E[] data;
    private  int size;

    public Array(int capacity){
       data= (E[]) new Object[capacity];
       size=0;
    }

    public Array(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void addLast(E e){
        if(size==data.length){
            relase(2*data.length);
        }

        data[size]=e;
        size++;
    }
   public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }
    public void addFirst(E e){
        add(0,e);
    }

    public void add(int index,E e){


        if(index<0||index>size){
            throw new IllegalArgumentException(("AddLast failed. Require index>=0 and index<=size"));
        }

        if(size==data.length)
            relase(2*data.length);

        for(int i=size-1;i>=index;i--){
            data[i+1]=data[i];

            data[index]=e;

            size++;
        }
    }

    public E get(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Get fail. Index is illega");
        }
        return data[index];
    }

    public void set(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("Set fail. Index is illega");
        }
        data[index]=e;
    }

    public boolean contain(E e){
        for(int i=0;i<size;i++){
           if( e==data[i]){
               return true;
           }
        }
        return false;
    }

    public int find(E e){
        for(int i=0;i<size;i++){
            if( e==data[i]){
                return i;
            }
        }
        return -1;
    }

    public E remove(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("Remove failed. Index is illega ");
        }
        E ret=data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        if(size==data.length/4&&data.length/4!=0)
            relase(data.length/2);
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E  removeLast(){
        return remove(size-1);
    }

    public void removeElement(E e){
           int index=find(e);
           if(index!=-1){
               remove(index);
           }
    }

    public void relase(int capacity){
         E[] newDate= (E[])new Object[capacity];
         for(int i=0;i<size;i++){
             newDate[i]=data[i];
         }
         data=newDate;
    }
    @Override
    public String toString(){
          StringBuilder stringBuilder=new StringBuilder();
          stringBuilder.append(String.format("Array:size = %d,capacity= %d\n",size,data.length));
          stringBuilder.append("[");
          for(int i=0;i<size;i++){
              stringBuilder.append(data[i]);
              if(i!=size-1)
                  stringBuilder.append(",");
          }
          stringBuilder.append("]");
          return stringBuilder.toString();
    }
}
