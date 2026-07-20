/**
 * Problem: <Two Sum>
 * Link: <https://leetcode.com/problems/two-sum/description/>
 * Difficulty: Easy | Medium | Hard <Easy>
 *
 * Approach: 1.BruteForce *
 * Time: O(n2)
 * Space: O(1)
 * 2.HashMap
 * Time: O(n)
 * Space: O(n)
 */

function twoSumBF(nums, target) {
  for (let i = 0; i < nums.length; i++) {
    for (j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] == target) {
        return [i, j];
      }
    }
  }
  return [0, 0];
}

function twoSumHashMap(nums, target) {
  const map = new Map();

  for (let i = 0; i < nums.length; i++) {
    let complement;
    complement = target - nums[i];
    if ([...map.values()].includes(complement)) {
      return [
        i,
        [...map.entries()].find(([key, value]) => value === complement)?.[0],
      ];
    } else {
      map.set(i, nums[i]);
    }
  }
  console.log(map);

  return [0, 0];
}

// --- Tests ---
console.log(twoSumBF([2, 7, 11, 15], 9));
console.log(twoSumBF([3, 2, 4], 6));
console.log(twoSumBF([3, 3], 6));
console.log(twoSumHashMap([2, 7, 11, 15], 9));
console.log(twoSumHashMap([3, 2, 4], 6));
console.log(twoSumHashMap([3, 3], 6));
