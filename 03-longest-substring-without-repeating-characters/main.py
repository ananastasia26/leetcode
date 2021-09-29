class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = set()
        for c in s:
            chars.update(c)
        max_diff_chars = len(chars)

        max_length_without_repeat = 0
        current_start_idx = 0
        current_idx = -1

        while current_idx < (len(s) - 1) :
            i = 0
            chars_in_substr = {}
            for current_idx in range(current_start_idx, len(s)):
                c = s[current_idx]
                if c in chars_in_substr:
                    max_length_without_repeat = i if i > max_length_without_repeat else max_length_without_repeat
                    current_start_idx = chars_in_substr[c] + 1
                    break
                else:
                    i += 1
                    chars_in_substr[c] = current_idx

            max_length_without_repeat = i if i > max_length_without_repeat else max_length_without_repeat

            if max_length_without_repeat == max_diff_chars:
                return max_length_without_repeat

        return max_length_without_repeat