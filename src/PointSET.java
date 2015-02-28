import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Alexey Kutepov on 28.02.15.
 */
public class PointSET {
    private TreeSet<Point2D> tree;

    // construct an empty set of points
    public PointSET() {
        tree = new TreeSet<Point2D>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    // number of points in the set
    public int size() {
        return tree.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }
        tree.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }
        return tree.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        for (Point2D point2D : tree) {
            point2D.draw();
        }
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException();
        }
        ArrayList<Point2D> list = new ArrayList<Point2D>();
        for (Point2D point2D : tree) {
            if (rect.contains(point2D)) {
                list.add(point2D);
            }
        }
        return list;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }
        Point2D point2DNearst = null;
        for (Point2D point2D : tree) {
            if (point2DNearst == null) {
                point2DNearst = point2D;
            } else {
                if (p.distanceTo(point2D) < p.distanceTo(point2DNearst)) {
                    point2DNearst = point2D;
                }
            }
        }

        return point2DNearst;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {

    }
}
