/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package tn.esprit.thewalkingdev.gui.test;


import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tn.esprit.thewalkingdev.gui.delegates.GamerDelegate;

/**
 *
 * @author Boj
 
public class PieChartSample extends Application implements Runnable {

	
    public PieChartSample() {
    }

    @Override
    public void run() {
        launch();
    }

   

    @Override
    public void start(Stage primaryStage) {
        BorderPane p = new BorderPane();
        
        //data = FXCollections.observableArrayList();
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList();
        data.add(new PieChart.Data("Logistic", (double) GamerDelegate.calculNbGamerTeam1()));
        data.add(new PieChart.Data("Media", (double) GamerDelegate.calculNbGamerTeam2()));
        data.add(new PieChart.Data("Organisation", (double) GamerDelegate.calculNbGamerTeam3()));
        data.add(new PieChart.Data("Sponsor", (double) GamerDelegate.calculNbGamerTeam4()));
        		

        PieChart chart = new PieChart(data);

		//chart.setStyle("-fx-pie-label-visible: false");
        for (PieChart.Data d : data) {
            d.getNode().setOnMouseEntered(new MouseHoverAnimation(d, chart));
            d.getNode().setOnMouseExited(new MouseExitAnimation());
        }

        chart.setClockwise(false);
        
        p.setCenter(chart);
        chart.setTitle("Nombre de Gamer par team");
        chart.setAnimated(true);
        chart.setMaxSize(400, 400);
        chart.setLabelsVisible(true);
        Scene s = new Scene(p);
        primaryStage.setScene(s);
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Nombre de comptes");
        primaryStage.initStyle(StageStyle.DECORATED);
//                primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    static class MouseHoverAnimation implements EventHandler<MouseEvent> {

        static final Duration ANIMATION_DURATION = new Duration(500);
        static final double ANIMATION_DISTANCE = 0.15;
        private double cos;
        private double sin;
        private PieChart chart;

        public MouseHoverAnimation(PieChart.Data d, PieChart chart) {
            this.chart = chart;
            double start = 0;
            double angle = calcAngle(d);
            for (PieChart.Data tmp : chart.getData()) {
                if (tmp == d) {
                    break;
                }
                start += calcAngle(tmp);
            }

            cos = Math.cos(Math.toRadians(0 - start - angle / 2));
            sin = Math.sin(Math.toRadians(0 - start - angle / 2));
        }

        @Override
        public void handle(MouseEvent arg0) {
            Node n = (Node) arg0.getSource();

            double minX = Double.MAX_VALUE;
            double maxX = Double.MAX_VALUE * -1;

            for (PieChart.Data d : chart.getData()) {
                minX = Math.min(minX, d.getNode().getBoundsInParent().getMinX());
                maxX = Math.max(maxX, d.getNode().getBoundsInParent().getMaxX());
            }

            double radius = maxX - minX;
            TranslateTransitionBuilder.create().toX((radius * ANIMATION_DISTANCE) * cos).toY((radius * ANIMATION_DISTANCE) * sin).duration(ANIMATION_DURATION).node(n).build().play();
        }

        private static double calcAngle(PieChart.Data d) {
            double total = 0;
            for (PieChart.Data tmp : d.getChart().getData()) {
                total += tmp.getPieValue();
            }

            return 360 * (d.getPieValue() / total);
        }
    }

    static class MouseExitAnimation implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            TranslateTransitionBuilder.create().toX(0).toY(0).duration(new Duration(500)).node((Node) event.getSource()).build().play();
        }
    }
}*/
