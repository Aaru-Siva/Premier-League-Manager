import java.io.IOException;
import java.util.List;

public interface LeagueManager {
    //method to addFootballClub
    void addFootballClub(FootballClub fClub);
    //method to deleteFootballClub
    void deleteFootballClub(String nameOfTheSportsClub);
    //method to displayStatics
    void displayStatistics(String nameOfTheSportsClub);
    //method to displayPremierLeagueTable
    void displayPremierLeagueTable();
    //method to addPlayedMatch
    void addPlayedMatch(String home,String away,int homeGoals,int awayGoals,Date date);
    //method to save
    void save();
    //method to save2 - details of match played
    void save2();
    //method to retrieve
    void retrieve(String retrieveFile) throws IOException, ClassNotFoundException;
    List<FootballClub> getFbClubList();
}
