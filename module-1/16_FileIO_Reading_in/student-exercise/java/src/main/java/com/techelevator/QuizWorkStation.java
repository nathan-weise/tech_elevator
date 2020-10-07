package com.techelevator;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class QuizWorkStation {

    public static void main(String[] args) {

        String userAnswer;
        Scanner scanner = new Scanner(System.in);
        String correctValue = "";
        int correct = 0;
        int incorrect = 0;

        Path input = Paths.get("test_quiz.txt");
        try (Scanner fileInput = new Scanner(input)) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();

                String[] lineArray = line.split("\\|");

                List<String> lineList = new ArrayList<String>(Arrays.asList(lineArray));

                Boolean correctAnswer = true;
                int questionNumber = 0;


                for (int i = 0; i < lineArray.length; i++)
                    if (lineList.get(i).contains("*")) {
                        correctAnswer = true;
                        correctValue = lineList.get(i).substring(0, (lineList.get(i).length() - 1));
                        System.out.println(correctValue);
                    } else {
                        correctAnswer = false;
                        System.out.println(lineList.get(i));
                    }

                System.out.println("");
                System.out.print("Your answer is: ");
                userAnswer = scanner.nextLine();
                if (userAnswer.equals(correctValue)) {
                    correct = correct + 1;
                    System.out.println("Your answer is correct!");
                } else {
                    incorrect = incorrect + 1;
                    System.out.println("Your answer is incorrect!");
                }
            }
            System.out.println();
            System.out.println("You got " + correct + " correct, and " + incorrect + " incorrect!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}