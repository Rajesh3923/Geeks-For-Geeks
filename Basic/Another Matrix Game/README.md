<h2><a href="https://practice.geeksforgeeks.org/problems/matrix-game-20508/1?page=5&difficulty[]=-1&category[]=Strings&sortBy=submissions">Another Matrix Game</a></h2><h3>Difficulty Level : Basic</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a string S which contains only small letters. The task is to make a square matrix from string S. Then perform the following operations.<br>
1. In each column delete the characters which occur more than one.<br>
2. Column-wise sort the remaining characters in order abcd....wxyz. But print them in order azbycxdw.... &nbsp;<br>
For example, after operation 1 if the remaining characters in a column are cedjki then after sorting they become cdeijk , now when printed in the given order the output will be ckdjei. If there's no character remaining Print 0.</span></p>

<p><span style="font-size:18px"><strong>Note: </strong>Length of the Input String is always a Perfect Square.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>S = </strong>"adgkbdhlceilcfjm</span>"
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">abefgjhikm</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:18px">Matrix will be
a d g k
b d h l
c e i  l
c f  j m
In 1st column 'c', in 2nd column 'd' and in
4th column 'l' has occurred more than once.
So after deleting them and sorting the
remaining characters the matrix become </span>

<span style="font-size:18px">   a - g  k
   b - h  -
   - e i   -
   - f  j  m </span>

<span style="font-size:18px">So after operation 2 we get 'ab' from 1st
column, 'ef' from 2nd column, 'gjhi' from
3rd column and 'km' from 4th column. Appending
all of them we get the output as  "abefgjhikm".</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong></span>
<span style="font-size:18px"><strong>S = </strong>"</span><span style="font-size:20px">abcabcabc</span><span style="font-size:18px">"</span>
<span style="font-size:18px"><strong>Output:</strong></span>
<span style="font-size:18px">0</span>
<span style="font-size:18px"><strong>Explanation:</strong></span>
<span style="font-size:20px">Matrix will be
a b c
a b c
a b c
So, There will be no letters remaining
and the output will be 0.</span> </pre>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>matrixGame()</strong> which takes a String S and returns the answer.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(|S|)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints</strong><br>
1 &lt;= |S| &lt;= 10<sup>5</sup></span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Mathematical</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;