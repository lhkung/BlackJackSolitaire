public class Card {
    private String suite = "";
    private String rank = "";

    public Card (String suite, int rank){
        this.suite = suite;
        if (rank == 1){
            this.rank = "A";
        }
        else if (rank == 11){
            this.rank = "J";
        }
        else if (rank == 12){
            this.rank = "Q";
        }
        else if (rank == 13){
            this.rank = "K";
        }
        else{
            this.rank = Integer.toString(rank);
        }

    }
    public Card (String suite, String rank){
        this.suite = suite;
        this.rank = rank;
    }

    public String getSuiteAndRank(){
        String suiteAndRank = this.suite + this.rank;
        return suiteAndRank;
    }
    public String getRank(){
        return this.rank;
    }
    public int getRankVal(){
        if (this.rank.equals("J") || this.rank.equals("Q") || this.rank.equals("K")){
            return 10;
        }
        if (this.rank.equals("A")){
            return 11;
        }
        else{
            return Integer.valueOf(this.rank);
        }
    }
}
