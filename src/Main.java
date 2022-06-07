public class Main {
    public static void main(String[] args) {

        GrapheListe figure1 = new GrapheListe();

        figure1.ajouterArc("A", "B", 12);
        figure1.ajouterArc("B", "E", 11);
        figure1.ajouterArc("E", "D", 43);
        figure1.ajouterArc("D", "C", 10);
        figure1.ajouterArc("C", "A", 19);
        figure1.ajouterArc("A", "D", 87);
        figure1.ajouterArc("D", "B", 23);

    }
}
