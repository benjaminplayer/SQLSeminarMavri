/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author miranda
 */
public class OracleConnection {
    
    public static OracleDataSource oracleDataSource;
    public static Connection getConnection() {
        if (oracleDataSource == null) {
            final String host = "193.2.139.22";
            //final String host = "localhost";
            final String user = "biscakb";
            final String password = "biscakb";
            final String sid = "ers";
            final String port = "1521";
            try {
                oracleDataSource = new OracleDataSource();
                oracleDataSource.setURL("jdbc:oracle:thin:@" + host + ":" + port + ":" + sid);
                oracleDataSource.setUser(user);
                oracleDataSource.setPassword(password);
            } catch (Exception e) {
            }
        }
        Connection connection = null;
        try {
            connection = oracleDataSource.getConnection();
            } catch (Exception e) {
            }        
        return connection;
    }    
    
}
