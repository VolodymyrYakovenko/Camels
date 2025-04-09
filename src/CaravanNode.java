public class CaravanNode {
    private final Camel camel;
    private CaravanNode next;

    public CaravanNode(Camel camel){
        this.camel = camel;
    }

//    public void setCamel(Camel camel){
//        this.camel = camel;
//    }

    public Camel getCamel(){
        return this.camel;
    }

    public void setNext(CaravanNode next){
        this.next = next;
    }

    public CaravanNode getNext(){
        return this.next;
    }
}
