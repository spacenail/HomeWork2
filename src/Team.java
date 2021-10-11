public class Team {
    private String teamName;
    private Sportsman[] sportsman;

    public Team(String teamName, Sportsman[] sportsman) {
        this.teamName = teamName;
        this.sportsman = sportsman;
    }

    public void getTeamInfo(){
        System.out.println(teamName);
        for(Sportsman s:sportsman){
            System.out.println(s);
        }
    }

    public void showResults(){
    }
}
