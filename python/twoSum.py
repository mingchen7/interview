def __init__(self):
        self.__Container__ = []
        """
        initialize your data structure here
        """
        

    def add(self, number):
        if number is not None:
            self.__Container__.append(number)
            
        """
        Add the number to an internal data structure.
        :rtype: nothing
        """
        

    def find(self, value):
        length = len(self.__Container__)
        for i in range(length):
            numA = self.__Container__[i]
            for j in range(i+1,length):
                numB = self.__Container__[j]
                if(numA + numB == value):
                    return True
                    
        return False