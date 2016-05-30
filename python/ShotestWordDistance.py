def shortestDistance(self, words, word1, word2):
        last, min_dist = -1, len(words)
        for i in xrange(len(words)):
            if words[i] in [word1, word2]:
                if last != -1 and words[last] != words[i]: # if current matched word is different from last matched word
                    min_dist = min(min_dist, i-last)
                last = i
        return min_dist
