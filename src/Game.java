import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выбери игру: 1 - Угадай число / 2 - Угадай слово");
            switch(scanner.nextInt()) {
                case 1:
                    RandomNumberGame();
                    break;
                case 2:
                    RandomWordGame();
                    break;
                default:return;
            }

        }

    }
    public static void RandomNumberGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int guessingNumber = random.nextInt(10);
        int  enteredNumber =-1;
        int attempt =0;

        System.out.println("Угадайте число от 0 до 9. У вас 3 попытки");
        while (attempt<3&&enteredNumber!=guessingNumber) {
            System.out.println("Попытка " + (attempt+1) + ". Введите число");
            do {
                if (scanner.hasNextInt()) {
                    enteredNumber=scanner.nextInt();
                    break;
                }
                scanner.nextLine();
            } while (true);
            if (enteredNumber==guessingNumber){
                System.out.println("Вы выиграли");
            }
            else {
                System.out.println("Ваше число " + ((enteredNumber>guessingNumber)?"больше":"меньше"));
                attempt++;
            }
        }
        if (attempt==3){
        System.out.println("Вы проиграли. Правильное число: " +guessingNumber);
        }
        System.out.println("Сыграем еще? 1 - да / 0 - нет");
        do {
            if (scanner.hasNextInt()) {
                enteredNumber =scanner.nextInt();
                break;
            }
            scanner.nextLine();
        }while (true);
        if (enteredNumber==1) {
            RandomNumberGame();
        }else {
            System.out.println("Спасибо за игру!");
        }

    }

    public static void RandomWordGame() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String mysteryWord = words[random.nextInt(words.length)];
        String humanWord = null;
        System.out.println("Компьютер загадал слово. Вам предстоит его угадать из списка");
        System.out.print(Arrays.toString(words));
        System.out.println();
        do {
            System.out.println("Введите слово");
            humanWord = scanner.nextLine();
            for (int i=0; i<15; i++) {
                if (i<mysteryWord.length() && i<humanWord.length() && mysteryWord.charAt(i)==humanWord.charAt(i)){
                    System.out.print(mysteryWord.charAt(i));

                }
                else {
                    System.out.print((mysteryWord.equals(humanWord))?"":"#");
                }

            } System.out.println();
        }while(!mysteryWord.equals(humanWord));

    }


    }


