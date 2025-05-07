public abstract class Artist {
    // Here we define the Artists class, it is an abstract class as we won't have artists per se, 
    // as they will either be Solists or Groups

    String name,genre;
    boolean headliner,confirmedAtt;
    int capacity, duration;
    double price;

    public Artist(String name, String genre, boolean headliner, int capacity, int duration, double price,  boolean confirmedAtt){
        this.name = name;
        this.genre = genre;
        this.headliner = headliner;
        this.confirmedAtt = confirmedAtt;
        this.capacity = capacity;
        this.duration = duration;
        this.price = price;
    }

    public abstract boolean getSellMerch();
    public abstract boolean getDressingRoom();
    //There are more methods unique to groups and solists, however, we have only implemented these two 
    // as they are the ones we'll use (for example, it makes no sense to call Artist.setSellMerch)

    public int getCapacity() {
        return capacity;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public boolean getConfirmedAtt(){
        return confirmedAtt;
    }
    public boolean getHeadliner() { 
        return headliner;
    }
    public String toString(){
        String str = "Name: " + name + " Genre: " + genre + " Is a headliner?: " + 
        headliner + " Has confirmed assistance: " + confirmedAtt + 
        " Capacity for the concert: " + capacity + " Duration of the concert: " +
        duration + " Price: " + price + " ";
        return (str);
    }
}
