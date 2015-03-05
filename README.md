# Kd-Trees
Algorithms, Part I, Week 5

Submission
Submission time	Thu-05-Mar 06:46:38
Raw Score	91.46 / 100.00
Feedback	See the Assessment Guide for information on how to read this report.
Assessment Summary
Compilation:  PASSED
Style:        PASSED
Findbugs:     No potential bugs found.
API:          PASSED

Correctness:  21/21 tests passed
Memory:       8/8 tests passed
Timing:       27/41 tests passed

Aggregate score: 91.46% [Correctness: 65%, Memory: 10%, Timing: 25%, Style: 0%]
Assessment Details
The following files were submitted:
----------------------------------
total 20K
-rw-r--r-- 1  12K Mar  5 14:48 KdTree.java
-rw-r--r-- 1 2.1K Mar  5 14:48 PointSET.java
-rw-r--r-- 1 2.7K Mar  5 14:48 studentSubmission.zip


******************************************************************************
*  compiling
******************************************************************************


% javac PointSET.java
*-----------------------------------------------------------
================================================================

% javac KdTree.java
*-----------------------------------------------------------
================================================================



% checkstyle *.java
*-----------------------------------------------------------
================================================================


% findbugs *.class
*-----------------------------------------------------------
================================================================


Testing the APIs of your programs.
*-----------------------------------------------------------
PointSET:

KdTree:

================================================================


******************************************************************************
*  correctness
******************************************************************************

Testing methods in PointSET
*-----------------------------------------------------------
Running 8 total tests.

Test 1: Test size() by inserting N random points
        (size may be less than N because of duplicates)
  *  100000 random points in 100000-by-100000 grid
  *  100000 random points in 10000-by-10000 grid
  *  100000 random points in 1000-by-1000 grid
  *  100000 random points in 100-by-100 grid
  *  100000 random points in 10-by-10 grid
==> passed

Test 2: Test isEmpty() by checking for N = 0, 1, and 2 points
  *  zero points
  *  one point
  *  two points
==> passed

Test 3: Insert N random points and check contains() for random query points
  *  100000 random points in 100000-by-100000 grid
  *  100000 random points in 10000-by-10000 grid
  *  100000 random points in 1000-by-1000 grid
  *  100000 random points in 100-by-100 grid
  *  100000 random points in 10-by-10 grid
==> passed

Test 4: Insert N random points and check nearest() for random query points
  *  3000 random points in 100000-by-100000 grid
  *  3000 random points in 10000-by-10000 grid
  *  3000 random points in 1000-by-1000 grid
  *  3000 random points in 100-by-100 grid
  *  3000 random points in 10-by-10 grid
==> passed

Test 5: Insert N random points and check range() for random query rectangles
  *  1000 random rectangles and points in 100000-by-100000 grid
  *  1000 random rectangles and points in 10000-by-10000 grid
  *  1000 random rectangles and points in 1000-by-1000 grid
  *  1000 random rectangles and points in 100-by-100 grid
  *  1000 random rectangles and points in 10-by-10 grid
==> passed

Test 6: Intermixed sequence of calls to isEmpty(), size(), insert(),
        contains(), range(), and nearest() with probabilities
        p1, p2, p3, p4, p5, and p6, respectively
  *  10000 calls in 10000-by-10000 grid with random points
     and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  *  10000 calls in 1000-by-1000 grid with random points
     and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  *  10000 calls in 100-by-100 grid with random points
     and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  *  10000 calls in 10-by-10 grid with random points
     and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
  *  10000 calls in 1-by-1 grid with random points
     and probabilities 0.05, 0.05, 0.3, 0.2, 0.2, 0.2
==> passed

