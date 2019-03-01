import javax.swing.*;
import java.awt.*;

public class Gui extends JScrollPane implements Listener {
    private final Sorter sorter;
    private final JPanel p = new JPanel();


    Gui(Sorter s) {
        sorter = s;
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        setViewportView(p);
        setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    }


    @Override
    public void currentSongsChanged(String newSong1, String newSong2) {
        int ans = JOptionPane.showOptionDialog(null,"Pick one",
                "Pick one", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null,
                new String[] {newSong1, newSong2}, newSong1);
        sorter.questionAnswered(ans);
    }

    public void listComplete(String[] sorted) {
        for (int i = 0; i < sorted.length; i++) {
            Label l = new Label((i+1) + ": " + sorted[i]);
            p.add(l);
        }
    }
}
