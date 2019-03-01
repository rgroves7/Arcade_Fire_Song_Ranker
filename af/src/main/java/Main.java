import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> {
            showBoard();
        });
    }

    private static void showBoard() {
        Sorter sorter = new Sorter();
        Gui gui = new Gui(sorter);
        sorter.setListener(gui);
        sorter.sortSongs();
        JFrame frame = new JFrame();
        frame.setContentPane(gui);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }
}
