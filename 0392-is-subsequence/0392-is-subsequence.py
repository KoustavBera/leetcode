class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
         s_p, t_p = 0, 0
         s_n, t_n = len(s), len(t)
         flag = 0
         while t_p < t_n and s_p < s_n:
            if t[t_p] == s[s_p]:
                t_p += 1
                s_p += 1
            else: t_p += 1
         return s_p == s_n
            
        