#include <bits/stdc++.h>
#define endl '\n'

using namespace std;

int main(){
    int T;
    cin>>T;
    while(T--){

        int N,anterior,total;
        cin>>N;
        anterior=N;
        total=0;
        while(cin>>N && N!=0){
            if(N>2*anterior){
                total+=N-2*anterior;
            }
                anterior=N;
        }
        cout<<total<<endl;
    }
    return 0;
}
