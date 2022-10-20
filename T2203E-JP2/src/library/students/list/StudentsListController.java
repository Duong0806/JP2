package library.students.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Book;
import library.entities.Student;
import library.helper.Connector;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentsListController implements Initializable {
    public TableView<Student> tbStudents;
    public TableColumn<Student,Integer> tdId;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tbEmail;
    public TableColumn<Student,String> tbTel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tbEmail.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
        tbTel.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));

        ObservableList<Student> ls = FXCollections.observableArrayList();

        try {
            String sql_txt = "select * from students";
            Connector conn = new Connector();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Student b = new Student(id,name,email,tel);
                ls.add(b);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            tbStudents.setItems(ls);
        }
    }



    public void createNewStudents(ActionEvent actionEvent) throws Exception {
        Parent listStudents = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("New Students");
        Main.rootStage.setScene(new Scene(listStudents));
    }
    public void backToHome(ActionEvent actionEvent) {
    }
}
