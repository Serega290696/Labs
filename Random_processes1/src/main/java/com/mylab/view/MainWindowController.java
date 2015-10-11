package com.mylab.view;

import com.mylab.model.MyRandomizer;
import com.mylab.model.RandomValidator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by serega.
 */
public class MainWindowController implements Initializable {

    private MyRandomizer r = new MyRandomizer();
    private RandomValidator validator = new RandomValidator();
    private static int[] result;
    private static int amountSegmentsValue;

    @FXML
    public TextField amount;
    @FXML
    public TextField amountSegments;
    @FXML
    public Label warning;
    @FXML
    public Label warning2;
    @FXML
    public BarChart<String, Number> chart;
    @FXML
    public CategoryAxis xord;
    @FXML
    public NumberAxis yord;

    @FXML
    private void generateAction() {
        try {
            warning.setText("");
            warning2.setText("");
            if (amount.getText().equals(""))
                amount.setText("100000");
            else if (amountSegments.getText().equals(""))
                amountSegments.setText("10");
            final int AMOUNT;
            try {
                AMOUNT = Integer.parseInt(amount.getText());
            } catch (Exception e) {
                warning.setText("Wrong input!");
                return;
            }
            double mass[] = new double[AMOUNT];
            for (int i = 0; i < AMOUNT; i++) {
                mass[i] = r.random();
            }
            try {
                amountSegmentsValue = Integer.parseInt(amountSegments.getText());
                if (amountSegmentsValue < 2)
                    amountSegments.setText("2");
                else if (amountSegmentsValue > 500)
                    amountSegments.setText("500");
                else
                    amountSegmentsValue = Integer.parseInt(amountSegments.getText());
            } catch (Exception e) {
                warning2.setText("Wrong input!");
                return;
            }
            validator.setAmountSegments(amountSegmentsValue);
            result = validator.valid(mass, 0, 1);
            updateChart();
        } catch (Exception e) {
            warning.setText("Wrong input!");
            return;
        }
    }

    private void updateChart() {

        xord.getCategories().remove(0, xord.getCategories().size() - 1);
        XYChart.Series series1 = new XYChart.Series();
        int i = 0;
        for (int a : result) {
            i++;
            series1.getData().add(new XYChart.Data(String.valueOf(i), a));
        }
        chart.getData().clear();
        chart.getData().addAll(series1);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
