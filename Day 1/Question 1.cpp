#include<bits/stdc++.h>
using namespace std;
vector<int> twosum(vector<int> arr,int k){
    int left=0,right=arr.size()-1;
    while(left<right){
        if(arr[left]+arr[right]==k){
            return {left,right};
        }
        if(arr[left]+arr[right]<k){
            right--;
        }
        if(arr[left]+arr[right]>k){
            left++;
        }
    }
    return {};
}
int main(){
    int n,k;
    cin>>k;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }
    sort(arr.begin(),arr.end());
    cout<<"Sorted Array:";
    for(int i=0;i<n;i++){
        cout<<arr[i]<<" ";
    }
    vector<int> res = twosum(arr,k);
    for(int i=0;i<res.size();i++){
        cout<<res[i]<<" ";
    }
    return 0;
}
