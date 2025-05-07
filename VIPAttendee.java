public class VIPAttendee extends Attendee {
    int VIPNum;

    public VIPAttendee(String n, String id, String crNum, int vipNum, boolean prevAtt, boolean isVIP){
        super(n,id,crNum,prevAtt,isVIP);
        VIPNum = vipNum;
    }

    public String toString(){
        String str = super.toString() + "VIP number: " + VIPNum;
        return str;
    }
}
