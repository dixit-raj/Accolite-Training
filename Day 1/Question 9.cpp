#include<bits/stdc++.h>
using namespace std;
string nextgreter(string s){
    int n=s.length();
    string ans="";
    int arr[10]={0};
    for(int i=0;i<n;i++){
        arr[s[i]-48]++;
    }
    for(int i=0;i<10;i++){
        for(int j=0;j<arr[i];j++)ans=ans+to_string(i);
    }
    return ans;
}
int main(){
    string s;
    cin>>s;
    string res=nextgreter(s);
    cout<<res;
    return 0;
}