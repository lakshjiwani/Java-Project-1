package com.company.FXML;

import javafx.scene.layout.Pane;

import java.net.URL;

public class SidebarLoader {
        private Pane view;

        public Pane getPage(String fileName) {
            try {
                URL fileUrl = com.company.Main.class.getResource("" + fileName +
                        ".fxml");

                view = javafx.fxml.FXMLLoader.load(fileUrl);
            } catch (Exception e) {
                System.out.println("No page " + fileName + " Please check FxmlLoader.");
            }
            return view;

        }
    }

