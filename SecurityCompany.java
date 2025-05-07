public class SecurityCompany {
    //we declare the values for our class, being the cost that the company implies and the name of the company
    public double charge;
    public String name;
    
    //we need the constructor for the object security company
    public SecurityCompany(String name, double charge){
        this.name = name;
        this.charge = charge;
    }

    //getter of charge
    public double getCharge() {
        return charge;
    }
}
