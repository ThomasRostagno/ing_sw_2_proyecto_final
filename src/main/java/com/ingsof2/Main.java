package com.ingsof2;

import com.ingsof2.frames.MainFrame;

public class Main {

    public static MainFrame mainFrame;

    public static void main(String[] args) {


        mainFrame = new MainFrame();

        /*Connection connection = Database.INSTANCE.connect();

        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE STUDENT");
            statement.executeUpdate("CREATE TABLE STUDENT(ID INT NOT NULL, NAME VARCHAR)");
            statement.executeUpdate("DROP TABLE STUDENT");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Main.mainFrame.showException(new ApiException(ErrorCode.FAIL_EXECUTING_QUERY));
        }


        Database.INSTANCE.disconnect(connection);*/
    }
}
