package ua.nure.kn16.trotsenko.usermanagement.db;
import java.sql.Connection;

/**
 * Interface to create connection with DB
 */
public interface ConnectionFactory {
    Connection createConnection () throws DatabaseException;
}