package com.company.model.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    //connect to our DB
    Connection getConnection() throws SQLException, ClassNotFoundException;
}
