public class CamelNode {
    private CamelNode next;
    private Camel camel;

    public CamelNode(CamelNode next, Camel camel) {
        this.next = next;
        this.camel = camel;
    }

    public void setNext(CamelNode next) {
        this.next = next;
    }

    public void setCamel(Camel camel) {
        this.camel = camel;
    }

    public CamelNode getNext() {
        return next;
    }

    public Camel getCamel() {
        return camel;
    }
}
