public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count] = item;
        count++;
    }
    public void insertAt(int index, int item){
        // validate the index
        if(index<0 || index > count)
            throw new IllegalArgumentException();
        if(count == items.length){
            int[] newItems = new int[count * 2];
            for(int i = 0; i < count; i++){
                newItems[i] = items[i];
            }
            items = newItems;
        }
        for(int i = count - 1; i >= index; i--){  // 1,  3,  5  index : 1 item: 4
            items[i + 1] = items[i];
        }
        // insert the new item at the given index
        items[index] = item;
        count++;

    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count - 1; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int number) {
        for (int i = 0; i < count; i++) {
            if (items[i] == number) return i;
        }
        return -1;
    }

    public int max() {
        int max = items[0];
        for (int i = 1; i < items.length; i++) {
            if (items[i] > max) {
                max = items[i];
            }
        }
        return max;
    }

    public Array intersect(Array other) {
        Array result = new Array(count);
        for (int i = 0; i < count; i++) {
            int currentItem = items[i];
            if (other.indexOf(currentItem) != -1 && result.indexOf(currentItem) == -1) {
                result.insert(currentItem);
            }
        }
        return result;
    }

    public void reverse(){
        int temp ;
        for (int i = 0; i < count/2; i++) { // 1 3 5
            temp = items[i];
            items[i] = items[count-1-i];
            items[count-1-i] = temp;
        }
    }

}


