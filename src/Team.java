public class Team {
    private String teamName;
    private Sportsman[] participants = new Sportsman[4];

    public Team(String teamName,  Sportsman sportsman1,Sportsman sportsman2,Sportsman sportsman3,Sportsman sportsman4) {
        this.teamName = teamName;
        participants[0] = sportsman1;
        participants[1] = sportsman2;
        participants[2] = sportsman3;
        participants[3] = sportsman4;
    }

    public void getTeamInfo(){
        System.out.println(teamName);
        for(Sportsman s:participants){
            System.out.println(s);
        }
    }
}
