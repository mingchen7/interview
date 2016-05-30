public class Solution {
    public int compareVersion(String version1, String version2) {
        int idx1 = version1.indexOf('.');
        int idx2 = version2.indexOf('.');
        int prefix1 = -1;
        int prefix2 = -1;
        int suffix1 = -1;
        int suffix2 = -1;
        
        if(idx1 != -1 && idx2 != -1){
            prefix1 = Integer.parseInt(version1.substring(0,idx1));
            prefix2 = Integer.parseInt(version2.substring(0,idx2));
            if(prefix1 < prefix2) return -1;
            else if(prefix1 > prefix2) return 1;
            else{
                return compareVersion(version1.substring(idx1+1,version1.length()), version2.substring(idx2+1,version2.length()));
            }
        }
        else if(idx1 == -1 && idx2 == -1){
            prefix1 = Integer.parseInt(version1);
            prefix2 = Integer.parseInt(version2);
            if(prefix1 == prefix2) 
                return 0;
            else
                return prefix1 < prefix2? -1:1;
        }
        // one of the string does not contain '.'
        else{   
            if(idx1 != -1){
                prefix1 = Integer.parseInt(version1.substring(0,idx1));
                prefix2 = Integer.parseInt(version2);
            }
            else
            {
                prefix1 = Integer.parseInt(version1);
                prefix2 = Integer.parseInt(version2.substring(0,idx2));
            }
            
            if(prefix1 < prefix2) 
                return -1;
            else if(prefix1 == prefix2){
                if(idx1 != -1){
                    String s = version1.substring(idx1+1, version1.length());
                    if(isZero(s)) return 0;
                    else return 1;
                }
                else{
                    String s = version2.substring(idx2+1, version2.length());
                    if(isZero(s)) return 0;
                    else return -1;
                }
            }
            else{
                return 1;
            }
        }
    }
    
    public boolean isZero(String s){
        char chs[] = s.toCharArray();
        for(int i = 0; i < chs.length; i++){
            if(chs[i] != '.' && chs[i] != '0')
                return false;
        }
        return true;
    }
}


// better version
public int compareVersion(String version1, String version2) {
    String[] s1 = version1.split("\\.");
    String[] s2 = version2.split("\\.");
    for (int i = 0; i < Math.min(s1.length, s2.length); i++) {
        int n1 = Integer.parseInt(s1[i]);
        int n2 = Integer.parseInt(s2[i]);
        if (n1 > n2) {return 1;}
        if (n1 < n2) {return -1;}
    }
    if (s1.length > s2.length) {
        int p1 = s2.length;
        while (p1 < s1.length && Integer.parseInt(s1[p1]) == 0) {
            p1++;
        }
        if (p1 < s1.length) return 1;
    }
    if (s2.length > s1.length) {return -compareVersion(version2, version1);}
    return 0;
}
