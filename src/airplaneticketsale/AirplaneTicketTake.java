/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneticketsale;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
/**
 *
 * @author hatice
 */
public class AirplaneTicketTake extends LoginFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginFrame lg=new LoginFrame();//Login frame açma komutu.
        lg.setVisible(true);
        // TODO code application logic here
    }
    //Veri tabanı bağlantısını yapan fonksiyon.
    public static ResultSet dbconnection(String sql) throws SQLException {
        String connection = "jdbc:hsqldb:file:db/AirportDB";
        DBHandler db = new DBHandler(connection);
        ResultSet rs = db.executeQuery(sql);
        return rs;
    
    }
    
}
