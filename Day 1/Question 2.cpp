#include<bits/stdc++.h>
using namespace std;
int countsum(vector<int> arr, int k){
    unordered_map<int,int> count_map;
    int sum=0;
    int count=0;
    int n=arr.size();
    count_map[0]=1;
    for(int i=0;i<n;i++){
        sum+=arr[i];
        if(count_map.find(sum-k)!=count_map.end()){
            count+=count_map[sum-k];
        }
        count_map[sum]++;
    }
    return count;
}
int main(){
    int n,k;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    cout<<"Target: ";
    cin>>k;
    int res=countsum(arr,k);
    cout<<res;
    return 0;
}
