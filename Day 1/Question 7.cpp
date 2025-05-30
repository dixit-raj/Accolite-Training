#include<bits/stdc++.h>
using namespace std;
int larglen(string s){
int n=s.length();
int maxlen=0;
unordered_set<char> cset;
int left=0;
for(int right=0;right<n;right++){
    if(cset.count(s[right])==0){
        cset.insert(s[right]);
        maxlen=max(maxlen,right-left);
    }else{
        while(cset.count(s[right])){
            cset.erase(s[left]);
            left++;
        }
        cset.insert(s[right]);
    }
}
return maxlen;
}
int main(){
   string s;
   cin>>s;
   int out=larglen(s);
   cout<<out;
   return 0;
}