import java.util.ArrayList;

public class Implementation {

    static class Heap {
        ArrayList<Integer> data;

        public Heap() {
            data = new ArrayList<>();
        }

        // add
        public void add(int val) {
            data.add(val);

            upHeapify(data.size() - 1);
        }

        private void upHeapify(int currentIndex) {
            int parentIndex = (currentIndex - 1) / 2;

            if (parentIndex >= 0 && data.get(parentIndex) > data.get(currentIndex)) {
                swap(parentIndex, currentIndex);
                upHeapify(parentIndex);
            }
        }

        private void swap(int parentIndex, int currentIndex) {
            int valAtCurrentIndex = data.get(currentIndex);
            int valAtParentIndex = data.get(parentIndex);

            data.set(currentIndex, valAtParentIndex);
            data.set(parentIndex, valAtCurrentIndex);
        }

//        peek
        public int peek() {
            if (data.size() == 0) {
                System.out.println("There is no element in the heap");
                return -1;
            }

            return data.get(0);
        }

//        remove
        public int remove() {
            if (data.size() == 0) {
                System.out.println("There is no element in the heap");
                return -1;
            }

            swap(0, data.size() - 1);
            int removedVal = data.remove(data.size() - 1);

            downHeapify(0);

            return removedVal;
        }

        private void downHeapify(int parentIndex) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;

            int minIndex = parentIndex;

            if (leftChildIndex < data.size() && data.get(leftChildIndex) < data.get(minIndex)) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < data.size() && data.get(rightChildIndex) < data.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            if (minIndex != parentIndex) {
                swap(parentIndex, minIndex);
                downHeapify(minIndex);
            }

        }

        //        size
        public int size() {
            return data.size();
        }
    }

    public static void main(String[] args) {
        Heap minPQ = new Heap();

        System.out.println(minPQ.size());
    }
}
