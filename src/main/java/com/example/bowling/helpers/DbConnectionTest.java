package com.example.bowling.helpers;

import java.sql.*;
import java.util.Map;

public class DbConnectionTest {

    public String ConnectDb(Map<String, String> properties) throws SQLException {

        String result = null;
        Connection conn = DriverManager.getConnection(properties.get("jdbc_url"), properties.get("db_username"), properties.get("db_password"));
        Statement statement = conn.createStatement();


//        String sql_create_users = "CREATE TABLE IF NOT EXISTS `Users` (`idUsers` int(11) NOT NULL AUTO_INCREMENT,`userName` varchar(45) NOT NULL, PRIMARY KEY (`idUsers`), UNIQUE KEY `idUsers_UNIQUE` (`idUsers`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;";
//        statement.executeUpdate(sql_create_users);
//
//        String sql_create_scores = "CREATE TABLE IF NOT EXISTS `Scores` (`idScores` int(11) NOT NULL AUTO_INCREMENT,`Score` int(11) NOT NULL,`idUser` int(11) NOT NULL, PRIMARY KEY (`idScores`), UNIQUE KEY `idScores_UNIQUE` (`idScores`), KEY `fk_userid_idx` (`idUser`), CONSTRAINT `fk_userid` FOREIGN KEY (`idUser`) REFERENCES `Users` (`idUsers`) ON DELETE NO ACTION ON UPDATE NO ACTION) ENGINE=InnoDB DEFAULT CHARSET=latin1;";
//        statement.executeUpdate(sql_create_scores);

        String sql_query = "SELECT  count(*) as count FROM players";

        ResultSet resultSet = statement.executeQuery(sql_query);

        while (resultSet.next()) {
            result = resultSet.getString("count");
        }

        return result;
    }

}
