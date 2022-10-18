package Books;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BooksController implements Initializable {
    public TableView<Book> tableView;
    public TableColumn<Book, Integer> tbId;
    public TableColumn<Book, Integer> tbQty;
    public TableColumn<Book, String> tbName;
    public TableColumn<Book, String> tbAuthor;
    // connect API
    public final static String connectionString = "jdbc:mysql://localhost:3306/t2203e";
    public final static String user = "root";
    public final static String pwd = "";

    public void goToBack(ActionEvent actionEvent) {
    }

    public void addNew(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tbId.setCellValueFactory(new PropertyValueFactory<Book, Integer>("id"));
        tbName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        tbAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        tbQty.setCellValueFactory(new PropertyValueFactory<Book, Integer>("qty"));
        ObservableList<Book> listBooks = FXCollections.observableArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectionString,user,pwd);
            Statement statement = conn.createStatement();
            String sql_txt = "select * from books";
            ResultSet rs = statement.executeQuery(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id,name,author,qty);
                listBooks.add(b);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        } finally {

            tableView.setItems(listBooks);
        }
    }


}
