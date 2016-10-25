public class ProbTwo {
  public void one(int x, int y) {
    System.out.println(x * y);
    System.out.println(x % y);
    System.out.println(x / y);
    System.out.println(x + (y / 5));
    System.out.println(x == y);
  }

  public void two(double f, double g, double k) {
    if ((f <= g) || (f == 0.0)) {
      if (!(g > k) || false) {
        System.out.println("Case 1");
      } else {
        System.out.println("Case 2");
      }
    } else {
      System.out.println("Case 3");
    }
  }
  public void three(int b) {
    int i = 1;
    while (i <= b) {
      if (i == 2) {
        i = i + 1;
      }
      System.out.println(i);
      i = i + 1;
    }
    System.out.println(i);
  }

  public void four(Weather mon, Weather fri, double maxTemp) {
    mon = new Weather(100.00);
    fri.setHumidity(90);
    fri.setHumidity(70);
    maxTemp = 110;
  }
}
