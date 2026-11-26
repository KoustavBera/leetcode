class Solution:
    def canAliceWin(self, n: int) -> bool:
        if n < 10:
            return False
        elif n==10:
            return True
        else:
            stones_to_remove = 10
            alice_turn = True
            while n>=stones_to_remove:
                n-=stones_to_remove
                stones_to_remove-=1
                alice_turn = not alice_turn

            return not alice_turn