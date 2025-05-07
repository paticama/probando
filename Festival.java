
public class Festival {
    String name, city; 
    Artist[] artistList;
    Attendee[] atendeeList;
    SecurityCompany sec;
    
    public Festival(String n, String c, Artist[] arList, Attendee[] attList){
        this.name = n;
        this.city = c;
        this.artistList = arList;
        this.atendeeList = attList;
    }

    public Artist[] getArtList(){
        return artistList;
    }

    public Attendee[] getAttendeeList(){
        return atendeeList;
    }

    public String showAllArtistInfo(Artist[] art){
        String str = "";
        for (int i = 0; i < art.length; i++) {
            str += (art[i].toString() + "\n"); 
        }
        return str;
    }

    public double calculateSecurityCost(Artist[] art, SecurityCompany sec){
        int assistance = 0;
        int numSec = 0;
        double price;
        //By every iteration of the for, we get the capacity of each artist and then we get to calculate every cost for the security company
        for (int i = 0; i < art.length; i++) {
            assistance += art[i].getCapacity(); 
            if (art[i].getSellMerch()){
                numSec += 2;
            }
            else if (art[i].getDressingRoom()){ 
                numSec += 1;
            }
        }
        numSec += assistance*1000/500;
        
        price = numSec * sec.getCharge();
        return price;
    }

    public boolean checkRegistedAttendee(String attId, Attendee[] att){
        boolean nameReal = false;

        for (int i = 0; i < att.length; i++) {
            if (attId.equalsIgnoreCase(att[i].getId())){
                nameReal = true;
            }
        }
        return nameReal;
    }

    public boolean checkRealArtist(String wantToAttend, Artist[] art){
        boolean nameReal = false;

        for (int i = 0; i < art.length; i++) {
            if (wantToAttend.equalsIgnoreCase(art[i].getName())){
                nameReal = true;
            }
        }
        return nameReal;
    }


    public double[] calcPrice(Attendee[] att, Artist[] art, String artName, String attId){  
        double priceArt = 0;
        double toDiscount = 0;
        double finalPrice = 0;
        double[] toReturn = new double[3];
        //we get the position of atist and attendee array 
        int c = attPosition(att, attId);
        int d = artPosition(art, artName);
        //we apply the discounts
        priceArt = art[d].getPrice();
        if (att[c].getPrevAtt() == true) {
            toDiscount += iConstants.TICKETPREVATTENDEDISCOUNT;
        }
        if (att[c] instanceof VIPAttendee) {
            toDiscount += iConstants.TICKETVIP;
        }
         
        finalPrice = priceArt  * (1-toDiscount);

        toReturn[0] = priceArt;
        toReturn[1] = toDiscount;
        toReturn[2] = finalPrice;
        return toReturn;
    }

    public double estimateMoney(Artist[] art, String att){
        double expectedSpentTickets = 0;
        double expectedSpentTShirts = 0;
        //we get the position of the array and the calculate the tshirts and the discounts for the attendee which ID was given
        int c = attPosition(atendeeList, att);
        for (int i = 0; i < art.length; i++) {
            if (art[i].getConfirmedAtt() && art[i].getHeadliner()){ 
                expectedSpentTickets += calcPrice(atendeeList, art, art[i].getName(), att)[2];
                System.out.println("Artist: " + art[i].getName() + " Ticket" + calcPrice(atendeeList, art, art[i].getName(), att)[2]);
            } 
            if (art[i].getSellMerch() && art[i].getConfirmedAtt()){
                if(atendeeList[c].getPrevAtt()){
                    System.out.println("Artist: " + art[i].getName() + " TShirt" +  iConstants.TSHIRTPRICE * (1 - iConstants.MERCHANDISCOUNTS));
                    expectedSpentTShirts += iConstants.TSHIRTPRICE * (1 - iConstants.MERCHANDISCOUNTS);
                } else {
                    System.out.println("Artist: " + art[i].getName() + " TShirt" + iConstants.TSHIRTPRICE * (1 - iConstants.MERCHANDISCOUNTS));
                    expectedSpentTShirts += iConstants.TSHIRTPRICE;
                }
            }
        }

        return expectedSpentTickets + expectedSpentTShirts;
    }

    public String showInfoTicket(String attId, Attendee[] att){
        int pos = 0; 
        String str = "";

        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)){
                pos = i;
            }
        }
        for(int i = 0; i < att[pos].ticketList.length; i++){
            if (att[pos].ticketList[i] != null) {
                str += (att[pos].ticketList[i].toString());
            }
        }
        return str;
    }

    public String showInfoConcerts(Attendee[] att){
        String str = "";

        for (int i = 0; i < att.length; i++) {
            for (int j = 0; j < att[i].ticketList.length; j++){
                if (att[i] instanceof VIPAttendee && att[i].ticketList[j] != null ){
                    if(att[i].ticketList[j].forWho.getSellMerch()){
                        str += att[i].ticketList[j].forWho.toString();
                    }
                }
            }
        }
        return str;
    }

    public static int attPosition(Attendee[] att, String attId){
        int c = 0;
        for (int i = 0; i < att.length; i++) {
            if (att[i].getId().equalsIgnoreCase(attId)){
                c = i;
            }
        } 
        return c;
    }

    public static int artPosition(Artist[] art, String name){
        int c = 0;
        for (int i = 0; i < art.length; i++) {
            if (art[i].getName().equalsIgnoreCase(name)){
                c = i;
            }
        } 
        return c;
    }

    public boolean buyTicket(Attendee att, Artist art){
        boolean ticketBought = false;

        for (int i = 0; i < iConstants.TICKETS; i++) {
            if (!ticketBought && att.ticketList[i] == null){
                int randomNum = (int)(Math.random() * 1001); //Asked about the random ID. Told it was OK
                //Generate a new ticket object
                att.ticketList[i] = new Ticket(randomNum, art); 
                ticketBought = true;  
            } 
        }
        return  ticketBought;
    }

}    
