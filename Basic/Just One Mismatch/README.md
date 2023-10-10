<h2><a href="https://practice.geeksforgeeks.org/problems/just-one-mismatch1714/1?page=4&difficulty[]=-1&category[]=Strings&sortBy=submissions">Just One Mismatch</a></h2><h3>Difficulty Level : Basic</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given a string S and array of strings, find whether the array contains a string with one character different from the given string.</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input :</strong>
N = 4
arr[] = {"bana","apple","banaba","bonanzo"}
S = "banana"
<strong>Output :
</strong>True
<strong>Explanation: 
</strong>banana and banaba has only one character 
different.</span></pre>

<p><strong><span style="font-size:18px">Example 2:</span></strong></p>

<pre><strong><span style="font-size:18px">Input:
</span></strong><span style="font-size:18px">N = 4
arr[] = {"bana","apple","banaba","bonanzo"}</span>
<span style="font-size:18px">S = "apple"
<strong>Output :</strong></span>
<span style="font-size:18px">False
<strong>Explanation: 
</strong>No string in arr differ by one 
character from S 
</span></pre>

<p>&nbsp;</p>

<p>&nbsp;<span style="font-size:18px"><strong>Your Task:&nbsp; </strong><br>
You don't need to read input or print anything. Your task is to complete the function <strong>isStringExist()</strong> which takes the string array arr[], its size N<strong> </strong>and a string S<strong> </strong>as input parameters and returns "True" if a string exists in arr which has only one character different from S else return "False".</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(N*Length of the string S)</span></p>

<p><span style="font-size:18px"><strong>Expected Space Complexity:</strong> O(1)</span></p>

<p>&nbsp;</p>

<p><span style="font-size:18px"><strong>Constraints :</strong><br>
1 ≤ N ≤ 100<br>
1 ≤| arr[i] | ≤ 1000</span><br>
<span style="font-size:18px">1 ≤| S | ≤ 1000</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Data Structures</code>&nbsp;