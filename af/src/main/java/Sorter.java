import javax.swing.*;

class Sorter {
    private String[] songs = new String[] {
    "Antichrist Television Blues",
    "Abraham’s Daughter",
    "Afterlife",
    "Apocrypha",
    "Awful Sound (Oh Eurydice)",
    "Black Mirror",
    "Black Wave/Bad Vibrations",
    "Broken Window",
    "Chemistry",
    "City with No Children",
    "Creature Comfort",
    "Crown Of Love",
    "Culture War",
    "Deep Blue",
    "Electric Blue",
    "Empty Room",
    "Everything Now",
    "Everything_Now (continued)",
    "Everything Now (continued)",
    "Flashbulb Eyes",
    "Good God Damn",
    "Haïti",
    "Half Light I",
    "Half Light II (No Celebration)",
    "Headlights Look Like Diamonds",
    "Here Comes the Night Time",
    "Here Comes the Night Time II",
    "I’m Sleeping In A Submarine",
    "I Give You Power [feat. Mavis Staples]",
    "In The Backseat",
    "Infinite Content",
    "Infinite_Content",
    "Intervention",
    "It’s Never Over (Hey Orpheus)",
    "Joan of Arc",
    "Keep The Car Running",
    "Modern Man",
    "Month of May",
    "My Body Is A Cage",
    "My Heart Is An Apple",
    "Neighborhood #1 (Tunnels)",
    "Neighborhood #2 (Laïka)",
    "Neighborhood #3 (Power Out)",
    "Neighborhood #4 (7 Kettles)",
    "Neon Bible",
    "No Cars Go",
    "Normal Person",
    "Ocean Of Noise",
    "Old Flame",
    "Peter Pan",
    "Porno",
    "Put Your Money On Me",
    "Ready to Start",
    "Rebellion (Lies)",
    "Reflektor",
    "Rococo",
    "Signs of Life",
    "Speaking in Tongues",
    "Sprawl I (Flatland)",
    "Sprawl II (Mountains Beyond Mountains)",
    "Suburban War",
    "Supersymmetry",
    "Surf City Eastern Bloc",
    "The Suburbs",
    "The Suburbs (Continued)",
    "The Well And The Lighthouse",
    "The Woodland National Anthem",
    "Une Année Sans Lumière",
    "Vampire Forest Fire",
    "Wake Up",
    "Wasted Hours",
    "We Exist",
    "We Used to Wait",
    "Windowsill",
    "You Already Know",
    "We Don't Deserve Love",
    "Women of a Certain Age",
    "Soft Power",
    "Get Right",
    "Crucified Again"};
    private String currentSong1 = "";
    private String currentSong2 = "";
    private String picked = "";
    private Listener listener;

    void setListener(Listener l) {listener = l;}

    void questionAnswered(int i) {
        if (i == JOptionPane.YES_OPTION) {
            picked = currentSong1;
        }
        if (i == JOptionPane.NO_OPTION) {
            picked = currentSong2;
        }
    }

    private String[] merge(String[] a1, String[] a2) {
        if (a1.length == 0) return a2;
        if (a2.length == 0) return a1;
        String[] new_arr = new String[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int curr = 0;
        while (i < a1.length && j < a2.length) {
            currentSong1 = a1[i];
            currentSong2 = a2[j];
            listener.currentSongsChanged(currentSong1, currentSong2);
            new_arr[curr] = picked;
            if (picked.equals(currentSong1)) {
                i++;
            }
            else if (picked.equals(currentSong2)) {
                j++;
            }
            curr++;
        }
        while (i < a1.length) {
            new_arr[curr] = a1[i];
            i++;
            curr++;
        }
        while (j < a2.length) {
            new_arr[curr] = a2[j];
            j++;
            curr++;
        }
        return new_arr;
    }

    private String[] merge_sort(String[] arr) {
        if (arr.length <= 1) {return arr;}
        else {
            int half_length = arr.length/2;
            String[] a = new String[half_length];
            String[] b = new String[arr.length - half_length];
            int i = 0;
            while (i < half_length) {
                a[i] = arr[i];
                i++;
            }
            while (i < arr.length) {
                b[i-half_length] = arr[i];
                i++;
            }
            String[] sort_left = merge_sort(a);
            String[] sort_right = merge_sort(b);
            return merge(sort_left, sort_right);
        }
    }

    void sortSongs() {
        String[] sorted = merge_sort(songs);
        listener.listComplete(sorted);
    }
}
