import java.util.Scanner;
public class BlackjackSolitaire {
    private String[] tableDisplay = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16"};
    private Card[] table = new Card[20];
    private boolean[] tableCheck = {false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};
    private int tableCount = 16;
    private int score = 0;

    public BlackjackSolitaire() {
    }
    public void play(){
        Deck deck = new Deck();
        deck.shuffle();
        Scanner scnr = new Scanner(System.in);

        //print table
        while (tableCount > 0){
            for (int i = 0; i < 16; i++){
                if (i + 1 <= 10){
                    System.out.print(tableDisplay[i] + "\t");
                    if (i+1 == 5){
                        System.out.println();
                    }
                    if (i+1 == 10) {
                        System.out.println("\t");
                    }
                }
                else{
                    System.out.print("\t" + tableDisplay[i]);
                    if (i+1 == 13){
                        System.out.println();
                    }
                }
            }
            System.out.println();
            System.out.println();
            // deal new card from deck
            Card delt = deck.deal();
            System.out.println("Card delt: " + delt.getSuiteAndRank());
            System.out.println();
            // get position from user
            System.out.println("Enter the position you want to place the card. To discard, enter 17, 18, 19, or 20");
            while (true) {
                int positionEntered = scnr.nextInt();
                if (positionEntered > 20 || positionEntered < 1 ){
                    System.out.println("Position invalid. Please re-enter.");
                }
                else if (positionEntered > 16 && positionEntered <= 20 && tableCheck[positionEntered - 1] == false) {
                    table[positionEntered-1] = delt;
                    tableCheck[positionEntered-1] = true;
                    break;
                }
                else if (tableCheck[positionEntered - 1] == true) {
                    System.out.println("Position already filled. Please re-enter.");
                }
                else{
                    table[positionEntered-1] = delt;
                    tableDisplay[positionEntered-1] = delt.getSuiteAndRank();
                    tableCheck[positionEntered-1] = true;
                    break;
                }
            }
            tableCount --;
        }
        //calculate scores
        int localSum = 0;
        int aces = 0;


        //row 1



        for (int i = 0; i < 5; i++) {
            localSum+= table[i].getRankVal();
            if (table[i].getRank().equals("A")){
                aces ++;
            }
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //row 2

        localSum = 0;

        for (int i = 5; i < 10; i++) {
            localSum+= table[i].getRankVal();
            if (table[i].getRank().equals("A")){
                aces ++;
            }
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //row 3

        localSum = 0;

        for (int i = 10; i < 13; i++) {
            localSum+= table[i].getRankVal();
            if (table[i].getRank().equals("A")){
                aces ++;
            }
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //row 4

        localSum = 0;


        for (int i = 13; i < 16; i++) {
            localSum+= table[i].getRankVal();
            if (table[i].getRank().equals("A")){
                aces ++;
            }
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //column 2

        localSum = 0;
        aces = 0;

        localSum += table[1].getRankVal() + table[6].getRankVal() + table[10].getRankVal() + table[13].getRankVal();
        if (table[1].getRank().equals("A")){
            aces ++;
        }
        if (table[6].getRank().equals("A")){
            aces ++;
        }
        if (table[10].getRank().equals("A")){
            aces ++;
        }
        if (table[13].getRank().equals("A")){
            aces ++;
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //column 3

        localSum = 0;
        aces = 0;

        localSum += table[2].getRankVal() + table[7].getRankVal() + table[11].getRankVal() + table[14].getRankVal();
        if (table[2].getRank().equals("A")){
            aces ++;
        }
        if (table[7].getRank().equals("A")){
            aces ++;
        }
        if (table[11].getRank().equals("A")){
            aces ++;
        }
        if (table[14].getRank().equals("A")){
            aces ++;
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //column 4

        localSum = 0;
        aces = 0;

        localSum += table[3].getRankVal() + table[8].getRankVal() + table[12].getRankVal() + table[15].getRankVal();
        if (table[2].getRank().equals("A")){
            aces ++;
        }
        if (table[7].getRank().equals("A")){
            aces ++;
        }
        if (table[11].getRank().equals("A")){
            aces ++;
        }
        if (table[14].getRank().equals("A")){
            aces ++;
        }
        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 7;
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }


        //column 1 (blackjack possible)

        localSum = 0;
        aces = 0;

        localSum += table[0].getRankVal() + table[5].getRankVal();
        if (table[0].getRank().equals("A")){
            aces ++;
        }
        if (table[5].getRank().equals("A")){
            aces ++;
        }

        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 10; // blackjack
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        //column 5 (blackjack possible)

        localSum = 0;
        aces = 0;
        localSum += table[0].getRankVal() + table[5].getRankVal();
        if (table[0].getRank().equals("A")){
            aces ++;
        }
        if (table[5].getRank().equals("A")){
            aces ++;
        }

        while (aces > 0 && localSum > 21){
            localSum -= 10;
            aces -= 1;
        }
        if (localSum == 21){
            score += 10; // blackjack
        }
        if (localSum == 20){
            score += 5;
        }
        if (localSum == 19){
            score += 4;
        }
        if (localSum == 18){
            score += 3;
        }
        if (localSum == 17){
            score += 2;
        }
        if (localSum <= 16){
            score += 1;
        }

        System.out.println();
        System.out.printf("Game over! You scored %d points", score);
    }
}
