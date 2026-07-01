import javax.swing.*;
import java.awt.*;

public class Login {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame(
                        "Farmer Login"
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
                        "AI Farmer Login"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        JLabel nameLabel =
                new JLabel(
                        "Username"
                );

        JTextField nameField =
                new JTextField();

        JLabel passLabel =
                new JLabel(
                        "Password"
                );

        JPasswordField passField =
                new JPasswordField();

        JButton login =
                new JButton(
                        "Login"
                );

        login.setBackground(
                Color.GREEN
        );

        login.setForeground(
                Color.WHITE
        );

        title.setBounds(
                120,
                30,
                200,
                30
        );

        nameLabel.setBounds(
                50,
                100,
                100,
                30
        );

        nameField.setBounds(
                150,
                100,
                150,
                30
        );

        passLabel.setBounds(
                50,
                160,
                100,
                30
        );

        passField.setBounds(
                150,
                160,
                150,
                30
        );

        login.setBounds(
                130,
                230,
                100,
                35
        );

        login.addActionListener(

                e -> {

                    String user =

                            nameField
                                    .getText()
                                    .trim()
                                    .toLowerCase();

                    String pass =

                            String.valueOf(

                                            passField
                                                    .getPassword()

                                    )
                                    .trim();

                    System.out.println(
                            user
                    );

                    System.out.println(
                            pass
                    );

                    if(

                            user.equals(
                                    "farmer"
                            )

                                    &&

                                    pass.equals(
                                            "123"
                                    )

                    ){

                        JOptionPane.showMessageDialog(

                                null,

                                "Login Success"

                        );

                        frame.dispose();

                        Dashboard.main(
                                null
                        );

                    }

                    else{

                        JOptionPane.showMessageDialog(

                                null,

                                "Wrong Login\nUse:\nfarmer\n123"

                        );

                    }

                }

        );

        frame.add(
                title
        );

        frame.add(
                nameLabel
        );

        frame.add(
                nameField
        );

        frame.add(
                passLabel
        );

        frame.add(
                passField
        );

        frame.add(
                login
        );

        frame.setSize(
                400,
                350
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