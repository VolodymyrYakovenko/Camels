
/**
 * A caravan of camels implemented as a singly linked list with entries of 'Camel'.
 * There are no 'null' entries in the list.
 */
//
// TODO: define further classes and methods for the implementation of the singly linked list,
//  if needed. Do NOT use the Java-Collection framework in your implementation.
//
public class Caravan {

    //TODO: declare variables.
    private CamelNode tail;
    private CamelNode head;
    private int size;

    /**
     * Initializes this caravan as an empty list.
     */
    public Caravan() {
        head = tail = null;
        size = 0;
    }

    /**
     * Adds 'camel' as the last camel to the end of this caravan.
     * @param camel the camel to be added to the end of this caravan, camel != null.
     */
    public void addLast(Camel camel) {
        size++;
        CamelNode node = new CamelNode(null, camel);
        if(head == null) {
            tail = head = node;
            return;
        }
        tail.setNext(node);
        tail = tail.getNext();
    }

    /**
     * Inserts a new camel into this caravan. Seen from the head of the caravan, the camel is
     * inserted just before the first camel in the caravan that has the same strength as the
     * specified 'searchStrength'. If no such camel is found, the new camel is added as the head
     * of the caravan.
     * @param searchStrength the strength of the camel to be found in the caravan.
     * @param camel the camel to be inserted into the caravan, camel != null.
     */
    public void insertBefore(int searchStrength, Camel camel) {
        if(head == null || tail == null) {
            head = tail = new CamelNode(null, camel);
            size++;
            return;
        }

        CamelNode pointer = head;
        boolean found = false;

        for (int i = 0; i < size-1; i++) {
            if(pointer.getNext().getCamel().getStrength() == searchStrength) {
                found = true;
                break;
            }
            pointer = pointer.getNext();
        }
        if(found){
            CamelNode old = pointer.getNext();
            pointer.setNext(new CamelNode(old, camel));
        } else {
            head = new CamelNode(head, camel);
        }
        size++;
    }

    /**
     * Removes 'number' camels from the front of the caravan (the first 'number'
     * camels seen from the head of the caravan) and returns them as a new caravan in which they
     * have the same order as they had in 'this' (see examples in 'ApplicationTest1.java'). If this
     * caravan is empty (this.size() == 0) or number == 0 then the result is a new empty caravan.
     * Precondition:
     * @param number the number of camels to be removed from the front of this caravan,
     *               number >= 0 && number <= this.size().
     * @return the detached caravan.
     */
    public Caravan detachFront(int number) {

        if(number == 0 || size == 0) return new Caravan();

        Caravan caravan = new Caravan();

        for (int i = 0; i < number; i++) {
            Camel camel = head.getCamel();
            caravan.addLast(camel);
            size--;
            head = head.getNext();
        }

        return caravan;
    }

    /**
     * Returns the number of camels in the caravan.
     * @return the number of camels in the caravan.
     */
    public int size() {
        return size;
    }

    /**
     * Returns a string representation of this caravan with all its camels in brackets
     * in corresponding order with head of the caravan on the left,
     * followed by the pace of the caravan, which corresponds to the pace of
     * the slowest camel in the caravan.
     * Example: [(10-2=8), (5-2=3), (7-3=4), (10-3=7)] pace = 3
     * Returns "[]" if the caravan is empty.
     * @return the string representation of this caravan.
     */
    public String toString() {

        if(size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        CamelNode pointer = head;
        int pace = Integer.MAX_VALUE;
        for (int i = 0; i < size && pointer!=null; i++) {
            int strength = pointer.getCamel().getStrength();
            int load = pointer.getCamel().getLoad();
            int pace_local = strength-load;
            if(pace > pace_local) pace = pace_local;
            sb.append(pointer.getCamel().toString());
            if(i!=size-1){
                sb.append(", ");
            }
            pointer = pointer.getNext();

        }
        sb.append("] pace = ").append(pace);

        return sb.toString();
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
