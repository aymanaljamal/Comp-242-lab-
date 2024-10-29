package application;

public class oHashp_L_D_Q<A extends Comparable<A>> {

    private HNode<A>[] hashTable;
    private int size;

    public oHashp_L_D_Q(int n) {
        this.size = n * 2;
        hashTable = new HNode[this.size];
        for (int i = 0; i < this.size; i++) {
            hashTable[i] = new HNode<>(null);
        }
    }

    public void addLinear(A data) {
        int index = Math.abs(data.hashCode() % size);
        int firstIndex = index;
        if (hashTable[index].getFlag() == 'E') {
            hashTable[index].setData(data);
            hashTable[index].setFlag('F');
        } else {
            while (hashTable[index].getFlag() == 'F') {
                index = (index + 1) % size;
                if (index == firstIndex) {
                    System.out.println("Table is full");
                    return;
                }
            }
            hashTable[index].setData(data);
            hashTable[index].setFlag('F');
        }
    }

    public void addQuadratic(A data) {
        int index = Math.abs(data.hashCode() % size);
        int firstIndex = index;
        int i = 1;
        if (hashTable[index].getFlag() == 'E') {
            hashTable[index].setData(data);
            hashTable[index].setFlag('F');
        } else {
            while (hashTable[(index + i * i) % size].getFlag() == 'F') {
                index = (firstIndex + i * i) % size;
                i++;
                if (index == firstIndex) {
                    System.out.println("Table is full");
                    return;
                }
            }
            hashTable[index].setData(data);
            hashTable[index].setFlag('F');
        }
    }

    public void addDoubleHashing(A data) {
        int index = Math.abs(data.hashCode() % size);
        int stepSize = 7 - (Math.abs(data.hashCode()) % 7);
        int firstIndex = index;
        if (hashTable[index].getFlag() == 'E') {
            hashTable[index].setData(data);
            hashTable[index].setFlag('F');
        } else {
            while (hashTable[index].getFlag() == 'F') {
                index = (index + stepSize) % size;
                if (index == firstIndex) {
                    System.out.println("Table is full");
                    return;
                }
            }
            hashTable[index].setData(data);
            hashTable[index].setFlag('F');
        }
    }

    public HNode<A>[] getHashTable() {
        return hashTable;
    }

    public int getSize() {
        return size;
    }
}



