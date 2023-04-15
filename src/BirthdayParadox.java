import java.util.*;
import java.time.*;

public class BirthdayParadox {
    public String[] getBirthdays(int x){
        Random rand = new Random();
        String[] birthdays = new String[x];
        for(int i = 0; i < x; i++){
            int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
            int maxDay = (int) LocalDate.of(2100, 12, 31).toEpochDay();
            long randomDay = minDay + rand.nextInt(maxDay - minDay);
            LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
            String birthday = randomDate.getMonth() + " " + randomDate.getDayOfMonth();
            birthdays[i] = birthday;
        }
        return birthdays;
    }

    public int getMostCommonBirthday(String[] birthdays) {
        int maxCount = 0;
        for(int i = 0; i < birthdays.length; i++) {
            String currentBirthday = birthdays[i];
            int count = 0;
            for(int j = 0; j < birthdays.length; j++) {
                if(birthdays[j].equals(currentBirthday)) {
                    count++;
                }
            }
            if(count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    public double birthdayProbability(int simulations, int birthdaysNum) {
        int commonBirthday = 0;
        for(int i = 0; i < simulations; i++) {
            String[] birthdays = getBirthdays(birthdaysNum);
            int mostCommonBirthdayCount = getMostCommonBirthday(birthdays);
            if(mostCommonBirthdayCount > 1) {
                commonBirthday++;
            }
        }
        return (double)commonBirthday / simulations * 100;
    }
}
