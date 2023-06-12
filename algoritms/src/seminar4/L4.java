package seminar4;

public class L4 {
    public static void main(String[] args) {

        Mapa <Integer, String> mapa = new Mapa<>();
        System.out.println(mapa.put(1, "a"));
        System.out.println(mapa.put(2, "b"));
        System.out.println(mapa.put(3, "c"));
        System.out.println(mapa.put(4, "d"));
        System.out.println(mapa.put(17, "F+1"));
        System.out.println(mapa.put(18, "F+2"));
        System.out.println(mapa.put(33, "F+21"));
        System.out.println(mapa.put(1, "e"));
        System.out.println();

        System.out.println(mapa.get(1));
        System.out.println(mapa.get(106));
        System.out.println(mapa.get(33));
        System.out.println(mapa.get(17));
        System.out.println();

        System.out.println(mapa.remove(106));
        System.out.println(mapa.remove(17));

        System.out.println();



    }
}