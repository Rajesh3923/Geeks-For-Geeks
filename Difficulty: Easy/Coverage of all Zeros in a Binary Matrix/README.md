<h2><a href="https://www.geeksforgeeks.org/problems/coverage-of-all-zeros-in-a-binary-matrix4024/1">Coverage of all Zeros in a Binary Matrix</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="color: #273239; font-family: Nunito, sans-serif; font-size: 18px; letter-spacing: 0.162px; background-color: #ffffff;">Given a binary <strong>matrix </strong>contains <strong>0s</strong> and <strong>1s </strong>only, we need to find the sum of <strong>coverage</strong> of all zeros of the matrix where coverage for a particular 0 is defined as a total number of ones around a zero in left, right, up and bottom directions.</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><strong><span style="font-size: 14pt;">Input:</span></strong><br><span style="font-size: 14pt;">matrix = [[0, 1, 0],<br>          [0, 1, 1],</span><br><span style="font-size: 14pt;">         [0, 0, 0]]<br></span><span style="font-size: 14pt; font-family: Arial, sans-serif; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; font-variant-position: normal; vertical-align: baseline; white-space-collapse: preserve;"><strong>Output</strong>: 6<br></span><span style="font-size: 14pt; font-family: Arial, sans-serif; font-variant-numeric: normal; font-variant-east-asian: normal; font-variant-alternates: normal; font-variant-position: normal; vertical-align: baseline; white-space-collapse: preserve;"><strong>Explanation:</strong> There are a total of 6 coverage are there.</span></pre>
<p><span id="docs-internal-guid-1235b0a7-7fff-bf71-d97f-b742714a175e"></span></p>
<pre><span style="font-size: 18px;"><strong>Input: <br></strong>matrix = [[0, 1]]
<strong>Output: </strong>1<br></span><span style="font-size: 14pt;"><strong>Explanation: </strong>There are only 1 coverage.</span></pre>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity: </strong>O(n&nbsp;</span><span style="font-size: 15px;">*&nbsp;<span style="font-size: 18px;">m)<br><strong>Expected Space Complexity:&nbsp;</strong>O(1)</span></span></p>
<p><span style="font-size: 15px;"><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= matrix.size, matrix[0].size &lt;= 100</span></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Matrix</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;