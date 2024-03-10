package lesson_6;

import lombok.Data;
import org.apache.commons.math3.stat.Frequency;
import java.util.*;

@Data
public class Main {
    final static int DOOR_COUNT = 3;
    final static int ROUND_COUNT = 1000;
    static Frequency frequency = new Frequency();
    static Random rnd = new Random();

    public static void main(String[] args) {
        Boolean[] doors = new Boolean[DOOR_COUNT];
        System.out.printf("Wins with changed choice: %s\n", playGameWithChangedChoice(doors, frequency));
        System.out.println(frequency);
        frequency.clear();
        System.out.printf("Wins with same choice: %s\n", playGameWithSameChoice(doors, frequency));
        System.out.println(frequency);
    }

    public static void prizeDoor(Boolean[] arr){
        Arrays.fill(arr, false);
        arr[rnd.nextInt(arr.length)] = true;
    }

    public static int removeOneDoor(Boolean[] arr, int playerChoice){
        int randomDoorNumber;
        int hostChoice;
        do {
            randomDoorNumber = rnd.nextInt(arr.length);
        } while(arr[randomDoorNumber] || randomDoorNumber == playerChoice);
        hostChoice = randomDoorNumber;
        return hostChoice;
    }

    public static int changeChoice(Boolean[] arr, int playerChoice, int hostChoice){
        int newPlayerChoice;
        do {
            newPlayerChoice = rnd.nextInt(arr.length);
        } while(newPlayerChoice == playerChoice || newPlayerChoice == hostChoice);
        return newPlayerChoice;
    }

    public static int playGameWithChangedChoice(Boolean[] arr, Frequency frequency){
        int count = 0;
        for (int i = 0; i < ROUND_COUNT; i++) {
            prizeDoor(arr);
            int playerChoice = rnd.nextInt(arr.length);
            int hostChoice = removeOneDoor(arr, playerChoice);
            int newPlayerChoice = changeChoice(arr, playerChoice, hostChoice);
            frequency.addValue(arr[newPlayerChoice]);
            if(arr[newPlayerChoice]){
                count++;
            }
        }
        return count;
    }

    public static int playGameWithSameChoice(Boolean[] arr, Frequency frequency){
        int count = 0;
        for (int i = 0; i < ROUND_COUNT; i++) {
            prizeDoor(arr);
            int playerChoice = rnd.nextInt(arr.length);
            frequency.addValue(arr[playerChoice]);
            if(arr[playerChoice]) {
                count++;
            }
        }
        return count;
    }
}