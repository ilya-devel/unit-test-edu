package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {

    public List<Integer> generateRandomIntList(int length) {
        Random random = new Random();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            lst.add(random.nextInt());
        }
        return lst;
    }
}
