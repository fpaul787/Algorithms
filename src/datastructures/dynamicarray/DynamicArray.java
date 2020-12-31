/**
 * A generic implementation of dynamic array
 */
@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int len = 0; // length user thinks
    private int capacity = 0; // actual size of array

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T get(int index) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public void set(int index, T elem) {
        if (index >= len || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < len; i++) {
            array[i] = null;
        }
        len = 0;
    }

    public void add(T elem) {

        // resize
        if (len + 1 >= capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2; // double the size
            }
            T[] new_array = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                new_array[i] = array[i];
            }
            array = new_array;
        }

        array[len++] = elem;
    }

    public T removeAt(int rm_index) {
        if (rm_index >= len || rm_index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T data = array[rm_index];
        T[] new_array = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (i == rm_index) {
                j--;
            } else {
                new_array[j] = array[i];
            }
        }
        array = new_array;
        capacity = --len;
        return data;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < len; i++) {
            if (obj == null) {
                if (array[i] == null) {
                    return i;
                }
            } else {
                if (obj.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(array[i] + ", ");
            }
            return sb.append(array[len - 1] + "]").toString();
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello World");
        DynamicArray<Integer> array = new DynamicArray<Integer>(5);
        array.add(10);
        array.add(12);
        array.add(35);
        array.add(17);
        System.out.println(array);
    }
}