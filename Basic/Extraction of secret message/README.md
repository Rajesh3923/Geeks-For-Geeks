<h2><a href="https://practice.geeksforgeeks.org/problems/extraction-of-secret-message0616/1?page=4&difficulty[]=-1&category[]=Strings&sortBy=submissions">Extraction of secret message</a></h2><h3>Difficulty Level : Basic</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">You are given an encoded string <strong>S</strong> of length <strong>N</strong>. The encoded string is mixed with some number of substring "<strong>LIE</strong>" and some secret message.&nbsp;You have to extract secret message from it by removing&nbsp;all the "<strong>LIE</strong>"&nbsp;substrings.<br>
For example -&nbsp;<strong>"</strong>I AM COOL<strong>"</strong> is given as <strong>"</strong>LIE<strong>I</strong>LIE<strong>AM</strong>LIELIE<strong>COOL</strong><strong>"</strong>.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong> S = "LIEILIEAMLIELIECOOL"
<strong>Output:</strong> "I AM COOL"
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong> S = "LIELIEALIEBCLIE"
<strong>Output:</strong> "A BC"</span></pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;&nbsp;</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>ExtractMessage()</strong>&nbsp;which accepts a string as input parameter and returns a string containing&nbsp;secret message.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(N)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 ≤ N ≤&nbsp;10<sup>6</sup><br>
String contains only Upper Case Letters.</span></p>
</div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Data Structures</code>&nbsp;