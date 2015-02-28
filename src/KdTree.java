/**
 * Created by Alexey Kutepov on 28.02.15.
 */
public class KdTree {
    private Node root;
    private int size;

    // construct an empty set of points
    public KdTree() {
        this.root = null;
        this.size = 0;
    }

    // is the set empty?
    public boolean isEmpty() {
        return root == null;
    }

    // number of points in the set
    public int size() {
        return this.size;
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (root == null) {
            root = new Node(p, true);
            size++;
        } else {
            Node node = root;
            while (true) {
                if (node.getPoint().equals(p)) {
                    break;
                } else {
                    if (node.isVertical()) {
                        if (node.getPoint().x() > p.x()) {
                            if (node.getLeft() == null) {
                                node.setLeft(new Node(p, false));
                                size++;
                                break;
                            } else {
                                node = node.getLeft();
                            }
                        } else {
                            if (node.getRight() == null) {
                                node.setRight(new Node(p, false));
                                size++;
                                break;
                            } else {
                                node = node.getRight();
                            }
                        }
                    } else {
                        if (node.getPoint().y() > p.y()) {
                            if (node.getLeft() == null) {
                                node.setLeft(new Node(p, true));
                                size++;
                                break;
                            } else {
                                node = node.getLeft();
                            }
                        } else {
                            if (node.getRight() == null) {
                                node.setRight(new Node(p, true));
                                size++;
                                break;
                            } else {
                                node = node.getRight();
                            }
                        }
                    }
                }
            }
        }
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }
        return searchPoint(root, p);
    }

    private boolean searchPoint(Node node, Point2D p) {
        if (node != null) {
            if (node.getPoint().equals(p)) {
                return true;
            } else {
                if (node.isVertical()) {
                    if (node.getPoint().x() > p.x()) {
                        return searchPoint(node.getLeft(), p);
                    } else {
                        return searchPoint(node.getRight(), p);
                    }
                } else {
                    if (node.getPoint().y() > p.y()) {
                        return searchPoint(node.getLeft(), p);
                    } else {
                        return searchPoint(node.getRight(), p);
                    }
                }
            }
        } else {
            return false;
        }
    }

    // draw all points to standard draw
    public void draw() {

    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException();
        }
        return null;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        if (p == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            return null;
        }
        Node node = root;
        while (true) {
            if (node.isVertical()) {
                if (node.getPoint().x() < p.x()) {
                    if (node.getLeft() != null) {
                        if (node.getLeft().getPoint().distanceTo(p) < node.getPoint().distanceTo(p)) {
                            node = node.getLeft();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (node.getRight() != null) {
                        if (node.getRight().getPoint().distanceTo(p) < node.getPoint().distanceTo(p)) {
                            node = node.getRight();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            } else {
                if (node.getPoint().y() < p.y()) {
                    if (node.getLeft() != null) {
                        if (node.getLeft().getPoint().distanceTo(p) < node.getPoint().distanceTo(p)) {
                            node = node.getLeft();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    if (node.getRight() != null) {
                        if (node.getRight().getPoint().distanceTo(p) < node.getPoint().distanceTo(p)) {
                            node = node.getRight();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return node.getPoint();
    }



    private class Node {
        private Point2D point;
        private boolean isVertical;
        private Node left;
        private Node right;

        private Node(Point2D point, boolean isVertical) {
            this.point = point;
            this.isVertical = isVertical;
            this.left = null;
            this.right = null;
        }

        public Point2D getPoint() {
            return point;
        }

        public void setPoint(Point2D point) {
            this.point = point;
        }

        public boolean isVertical() {
            return isVertical;
        }

        public void setVertical(boolean isVertical) {
            this.isVertical = isVertical;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        KdTree kdTree = new KdTree();
        kdTree.insert(new Point2D(0.2, 0.2));
        Point2D point2D = new Point2D(0.2, 0.2);
        System.out.println(kdTree.contains(point2D));
    }
}
