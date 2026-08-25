class MyCircularDeque {

    private int[] deque;
    private int front;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        deque = new int[k];
        capacity = k;
        front = 0;
        size = 0;
    }

    // Add an item at the front
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (!isEmpty()) {
            front = (front - 1 + capacity) % capacity;
        }

        deque[front] = value;
        size++;

        return true;
    }

    // Add an item at the rear
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        int rear = (front + size) % capacity;
        deque[rear] = value;
        size++;

        return true;
    }

    // Delete an item from the front
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;
        size--;

        return true;
    }

    // Delete an item from the rear
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        size--;

        return true;
    }

    // Get front item
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }

        return deque[front];
    }

    // Get rear item
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }

        int rear = (front + size - 1) % capacity;
        return deque[rear];
    }

    // Check empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check full
    public boolean isFull() {
        return size == capacity;
    }
}
