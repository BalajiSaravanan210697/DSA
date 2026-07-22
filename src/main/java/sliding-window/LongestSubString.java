/*Problem Name: Longest substring 
- Problem Link :https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
- Difficulty: Medium
- Date: 21-07-2026

1.Did I understand the problem? Yes/No - yes

2.Do I know the constraints? Yes/No - Yes
Constraints:
-0 <= s.length <= 5 * 104 -- length starts from 0 to 500000
-s consists of English letters, digits, symbols and spaces. 

3.Frame the Test Data - Positive,Edge,Negative - DONE/NOT DONE - DONE

4.Do I already know how to solve it? Yes/No - Yes

Possible approaches:
1.Brute Force using nested for loop and Set TC - 0(n2) SC - O(n)
2.Sliding window using the Set and Two pointers
3.Hash Map using Hashing with two pointers

5.Write Pseudocode & dry run it with test data - DONE/NOT DONE -DONE
Pseudocode:

  if string length is less than or equal to 0 then return 1
  Initialise a set (HashSet)                                        s="abcdabc"  s="ccccdddc"
  Initialise the current max to 1 max to 0 
   for i starts with 0 to length -1 of a string                       a             c
    add i to set                                                   [a               [c
    for j starts with i+1 till length of a string                   b c d a   
	
	if set contains j                                               No,No,No,Yes
	  then break                                                    
	  make set as empty                                             []
	  if current max is greater than max then max = current max      4>0 max = 4
	 
    else                                                            
      add the value to the set 	                                   [a,b,C,d]   
      increment currentmax                                         2 3 4

     return the max	  

6.Write the Code in Notepad++ & dry run it with test data - DONE/NOT DONE - DONE
 
public int subString(String s){                                 //abcabcbb
	 
	   if(s.length()==0) return 1;
	 
	   Set<Characters> inputSet = new HashSet<Characters>();
 
       int currentMax = 1, Max = 0;
       
         for (int i=0; i<s.length()-1;i++){                  a
		  inputSet.add(s.charAt(i));                        [a  
		   for(int j=i+1; j<s.length();j++){                 b
		     if(inputSet.contains(s.charAt(j))){             false
			  if (currentMax>Max) Max = currentMax; 
			    inputSet.clear();
				currentMax = 1;
				break;		 	 
			 }
		   }
		   else{
		   inputSet.add(s.charAt(j));                        [a,b
		   currentMax++;                                      2
		   }
		 } 	   
	 
	 return Max;
	 }

7.Run the Code in Editor - Executed - Success/Failure - Failure

8.Debug the code and resolve the failures - DONE/NOT DONE/NOT REQUIRED - DONE Fixed Failures

9.try with Optimized solution - DONE/NOT DONE - NOT DONE

10.Review the Learning from this Problem 

What pattern did I learn?
BruteForce Approach

What mistake did I make?
Syntax and utils packages to added for set 

What should I remember for next time?
import utils for set and declaration
*/
import java.util.Set;
import java.util.HashSet;

public class LongestSubString {

    public static int longestSubString(String s) {

        if (s.isEmpty()) return 0;
        if (s.length() <= 1) return 1;

        int currentMax = 1, finalMax = 0;
        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));

            for (int j = i + 1; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    if (currentMax > finalMax) finalMax = currentMax;
                    charSet.clear();
                    currentMax = 1;
                    break;
                } else {
                    charSet.add(s.charAt(j));
                    currentMax++;
                }
            }
        }

        return finalMax;
    }

    public static void main(String[] args) {
        int maxSubstringValue = longestSubString("abcabc");
        System.out.println("The max substring value is: " + maxSubstringValue);
    }
}
