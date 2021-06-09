
/*
    Student Name: Aarany Sivanathan
    Student ID: 2019693
    UoW ID: w1789958

    References: http://tutorials.jenkov.com/javafx/tableview.html
    https://docs.oracle.com/javafx/2/ui_controls/table-view.htm

    //https://stackoverflow.com/questions/47559491/making-a-search-bar-in-javafx
*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Collections;
import java.util.Random;

public class Table extends Application {
    private final static PremierLeagueManager premierLeagueM = new PremierLeagueManager();

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());   //scene creation
        stage.setTitle("Football Management System");   //setting title for scene
        TableView tableVi = new TableView();    //creating table view

        //creating label
        final Label lb = new Label("FootballClubList");
        lb.setStyle("-fx-font: 45 Bahnschrift; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");
        lb.setLayoutX(650);
        final ObservableList<FootballClub> update = FXCollections.observableArrayList(premierLeagueM.getFbClubList());
        tableVi.setEditable(false);

        //table columns
        TableColumn<Integer, FootballClub> column1 = new TableColumn<>("nameOfTheSportsClub");
        column1.setCellValueFactory(new PropertyValueFactory<>("nameOfTheSportsClub"));
        column1.setPrefWidth(190);
        column1.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column2 = new TableColumn<>("locationOfTheClub");
        column2.setCellValueFactory(new PropertyValueFactory<>("locationOfTheClub"));
        column2.setPrefWidth(200);
        column2.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column3 = new TableColumn<>("winCount");
        column3.setCellValueFactory(new PropertyValueFactory<>("winCount"));
        column3.setPrefWidth(150);
        column3.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column4 = new TableColumn<>("drawCount");
        column4.setCellValueFactory(new PropertyValueFactory<>("drawCount"));
        column4.setPrefWidth(150);
        column4.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column5 = new TableColumn<>("defeatCount");
        column5.setCellValueFactory(new PropertyValueFactory<>("defeatCount"));
        column5.setPrefWidth(150);
        column5.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<Integer, FootballClub> column6 = new TableColumn<>("goalDifference");
        column6.setCellValueFactory(new PropertyValueFactory<>("goalDifference"));
        column6.setPrefWidth(140);
        column6.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column7 = new TableColumn<>("scoredGoalsCount");
        column7.setCellValueFactory(new PropertyValueFactory<>("scoredGoalsCount"));
        column7.setPrefWidth(190);
        column7.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column8 = new TableColumn<>("receivedGoalsCount");
        column8.setCellValueFactory(new PropertyValueFactory<>("receivedGoalsCount"));
        column8.setPrefWidth(190);
        column8.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column9 = new TableColumn<>("points");
        column9.setCellValueFactory(new PropertyValueFactory<>("points"));
        column9.setPrefWidth(100);
        column9.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<String, FootballClub> column10 = new TableColumn<>("numberOfMatchesPlayed");
        column10.setCellValueFactory(new PropertyValueFactory<>("numberOfMatchesPlayed"));
        column10.setPrefWidth(190);
        column10.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        //getting columns to table view
        tableVi.getColumns().add(column1);
        tableVi.getColumns().add(column2);
        tableVi.getColumns().add(column3);
        tableVi.getColumns().add(column4);
        tableVi.getColumns().add(column5);
        tableVi.getColumns().add(column6);
        tableVi.getColumns().add(column7);
        tableVi.getColumns().add(column8);
        tableVi.getColumns().add(column9);
        tableVi.getColumns().add(column10);

        //Collections.sort() method is used to sort elements in the list
        Collections.sort(update, new PremierLeagueManager.CustomComparator());
        for (FootballClub updatesOfFootballClub : update) {
            FootballClub insertUpdate = new FootballClub(updatesOfFootballClub.getNameOfTheSportsClub(), updatesOfFootballClub.getLocationOfTheClub(), updatesOfFootballClub.getWinCount(), updatesOfFootballClub.getDrawCount(), updatesOfFootballClub.getDefeatCount(), updatesOfFootballClub.getScoredGoalsCount(), updatesOfFootballClub.getReceivedGoalsCount(), updatesOfFootballClub.getPoints(), updatesOfFootballClub.getNumberOfMatchesPlayed(), updatesOfFootballClub.getGoalDifference());
            tableVi.getItems().addAll(insertUpdate);
        }

        //sorting the table according to scored goals in descending order
        //button sortScoredGoalButton
        Button sortScoredGoalButton = new Button();
        sortScoredGoalButton.setText("Sort By Scored Goal");
        sortScoredGoalButton.setLayoutX(50);
        sortScoredGoalButton.setLayoutY(650);
        sortScoredGoalButton.setStyle("-fx-background-color:midnightblue;" + "-fx-text-fill:white;" + "-fx-font-size: 20;" + "-fx-border-color: black;" + "-fx-pref-height: 40;" + "-fx-pref-width: 400;" + "-fx-font: 24 Bahnschrift;");
        //setting set on action for button sortScoredGoalButton
        sortScoredGoalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column7.setSortType(TableColumn.SortType.DESCENDING);
                tableVi.getSortOrder().setAll(column7);
            }
        });

        //sorting the table according to win count in descending order
        //Button sortWinCountButton
        Button sortWinCountButton = new Button();
        sortWinCountButton.setText("Sort By Win Count");
        sortWinCountButton.setLayoutX(500);
        sortWinCountButton.setLayoutY(650);
        sortWinCountButton.setStyle("-fx-background-color:midnightblue;" + "-fx-text-fill:white;" + "-fx-font-size: 20;" + "-fx-border-color: black;" + "-fx-pref-height: 40;" + "-fx-pref-width: 400;" + "-fx-font: 24 Bahnschrift;");
        //setting set on action for button sortWinCountButton
        sortWinCountButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                column3.setSortType(TableColumn.SortType.DESCENDING);
                tableVi.getSortOrder().setAll(column3);
            }
        });

        //displaying all the  matches played sorted in ascending order
        //button sortMatchesPlayed
        Button sortMatchesPlayed = new Button();
        sortMatchesPlayed.setText("MatchesPlayed");
        sortMatchesPlayed.setLayoutX(500);
        sortMatchesPlayed.setLayoutY(850);
        sortMatchesPlayed.setStyle("-fx-background-color:midnightblue;" + "-fx-text-fill:white;" + "-fx-font-size: 20;" + "-fx-border-color: black;" + "-fx-pref-height: 40;" + "-fx-pref-width: 400;" + "-fx-font: 24 Bahnschrift;");
        //setting set on action for button sortMatchesPlayed
        sortMatchesPlayed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //calling the new window function to display on button click
                matchesPlayed();
            }

        });

        //Creating a new window to display random match with score
        //Labels creation
        Label label1 = new Label("");
        label1.setLayoutX(300);
        label1.setLayoutY(730);
        label1.setStyle("-fx-font: 35 Tahoma; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");

        Label label2 = new Label("");
        label2.setLayoutX(550);
        label2.setLayoutY(730);
        label2.setStyle("-fx-font: 35 Tahoma; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");

        Label teamOneScore = new Label("");
        teamOneScore.setLayoutX(300);
        teamOneScore.setLayoutY(770);
        teamOneScore.setStyle("-fx-font: 35 Tahoma; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");

        Label teamTwoScore = new Label("");
        teamTwoScore.setLayoutX(550);
        teamTwoScore.setLayoutY(770);
        teamTwoScore.setStyle("-fx-font: 35 Tahoma; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");

        //generating random match
        //creating buttons
        Button randomMatches= new Button();
        randomMatches.setText("Random Match");
        randomMatches.setLayoutX(50);
        randomMatches.setLayoutY(850);
        randomMatches.setStyle("-fx-background-color:midnightblue;" + "-fx-text-fill:white;" + "-fx-font-size: 20;" + "-fx-border-color: black;" + "-fx-pref-height: 40;" + "-fx-pref-width: 400;" + "-fx-font: 24 Bahnschrift;");
        //setting set on action for button sortMatchesPlayed
        randomMatches.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Adding Random function,generating random teams, score and date
                Random random = new Random();
                // Generating a random played match date using Math.random() method
                int year = (int) (10 * Math.random() + 2015);
                int day;
                int month = (int) (12 * Math.random() + 1);
                if (month == 2) {   //2nd month only have 28 days
                    day = (int) (28 * Math.random() + 1);
                } else {
                    day = (int) (31 * Math.random() + 1);
                }

                FootballClub footballTeam1 = randomClub();
                FootballClub footballTeam2 = randomClub();
                if(footballTeam1 == footballTeam2){
                    return;
                }

                int randomScoreTeam1 = random.nextInt(12);
                int randomScoreTeam2 = random.nextInt(12);
                Date d = new Date(day,month,year);
                try {
                    premierLeagueM.addPlayedMatch(footballTeam1.getNameOfTheSportsClub(), footballTeam2.getNameOfTheSportsClub(), randomScoreTeam1, randomScoreTeam2,d);
                    tableVi.getItems();
                } catch (Exception e) {

                }

                try {
                    premierLeagueM.save();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    premierLeagueM.save2();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //displaying the random points
                label1.setText(String.valueOf(footballTeam1.getNameOfTheSportsClub()));
                teamOneScore.setText(String.valueOf(randomScoreTeam1));
                label2.setText(String.valueOf(footballTeam2.getNameOfTheSportsClub()));
                teamTwoScore.setText(String.valueOf(randomScoreTeam2));
            }

            //creating veriable for random
            public FootballClub randomClub() {
                Random randC = new Random();
                int randomNumber = randC.nextInt(update.size());
                FootballClub randomClub = update.get(randomNumber);
                return randomClub;
            }

        });

        tableVi.setPrefSize(1655, 500); //setting the size of table view

        //setting background image for background
        Image backGroundImage = new Image("file:fb.jpg");
        ImageView imageView = new ImageView(backGroundImage);
        imageView.setFitWidth(1800);    //setting height and width for image view
        imageView.setFitHeight(1000);

        // creating vbox
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(60,0,0,10));
        vbox.getChildren().addAll(tableVi);

        ((Group)scene.getRoot()).getChildren().addAll(imageView,lb,vbox,sortScoredGoalButton,sortWinCountButton,sortMatchesPlayed,label1,label2,teamOneScore,teamTwoScore,randomMatches);

        stage.setScene(scene);
        stage.show();
        stage.setWidth(1690);   //setting height and width for stage
        stage.setHeight(1000);
    }
    public static void matchesPlayed() {
        final ObservableList<Match> scoreDetails = FXCollections.observableArrayList(premierLeagueM.getMatchClubList());

        //creating new stage to display matches played table in new window
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(new Group());
        stage2.setTitle("Matches Played with Score");
        stage2.setWidth(1400);
        stage2.setHeight(1000);

        //creating the label for table heading
        Label playedMatchLabel = new Label("Matches Played with Score");
        playedMatchLabel.setStyle("-fx-font: 45 Bahnschrift; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");

        //creating a table view to display the played football clubs in the match and its score
        TableView tableView = new TableView();
        tableView.setPrefSize(1000, 500);
        tableView.setEditable(false);
        tableView.setStyle("-fx-border-color: black");

        //table columns
        TableColumn<String, Match> homeClub = new TableColumn<>("Home Club");
        homeClub.setCellValueFactory(new PropertyValueFactory<>("team_1"));
        homeClub.setPrefWidth(200);
        homeClub.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");


        TableColumn<String, Match> awayClub = new TableColumn<>("Away Club");
        awayClub.setCellValueFactory(new PropertyValueFactory<>("team_2"));
        awayClub.setPrefWidth(200);
        awayClub.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<Integer, Match> scoreClub1 = new TableColumn<>("Score of Home club");
        scoreClub1.setCellValueFactory(new PropertyValueFactory<>("scoreOfTheTeam_1"));
        scoreClub1.setPrefWidth(200);
        scoreClub1.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<Integer, Match> scoreClub2 = new TableColumn<>("Score of Away club");
        scoreClub2.setCellValueFactory(new PropertyValueFactory<>("scoreOfTheTeam_2"));
        scoreClub2.setPrefWidth(200);
        scoreClub2.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");

        TableColumn<Date, Match> matchPlayedDate = new TableColumn<>("Date");
        matchPlayedDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        matchPlayedDate.setPrefWidth(200);
        matchPlayedDate.setStyle("-fx-background-color: linear-gradient(#848ca0,#87a0a2);"+"-fx-font-weight: bold;"+"-fx-text-fill:black;"+"-fx-border-color: -fx-box-border;"+"-fx-border-color: black;"+"-fx-text-alignment: center;");


        tableView.getColumns().addAll(homeClub, awayClub, scoreClub1, scoreClub2, matchPlayedDate);

        for (Match playedMatchDetails : scoreDetails) {
            Match playedMatchScoreDetails = new Match(playedMatchDetails.getTeam_1(), playedMatchDetails.getTeam_2(), playedMatchDetails.getScoreOfTheTeam_1(), playedMatchDetails.getScoreOfTheTeam_2(), String.valueOf(playedMatchDetails.getDate()));
            tableView.getItems().addAll(playedMatchScoreDetails);
        }

        //Passing the data to a filtered list
        //Reference - https://stackoverflow.com/questions/47559491/making-a-search-bar-in-javafx
        FilteredList<Match> date = new FilteredList(scoreDetails, p -> true);
        tableView.setItems(date);//Setting the table's items using the filtered list

        //creating label for search
        Label searchLabel = new Label("Date");
        searchLabel.setLayoutX(40);
        searchLabel.setLayoutY(800);
        searchLabel.setStyle("-fx-font: 35 Tahoma; -fx-base: #b3b3ff; -fx-font-weight: bold; -fx-text-fill:white;");

        //Creating textfield for search
        TextField textField = new TextField();
        textField.setPromptText("Search here!");
        textField.setLayoutX(150);
        textField.setLayoutY(810);
        textField.setOnKeyReleased(keyEvent ->
        {
            date.setPredicate(p -> p.getDate().toLowerCase().contains(textField.getText().toLowerCase().trim()));
        });

        //creating hBox
        HBox hb = new HBox(searchLabel, textField);
        hb.setAlignment(Pos.CENTER);//Center HBox

        //adding image for background
        Image backgroundImg = new Image("file:fb.jpg");
        ImageView imgView1 = new ImageView(backgroundImg);
        imgView1.setFitWidth(1400);
        imgView1.setFitHeight(1000);

        //creating vbox
        final VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setPadding(new Insets(90, 0, 0, 180));//setting padding for vbox
        vbox.getChildren().addAll(playedMatchLabel,tableView);

        ((Group) scene2.getRoot()).getChildren().addAll(imgView1,vbox,hb,textField,searchLabel);

        stage2.setScene(scene2);
        stage2.show();

    }
}

