import GUI.AltaUsurious;

import javax.swing.*;




public class Main {
    public static void main(String[] args)
    {


        SwingUtilities.invokeLater(() -> {
            AltaUsurious view = new AltaUsurious();
            view.setVisible(true);
        });
    }

    }
