import javax.swing.*;

public class AboutPage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame(
                        "About Project"
                );

        JTextArea area =
                new JTextArea();

        area.setText(

                "AI Powered Farmer Crop Market Price Prediction\n\n"

                        +

                        "Features:\n"

                        +

                        "1. Multi Crop Prediction\n"

                        +

                        "2. AI Price Forecasting\n"

                        +

                        "3. Sell / Wait Advice\n"

                        +

                        "4. History Tracking\n"

                        +

                        "5. Graph Analysis\n\n"

                        +

                        "Future Scope:\n"

                        +

                        "- Weather API\n"

                        +

                        "- Market Price API\n"

                        +

                        "- Hindi Voice Assistant\n"

                        +

                        "- Mobile App"

        );

        area.setEditable(
                false
        );

        frame.add(
                area
        );

        frame.setSize(
                400,
                350
        );

        frame.setVisible(
                true
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

    }

}