package by.stepanenko.notebook.dao;

public class DAOException extends Exception {
  private String message;

  public DAOException(String message) {
    super(message);
  }

  public DAOException(Throwable cause) {
    super(cause);
  }

  public DAOException(String message, Throwable cause) {
    super(message, cause);
  }

}
