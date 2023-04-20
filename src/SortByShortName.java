import java.util.Comparator;

public class SortByShortName implements Comparator<Container> {
        public int compare(Container a, Container b) {
            char shortNameLastCharA = a.getShortName().charAt(a.getShortName().length() - 1);
            char shortNameLastCharB = b.getShortName().charAt(b.getShortName().length() - 1);
            return Character.compare(shortNameLastCharA, shortNameLastCharB);

        }

}
