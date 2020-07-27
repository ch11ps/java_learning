package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.Point;

@Test
public class PointTests {

  public void testDistanceP1P2() {
    Point p1 = new Point(2, 4);
    Point p2 = new Point(4, 16);

    Assert.assertEquals(p1.distance(p2), 12.165525060596439);
  }

  public void testDistanceP3P4() {
    Point p3 = new Point(10, 72);
    Point p4 = new Point(25, 11);

    Assert.assertEquals(p3.distance(p4), 62.81719509815764);
  }

  public void testDistanceP1P3() {
    Point p1 = new Point(2, 4);
    Point p3 = new Point(10, 72);

    Assert.assertEquals(p1.distance(p3), 68.46897107449476);
  }

  public void testDistanceP2P4() {
    Point p2 = new Point(4, 16);
    Point p4 = new Point(25, 11);

    Assert.assertEquals(p2.distance(p4), 21.587033144922902);
  }
}
