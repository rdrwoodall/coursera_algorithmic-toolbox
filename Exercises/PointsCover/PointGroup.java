import java.util.ArrayList;
import java.util.List;

public class PointGroup {
    // Assumes sorted point list as input
    public static List<List<Double>> groupPoints(double[] points) {
        List<List<Double>> groups = new ArrayList<>();

        if (points.length < 1) { // return empty groups structure
            return groups;
        } else if (points.length == 1) { // return single point in group format
            List<Double> group = new ArrayList<>();
            group.add(points[0]);
            groups.add(group);

            return groups;
        }

        int i = 0;
        double left;
        double right;

        while (i < points.length) { // initialize new group
            List<Double> group = new ArrayList<>();

            left = points[i];
            right = left + 1;
            group.add(points[i++]);

            while ((i < points.length) && (points[i] <= right)) {
                group.add(points[i]);
                i++;
            }

            // add group to groups
            groups.add(group);
        }

        return groups;
    }
}

class PointGroupTester {
    public static void main(String[] args) {
        double[] sample = {5, 5.2, 5.8, 6, 7};

        List<List<Double>> groups = PointGroup.groupPoints(sample);

        System.out.println("Number of groups: " + groups.size());
    }
}
