package br.com.pipa.game.services;

import br.com.pipa.game.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuickSortService {

    public static void quickSort(List<User> userList, int first, int last) {

        if (last >= 20000)
            last = 20000-1;
        if (first < last) {
            int partitionIndex = partition(userList, first, last);

            quickSort(userList, first, partitionIndex-1);
            quickSort(userList, partitionIndex+1, last);
        }
    }

    private static int partition(List<User> userList, int first, int last) {
        User pivot = userList.get(last);
        int i = (first-1);
        pivot.setPosition((long) i+1);
        for (int j = first; j < last; j++) {
            if (userList.get(j).getScore() > pivot.getScore()) {
                i++;
                User swapTemp = userList.get(i);
                userList.set(i,userList.get(j));
                userList.get(i).setPosition((long)i+1);
                userList.set(j,swapTemp);
                userList.get(j).setPosition((long)j+1);
            }
        }
        User swapUser = userList.get(i+1);
        userList.set(i+1, userList.get(last));
        userList.get(i+1).setPosition((long)i+2);
        userList.set(last, swapUser);
        userList.get(last).setPosition((long)last+1);
        return i+1;
    }
}