Test 7: Intermixed sequence of calls to isEmpty(), size(), insert(),
        contains(), range(), and nearest() with probabilities
        p1, p2, p3=0, p4, p5, and p6, respectively
        (data structure with 0 points)
  *  1000 calls in 1000-by-1000 grid with random points
     and probabilities 0.5, 0.5, 0.0, 0.0, 0.0, 0.0
  *  1000 calls in 1000-by-1000 grid with random points
     and probabilities 0.2, 0.2, 0.0, 0.6, 0.0, 0.0
  *  1000 calls in 1000-by-1000 grid with random points
     and probabilities 0.2, 0.2, 0.0, 0.0, 0.6, 0.0
  *  1000 calls in 1000-by-1000 grid with random points
     and probabilities 0.2, 0.2, 0.0, 0.0, 0.0, 0.6
  *  1000 calls in 1000-by-1000 grid with random points
     and probabilities 0.2, 0.2, 0.0, 0.2, 0.2, 0.2
==> passed

Test 8: Test whether two PointSET objects can be created at the same time
==> passed


Total: 8/8 tests passed!

================================================================

Testing methods in KdTree
*-----------------------------------------------------------
Running 13 total tests.

Test 1a: Insert N distinct points and check size() after each insertion
  *  100000 random distinct points in 100000-by-100000 grid
  *  100000 random distinct points in 10000-by-10000 grid
  *  100000 random distinct points in 1000-by-1000 grid
  *  10000 random distinct points in 100-by-100 grid
  *  100 random distinct points in 10-by-10 grid
  *  1 random distinct points in 1-by-1 grid
==> passed

Test 1b: Insert N points and check size() after each insertion
  *  100000 random points in 100000-by-100000 grid
  *  100000 random points in 10000-by-10000 grid
  *  100000 random points in 1000-by-1000 grid
  *  100000 random points in 100-by-100 grid
  *  100000 random points in 10-by-10 grid
  *  10 random points in 1-by-1 grid
==> passed

Test 2: Test isEmpty() by checking that it returns the right results for 0, 1, and 2 points
  *  zero points
  *  one point
  *  two points
==> passed

Test 3a: Insert N distinct points and call contains() with random query points
  *  100000 random distinct points in 100000-by-100000 grid
  *  100000 random distinct points in 10000-by-10000 grid
  *  100000 random distinct points in 1000-by-1000 grid
  *  10000 random distinct points in 100-by-100 grid
  *  100 random distinct points in 10-by-10 grid
  *  1 random distinct points in 1-by-1 grid
==> passed

Test 3b: Insert N points and call contains() with random query points
  *  10000 random points in 1000-by-1000 grid
  *  10000 random points in 100-by-100 grid
  *  10000 random points in 10-by-10 grid
  *  10000 random points in 1-by-1 grid
==> passed

Test 4: Test whether two KdTree objects can be created at the same time
==> passed

Test 5a: Insert N distinct points and call range() for random query rectangles
  *  4000 random rectangles and 4000 distinct points in 100000-by-100000 grid
  *  4000 random rectangles and 4000 distinct points in 10000-by-10000 grid
  *  4000 random rectangles and 4000 distinct points in 1000-by-1000 grid
  *  4000 random rectangles and 4000 distinct points in 100-by-100 grid
  *  4000 random rectangles and 4000 distinct points in 10-by-10 grid
  *  4000 random rectangles and 4000 distinct points in 1-by-1 grid
==> passed

Test 5b: Insert N points and call range() for random query rectangles
  *  4000 random rectangles and 4000 random points in 10000-by-10000 grid
  *  4000 random rectangles and 4000 random points in 1000-by-1000 grid
  *  4000 random rectangles and 4000 random points in 100-by-100 grid
  *  4000 random rectangles and 4000 random points in 10-by-10 grid
  *  4000 random rectangles and 4000 random points in 1-by-1 grid
==> passed

Test 5c: Insert N points and call range() for tiny
rectangles enclosing each point.
  *  4000 tiny rectangles and 4000 points in 100000-by-100000 grid
  *  4000 tiny rectangles and 4000 points in 10000-by-10000 grid
  *  4000 tiny rectangles and 4000 points in 1000-by-1000 grid
  *  4000 tiny rectangles and 4000 points in 100-by-100 grid
  *  4000 tiny rectangles and 4000 points in 10-by-10 grid
==> passed

Test 6a: Insert N distinct points and call nearest() with random query points
  *  100000 random points in 100000-by-100000 grid
  *  100000 random points in 10000-by-10000 grid
  *  100000 random points in 1000-by-1000 grid
  *  100000 random points in 100-by-100 grid
  *  100000 random points in 10-by-10 grid
