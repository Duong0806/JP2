package library;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HomeController {

    public void goToBookList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("book/list/list.fxml"));
        Main.rootStage.setTitle("List Books");
        Main.rootStage.setScene(new Scene(listBook));
    }

    public void gotoStudentsList(ActionEvent actionEvent)  throws Exception {
        Parent listStudents = FXMLLoader.load(getClass().getResource("students/list/list.fxml"));
        Main.rootStage.setTitle("List Students");
        Main.rootStage.setScene(new Scene(listStudents));

    }
}
