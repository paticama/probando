public class Ticket{
    int id;
    Artist forWho;

    public Ticket(int id, Artist art){
        this.id = id;
        this.forWho = art;
    }

    public int getId(){
        return id;
    }
 
    public String toString(){
        String str = "Ticket ID: " + id + "Artist info: " + forWho.toString();
        return str;
    }

}
