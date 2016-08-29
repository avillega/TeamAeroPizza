#include <bits/stdc++.h>
using namespace std;

int toInt(string Text){
 int Number;
 if ( ! (istringstream(Text) >> Number) ) Number = 0;
 return Number;
}
int main()
{
    cin.tie(NULL);
    string linea;
    int N;cin>>N;
    int caso=1;
    while(N--){
     int a,b;
     cin>>linea;
     vector<pair<int,int> > soluciones;
     for(int i=0;i<linea.size();i++){
//        a=stoi(linea.substr(0,i));
//        b=stoi(linea.substr(i));
        a=toInt(linea.substr(0,i));
        b=toInt(linea.substr(i));
        if(__gcd(a,b)==1){
           soluciones.push_back(make_pair(a,b));
        }
     }

     sort(soluciones.begin(),soluciones.end());

     cout<<"Ticket #"<<caso<<":\n";
     if(soluciones.size()==0){
        cout<<"Not relative\n";
     }else{
        cout<<soluciones[0].first<<" "<<soluciones[0].second<<'\n';
     }
     caso++;
    }
return 0;
}
