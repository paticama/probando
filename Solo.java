public class Solo extends Artist {

    boolean dressingRoom;
    int managerNum;

    public Solo(String name, String genre, boolean headliner,  int capacity, int duration, double price,boolean confirmedAtt, boolean dressingRoom, int managerNum) {
            super(name, genre, headliner, capacity, duration, price, confirmedAtt);
            this.dressingRoom = dressingRoom;
            this.managerNum = managerNum;
    }

    public boolean hasStand() {
        return false;
    }

    public boolean getDressingRoom(){
        return dressingRoom;
    }

    public boolean getSellMerch(){
        return false; 
    }

    @Override
    public String toString() {
        return (super.toString() + "Do they need a dressing room?: " + dressingRoom + " Manager phone number: " + managerNum);
    }
}

