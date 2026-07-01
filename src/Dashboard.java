import javax.swing.*;
import java.io.*;
import java.awt.*;

public class Dashboard {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame(
                        "Farmer Dashboard"
                );

        frame.getContentPane().setBackground(
                new Color(
                        220,
                        255,
                        220
                )
        );

        JLabel title =
                new JLabel(
                        "AI Farmer Crop Price Prediction"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        16
                )
        );

        String crops[] = {

                "Tomato",

                "Wheat",

                "Rice"

        };

        JComboBox<String> cropBox =
                new JComboBox<>(
                        crops
                );

        JButton predict =
                new JButton(
                        "Predict"
                );

        JButton history =
                new JButton(
                        "View History"
                );

        JButton about =
                new JButton(
                        "About"
                );

        predict.setBackground(
                Color.GREEN
        );

        predict.setForeground(
                Color.WHITE
        );

        JLabel current =
                new JLabel(
                        "Current Price : ₹20"
                );

        JLabel prediction =
                new JLabel();

        JLabel advice =
                new JLabel();

        JLabel profit =
                new JLabel();

        title.setBounds(
                60,
                20,
                300,
                30
        );

        cropBox.setBounds(
                120,
                70,
                140,
                30
        );

        predict.setBounds(
                40,
                130,
                100,
                35
        );

        history.setBounds(
                150,
                130,
                120,
                35
        );

        about.setBounds(
                280,
                130,
                80,
                35
        );

        current.setBounds(
                80,
                200,
                250,
                30
        );

        prediction.setBounds(
                80,
                250,
                250,
                30
        );

        advice.setBounds(
                80,
                300,
                250,
                30
        );

        profit.setBounds(
                80,
                350,
                250,
                30
        );

        predict.addActionListener(

                e -> {

                    try {

                        String crop =

                                cropBox
                                        .getSelectedItem()
                                        .toString()
                                        .toLowerCase();

                        ProcessBuilder pb =

                                new ProcessBuilder(

                                        "C:\\Users\\admin\\PycharmProjects\\FarmerPricePredictor\\.venv\\Scripts\\python.exe",

                                        "C:\\Users\\admin\\PycharmProjects\\FarmerPricePredictor\\predict.py",

                                        crop

                                );

                        pb.redirectErrorStream(
                                true
                        );

                        Process p =
                                pb.start();

                        BufferedReader br =

                                new BufferedReader(

                                        new InputStreamReader(

                                                p.getInputStream()

                                        )

                                );

                        String output =
                                br.readLine();

                        if(
                                output==null
                        ){

                            JOptionPane.showMessageDialog(

                                    null,

                                    "Python Output Empty"

                            );

                            return;

                        }

                        int future =

                                Integer.parseInt(

                                        output.trim()

                                );

                        prediction.setText(

                                "Predicted Price : ₹"

                                        + future

                        );

                        if(
                                future>20
                        )

                            advice.setText(

                                    "Advice : WAIT"

                            );

                        else

                            advice.setText(

                                    "Advice : SELL"

                            );

                        int profitValue =

                                (
                                        future-20
                                )*100;

                        profit.setText(

                                "Expected Profit : ₹"

                                        +

                                        profitValue

                        );

                        FileWriter writer =

                                new FileWriter(

                                        "history.csv",

                                        true

                                );

                        writer.write(

                                crop

                                        +

                                        ","

                                        +

                                        future

                                        +

                                        ","

                                        +

                                        advice.getText()

                                        +

                                        "\n"

                        );

                        writer.close();

                    }

                    catch(
                            Exception ex
                    ){

                        ex.printStackTrace();

                    }

                }

        );

        history.addActionListener(

                e -> {

                    HistoryPage.main(
                            null
                    );

                }

        );

        about.addActionListener(

                e -> {

                    AboutPage.main(
                            null
                    );

                }

        );

        frame.add(title);

        frame.add(cropBox);

        frame.add(predict);

        frame.add(history);

        frame.add(about);

        frame.add(current);

        frame.add(prediction);

        frame.add(advice);

        frame.add(profit);

        frame.setSize(
                420,
                500
        );

        frame.setLayout(
                null
        );

        frame.setVisible(
                true
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

    }

}