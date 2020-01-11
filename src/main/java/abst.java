abstract class Wrestler {

    public void paymentForWork (int hours) {
       System.out.println("The wrestler will make $"+hours*250.00);
    }
    public abstract void themeMusic();
    public abstract void finisher();
}

class Kane extends Wrestler{

    @Override
    public void themeMusic() {
        System.out.println("Kane's Intro music...");
    }
    @Override
    public void finisher() {
        System.out.println("Kane's finishing TombStone...");
    }
}
public class abst {
	public static void main (String [] args) {
        Wrestler wrestler1= new Kane();

        wrestler1.themeMusic();
        wrestler1.paymentForWork(5);
        wrestler1.finisher();
    }

}
