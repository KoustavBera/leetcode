class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        rev = ""
        pal = ""
        for ss in s:
            if ss.isalnum():
                rev = rev + ss
                pal = ss + pal
                
        return rev == pal