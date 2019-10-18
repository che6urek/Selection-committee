package Entity.Person;

public class IdGenerator {
    private static int id;

    private IdGenerator() {

    }

    public static int getNewId() {
        return ++id;
    }

    public static void init(int currId){
        if (id == 0){
            id = currId;
        }
    }



}
