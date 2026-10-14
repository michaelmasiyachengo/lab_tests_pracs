package lab1;

public class PersonDemo {
    public static void main(String[] args) {
        // Person WITH an address
        Address home = new Address();
        home.street = "12 Main Street";
        home.city = "Harare";

        Person tariro = new Person();
        tariro.name = "Tariro";
        tariro.address = home;

        // Chained dot: person -> address -> city
        System.out.println(tariro.name + " lives in " + tariro.address.city);

        // Person WITHOUT an address: the address field is still null
        Person farai = new Person();
        farai.name = "Farai";

        // 1) What goes wrong: using a null reference throws NullPointerException
        try {
            System.out.println(farai.name + " lives in " + farai.address.city);
        } catch (NullPointerException e) {
            System.out.println("Oops! " + farai.name + " has no address, so address.city crashed: NullPointerException");
        }

        // 2) The safe way: check for null first
        if (farai.address == null) {
            System.out.println(farai.name + " has no address on record.");
        } else {
            System.out.println(farai.name + " lives in " + farai.address.city);
        }
    }
}
