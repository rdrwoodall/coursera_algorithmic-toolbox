import java.util.ArrayList;
import java.util.List;

/*

Problem Description

Let's consider the following situation. You've invited a lot of children to a 
celebration party, and you want to entertain them and also teach them something 
in the process. You are going to hire a few teachers and divide the children into 
groups and assign a teacher to each of the groups this teacher will work with 
this group through the whole party. 

But you know that for a teacher to work with a group of children efficiently,
children of that group should be of relatively the same age. More specifically the age 
of any two children in the same group should differ by at most, one year. 

Also, you want to minimize the number of groups. Because you want to hire fewer teachers, 
and spend the money on presents and other kinds of entertainment for the children. 
So, you need to divide children into the minimum possible number of groups. 
Such that the age of any two children in any group differs by at most one year. 

*/

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
