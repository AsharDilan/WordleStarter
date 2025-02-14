/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 */

public class Wordle {
    private int randomIndex = (int) (Math.random() * WordleDictionary.FIVE_LETTER_WORDS.length);
    private String answerToWordle = WordleDictionary.FIVE_LETTER_WORDS[randomIndex].toUpperCase();

    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
    }

    public void enterAction(String s) {
        System.out.println(answerToWordle);
        String userWord = s;

        boolean check = false;
        for (String checkWord : WordleDictionary.FIVE_LETTER_WORDS) {
            if (userWord.toLowerCase().equals(checkWord)) {
                check = true;
            }
        }
        if (!check) {
            gw.showMessage("not in word list.");

        } else {
            gw.showMessage("in word list.");

        for (int col = 0; col < WordleGWindow.N_COLS; col++) {
            System.out.println(userWord.substring(col, col + 1) + " " + answerToWordle.substring(col, col + 1) );
            if (userWord.substring(col, col + 1).equals(answerToWordle.substring(col, col + 1))) {
                gw.setSquareColor(gw.getCurrentRow(), col, WordleGWindow.CORRECT_COLOR);
            }
            else if (answerToWordle.contains(userWord.substring(col, col + 1)) && !gw.getSquareColor(gw.getCurrentRow(), col).equals(WordleGWindow.CORRECT_COLOR)) {
                gw.setSquareColor(gw.getCurrentRow(), col, WordleGWindow.PRESENT_COLOR);
            } else {
                gw.setSquareColor(gw.getCurrentRow(), col, WordleGWindow.MISSING_COLOR);
            }
        }
            updateRow();
        }

    }


    public static void main(String[] args) {
        new Wordle().run();
    }
    public void RandomWord()
    {
        int letter = 0;
        for(int c = 0; c < WordleGWindow.N_COLS; c++)
        {
            gw.setSquareLetter(0,c,answerToWordle.substring(letter,letter+1));
            letter++;
        }
    }
    public void updateRow(){
        int rowIndex = 1;
        if(rowIndex <= WordleGWindow.N_ROWS)
        {
            gw.setCurrentRow(gw.getCurrentRow() + 1);
        }
    }

    private WordleGWindow gw;

}
