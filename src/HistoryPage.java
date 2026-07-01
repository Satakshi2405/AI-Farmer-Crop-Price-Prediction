import javax.swing.*;
import java.io.*;

public class HistoryPage {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame(
                        "Prediction History"
                );

        JTextArea area =
                new JTextArea();

        JScrollPane scroll =
                new JScrollPane(
                        area
                );

        scroll.setBounds(
                20,
                20,
                340,
                300
        );

        try{

            BufferedReader br =
                    new BufferedReader(

                            new FileReader(
                                    "history.csv"
                            )

                    );

            String line;

            while(

                    (
                            line=
                                    br.readLine()
                    )!=null

            ){

                area.append(

                        line

                                +

                                "\n"

                );

            }

            br.close();

        }

        catch(
                Exception e
        ){

            e.printStackTrace();

        }

        frame.add(
                scroll
        );

        frame.setSize(
                400,
                400
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