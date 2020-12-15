package com.ingsof2;

import com.ingsof2.SQLTables.Tablas;
import com.ingsof2.frames.MainFrame;

public class Main {

    public static MainFrame mainFrame;

    public static void main(String[] args) {

        //Tablas.dropAllAndCreate();

        mainFrame = new MainFrame();
    }
}
