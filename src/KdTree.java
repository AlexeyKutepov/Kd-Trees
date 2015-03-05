import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;

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
        return search(root, p);
    }

    private boolean search(Node node, Point2D p) {
        if (node != null) {
            if (node.getPoint().equals(p)) {
                return true;
            } else {
                if (node.isVertical()) {
                    if (node.getPoint().x() > p.x()) {
                        return search(node.getLeft(), p);
                    } else {
                        return search(node.getRight(), p);
                    }
                } else {
                    if (node.getPoint().y() > p.y()) {
                        return search(node.getLeft(), p);
                    } else {
                        return search(node.getRight(), p);
                    }
                }
            }
        } else {
            return false;
        }
    }

    // draw all points to standard draw
    public void draw() {
      Node node = root;
    }

    private void draw(Node node) {
      if (node == null) {
        return;
      }
      node.getPoint().draw();
      draw(node.getLeft());
      draw(node.getRight());
    }

    // all points that are inside the rectangle
    public Iterable<Point2D> range(RectHV rect) {
        if (rect == null) {
            throw new NullPointerException();
        }
        Node node = root;
        List<Point2D> point2DList = new ArrayList<Point2D>();
        range(rect, node, point2DList);
        return point2DList;
    }

    private void range(RectHV rect, Node node, List<Point2D> point2DList) {
      if (node == null) {
        return;
      }
      if (rect.contains(node.getPoint())) {
        point2DList.add(node.getPoint());
      }
      if (node.isVertical) {
        if (node.getLeft() != null) {
          double yminLeft = 0;
          double ymaxLeft = 1;
          double xminLeft;
          double xmaxLeft;
          if (node.getPoint().x() > node.getLeft().getPoint().x()) {
            xminLeft = 0;
            xmaxLeft = node.getPoint().x();
          } else {
            xminLeft = node.getPoint().x();
            xmaxLeft = 1;
          }
          RectHV rectHV = new RectHV(xminLeft, yminLeft, xmaxLeft, ymaxLeft);
          if (rect.intersects(rectHV)) {
            range(rect, node.getLeft(), point2DList);
          }
        }
        if (node.getRight() != null) {
          double yminRight = 0;
          double ymaxRight = 1;
          double xminRight;
          double xmaxRight;
          if (node.getPoint().x() > node.getRight().getPoint().x()) {
            xminRight = 0;
            xmaxRight = node.getPoint().x();
          } else {
            xminRight = node.getPoint().x();
            xmaxRight = 1;
          }
          RectHV rectHV = new RectHV(xminRight, yminRight, xmaxRight, ymaxRight);
          if (rect.intersects(rectHV)) {
            range(rect, node.getRight(), point2DList);
          }
        }
      } else {
        if (node.getLeft() != null) {
          double yminLeft;
          double ymaxLeft;
          double xminLeft = 0;
          double xmaxLeft = 1;
          if (node.getPoint().y() > node.getLeft().getPoint().y()) {
            yminLeft = 0;
            ymaxLeft = node.getPoint().y();
          } else {
            yminLeft = node.getPoint().y();
            ymaxLeft = 1;
          }
          RectHV rectHV = new RectHV(xminLeft, yminLeft, xmaxLeft, ymaxLeft);
          if (rect.intersects(rectHV)) {
            range(rect, node.getLeft(), point2DList);
          }
        }
        if (node.getRight() != null) {
          double yminRight;
          double ymaxRight;
          double xminRight = 0;
          double xmaxRight = 1;
          if (node.getPoint().y() > node.getRight().getPoint().y()) {
            yminRight = 0;
            ymaxRight = node.getPoint().y();
          } else {
            yminRight = node.getPoint().y();
            ymaxRight = 1;
          }
          RectHV rectHV = new RectHV(xminRight, yminRight, xmaxRight, ymaxRight);
          if (rect.intersects(rectHV)) {
            range(rect, node.getRight(), point2DList);
          }
        }
      }
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
       return nearest(node, p, node.getPoint());
//      return null;
    }

    private Point2D nearest(Node node, Point2D point2D, Point2D nearstPoint) {
      Point2D bestPoint;
      if (node.getPoint().distanceTo(point2D) < nearstPoint.distanceTo(point2D)) {
        bestPoint = node.getPoint();
      } else {
        bestPoint = nearstPoint;
      }
        if (node.getLeft() != null) {
          if (node.isVertical) {
            double yminLeft = 0;
            double ymaxLeft = 1;
            if (bestPoint.y() > node.getLeft().getPoint().y()) {
              ymaxLeft = bestPoint.y();
            } else {
              yminLeft = bestPoint.y();
            }
            double xminLeft;
            double xmaxLeft;
            if (node.getPoint().x() > node.getLeft().getPoint().x()) {
              xminLeft = 0;
              xmaxLeft = node.getPoint().x();
            } else {
              xminLeft = node.getPoint().x();
              xmaxLeft = 1;
            }
            RectHV rectHV = new RectHV(xminLeft, yminLeft, xmaxLeft, ymaxLeft);
            if (rectHV.distanceSquaredTo(point2D) < point2D.distanceTo(bestPoint)) {
              Point2D bufPoint = nearest(node.getLeft(), point2D, bestPoint);
              if (point2D.distanceTo(bestPoint) > point2D.distanceTo(bufPoint)) {
                bestPoint = bufPoint;
              }
            }
          } else {
            double yminLeft;
            double ymaxLeft;
            double xminLeft = 0;
            double xmaxLeft = 1;
            if (bestPoint.x() > node.getLeft().getPoint().x()) {
              xmaxLeft = bestPoint.x();
            } else {
              xminLeft = bestPoint.x();
            }
            if (node.getPoint().y() > node.getLeft().getPoint().y()) {
              yminLeft = 0;
              ymaxLeft = node.getPoint().y();
            } else {
              yminLeft = node.getPoint().y();
              ymaxLeft = 1;
            }
            RectHV rectHV = new RectHV(xminLeft, yminLeft, xmaxLeft, ymaxLeft);
            if (rectHV.distanceSquaredTo(point2D) < point2D.distanceTo(bestPoint)) {
              Point2D bufPoint = nearest(node.getLeft(), point2D, bestPoint);
              if (point2D.distanceTo(bestPoint) > point2D.distanceTo(bufPoint)) {
                bestPoint = bufPoint;
              }
            }
          }
        }
        if (node.getRight() != null) {
          if (node.isVertical) {
            double ymaxRight = 1;
            double yminRight = 0;
            if (bestPoint.y() > node.getRight().getPoint().y()) {
              ymaxRight = bestPoint.y();
            } else {
              yminRight = bestPoint.y();
            }
            double xminRight;
            double xmaxRight;
            if (node.getPoint().x() > node.getRight().getPoint().x()) {
              xminRight = 0;
              xmaxRight = node.getPoint().x();
            } else {
              xminRight = node.getPoint().x();
              xmaxRight = 1;
            }
            RectHV rectHV = new RectHV(xminRight, yminRight, xmaxRight, ymaxRight);
            if (rectHV.distanceSquaredTo(point2D) < point2D.distanceTo(bestPoint)) {
              Point2D bufPoint = nearest(node.getRight(), point2D, bestPoint);
              if (point2D.distanceTo(bestPoint) > point2D.distanceTo(bufPoint)) {
                bestPoint = bufPoint;
              }
            }
          } else {
            double yminRight;
            double ymaxRight;
            double xminRight = 0;
            double xmaxRight = 1;
            if (bestPoint.x() > node.getRight().getPoint().x()) {
              xmaxRight = bestPoint.x();
            } else {
              xminRight = bestPoint.x();
            }
            if (node.getPoint().y() > node.getRight().getPoint().y()) {
              yminRight = 0;
              ymaxRight = node.getPoint().y();
            } else {
              yminRight = node.getPoint().y();
              ymaxRight = 1;
            }
            RectHV rectHV = new RectHV(xminRight, yminRight, xmaxRight, ymaxRight);
            if (rectHV.distanceSquaredTo(point2D) < point2D.distanceTo(bestPoint)) {
              Point2D bufPoint = nearest(node.getRight(), point2D, bestPoint);
              if (point2D.distanceTo(bestPoint) > point2D.distanceTo(bufPoint)) {
                bestPoint = bufPoint;
              }
            }
          }
        }
        return bestPoint;
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
