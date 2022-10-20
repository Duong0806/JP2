package library.students.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import library.Main;
import library.helper.Connector;

public class StudentCreateController {
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTel;


    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String tel = txtTel.getText();

            String sql_txt = "insert into students(name,email,tel) " +
                    "values('"+name+"','"+email+"','"+tel+"')";
            Connector conn = new Connector();
            if(conn.executeQuery(sql_txt)){
                backToList();
            }else{
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backToList() throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
        Main.rootStage.setTitle("Students");
        Main.rootStage.setScene(new Scene(listBook));
    }
}
