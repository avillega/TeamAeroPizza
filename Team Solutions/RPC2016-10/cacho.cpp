#include <bits/stdc++.h>

using namespace std;

int main()
{
 int n;cin>>n;
 while(n--){
 bool puede=true;
 int aux;cin>>aux;
 int aux2;
    for(int i=0;i<4;i++){
            cin>>aux2;
        if(aux+1 !=aux2){
            puede=false;
         }
        aux=aux2;
    }

    cout<<(puede?"Y":"N")<<'\n';
 }
 return 0;
}
