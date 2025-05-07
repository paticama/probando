public class Group extends Artist {
    //We define class Group, which inherits from Artist while having some unique characteristics.
    public boolean sellMerch;
    public int memberNum;

    public Group(String name, String genre, boolean headliner,  int capacity, int duration, double price,boolean confirmedAtt, int memberNum,boolean sellMerch) {
            super(name, genre, headliner,capacity, duration, price,  confirmedAtt);
            this.sellMerch = sellMerch;
            this.memberNum = memberNum;
        }
    
    public boolean getSellMerch(){
        return sellMerch;
    }

    public boolean getDressingRoom(){
        return false; 
    }

    @Override
    public String toString() {
        return (super.toString() + " How many members are there in the group?: " +
         memberNum +" Do they sell merchandising?: " + sellMerch);
    } 
}