==> passed

Test 6b: Insert N points and call nearest() with random query points
  *  10000 random points in 1000-by-1000 grid
  *  10000 random points in 100-by-100 grid
  *  10000 random points in 10-by-10 grid
==> passed

Test 7: test intermixed sequence of calls to isEmpty(), size(), insert(),
        contains(), range(), and nearest() with probabilities
        p1, p2, p3, p4, p5, and p6, respectively
  *  20000 calls in 100000-by-100000 grid with probabilties 0.05, 0.05, 0.3, 0.1, 0.2, 0.2
  *  20000 calls in 10000-by-10000 grid with probabilties 0.05, 0.05, 0.3, 0.1, 0.2, 0.2
  *  20000 calls in 1000-by-1000 grid with probabilties 0.05, 0.05, 0.3, 0.1, 0.2, 0.2
  *  20000 calls in 100-by-100 grid with probabilties 0.05, 0.05, 0.3, 0.1, 0.2, 0.2
  *  20000 calls in 10-by-10 grid with probabilties 0.05, 0.05, 0.3, 0.1, 0.2, 0.2
  *  20000 calls in 1-by-1 grid with probabilties 0.05, 0.05, 0.3, 0.1, 0.2, 0.2
==> passed

Test 8: test intermixed sequence of calls to isEmpty(), size(), insert(),
        contains(), range(), and nearest() with probabilities
        p1, p2, p3 = 0, p4, p5, and p6, respectively
        (a data structure with 0 points)
  *  1000 calls in 1000-by-1000 grid with probabilties 0.5, 0.5, 0.0, 0.0, 0.0, 0.0
  *  1000 calls in 1000-by-1000 grid with probabilties 0.2, 0.2, 0.0, 0.6, 0.0, 0.0
  *  1000 calls in 1000-by-1000 grid with probabilties 0.2, 0.2, 0.0, 0.0, 0.6, 0.0
  *  1000 calls in 1000-by-1000 grid with probabilties 0.2, 0.2, 0.0, 0.0, 0.0, 0.6
  *  1000 calls in 1000-by-1000 grid with probabilties 0.2, 0.2, 0.0, 0.2, 0.2, 0.2
==> passed


Total: 13/13 tests passed!

================================================================

******************************************************************************
*  memory
******************************************************************************

Computing memory of KdTree
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a KdTree with N points (including Point2D and RectHV objects).
Maximum allowed memory is 312N + 192 bytes.

                 N       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          120                160
=> passed        2          208                288
=> passed        5          472                672
=> passed       10          912               1312
=> passed       25         2232               3232
=> passed      100         8832              12832
=> passed      400        35232              51232
=> passed      800        70432             102432
==> 8/8 tests passed

Total: 8/8 tests passed!

Student   memory (bytes) = 88.00 N + 32.00  (R^2 = 1.000)
Reference memory (bytes) = 128.00 N + 32.00  (R^2 = 1.000)
================================================================



******************************************************************************
*  timing
******************************************************************************

Timing PointSET
*-----------------------------------------------------------
Running 13 total tests.


Inserting N points into a PointSET.

               N      ops per second
----------------------------------------
=> passed   160000     788177         
=> passed   320000     634921         
=> passed   640000     667362         
=> passed  1280000     579186         
==> 4/4 tests passed

Performing contains() queries after inserting N points into a PointSET.

               N      ops per second
----------------------------------------
=> passed    10000     657895         
=> passed    20000     704225         
=> passed    40000     655022         
==> 3/3 tests passed

Performing range() queries after inserting N points into a PointSET.

               N      ops per second
----------------------------------------
=> passed    10000       2318         
=> passed    20000       1117         
=> passed    40000        509         
==> 3/3 tests passed

Performing nearest() queries after inserting N points into a PointSET.

               N      ops per second
----------------------------------------
=> passed    10000       2669         
=> passed    20000       1468         
=> passed    40000        573         
==> 3/3 tests passed

Total: 13/13 tests passed!

