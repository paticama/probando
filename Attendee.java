public class Attendee{
    String name, id, creditNum; 
    boolean prevAtt, isVIP;
    
    Ticket[] ticketList = new Ticket[iConstants.TICKETS - 1];

    public Attendee(String n, String i, String cred, boolean prev, boolean vip){
        this.name = n;
        this.id = i;
        this.creditNum = cred;
        this.isVIP = vip;
        this.prevAtt = prev;
    }

    public String getId(){
        return id;
    }

    public boolean getPrevAtt(){
        return prevAtt;
    }

    public Ticket[] getTicketList(){
        return ticketList;
    }

    @Override
    public String toString(){
        String str = "Name: " + name + " ID: " + id + " Credit card number: " +
        creditNum + " Has previously attended?: " + prevAtt + 
        "Is a VIP Attendee?: " + isVIP;
        return str;
    }  
}

