import java.util.*;

/**
 * Користувацька реалізація однозв'язного списку, що підтримує узагальнені типи.
 * 
 * @param <E> тип елементів, що зберігаються в цій колекції
 */
public class CustomLinkedList<E> implements List<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private int size;

    /**
     * Конструктор за замовчуванням. Ініціалізує порожній список.
     */
    public CustomLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Конструктор, що створює список з одним елементом.
     * 
     * @param element елемент, який додається до списку
     */
    public CustomLinkedList(E element) {
        this();
        add(element);
    }

    /**
     * Конструктор, що створює список, містить усі елементи вказаної колекції.
     * 
     * @param collection колекція, елементи якої додаються до списку
     */
    public CustomLinkedList(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    /**
     * Повертає ітератор для проходження елементів списку в правильному порядку.
     * 
     * @return ітератор для елементів списку
     */
    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    /**
     * Внутрішній ітератор для обходу елементів списку.
     */
    private class CustomIterator implements Iterator<E> {
        private Node<E> current = head;

        /**
         * Перевіряє, чи є наступний елемент у списку.
         * 
         * @return true, якщо наступний елемент існує, false в іншому випадку
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Повертає наступний елемент у списку.
         * 
         * @return наступний елемент
         * @throws NoSuchElementException якщо більше немає елементів
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }

    /**
     * Повертає кількість елементів у списку.
     * 
     * @return кількість елементів у списку
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Перевіряє, чи список порожній.
     * 
     * @return true, якщо список не містить елементів, інакше false
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Додає елемент у кінець списку.
     * 
     * @param e елемент, який додається
     * @return true (як вказано в {@link Collection#add})
     */
    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Повертає елемент за вказаним індексом у списку.
     * 
     * @param index індекс елемента, який потрібно повернути
     * @return елемент за вказаним індексом у списку
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі
     */
    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Видаляє елемент за вказаним індексом у списку.
     * 
     * @param index індекс елемента, який потрібно видалити
     * @return елемент, який був видалений зі списку
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі
     */
    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedData;

        if (index == 0) {
            removedData = head.data;
            head = head.next;
        } else {
            Node<E> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
        }
        size--;
        return removedData;
    }

    /**
     * Додає всі елементи вказаної колекції до списку.
     * 
     * @param c колекція, що містить елементи для додавання
     * @return true, якщо список змінився внаслідок виклику методу
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E e : c) {
            add(e);
        }
        return true;
    }

    /**
     * Додає всі елементи вказаної колекції до списку, починаючи з вказаного індексу.
     * 
     * @param index позиція, з якої слід почати додавання
     * @param c колекція, що містить елементи для додавання
     * @return true, якщо список змінився внаслідок виклику методу
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі діапазону
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndexForAdd(index);
        for (E e : c) {
            add(index++, e);
        }
        return true;
    }

    /**
     * Перевіряє, чи список містить вказаний елемент.
     * 
     * @param o елемент, наявність якого перевіряється у списку
     * @return true, якщо список містить вказаний елемент
     */
    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if ((o == null && current.data == null) || (o != null && o.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    
    /**
     * Перевіряє, чи вказаний індекс є коректним для отримання елементів.
     * 
     * @param index індекс для перевірки
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Перевіряє, чи вказаний індекс є коректним для додавання елементів.
     * 
     * @param index індекс для перевірки
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * Повертає рядкове представлення цього списку.
     * 
     * @return рядкове представлення цього списку
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    
    @Override public void clear() { head = null; size = 0; }
    @Override public boolean containsAll(Collection<?> c) { return false; }
    @Override public boolean remove(Object o) { return false; }
    @Override public boolean removeAll(Collection<?> c) { return false; }
    @Override public boolean retainAll(Collection<?> c) { return false; }
    @Override public E set(int index, E element) { throw new UnsupportedOperationException(); }
    @Override public void add(int index, E element) { throw new UnsupportedOperationException(); }
    @Override public int indexOf(Object o) { return -1; }
    @Override public int lastIndexOf(Object o) { return -1; }
    @Override public ListIterator<E> listIterator() { throw new UnsupportedOperationException(); }
    @Override public ListIterator<E> listIterator(int index) { throw new UnsupportedOperationException(); }
    @Override public List<E> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
    @Override public Object[] toArray() { return new Object[0]; }
    @Override public <T> T[] toArray(T[] a) { return null; }

}