================================================================



Timing KdTree
*-----------------------------------------------------------
Running 28 total tests.


Inserting N points into a 2d tree. The table gives the average number of calls to methods
in RectHV and Point per call to insert().

                                                                                                Point2D
               N      ops per second       RectHV()           x()               y()             equals()
----------------------------------------------------------------------------------------------------------------
=> passed   160000     824742               0.0              22.1              21.1              21.6         
=> passed   320000     804020               0.0              22.5              21.5              22.0         
=> passed   640000     598131               0.0              24.0              23.0              23.5         
=> passed  1280000     634921               0.0              26.1              25.1              25.6         
==> 4/4 tests passed

Performing contains() queries after inserting N points into a 2d tree. The table gives
the average number of calls to methods in RectHV and Point per call to contain().

                                                                               Point2D
               N      ops per second       x()               y()               equals()
-----------------------------------------------------------------------------------------------
=> passed    10000     669643              18.5              17.5              18.0         
=> passed    20000     697674              19.7              18.7              19.2         
=> passed    40000     313808              21.8              20.8              21.3         
=> passed    80000     590551              22.0              21.0              21.5         
=> passed   160000     533808              23.2              22.2              22.7         
=> passed   320000     446429              25.0              24.0              24.5         
=> passed   640000     380711              25.7              24.7              25.2         
=> passed  1280000     300000              27.2              26.2              26.7         
==> 8/8 tests passed

Performing range() queries after inserting N points into a 2d tree. The table gives
the average number of calls to methods in RectHV and Point per call to range().

               N      ops per second       intersects()      contains()        x()               y()
---------------------------------------------------------------------------------------------------------------
=> passed    10000     307377              49.4              31.1             126.2              84.2         
=> passed    20000     251256              51.7              32.6             131.5              93.1         
=> FAILED    40000     277778              63.9              39.3             160.9             108.1   (1.1x)
=> FAILED    80000     238095              66.1              40.7             166.2             112.3   (1.1x)
=> FAILED   160000     193299              69.0              42.5             174.5             123.8   (1.2x)
=> FAILED   320000     177096              66.0              40.2             165.4             113.5   (1.1x)
=> FAILED   640000     125839              71.0              43.3             177.6             125.3   (1.3x)
=> FAILED  1280000      74925              77.7              47.0             194.1             128.1   (1.3x)
==> 2/8 tests passed

Performing nearest() queries after inserting N points into a 2d tree. The table gives
the average number of calls to methods in RectHV and Point per call to nearest().

                                         Point2D                 RectHV
               N      ops per second     distanceSquaredTo()     distanceSquaredTo()        x()               y()
------------------------------------------------------------------------------------------------------------------------
=> FAILED    10000    30120                2340.4   (3.9x)         533.9   (1.8x)         2009.4   (2.5x)   1963.3   (2.5x)
=> FAILED    20000    26156   (0.9x)       1902.5   (3.2x)         451.2   (1.5x)         1667.4   (2.1x)   1678.4   (2.1x)
=> FAILED    40000     8955   (0.3x)       5025.2   (8.4x)        1129.1   (3.8x)         4180.3   (5.2x)   4222.8   (5.3x)
=> FAILED    80000     5159   (0.2x)      10594.1  (17.7x)        2325.6   (7.8x)         8762.0  (11.0x)   8564.4  (10.7x)
=> FAILED   160000     2630   (0.1x)      20175.9  (33.6x)        4285.7  (14.3x)        16083.6  (20.1x)  15951.7  (19.9x)
=> FAILED   320000      950   (0.0x)      36609.2  (61.0x)        7748.9  (25.8x)        29092.1  (36.4x)  28844.9  (36.1x)
=> FAILED   640000      747   (0.0x)      48381.2  (80.6x)       10160.4  (33.9x)        38164.6  (47.7x)  37817.8  (47.3x)
=> FAILED  1280000      232   (0.0x)     132208.0 (220.3x)       27201.3  (90.7x)       102123.0 (127.7x) 101608.8 (127.0x)
==> 0/8 tests passed

Total: 14/28 tests passed!

================================================================



