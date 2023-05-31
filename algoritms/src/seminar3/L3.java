package seminar3;

public class L3 {

    public static void main(String[] args){

        OneWayList<Integer> integerOneWayList = new OneWayList<>();
        integerOneWayList.add(55);
        integerOneWayList.add(26);
        integerOneWayList.add(13);
        integerOneWayList.add(98);

        System.out.println(integerOneWayList.size());
        System.out.println(integerOneWayList.get(integerOneWayList.size())-1);
        System.out.println(integerOneWayList.contains(55));
    }


}